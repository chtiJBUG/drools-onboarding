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
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 09/10/12
 * Time: 09:05
 */
public class SwimmingPoolConnexionConfiguration {

    private static ResteasyClient client = null;
    private static ResteasyWebTarget target = null;
    private String baseUrl;
    private String userName;
    private String password;
    private SwimmingPoolRestAPI swimmingPoolRestAPI;

    public SwimmingPoolConnexionConfiguration(String baseUrl, String userName, String password) {
        this.baseUrl = baseUrl;
        this.userName = userName;
        this.password = password;
    }


    public SwimmingPoolRestAPI getSwimmingPoolRestAPI() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(this.baseUrl);
        target.register(new BasicAuthentication(this.userName, this.password));
        swimmingPoolRestAPI = target.proxy(SwimmingPoolRestAPI.class);
        return swimmingPoolRestAPI;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SwimmingPoolConnexionConfiguration{");
        sb.append("baseUrl='").append(baseUrl).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
