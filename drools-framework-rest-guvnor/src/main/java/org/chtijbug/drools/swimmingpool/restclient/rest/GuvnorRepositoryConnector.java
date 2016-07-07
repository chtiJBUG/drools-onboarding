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
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetPropertyType;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetType;
import org.drools.guvnor.server.jaxrs.jaxb.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class GuvnorRepositoryConnector implements RestRepositoryConnector {
    /**
     * Class logger
     */
    private static Logger logger = LoggerFactory.getLogger(GuvnorRepositoryConnector.class);

    /**
     * Guvnor Web application connexion data
     */
    private GuvnorConnexionConfiguration configuration;

    private AssetManager assetManager = null;

    private RuleTemplateManager ruleTemplateManager = null;

    private DecisionTableManager decisionTableManager = null;

    private RulePackageManager rulePackageManager = null;

    private BPMN2ManagerManager bpmn2ManagerManager = null;

    public GuvnorRepositoryConnector(GuvnorConnexionConfiguration configuration) {
        logger.debug(format("Creating new GuvnorRepositoryConnector with args : %s", configuration.toString()));
        this.configuration = configuration;
        this.assetManager = new AssetManager(configuration);
        this.ruleTemplateManager = new RuleTemplateManager(configuration, this.assetManager);
        this.decisionTableManager = new DecisionTableManager(configuration, this.assetManager);
        this.rulePackageManager = new RulePackageManager(configuration);
        this.bpmn2ManagerManager = new BPMN2ManagerManager(configuration, this.assetManager);
    }

    public GuvnorRepositoryConnector(String guvnorUrl, String guvnorAppName, String organizationalUnitName, String repositoryName, String packageName, String guvnorUserName, String guvnorPassword) {
        this(new GuvnorConnexionConfiguration(guvnorUrl, guvnorAppName, organizationalUnitName, repositoryName, packageName, guvnorUserName, guvnorPassword));
    }

    @Override
    public DecisionTable getGuidedDecisionTable(String dtName) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        return this.decisionTableManager.getGuidedDecisionTable(configuration.getDefaultPackageName(), dtName);
    }

    @Override
    public DecisionTable getGuidedDecisionTable(String packageName, String dtName) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException {
        return this.decisionTableManager.getGuidedDecisionTable(packageName, dtName);
    }

    @Override
    public void commitChanges(DecisionTable guidedDecisionTable52) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.decisionTableManager.commitChanges(configuration.getDefaultPackageName(), guidedDecisionTable52);
    }

    @Override
    public void commitChanges(String packageName, DecisionTable guidedDecisionTable52) throws GuvnorConnexionFailedException, ChtijbugDroolsRestException {
        this.decisionTableManager.commitChanges(packageName, guidedDecisionTable52);
    }


    @Override
    public InputStream getPojoModel() throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        return this.assetManager.getPojoModel(configuration.getDefaultPackageName());
    }

    @Override
    public InputStream getPojoModel(String packageName) throws ChtijbugDroolsRestException {

        return this.assetManager.getPojoModel(packageName);
    }

    @Override
    public Map<String, List<String>> getTemplateTable(String templateRuleName) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        return this.ruleTemplateManager.getTemplateTable(configuration.getDefaultPackageName(), templateRuleName);
    }

    @Override
    public Map<String, List<String>> getTemplateTable(String packageName, String templateRuleName) throws ChtijbugDroolsRestException {
        return this.ruleTemplateManager.getTemplateTable(packageName, templateRuleName);
    }

    @Override
    public void putTemplateTable(String templateRuleName, Map<String, List<String>> newTable) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.ruleTemplateManager.putTemplateTable(configuration.getDefaultPackageName(), templateRuleName, newTable);
    }

    @Override
    public void putTemplateTable(String packageName, String templateRuleName, Map<String, List<String>> table) throws ChtijbugDroolsRestException {
        this.ruleTemplateManager.putTemplateTable(packageName, templateRuleName, table);
    }

    @Override
    public List<Asset> getAllBusinessAssets() throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        return this.assetManager.getAllBusinessAssets(configuration.getDefaultPackageName());
    }

    @Override
    public List<Asset> getAllBusinessAssets(String packageName) throws ChtijbugDroolsRestException {
        return this.assetManager.getAllBusinessAssets(packageName);
    }

    @Override
    public List<Package> getAllPackagesInGuvnorRepo() {
        return this.assetManager.getAllPackagesInGuvnorRepo();
    }


    @Override
    public void changeAssetPropertyValue(String assetName, AssetPropertyType assetPropertyType, String propertyValue) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.assetManager.changeAssetPropertyValue(configuration.getDefaultPackageName(), assetName, assetPropertyType, propertyValue);

    }

    @Override
    public void changeAssetPropertyValue(String packageName, String assetName, AssetPropertyType assetPropertyType, String propertyValue) {
        this.assetManager.changeAssetPropertyValue(packageName, assetName, assetPropertyType, propertyValue);
    }

    @Override
    public void createAsset(Asset asset, AssetType assetType, String assetSource) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.assetManager.createAsset(configuration.getDefaultPackageName(), asset, assetType);
        //_____ TODO SMT comment out these 2 lines as we need to find another for doing so
        //org.drools.guvnor.server.jaxrs.providers.atom.Entry output = this.assetManager.createAsset(configuration.getDefaultPackageName(), asset, assetType);
        //this.assetManager.updateAssetCodeFromXML(configuration.getDefaultPackageName(), output.getTitle(), assetSource);
    }

    @Override
    public void createAsset(String packageName, Asset asset, AssetType assetType, String assetSource) throws ChtijbugDroolsRestException {
        this.assetManager.createAsset(packageName, asset, assetType);
        //_____ TODO SMT comment out these 2 lines as we need to find another for doing so
        //org.drools.guvnor.server.jaxrs.providers.atom.Entry output = this.assetManager.createAsset(packageName, asset, assetType);
        //this.assetManager.updateAssetCodeFromXML(packageName, output.getTitle(), assetSource);
    }

    public Integer getAssetVersion(String assetName) throws ChtijbugDroolsRestException {

        return this.getAssetVersion(configuration.getDefaultPackageName(), assetName);
    }

    public Integer getAssetVersion(String packageName, String assetName) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        Asset asset = this.assetManager.getAsset(packageName, assetName);
        Integer assetVersion = null;
        //  if (asset != null && asset.getVersionNumber() != null) {
        //     assetVersion = new Integer(asset.getVersionNumber());
        //}
        return 0;
    }

    @Override
    public void buildRulePackageByStatus(String snapshotName, String filter) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.rulePackageManager.buildRulePackageByStatus(configuration.getDefaultPackageName(), snapshotName, filter);
    }

    @Override
    public void buildRulePackageByStatus(String packageName, String snapshotName, String filter) throws ChtijbugDroolsRestException {
        this.rulePackageManager.buildRulePackageByStatus(packageName, snapshotName, filter);
    }

    @Override
    public void deletePackageSnapshot(String snapshotName) throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        this.rulePackageManager.deletePackageSnapshot(configuration.getDefaultPackageName(), snapshotName);
    }

    @Override
    public void deletePackageSnapshot(String packageName, String snapshotName) throws ChtijbugDroolsRestException {
        this.rulePackageManager.deletePackageSnapshot(packageName, snapshotName);
    }

    @Override
    public List<String> getListSnapshots() throws ChtijbugDroolsRestException {
        if (configuration.getDefaultPackageName() == null || configuration.getDefaultPackageName().length() == 0) {
            throw new ChtijbugDroolsRestException("No Default Package Name defined");
        }
        return this.rulePackageManager.getListSnaphots(configuration.getDefaultPackageName());
    }

    @Override
    public List<String> getListSnapshots(String packageName) throws ChtijbugDroolsRestException {
        return this.rulePackageManager.getListSnaphots(packageName);
    }

    @Override
    public String getBPMN2InXML(String packageName, String bpmn2name) throws ChtijbugDroolsRestException {
        return this.bpmn2ManagerManager.getBPMN2InXML(packageName, bpmn2name);
    }

    @Override
    public String getBPMN2ProcessID(String packageName, String bpmnName) throws ChtijbugDroolsRestException {
        return this.bpmn2ManagerManager.getBPMN2ProcessID(packageName, bpmnName);
    }

    public GuvnorConnexionConfiguration getConfiguration() {
        return configuration;
    }
}
