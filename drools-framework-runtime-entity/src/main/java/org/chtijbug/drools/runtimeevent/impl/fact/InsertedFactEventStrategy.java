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
package org.chtijbug.drools.runtimeevent.impl.fact;

import org.chtijbug.drools.SessionContext;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.fact.InsertedFactHistoryEvent;
import org.chtijbug.drools.logging.Fact;
import org.chtijbug.drools.logging.FactType;
import org.chtijbug.drools.logging.RuleExecution;
import org.chtijbug.drools.logging.SessionExecution;
import org.chtijbug.drools.runtimeevent.AbstractMemoryEventHandlerStrategy;


public class InsertedFactEventStrategy implements AbstractMemoryEventHandlerStrategy {

    @Override
    public void handleMessageInternally(HistoryEvent historyEvent, SessionContext sessionContext) {
        InsertedFactHistoryEvent insertedFactHistoryEvent = (InsertedFactHistoryEvent) historyEvent;
        Fact fact = new Fact();
        fact.setFullClassName(insertedFactHistoryEvent.getInsertedObject().getFullClassName());
        fact.setObjectVersion(insertedFactHistoryEvent.getInsertedObject().getObjectVersion());
        fact.setRealFact(insertedFactHistoryEvent.getInsertedObject().getRealObject());
        fact.setModificationDate(insertedFactHistoryEvent.getDateEvent());
        fact.setFactType(FactType.INSERTED);
        RuleExecution existingInSessionRuleExecution = null;
        if (insertedFactHistoryEvent.getRuleName() == null) {  // inserted from a session
            SessionExecution sessionExecution = sessionContext.getSessionExecution();
            sessionExecution.getFacts().add(fact);

        } else {   // inserted from a rule that is not in a ruleflow/process
            existingInSessionRuleExecution = sessionContext.getRuleExecution();
            existingInSessionRuleExecution.getThenFacts().add(fact);
        }

    }

    @Override
    public boolean isEventSupported(HistoryEvent historyEvent) {

        return historyEvent instanceof InsertedFactHistoryEvent;
    }

}
