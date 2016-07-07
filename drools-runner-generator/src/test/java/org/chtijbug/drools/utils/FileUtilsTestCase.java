/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.drools.utils;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 03/10/12
 * Time: 23:03
 */
public class FileUtilsTestCase {

    @Test
    public void runGetPomContent() {
        try {

            byte[] content = FileUtils.getByteArrayContent("/templates/log4j-template");
            String toEval = new String(content);
            assertNotNull(toEval);
            assertTrue(toEval.contains("log4j"));
        } catch (Throwable e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testReplaceTokenInFile() {
        try {
            URL url = FileUtilsTestCase.class.getResource("/replace-token-file");
            File file = new File(url.getFile());
            String tokenKey = "#JUNIT#";
            String tokenValue = "value";
            StringBuffer content = FileUtils.replaceTokenFromFile(file, tokenKey, tokenValue);
            assertNotNull(content);
            assertFalse(content.toString().contains("#JUNIT#"));
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
