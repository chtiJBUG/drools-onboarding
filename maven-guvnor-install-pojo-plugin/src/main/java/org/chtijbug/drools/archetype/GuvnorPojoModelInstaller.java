/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.drools.archetype;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.chtijbug.drools.guvnor.rest.ChtijbugDroolsRestException;
import org.chtijbug.drools.guvnor.rest.GuvnorRepositoryConnector;
import org.chtijbug.drools.guvnor.rest.RestRepositoryConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.aether.RepositorySystem;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.installation.InstallRequest;
import org.sonatype.aether.installation.InstallationException;
import org.sonatype.aether.util.artifact.DefaultArtifact;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: smangot
 * Date: 20/12/12
 * Time: 15:28
 *
 * @goal install-file
 * @phase clean
 *
 */
public class GuvnorPojoModelInstaller extends AbstractMojo {
    /** class Logger */
    private static Logger logger = LoggerFactory.getLogger(GuvnorPojoModelInstaller.class);
    /**
     * @parameter expression="${host}"
     */
    private String host;
    /**
     * @parameter expression="${app}"
     */
    private String app;

    private String organizationalUnitName;

    private String repositoryName;


    /**
     * @parameter expression="${pkg}"
     */
    private String pkg;
    /**
     * @parameter expression="${version}"
     */
    private String version;
    /**
     * @parameter  expression="${username}"
     */
    private String username;
    /**
     * @parameter expression="${password}"
     */
    private String password;
    /**
     * @parameter expression="${artifactGroupId}"
     */
    private String artifactGroupId;
    /**
     * @parameter expression="${artifactId}"
     */
    private String artifactId;
    /**
     * The entry point to Aether, i.e. the component doing all the work.
     *
     * @component
     */
    private RepositorySystem repoSystem;
    /**
     * The current repository/network configuration of Maven.
     *
     * @parameter default-value="${repositorySystemSession}"
     * @readonly
     */
    private RepositorySystemSession repoSession;

    public GuvnorPojoModelInstaller() {
    }

    /**
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        logger.debug(" >> execute");
        try {
            RestRepositoryConnector repositoryConnector = new GuvnorRepositoryConnector(host, app, organizationalUnitName,repositoryName,pkg, username, password);
            //____ Download the POJO Model from Guvnor instance
            InputStream inputStream = null;
            try {
                inputStream = repositoryConnector.getPojoModel();
            } catch (ChtijbugDroolsRestException e) {
                logger.error("Error occurred while creating he file from the Pojo Model", e);
            }
            //____ First create TEMP file with the downloaded content
            File tempFile = File.createTempFile(artifactId, ".jar");
            FileOutputStream outputStream = FileUtils.openOutputStream(tempFile);
            IOUtils.copy(inputStream, outputStream);
            IOUtils.closeQuietly(outputStream);
            //____ Install the pojo model from the local repository as a Maven artifact

            InstallRequest installRequest = new InstallRequest();
            Artifact artifact = new DefaultArtifact(artifactGroupId, artifactId, "jar",version);
            artifact = artifact.setFile(tempFile);
            installRequest.addArtifact(artifact);
            repoSystem.install(repoSession, installRequest);

        } catch (IOException e) {
            logger.error("Error occurred while creating he file from the Pojo Model", e);
        } catch (InstallationException e) {
            logger.error("Error occurred while creating he file from the Pojo Model", e);
        } finally {
            logger.debug(">> execute");
        }
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setArtifactGroupId(String artifactGroupId) {
        this.artifactGroupId = artifactGroupId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setRepoSystem(RepositorySystem repoSystem) {
        this.repoSystem = repoSystem;
    }

    public void setRepoSession(RepositorySystemSession repoSession) {
        this.repoSession = repoSession;
    }

    public String getOrganizationalUnitName() {
        return organizationalUnitName;
    }

    public void setOrganizationalUnitName(String organizationalUnitName) {
        this.organizationalUnitName = organizationalUnitName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
