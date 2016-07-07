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
package com.pymmasoftware.platform.login.loginmodule;

import com.pymmasoftware.platform.login.loginmodule.principal.DroolsGroup;
import com.pymmasoftware.platform.login.loginmodule.principal.DroolsPrincipal;
import com.pymmasoftware.platform.login.loginmodule.principal.DroolsRole;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DroolsLoginModule implements LoginModule {

    private static Context env = null;
    private static DataSource dataSource = null;
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map sharedState;
    private Map options;
    //the authencation status
    private boolean succeeded = false;
    private boolean commitSucceeded = false;
    //username & password
    private String username;
    private String password;
    private DroolsPrincipal userPrincipal;
    private String[] roles;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;

        try {
            if (env == null) {
                env = (Context) new InitialContext().lookup("java:comp/env");
                if (dataSource == null) {
                    dataSource = (DataSource) env.lookup("jdbc/URDroolsDS");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public boolean login() throws LoginException {
        succeeded = false;
        QueryRunner queryRunner = null;
        try {
            userPrincipal = null;
            roles = null;
            if (callbackHandler == null)
                throw new LoginException("No callback handler");

            NameCallback nameCallback = new NameCallback("Username");
            PasswordCallback passwordCallback = new PasswordCallback(
                    "Password", false);

            Callback[] callbacks = new Callback[]{nameCallback,
                    passwordCallback};
            try {
                callbackHandler.handle(callbacks);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (UnsupportedCallbackException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            username = nameCallback.getName();
            password = new String(passwordCallback.getPassword());

            queryRunner = new QueryRunner(dataSource);

            // Create a ResultSetHandler implementation to convert the
            // first row into an Object[].
            ResultSetHandler<DroolsPrincipal> h = new ResultSetHandler<DroolsPrincipal>() {
                public DroolsPrincipal handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) {
                        return null;
                    }

                    ResultSetMetaData meta = rs.getMetaData();
                    String userName = rs.getString("username");

                    DroolsPrincipal droolsPrincipal = new DroolsPrincipal(userName);
                    droolsPrincipal.setId(rs.getInt("id"));

                    return droolsPrincipal;
                }
            };
            ResultSetHandler<List<String>> hh = new ResultSetHandler<List<String>>() {
                public List<String> handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) {
                        return null;
                    }
                    List<String> droolsGroups = new ArrayList<>();
                    boolean goOne = true;
                    while (goOne) {
                        String groupName = rs.getString("groups");


                        droolsGroups.add(groupName);
                        if (rs.next() == false) {
                            goOne = false;
                        }
                    }
                    return droolsGroups;
                }
            };

            String sqlname = "select * from guvnorusers where username = ? and password = ? ";
            DroolsPrincipal user = queryRunner.query(sqlname, h, username, password);
            if (user == null) {
                succeeded = false;
                throw new FailedLoginException("The username or The password is incorrect");
            } else {

                userPrincipal = user;
                String sqlname2 = "select groups from guvnorgroups gr,guvnorusers_groups gr_user " +
                        "where gr.id = gr_user.groups_id  " +
                        "and gr_user.guvnorusers_id= ?";
                List<String> droolsGroups = queryRunner.query(sqlname2, hh, user.getId());
                if (droolsGroups != null) {
                    int i = droolsGroups.size();
                    roles = new String[i];
                    i = 0;
                    for (String droolsGroup : droolsGroups) {
                        roles[i] = droolsGroup;
                        i++;
                    }
                }
                succeeded = true;
                return true;
            }


        } catch (Exception e) {
            throw new LoginException(e.getMessage());
        } finally {
            queryRunner = null;
        }

    }

    @Override
    public boolean commit() throws LoginException {

        // this is the important part to work with JBoss:
        subject.getPrincipals().add(userPrincipal);
        // jboss requires the name 'Roles'
        DroolsGroup group = new DroolsGroup("Roles");
        for (String role : roles) {
            // group.addMember(role);
            DroolsRole droolsRole = new DroolsRole(role);
            subject.getPrincipals().add(droolsRole);
        }
        subject.getPrincipals().add(group);
        subject.getPrivateCredentials().add(password);

        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        // TODO Auto-generated method stub
        subject.getPrincipals().remove(userPrincipal);
        succeeded = false;
        succeeded = commitSucceeded;
        username = null;
        password = null;
        userPrincipal = null;
        return true;
    }

    @Override
    public boolean logout() throws LoginException {

        subject.getPrincipals().remove(userPrincipal);
        succeeded = false;
        succeeded = commitSucceeded;
        username = null;
        password = null;
        userPrincipal = null;

        return true;
    }
}
