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

import com.squareup.okhttp.OkHttpClient;
import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.chtijbug.drools.swimmingpool.restclient.rest.GuvnorRestApi;
import org.codehaus.jackson.map.ObjectMapper;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import static java.lang.String.format;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 09/10/12
 * Time: 09:05
 */
public class GuvnorConnexionConfiguration {
    private static WebClient client = null;
    /**
     * Hostname and port
     */
    private String hostname;
    /**
     * Web application Name
     */
    private String webappName;
    /**
     * organizationalUnitName
     */
    private String organizationalUnitName;
    /**
     * repositoryName
     */
    private String repositoryName;
    /**
     * The package name which contains all business assets
     */
    private String defaultPackageName;
    /**
     * username for login
     */
    private String username;
    /**
     * password for login
     */
    private String password;

    public GuvnorConnexionConfiguration(String hostname, String webappName, String organizationalUnitName, String repositoryName, String defaultPackageName, String username, String password) {
        this.hostname = hostname;
        this.webappName = webappName;
        this.organizationalUnitName = organizationalUnitName;
        this.repositoryName = repositoryName;
        this.defaultPackageName = defaultPackageName;
        this.username = username;
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public String getWebappName() {
        return webappName;
    }

    public String getDefaultPackageName() {
        return defaultPackageName;
    }

    public void setDefaultPackageName(String defaultPackageName) {
        this.defaultPackageName = defaultPackageName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganizationalUnitName() {
        return organizationalUnitName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * This method will create authentication header frame containing Base 64 encoded username and password
     *
     * @return the authentication header frame
     */
    public String createAuthenticationHeader() {
        return "Basic " + Base64Utility.encode((username + ":" + password).getBytes());
    }

    public WebClient webClient() {
        if (client != null) {
            client.close();
            client = null;
        }
        if (client == null) {
            client = WebClient.create(this.getHostname());
            client.header("Authorization", this.createAuthenticationHeader());
        }
        return client;
    }

    public String assetBinaryPath(String packageName, String ruleName) {
        return getPathFor(packageName, ruleName, "source");
    }

    public String getPathFor(String packageName, String assetName, String pathType) {
        return format("%s/rest/packages/%s/%s/%s", this.getWebappName(), this.organizationalUnitName, this.repositoryName, packageName, assetName, pathType);
    }

    public void noTimeout(WebClient client) {
        ClientConfiguration config = WebClient.getConfig(client);
        HTTPConduit http = (HTTPConduit) config.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        /* connection timeout for requesting the rule package binaries */
        long connectionTimeout = 0L;
        httpClientPolicy.setConnectionTimeout(connectionTimeout);
        /* Reception timeout */
        long receivedTimeout = 0L;
        httpClientPolicy.setReceiveTimeout(receivedTimeout);

        http.setClient(httpClientPolicy);
    }


    public GuvnorRestApi getGuvnorRestApiService() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Authorization", createAuthenticationHeader());
            }
        };
        // Maybe you have to correct this or use another / no Locale

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(this.getHostname() + this.getWebappName())
                .setRequestInterceptor(requestInterceptor)
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new JacksonConverter(new ObjectMapper()))
                .build();

        return restAdapter.create(GuvnorRestApi.class);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GuvnorConnexionConfiguration{");
        sb.append("hostname='").append(hostname).append('\'');
        sb.append(", webappName='").append(webappName).append('\'');
        sb.append(", defaultPackageName='").append(defaultPackageName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
