package org.chtijbug.drools.carinsurance.model;

import java.math.BigDecimal;

/**
 * Created by nheron on 14/09/2016.
 */
public class CalculatedElement {

    private String objectName;
    private String key;
    private String Description;
    private BigDecimal bigDecimalValue;
    private Long longValue;
    private Double doubleValue;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BigDecimal getBigDecimalValue() {
        return bigDecimalValue;
    }

    public void setBigDecimalValue(BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CalculatedElement{");
        sb.append("objectName='").append(objectName).append('\'');
        sb.append(", key='").append(key).append('\'');
        sb.append(", Description='").append(Description).append('\'');
        sb.append(", bigDecimalValue=").append(bigDecimalValue);
        sb.append(", longValue=").append(longValue);
        sb.append(", doubleValue=").append(doubleValue);
        sb.append('}');
        return sb.toString();
    }
}
