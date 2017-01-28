package org.chtijbug.drools.generic.restclient.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface GenericlRestAPI {

    @POST
    @Path("/services/rest/server/containers/instances/generic/run/{id}/{processId}/{className}")
    @Produces("application/json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    String runSession(@PathParam("id") String id,
                      @PathParam("processId") String processID,
                      @PathParam("className") String className,
                     Object objectRequest);

    @POST
    @Path("/services/rest/server/containers/instances/generic/runSessionName/{id}/{processId}/{className}/{sessionName}")
    @Produces("application/json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    String runSessionWithName(@PathParam("id") String id,
                              @PathParam("processId") String processID,
                              @PathParam("className") String className,
                              @PathParam("sessionName") String sessionName,
                              Object objectRequest);

}
