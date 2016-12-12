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
package org.chtijbug.loyalty.web;


import org.chtijbug.drools.generic.restclient.GenericConnexionConfiguration;
import org.chtijbug.drools.generic.restclient.rest.UsedRestAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value(value="${url.loyalty.calculate}")
    private String url;

    @Value(value="${url.loyalty.calculate.username}")
    private String username;
    @Value(value="${url.loyalty.calculate.password}")
    private String password;

    @Bean
    public UsedRestAPI serviceCalculate() {
        GenericConnexionConfiguration swimmingPoolConnexionConfiguration = new GenericConnexionConfiguration(url, username, password);

        return swimmingPoolConnexionConfiguration.getGenericRestAPI();

    }
}