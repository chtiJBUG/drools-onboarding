package org.chtijbug.drools.generic.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.chtijbug.drools.generic.restclient.rest.GenericlRestAPI;
import org.chtijbug.drools.generic.restclient.rest.UsedRestAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by nheron on 12/12/2016.
 */
public class GenericRestAPIImpl implements UsedRestAPI {

    private static final Logger logger = LoggerFactory.getLogger(GenericRestAPIImpl.class);
    private GenericlRestAPI genericlRestAPI;
    private ObjectMapper mapper = new ObjectMapper();

    public GenericRestAPIImpl(GenericlRestAPI genericlRestAPI) {
        this.genericlRestAPI = genericlRestAPI;
    }

    @Override
    public Object runSession(String id, String processID, String className, Object objectRequest) {

        Object response= null;

        String responseJson = this.genericlRestAPI.runSession(id, processID, className, objectRequest);


        try {
            response = mapper.readValue(responseJson, objectRequest.getClass()   );
        } catch (IOException e) {
            logger.error("GenericRestAPIImpl.runSession.readValue", e);
        }

        return response;
    }

    @Override
    public Object runSessionSessionName(String id, String processID, String className, String sessionName, Object objectRequest) {
        Object response = null;

        String responseJson = this.genericlRestAPI.runSessionWithName(id, processID, className, sessionName, objectRequest);


        try {
            response = mapper.readValue(responseJson, objectRequest.getClass());
        } catch (IOException e) {
            logger.error("GenericRestAPIImpl.runSession.readValue", e);
        }

        return response;
    }
}
