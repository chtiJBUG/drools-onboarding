package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ExpressionFormLine;
import org.drools.workbench.models.datamodel.rule.FactPattern;
import org.drools.workbench.models.datamodel.rule.FromAccumulateCompositeFactPattern;
import org.drools.workbench.models.datamodel.rule.IPattern;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_r_FromAccumulateCompositeFactPattern_1_Impl implements GeneratedMarshaller<FromAccumulateCompositeFactPattern> {
  private FromAccumulateCompositeFactPattern[] EMPTY_ARRAY = new FromAccumulateCompositeFactPattern[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ExpressionFormLine> org_drools_workbench_models_datamodel_rule_ExpressionFormLine = null;
  public FromAccumulateCompositeFactPattern[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FromAccumulateCompositeFactPattern demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FromAccumulateCompositeFactPattern.class, objId);
    }
    FromAccumulateCompositeFactPattern entity = new FromAccumulateCompositeFactPattern();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sourcePattern")) && (!obj.get("sourcePattern").isNull())) {
      entity.setSourcePattern((IPattern) ((ObjectMarshaller) java_lang_Object).demarshall(IPattern.class, obj.get("sourcePattern"), a1));
    }
    if ((obj.containsKey("initCode")) && (!obj.get("initCode").isNull())) {
      entity.setInitCode(java_lang_String.demarshall(obj.get("initCode"), a1));
    }
    if ((obj.containsKey("actionCode")) && (!obj.get("actionCode").isNull())) {
      entity.setActionCode(java_lang_String.demarshall(obj.get("actionCode"), a1));
    }
    if ((obj.containsKey("reverseCode")) && (!obj.get("reverseCode").isNull())) {
      entity.setReverseCode(java_lang_String.demarshall(obj.get("reverseCode"), a1));
    }
    if ((obj.containsKey("resultCode")) && (!obj.get("resultCode").isNull())) {
      entity.setResultCode(java_lang_String.demarshall(obj.get("resultCode"), a1));
    }
    if ((obj.containsKey("function")) && (!obj.get("function").isNull())) {
      entity.setFunction(java_lang_String.demarshall(obj.get("function"), a1));
    }
    if ((obj.containsKey("factPattern")) && (!obj.get("factPattern").isNull())) {
      entity.setFactPattern((FactPattern) ((ObjectMarshaller) java_lang_Object).demarshall(FactPattern.class, obj.get("factPattern"), a1));
    }
    if ((obj.containsKey("expression")) && (!obj.get("expression").isNull())) {
      entity.setExpression(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.demarshall(obj.get("expression"), a1));
    }
    return entity;
  }

  public String marshall(FromAccumulateCompositeFactPattern a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.FromAccumulateCompositeFactPattern\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sourcePattern\":").append(java_lang_Object.marshall(a0.getSourcePattern(), a1)).append(",").append("\"initCode\":").append(java_lang_String.marshall(a0.getInitCode(), a1)).append(",").append("\"actionCode\":").append(java_lang_String.marshall(a0.getActionCode(), a1)).append(",").append("\"reverseCode\":").append(java_lang_String.marshall(a0.getReverseCode(), a1)).append(",").append("\"resultCode\":").append(java_lang_String.marshall(a0.getResultCode(), a1)).append(",").append("\"function\":").append(java_lang_String.marshall(a0.getFunction(), a1)).append(",").append("\"factPattern\":").append(java_lang_Object.marshall(a0.getFactPattern(), a1)).append(",").append("\"expression\":").append(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.marshall(a0.getExpression(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_ExpressionFormLine == null) {
      org_drools_workbench_models_datamodel_rule_ExpressionFormLine = Marshalling.getMarshaller(ExpressionFormLine.class);
    }
  }
}