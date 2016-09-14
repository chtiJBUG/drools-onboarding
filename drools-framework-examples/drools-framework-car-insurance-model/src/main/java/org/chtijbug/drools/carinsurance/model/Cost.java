package org.chtijbug.drools.carinsurance.model;

import java.math.BigDecimal;

/**
 * Created by nheron on 14/09/2016.
 */
public class Cost {

    private String key;

    private String description;

    private BigDecimal cost;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cost{");
        sb.append("key='").append(key).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}
