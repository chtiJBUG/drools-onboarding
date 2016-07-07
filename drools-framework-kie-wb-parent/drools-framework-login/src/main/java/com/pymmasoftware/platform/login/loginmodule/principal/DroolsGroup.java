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
package com.pymmasoftware.platform.login.loginmodule.principal;

import java.io.Serializable;
import java.security.Principal;
import java.security.acl.Group;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class DroolsGroup implements Group, Serializable {


    private static final long serialVersionUID = 1L;
    private final String name;
    private final Set<Principal> users = new HashSet<Principal>();

    public DroolsGroup(String name) {
        this.name = name;
    }

    public boolean addMember(Principal user) {
        return users.add(user);
    }

    public boolean removeMember(Principal user) {
        return users.remove(user);
    }

    public boolean isMember(Principal member) {
        return users.contains(member);
    }

    public Enumeration<? extends Principal> members() {
        return Collections.enumeration(users);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
