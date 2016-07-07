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
package org.chtijbug.drools.runner;


import org.chtijbug.drools.guvnor.GuvnorConnexionConfiguration;
import org.chtijbug.drools.guvnor.rest.ChtijbugDroolsRestException;
import org.chtijbug.drools.guvnor.rest.GuvnorRepositoryConnector;
import org.chtijbug.drools.guvnor.rest.RestRepositoryConnector;
import org.chtijbug.drools.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.chtijbug.drools.utils.FileUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 03/10/12
 * Time: 17:38
 */
public class WebApplicationBuilder {
    /**
     * class logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationBuilder.class);
    /**
     * POM file template
     */
    private static final String POM_FILE = "/templates/pom-template";
    /**
     * log4j file template
     */
    private static final String LOG4J_FILE = "/templates/log4j-template";
    /**
     * spring file template
     */
    private static final String SPRING_FILE = "/templates/spring-template";
    /**
     * spring CXF file template
     */
    private static final String SPRING_CXF_FILE = "/templates/spring-cxf-template";
    /**
     * web.xml file template
     */
    private static final String WEB_XML_FILE = "/templates/web-xml-template";
    /**
     * web service package
     */
    private static final String WS_INTERFACE_PACKAGE = "org/chtijbug/drools/ws";
    /**
     * web service implementation package
     */
    private static final String WS_IMPLEMENTATION_PACKAGE = WS_INTERFACE_PACKAGE.concat("/impl");
    public static final String SRC_MAIN_JAVA = "src/main/java";
    public static final String SRC_MAIN_RESOURCES = "src/main/resources";
    public static final String SRC_MAIN_RESOURCES_SPRING = "src/main/resources/spring";
    public static final String SRC_MAIN_WEBAPP_WEB_INF = "src/main/webapp/WEB-INF";
    public static final String SRC_MAIN_WEBAPP_WEB_INF_SPRING = "src/main/webapp/WEB-INF/spring";
    public static final String LIB_FOLDER = "lib";

    private final RunnerConfiguration runnerConfiguration;
    private final String webAppName;
    private final File projectFolder;
    private final RestRepositoryConnector repositoryConnector;


    protected WebApplicationBuilder(RunnerConfiguration runnerConfiguration) throws DroolsRunnerGenerationException {
        this.runnerConfiguration = runnerConfiguration;
        File workspaceFolder = new File(RunnerConfiguration.WORKSPACE_FOLDER);
        if (!workspaceFolder.exists()) {
            if (!workspaceFolder.mkdirs()) {
                throw new DroolsRunnerGenerationException(String.format("Error while creating the folder %s", RunnerConfiguration.WORKSPACE_FOLDER));
            }
        }
        //_____ Create the root folder
        this.webAppName = runnerConfiguration.getWebappName();
        projectFolder = new File(workspaceFolder, webAppName);
        if (!projectFolder.exists() && !projectFolder.mkdir()) {
            throw new DroolsRunnerGenerationException(String.format("Error while creating the folder %s", projectFolder.getName()));
        }
        this.repositoryConnector = new GuvnorRepositoryConnector(this.runnerConfiguration.getConfiguration());
    }

    public void buildWebApplication() throws DroolsRunnerGenerationException {
        try {
            //______ Build the project file skeleton
            buildProjectSkeleton();
            //______ Copy all files from templates
            //_____ Copy log4j.xml file into resources folder
            File resourcesFolder = getFolder(projectFolder, SRC_MAIN_RESOURCES);
            createFileFromTemplate(resourcesFolder, "log4j.xml", LOG4J_FILE);
            File springFolder = getFolder(projectFolder, SRC_MAIN_RESOURCES_SPRING);
            createFileFromTemplate(springFolder, "chtijbug-spring.xml", SPRING_FILE);
            File springCxfFolder = getFolder(projectFolder, SRC_MAIN_WEBAPP_WEB_INF_SPRING);
            createFileFromTemplate(springCxfFolder, "rule-engine-servlet.xml", SPRING_CXF_FILE);
            //_____ Copy file expected to be updated according to configuration
            File pomXml = createFileFromTemplate(projectFolder, "pom.xml", POM_FILE);
            FileUtils.replaceTokenInFile(pomXml, "#WAR_NAME#", this.webAppName);
            //_____ Copy property file containing Guvnor repository connexion info
            replacePropertyFileTokens(resourcesFolder);
            //______ Create the service interface
            createServiceInterface();
            //_____ Copy Configuration Bean class file
            createImplementationJavaSources();
            //_____ Copy web.xml descriptor file
            File webInfFolder = getFolder(projectFolder, SRC_MAIN_WEBAPP_WEB_INF);
            createFileFromTemplate(webInfFolder, "web.xml", WEB_XML_FILE);
            //_____ Download model.jar file into the lib folder
            File libFolder = getFolder(projectFolder, LIB_FOLDER);
            InputStream inputStream = this.repositoryConnector.getPojoModel();
            FileUtils.createFileFromInputStream(libFolder, "model.jar", inputStream);
            // Return the InputStream from reading the tmp file
        } catch (IOException e) {
            throw new DroolsRunnerGenerationException("An error occurred while genereting the tmp Maven project", e);
        } catch (ChtijbugDroolsRestException e) {
            throw new DroolsRunnerGenerationException("An error occurred while genereting the tmp Maven project ", (IOException) e.getCause());
        }
    }

