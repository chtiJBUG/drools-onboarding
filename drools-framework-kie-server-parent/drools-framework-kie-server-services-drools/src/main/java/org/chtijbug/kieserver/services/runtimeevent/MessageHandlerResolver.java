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
package org.chtijbug.kieserver.services.runtimeevent;

import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.kieserver.services.runtimeevent.impl.fact.*;
import org.chtijbug.kieserver.services.runtimeevent.impl.knowledgeSession.*;
import org.chtijbug.kieserver.services.runtimeevent.impl.process.*;
import org.chtijbug.kieserver.services.runtimeevent.impl.rule.AfterRuleFiredEventStrategy;
import org.chtijbug.kieserver.services.runtimeevent.impl.rule.AfterRuleflowGroupActivatedEventStrategy;
import org.chtijbug.kieserver.services.runtimeevent.impl.rule.AfterRuleflowGroupDeactivatedEventStrategy;
import org.chtijbug.kieserver.services.runtimeevent.impl.rule.BeforeRuleFiredEventStrategy;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class MessageHandlerResolver {


    @Resource
    private List<AbstractMemoryEventHandlerStrategy> allMemoryStrategies = new ArrayList<>();

    public MessageHandlerResolver() {
        allMemoryStrategies.add(new DeleteFactEventStrategy());
        allMemoryStrategies.add(new InsertedByRelectionFactEndEventStrategy());
        allMemoryStrategies.add(new InsertedByRelectionFactStartEventStrategy());
        allMemoryStrategies.add(new InsertedFactEventStrategy());
        allMemoryStrategies.add(new UpdatedFactEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionCreateEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionDisposeEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionFireAllRulesAndStartProcessEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionFireAllRulesBeginEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionFireAllRulesEndEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionFireAllRulesMaxRulesEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionProcessBeginEventStrategy());
        allMemoryStrategies.add(new KnowledgeSessionProcessEndEventStrategy());
        allMemoryStrategies.add(new AfterNodeInstanceTriggeredEventStrategy());
        allMemoryStrategies.add(new AfterNodeLeftEventStrategy());
        allMemoryStrategies.add(new AfterProcessEndHistoryEventStrategy());
        allMemoryStrategies.add(new AfterProcessStartEventStrategy());
        allMemoryStrategies.add(new AfterVariableChangeEventStrategy());
        allMemoryStrategies.add(new BeforeNodeInstanceTriggeredEventStrategy());
        allMemoryStrategies.add(new BeforeNodeLeftEventStrategy());
        allMemoryStrategies.add(new BeforeProcessEndEventStrategy());
        allMemoryStrategies.add(new BeforeProcessStartEventStrategy());
        allMemoryStrategies.add(new BeforeVariableChangeEventStrategy());
        allMemoryStrategies.add(new AfterRuleFiredEventStrategy());
        allMemoryStrategies.add(new AfterRuleflowGroupActivatedEventStrategy());
        allMemoryStrategies.add(new AfterRuleflowGroupDeactivatedEventStrategy());
        allMemoryStrategies.add(new BeforeRuleFiredEventStrategy());


    }

    public SessionContext getSessionFromHistoryEvent(List<HistoryEvent> historyEvents) {
        SessionContext sessionContext = new SessionContext();
        for (HistoryEvent historyEvent : historyEvents) {
            AbstractMemoryEventHandlerStrategy strategy = this.resolveMessageHandlerMemory(historyEvent);
            if (strategy != null) {
                strategy.handleMessageInternally(historyEvent, sessionContext);
            }
        }
        return sessionContext;
    }

    public AbstractMemoryEventHandlerStrategy resolveMessageHandlerMemory(HistoryEvent historyEvent) {
        for (AbstractMemoryEventHandlerStrategy strategy : allMemoryStrategies) {
            if (strategy.isEventSupported(historyEvent))
                return strategy;
        }
        return null;
    }
}
