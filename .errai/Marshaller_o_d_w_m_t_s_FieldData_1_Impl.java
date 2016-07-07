package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.FieldData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_FieldData_1_Impl implements GeneratedMarshaller<FieldData> {
  private FieldData[] EMPTY_ARRAY = new FieldData[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public FieldData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FieldData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FieldData.class, objId);
    }
    FieldData entity = new FieldData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("nature")) && (!obj.get("nature").isNull())) {
      entity.setNature(java_lang_Long.demarshall(obj.get("nature"), a1));
    }
    return entity;
  }

  public String marshall(FieldData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.FieldData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"nature\":").append(java_lang_Long.marshall(a0.getNature(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}