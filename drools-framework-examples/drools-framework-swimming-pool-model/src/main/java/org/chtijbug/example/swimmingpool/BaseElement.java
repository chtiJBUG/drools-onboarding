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
package org.chtijbug.example.swimmingpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 12/09/14
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class BaseElement {

    private List<CalculatedAttribute> calculatedAttributeList = new ArrayList<>();

    public BaseElement() {
    }

    public List<CalculatedAttribute> getCalculatedAttributeList() {
        return calculatedAttributeList;


    }

    public void setCalculatedAttributeList(List<CalculatedAttribute> calculatedAttributeList) {
        this.calculatedAttributeList = calculatedAttributeList;
    }

    public void addCalculatedElement(CalculatedAttribute calculatedAttribute) {
        this.calculatedAttributeList.add(calculatedAttribute);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseElement{");
        sb.append("calculatedAttributeList=").append(calculatedAttributeList);
        sb.append('}');
        return sb.toString();
    }
}
