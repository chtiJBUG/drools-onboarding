package org.chtijbug.drools.runtime.impl;

import com.thoughtworks.xstream.XStream;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.RuleBaseBuilder;
import org.chtijbug.drools.runtime.RuleBasePackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 26/11/12
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class RuleBasePackageTestCase {


    private static String readFileAsString(String filePath)
            throws java.io.IOException {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }

    @Before
    public void justBefore() {
        // fibonacciFile = FileKnowledgeResource.createDRLClassPathResource("fibonacci.drl");
    }

    @Test
    @Ignore
    public void testXStreamSerialization() {

        try {
            XStream xstream = new XStream();
            RuleBasePackage ruleBasePackage = RuleBaseBuilder.createRuleBasePackage(1L, "com.pymmasoftware.test", "fibonacci", "1.0.0_SNAPSHOT", "fibonacci.drl");
            String pkgXML = xstream.toXML(ruleBasePackage);
            FileWriter fstream = new FileWriter("/tmp/chtijbug-rule-cache");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(pkgXML);
            out.close();
        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        } catch (DroolsChtijbugException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Ignore
    public void testXStreamDeserialization() {
        String ruleBaseXML = null;
        try {
            ruleBaseXML = readFileAsString("/tmp/chtijbug-rule-cache");
            if (ruleBaseXML == null)
                fail();
            XStream xStream = new XStream();
            RuleBaseSingleton ruleBasePackage = (RuleBaseSingleton) xStream.fromXML(ruleBaseXML);
            assertNotNull(ruleBasePackage);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            fail();
        }

    }

}