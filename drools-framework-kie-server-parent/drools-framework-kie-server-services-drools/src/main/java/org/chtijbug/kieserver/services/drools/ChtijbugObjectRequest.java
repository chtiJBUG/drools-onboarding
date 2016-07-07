package org.chtijbug.kieserver.services.drools;

import org.chtijbug.kieserver.services.runtimeevent.SessionContext;

/**
 * Created by nheron on 07/07/2016.
 */
public class ChtijbugObjectRequest {

    private Object objectRequest;

    private SessionContext sessionLogging;

    public Object getObjectRequest() {
        return objectRequest;
    }

    public void setObjectRequest(Object objectRequest) {
        this.objectRequest = objectRequest;
    }

    public SessionContext getSessionLogging() {
        return sessionLogging;
    }

    public void setSessionLogging(SessionContext sessionLogging) {
        this.sessionLogging = sessionLogging;
    }
}
