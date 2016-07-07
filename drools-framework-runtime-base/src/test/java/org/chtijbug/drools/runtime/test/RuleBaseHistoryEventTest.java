package org.chtijbug.drools.runtime.test;

import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.entity.history.knowledge.KnowledgeBaseAddResourceEvent;
import org.chtijbug.drools.entity.history.knowledge.KnowledgeBaseCreatedEvent;
import org.chtijbug.drools.entity.history.knowledge.KnowledgeBaseInitialLoadEvent;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.chtijbug.drools.runtime.listener.HistoryListener;
import org.chtijbug.drools.runtime.resource.FileKnowledgeResource;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Date: 17/02/14
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class RuleBaseHistoryEventTest {

    private FileKnowledgeResource fibonacciFile;

    @Before
    public void justBefore() {
        // fibonacciFile = FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
    }

    @Test
    public void PackageCreationEvent() throws DroolsChtijbugException {

        final List<HistoryEvent> historyEvents = new ArrayList<HistoryEvent>();
        HistoryListener historyListener = new HistoryListener() {
            @Override
            public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
                historyEvents.add(newHistoryEvent);
            }
        };
        RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(new Long(1L), historyListener, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT)", "fibonacci.drl");
        Long rulePackageID = ruleBasePackage.getRuleBaseID();

        assertThat(historyEvents).hasSize(3);
        assertThat(historyEvents.get(0)).isInstanceOf(KnowledgeBaseCreatedEvent.class);
        KnowledgeBaseCreatedEvent knowledgeBaseCreatedEvent = (KnowledgeBaseCreatedEvent) historyEvents.get(0);
        assertThat(knowledgeBaseCreatedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
        assertThat(knowledgeBaseCreatedEvent.getEventID()).isEqualTo(1);
        assertThat(knowledgeBaseCreatedEvent.getSessionId()).isNull();
        assertThat(knowledgeBaseCreatedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        assertThat(historyEvents.get(2)).isInstanceOf(KnowledgeBaseAddResourceEvent.class);
        KnowledgeBaseAddResourceEvent knowledgeBaseAddResourceEvent = (KnowledgeBaseAddResourceEvent) historyEvents.get(2);
        assertThat(knowledgeBaseAddResourceEvent.getEventID()).isEqualTo(3);
        assertThat(knowledgeBaseAddResourceEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        assertThat(knowledgeBaseAddResourceEvent.getKnowledgeResources()).hasSize(1);
        assertThat(knowledgeBaseAddResourceEvent.getKnowledgeResources().get(0)).isInstanceOf(FileKnowledgeResource.class);
        FileKnowledgeResource drlRessourceFile = (FileKnowledgeResource) knowledgeBaseAddResourceEvent.getKnowledgeResources().get(0);
        assertThat(drlRessourceFile.getPath()).isEqualTo("fibonacci.drl");
        assertThat(historyEvents.get(1)).isInstanceOf(KnowledgeBaseInitialLoadEvent.class);
        KnowledgeBaseInitialLoadEvent knowledgeBaseInitialLoadEvent = (KnowledgeBaseInitialLoadEvent) historyEvents.get(1);
        assertThat(knowledgeBaseInitialLoadEvent.getEventID()).isEqualTo(2);
        assertThat(knowledgeBaseInitialLoadEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
        /** ruleBasePackage.RecreateKBaseWithNewResources(DrlDroolsResource.createClassPathResource("fibonacciBis.drl"));
         assertThat(historyEvents.size() == 6);
         assertThat(historyEvents.get(4) instanceof KnowledgeBaseAddResourceEvent);
         KnowledgeBaseAddResourceEvent knowledgeBaseAddRessourceEvent2 = (KnowledgeBaseAddResourceEvent) historyEvents.get(4);
         assertThat(knowledgeBaseAddRessourceEvent2.getEventID(), 5l);
         assertThat(knowledgeBaseAddRessourceEvent2.getTypeEvent(), HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
         assertThat(knowledgeBaseAddRessourceEvent2.getResourceFiles().size() == 1);
         assertThat(knowledgeBaseAddRessourceEvent2.getResourceFiles().get(0) instanceof DrlResourceFile);
         DrlResourceFile drlRessourceFile2 = (DrlResourceFile)knowledgeBaseAddRessourceEvent2.getResourceFiles().get(0);
         assertThat(drlRessourceFile2.getFileName().equals("fibonacciBis.drl"));

         assertThat(historyEvents.get(5) instanceof KnowledgeBaseReloadedEvent);
         KnowledgeBaseReloadedEvent knowledgeBaseReloadedEvent = (KnowledgeBaseReloadedEvent) historyEvents.get(5);
         assertThat(knowledgeBaseReloadedEvent.getRuleBaseID()).isEqualTo(rulePackageID);
         assertThat(knowledgeBaseReloadedEvent.getEventID()).isEqualTo(6);
         assertThat(knowledgeBaseReloadedEvent.getSessionId()).isEqualTo(0);
         assertThat(knowledgeBaseReloadedEvent.getTypeEvent()).isEqualTo(HistoryEvent.TypeEvent.KnowledgeBaseSingleton);
         */

    }
}
