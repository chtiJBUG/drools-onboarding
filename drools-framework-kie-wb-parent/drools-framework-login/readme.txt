

1) Create a user/schema pgsql called security

CREATE USER security WITH PASSWORD 'security';
create database security;
GRANT ALL PRIVILEGES ON DATABASE security to security;


CREATE TABLE guvnorusers (
  id bigint NOT NULL ,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
 CONSTRAINT realtimeparameters_runtime_pkey PRIMARY KEY (id)
);
ALTER TABLE guvnorusers
  OWNER TO security;


CREATE TABLE guvnorgroups
(
  id bigint NOT NULL,
  groups character varying(255) DEFAULT NULL::character varying,
  CONSTRAINT guvnorgroups_pk PRIMARY KEY (id)
);
ALTER TABLE guvnorgroups
  OWNER TO security;

CREATE TABLE guvnorusers_groups
(
  guvnorusers_id bigint NOT NULL,
  groups_id bigint NOT NULL,


  CONSTRAINT fk_guvnorusers_id FOREIGN KEY (guvnorusers_id)
      REFERENCES guvnorusers (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT fk_groups_id FOREIGN KEY (groups_id)
      REFERENCES guvnorgroups (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE guvnorusers_groups
  OWNER TO security;


INSERT INTO guvnorusers values (1,'admin','admin');
INSERT INTO guvnorusers values (3,'swimmingpool','swimmingpool');
INSERT INTO guvnorusers values (2,'loyalty','loyalty');
INSERT INTO guvnorgroups values (1,'admin');
INSERT INTO guvnorusers_groups values (1,1)  ;
INSERT INTO guvnorusers_groups values (2,1) ;
INSERT INTO guvnorusers_groups values (3,1);


2)   In %TOMCAT_HOME%/lib
    Copy the loginModule exported jar file and the pgsql connector jar.

3) In %TOMCAT_HOME%/conf/context.xml, we add a resource declaration


    <Resource name="jdbc/URDroolsDS" auth="Container"
        type="javax.sql.DataSource" driverClassName="org.postgresql.Driver"
        url="jdbc:postgresql://localhost/security" username="security"
        password="security" maxActive="20" maxIdle="10" maxWait="-1" />

4) – Update %TOMCAT_HOME%/conf/server.xml to add a Realm declaration

       <Realm className="org.apache.catalina.realm.CombinedRealm" >
                <Realm className="org.apache.catalina.realm.UserDatabaseRealm"
                    resourceName="UserDatabase"/>
                <Realm className="org.apache.catalina.realm.LockOutRealm">
                    <Realm appName="drools-guvnor"
                          className="com.pymmasoftware.platform.login.loginmodule.realm.DroolsJaasRealm"
                          userClassNames="com.pymmasoftware.platform.login.loginmodule.principal.DroolsPrincipal"
                          roleClassNames="com.pymmasoftware.platform.login.loginmodule.principal.DroolsGroup"/>

               </Realm>
           </Realm>

5)  – Create a file jaasConfig on %TOMCAT_HOME%/conf with this content:
    drools-guvnor{
    com.pymmasoftware.platform.login.loginmodule.DroolsLoginModule
    required debug=true;
    };

6)  – Before runing Tomcat create in %TOMCAT_HOME%/bin a setenv.sh file if you running on linux or setenv.bat on windows with this content (Working on linux)
       export JAVA_OPTS
    put this
    CATALINA_OPTS="-Xms1536m -Xmx6536m -XX:NewSize=256m -XX:MaxNewSize=256m -XX:PermSize=256m -XX:MaxPermSize=556m -XX:+DisableExplicitGC -Djava.security.auth.login.config=/home/nheron/workspace-ivy-showroom/apache-tomcat-7.0.53/conf/jaasConfig"