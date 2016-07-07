package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import org.guvnor.common.services.project.model.Build;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_Build_1_Impl implements GeneratedMarshaller<Build> {
  private Build[] EMPTY_ARRAY = new Build[0];
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public Build[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Build demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Build.class, objId);
    }
    Build entity = new Build();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("plugins")) && (!obj.get("plugins").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Plugin");
      entity.setPlugins(java_util_ArrayList.demarshall(obj.get("plugins"), a1));
    }
    return entity;
  }

  public String marshall(Build a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Build\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"plugins\":").append(java_util_ArrayList.marshall(a0.getPlugins(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}