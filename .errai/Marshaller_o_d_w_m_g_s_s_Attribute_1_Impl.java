package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.scorecard.shared.Attribute;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_s_s_Attribute_1_Impl implements GeneratedMarshaller<Attribute> {
  private Attribute[] EMPTY_ARRAY = new Attribute[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Double> java_lang_Double = Marshalling.getMarshaller(Double.class);
  public Attribute[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Attribute demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Attribute.class, objId);
    }
    Attribute entity = new Attribute();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("partialScore")) && (!obj.get("partialScore").isNull())) {
      entity.setPartialScore(java_lang_Double.demarshall(obj.get("partialScore"), a1));
    }
    if ((obj.containsKey("reasonCode")) && (!obj.get("reasonCode").isNull())) {
      entity.setReasonCode(java_lang_String.demarshall(obj.get("reasonCode"), a1));
    }
    if ((obj.containsKey("operator")) && (!obj.get("operator").isNull())) {
      entity.setOperator(java_lang_String.demarshall(obj.get("operator"), a1));
    }
    return entity;
  }

  public String marshall(Attribute a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.scorecard.shared.Attribute\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"partialScore\":").append(java_lang_Double.marshall(a0.getPartialScore(), a1)).append(",").append("\"reasonCode\":").append(java_lang_String.marshall(a0.getReasonCode(), a1)).append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}