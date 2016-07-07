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
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetCategory;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetPropertyType;
import org.chtijbug.drools.swimmingpool.restclient.rest.model.AssetType;
import org.drools.guvnor.server.jaxrs.jaxb.Asset;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 26/04/12
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */
public class GuvnorRepositoryConnectorLocalTestCase {
    GuvnorRepositoryConnector guvnorRepositoryConnector;

    @Before
    public void setUp() throws Exception {
        guvnorRepositoryConnector = new GuvnorRepositoryConnector("http://localhost:8080/", "/drools-guvnor", "", "", "swimmingpool", "admin", "admin");
    }

    @Test
    //  @Ignore
    public void testgetAllPackages() throws Exception {
        List<Package> toto = guvnorRepositoryConnector.getAllPackagesInGuvnorRepo();
        System.out.println(toto.toString());
    }

    @Test
    @Ignore
    public void testName() throws Exception {
        DecisionTable toto = guvnorRepositoryConnector.getGuidedDecisionTable("test");
        System.out.println(toto.toString());
    }

    @Test
    @Ignore
    public void testGetModel() throws Exception {
        InputStream inputStream = guvnorRepositoryConnector.getPojoModel();

        FileOutputStream outputStream = new FileOutputStream("/tmp/chtijbug/model.jar");
        int ch;
        while ((ch = inputStream.read()) != -1) {
            outputStream.write(ch);
        }
        outputStream.close();
        inputStream.close();
    }


    @Test
    @Ignore
    public void testUpdateAsset() throws Exception {
        guvnorRepositoryConnector.changeAssetPropertyValue("Underage", AssetPropertyType.STATE, "ESSAI");
    }

    @Test
    @Ignore
    public void testcreateAsset() throws Exception {
        Asset newAsset = new Asset();
        newAsset.setTitle("FirstRule2");
        newAsset.setDescription("First Rule via Rest");
        AssetCategory newCategoryOne = new AssetCategory("amag");
        //newAsset.getCategories().add(newCategoryOne);
        AssetCategory newCategorytwo = new AssetCategory("amag");
        //newAsset.getCategories().add(newCategorytwo);

        guvnorRepositoryConnector.createAsset(newAsset, AssetType.GuidedRule, "no source");

    }

    @Test
    @Ignore
    public void testListSnapshots() throws Exception {


        List<String> theList = guvnorRepositoryConnector.getListSnapshots();
        System.out.println(theList.toString());

    }

    @Test
    @Ignore
    public void getListAssets() throws Exception {
        List<Asset> listAssets = guvnorRepositoryConnector.getAllBusinessAssets("loyalty");
        System.out.println(listAssets.toString());
    }

    @Test
    @Ignore
    public void getListAssets2() throws Exception {
        List<Asset> listAssets1 = guvnorRepositoryConnector.getAllBusinessAssets("loyalty");
        List<Asset> listAssets12 = guvnorRepositoryConnector.getAllBusinessAssets("swimmingpool");
        System.out.println(listAssets1.toString());
    }

    @Test
    @Ignore
    public void getAssetVersion() throws Exception {
        Integer version = guvnorRepositoryConnector.getAssetVersion("loyalty", "P1");
        System.out.println(version);
    }

    @Test
    @Ignore
    public void getAssetBPMN2Conrent() throws Exception {
        String content = guvnorRepositoryConnector.getBPMN2InXML("loyalty", "P1");
        System.out.println(content);
    }

    @Test
    @Ignore
    public void getBPMN2ProcessID() throws Exception {
        String content = guvnorRepositoryConnector.getBPMN2ProcessID("loyalty", "P1");
        System.out.println(content);
    }

    @Test
    @Ignore
    public void getListPAckageVersion() throws Exception {
        List<String> content = guvnorRepositoryConnector.getListSnapshots("loyalty");
        System.out.println(content);
    }

}
