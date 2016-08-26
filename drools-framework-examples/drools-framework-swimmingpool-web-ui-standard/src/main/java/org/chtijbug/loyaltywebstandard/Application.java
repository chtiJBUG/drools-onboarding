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
package org.chtijbug.loyaltywebstandard;


import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.impl.RuleBaseCommandSingleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan

@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Value(value="${url.kie.url}")
    private String url;

    @Value(value="${url.kie.username}")
    private String username;
    @Value(value="${url.kie.password}")
    private String password;

    @Value(value="${url.kie.containerid}")
    private String containerId;

    @Bean
    public RuleBaseCommandSingleton serviceCalculate() {
        RuleBaseCommandSingleton ruleBaseCommandSingleton=null;
        try {
            ruleBaseCommandSingleton= (RuleBaseCommandSingleton) RuleBaseBuilder.createRemoteStandardRestBasePackage("dev",url, username, password);
        } catch (DroolsChtijbugException e) {
            e.printStackTrace();
        }


        return ruleBaseCommandSingleton;

    }
}