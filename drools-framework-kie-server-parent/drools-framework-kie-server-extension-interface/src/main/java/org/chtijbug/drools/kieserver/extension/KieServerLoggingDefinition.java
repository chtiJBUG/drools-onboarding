package org.chtijbug.drools.kieserver.extension;

public interface KieServerLoggingDefinition {

    void OnCreateKieBase();

    void OnFireAllrulesStart(String groupID, String artifactId, String version, Object inputDataObject);

    void OnFireAllrulesEnd(String groupID, String artifactId, String version, Object outputDataObject, String jsonSessionLogging);

    void OnDisposeKieBase();
}
