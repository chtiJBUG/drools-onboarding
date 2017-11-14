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

import org.chtijbug.drools.entity.history.EventCounter;
import org.chtijbug.drools.entity.history.knowledge.*;
import org.chtijbug.drools.kieserver.extension.KieServerGlobalVariableDefinition;
import org.chtijbug.drools.kieserver.extension.KieServerListenerDefinition;
import org.chtijbug.drools.kieserver.extension.KieServerLoggingDefinition;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.chtijbug.drools.runtime.resource.FileKnowledgeResource;
import org.chtijbug.drools.runtime.resource.KnowledgeModule;
import org.chtijbug.drools.runtime.resource.WorkbenchClient;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Semaphore;

import static com.google.common.base.Throwables.propagate;

/**
 * @author Bertrand Gressier
 */
public class RuleBaseSingleton implements RuleBasePackage {
    /**
     * default rule threshold
     */
    public static int DEFAULT_RULE_THRESHOLD = 2000;
    /**
     * Class Logger
     */
    private static Logger logger = LoggerFactory.getLogger(RuleBaseSingleton.class);
    /**
     * unique ID of the RuleBase in the JVM
     */
    protected EventCounter eventCounter = EventCounter.newCounter();
    protected EventCounter sessionCounter = EventCounter.newCounter();
    /**
     * Rule Base ID
     */
    private Long ruleBaseID;
    private KieContainer kieContainer;
    private ReleaseId releaseId;
    private String groupId;
    private String artifactId;
    private String version;
    private KnowledgeModule knowledgeModule;
    /**
     * Max rule to be fired threshold.
     */
    private int maxNumberRuleToExecute = DEFAULT_RULE_THRESHOLD;
    /**
     * Semaphore used to void concurrent access to the singleton
     */
    private Semaphore lockKbase = new Semaphore(1);
    /**
     * History Listener
     */
    private HistoryListener historyListener = null;
    /**
     * Global Maps
     */
    Map<String, Object> globals = new HashMap<>();
    /**
     * extensions Points
     */
    private List<KieServerGlobalVariableDefinition> kieServerGlobalVariableDefinitions = new ArrayList<>();
    private List<KieServerLoggingDefinition> kieServerLoggingDefinitions = new ArrayList<>();
    private List<KieServerListenerDefinition> kieServerListenerDefinitions = new ArrayList<>();
    private Reflections reflections = null;

    /**
     * @param kieContainer
     * @param maxNumberRulesToExecute
     */

    public RuleBaseSingleton(KieContainer kieContainer, int maxNumberRulesToExecute) {
        this.kieContainer = kieContainer;
        this.maxNumberRuleToExecute = maxNumberRulesToExecute;
        initExtensionsList();
    }

    public RuleBaseSingleton(KieContainer kieContainer, int maxNumberRulesToExecute, Reflections reflections) {
        this.reflections = reflections;
        this.kieContainer = kieContainer;
        this.maxNumberRuleToExecute = maxNumberRulesToExecute;
        initExtensionsList();
    }

    public RuleBaseSingleton(KieContainer kieContainer, int maxNumberRulesToExecute, HistoryListener historyListener) {
        this.kieContainer = kieContainer;
        this.maxNumberRuleToExecute = maxNumberRulesToExecute;
        this.historyListener = historyListener;

        initExtensionsList();
    }

    public RuleBaseSingleton(Long ruleBaseID, int maxNumberRulesToExecute, HistoryListener historyListener, String groupId, String artifactId, String version) throws DroolsChtijbugException {
        this.ruleBaseID = ruleBaseID;
        this.maxNumberRuleToExecute = maxNumberRulesToExecute;
        this.historyListener = historyListener;
        if (this.historyListener != null) {
            KnowledgeBaseCreatedEvent knowledgeBaseCreatedEvent = new KnowledgeBaseCreatedEvent(eventCounter.next(), new Date(), ruleBaseID);
            this.historyListener.fireEvent(knowledgeBaseCreatedEvent);
        }
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.knowledgeModule = new KnowledgeModule(this.ruleBaseID, this.historyListener, groupId, artifactId, version, eventCounter);

        initExtensionsList();
    }

