package org.chtijbug.drools.runtime.test;

import org.chtijbug.drools.entity.DroolsFactObjectAttribute;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.rule.AfterRuleFiredHistoryEvent;
import org.chtijbug.drools.entity.history.rule.BeforeRuleFiredHistoryEvent;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * Date: 23/11/12
 * Time: 09:44
 * To change this template use File | Settings | File Templates.
 */
public class RuleHandlerListenerTest {
    static RuleBasePackage ruleBasePackage;
    RuleBaseSession session;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @Before
    public void justBefore() {
        //infiniteLoopFile = FileKnowledgeResource.createDRLClassPathResource("infiniteLoop.drl");
        //ruleflow1File = FileKnowledgeResource.createDRLClassPathResource("ruleflow1.drl");
        //ruleFlowProcess1File = FileKnowledgeResource.createDRLClassPathResource("RuleFlowProcess1.bpmn2");
    }

    /**
     * @throws java.lang.Exception
     */

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void DefaultMaxNumberRUleExecuted() throws Exception {
        ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "infiniteLoop.drl");
        session = ruleBasePackage.createRuleBaseSession();
        Fibonacci newObject = new Fibonacci(0);
        session.insertObject(newObject);
        try {
            session.fireAllRules();
            fail();
        } catch (DroolsChtijbugException e) {
            assertThat(e.getKey()).isEqualTo(DroolsChtijbugException.MaxNumberRuleExecutionReached);
        }
    }


    @Test
    public void max10tMaxNumberRUleExecuted() throws Exception {
        ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "infiniteLoop.drl");

        session = ruleBasePackage.createRuleBaseSession(10);

        Fibonacci newObject = new Fibonacci(0);
        session.insertObject(newObject);
        try {
            session.fireAllRules();
            fail();
        } catch (DroolsChtijbugException e) {
            assertThat(session.getNumberRulesExecuted()).isEqualTo(10);
            assertThat(e.getKey()).isEqualTo(DroolsChtijbugException.MaxNumberRuleExecutionReached);
        }
    }

    @Test
    public void RuleEvent() throws DroolsChtijbugException {
        ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "infiniteLoop.drl");

        session = ruleBasePackage.createRuleBaseSession();

        Fibonacci newObject = new Fibonacci(0);
        session.insertObject(newObject);
        try {
            session.fireAllRules();
        } catch (DroolsChtijbugException e) {
            e.printStackTrace();
        }
        List<HistoryEvent> eventList = session.getHistoryContainer().getListHistoryEvent();
        assertThat(eventList).hasSize(6002);
        /*
            BeforeRuleFiredHistoryEvent
         */
        HistoryEvent event1 = eventList.get(1);
        assertThat(event1).isInstanceOf(BeforeRuleFiredHistoryEvent.class);
        BeforeRuleFiredHistoryEvent beforeRuleFiredHistoryEvent = (BeforeRuleFiredHistoryEvent) event1;
        assertThat(beforeRuleFiredHistoryEvent.getRule().getRuleName()).isEqualTo("infiniteLoop");
        assertThat(beforeRuleFiredHistoryEvent.getWhenObjects().size()).isEqualTo(1);
        assertThat(beforeRuleFiredHistoryEvent.getWhenObjects().get(0).getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(beforeRuleFiredHistoryEvent.getWhenObjects().get(0).getListfactObjectAttributes()).hasSize(2);
        List<DroolsFactObjectAttribute> droolsFactObjectAttributes = beforeRuleFiredHistoryEvent.getWhenObjects().get(0).getListfactObjectAttributes();
        assertThat(droolsFactObjectAttributes.get(0).getAttributeValue()).isEqualTo("0");
        /*
           AfterRuleFiredHistoryEvent
        */
        HistoryEvent event3 = eventList.get(3);
        assertThat(event3).isInstanceOf(AfterRuleFiredHistoryEvent.class);
        AfterRuleFiredHistoryEvent afterRuleFiredHistoryEvent = (AfterRuleFiredHistoryEvent) event3;
        assertThat(afterRuleFiredHistoryEvent.getRule().getRuleName()).isEqualTo("infiniteLoop");
    }


    @Test
    public void RuleFLowgroup1() throws Exception {
        ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "ruleflow1.drl", "RuleFlowProcess1.bpmn2");

        session = ruleBasePackage.createRuleBaseSession();

        Fibonacci newObject = new Fibonacci(0);
        session.insertObject(newObject);
        session.startProcess("P1");
        session.fireAllRules();
        //assertThat(session.getNumberRulesExecuted(), 10);

    }

}
