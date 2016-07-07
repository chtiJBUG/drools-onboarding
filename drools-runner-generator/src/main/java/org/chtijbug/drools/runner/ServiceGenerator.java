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

import org.apache.commons.io.IOUtils;
import org.chtijbug.drools.guvnor.GuvnorConnexionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 10/10/12
 * Time: 20:02
 */
public class ServiceGenerator {
    /**
     * Class logger
     */
    private static Logger logger = LoggerFactory.getLogger(ServiceGenerator.class);


    public InputStream generateWebServiceArchive(RunnerConfiguration runnerConfiguration) throws DroolsRunnerGenerationException {
        logger.debug(">> generateWebServiceArchive");
        try {

            WebApplicationBuilder archiveBuilder = WebApplicationBuilder.get(runnerConfiguration);
            archiveBuilder.buildWebApplication();
            //_____ Run mvn clean command for installing the model.jar into the local repository
            String warFilePath = runnerConfiguration.getWarFileFile();
            String pomFilePath = runnerConfiguration.getPomFilePath();
            runMvnCleanCommand(pomFilePath);
            //_____ Run mvn package command for packaging the websevice into a war file.
            runMvnPackageCommand(pomFilePath);
            //_____ Return the war file as an input Stream
            File warFile = new File(warFilePath);
            if (!warFile.exists()) {
                throw new DroolsRunnerGenerationException("The expected generated war file cannot be found. Please report a bug into JIRA with stacktrace");
            }
            return org.apache.commons.io.FileUtils.openInputStream(warFile);
        } catch (IOException e) {
            throw new DroolsRunnerGenerationException("An error occured while creating the war file on the filesystem. Do you have write access on the target location ?", e);
        } finally {
            logger.debug("<< generateWebServiceArchive");
        }
    }

    private void runMvnCleanCommand(String mavenProjectPath) throws DroolsRunnerGenerationException {
        try {
            Runtime.getRuntime().exec("mvn -f " + mavenProjectPath + " clean");
        } catch (IOException e) {
            throw new DroolsRunnerGenerationException("An error occurred while executing mvn clean command", e);
        }
    }

    private void runMvnPackageCommand(String mavenProjectPath) throws DroolsRunnerGenerationException {
        try {
            Runtime.getRuntime().exec("mvn -f " + mavenProjectPath + " package");
        } catch (IOException e) {
            throw new DroolsRunnerGenerationException("An error occurred while executing mvn package command", e);
        }
    }

    public static void main(String[] args) {
        ServiceGenerator generator = new ServiceGenerator();

        try {
            GuvnorConnexionConfiguration configuration = new GuvnorConnexionConfiguration("http://192.168.255.60:8080", "drools-guvnor", "","","amag", "tomcat", "tomcat");
            RunnerConfiguration runnerConfiguration = new RunnerConfiguration(configuration, "com.axonactive.amag.pojo.Decision", "com.axonactive.amag.pojo.Decision");
            InputStream warFileInputStream = generator.generateWebServiceArchive(runnerConfiguration);

            FileOutputStream outputStream = new FileOutputStream("/tmp/webService.war");
            IOUtils.copy(warFileInputStream, outputStream);
            IOUtils.closeQuietly(warFileInputStream);
            IOUtils.closeQuietly(outputStream);
            generator.cleanWorkspace();
        } catch (DroolsRunnerGenerationException | IOException e) {
            //____ Error during execution
            System.exit(-1);
        }

    }

    private void cleanWorkspace() throws IOException {
        File workspaceFolder = new File(RunnerConfiguration.WORKSPACE_FOLDER);
        org.apache.commons.io.FileUtils.deleteDirectory(workspaceFolder);
    }

}
