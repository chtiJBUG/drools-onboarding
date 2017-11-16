/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.chtijbug.kieserver.services.drools;

import org.chtijbug.drools.kieserver.extension.*;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.impl.RuleBaseSingleton;
import org.chtijbug.kieserver.services.runtimeevent.MessageHandlerResolver;
import org.chtijbug.kieserver.services.runtimeevent.SessionContext;
import org.kie.api.runtime.KieContainer;
import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.api.KieServerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Direct rules execution service that allow use of typed objects instead of string only
 */
public class DroolsFrameworkRulesExecutionService {
    private static final Logger logger = LoggerFactory.getLogger(DroolsFrameworkRulesExecutionService.class);

    private KieServerRegistry context;
    private RuleBasePackage ruleBasePackage = null;
    private MessageHandlerResolver messageHandlerResolver;
    private int MaxNumberRulesToExecute = 20000;
    private KieServerAddOnElement kieServerAddOnElement = null;

    public DroolsFrameworkRulesExecutionService(KieServerRegistry context, KieServerAddOnElement kieServerAddOnElement) {
        this.context = context;
        this.messageHandlerResolver = new MessageHandlerResolver();
        this.kieServerAddOnElement = kieServerAddOnElement;
    }


    public KieServerRegistry getContext() {
        return context;
    }


    public ChtijbugObjectRequest FireAllRulesAndStartProcess(KieContainerInstance kci, ChtijbugObjectRequest chtijbugObjectRequest, String processID, int sessionMaxNumberRulesToExecute) {
        return this.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, processID, null, sessionMaxNumberRulesToExecute);
    }

    public ChtijbugObjectRequest FireAllRulesAndStartProcess(KieContainerInstance kci, ChtijbugObjectRequest chtijbugObjectRequest, String processID) {
        return this.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, processID, null);
    }

    public KieServerAddOnElement getKieServerAddOnElement() {
        return kieServerAddOnElement;
    }

    public ChtijbugObjectRequest FireAllRulesAndStartProcess(KieContainerInstance kci, ChtijbugObjectRequest chtijbugObjectRequest, String processID, String sessionName, int sessionMaxNumberRulesToExecute) {

        Object result = null;
        try {

            if (kci != null
                    && kci.getKieContainer() != null
                    && ruleBasePackage == null) {

                KieContainer kieContainer = kci.getKieContainer();
                ruleBasePackage = new RuleBaseSingleton(kieContainer, sessionMaxNumberRulesToExecute, kieServerAddOnElement);
                if (kieServerAddOnElement != null) {
                    for (KieServerAsyncCallBack kieServerAsyncCallBack : kieServerAddOnElement.getKieServerAsyncCallBacks()) {
                        kieServerAsyncCallBack.OnCreateKieBase();
                    }
                    for (KieServerGlobalVariableDefinition kieServerGlobalVariableDefinition : kieServerAddOnElement.getKieServerGlobalVariableDefinitions()) {
                        kieServerGlobalVariableDefinition.OnCreateKieBase(kieServerAddOnElement.getGlobals());
                    }
                    for (KieServerListenerDefinition kieServerListenerDefinition : kieServerAddOnElement.getKieServerListenerDefinitions()) {
                        kieServerListenerDefinition.OnCreateKieBase();
                    }
                    for (KieServerLoggingDefinition kieServerLoggingDefinition : kieServerAddOnElement.getKieServerLoggingDefinitions()) {
                        kieServerLoggingDefinition.OnCreateKieBase();
                    }
                }

            }
            ChtijbugHistoryListener chtijbugHistoryListener = new ChtijbugHistoryListener();
            RuleBaseSession session = ruleBasePackage.createRuleBaseSession(sessionMaxNumberRulesToExecute, chtijbugHistoryListener, sessionName);
            if (kieServerAddOnElement != null) {

                for (KieServerListenerDefinition kieServerListenerDefinition : kieServerAddOnElement.getKieServerListenerDefinitions()) {
                    kieServerListenerDefinition.OnCreateKieSession(session.getKnowledgeSession());
                }
                for (String globalVariableName : kieServerAddOnElement.getGlobals().keySet()) {
                    session.setGlobal(globalVariableName, kieServerAddOnElement.getGlobals().get(globalVariableName));
                }

            }
            result = session.fireAllRulesAndStartProcess(chtijbugObjectRequest.getObjectRequest(), processID);
            SessionContext sessionContext = this.messageHandlerResolver.getSessionFromHistoryEvent(chtijbugHistoryListener.getHistoryEventLinkedList());
            chtijbugObjectRequest.setSessionLogging(sessionContext);
            chtijbugObjectRequest.setObjectRequest(result);
            logger.debug("Returning OK response with content '{}'", chtijbugObjectRequest.getObjectRequest());
            session.dispose();
            return chtijbugObjectRequest;

        } catch (DroolsChtijbugException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("Unable to execute command " + chtijbugObjectRequest.getObjectRequest());

    }

    public ChtijbugObjectRequest FireAllRulesAndStartProcess(KieContainerInstance kci, ChtijbugObjectRequest chtijbugObjectRequest, String processID, String sessionName) {

        return this.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, processID, sessionName, this.MaxNumberRulesToExecute);
    }
}
