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

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 03/10/12
 * Time: 23:00
 */
public final class FileUtils {

    public static File getFolder(File projectFolder, String directoryName) throws IOException {
        File folder = new File(projectFolder, directoryName);
        if (!folder.exists()) {
            throw new IOException(String.format("Folder %s does not exists", directoryName));
        }
        if (!folder.isDirectory()) {
            throw new IOException(String.format("File named %s is not a directory", directoryName));
        }
        return folder;
    }

    public static File createFileFromTemplate(File folder, String filename, String templateFilename) throws IOException {
        File newFile = new File(folder, filename);
        newFile.createNewFile();
        org.apache.commons.io.FileUtils.writeByteArrayToFile(newFile, getByteArrayContent(templateFilename));
        return newFile;
    }

    public static void createFolder(String folder, File rootFolder) {
        // TODO Take MS File separator into account
        File newFolder = new File(rootFolder, folder);
        newFolder.mkdirs();

    }

    public static byte[] getByteArrayContent(String classPathFile) throws IOException {
        URL fileURL = Class.class.getResource(classPathFile);
        return org.apache.commons.io.FileUtils.readFileToByteArray(new File(fileURL.getFile()));
    }

    public static void replaceTokenInFile(File file, String tokenKey, String tokenValue) throws IOException {
        StringBuffer stringBuffer = replaceTokenFromFile(file, tokenKey, tokenValue);
        FileWriter writer = new FileWriter(file);
        IOUtils.write(stringBuffer, writer);
        IOUtils.closeQuietly(writer);

    }

    protected static StringBuffer replaceTokenFromFile(File file, String tokenKey, String tokenValue) throws IOException {
        FileReader fileReader = new FileReader(file);
        StringWriter stringWriter = null;
        try {
            stringWriter = new StringWriter();
            //______ Read each line of the file.
            List<String> allLines = IOUtils.readLines(fileReader);
            for (String line : allLines) {
                //______ Replace all Token key with the token Value
                String replacedLine = line.replace(tokenKey, tokenValue);
                stringWriter.write(replacedLine);
                stringWriter.write("\n");
            }
            //______ return the replaced content
            return stringWriter.getBuffer();
        } finally {
            IOUtils.closeQuietly(fileReader);
            IOUtils.closeQuietly(stringWriter);
        }
    }

    public static void createFileFromInputStream(File folder, String filename, InputStream inputStream) throws IOException {
        File newFile = new File(folder, filename);
        newFile.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(newFile);
        int ch;
        while ((ch = inputStream.read()) != -1) {
            outputStream.write(ch);
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }
}
