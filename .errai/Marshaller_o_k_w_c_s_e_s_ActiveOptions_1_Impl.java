package org.jboss.errai.marshalling.client.api;

import java.util.HashSet;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.explorer.service.ActiveOptions;
import org.kie.workbench.common.screens.explorer.service.Option;

public class Marshaller_o_k_w_c_s_e_s_ActiveOptions_1_Impl implements GeneratedMarshaller<ActiveOptions> {
  private ActiveOptions[] EMPTY_ARRAY = new ActiveOptions[0];
  private Marshaller<HashSet> java_util_HashSet = null;
  public ActiveOptions[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static HashSet _$1673417926__$1402716492_set(ActiveOptions instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ActiveOptions::set;
  }-*/;

  private native static void _$1673417926__$1402716492_set(ActiveOptions instance, HashSet<Option> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ActiveOptions::set = value;
  }-*/;

  public ActiveOptions demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActiveOptions.class, objId);
    }
    ActiveOptions entity = new ActiveOptions();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("set")) && (!obj.get("set").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.explorer.service.Option");
      _$1673417926__$1402716492_set(entity, java_util_HashSet.demarshall(obj.get("set"), a1));
    }
    return entity;
  }

  public String marshall(ActiveOptions a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.service.ActiveOptions\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"set\":").append(java_util_HashSet.marshall(_$1673417926__$1402716492_set(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashSet == null) {
      java_util_HashSet = Marshalling.getMarshaller(HashSet.class);
    }
  }
}