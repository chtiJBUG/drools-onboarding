package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ActionFieldValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ActionFieldValue_1_Impl implements GeneratedMarshaller<ActionFieldValue> {
  private ActionFieldValue[] EMPTY_ARRAY = new ActionFieldValue[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public ActionFieldValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionFieldValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionFieldValue.class, objId);
    }
    ActionFieldValue entity = new ActionFieldValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("field")) && (!obj.get("field").isNull())) {
      entity.setField(java_lang_String.demarshall(obj.get("field"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("nature")) && (!obj.get("nature").isNull())) {
      entity.setNature(java_lang_Integer.demarshall(obj.get("nature"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    return entity;
  }

  public String marshall(ActionFieldValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionFieldValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"field\":").append(java_lang_String.marshall(a0.getField(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"nature\":").append(java_lang_Integer.marshall(a0.getNature(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}