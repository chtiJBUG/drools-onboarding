package org.chtijbug.drools.runtime.test;

import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.knowledge.KnowledgeBaseCreateSessionEvent;
import org.chtijbug.drools.entity.history.session.SessionCreatedEvent;
import org.chtijbug.drools.entity.history.session.SessionDisposedEvent;
import org.chtijbug.drools.entity.history.session.SessionFireAllRulesBeginEvent;
import org.chtijbug.drools.entity.history.session.SessionFireAllRulesEndEvent;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Date: 17/02/14
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class KnowledgeBaseHistoryEventTest {


    @Before
    public void justBefore() {
        // fibonacciFile = FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
    }

    @Test
    public void KnowledgeSessionEventOneSession() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT)", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession = ruleBasePackage.createRuleBaseSession();
        assertThat(historyEvents).hasSize(5);
        assertThat(historyEvents.get(3)).isInstanceOf(KnowledgeBaseCreateSessionEvent.class);
        KnowledgeBaseCreateSessionEvent knowledgeBaseCreateSessionEvent = (KnowledgeBaseCreateSessionEvent) historyEvents.get(3);
        assertThat(knowledgeBaseCreateSessionEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(knowledgeBaseCreateSessionEvent.getEventID()).isEqualTo(4);
        assertThat(knowledgeBaseCreateSessionEvent.getSessionId()).isEqualTo(1);
        assertThat(knowledgeBaseCreateSessionEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        assertThat(historyEvents.get(4)).isInstanceOf(SessionCreatedEvent.class);
        SessionCreatedEvent sessionCreatedEvent = (SessionCreatedEvent) historyEvents.get(4);
        assertThat(sessionCreatedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionCreatedEvent.getEventID()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
        ruleBaseSession.dispose();
        assertThat(historyEvents).hasSize(6);
        assertThat(historyEvents.get(5)).isInstanceOf(SessionDisposedEvent.class);
        SessionDisposedEvent sessionDisposedEvent = (SessionDisposedEvent) historyEvents.get(5);
        assertThat(sessionDisposedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionDisposedEvent.getEventID()).isEqualTo(2);
        assertThat(sessionDisposedEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
    }

    @Test
    public void KnowledgeSessionEventTwoSession() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT)", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession1 = ruleBasePackage.createRuleBaseSession();
        assertThat(historyEvents).hasSize(5);
        assertThat(historyEvents.get(3)).isInstanceOf(KnowledgeBaseCreateSessionEvent.class);
        KnowledgeBaseCreateSessionEvent knowledgeBaseCreateSessionEvent = (KnowledgeBaseCreateSessionEvent) historyEvents.get(3);
        assertThat(knowledgeBaseCreateSessionEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(knowledgeBaseCreateSessionEvent.getEventID()).isEqualTo(4);
        assertThat(knowledgeBaseCreateSessionEvent.getSessionId()).isEqualTo(1);
        assertThat(knowledgeBaseCreateSessionEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        assertThat(historyEvents.get(4)).isInstanceOf(SessionCreatedEvent.class);
        SessionCreatedEvent sessionCreatedEvent = (SessionCreatedEvent) historyEvents.get(4);
        assertThat(sessionCreatedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionCreatedEvent.getEventID()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
        RuleBaseSession ruleBaseSession2 = ruleBasePackage.createRuleBaseSession();
        assertThat(historyEvents).hasSize(7);
        assertThat(historyEvents.get(5)).isInstanceOf(KnowledgeBaseCreateSessionEvent.class);
        KnowledgeBaseCreateSessionEvent knowledgeBaseCreateSessionEvent2 = (KnowledgeBaseCreateSessionEvent) historyEvents.get(5);
        assertThat(knowledgeBaseCreateSessionEvent2.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(knowledgeBaseCreateSessionEvent2.getEventID()).isEqualTo(5);
        assertThat(knowledgeBaseCreateSessionEvent2.getSessionId()).isEqualTo(2);
        assertThat(knowledgeBaseCreateSessionEvent2.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        assertThat(historyEvents.get(6)).isInstanceOf(SessionCreatedEvent.class);
        SessionCreatedEvent sessionCreatedEvent2 = (SessionCreatedEvent) historyEvents.get(6);
        assertThat(sessionCreatedEvent2.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionCreatedEvent2.getEventID()).isEqualTo(1);
        assertThat(sessionCreatedEvent2.getSessionId()).isEqualTo(2);
        assertThat(sessionCreatedEvent2.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);


        ruleBaseSession1.dispose();
        assertThat(historyEvents).hasSize(8);
        assertThat(historyEvents.get(7)).isInstanceOf(SessionDisposedEvent.class);
        SessionDisposedEvent sessionDisposedEvent = (SessionDisposedEvent) historyEvents.get(7);
        assertThat(sessionDisposedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionDisposedEvent.getEventID()).isEqualTo(2);
        assertThat(sessionDisposedEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionCreatedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
        ruleBaseSession2.dispose();
        assertThat(historyEvents).hasSize(9);
        assertThat(historyEvents.get(8)).isInstanceOf(SessionDisposedEvent.class);
        SessionDisposedEvent sessionDisposedEvent2 = (SessionDisposedEvent) historyEvents.get(8);
        assertThat(sessionDisposedEvent2.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionDisposedEvent2.getEventID()).isEqualTo(2);
        assertThat(sessionDisposedEvent2.getSessionId()).isEqualTo(2);
        assertThat(sessionDisposedEvent2.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
    }

    @Test
    public void KnowledgeBaseFireAllRules() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT)", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession1 = ruleBasePackage.createRuleBaseSession();
        Fibonacci fibonacci = new Fibonacci(1);
        ruleBaseSession1.insertObject(fibonacci);
        ruleBaseSession1.fireAllRules();
        assertThat(historyEvents).hasSize(11);
        assertThat(historyEvents.get(6)).isInstanceOf(SessionFireAllRulesBeginEvent.class);
        SessionFireAllRulesBeginEvent sessionFireAllRulesBeginEvent = (SessionFireAllRulesBeginEvent) historyEvents.get(6);
        assertThat(sessionFireAllRulesBeginEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionFireAllRulesBeginEvent.getEventID()).isEqualTo(3);
        assertThat(sessionFireAllRulesBeginEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionFireAllRulesBeginEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
        assertThat(historyEvents.get(10)).isInstanceOf(SessionFireAllRulesEndEvent.class);
        SessionFireAllRulesEndEvent sessionFireAllRulesEndEvent = (SessionFireAllRulesEndEvent) historyEvents.get(10);
        assertThat(sessionFireAllRulesEndEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(sessionFireAllRulesEndEvent.getEventID()).isEqualTo(7);
        assertThat(sessionFireAllRulesEndEvent.getSessionId()).isEqualTo(1);
        assertThat(sessionFireAllRulesEndEvent.getNumberRulesExecuted()).isEqualTo(1);
        assertThat(sessionFireAllRulesEndEvent.getExecutionTime() > 0l);
        assertThat(sessionFireAllRulesEndEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Session);
    }
}
