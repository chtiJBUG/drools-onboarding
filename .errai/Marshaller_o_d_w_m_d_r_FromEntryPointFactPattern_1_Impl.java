package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ExpressionFormLine;
import org.drools.workbench.models.datamodel.rule.FactPattern;
import org.drools.workbench.models.datamodel.rule.FromEntryPointFactPattern;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_r_FromEntryPointFactPattern_1_Impl implements GeneratedMarshaller<FromEntryPointFactPattern> {
  private FromEntryPointFactPattern[] EMPTY_ARRAY = new FromEntryPointFactPattern[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ExpressionFormLine> org_drools_workbench_models_datamodel_rule_ExpressionFormLine = null;
  public FromEntryPointFactPattern[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FromEntryPointFactPattern demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FromEntryPointFactPattern.class, objId);
    }
    FromEntryPointFactPattern entity = new FromEntryPointFactPattern();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("entryPointName")) && (!obj.get("entryPointName").isNull())) {
      entity.setEntryPointName(java_lang_String.demarshall(obj.get("entryPointName"), a1));
    }
    if ((obj.containsKey("factPattern")) && (!obj.get("factPattern").isNull())) {
      entity.setFactPattern((FactPattern) ((ObjectMarshaller) java_lang_Object).demarshall(FactPattern.class, obj.get("factPattern"), a1));
    }
    if ((obj.containsKey("expression")) && (!obj.get("expression").isNull())) {
      entity.setExpression(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.demarshall(obj.get("expression"), a1));
    }
    return entity;
  }

  public String marshall(FromEntryPointFactPattern a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.FromEntryPointFactPattern\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"entryPointName\":").append(java_lang_String.marshall(a0.getEntryPointName(), a1)).append(",").append("\"factPattern\":").append(java_lang_Object.marshall(a0.getFactPattern(), a1)).append(",").append("\"expression\":").append(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.marshall(a0.getExpression(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_ExpressionFormLine == null) {
      org_drools_workbench_models_datamodel_rule_ExpressionFormLine = Marshalling.getMarshaller(ExpressionFormLine.class);
    }
  }
}