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
package org.chtijbug.drools.swimmingpool.restclient.rest.dt;


import org.drools.workbench.models.datamodel.oracle.DataType;
import org.drools.workbench.models.guided.dtable.shared.model.*;

/**
 * Created by IntelliJ IDEA.
 * Date: 26/04/12
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public class ColumnDefinition {
    private int columnNumber;
    private ColumnType columnType;
    private boolean hideColumn;
    private boolean hasDefaultValue;
    private String defaultValue;
    private String fieldType;
    private String header;
    private RowNumberCol52 rowNumberCol52;
    private DescriptionCol52 descriptionCol52;
    private AttributeCol52 attributeCol52;
    private ConditionCol52 conditionCol52;
    private ActionInsertFactCol52 actionInsertFact52;
    private DTCellValue52 defaultValueCell;

    public ColumnDefinition(int columnNumber, RowNumberCol52 rowNumberCol52) {
        this.columnNumber = columnNumber;
        this.columnType = ColumnType.rowNumber;
        this.fieldType = DataType.TYPE_NUMERIC_INTEGER.toString();
        this.rowNumberCol52 = rowNumberCol52;
        this.header = rowNumberCol52.getHeader();
    }

    public ColumnDefinition(int columnNumber, DescriptionCol52 descriptionCol52) {
        this.columnNumber = columnNumber;
        this.columnType = ColumnType.description;
        this.header = descriptionCol52.getHeader();
        this.fieldType = DataType.TYPE_STRING.toString();
        this.descriptionCol52 = descriptionCol52;
    }

    public ColumnDefinition(int columnNumber, AttributeCol52 attributeCol52) {
        this.attributeCol52 = attributeCol52;
        this.columnNumber = columnNumber;
        this.columnType = ColumnType.attribute;
        this.fieldType = DataType.TYPE_STRING.toString();
        if (attributeCol52.getDefaultValue() != null) {
            this.hasDefaultValue = true;
            this.defaultValueCell = attributeCol52.getDefaultValue();
            this.defaultValue = getValue(attributeCol52.getDefaultValue());
        }
        this.header = attributeCol52.getHeader();
        this.hideColumn = attributeCol52.isHideColumn();
    }

    public ColumnDefinition(int columnNumber, ConditionCol52 conditionCol52) {
        this.conditionCol52 = conditionCol52;
        this.columnNumber = columnNumber;
        this.columnType = ColumnType.condition;
        this.fieldType = conditionCol52.getFieldType();
        if (conditionCol52.getDefaultValue() != null) {
            this.hasDefaultValue = true;
            this.defaultValue = getValue(conditionCol52.getDefaultValue());
        }
        this.hideColumn = conditionCol52.isHideColumn();
        this.header = conditionCol52.getHeader();
    }

    public ColumnDefinition(int columnNumber, ActionInsertFactCol52 actionInsertFact52) {
        this.actionInsertFact52 = actionInsertFact52;
        this.columnNumber = columnNumber;
        this.columnType = ColumnType.action;
        this.fieldType = actionInsertFact52.getType();
        this.header = actionInsertFact52.getHeader();
        if (actionInsertFact52.getDefaultValue() != null) {
            DTCellValue52 defaultValue = actionInsertFact52.getDefaultValue();
            if (!(DataType.TYPE_STRING.equals(defaultValue.getDataType()) && defaultValue.getStringValue().isEmpty())) {
                this.hasDefaultValue = true;
                this.defaultValue = getValue(actionInsertFact52.getDefaultValue());
            }
        }
        this.hideColumn = actionInsertFact52.isHideColumn();
        this.header = actionInsertFact52.getHeader();
    }

    public static String getValue(DTCellValue52 cell) {
        String value = null;
        switch (cell.getDataType()) {
            case BOOLEAN:
                value = Boolean.toString(cell.getBooleanValue());
                break;
            case NUMERIC:
                value = cell.getNumericValue().toString();
                break;
            case NUMERIC_INTEGER:
                value = cell.getNumericValue().toString();
                break;
            case NUMERIC_DOUBLE:
                value = cell.getNumericValue().toString();
                break;
            case STRING:
                value = cell.getStringValue();
                break;
            case DATE:
                value = cell.getDateValue().toString();
                break;
        }
        /**
         *  STRING,
         NUMERIC,
         NUMERIC_BIGDECIMAL,
         NUMERIC_BIGINTEGER,
         NUMERIC_BYTE,
         NUMERIC_DOUBLE,
         NUMERIC_FLOAT,
         NUMERIC_INTEGER,
         NUMERIC_LONG,
         NUMERIC_SHORT,
         DATE,
         BOOLEAN
         */
        return value;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public ColumnType getColumnDefinition() {
        return columnType;
    }

    public boolean isHideColumn() {
        return hideColumn;
    }

    public boolean isHasDefaultValue() {
        return hasDefaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public AttributeCol52 getAttributeCol52() {
        return attributeCol52;
    }

    public ConditionCol52 getPattern52() {
        return conditionCol52;
    }

    public ActionInsertFactCol52 getActionInsertFact52() {
        return actionInsertFact52;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getHeader() {
        return header;
    }

}
