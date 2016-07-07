package org.jboss.errai.marshalling.client.api;

import java.util.HashMap;
import org.guvnor.common.services.project.model.GAV;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.dependencies.EnhancedDependencies;
import org.kie.workbench.common.services.shared.dependencies.EnhancedDependency;

public class Marshaller_o_k_w_c_s_s_d_EnhancedDependencies_1_Impl implements GeneratedMarshaller<EnhancedDependencies> {
  private EnhancedDependencies[] EMPTY_ARRAY = new EnhancedDependencies[0];
  private Marshaller<HashMap> java_util_HashMap = null;
  public EnhancedDependencies[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static HashMap _$1007655256__$1402722386_enhancedDependencies(EnhancedDependencies instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependencies::enhancedDependencies;
  }-*/;

  private native static void _$1007655256__$1402722386_enhancedDependencies(EnhancedDependencies instance, HashMap<GAV, EnhancedDependency> value) /*-{
    instance.@org.kie.workbench.common.services.shared.dependencies.EnhancedDependencies::enhancedDependencies = value;
  }-*/;

  public EnhancedDependencies demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EnhancedDependencies.class, objId);
    }
    EnhancedDependencies entity = new EnhancedDependencies();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("enhancedDependencies")) && (!obj.get("enhancedDependencies").isNull())) {
      a1.setAssumedMapKeyType("org.guvnor.common.services.project.model.GAV");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.shared.dependencies.EnhancedDependency");
      _$1007655256__$1402722386_enhancedDependencies(entity, java_util_HashMap.demarshall(obj.get("enhancedDependencies"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(EnhancedDependencies a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.dependencies.EnhancedDependencies\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"enhancedDependencies\":").append(java_util_HashMap.marshall(_$1007655256__$1402722386_enhancedDependencies(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
  }
}