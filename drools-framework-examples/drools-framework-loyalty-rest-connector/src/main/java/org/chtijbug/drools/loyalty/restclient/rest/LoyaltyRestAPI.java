package org.chtijbug.drools.loyalty.restclient.rest;




import loyalty.domains.Ticket;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface LoyaltyRestAPI {

    @POST
    @Path("/services/rest/server/containers/instances/loyalty/run/{id}")
    @Produces("application/json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    Ticket runSession(@PathParam("id") String id,
                      Ticket ticket);

}
