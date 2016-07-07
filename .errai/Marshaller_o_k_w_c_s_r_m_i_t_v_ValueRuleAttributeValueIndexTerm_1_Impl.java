package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeValueIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValueRuleAttributeValueIndexTerm_1_Impl implements GeneratedMarshaller<ValueRuleAttributeValueIndexTerm> {
  private ValueRuleAttributeValueIndexTerm[] EMPTY_ARRAY = new ValueRuleAttributeValueIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueRuleAttributeValueIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _109302417__1195259493_attributeValue(ValueRuleAttributeValueIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeValueIndexTerm::attributeValue;
  }-*/;

  private native static void _109302417__1195259493_attributeValue(ValueRuleAttributeValueIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeValueIndexTerm::attributeValue = value;
  }-*/;

  public ValueRuleAttributeValueIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueRuleAttributeValueIndexTerm.class, objId);
    }
    ValueRuleAttributeValueIndexTerm entity = new ValueRuleAttributeValueIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("attributeValue")) && (!obj.get("attributeValue").isNull())) {
      _109302417__1195259493_attributeValue(entity, java_lang_String.demarshall(obj.get("attributeValue"), a1));
    }
    return entity;
  }

  public String marshall(ValueRuleAttributeValueIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeValueIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"attributeValue\":").append(java_lang_String.marshall(_109302417__1195259493_attributeValue(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}