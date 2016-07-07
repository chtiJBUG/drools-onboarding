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
package org.chtijbug.drools.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nheron
 */
public class DroolsFactObject implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8185674445343213645L;
    private final transient Object realObject;
    protected int version;
    private String fullClassName;
    private int hashCode;
    private List<DroolsFactObjectAttribute> listfactObjectAttributes = new ArrayList<DroolsFactObjectAttribute>();
    private String realObject_JSON;

    /**
     *
     */
    public DroolsFactObject() {
        realObject = null;
    }

    public DroolsFactObject(Object realObject, int version) throws IOException {
        this.realObject = realObject;
        this.version = version;
        ObjectMapper mapper = new ObjectMapper();
        Writer strWriter = new StringWriter();
        mapper.writeValue(strWriter, realObject);
        this.realObject_JSON = strWriter.toString();
    }

    public String getRealObject_JSON() {
        return realObject_JSON;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("DroolsFactObject");
        sb.append("{fullClassName='").append(fullClassName).append('\'');
        sb.append(", hashCode=").append(hashCode);
        sb.append(", version=").append(version);
        sb.append(", listfactObjectAttributes=").append(listfactObjectAttributes);
        sb.append("attributes :\n");
        for (DroolsFactObjectAttribute foa : this.getListfactObjectAttributes()) {
            sb.append("- " + foa.getAttributeType() + " " + foa.getAttributeName() + "=" + foa.getAttributeValue() + "\n");
        }
        sb.append(", realObject=").append(realObject);
        sb.append('}');
        return sb.toString();
    }

    public int getObjectVersion() {
        return version;
    }

    public int getNextObjectVersion() {
        return version + 1;
    }

    public List<DroolsFactObjectAttribute> getListfactObjectAttributes() {
        return listfactObjectAttributes;
    }

    public void setListfactObjectAttributes(List<DroolsFactObjectAttribute> listfactObjectAttributes) {
        this.listfactObjectAttributes = listfactObjectAttributes;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public Object getRealObject() {
        return realObject;
    }
}
