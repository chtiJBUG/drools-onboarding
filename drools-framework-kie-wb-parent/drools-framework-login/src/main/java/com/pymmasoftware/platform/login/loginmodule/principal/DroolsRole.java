package com.pymmasoftware.platform.login.loginmodule.principal;

import java.io.Serializable;
import java.security.Principal;

/**
 * Created by nheron on 30/01/15.
 */
public class DroolsRole implements Principal, Serializable {
    private String name;

    public DroolsRole(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
