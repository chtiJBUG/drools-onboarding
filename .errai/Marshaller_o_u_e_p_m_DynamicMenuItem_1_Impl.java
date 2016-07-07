package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.DynamicMenuItem;

public class Marshaller_o_u_e_p_m_DynamicMenuItem_1_Impl implements GeneratedMarshaller<DynamicMenuItem> {
  private DynamicMenuItem[] EMPTY_ARRAY = new DynamicMenuItem[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DynamicMenuItem[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DynamicMenuItem demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DynamicMenuItem.class, objId);
    }
    DynamicMenuItem entity = new DynamicMenuItem();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("activityId")) && (!obj.get("activityId").isNull())) {
      entity.setActivityId(java_lang_String.demarshall(obj.get("activityId"), a1));
    }
    if ((obj.containsKey("menuLabel")) && (!obj.get("menuLabel").isNull())) {
      entity.setMenuLabel(java_lang_String.demarshall(obj.get("menuLabel"), a1));
    }
    return entity;
  }

  public String marshall(DynamicMenuItem a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.DynamicMenuItem\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"activityId\":").append(java_lang_String.marshall(a0.getActivityId(), a1)).append(",").append("\"menuLabel\":").append(java_lang_String.marshall(a0.getMenuLabel(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}