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

import org.chtijbug.drools.swimmingpool.restclient.rest.SwimmingPoolRestAPI;
import org.chtijbug.example.swimmingpool.Quote;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 09/10/12
 * Time: 09:32
 */
public class GuvnorConnexionConfigurationTestCase {

    private SwimmingPoolConnexionConfiguration toTest;

    @Before
    public void setUp() throws Exception {
        String hostname = "http://localhost:8080/kie-server";

        String username = "admin";
        String password = "admin";
        this.toTest = new SwimmingPoolConnexionConfiguration(hostname, username, password);
    }

    @Test
    public void testGetRestAPIPathForPackage() throws Exception {
        Quote queoteRequest = new Quote();
        SwimmingPoolRestAPI swimmingPoolRestAPI = toTest.getSwimmingPoolRestAPI();

        Quote quoteResponse = swimmingPoolRestAPI.runSession("zouzou", queoteRequest);
        System.out.println(quoteResponse.toString());
    }


}
