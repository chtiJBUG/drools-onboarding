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
import org.chtijbug.drools.swimmingpool.restclient.rest.dt.DecisionTable;
import org.drools.workbench.models.guided.dtable.backend.GuidedDTXMLPersistence;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * Date: 25/03/13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
class DecisionTableManager {

    private static Logger logger = LoggerFactory.getLogger(DecisionTableManager.class);

    private GuvnorConnexionConfiguration configuration = null;

    private AssetManager assetManager = null;

    public DecisionTableManager(GuvnorConnexionConfiguration configuration, AssetManager assetManager) {
        this.configuration = configuration;
        this.assetManager = assetManager;
    }

    public DecisionTable getGuidedDecisionTable(String packageName, String dtName) throws ChtijbugDroolsRestException {
        String content = this.assetManager.getAssetCodeInXML(packageName, dtName);
        GuidedDecisionTable52 guidedDecisionTable52 = GuidedDTXMLPersistence.getInstance().unmarshal(content);
        return new DecisionTable(guidedDecisionTable52);
    }

    public void commitChanges(String packageName, DecisionTable guidedDecisionTable52) throws ChtijbugDroolsRestException {
        String dtName = guidedDecisionTable52.getGuidedDecisionTable52().getTableName();
        String newContent = GuidedDTXMLPersistence.getInstance().marshal(guidedDecisionTable52.getGuidedDecisionTable52());
        this.assetManager.updateAssetCodeFromXML(packageName, dtName, newContent);
    }

}
