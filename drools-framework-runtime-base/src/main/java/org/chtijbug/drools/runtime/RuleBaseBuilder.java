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
package org.chtijbug.drools.runtime;

import org.chtijbug.drools.runtime.impl.RuleBaseCommandSingleton;
import org.chtijbug.drools.runtime.impl.RuleBaseSingleton;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.chtijbug.drools.runtime.resource.FileKnowledgeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nheron
 */
public abstract class RuleBaseBuilder {
    /**
     * Class Logger
     */
    private static Logger logger = LoggerFactory.getLogger(RuleBaseBuilder.class);

    public static RuleBasePackage createRemoteStandardRestBasePackage(String containerId, String url,String username,String password) throws DroolsChtijbugException {
        logger.debug(">> createWorkbenchRuleBasePackage()");
        RuleBaseCommandSingleton newRuleBasePackage = new RuleBaseCommandSingleton(RuleBaseSingleton.DEFAULT_RULE_THRESHOLD,containerId,url,username,password);
        try {
            newRuleBasePackage.connectKBase();
            //_____ Returning the result
            return newRuleBasePackage;
        } finally {
            logger.debug("<< createWorkbenchRuleBasePackage", newRuleBasePackage);
        }
    }


    public static RuleBasePackage createWorkbenchRuleBasePackage(Long ruleBaseId, HistoryListener historyListener, String groupId, String artifactId, String version, String workbenchUrl, String username, String password) throws DroolsChtijbugException {
        logger.debug(">> createWorkbenchRuleBasePackage()");
        RuleBaseSingleton newRuleBasePackage = new RuleBaseSingleton(ruleBaseId, RuleBaseSingleton.DEFAULT_RULE_THRESHOLD, historyListener, groupId, artifactId, version);
        try {
            newRuleBasePackage.createKBase(workbenchUrl, username, password);
            //_____ Returning the result
            return newRuleBasePackage;
        } finally {
            logger.debug("<< createWorkbenchRuleBasePackage", newRuleBasePackage);
        }
    }

    public static RuleBasePackage createRuleBasePackage(Long ruleBaseId, String modulePackage, String moduleName, String version, String... files) throws DroolsChtijbugException {
        return RuleBaseBuilder.createRuleBasePackage(ruleBaseId, null, modulePackage, moduleName, version, files);
    }

    public static RuleBasePackage createRuleBasePackage(Long ruleBaseId, HistoryListener historyListener, String groupId, String artifactId, String version, String... files) throws DroolsChtijbugException {
        logger.debug(">>createRuleBasePackage");
        List<FileKnowledgeResource> fileKnowledgeResources = new ArrayList<>();
        for (String s : files) {
            if (s.contains("bpmn2")) {
                FileKnowledgeResource fileKnowledgeResource = FileKnowledgeResource.createBPMN2ClassPathResource(s);
                fileKnowledgeResources.add(fileKnowledgeResource);

            } else {
                FileKnowledgeResource fileKnowledgeResource = FileKnowledgeResource.createDRLClassPathResource(s);
                fileKnowledgeResources.add(fileKnowledgeResource);
            }

        }
        RuleBaseSingleton ruleBasePackage = new RuleBaseSingleton(ruleBaseId, RuleBaseSingleton.DEFAULT_RULE_THRESHOLD, historyListener, artifactId, groupId, version);
        try {
            ruleBasePackage.createKBase(fileKnowledgeResources);
            //_____ Returning the result
            return ruleBasePackage;
        } finally {
            logger.debug("<<createRuleBasePackage", ruleBasePackage);
        }
    }

    public static RuleBasePackage createRuleBasePackage(Long ruleBaseId, HistoryListener historyListener, ClassLoader... classLoader) throws DroolsChtijbugException {
        logger.debug(">>createRuleBasePackage");

        RuleBaseSingleton ruleBasePackage = new RuleBaseSingleton(ruleBaseId, RuleBaseSingleton.DEFAULT_RULE_THRESHOLD, historyListener);
        try {
            ruleBasePackage.createKBase(classLoader);
            //_____ Returning the result
            return ruleBasePackage;
        } finally {
            logger.debug("<<createRuleBasePackage", ruleBasePackage);
        }
    }

    public static RuleBasePackage createRuleBasePackage(String rulebaseName, HistoryListener historyListener, ClassLoader... classLoader) throws DroolsChtijbugException {
        logger.debug(">>createRuleBasePackage");

        RuleBaseSingleton ruleBasePackage = new RuleBaseSingleton(rulebaseName, RuleBaseSingleton.DEFAULT_RULE_THRESHOLD, historyListener);
        try {
            ruleBasePackage.createKBase(classLoader);
            //_____ Returning the result
            return ruleBasePackage;
        } finally {
            logger.debug("<<createRuleBasePackage", ruleBasePackage);
        }
    }

}
