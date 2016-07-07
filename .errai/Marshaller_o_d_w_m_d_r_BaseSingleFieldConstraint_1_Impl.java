package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint;
import org.drools.workbench.models.datamodel.rule.ExpressionFormLine;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_BaseSingleFieldConstraint_1_Impl implements GeneratedMarshaller<BaseSingleFieldConstraint> {
  private BaseSingleFieldConstraint[] EMPTY_ARRAY = new BaseSingleFieldConstraint[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<ExpressionFormLine> org_drools_workbench_models_datamodel_rule_ExpressionFormLine = null;
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public BaseSingleFieldConstraint[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ExpressionFormLine _$623735007__525466253_expression(BaseSingleFieldConstraint instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint::expression;
  }-*/;

  private native static void _$623735007__525466253_expression(BaseSingleFieldConstraint instance, ExpressionFormLine value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint::expression = value;
  }-*/;

  public BaseSingleFieldConstraint demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BaseSingleFieldConstraint.class, objId);
    }
    BaseSingleFieldConstraint entity = new BaseSingleFieldConstraint();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("operator")) && (!obj.get("operator").isNull())) {
      entity.setOperator(java_lang_String.demarshall(obj.get("operator"), a1));
    }
    if ((obj.containsKey("constraintValueType")) && (!obj.get("constraintValueType").isNull())) {
      entity.setConstraintValueType(java_lang_Integer.demarshall(obj.get("constraintValueType"), a1));
    }
    if ((obj.containsKey("expression")) && (!obj.get("expression").isNull())) {
      _$623735007__525466253_expression(entity, org_drools_workbench_models_datamodel_rule_ExpressionFormLine.demarshall(obj.get("expression"), a1));
    }
    if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setParameters(java_util_Map.demarshall(obj.get("parameters"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(BaseSingleFieldConstraint a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append(",").append("\"constraintValueType\":").append(java_lang_Integer.marshall(a0.getConstraintValueType(), a1)).append(",").append("\"expression\":").append(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.marshall(_$623735007__525466253_expression(a0), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(a0.getParameters(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_ExpressionFormLine == null) {
      org_drools_workbench_models_datamodel_rule_ExpressionFormLine = Marshalling.getMarshaller(ExpressionFormLine.class);
    }
  }
}