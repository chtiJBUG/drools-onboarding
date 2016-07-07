package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.globals.model.Global;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_g_m_Global_1_Impl implements GeneratedMarshaller<Global> {
  private Global[] EMPTY_ARRAY = new Global[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Global[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Global demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Global.class, objId);
    }
    Global entity = new Global();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("alias")) && (!obj.get("alias").isNull())) {
      entity.setAlias(java_lang_String.demarshall(obj.get("alias"), a1));
    }
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    return entity;
  }

  public String marshall(Global a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.globals.model.Global\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"alias\":").append(java_lang_String.marshall(a0.getAlias(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}