package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.guvnor.common.services.project.model.Dependency;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.dependencies.EnhancedDependency;
import org.kie.workbench.common.services.shared.dependencies.TransitiveEnhancedDependency;

public class Marshaller_o_k_w_c_s_s_d_TransitiveEnhancedDependency_1_Impl implements GeneratedMarshaller<TransitiveEnhancedDependency> {
  private TransitiveEnhancedDependency[] EMPTY_ARRAY = new TransitiveEnhancedDependency[0];
  private Marshaller<Dependency> org_guvnor_common_services_project_model_Dependency = null;
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public TransitiveEnhancedDependency[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Dependency _240291978__$1616947571_dependency(EnhancedDependency instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependency::dependency;
  }-*/;

  private native static void _240291978__$1616947571_dependency(EnhancedDependency instance, Dependency value) /*-{
    instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependency::dependency = value;
  }-*/;

  private native static Set _240291978__$1383343454_packageNames(EnhancedDependency instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependency::packageNames;
  }-*/;

  private native static void _240291978__$1383343454_packageNames(EnhancedDependency instance, Set<String> value) /*-{
    instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependency::packageNames = value;
  }-*/;

  public TransitiveEnhancedDependency demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TransitiveEnhancedDependency.class, objId);
    }
    TransitiveEnhancedDependency entity = new TransitiveEnhancedDependency();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dependency")) && (!obj.get("dependency").isNull())) {
      _240291978__$1616947571_dependency(entity, org_guvnor_common_services_project_model_Dependency.demarshall(obj.get("dependency"), a1));
    }
    if ((obj.containsKey("packageNames")) && (!obj.get("packageNames").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _240291978__$1383343454_packageNames(entity, java_util_Set.demarshall(obj.get("packageNames"), a1));
    }
    return entity;
  }

  public String marshall(TransitiveEnhancedDependency a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.dependencies.TransitiveEnhancedDependency\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dependency\":").append(org_guvnor_common_services_project_model_Dependency.marshall(a0.getDependency(), a1)).append(",").append("\"packageNames\":").append(java_util_Set.marshall(_240291978__$1383343454_packageNames(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_Dependency == null) {
      org_guvnor_common_services_project_model_Dependency = Marshalling.getMarshaller(Dependency.class);
    }
  }
}