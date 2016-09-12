package org.chtijbug.drools.carinsurance.restclient.rest;






import org.chtijbug.drools.carinsurance.model.QuoteRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface CarInsuranceRestAPI {

    @POST
    @Path("/services/rest/server/containers/instances/carinsurance/run/{id}")
    @Produces("application/json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    QuoteRequest runSession(@PathParam("id") String id,
                            QuoteRequest ticket);

}
