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
package org.chtijbug.drools.swimmingpool.restclient;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 09/10/12
 * Time: 09:32
 */
public class GuvnorConnexionConfigurationTestCase {

    private GuvnorConnexionConfiguration toTest;

    @Before
    public void setUp() throws Exception {
        String hostname = "http://192.168.255.60:8080";
        String webappName = "drools-guvnor";
        String packageName = "amag";
        String username = "tomcat";
        String password = "tomcat";
        this.toTest = new GuvnorConnexionConfiguration(hostname, webappName, "", "", packageName, username, password);
    }

//    @Test
//    public void testGetRestAPIPathForPackage() throws Exception {
//        String restApiPath = toTest.getRestAPIPathForPackage();
//        String expectedPath = "drools-guvnor/rest/packages/packageName/assets/";
//
//        assertEquals("The expected calculated path did not match.", expectedPath, restApiPath);
//    }

    @Test
    public void testCreateAuthenticationHeader() throws Exception {
        String base64EncodedHeader = toTest.createAuthenticationHeader();

        String expectedEncodedHeader = "Basic dG9tY2F0OnRvbWNhdA==";

        assertEquals("The expected encoded header did not match.", expectedEncodedHeader, base64EncodedHeader);

    }
}
