package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.CallFieldValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_CallFieldValue_1_Impl implements GeneratedMarshaller<CallFieldValue> {
  private CallFieldValue[] EMPTY_ARRAY = new CallFieldValue[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public CallFieldValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CallFieldValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CallFieldValue.class, objId);
    }
    CallFieldValue entity = new CallFieldValue();
    a1.recordObject(objId, entity);
    entity.field = java_lang_String.demarshall(obj.get("field"), a1);
    entity.value = java_lang_String.demarshall(obj.get("value"), a1);
    entity.nature = java_lang_Integer.demarshall(obj.get("nature"), a1);
    entity.type = java_lang_String.demarshall(obj.get("type"), a1);
    return entity;
  }

  public String marshall(CallFieldValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.CallFieldValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"field\":").append(java_lang_String.marshall(a0.field, a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.value, a1)).append(",").append("\"nature\":").append(java_lang_Integer.marshall(a0.nature, a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.type, a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}