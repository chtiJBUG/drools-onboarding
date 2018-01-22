package org.chtijbug.drools.kieserver.drools.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.chtijbug.drools.kieserver.extension.KieServerAddOnElement;
import org.chtijbug.drools.kieserver.extension.KieServerLoggingDefinition;
import org.chtijbug.kieserver.services.drools.ChtijbugObjectRequest;
import org.chtijbug.kieserver.services.drools.DroolsChtijbugRulesExecutionService;
import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.api.KieServerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("server/containers/instances/generic/")
public class GenericResource {

    private static final Logger logger = LoggerFactory.getLogger(GenericResource.class);

    private DroolsChtijbugRulesExecutionService rulesExecutionService;
    private KieServerRegistry registry;
    private ObjectMapper mapper = new ObjectMapper();

    public GenericResource() {

    }

    public GenericResource(DroolsChtijbugRulesExecutionService rulesExecutionService, KieServerRegistry registry) {
        this.rulesExecutionService = rulesExecutionService;
        this.registry = registry;
    }

    private Class getClassFromName(Set<Class<?>> classes, String name) {
        Class result = null;
        for (Class c : classes) {
            if (c.getCanonicalName() != null
                    && c.getCanonicalName().equals(name)) {
                result = c;
                break;
            }
        }
        return result;
    }



    @POST
    @Path("/run/{id}/{processId}/{className}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object runSession(@PathParam("id") String id,
                             @PathParam("processId") String processID,
                             @PathParam("className") String className,
                             String objectRequest) {
        ClassLoader localClassLoader = null;
        Object response = null;
        try {
            localClassLoader = Thread.currentThread()
                    .getContextClassLoader();
        } catch (ClassCastException e) {
            logger.info("DroolsFactObject.updateRealObjectFromJSON", e);
        }
        try {

            KieContainerInstance kci = registry.getContainer(id);
            Set<Class<?>> classes = kci.getExtraClasses();
            Class foundClass = this.getClassFromName(classes, className);
            if (foundClass != null) {
                ClassLoader classLoader = foundClass.getClassLoader();
                Object input = mapper.readValue(objectRequest, classLoader.loadClass(className));
                ChtijbugObjectRequest chtijbugObjectRequest = new ChtijbugObjectRequest();
                chtijbugObjectRequest.setObjectRequest(input);
                KieServerAddOnElement kieServerAddOnElement = rulesExecutionService.getKieServerAddOnElement();
                if (kieServerAddOnElement != null) {
                    for (KieServerLoggingDefinition kieServerLoggingDefinition : kieServerAddOnElement.getKieServerLoggingDefinitions()) {
                        kieServerLoggingDefinition.OnFireAllrulesStart(kci.getKieContainer().getReleaseId().getGroupId(), kci.getKieContainer().getReleaseId().getArtifactId(), kci.getKieContainer().getReleaseId().getVersion(), input);
                    }
                }
                ChtijbugObjectRequest chtijbutObjectResponse = rulesExecutionService.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, processID);
                if (kieServerAddOnElement != null) {

                    for (KieServerLoggingDefinition kieServerLoggingDefinition : kieServerAddOnElement.getKieServerLoggingDefinitions()) {
                        kieServerLoggingDefinition.OnFireAllrulesEnd(kci.getKieContainer().getReleaseId().getGroupId(), kci.getKieContainer().getReleaseId().getArtifactId(), kci.getKieContainer().getReleaseId().getVersion(), chtijbutObjectResponse.getObjectRequest(), chtijbutObjectResponse.getSessionLogging());
                    }
                }
                response = chtijbutObjectResponse.getObjectRequest();
            }
            //response.setSessionLogging(jsonInString);
            logger.debug("Returning OK response with content '{}'", response);
            return response;
        } catch (Exception e) {
            // in case marshalling failed return the FireAllRulesAndStartProcess container response to keep backward compatibility
            String responseMessage = "Execution failed with error : " + e.getMessage();
            logger.debug("Returning Failure response with content '{}'", responseMessage);
            return objectRequest;
        } finally {
            if (localClassLoader != null) {
                Thread.currentThread().setContextClassLoader(localClassLoader);
            }
        }

    }

    @POST
    @Path("/runSessionName/{id}/{processId}/{className}/{sessionName}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object runSessionWithName(@PathParam("id") String id,
                                     @PathParam("processId") String processID,
                                     @PathParam("className") String className,
                                     @PathParam("sessionName") String sessionName,
                                     String objectRequest) {
        ClassLoader localClassLoader = null;
        Object response = null;
        try {
            localClassLoader = Thread.currentThread()
                    .getContextClassLoader();
        } catch (ClassCastException e) {
            logger.info("DroolsFactObject.updateRealObjectFromJSON", e);
        }
        try {

            KieContainerInstance kci = registry.getContainer(id);
            Set<Class<?>> classes = kci.getExtraClasses();
            Class foundClass = this.getClassFromName(classes, className);
            if (foundClass != null) {
                ClassLoader classLoader = foundClass.getClassLoader();
                Object input = mapper.readValue(objectRequest, classLoader.loadClass(className));
                ChtijbugObjectRequest chtijbugObjectRequest = new ChtijbugObjectRequest();
                chtijbugObjectRequest.setObjectRequest(input);
                ChtijbugObjectRequest chtijbutObjectResponse = rulesExecutionService.FireAllRulesAndStartProcess(kci, chtijbugObjectRequest, processID, sessionName);
                ObjectMapper mapper = new ObjectMapper();
                //String jsonInString = mapper.writeValueAsString(chtijbutObjectResponse.getSessionLogging());
                response = chtijbutObjectResponse.getObjectRequest();
            }
            //response.setSessionLogging(jsonInString);
            logger.debug("Returning OK response with content '{}'", objectRequest);
            return response;
        } catch (Exception e) {
            // in case marshalling failed return the FireAllRulesAndStartProcess container response to keep backward compatibility
            String responseMessage = "Execution failed with error : " + e.getMessage();
            logger.debug("Returning Failure response with content '{}'", responseMessage);
            return objectRequest;
        } finally {
            if (localClassLoader != null) {
                Thread.currentThread().setContextClassLoader(localClassLoader);
            }
        }

    }
}
