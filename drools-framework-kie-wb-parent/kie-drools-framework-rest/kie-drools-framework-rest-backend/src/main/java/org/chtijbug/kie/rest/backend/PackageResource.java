package org.chtijbug.kie.rest.backend;

import org.drools.guvnor.server.jaxrs.jaxb.Asset;
import org.drools.guvnor.server.jaxrs.jaxb.Package;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.common.services.project.service.ProjectService;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.organizationalunit.OrganizationalUnitService;
import org.guvnor.structure.repositories.Repository;
import org.guvnor.structure.repositories.RepositoryService;
import org.kie.workbench.common.services.shared.project.KieProjectService;
import org.slf4j.LoggerFactory;
import org.uberfire.backend.server.util.Paths;
import org.uberfire.io.IOService;
import org.uberfire.java.nio.base.options.CommentedOption;
import org.uberfire.java.nio.file.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.util.*;

@Path("/packages")
@Named
@ApplicationScoped
public class PackageResource {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PackageResource.class);

    @Context
    protected UriInfo uriInfo;

    @Inject
    @Named("ioStrategy")
    private IOService ioService;

    @Inject
    private OrganizationalUnitService organizationalUnitService;

    @Inject
    private RepositoryService repositoryService;

    @Inject
    private ProjectService<? extends Project> projectService;

    @Inject
    private KieProjectService kieProjectService;

    private RestTypeDefinition dotFileFilter = new RestTypeDefinition();

    @GET
    @Path("{organizationalUnitName}/{repositoryName}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Package> getPackagesAsJAXB(@PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName) {
        OrganizationalUnit organizationalUnit = organizationalUnitService.getOrganizationalUnit(organizationalUnitName);
        Collection<Repository> repositories = organizationalUnit.getRepositories();
        for (Repository repository : repositories) {
            if (repository.getAlias().equals(repositoryName)) {
                String branch = repository.getDefaultBranch();
                Set<Project> projects = projectService.getProjects(repository, branch);
                Collection<Package> packages = new ArrayList<>();
                for (Project project : projects) {
                    Package aPackage = new Package();
                    aPackage.setTitle(project.getProjectName());
                    aPackage.setGroupID(project.getPom().getGav().getGroupId());
                    aPackage.setArtifactID(project.getPom().getGav().getArtifactId());
                    aPackage.setVersion(project.getPom().getGav().getVersion());
                    aPackage.getModules().addAll(project.getModules());
                    packages.add(aPackage);
                }
                return packages;
            }
        }
        return null;
    }

    @GET
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/assets")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Asset> getAssetsAsJAXB(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName,
            @QueryParam("format") List<String> formats) {
        try {
            List<Asset> contentList = new LinkedList<>();
            Project project = getProject(organizationalUnitName, repositoryName, packageName);

            if (project != null && project.getProjectName().equals(packageName)) {

                org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
                org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
                DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);
                getContent(directoryStream, contentList);
            }


            return contentList;
        } catch (RuntimeException e) {
            throw new WebApplicationException(e);
        }
    }

    private Project getProject(String organizationalUnitName, String repositoryName, String packageName) {
        OrganizationalUnit organizationalUnit = organizationalUnitService.getOrganizationalUnit(organizationalUnitName);
        Collection<Repository> repositories = organizationalUnit.getRepositories();
        for (Repository repository : repositories) {
            if (repository.getAlias().equals(repositoryName)) {
                String branch = repository.getDefaultBranch();
                Set<Project> projects = projectService.getProjects(repository, branch);
                for (Project project : projects) {
                    if (project.getProjectName().equals(packageName)) {
                        return project;
                    }
                }
            }
        }
        return null;
    }


    private void  getContentSource(DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream, Asset asset,List<org.uberfire.java.nio.file.Path> pathLinkedList) {
        for (org.uberfire.java.nio.file.Path elementPath : directoryStream) {
            if (org.uberfire.java.nio.file.Files.isDirectory(elementPath)) {
                DirectoryStream<org.uberfire.java.nio.file.Path> adirectoryStream = ioService.newDirectoryStream(elementPath);
                getContentSource(adirectoryStream, asset,pathLinkedList);
            } else {
                if (dotFileFilter.accept(Paths.convert(elementPath))) {
                    Map<String, Object> listAttributes = ioService.readAttributes(elementPath);
                    if (asset.getTitle().equals(elementPath.getFileName().toString())){
                        pathLinkedList.add(elementPath);
                    }
                }
            }
        }
    }
    private void getContent(DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream, Collection<Asset> contentList) {
        for (org.uberfire.java.nio.file.Path elementPath : directoryStream) {
            if (org.uberfire.java.nio.file.Files.isDirectory(elementPath)) {
                DirectoryStream<org.uberfire.java.nio.file.Path> adirectoryStream = ioService.newDirectoryStream(elementPath);
                getContent(adirectoryStream, contentList);
            } else {
                if (dotFileFilter.accept(Paths.convert(elementPath))) {
                    Map<String, Object> listAttributes = ioService.readAttributes(elementPath);
                    Asset asset = new Asset();
                    asset.setTitle(elementPath.getFileName().toString());
                    asset.setDirectory(elementPath.getParent().toString());
                    asset.setRefLink(elementPath.getFileName().toUri());
                    contentList.add(asset);
                }
            }
        }
    }

    private org.uberfire.java.nio.file.Path getFileElementPath(DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream, String assetName) {
        for (org.uberfire.java.nio.file.Path elementPath : directoryStream) {
            if (org.uberfire.java.nio.file.Files.isDirectory(elementPath)) {
                DirectoryStream<org.uberfire.java.nio.file.Path> adirectoryStream = ioService.newDirectoryStream(elementPath);
                org.uberfire.java.nio.file.Path foundElementPath = getFileElementPath(adirectoryStream, assetName);
                if (foundElementPath != null) {
                    return foundElementPath;
                }
            } else {
                if (dotFileFilter.accept(Paths.convert(elementPath))) {
                    return elementPath;
                }
            }
        }
        return null;
    }

    private org.uberfire.java.nio.file.Path getDirectoryElementPath(DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream, String assetName) {
        for (org.uberfire.java.nio.file.Path elementPath : directoryStream) {
            if (org.uberfire.java.nio.file.Files.isDirectory(elementPath)) {
                DirectoryStream<org.uberfire.java.nio.file.Path> adirectoryStream = ioService.newDirectoryStream(elementPath);
                if (elementPath.getFileName().toString().equals(assetName)) {
                    return elementPath;
                }
                org.uberfire.java.nio.file.Path foundElementPath = getDirectoryElementPath(adirectoryStream, assetName);
                if (foundElementPath != null) {
                    return foundElementPath;
                }
            }
        }
        return null;
    }

    @GET
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/assets/{assetName}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Asset> getAssetAsJaxB(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName, @PathParam("assetName") String assetName) {
        List<Asset> resultList = new LinkedList<>();
        try {
            Project project = getProject(organizationalUnitName, repositoryName, packageName);
            if (project != null && project.getProjectName().equals(packageName)) {
                List<Asset> contentList = new LinkedList<>();
                org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
                org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
                DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);
                getContent(directoryStream, contentList);
                for (Asset asset : contentList) {
                    if (asset.getTitle().equals(assetName)) {
                        resultList.add(asset);
                    }
                }
            }
            return resultList;
        } catch (RuntimeException e) {
            throw new WebApplicationException(e);
        }

    }

    @GET
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/assets/{assetName}/source")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getAssetSource(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName, @PathParam("assetName") String assetName) {
        List<Asset> resultList = new LinkedList<>();
        String result="";
        try {
            Project project = getProject(organizationalUnitName, repositoryName, packageName);
            if (project != null && project.getProjectName().equals(packageName)) {
                List<Asset> contentList = new LinkedList<>();
                List<org.uberfire.java.nio.file.Path> pathLinkedList = new LinkedList<>();
                org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
                org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
                DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);
                getContent(directoryStream, contentList);
                for (Asset asset : contentList) {
                    if (asset.getTitle().equals(assetName)) {
                        resultList.add(asset);
                        DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream2 = ioService.newDirectoryStream(goodRootPath);
                         getContentSource(directoryStream2, asset,pathLinkedList);
                        if (pathLinkedList.size()==1) {
                            result = ioService.readAllString(pathLinkedList.get(0));
                        }
                    }
                }
            }
            return result;
        } catch (RuntimeException e) {
            throw new WebApplicationException(e);
        }

    }

    @PUT
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/asset/{assetName}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateAssetFromJAXB(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName,
            @PathParam("assetName") String assetName, Asset asset) {
        try {
            Project project = getProject(organizationalUnitName, repositoryName, packageName);

            if (project != null && project.getProjectName().equals(packageName)) {
                org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
                org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
                DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);
                org.uberfire.java.nio.file.Path elementToUpdate = getFileElementPath(directoryStream, assetName);
                //What To DO ?
            }
        } catch (RuntimeException e) {
            throw new WebApplicationException(e);
        }
    }

    @POST
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/newAsset")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Asset createAssetFromSourceAndJAXB(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName, Asset asset) {
        try {
            Project project = getProject(organizationalUnitName, repositoryName, packageName);
            org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
            org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
            DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);

            org.uberfire.java.nio.file.Path directoryWhereCreateAsset = getDirectoryElementPath(directoryStream, asset.getTitle());
            org.uberfire.backend.vfs.Path newDirectoryPath = Paths.convert(directoryWhereCreateAsset);
            final org.uberfire.java.nio.file.Path nioPath = Paths.convert(newDirectoryPath).resolve(asset.getTitle());
            if (ioService.exists(nioPath)) {
                throw new FileAlreadyExistsException(nioPath.toString());
            }
            CommentedOption commentedOption = new CommentedOption(asset.getComment());
            ioService.write(nioPath, asset.getContent().getBytes(), commentedOption);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
        return null;
    }

    @PUT
    @Path("{organizationalUnitName}/{repositoryName}/{packageName}/asset/{assetName}/source")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.WILDCARD})
    public void updateAssetSource(
            @PathParam("organizationalUnitName") String organizationalUnitName, @PathParam("repositoryName") String repositoryName,
            @PathParam("packageName") String packageName, @PathParam("assetName") String assetName, String content) {
        try {
            Project project = getProject(organizationalUnitName, repositoryName, packageName);
            org.uberfire.backend.vfs.Path rootPath = project.getRootPath();
            org.uberfire.java.nio.file.Path goodRootPath = Paths.convert(rootPath);
            DirectoryStream<org.uberfire.java.nio.file.Path> directoryStream = ioService.newDirectoryStream(goodRootPath);

            org.uberfire.java.nio.file.Path directoryWhereCreateAsset = getDirectoryElementPath(directoryStream, assetName);
            org.uberfire.backend.vfs.Path newDirectoryPath = Paths.convert(directoryWhereCreateAsset);
            final org.uberfire.java.nio.file.Path nioPath = Paths.convert(newDirectoryPath).resolve(assetName);
            if (ioService.exists(nioPath)) {
                throw new NoSuchFileException(nioPath.toString());
            }
            ioService.write(nioPath, content.getBytes(), null);

        } catch (Exception e) {
            throw new WebApplicationException(e);
        }

    }

}
