package org.chtijbug.drools.runtime.impl;

import org.chtijbug.drools.entity.DroolsFactObject;
import org.chtijbug.drools.runtime.resource.FileKnowledgeResource;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 28/09/12
 * Time: 17:55
 */
public class RuleBaseStatefulSessionTestCase {
    private static RuleBaseSingleton ruleBase;

    private RuleBaseStatefulSession session;
    private FileKnowledgeResource fibonacciFile;


    @Before
    public void before() throws Exception {
        fibonacciFile = FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
        ruleBase = new RuleBaseSingleton(1L, 5000, null, "com.pymmasoftware.test", "fibonacci", "1.0.0-SNAPSHOT");
        // TODO Créer une kbase
        ruleBase.createKBase(Arrays.asList(fibonacciFile));
        // TODO créer une session à partir dela KBase
        session = (RuleBaseStatefulSession) ruleBase.createRuleBaseSession();
    }

    @Test
    public void runInsertByReflection() throws Exception {

        DummyFact sibling = new DummyFact("sibling");
        DummyFact item1 = new DummyFact("items 1");
        DummyFact item2 = new DummyFact("items 2");
        DummyFact root = new DummyFact("ROOT", sibling, Arrays.asList(item1, item2));

        try {
            //_____ Execute reflection insertion
            session.insertByReflection(root);
            //_____ Assert that all fact handle have been correctly created
            Collection<DroolsFactObject> droolsFactObjects = session.listLastVersionObjects();
            assertEquals(4, droolsFactObjects.size());


            DroolsFactObject rootFactObject = session.getLastFactObjectVersion(root);
            assertNotNull(rootFactObject);
            DroolsFactObject siblingFactObject = session.getLastFactObjectVersion(sibling);
            assertNotNull(siblingFactObject);
            DroolsFactObject item1FactObject = session.getLastFactObjectVersion(item1);
            assertNotNull(item1FactObject);
            DroolsFactObject item2FactObject = session.getLastFactObjectVersion(item2);
            assertNotNull(item2FactObject);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }


    public class DummyFact {
        private String name;
        private DummyFact property;
        private List<DummyFact> listOfFacts;

        DummyFact(String name) {
            this.name = name;
        }

        DummyFact(String name, DummyFact property) {
            this(name);
            this.property = property;
        }

        DummyFact(String name, DummyFact property, List<DummyFact> listOfFacts) {
            this(name, property);
            this.listOfFacts = listOfFacts;
        }

        public String getName() {
            return name;
        }

        public DummyFact getProperty() {
            return property;
        }

        public List<DummyFact> getListOfFacts() {
            return listOfFacts;
        }

    }

}
