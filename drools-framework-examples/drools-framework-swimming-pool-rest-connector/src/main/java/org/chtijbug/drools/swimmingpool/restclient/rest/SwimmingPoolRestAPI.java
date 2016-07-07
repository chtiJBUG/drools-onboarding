package org.chtijbug.drools.swimmingpool.restclient.rest;


import org.chtijbug.example.swimmingpool.Quote;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface SwimmingPoolRestAPI {

    @POST
    @Path("/services/rest/server/containers/instances/swimmingpool/run/{id}")
    @Produces("application/json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    Quote runSession(@PathParam("id") String id,
                     Quote quoteRequest);

}
