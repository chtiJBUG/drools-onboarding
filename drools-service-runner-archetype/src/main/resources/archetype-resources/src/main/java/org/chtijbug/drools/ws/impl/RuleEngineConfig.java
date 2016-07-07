#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.chtijbug.drools.ws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: samuel
 * Date: 17/09/12
 * Time: 09:54
 */
@Component
public class RuleEngineConfig {
    //TODO Les valeurs par défaut devraient être celle du JBoss AS
    @Value("${symbol_dollar}{chtijbug.guvnor.host}")
    private String host = "http:/localhost:8080/";
    @Value("${symbol_dollar}{chtijbug.guvnor.app}")
    private String app="drools-guvnor";
    @Value("${symbol_dollar}{chtijbug.guvnor.package}")
    private String packageName="amag/";
    @Value("${symbol_dollar}{chtijbug.guvnor.version}")
    private String version = "LATEST";
    @Value("${symbol_dollar}{chtijbug.guvnor.username}")
    private String user = "tomcat";
    @Value("${symbol_dollar}{chtijbug.guvnor.password}")
    private String password = "tomcat";


    public String getHost() {
        return host;
    }

    public String getApp() {
        return app;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getVersion() {
        return version;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