    private void createImplementationJavaSources() throws IOException {
        File javaSrcFolder = getFolder(this.projectFolder, SRC_MAIN_JAVA);
        File implementationPackageFolder = getFolder(javaSrcFolder, WS_IMPLEMENTATION_PACKAGE);
        createFileFromTemplate(implementationPackageFolder, "RuleEngineConfig.java", "/templates/config-class-template");
        //_____ Create service implementation Java class file
        File serviceImplementationFile = createFileFromTemplate(implementationPackageFolder, "RulesRunnerServiceImpl.java", "/templates/service-implementation-template");
        //_____ Replace Token with expected content
        replaceJavaClassToken(serviceImplementationFile);
    }

    /**
     * This method create the service interface Java resource.
     * By default, this method considers that the input class == the output class
     * That's why default local variable intialization set the same values as the input
     *
     * @throws IOException
     */
    private void createServiceInterface() throws IOException {
        logger.debug("createServiceInterface");
        try {
            File javaSrcFolder = getFolder(this.projectFolder, SRC_MAIN_JAVA);
            File servicePackageFolder = getFolder(javaSrcFolder, WS_INTERFACE_PACKAGE);
            File serviceInterfaceFile = createFileFromTemplate(servicePackageFolder, "RulesRunnerService.java", "/templates/service-interface-template");
            replaceJavaClassToken(serviceInterfaceFile);
        } finally {
            logger.debug("createServiceInterface");
        }
    }

    private void replaceJavaClassToken(File javaResourceFile) throws IOException {
        //____ Get the import code line for input class
        String inputClassName = this.runnerConfiguration.getInputClassName();
        String outputClassName = this.runnerConfiguration.getOutputClassName();
        String inputClassShortName = this.runnerConfiguration.getInputClassShortName();
        String outputClassShortName = this.runnerConfiguration.getInputClassShortName();
        String importInputClass = "import " + inputClassName + ";";

        String importOutputClass = "";
        if (!inputClassName.equals(outputClassName)) {
            importOutputClass = "import " + this.runnerConfiguration.getOutputClassName() + ";";
            outputClassShortName = this.runnerConfiguration.getOutputClassShortName();
        }
        FileUtils.replaceTokenInFile(javaResourceFile, "#INPUT_CLASS_IMPORT#", importInputClass);
        FileUtils.replaceTokenInFile(javaResourceFile, "#OUTPUT_CLASS_IMPORT#", importOutputClass);
        FileUtils.replaceTokenInFile(javaResourceFile, "#INPUT_CLASS_NAME#", inputClassShortName);
        FileUtils.replaceTokenInFile(javaResourceFile, "#OUTPUT_CLASS_NAME#", outputClassShortName);
        String variableName = inputClassShortName.substring(0, 1).toLowerCase().concat(inputClassShortName.substring(1, inputClassShortName.length()));
        FileUtils.replaceTokenInFile(javaResourceFile, "#INPUT_PARAM_NAME#", variableName);
    }

    private void replacePropertyFileTokens(File resourcesFolder) throws IOException {
        logger.debug("replacePropertyFileTokens", resourcesFolder);
        try {
            GuvnorConnexionConfiguration guvnorConf = this.runnerConfiguration.getConfiguration();
            File guvnorPropsFile = createFileFromTemplate(resourcesFolder, "rules-runner.properties", "/templates/guvnor-properties-template");
            FileUtils.replaceTokenInFile(guvnorPropsFile, "#HOSTNAME#", guvnorConf.getHostname());
            FileUtils.replaceTokenInFile(guvnorPropsFile, "#WEBAPPNAME#", guvnorConf.getWebappName());
            FileUtils.replaceTokenInFile(guvnorPropsFile, "#PACKAGE#", this.runnerConfiguration.getPackageName());
            FileUtils.replaceTokenInFile(guvnorPropsFile, "#USERNAME#", guvnorConf.getUsername());
            FileUtils.replaceTokenInFile(guvnorPropsFile, "#PASSWORD#", guvnorConf.getPassword());
        } finally {
            logger.debug("replacePropertyFileTokens");
        }
    }

    protected void buildProjectSkeleton() throws DroolsRunnerGenerationException, IOException {
        //_____ Create all standard Maven web application project folders
        createFolder(SRC_MAIN_JAVA, projectFolder);
        createFolder(SRC_MAIN_RESOURCES, projectFolder);
        createFolder(SRC_MAIN_WEBAPP_WEB_INF, projectFolder);
        //_____ Copy pom.xml file base on template
        File resourcesFolder = getFolder(projectFolder, SRC_MAIN_RESOURCES);
        //______ Copy spring context configuration file
        createFolder("spring", resourcesFolder);
        //______ Copy spring web context configuration file
        File webInfFolder = getFolder(projectFolder, SRC_MAIN_WEBAPP_WEB_INF);
        createFolder("spring", webInfFolder);
        //______ Create folder for containing java classes to be generated
        File srcFolder = getFolder(projectFolder, SRC_MAIN_JAVA);
        createFolder(WS_IMPLEMENTATION_PACKAGE, srcFolder);
        //______ Add lib/ folder at the project root path
        createFolder(LIB_FOLDER, projectFolder);
    }

    public static WebApplicationBuilder get(RunnerConfiguration runnerConfiguration) throws DroolsRunnerGenerationException {
        return new WebApplicationBuilder(runnerConfiguration);
    }
}
