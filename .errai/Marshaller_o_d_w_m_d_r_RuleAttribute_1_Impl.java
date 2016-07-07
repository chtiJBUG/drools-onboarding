package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.RuleAttribute;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_RuleAttribute_1_Impl implements GeneratedMarshaller<RuleAttribute> {
  private RuleAttribute[] EMPTY_ARRAY = new RuleAttribute[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public RuleAttribute[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuleAttribute demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleAttribute.class, objId);
    }
    RuleAttribute entity = new RuleAttribute();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("attributeName")) && (!obj.get("attributeName").isNull())) {
      entity.setAttributeName(java_lang_String.demarshall(obj.get("attributeName"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(RuleAttribute a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.RuleAttribute\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"attributeName\":").append(java_lang_String.marshall(a0.getAttributeName(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}