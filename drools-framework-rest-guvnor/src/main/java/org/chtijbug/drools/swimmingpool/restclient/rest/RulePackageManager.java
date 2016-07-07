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

import ch.lambdaj.function.convert.Converter;
import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Element;
import org.apache.abdera.parser.stax.FOMExtensibleElement;
import org.apache.cxf.jaxrs.client.WebClient;
import org.chtijbug.drools.common.jaxb.JAXBContextUtils;
import org.chtijbug.drools.swimmingpool.restclient.GuvnorConnexionConfiguration;
import org.drools.guvnor.server.jaxrs.jaxb.SnapshotCreationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static ch.lambdaj.Lambda.convert;
import static java.lang.String.format;

/**
 * Created by IntelliJ IDEA.
 * Date: 16/04/13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public class RulePackageManager {

    private static Logger logger = LoggerFactory.getLogger(RulePackageManager.class);

    private GuvnorConnexionConfiguration configuration = null;

    public RulePackageManager(GuvnorConnexionConfiguration configuration) {
        this.configuration = configuration;
    }

    public void buildRulePackageByStatus(String packageName, String snapshotName, String filter) throws ChtijbugDroolsRestException {
        SnapshotCreationData snapshotCreationData = new SnapshotCreationData();
        snapshotCreationData.setBuildMode("BuiltInSelector");
        snapshotCreationData.setEnableStatusSelector(true);
        snapshotCreationData.setStatusOperator("=");
        snapshotCreationData.setStatusDescriptionValue(filter);
        try {
            String path = format("%s/rest/packages/%s/snapshot/%s", this.configuration.getWebappName(), packageName, snapshotName);

            String xmlObject = JAXBContextUtils.marshallObjectAsString(SnapshotCreationData.class, snapshotCreationData);
            WebClient webClient = this.configuration.webClient();
            this.configuration.noTimeout(webClient);
            webClient.path(path)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .post(xmlObject);
        } catch (JAXBException e) {
            throw new ChtijbugDroolsRestException(e);
        }
    }

    public List<String> getListSnaphots(String packageName) throws ChtijbugDroolsRestException {
        List<String> result = new ArrayList();
        try {
            String path = format("%s/rest/packages/%s/snapshots", this.configuration.getWebappName(), packageName);
            WebClient webClient = this.configuration.webClient();
            this.configuration.noTimeout(webClient);
            /**
             * Snapshots list = webClient.path(path)
             .type(MediaType.APPLICATION_ATOM_XML)
             .get(Snapshots.class);
             **/
            InputStream inputStream = webClient.path(path)
                    .type(MediaType.APPLICATION_ATOM_XML)
                    .get(InputStream.class);
            Document<Element> atomDocument = Abdera.getInstance().getParser().parse(inputStream);
            FOMExtensibleElement feed = (FOMExtensibleElement) atomDocument.getRoot();
            final XPath xPath = XPathFactory.newInstance().newXPath();
            result = convert(feed.getElements(), new Converter<FOMExtensibleElement, String>() {


                @Override
                public String convert(FOMExtensibleElement element) {
                    if (element.getNextSibling() != null)
                        return element.getNextSibling().getText();
                    else
                        return null;
                }
            });
        } catch (Exception e) {
            throw new ChtijbugDroolsRestException(e);
        }
        return result;
    }


    public void deletePackageSnapshot(String packageName, String snapshotName) {
        String path = format("%s/rest/packages/%s/snapshot/%s/delete", this.configuration.getWebappName(), packageName, snapshotName);
        WebClient webClient = this.configuration.webClient();
        this.configuration.noTimeout(webClient);
        webClient.path(path)
                .type(MediaType.APPLICATION_ATOM_XML)
                .delete();
    }


}
