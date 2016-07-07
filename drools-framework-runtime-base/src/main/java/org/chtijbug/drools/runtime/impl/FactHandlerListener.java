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
package org.chtijbug.drools.runtime.impl;

import org.chtijbug.drools.entity.DroolsFactObject;
import org.chtijbug.drools.entity.history.fact.DeletedFactHistoryEvent;
import org.chtijbug.drools.entity.history.fact.FactHistoryEvent;
import org.chtijbug.drools.entity.history.fact.InsertedFactHistoryEvent;
import org.chtijbug.drools.entity.history.fact.UpdatedFactHistoryEvent;
import org.chtijbug.drools.runtime.DroolsFactObjectFactory;
import org.drools.core.definitions.rule.impl.RuleImpl;
import org.drools.core.event.rule.impl.RuleRuntimeEventImpl;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.PropagationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactHandlerListener implements RuleRuntimeEventListener {

    private static Logger logger = LoggerFactory.getLogger(FactHandlerListener.class);
    private final RuleBaseStatefulSession ruleBaseSession;

    public FactHandlerListener(RuleBaseStatefulSession ruleBaseSession) {
        this.ruleBaseSession = ruleBaseSession;
    }

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        logger.debug(">>objectInserted", event);
        try {
            //____ Updating reference into the facts map from knowledge Session
            //((RuleTerminalNode)((RuleTerminalNodeLeftTuple)((org.drools.common.DefaultFactHandle)event.getFactHandle()).getFirstLeftTuple()).getSink()).getRule().getRuleFlowGroup()
            FactHandle f = event.getFactHandle();
            Object newObject = event.getObject();
            DroolsFactObject ff = DroolsFactObjectFactory.createFactObject(newObject);
            ruleBaseSession.setData(f, newObject, ff);
            //____ Adding the Insert Event from the History Container
            InsertedFactHistoryEvent insertFactHistoryEvent = new InsertedFactHistoryEvent(this.ruleBaseSession.nextEventId(), ff, this.ruleBaseSession.getRuleBaseID(), this.ruleBaseSession.getSessionId());
            if (insertFactHistoryEvent.getRuleName() == null && event instanceof RuleRuntimeEventImpl) {
                PropagationContext propagationContext = ((RuleRuntimeEventImpl) event).getPropagationContext();
                this.updateRuleDetailFromPropagationContext(propagationContext, insertFactHistoryEvent);

            }
            this.ruleBaseSession.addHistoryElement(insertFactHistoryEvent);
        } finally

        {
            logger.debug("<<objectInserted");
        }

    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        logger.debug(">>objectUpdated", event);
        try {
            //____ Updating FactHandle Object reference from the knwoledge session
            FactHandle f = event.getFactHandle();
            Object oldValue = event.getOldObject();
            Object newValue = event.getObject();

            DroolsFactObject factOldValue = this.ruleBaseSession.getLastFactObjectVersion(oldValue);
            DroolsFactObject factNewValue = DroolsFactObjectFactory.createFactObject(newValue, factOldValue.getNextObjectVersion());
            ruleBaseSession.setData(f, newValue, factNewValue);
            //____ Adding the Update Event from the History Container
            UpdatedFactHistoryEvent updatedFactHistoryEvent = new UpdatedFactHistoryEvent(this.ruleBaseSession.nextEventId(), factOldValue, factNewValue, this.ruleBaseSession.getRuleBaseID(), this.ruleBaseSession.getSessionId());
            if (updatedFactHistoryEvent.getRuleName() == null && event instanceof RuleRuntimeEventImpl) {
                PropagationContext propagationContext = ((RuleRuntimeEventImpl) event).getPropagationContext();
                this.updateRuleDetailFromPropagationContext(propagationContext, updatedFactHistoryEvent);
            }
            this.ruleBaseSession.addHistoryElement(updatedFactHistoryEvent);
        } finally {
            logger.debug("<<objectUpdated");
        }
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        logger.debug(">>objectRetracted", event);
        try {
            //____ Removing FactHandle from the KnowledgeBase
            FactHandle f = event.getFactHandle();
            Object newObject = event.getOldObject();
            DroolsFactObject deletedFact = this.ruleBaseSession.getLastFactObjectVersion(newObject);
            ruleBaseSession.unsetData(f, newObject);
            //____ Adding a Delete Event from the HistoryContainer

            DeletedFactHistoryEvent deleteFactEvent = new DeletedFactHistoryEvent(this.ruleBaseSession.nextEventId(), deletedFact, this.ruleBaseSession.getRuleBaseID(), this.ruleBaseSession.getSessionId());
            if (event instanceof RuleRuntimeEventImpl) {
                PropagationContext propagationContext = ((RuleRuntimeEventImpl) event).getPropagationContext();
                this.updateRuleDetailFromPropagationContext(propagationContext, deleteFactEvent);
                this.ruleBaseSession.addHistoryElement(deleteFactEvent);
            }
        } finally {
            logger.debug("<<objectRetracted");
        }
    }

    private void updateRuleDetailFromPropagationContext(PropagationContext propagationContext, FactHistoryEvent historyEvent) {
        if (propagationContext.getRule() instanceof RuleImpl) {
            RuleImpl ruleOrigin = (RuleImpl) propagationContext.getRule();
            historyEvent.setRuleName(ruleOrigin.getName());
            historyEvent.setRulePackageName(ruleOrigin.getPackageName());
            historyEvent.setRuleflowGroup(ruleOrigin.getRuleFlowGroup());
        }
    }
}