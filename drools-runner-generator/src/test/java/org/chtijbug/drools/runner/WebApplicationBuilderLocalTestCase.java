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

import org.apache.commons.io.FileUtils;
import org.chtijbug.drools.guvnor.GuvnorConnexionConfiguration;
import org.chtijbug.drools.guvnor.rest.GuvnorRepositoryConnector;
import org.chtijbug.drools.guvnor.rest.RestRepositoryConnector;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 03/10/12
 * Time: 18:13
 */
public class WebApplicationBuilderLocalTestCase {

    @Test
    public void runBuildProjectSkeleton() throws IOException {
        File workspaceFolder = new File(RunnerConfiguration.WORKSPACE_FOLDER);
        assertNotNull(workspaceFolder);

        try {
            GuvnorConnexionConfiguration configuration = new GuvnorConnexionConfiguration("http://192.168.255.60:8080", "drools-guvnor","","","amag", "tomcat", "tomcat");
            RunnerConfiguration runnerConfiguration = new RunnerConfiguration(configuration, "com.axonactive.amag.pojo.Decision", "com.axonactive.amag.pojo.Decision");
            RestRepositoryConnector repositoryConnector = new GuvnorRepositoryConnector(configuration);
            WebApplicationBuilder toTest = new WebApplicationBuilder(runnerConfiguration);
            toTest.buildProjectSkeleton();
            //_____ If the method is correctly executed, then it is correct.
            // TODO Add some file system searches to be sure directories are correctly created
        } catch (Throwable e) {
            e.printStackTrace();
            fail();
        } finally {
            FileUtils.deleteDirectory(workspaceFolder);
        }
    }

    @Test
    public void testBuildWebApplication() throws Exception {
        File workspaceFolder = new File(RunnerConfiguration.WORKSPACE_FOLDER);
        assertNotNull(workspaceFolder);

        try {
            GuvnorConnexionConfiguration configuration = new GuvnorConnexionConfiguration("http://192.168.255.60:8080/", "drools-guvnor/","","","amag", "tomcat", "tomcat");
            RunnerConfiguration runnerConfiguration = new RunnerConfiguration(configuration, "com.axonactive.amag.pojo.Decision", "com.axonactive.amag.pojo.Decision");
            RestRepositoryConnector repositoryConnector = new GuvnorRepositoryConnector(configuration);
            WebApplicationBuilder toTest = new WebApplicationBuilder(runnerConfiguration);
            toTest.buildWebApplication();
            //_____ If the method is correctly executed, then it is correct.
            // TODO Add some file system searches to be sure all expected files are present and content be replaced
        } catch (Throwable e) {
            e.printStackTrace();
            fail();
        } finally {
            FileUtils.deleteDirectory(workspaceFolder);
        }
    }
}
