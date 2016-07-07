package org.chtijbug.drools.runtime.test;

import org.chtijbug.drools.entity.DroolsFactObject;
import org.chtijbug.drools.entity.DroolsFactObjectAttribute;
import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.fact.*;
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
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class FactHistoryEventTest {

    @Before
    public void justBefore() {
        //fibonacciFile = FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
    }

    @Test
    public void KnowledgeSessionFact() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();
        RuleBaseSession ruleBaseSession = ruleBasePackage.createRuleBaseSession();
        Fibonacci fibonacci = new Fibonacci(1);
        ruleBaseSession.insertObject(fibonacci);
        assertThat(historyEvents).hasSize(6);
        assertThat(historyEvents.get(5)).isInstanceOfAny(InsertedFactHistoryEvent.class);
        InsertedFactHistoryEvent insertedFactHistoryEvent = (InsertedFactHistoryEvent) historyEvents.get(5);
        assertThat(insertedFactHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(insertedFactHistoryEvent.getEventID()).isEqualTo(2);
        assertThat(insertedFactHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(insertedFactHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);
        DroolsFactObject droolsFactObject = insertedFactHistoryEvent.getInsertedObject();
        assertThat(droolsFactObject.getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(droolsFactObject.getObjectVersion()).isEqualTo(0);
        assertThat(droolsFactObject.getRealObject() instanceof Fibonacci);
        assertThat(droolsFactObject.getListfactObjectAttributes()).hasSize(2);
        DroolsFactObjectAttribute droolsFactObjectAttribute1 = droolsFactObject.getListfactObjectAttributes().get(0);
        assertThat(droolsFactObjectAttribute1.getAttributeName()).isEqualTo("sequence");
        assertThat(droolsFactObjectAttribute1.getAttributeValue()).isEqualTo("1");
        assertThat(droolsFactObjectAttribute1.getAttributeType()).isEqualTo("Integer");
        DroolsFactObjectAttribute droolsFactObjectAttribute2 = droolsFactObject.getListfactObjectAttributes().get(1);
        assertThat(droolsFactObjectAttribute2.getAttributeName()).isEqualTo("value");
        assertThat(droolsFactObjectAttribute2.getAttributeValue()).isEqualTo("-1");
        assertThat(droolsFactObjectAttribute2.getAttributeType()).isEqualTo("Long");
        fibonacci.setValue(-2);
        ruleBaseSession.updateObject(fibonacci);
        assertThat(historyEvents).hasSize(7);
        assertThat(historyEvents.get(6) instanceof UpdatedFactHistoryEvent);
        UpdatedFactHistoryEvent updatedFactHistoryEvent = (UpdatedFactHistoryEvent) historyEvents.get(6);
        assertThat(updatedFactHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(updatedFactHistoryEvent.getEventID()).isEqualTo(3);
        assertThat(updatedFactHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(updatedFactHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);
        DroolsFactObject oldDroolsFactObject = updatedFactHistoryEvent.getObjectOldValue();
        assertThat(oldDroolsFactObject.getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(oldDroolsFactObject.getObjectVersion()).isEqualTo(0);
        assertThat(oldDroolsFactObject.getRealObject()).isInstanceOf(Fibonacci.class);
        assertThat(oldDroolsFactObject.getListfactObjectAttributes()).hasSize(2);
        DroolsFactObjectAttribute oldDroolsFactObjectAttribute1 = oldDroolsFactObject.getListfactObjectAttributes().get(0);
        assertThat(oldDroolsFactObjectAttribute1.getAttributeName()).isEqualTo("sequence");
        assertThat(oldDroolsFactObjectAttribute1.getAttributeValue()).isEqualTo("1");
        assertThat(oldDroolsFactObjectAttribute1.getAttributeType()).isEqualTo("Integer");
        DroolsFactObjectAttribute oldDroolsFactObjectAttribute2 = oldDroolsFactObject.getListfactObjectAttributes().get(1);
        assertThat(oldDroolsFactObjectAttribute2.getAttributeName()).isEqualTo("value");
        assertThat(oldDroolsFactObjectAttribute2.getAttributeValue()).isEqualTo("-1");
        assertThat(oldDroolsFactObjectAttribute2.getAttributeType()).isEqualTo("Long");
        DroolsFactObject newDroolsFactObject = updatedFactHistoryEvent.getObjectNewValue();
        assertThat(newDroolsFactObject.getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(newDroolsFactObject.getObjectVersion()).isEqualTo(1);
        assertThat(newDroolsFactObject.getRealObject()).isInstanceOf(Fibonacci.class);
        assertThat(newDroolsFactObject.getListfactObjectAttributes()).hasSize(2);
        DroolsFactObjectAttribute newDroolsFactObjectAttribute1 = newDroolsFactObject.getListfactObjectAttributes().get(0);
        assertThat(newDroolsFactObjectAttribute1.getAttributeName()).isEqualTo("sequence");
        assertThat(newDroolsFactObjectAttribute1.getAttributeValue()).isEqualTo("1");
        assertThat(newDroolsFactObjectAttribute1.getAttributeType()).isEqualTo("Integer");
        DroolsFactObjectAttribute newDroolsFactObjectAttribute2 = newDroolsFactObject.getListfactObjectAttributes().get(1);
        assertThat(newDroolsFactObjectAttribute2.getAttributeName()).isEqualTo("value");
        assertThat(newDroolsFactObjectAttribute2.getAttributeValue()).isEqualTo("-2");
        assertThat(newDroolsFactObjectAttribute2.getAttributeType()).isEqualTo("Long");
        ruleBaseSession.retractObject(fibonacci);
        assertThat(historyEvents).hasSize(8);
        assertThat(historyEvents.get(7)).isInstanceOf(DeletedFactHistoryEvent.class);
        DeletedFactHistoryEvent deletedFactHistoryEvent = (DeletedFactHistoryEvent) historyEvents.get(7);
        assertThat(deletedFactHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(deletedFactHistoryEvent.getEventID()).isEqualTo(4);
        assertThat(deletedFactHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(deletedFactHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);

        DroolsFactObject deletedDroolsFactObject = deletedFactHistoryEvent.getDeletedObject();
        assertThat(deletedDroolsFactObject.getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(deletedDroolsFactObject.getObjectVersion()).isEqualTo(1);
        assertThat(deletedDroolsFactObject.getRealObject()).isInstanceOf(Fibonacci.class);
        assertThat(deletedDroolsFactObject.getListfactObjectAttributes()).hasSize(2);
        DroolsFactObjectAttribute deletedDroolsFactObjectAttribute1 = deletedDroolsFactObject.getListfactObjectAttributes().get(0);
        assertThat(deletedDroolsFactObjectAttribute1.getAttributeName()).isEqualTo("sequence");
        assertThat(deletedDroolsFactObjectAttribute1.getAttributeValue()).isEqualTo("1");
        assertThat(deletedDroolsFactObjectAttribute1.getAttributeType()).isEqualTo("Integer");
        DroolsFactObjectAttribute deletedDroolsFactObjectAttribute2 = deletedDroolsFactObject.getListfactObjectAttributes().get(1);
        assertThat(deletedDroolsFactObjectAttribute2.getAttributeName()).isEqualTo("value");
        assertThat(deletedDroolsFactObjectAttribute2.getAttributeValue()).isEqualTo("-2");
        assertThat(deletedDroolsFactObjectAttribute2.getAttributeType()).isEqualTo("Long");
    }

    @Test
    public void KnowledgeSessionFactByReflection() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        RuleBaseSession ruleBaseSession = ruleBasePackage.createRuleBaseSession();
        Fibonacci fibonacci = new Fibonacci(1);
        ruleBaseSession.insertByReflection(fibonacci);
        assertThat(historyEvents.size() == 8);
        assertThat(historyEvents.get(5)).isInstanceOf(InsertedByReflectionFactStartHistoryEvent.class);
        InsertedByReflectionFactStartHistoryEvent insertedByReflectionFactHistoryEvent = (InsertedByReflectionFactStartHistoryEvent) historyEvents.get(5);
        assertThat(insertedByReflectionFactHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(insertedByReflectionFactHistoryEvent.getEventID()).isEqualTo(2);
        assertThat(insertedByReflectionFactHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(insertedByReflectionFactHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);
        assertThat(historyEvents.get(6)).isInstanceOf(InsertedFactHistoryEvent.class);
        InsertedFactHistoryEvent insertedFactHistoryEvent = (InsertedFactHistoryEvent) historyEvents.get(6);
        assertThat(insertedFactHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(insertedFactHistoryEvent.getEventID()).isEqualTo(3);
        assertThat(insertedFactHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(insertedFactHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);
        DroolsFactObject droolsFactObject = insertedFactHistoryEvent.getInsertedObject();
        assertThat(droolsFactObject.getFullClassName()).isEqualTo("org.chtijbug.drools.runtime.test.Fibonacci");
        assertThat(droolsFactObject.getObjectVersion()).isEqualTo(0);
        assertThat(droolsFactObject.getRealObject()).isInstanceOf(Fibonacci.class);
        assertThat(droolsFactObject.getListfactObjectAttributes()).hasSize(2);
        DroolsFactObjectAttribute droolsFactObjectAttribute1 = droolsFactObject.getListfactObjectAttributes().get(0);
        assertThat(droolsFactObjectAttribute1.getAttributeName()).isEqualTo("sequence");
        assertThat(droolsFactObjectAttribute1.getAttributeValue()).isEqualTo("1");
        assertThat(droolsFactObjectAttribute1.getAttributeType()).isEqualTo("Integer");
        DroolsFactObjectAttribute droolsFactObjectAttribute2 = droolsFactObject.getListfactObjectAttributes().get(1);
        assertThat(droolsFactObjectAttribute2.getAttributeName()).isEqualTo("value");
        assertThat(droolsFactObjectAttribute2.getAttributeValue()).isEqualTo("-1");
        assertThat(droolsFactObjectAttribute2.getAttributeType()).isEqualTo("Long");

        assertThat(historyEvents.get(7)).isInstanceOf(InsertedByReflectionFactEndHistoryEvent.class);
        InsertedByReflectionFactEndHistoryEvent insertedByReflectionFactEndHistoryEvent = (InsertedByReflectionFactEndHistoryEvent) historyEvents.get(7);
        assertThat(insertedByReflectionFactEndHistoryEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(insertedByReflectionFactEndHistoryEvent.getEventID()).isEqualTo(4);
        assertThat(insertedByReflectionFactEndHistoryEvent.getSessionId()).isEqualTo(1);
        assertThat(insertedByReflectionFactEndHistoryEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.Fact);

    }
}
