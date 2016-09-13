package org.chtijbug.drools.carinsurance.model;

/**
 * Created by nheron on 12/09/2016.
 */
public class Rule {
    private RuleLevel ruleLevel;
    private String ruleName;
    private String description;
    private String value;

    public RuleLevel getRuleLevel() {
        return ruleLevel;
    }

    public void setRuleLevel(RuleLevel ruleLevel) {
        this.ruleLevel = ruleLevel;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
