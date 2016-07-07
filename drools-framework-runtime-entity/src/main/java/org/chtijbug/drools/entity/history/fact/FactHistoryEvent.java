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
package org.chtijbug.drools.entity.history.fact;

import org.chtijbug.drools.entity.history.HistoryEvent;

import java.util.Date;

/**
 * @author nheron
 */
public abstract class FactHistoryEvent extends HistoryEvent {

    /**
     *
     */
    private static final long serialVersionUID = 5320437389177977457L;

    private String ruleName = null;
    private String rulePackageName = null;
    private String ruleflowGroup = null;

    /**
     * Mandatory for GWT Serialization
     */
    public FactHistoryEvent() {

    }

    public FactHistoryEvent(Long eventID, Date dateEvent, Long ruleBaseId, Long sessionId) {

        super(eventID, dateEvent, TypeEvent.Fact);
        this.setRuleBaseID(ruleBaseId);
        this.setSessionId(sessionId);
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRulePackageName() {
        return rulePackageName;
    }

    public void setRulePackageName(String rulePackageName) {
        this.rulePackageName = rulePackageName;
    }

    public String getRuleflowGroup() {
        return ruleflowGroup;
    }

    public void setRuleflowGroup(String ruleflowGroup) {
        this.ruleflowGroup = ruleflowGroup;
    }

    /*
          * (non-Javadoc)
          *
          * @see org.chtijbug.drools.entity.history.HistoryEvent#toString()
          */
    @Override
    public String toString() {
        return super.toString();
    }
}
