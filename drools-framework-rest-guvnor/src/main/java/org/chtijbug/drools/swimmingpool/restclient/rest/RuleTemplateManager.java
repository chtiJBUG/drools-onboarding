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

import com.google.common.collect.Iterables;
import org.chtijbug.drools.swimmingpool.restclient.GuvnorConnexionConfiguration;
import org.drools.workbench.models.datamodel.rule.InterpolationVariable;
import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.drools.workbench.models.guided.template.backend.RuleTemplateModelXMLPersistenceImpl;
import org.drools.workbench.models.guided.template.shared.TemplateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by IntelliJ IDEA.
 * Date: 25/03/13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
class RuleTemplateManager {
    private static Logger logger = LoggerFactory.getLogger(RuleTemplateManager.class);

    private GuvnorConnexionConfiguration configuration = null;

    private AssetManager assetManager = null;

    public RuleTemplateManager(GuvnorConnexionConfiguration configuration, AssetManager assetManager) {
        this.configuration = configuration;
        this.assetManager = assetManager;
    }

    public Map<String, List<String>> getTemplateTable(String packageName, String templateRuleName) throws ChtijbugDroolsRestException {
        TemplateModel templateModel = getTemplateModel(packageName, templateRuleName);
        Map<String, List<String>> table = templateModel.getTable();
        table.remove(TemplateModel.ID_COLUMN_NAME);
        return table;
    }

    public void putTemplateTable(String packageName, String templateRuleName, Map<String, List<String>> newTable) throws ChtijbugDroolsRestException {
        TemplateModel templateModel = getTemplateModel(packageName, templateRuleName);
        updateTableContent(newTable, templateModel);
        String xmlContent = RuleTemplateModelXMLPersistenceImpl.getInstance().marshal(templateModel);
        this.assetManager.updateAssetCodeFromXML(packageName, templateRuleName, xmlContent);
    }

    private TemplateModel getTemplateModel(String packageName, String templateRuleName) throws ChtijbugDroolsRestException {
        String content = this.assetManager.getAssetCodeInXML(packageName, templateRuleName);
        RuleModel ruleModel = RuleTemplateModelXMLPersistenceImpl.getInstance().unmarshal(content);
        return (TemplateModel) ruleModel;
    }

    private void updateTableContent(Map<String, List<String>> newTable, TemplateModel templateModel) throws ChtijbugDroolsRestException {
        templateModel.clearRows();
        int rowCount = Iterables.get(newTable.values(), 1).size();
        List<String> columnNames = orderedColumnNames(templateModel);
        checkColumnNames(columnNames, newTable);
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            List<String> row = newArrayList();
            for (String columnName : columnNames) {
                row.add(newTable.get(columnName).get(rowIndex));
            }
            templateModel.addRow(row.toArray(new String[row.size()]));
        }
    }

    private void checkColumnNames(List<String> columnNames, Map<String, List<String>> newTable) throws ChtijbugDroolsRestException {
        Set<String> newColumnNames = newTable.keySet();
        Set<String> columnNamesSet = new HashSet<String>(columnNames);
        if (!newColumnNames.equals(columnNamesSet)) {
            throw new ChtijbugDroolsRestException("Expected columns names : " + columnNames);
        }
    }

    private List<String> orderedColumnNames(TemplateModel templateModel) {
        List<String> columnNames = new ArrayList<String>();
        InterpolationVariable[] variablesList = templateModel.getInterpolationVariablesList();
        for (int i = 0; i < variablesList.length; i++) {
            columnNames.add(variablesList[i].getVarName());
        }
        return columnNames;
    }

}
