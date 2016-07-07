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


import org.chtijbug.drools.swimmingpool.restclient.rest.dt.DecisionTable;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetPropertyType;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetType;
import org.drools.guvnor.server.jaxrs.jaxb.Asset;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface RestRepositoryConnector {


    DecisionTable getGuidedDecisionTable(String dtName) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException;

    DecisionTable getGuidedDecisionTable(String packageName, String dtName) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException;

    void commitChanges(DecisionTable guidedDecisionTable52) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException;

    void commitChanges(String packageName, DecisionTable guidedDecisionTable52) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException;

    InputStream getPojoModel() throws ChtijbugDroolsRestException;

    InputStream getPojoModel(String packageName) throws ChtijbugDroolsRestException;


    Map<String, List<String>> getTemplateTable(String templateRuleName) throws ChtijbugDroolsRestException;

    Map<String, List<String>> getTemplateTable(String packageName, String templateRuleName) throws ChtijbugDroolsRestException;


    void putTemplateTable(String templateRuleName, Map<String, List<String>> table) throws ChtijbugDroolsRestException;

    void putTemplateTable(String packageName, String templateRuleName, Map<String, List<String>> table) throws ChtijbugDroolsRestException;


    List<Asset> getAllBusinessAssets() throws ChtijbugDroolsRestException;

    List<Asset> getAllBusinessAssets(String packageName) throws ChtijbugDroolsRestException;


    List<Package> getAllPackagesInGuvnorRepo();


    void changeAssetPropertyValue(String assetName, AssetPropertyType assetPropertyType, String propertyValue) throws ChtijbugDroolsRestException;

    void changeAssetPropertyValue(String packageName, String assetName, AssetPropertyType assetPropertyType, String propertyValue);

    void createAsset(Asset asset, AssetType assetType, String assetSource) throws ChtijbugDroolsRestException;

    void createAsset(String packageName, Asset asset, AssetType assetType, String assetSource) throws ChtijbugDroolsRestException;

    void buildRulePackageByStatus(String snapshotName, String filter) throws ChtijbugDroolsRestException;

    void buildRulePackageByStatus(String packageName, String snapshotName, String filter) throws ChtijbugDroolsRestException;

    void deletePackageSnapshot(String snapshotName) throws ChtijbugDroolsRestException;

    void deletePackageSnapshot(String packageName, String snapshotName) throws ChtijbugDroolsRestException;


    List<String> getListSnapshots() throws ChtijbugDroolsRestException;

    List<String> getListSnapshots(String packageName) throws ChtijbugDroolsRestException;

    String getBPMN2InXML(String packageNamen, String bpmn2name) throws ChtijbugDroolsRestException;

    public String getBPMN2ProcessID(String packageName, String bpmnName) throws ChtijbugDroolsRestException;


}

