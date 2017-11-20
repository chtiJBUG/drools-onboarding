package org.chtijbug.drools.kieserver.drools.rest;

import org.chtijbug.kieserver.services.drools.DroolsChtijbugRulesExecutionService;
import org.kie.server.services.api.KieServerApplicationComponentsService;
import org.kie.server.services.api.KieServerRegistry;
import org.kie.server.services.api.SupportedTransports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GenericKieServerApplicationComponentsService implements KieServerApplicationComponentsService {

    private static final String OWNER_EXTENSION = "DroolsFramework";

    public Collection<Object> getAppComponents(String extension, SupportedTransports type, Object... services) {
        // skip calls from other than owning extension
        if (!OWNER_EXTENSION.equals(extension)) {
            return Collections.emptyList();
        }

        DroolsChtijbugRulesExecutionService rulesExecutionService = null;
        KieServerRegistry context = null;

        for (Object object : services) {
            if (DroolsChtijbugRulesExecutionService.class.isAssignableFrom(object.getClass())) {
                DroolsChtijbugRulesExecutionService droolsFrameworkRulesExecutionService = (DroolsChtijbugRulesExecutionService) object;
                context = droolsFrameworkRulesExecutionService.getContext();
                rulesExecutionService = droolsFrameworkRulesExecutionService;
                continue;
            }
        }

        List<Object> components = new ArrayList<Object>(1);
        if (SupportedTransports.REST.equals(type)) {
            components.add(new GenericResource(rulesExecutionService, context));
        }

        return components;
    }

}
