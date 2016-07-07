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
package org.chtijbug.drools.swimmingpool.restclient.rest;

import org.chtijbug.drools.swimmingpool.restclient.GuvnorConnexionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * Date: 25/03/13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
class BPMN2ManagerManager {

    private static Logger logger = LoggerFactory.getLogger(BPMN2ManagerManager.class);

    private GuvnorConnexionConfiguration configuration = null;

    private AssetManager assetManager = null;


    public BPMN2ManagerManager(GuvnorConnexionConfiguration configuration, AssetManager assetManager) {
        this.configuration = configuration;
        this.assetManager = assetManager;
    }

    public String getBPMN2InXML(String packageName, String bpmnName) throws ChtijbugDroolsRestException {
        String content = this.assetManager.getAssetCodeInXML(packageName, bpmnName);
        return content;
    }


    public String getBPMN2ProcessID(String packageName, String bpmnName) throws ChtijbugDroolsRestException {
        String content = this.assetManager.getAssetCodeInXML(packageName, bpmnName);
        String processID = null;
        String searchElement = "bpmn2:process id=\"";
        int startIndex = 0;
        int stopIndex = 0;
        startIndex = content.indexOf(searchElement) + searchElement.length();
        stopIndex = content.indexOf("\"", startIndex + 1);
        processID = content.substring(startIndex, stopIndex);


        return processID;
    }

    public void commitChanges(String packageName, String bpmnName, String bpmnContentInXML) throws ChtijbugDroolsRestException {

        this.assetManager.updateAssetCodeFromXML(packageName, bpmnName, bpmnContentInXML);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
}
