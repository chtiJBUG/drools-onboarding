package org.chtijbug.drools.kieserver.loyalty.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.chtijbug.example.swimmingpool.Quote;
import org.chtijbug.kieserver.services.drools.ChtijbugObjectRequest;
import org.chtijbug.kieserver.services.drools.DroolsFrameworkRulesExecutionService;
import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.api.KieServerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("server/containers/instances/swimmingpool/")
public class swimmingpoolResource {

    private static final Logger logger = LoggerFactory.getLogger(swimmingpoolResource.class);

    private DroolsFrameworkRulesExecutionService rulesExecutionService;
    private KieServerRegistry registry;

    public swimmingpoolResource() {

    }

    public swimmingpoolResource(DroolsFrameworkRulesExecutionService rulesExecutionService, KieServerRegistry registry) {
        this.rulesExecutionService = rulesExecutionService;
        this.registry = registry;
    }

    @POST
    @Path("/run/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Quote runSession(@PathParam("id") String id,
                            Quote quoteRequest) {
        try {
            KieContainerInstance kci = registry.getContainer(id);
            ChtijbugObjectRequest chtijbugObjectRequest = new ChtijbugObjectRequest();
            chtijbugObjectRequest.setObjectRequest(quoteRequest);
            ChtijbugObjectRequest chtijbutObjectResponse = (ChtijbugObjectRequest) rulesExecutionService.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, "swimmingpool.P000");
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(chtijbutObjectResponse.getSessionLogging());
            Quote response = (Quote) chtijbutObjectResponse.getObjectRequest();
            response.setSessionLogging(jsonInString);
            logger.debug("Returning OK response with content '{}'", quoteRequest);
            return response;
        } catch (Exception e) {
            // in case marshalling failed return the FireAllRulesAndStartProcess container response to keep backward compatibility
            String response = "Execution failed with error : " + e.getMessage();
            logger.debug("Returning Failure response with content '{}'", response);
            return quoteRequest;
        }

    }
}
