package org.chtijbug.kie.rest.backend;

import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.internal.io.ResourceFactory;
import org.uberfire.backend.vfs.Path;
import org.uberfire.workbench.type.ResourceTypeDefinition;

/**
 * Created by nheron on 23/01/15.
 */
public class RestTypeDefinition implements ResourceTypeDefinition {
    @Override
    public String getShortName() {
        return "restFrameworkTypeElement";
    }

    @Override
    public String getDescription() {
        return "restFrameworkTypeElement";
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public String getSuffix() {
        return "";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getSimpleWildcardPattern() {
        return "*";
    }

    @Override
    public boolean accept(Path path) {
        boolean result = false;
        Resource zz = ResourceFactory.newFileResource("rr");

        if (path.getFileName().endsWith("." + ResourceType.DRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.GDRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.RDRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.XDRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.DSL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.DSLR.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.RDSLR.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.DRF.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.BPMN2.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.DTABLE.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.BRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.XSD.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.SCARD.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.TDRL.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.BAYES.getDefaultExtension())
                //  ||path.getFileName().endsWith("." + ResourceType.JAVA.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.PROPERTIES.getDefaultExtension())
                || path.getFileName().endsWith("." + ResourceType.DESCR.getDefaultExtension())

                ) {
            result = true;
        }
        return result;
    }
}
