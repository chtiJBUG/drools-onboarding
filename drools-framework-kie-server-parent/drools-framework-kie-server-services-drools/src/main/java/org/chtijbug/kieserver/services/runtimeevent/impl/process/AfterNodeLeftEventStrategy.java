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
package org.chtijbug.kieserver.services.runtimeevent.impl.process;

import org.chtijbug.drools.entity.DroolsNodeType;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.process.AfterNodeLeftHistoryEvent;
import org.chtijbug.drools.logging.RuleflowGroup;
import org.chtijbug.drools.logging.RuleflowGroupStatus;
import org.chtijbug.kieserver.services.runtimeevent.AbstractMemoryEventHandlerStrategy;
import org.chtijbug.kieserver.services.runtimeevent.SessionContext;

public class AfterNodeLeftEventStrategy implements AbstractMemoryEventHandlerStrategy {

    @Override
    public void handleMessageInternally(HistoryEvent historyEvent, SessionContext sessionContext) {
        AfterNodeLeftHistoryEvent afterNodeLeftHistoryEvent = (AfterNodeLeftHistoryEvent) historyEvent;
        if (afterNodeLeftHistoryEvent.getNodeInstance().getNode().getNodeType() == DroolsNodeType.RuleNode) {
            String ruleFlowName = afterNodeLeftHistoryEvent.getNodeInstance().getNode().getRuleflowGroupName();
            RuleflowGroup ruleflowGroup = sessionContext.findRuleFlowGroup(ruleFlowName);
            ruleflowGroup.setEndDate(afterNodeLeftHistoryEvent.getDateEvent());
            ruleflowGroup.setStopEventID(afterNodeLeftHistoryEvent.getEventID());
            ruleflowGroup.setRuleflowGroupStatus(RuleflowGroupStatus.STOPPED);
        }

    }

    @Override
    public boolean isEventSupported(HistoryEvent historyEvent) {

        return historyEvent instanceof AfterNodeLeftHistoryEvent;
    }

}
