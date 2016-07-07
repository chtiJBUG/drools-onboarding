package org.chtijbug.drools.runtime.impl;

import org.chtijbug.drools.entity.history.EventCounter;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * Created by nheron on 07/06/2016.
 */
public class RuleBaseCommandSingleton implements RuleBasePackage {
    /**
     * default rule threshold
     */
    public static int DEFAULT_RULE_THRESHOLD = 2000;
    /**
     * Class Logger
     */
    private static Logger logger = LoggerFactory.getLogger(RuleBaseCommandSingleton.class);
    /**
     * unique ID of the RuleBase in the JVM
     */
    protected EventCounter eventCounter = EventCounter.newCounter();
    protected EventCounter sessionCounter = EventCounter.newCounter();
    private int maxNumberRuleToExecute = DEFAULT_RULE_THRESHOLD;
    /**
     * Semaphore used to void concurrent access to the singleton
     */
    private Semaphore lockKbase = new Semaphore(1);
    /**
     * History Listener
     */
    private HistoryListener historyListener = null;
    private KieContainer kieContainer;
    private long ruleBaseid;

    public RuleBaseCommandSingleton(int maxNumberRuleToExecute) {
        this.maxNumberRuleToExecute = maxNumberRuleToExecute;
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
        logger.debug(">>createRuleBaseSession", maxNumberRulesToExecute);
        RuleBaseSession newRuleBaseSession = null;
        try {

            //_____ Wrapping the knowledge Session
            newRuleBaseSession = new RuleBaseCommandSession(maxNumberRulesToExecute);
            //_____ Release semaphore
            lockKbase.release();

            return newRuleBaseSession;
        } finally {
            logger.debug("<<createRuleBaseSession", newRuleBaseSession);
        }
    }

    @Override
    public void loadKBase(String version) throws DroolsChtijbugException {
        //
    }

    @Override
    public HistoryListener getHistoryListener() {
        return historyListener;
    }

    @Override
    public Long getRuleBaseID() {
        return this.ruleBaseid;
    }

    public void setRuleBaseid(long ruleBaseid) {
        this.ruleBaseid = ruleBaseid;
    }

    @Override
    public void dispose() {

    }
}
