package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValueRuleIndexTerm_1_Impl implements GeneratedMarshaller<ValueRuleIndexTerm> {
  private ValueRuleIndexTerm[] EMPTY_ARRAY = new ValueRuleIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueRuleIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$358927034__1195259493_ruleName(ValueRuleIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleIndexTerm::ruleName;
  }-*/;

  private native static void _$358927034__1195259493_ruleName(ValueRuleIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleIndexTerm::ruleName = value;
  }-*/;

  public ValueRuleIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueRuleIndexTerm.class, objId);
    }
    ValueRuleIndexTerm entity = new ValueRuleIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("ruleName")) && (!obj.get("ruleName").isNull())) {
      _$358927034__1195259493_ruleName(entity, java_lang_String.demarshall(obj.get("ruleName"), a1));
    }
    return entity;
  }

  public String marshall(ValueRuleIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueRuleIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"ruleName\":").append(java_lang_String.marshall(_$358927034__1195259493_ruleName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}