package org.chtijbug.drools.runtime.impl;

import org.chtijbug.drools.entity.history.EventCounter;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
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
    private String containerId;
    private String url;
    private String username;
    private String password;
    private KieServicesClient kieServicesClient;

    public RuleBaseCommandSingleton(int maxNumberRuleToExecute) {
        this.maxNumberRuleToExecute = maxNumberRuleToExecute;
    }

    public RuleBaseCommandSingleton(int defaultRuleThreshold, String containerId,String url, String username, String password) {
        this(defaultRuleThreshold);
        this.containerId=containerId;
        this.url=url;
        this.username=username;
        this.password=password;
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
        return this.createRuleBaseSession(maxNumberRulesToExecute, null);
    }

    @Override
    public RuleBaseSession createRuleBaseSession(int maxNumberRulesToExecute, HistoryListener sessionHistoryListener) throws DroolsChtijbugException {
        logger.debug(">>createRuleBaseSession", maxNumberRulesToExecute);
        RuleBaseSession newRuleBaseSession = null;
        try {

            //_____ Wrapping the knowledge Session
            newRuleBaseSession = new RuleBaseCommandSession(maxNumberRulesToExecute,this.kieServicesClient,this.containerId);
            //_____ Release semaphore
            lockKbase.release();

            return newRuleBaseSession;
        } finally {
            logger.debug("<<createRuleBaseSession", newRuleBaseSession);
        }
    }

    @Override
    public RuleBaseSession createRuleBaseSession(int maxNumberRulesToExecute, HistoryListener sessionHistoryListener, String sessionName) throws DroolsChtijbugException {
        return this.createRuleBaseSession(maxNumberRulesToExecute, sessionHistoryListener);
    }

    @Override
    public void loadKBase(String version) throws DroolsChtijbugException {
        //
    }

    @Override
    public HistoryListener getHistoryListener() {
        return null;
    }

    @Override
    public Long getRuleBaseID() {
        return null;
    }


    @Override
    public void dispose() {

    }

    public void connectKBase() {
        KieServicesConfiguration config;
        config = KieServicesFactory.newRestConfiguration(url, username, password);
        MarshallingFormat marshallingFormat = MarshallingFormat.XSTREAM;
        config.setMarshallingFormat(marshallingFormat);
        this.kieServicesClient = KieServicesFactory.newKieServicesClient(config);
    }
}
