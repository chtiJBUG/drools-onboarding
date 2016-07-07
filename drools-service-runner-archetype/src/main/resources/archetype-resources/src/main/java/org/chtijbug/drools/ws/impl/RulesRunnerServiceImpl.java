#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.chtijbug.drools.ws.impl;

import org.chtijbug.drools.common.log.Logger;
import org.chtijbug.drools.common.log.LoggerFactory;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.ws.RulesRunnerService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 14/09/12
 * Time: 08:52
 */
@WebService(endpointInterface = "org.chtijbug.drools.ws.RulesRunnerService")
@Service(value = "ruleRunnerService")
public class RulesRunnerServiceImpl implements RulesRunnerService, InitializingBean {
    /** Class Logger */
    private static final Logger logger = LoggerFactory.getLogger(RulesRunnerServiceImpl.class);
    /** ChtiJBug Rule base package */
    private RuleBasePackage ruleBasePackage = null;
    /** The Rule Engine configuration, which contains connexion data to guvnor app */
    @Autowired
    private RuleEngineConfig config;

    @Override
    public ${decision-outputClass}  executeProcess(${decision-inputClass} input, String processName) {
        logger.entry("executeProcess", input, processName);
        try {
            fireAllRules(input, processName);
        } catch (Exception e) {
            logger.error("Error while firing all rules");
            logger.error("caused by :", e);
        } finally {
            logger.exit("executeProcess", input);
        }
        // At the end of the execution, the input should be updated through the rules engine
        return input;
    }


    public ${decision-outputClass}  executeRuleEngine(${decision-inputClass} input) {
        logger.entry("executeRuleEngine", input);
        try {
            fireAllRules(input, null);
        } catch (Exception e) {
            logger.error("Error while firing all rules");
            logger.error("caused by :", e);
        } finally {
            logger.exit("executeProcess", input);
        }
        // At the end of the execution, the input should be updated through the rules engine
        return input;
    }

    private void fireAllRules(${decision-inputClass} input, String processName) throws Exception {
        RuleBaseSession session = this.ruleBasePackage.createRuleBaseSession();
        session.insertByReflection(input);
        if (processName != null) {
            session.startProcess(processName);
        }
        session.fireAllRules();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //
        // TODO créer la Rule avec les paramètres (Avoir une conf par défaut + 1 autre externe à l'appli
        //
        ruleBasePackage = RuleBaseBuilder.createGuvnorRuleBasePackage(
                config.getHost(),
                config.getApp(),
                config.getPackageName(),
                config.getVersion(),
                config.getUser(),
                config.getPassword());
    }

}
