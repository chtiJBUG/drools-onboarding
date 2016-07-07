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

import org.apache.cxf.jaxrs.client.WebClient;
import org.chtijbug.drools.swimmingpool.restclient.GuvnorConnexionConfiguration;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetPropertyType;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetType;
import org.drools.guvnor.server.jaxrs.jaxb.Asset;
import org.drools.guvnor.server.jaxrs.jaxb.AssetMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 25/03/13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
class AssetManager {

    private static Logger logger = LoggerFactory.getLogger(AssetManager.class);

    private GuvnorConnexionConfiguration configuration = null;

    public AssetManager(GuvnorConnexionConfiguration configuration) {
        this.configuration = configuration;
    }


    public void changeAssetPropertyValue(String packageName, String assetName, AssetPropertyType assetPropertyType, String propertyValue) {
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        //_____ Extract the current version of the asset
        Collection<org.drools.guvnor.server.jaxrs.jaxb.Asset> assets = guvnorService.getAsset(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName, assetName);
        org.drools.guvnor.server.jaxrs.jaxb.Asset asset = assets.iterator().next();
        //_____ Replace the property value
        org.drools.guvnor.server.jaxrs.jaxb.AssetMetadata assetMetadata = asset.getMetadata();
        if (assetMetadata != null) {
            if (AssetPropertyType.STATE.toString().equals(assetPropertyType.toString())) {
                assetMetadata.setState(propertyValue);
            }
            assetMetadata.setCheckInComment("Updated attribute: " + assetPropertyType);
        }
        if (asset.getDescription() == null) {
            asset.setDescription("Default Description");
        }
        //____ Put the new version of the Asset
        guvnorService.updateAsset(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName, assetName, asset);
    }

    public void createAsset(String packageName, Asset newAsset, AssetType assetType) throws ChtijbugDroolsRestException {
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        org.drools.guvnor.server.jaxrs.jaxb.Asset asset = new org.drools.guvnor.server.jaxrs.jaxb.Asset();
        asset.setTitle(newAsset.getTitle());
        asset.setDescription(newAsset.getDescription());

        AssetMetadata metadata = new AssetMetadata();
        asset.setMetadata(metadata);


        metadata.setFormat(assetType.getId());
        String[] categories = new String[]{};
        List<String> listCategories = new ArrayList<String>();
        /**
         for (AssetCategory assetCategory : newAsset.getCategories()) {
         listCategories.add(assetCategory.getName());
         }

         categories = listCategories.toArray(categories);
         metadata.setCategories(categories);
         */
        guvnorService.createAsset(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName, asset);
    }

    public List<Asset> getAllBusinessAssets(final String packageName) {
        List<Asset> result;
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        result = guvnorService.getAllAssets(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName);
        return result;
    }

    public List<Package> getAllPackagesInGuvnorRepo() {
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        return guvnorService.getAllPackages(configuration.getOrganizationalUnitName(), configuration.getRepositoryName());

    }


    public Asset getAsset(final String packageName, String assetName) {
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        //_____ Extract the current version of the asset
        Collection<org.drools.guvnor.server.jaxrs.jaxb.Asset> assets = guvnorService.getAsset(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName, assetName);
        org.drools.guvnor.server.jaxrs.jaxb.Asset asset = assets.iterator().next();
        return asset;
    }

    public InputStream getPojoModel(String packageName) {
        String path = this.configuration.getWebappName() + "/org.drools.guvnor.Guvnor/package/" + packageName + "/LATEST/MODEL";
        WebClient client = configuration.webClient();
        Response stream = client.path(path).accept(MediaType.APPLICATION_OCTET_STREAM_TYPE).get();
        return (InputStream) stream.getEntity();
    }

    public void updateAssetCodeFromXML(String packageName, String assetName, String newCode) throws ChtijbugDroolsRestException {
        GuvnorRestApi guvnorService = configuration.getGuvnorRestApiService();
        guvnorService.updateAssetFromSource(configuration.getOrganizationalUnitName(), configuration.getRepositoryName(), packageName, assetName, newCode);
    }

    public String getAssetCodeInXML(String packageName, String dtName) throws ChtijbugDroolsRestException {
        return configuration.webClient().path(configuration.assetBinaryPath(packageName, dtName)).accept("text/plain").get(String.class);
    }


}
