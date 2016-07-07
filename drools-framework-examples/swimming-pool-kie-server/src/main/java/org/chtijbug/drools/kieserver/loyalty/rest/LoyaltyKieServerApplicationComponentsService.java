package org.chtijbug.drools.kieserver.loyalty.rest;

import org.chtijbug.kieserver.services.drools.DroolsFrameworkRulesExecutionService;
import org.kie.server.services.api.KieServerApplicationComponentsService;
import org.kie.server.services.api.KieServerRegistry;
import org.kie.server.services.api.SupportedTransports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class LoyaltyKieServerApplicationComponentsService implements KieServerApplicationComponentsService {

    private static final String OWNER_EXTENSION = "DroolsFramework";

    public Collection<Object> getAppComponents(String extension, SupportedTransports type, Object... services) {
        // skip calls from other than owning extension
        if (!OWNER_EXTENSION.equals(extension)) {
            return Collections.emptyList();
        }

        DroolsFrameworkRulesExecutionService rulesExecutionService = null;
        KieServerRegistry context = null;

        for (Object object : services) {
            if (DroolsFrameworkRulesExecutionService.class.isAssignableFrom(object.getClass())) {
                DroolsFrameworkRulesExecutionService droolsFrameworkRulesExecutionService = (DroolsFrameworkRulesExecutionService) object;
                context = droolsFrameworkRulesExecutionService.getContext();
                rulesExecutionService = droolsFrameworkRulesExecutionService;
                continue;
            }
        }

        List<Object> components = new ArrayList<Object>(1);
        if (SupportedTransports.REST.equals(type)) {
            components.add(new swimmingpoolResource(rulesExecutionService, context));
        }

        return components;
    }

}
