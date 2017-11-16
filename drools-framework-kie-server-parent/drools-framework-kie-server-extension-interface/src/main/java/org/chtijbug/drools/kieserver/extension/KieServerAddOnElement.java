package org.chtijbug.drools.kieserver.extension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KieServerAddOnElement {

    private List<KieServerGlobalVariableDefinition> kieServerGlobalVariableDefinitions = null;
    private List<KieServerLoggingDefinition> kieServerLoggingDefinitions = null;
    private List<KieServerListenerDefinition> kieServerListenerDefinitions = null;
    private List<KieServerAsyncCallBack> kieServerAsyncCallBacks = null;
    private Map<String, Object> globals = new HashMap<>();

    public KieServerAddOnElement(List<KieServerGlobalVariableDefinition> kieServerGlobalVariableDefinitions, List<KieServerLoggingDefinition> kieServerLoggingDefinitions, List<KieServerListenerDefinition> kieServerListenerDefinitions, List<KieServerAsyncCallBack> kieServerAsyncCallBacks) {
        this.kieServerGlobalVariableDefinitions = kieServerGlobalVariableDefinitions;
        this.kieServerLoggingDefinitions = kieServerLoggingDefinitions;
        this.kieServerListenerDefinitions = kieServerListenerDefinitions;
        this.kieServerAsyncCallBacks = kieServerAsyncCallBacks;
    }

    public List<KieServerGlobalVariableDefinition> getKieServerGlobalVariableDefinitions() {
        return kieServerGlobalVariableDefinitions;
    }

    public List<KieServerLoggingDefinition> getKieServerLoggingDefinitions() {
        return kieServerLoggingDefinitions;
    }

    public List<KieServerListenerDefinition> getKieServerListenerDefinitions() {
        return kieServerListenerDefinitions;
    }

    public List<KieServerAsyncCallBack> getKieServerAsyncCallBacks() {
        return kieServerAsyncCallBacks;
    }

    public Map<String, Object> getGlobals() {
        return globals;
    }
}
