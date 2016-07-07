package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.guided.scorecard.shared.Characteristic;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_s_s_Characteristic_1_Impl implements GeneratedMarshaller<Characteristic> {
  private Characteristic[] EMPTY_ARRAY = new Characteristic[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Double> java_lang_Double = Marshalling.getMarshaller(Double.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public Characteristic[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Characteristic demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Characteristic.class, objId);
    }
    Characteristic entity = new Characteristic();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fact")) && (!obj.get("fact").isNull())) {
      entity.setFact(java_lang_String.demarshall(obj.get("fact"), a1));
    }
    if ((obj.containsKey("field")) && (!obj.get("field").isNull())) {
      entity.setField(java_lang_String.demarshall(obj.get("field"), a1));
    }
    if ((obj.containsKey("baselineScore")) && (!obj.get("baselineScore").isNull())) {
      entity.setBaselineScore(java_lang_Double.demarshall(obj.get("baselineScore"), a1));
    }
    if ((obj.containsKey("reasonCode")) && (!obj.get("reasonCode").isNull())) {
      entity.setReasonCode(java_lang_String.demarshall(obj.get("reasonCode"), a1));
    }
    if ((obj.containsKey("attributes")) && (!obj.get("attributes").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.scorecard.shared.Attribute");
      entity.setAttributes(java_util_List.demarshall(obj.get("attributes"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("dataType")) && (!obj.get("dataType").isNull())) {
      entity.setDataType(java_lang_String.demarshall(obj.get("dataType"), a1));
    }
    return entity;
  }

  public String marshall(Characteristic a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.scorecard.shared.Characteristic\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fact\":").append(java_lang_String.marshall(a0.getFact(), a1)).append(",").append("\"field\":").append(java_lang_String.marshall(a0.getField(), a1)).append(",").append("\"baselineScore\":").append(java_lang_Double.marshall(a0.getBaselineScore(), a1)).append(",").append("\"reasonCode\":").append(java_lang_String.marshall(a0.getReasonCode(), a1)).append(",").append("\"attributes\":").append(java_util_List.marshall(a0.getAttributes(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"dataType\":").append(java_lang_String.marshall(a0.getDataType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}