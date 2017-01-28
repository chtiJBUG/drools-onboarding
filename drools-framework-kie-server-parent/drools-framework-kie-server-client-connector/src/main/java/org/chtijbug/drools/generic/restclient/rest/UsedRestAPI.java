package org.chtijbug.drools.generic.restclient.rest;

/**
 * Created by nheron on 12/12/2016.
 */
public interface UsedRestAPI {
    Object runSession(String id,
                      String processID,
                       String className,
                      Object objectRequest);

    Object runSessionSessionName(String id,
                                 String processID,
                                 String className,
                                 String sessionName,
                                 Object objectRequest);
}
