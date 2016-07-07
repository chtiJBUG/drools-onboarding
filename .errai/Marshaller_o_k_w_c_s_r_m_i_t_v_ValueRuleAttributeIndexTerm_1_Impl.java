package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValueRuleAttributeIndexTerm_1_Impl implements GeneratedMarshaller<ValueRuleAttributeIndexTerm> {
  private ValueRuleAttributeIndexTerm[] EMPTY_ARRAY = new ValueRuleAttributeIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueRuleAttributeIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1443349818__1195259493_attributeName(ValueRuleAttributeIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeIndexTerm::attributeName;
  }-*/;

  private native static void _1443349818__1195259493_attributeName(ValueRuleAttributeIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeIndexTerm::attributeName = value;
  }-*/;

  public ValueRuleAttributeIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueRuleAttributeIndexTerm.class, objId);
    }
    ValueRuleAttributeIndexTerm entity = new ValueRuleAttributeIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("attributeName")) && (!obj.get("attributeName").isNull())) {
      _1443349818__1195259493_attributeName(entity, java_lang_String.demarshall(obj.get("attributeName"), a1));
    }
    return entity;
  }

  public String marshall(ValueRuleAttributeIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleAttributeIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"attributeName\":").append(java_lang_String.marshall(_1443349818__1195259493_attributeName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}