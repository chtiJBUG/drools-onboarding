package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.RuntimePlugin;

public class Marshaller_o_u_e_p_m_RuntimePlugin_1_Impl implements GeneratedMarshaller<RuntimePlugin> {
  private RuntimePlugin[] EMPTY_ARRAY = new RuntimePlugin[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public RuntimePlugin[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuntimePlugin demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuntimePlugin.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("style"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("script"), a1);
    RuntimePlugin entity = new RuntimePlugin(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(RuntimePlugin a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.RuntimePlugin\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"style\":").append(java_lang_String.marshall(a0.getStyle(), a1)).append(",").append("\"script\":").append(java_lang_String.marshall(a0.getScript(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}