    private void initExtensionsList() {


        if (reflections != null) {
            Set<Class<? extends KieServerGlobalVariableDefinition>> classes1 = reflections.getSubTypesOf(KieServerGlobalVariableDefinition.class);
            for (Class<? extends KieServerGlobalVariableDefinition> classeA : classes1) {
                try {
                    KieServerGlobalVariableDefinition newElement = classeA.newInstance();
                    kieServerGlobalVariableDefinitions.add(newElement);
                } catch (InstantiationException e) {
                    logger.error("initExtensionsList.KieServerGlobalVariableDefinition.InstantiationException", e);

                } catch (IllegalAccessException e) {
                    logger.error("initExtensionsList.KieServerGlobalVariableDefinition.IllegalAccessException", e);
                }


            }
            Set<Class<? extends KieServerLoggingDefinition>> classes2 = reflections.getSubTypesOf(KieServerLoggingDefinition.class);
            for (Class<? extends KieServerLoggingDefinition> classeA : classes2) {

                try {
                    KieServerLoggingDefinition newElement = classeA.newInstance();
                    kieServerLoggingDefinitions.add(newElement);
                } catch (InstantiationException e) {
                    logger.error("initExtensionsList.KieServerLoggingDefinition.InstantiationException", e);

                } catch (IllegalAccessException e) {
                    logger.error("initExtensionsList.KieServerLoggingDefinition.IllegalAccessException", e);
                }

            }
            Set<Class<? extends KieServerListenerDefinition>> classes3 = reflections.getSubTypesOf(KieServerListenerDefinition.class);
            for (Class<? extends KieServerListenerDefinition> classeA : classes3) {
                try {
                    KieServerListenerDefinition newElement = classeA.newInstance();
                    kieServerListenerDefinitions.add(newElement);
                } catch (InstantiationException e) {
                    logger.error("initExtensionsList.KieServerListenerDefinition.InstantiationException", e);

                } catch (IllegalAccessException e) {
                    logger.error("initExtensionsList.KieServerListenerDefinition.IllegalAccessException", e);
                }

            }
        }
    }

    public RuleBaseSingleton(Long ruleBaseID, int maxNumberRulesToExecute, HistoryListener historyListener) throws DroolsChtijbugException {
        this.ruleBaseID = ruleBaseID;
        this.maxNumberRuleToExecute = maxNumberRulesToExecute;
        this.historyListener = historyListener;
        if (this.historyListener != null) {
            KnowledgeBaseCreatedEvent knowledgeBaseCreatedEvent = new KnowledgeBaseCreatedEvent(eventCounter.next(), new Date(), ruleBaseID);
            this.historyListener.fireEvent(knowledgeBaseCreatedEvent);
        }
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.knowledgeModule = new KnowledgeModule(this.ruleBaseID, this.historyListener, eventCounter);
    }

    @Override
    public RuleBaseSession createRuleBaseSession() throws DroolsChtijbugException {
        logger.debug(">>createRuleBaseSession");
        try {
            //____ Creating new Rule Base Session using default rule threshold
            return this.createRuleBaseSession(this.maxNumberRuleToExecute);
        } finally {
            logger.debug("<<createRuleBaseSession");
        }
    }

    @Override
    public RuleBaseSession createRuleBaseSession(int maxNumberRulesToExecute) throws DroolsChtijbugException {
        return this.createRuleBaseSession(maxNumberRulesToExecute, this.historyListener);
    }


    @Override
    public RuleBaseSession createRuleBaseSession(int maxNumberRulesToExecute, HistoryListener sessionHistoryListener) throws DroolsChtijbugException {
        return this.createRuleBaseSession(maxNumberRulesToExecute, sessionHistoryListener, null);
    }

    @Override
    public RuleBaseSession createRuleBaseSession(int maxNumberRulesToExecute, HistoryListener sessionHistoryListener, String sessionName) throws DroolsChtijbugException {
        logger.debug(">>createRuleBaseSession", maxNumberRulesToExecute);
        RuleBaseSession newRuleBaseSession = null;
        try {
            if (kieContainer != null) {
                //____ Acquire semaphore
                try {
                    lockKbase.acquire();
                } catch (Exception e) {
                    throw new DroolsChtijbugException(DroolsChtijbugException.KbaseAcquire, "", e);
                }
                //_____ Now we can create a new stateful session using KnowledgeBase
                //_____ Now we can create a new stateful session using KnowledgeBase
                KieSession newDroolsSession = null;
                if (sessionName == null) {
                    newDroolsSession = this.kieContainer.newKieSession();
                } else {
                    newDroolsSession = this.kieContainer.newKieSession(sessionName);
                }
                for (String globalVariableName : globals.keySet()) {
                    if (globals.get(globalVariableName) != null) {
                        newDroolsSession.setGlobal(globalVariableName, globals.get(globalVariableName));
                    }
                }
                Long sessionId = this.sessionCounter.next();
                if (sessionHistoryListener != null) {
                    KnowledgeBaseCreateSessionEvent knowledgeBaseCreateSessionEvent = new KnowledgeBaseCreateSessionEvent(eventCounter.next(), new Date(), this.ruleBaseID);
                    knowledgeBaseCreateSessionEvent.setSessionId(sessionId);
                    sessionHistoryListener.fireEvent(knowledgeBaseCreateSessionEvent);
                }

                //_____ Wrapping the knowledge Session
                newRuleBaseSession = new RuleBaseStatefulSession(this.ruleBaseID, sessionId, newDroolsSession, maxNumberRulesToExecute, sessionHistoryListener);
                //_____ Release semaphore
                lockKbase.release();
            } else {
                throw new DroolsChtijbugException(DroolsChtijbugException.KbaseNotInitialised, "", null);
            }
            //____ return the wrapped KnowledgeSession
            return newRuleBaseSession;
        } finally {
            logger.debug("<<createRuleBaseSession", newRuleBaseSession);
        }
    }

