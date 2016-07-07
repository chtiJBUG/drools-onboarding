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

import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.chtijbug.drools.swimmingpool.restclient.GuvnorConnexionConfiguration;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Arrays.asList;
import static junit.framework.Assert.fail;
import static org.custommonkey.xmlunit.XMLUnit.compareXML;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(WebClient.class)
public class GuvnorRepositoryConnectorTest {

    GuvnorConnexionConfiguration configuration = new GuvnorConnexionConfiguration("http://mock-server", "drools-guvnor", "", "", "test", "tomcat", "tomcat");
    GuvnorRepositoryConnector guvnorRepositoryConnector = new GuvnorRepositoryConnector(configuration);
    private WebClient mockWebClient;

    @Before
    public void setUp() throws Exception {
        mockWebClient = mockWebClient();
    }

    @Test
    @Ignore
    public void should_get_latest_asset_version() throws Exception {
        Integer latestAssetVersion = guvnorRepositoryConnector.getAssetVersion("AssetWithVersions");

        assertThat(latestAssetVersion).isNotNull();
        assertThat(latestAssetVersion).isEqualTo(71);

    }

    @Test
    @Ignore
    public void should_get_template_model() throws Exception {
        Map<String, List<String>> table = guvnorRepositoryConnector.getTemplateTable("MyTemplateRule");

        assertThat(table).hasSize(3);
        assertThat(table.get("CONTRACT_A")).hasSize(4);

        verify(mockWebClient).header("Authorization", "Basic dG9tY2F0OnRvbWNhdA==");
    }

    @Test
    @Ignore
    public void should_put_template_table() throws Exception {
        Map<String, List<String>> table = newHashMap();
        table.put("CONTRACT_A", asList("false", "false", "false", "false"));
        table.put("CONTRACT_B", asList("true", "false", "true", "false"));
        table.put("CONTRACT_C", asList("true", "true", "false", "false"));

        guvnorRepositoryConnector.putTemplateTable("MyTemplateRule", table);

        assertExpectedXmlContent(mockWebClient);
    }


    @Test(expected = ChtijbugDroolsRestException.class)
    @Ignore
    public void should_detect_wrong_column_number() throws Exception {
        Map<String, List<String>> table = newHashMap();
        table.put("CONTRACT_A", asList("false", "false", "false", "false"));
        table.put("CONTRACT_C", asList("true", "true", "false", "false"));

        guvnorRepositoryConnector.putTemplateTable("MyTemplateRule", table);
    }


    private void assertExpectedXmlContent(WebClient mockWebClient) throws SAXException, IOException {
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(mockWebClient).put(argument.capture());
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = compareXML(readResource("/ExpectedTemplateRule.xml"), argument.getValue());
        if (!diff.similar()) {
            fail(diff.toString());
        }
    }

    private WebClient mockWebClient() {
        try {
            mockStatic(WebClient.class);
            WebClient mock = mock(WebClient.class);//, withSettings().verboseLogging());
            when(mock.get(String.class)).thenReturn(readResource("/MyTemplateRule.xml"));
            when(mock.get(InputStream.class)).thenReturn(IOUtils.toInputStream(readResource("/asset-atom.xml")));
            when(mock.accept(anyString())).thenReturn(mock);
            when(mock.type(anyString())).thenReturn(mock);
            when(WebClient.create(configuration.getHostname())).thenReturn(mock);
            ClientConfiguration mockedConfig = mock(ClientConfiguration.class);
            when(mockedConfig.getConduit()).thenReturn(mock(HTTPConduit.class));
            when(WebClient.getConfig(mock)).thenReturn(mockedConfig);
            when(mock.path("drools-guvnor/rest/packages/test/assets/MyTemplateRule/source")).thenReturn(mock);
            when(mock.path("drools-guvnor/rest/packages/test/assets/AssetWithVersions/versions")).thenReturn(mock);
            configuration.noTimeout(mock);
            return mock;
        } catch (IOException e) {
            throw propagate(e);
        }
    }

    private String readResource(String resource) throws IOException {
        return IOUtils.toString(this.getClass().getResource(resource).openStream());
    }
}
