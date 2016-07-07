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

    public DroolsFrameworkRulesExecutionService(KieServerRegistry context) {
        this.context = context;
        this.messageHandlerResolver = new MessageHandlerResolver();
    }


    public KieServerRegistry getContext() {
        return context;
    }

    public ChtijbugObjectRequest FireAllRulesAndStartProcess(KieContainerInstance kci, ChtijbugObjectRequest chtijbugObjectRequest, String processID) {
        Object result = null;
        try {

            if (kci != null && kci.getKieContainer() != null) {

                KieContainer kieContainer = kci.getKieContainer();
                ruleBasePackage = new RuleBaseSingleton(kieContainer, 20000);
            }
            ChtijbugHistoryListener chtijbugHistoryListener = new ChtijbugHistoryListener();
            RuleBaseSession session = ruleBasePackage.createRuleBaseSession(20000, chtijbugHistoryListener);
            result = session.fireAllRulesAndStartProcess(chtijbugObjectRequest.getObjectRequest(), processID);
            SessionContext sessionContext = this.messageHandlerResolver.getSessionFromHistoryEvent(chtijbugHistoryListener.getHistoryEventLinkedList());
            chtijbugObjectRequest.setSessionLogging(sessionContext);
            chtijbugObjectRequest.setObjectRequest(result);
            logger.debug("Returning OK response with content '{}'", chtijbugObjectRequest.getObjectRequest());
            return chtijbugObjectRequest;

        } catch (DroolsChtijbugException e) {
            e.printStackTrace();
        }


        throw new IllegalStateException("Unable to execute command " + chtijbugObjectRequest.getObjectRequest());
    }
}
