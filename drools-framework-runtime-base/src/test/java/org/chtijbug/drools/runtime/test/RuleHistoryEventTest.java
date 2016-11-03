package org.chtijbug.drools.runtime.test;

import org.chtijbug.drools.entity.DroolsRuleObject;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.rule.AfterRuleFiredHistoryEvent;
import org.chtijbug.drools.entity.history.rule.AfterRuleFlowActivatedHistoryEvent;
import org.chtijbug.drools.entity.history.rule.AfterRuleFlowDeactivatedHistoryEvent;
import org.chtijbug.drools.entity.history.rule.BeforeRuleFiredHistoryEvent;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Date: 18/02/14
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class RuleHistoryEventTest {


    @Before
    public void justBefore() {
        //   fibonacciFile =   FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
        //  ruleflow2File = FileKnowledgeResource.createDRLClassPathResource("ruleflow2.drl");
        //  ruleFlowProcess2File = FileKnowledgeResource.createDRLClassPathResource("RuleFlowProcess2.bpmn2");
    }

    @Test
    public void KnowledgeBaseFireAllRules() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession1 = ruleBasePackage.createRuleBaseSession();
        Fibonacci fibonacci = new Fibonacci(1);
        ruleBaseSession1.insertObject(fibonacci);
        ruleBaseSession1.fireAllRules();
        Assert.assertTrue(historyEvents.size() == 11);
        Assert.assertTrue(historyEvents.get(7) instanceof BeforeRuleFiredHistoryEvent);
        BeforeRuleFiredHistoryEvent beforeRuleFiredHistoryEvent = (BeforeRuleFiredHistoryEvent) historyEvents.get(7);
        assertThat(beforeRuleFiredHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(beforeRuleFiredHistoryEvent.getEventID()).isEqualTo(4);
        assertThat(beforeRuleFiredHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(beforeRuleFiredHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Rule);
        DroolsRuleObject droolsRuleObject = beforeRuleFiredHistoryEvent.getRule();
        assertThat(droolsRuleObject.getRuleName()).isEqualTo("Bootstrap");
        assertThat(droolsRuleObject.getRulePackageName()).isEqualTo("org.chtijbug.drools.runtime.test");

        Assert.assertTrue(historyEvents.get(9) instanceof AfterRuleFiredHistoryEvent);
        AfterRuleFiredHistoryEvent afterRuleFiredHistoryEvent = (AfterRuleFiredHistoryEvent) historyEvents.get(9);
        assertThat(afterRuleFiredHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(afterRuleFiredHistoryEvent.getEventID()).isEqualTo(6);
        assertThat(afterRuleFiredHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(afterRuleFiredHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Rule);
        DroolsRuleObject droolsRuleObject2 = afterRuleFiredHistoryEvent.getRule();
        assertThat(droolsRuleObject2.getRuleName()).isEqualTo("Bootstrap");
        assertThat(droolsRuleObject2.getRulePackageName()).isEqualTo("org.chtijbug.drools.runtime.test");
        assertThat(afterRuleFiredHistoryEvent.getRuleInstanceId()).isEqualTo(1);
    }

    @Test
    public void KnowledgeBaseFireAllRulesRuleFlowGroup() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "ruleflow2.drl", "RuleFlowProcess2.bpmn2");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession1 = ruleBasePackage.createRuleBaseSession();
        Fibonacci fibonacci = new Fibonacci(0);
        ruleBaseSession1.insertObject(fibonacci);
        ruleBaseSession1.startProcess("P1");
        ruleBaseSession1.fireAllRules();
        assertThat(historyEvents).hasSize(41);
        assertThat(historyEvents.get(12)).isInstanceOfAny(AfterRuleFlowActivatedHistoryEvent.class);
        AfterRuleFlowActivatedHistoryEvent afterRuleFlowActivatedHistoryEvent = (AfterRuleFlowActivatedHistoryEvent) historyEvents.get(12);
        assertThat(afterRuleFlowActivatedHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(afterRuleFlowActivatedHistoryEvent.getEventID()).isEqualTo(8);
        assertThat(afterRuleFlowActivatedHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(afterRuleFlowActivatedHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.RuleFlowGroup);
        assertThat(afterRuleFlowActivatedHistoryEvent.getDroolsRuleFlowGroupObject().getName()).isEqualTo("Group1");

        assertThat(historyEvents.get(15)).isInstanceOfAny(AfterRuleFiredHistoryEvent.class);
        AfterRuleFiredHistoryEvent afterRuleFiredHistoryEvent = (AfterRuleFiredHistoryEvent) historyEvents.get(15);
        assertThat(afterRuleFiredHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(afterRuleFiredHistoryEvent.getEventID()).isEqualTo(11);
        assertThat(afterRuleFiredHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(afterRuleFiredHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Rule);
        DroolsRuleObject droolsRuleObject2 = afterRuleFiredHistoryEvent.getRule();
        assertThat(droolsRuleObject2.getRuleName()).isEqualTo("Account group1");
        assertThat(droolsRuleObject2.getRulePackageName()).isEqualTo("org.chtijbug.drools.runtime.test");
        assertThat(afterRuleFiredHistoryEvent.getRuleInstanceId()).isEqualTo(1);


        assertThat(historyEvents.get(23)).isInstanceOf(AfterRuleFlowDeactivatedHistoryEvent.class);
        AfterRuleFlowDeactivatedHistoryEvent afterRuleFlowDeactivatedHistoryEvent = (AfterRuleFlowDeactivatedHistoryEvent) historyEvents.get(23);
        assertThat(afterRuleFlowDeactivatedHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(afterRuleFlowDeactivatedHistoryEvent.getEventID()).isEqualTo(19);
        assertThat(afterRuleFlowDeactivatedHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(afterRuleFlowDeactivatedHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.RuleFlowGroup);
        assertThat(afterRuleFlowDeactivatedHistoryEvent.getDroolsRuleFlowGroupObject().getName()).isEqualTo("Group2");


    }


}
