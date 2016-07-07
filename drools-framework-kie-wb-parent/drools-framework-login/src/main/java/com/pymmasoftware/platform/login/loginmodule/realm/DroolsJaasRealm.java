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
package com.pymmasoftware.platform.login.loginmodule.realm;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.realm.JAASRealm;


public class DroolsJaasRealm extends JAASRealm {

    private String jaasConfig;

    public String getJaasConfig() {
        return jaasConfig;
    }

    public void setJaasConfig(String jaasConfig) {
        this.jaasConfig = jaasConfig;
    }

    public void initialize() throws LifecycleException {
        System.setProperty("javax.security.auth.login.Configuration", jaasConfig);
        super.init();
    }
}
