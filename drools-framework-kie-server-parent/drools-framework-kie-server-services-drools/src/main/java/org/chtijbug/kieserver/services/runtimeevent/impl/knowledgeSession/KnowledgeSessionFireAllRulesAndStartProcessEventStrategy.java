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
package org.chtijbug.kieserver.services.runtimeevent.impl.knowledgeSession;


import org.chtijbug.drools.entity.DroolsFactObject;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.session.SessionFireAllRulesAndStartProcess;
import org.chtijbug.drools.logging.Fact;
import org.chtijbug.drools.logging.FactType;
import org.chtijbug.drools.logging.SessionExecution;
import org.chtijbug.kieserver.services.runtimeevent.AbstractMemoryEventHandlerStrategy;
import org.chtijbug.kieserver.services.runtimeevent.SessionContext;

public class KnowledgeSessionFireAllRulesAndStartProcessEventStrategy implements AbstractMemoryEventHandlerStrategy {

    @Override
    public void handleMessageInternally(HistoryEvent historyEvent, SessionContext sessionContext) {
        SessionFireAllRulesAndStartProcess sessionFireAllRulesAndStartProcess = (SessionFireAllRulesAndStartProcess) historyEvent;
        SessionExecution existingSessionRutime = sessionContext.getSessionExecution();
        if (existingSessionRutime != null) {
            if (sessionFireAllRulesAndStartProcess.getInputObject() != null) {
                DroolsFactObject inputObject = sessionFireAllRulesAndStartProcess.getInputObject();
                Fact inputFact = new Fact();
                inputFact.setEventid(sessionFireAllRulesAndStartProcess.getEventID());
                inputFact.setFactType(FactType.INPUTDATA);
                inputFact.setFullClassName(inputObject.getFullClassName());
                inputFact.setRealFact(inputObject.getRealObject());
                inputFact.setModificationDate(sessionFireAllRulesAndStartProcess.getDateEvent());
                inputFact.setObjectVersion(inputObject.getObjectVersion());
                existingSessionRutime.getFacts().add(inputFact);
            }
            if (sessionFireAllRulesAndStartProcess.getOutputObject() != null) {
                DroolsFactObject outputObject = sessionFireAllRulesAndStartProcess.getOutputObject();
                Fact outputFact = new Fact();
                outputFact.setEventid(sessionFireAllRulesAndStartProcess.getEventID());
                outputFact.setFactType(FactType.OUTPUTDATA);
                outputFact.setFullClassName(outputObject.getFullClassName());
                outputFact.setRealFact(outputObject.getRealObject());
                outputFact.setModificationDate(sessionFireAllRulesAndStartProcess.getDateEvent());
                outputFact.setObjectVersion(outputObject.getObjectVersion());
                existingSessionRutime.getFacts().add(outputFact);
            }
        }

    }

    @Override
    public boolean isEventSupported(HistoryEvent historyEvent) {

        return historyEvent instanceof SessionFireAllRulesAndStartProcess;
    }

}
