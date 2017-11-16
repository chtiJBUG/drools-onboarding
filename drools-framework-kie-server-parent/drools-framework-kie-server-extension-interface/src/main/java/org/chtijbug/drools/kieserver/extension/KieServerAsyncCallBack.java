package org.chtijbug.drools.kieserver.extension;

public interface KieServerAsyncCallBack {
    void OnCreateKieBase();


    void OnFireAllrulesEnd(String groupID, String artifactId, String version, Object outputDataObject, Object sessionLogging);

    void OnDisposeKieBase();
}
