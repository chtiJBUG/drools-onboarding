package org.chtijbug.drools.kieserver.loyalty.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import loyalty.domains.Ticket;
import org.chtijbug.kieserver.services.drools.ChtijbugObjectRequest;
import org.chtijbug.kieserver.services.drools.DroolsFrameworkRulesExecutionService;
import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.api.KieServerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("server/containers/instances/loyalty/")
public class LoyaltyResource {

    private static final Logger logger = LoggerFactory.getLogger(LoyaltyResource.class);

    private DroolsFrameworkRulesExecutionService rulesExecutionService;
    private KieServerRegistry registry;
    private ObjectMapper mapper = new ObjectMapper();
    public LoyaltyResource() {

    }

    public LoyaltyResource(DroolsFrameworkRulesExecutionService rulesExecutionService, KieServerRegistry registry) {
        this.rulesExecutionService = rulesExecutionService;
        this.registry = registry;
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @POST
    @Path("/run/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ticket runSession(@PathParam("id") String id,
                             Ticket quoteRequest) {
        try {
            KieContainerInstance kci = registry.getContainer(id);
            ChtijbugObjectRequest chtijbugObjectRequest = new ChtijbugObjectRequest();
            chtijbugObjectRequest.setObjectRequest(quoteRequest);
            ChtijbugObjectRequest chtijbutObjectResponse = (ChtijbugObjectRequest) rulesExecutionService.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, "swimmingpool.P000");
            String jsonInString = mapper.writeValueAsString(chtijbutObjectResponse.getSessionLogging());
            Ticket response = (Ticket) chtijbutObjectResponse.getObjectRequest();

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