    public synchronized void createKBase(String workbenchUrl, String username, String password) throws DroolsChtijbugException {
        if (kieContainer != null) {
            if (this.historyListener != null) {
                this.historyListener.fireEvent(new KnowledgeBaseReloadedEvent(eventCounter.next(), new Date(), this.ruleBaseID));
            }
            // TODO dispose all elements
        } else {
            if (this.historyListener != null) {
                this.historyListener.fireEvent(new KnowledgeBaseInitialLoadEvent(eventCounter.next(), new Date(), this.ruleBaseID));
            }
        }
        try {
            //___ TODO add URI Resource
            this.knowledgeModule.addWorkbenchResource(workbenchUrl, username, password);
            kieContainer = this.knowledgeModule.build();
        } catch (Exception e) {
            logger.error("error to load Agent", e);
            throw new DroolsChtijbugException(DroolsChtijbugException.ErrorToLoadAgent, "", e);
        }
    }

    @Override
    public void loadKBase(String version) throws DroolsChtijbugException {
        if (this.knowledgeModule.getWorkbenchClient() != null) {
            try {
                WorkbenchClient client = this.knowledgeModule.getWorkbenchClient();
                lockKbase.acquire();
                //this.releaseId = kieServices.newReleaseId(this.releaseId.getGroupId(), this.releaseId.getArtifactId(), version);
                this.version = version;

                kieContainer = null;
                this.knowledgeModule = null;
                this.knowledgeModule = new KnowledgeModule(this.ruleBaseID, this.historyListener, groupId, artifactId, version, eventCounter);
                this.createKBase(client.getWorkbenchUrl(), client.getUsername(), client.getPassword());


                lockKbase.release();
                if (this.historyListener != null) {
                    // TODO change the following event...
                    this.historyListener.fireEvent(new KnowledgeBaseAddResourceEvent(eventCounter.next(), new Date(), this.ruleBaseID));
                }
            } catch (InterruptedException e) {
                throw propagate(e);
            }
        }

    }

    @Override
    public HistoryListener getHistoryListener() {
        return historyListener;
    }

    public Long getRuleBaseID() {
        return ruleBaseID;
    }

    @Override
    public void dispose() {
        if (this.historyListener != null) {
            try {
                this.historyListener.fireEvent(new KnowledgeBaseDisposeEvent(eventCounter.next(), new Date(), this.ruleBaseID));
            } catch (DroolsChtijbugException e) {
                throw propagate(e);
            }
        }
        this.kieContainer = null;
    }


    public void createKBase(List<FileKnowledgeResource> files) {
        try {
            if (this.historyListener != null) {
                this.historyListener.fireEvent(new KnowledgeBaseInitialLoadEvent(eventCounter.next(), new Date(), this.ruleBaseID));
            }
            lockKbase.acquire();
            this.knowledgeModule.addAllFiles(files);
            kieContainer = this.knowledgeModule.build();
            lockKbase.release();
        } catch (InterruptedException | DroolsChtijbugException e) {
            propagate(e);
        }
    }

    public void createKBase() {
        try {
            if (this.historyListener != null) {
                this.historyListener.fireEvent(new KnowledgeBaseInitialLoadEvent(eventCounter.next(), new Date(), this.ruleBaseID));
            }
            lockKbase.acquire();

            kieContainer = this.knowledgeModule.buildFromClassPath();
            lockKbase.release();
        } catch (InterruptedException | DroolsChtijbugException e) {
            propagate(e);
        }
    }



}
