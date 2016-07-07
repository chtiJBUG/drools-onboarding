package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.Map;
import org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint;
import org.drools.workbench.models.datamodel.rule.ConnectiveConstraint;
import org.drools.workbench.models.datamodel.rule.ExpressionFormLine;
import org.drools.workbench.models.datamodel.rule.FieldConstraint;
import org.drools.workbench.models.datamodel.rule.SingleFieldConstraintEBLeftSide;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_SingleFieldConstraintEBLeftSide_1_Impl implements GeneratedMarshaller<SingleFieldConstraintEBLeftSide> {
  private SingleFieldConstraintEBLeftSide[] EMPTY_ARRAY = new SingleFieldConstraintEBLeftSide[0];
  private Marshaller<ExpressionFormLine> org_drools_workbench_models_datamodel_rule_ExpressionFormLine = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ConnectiveConstraint[]> arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1 = null;
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1 implements GeneratedMarshaller { }
  public SingleFieldConstraintEBLeftSide[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ExpressionFormLine _$1217437139__525466253_expLeftSide(SingleFieldConstraintEBLeftSide instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.SingleFieldConstraintEBLeftSide::expLeftSide;
  }-*/;

  private native static void _$1217437139__525466253_expLeftSide(SingleFieldConstraintEBLeftSide instance, ExpressionFormLine value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.SingleFieldConstraintEBLeftSide::expLeftSide = value;
  }-*/;

  private native static ExpressionFormLine _$623735007__525466253_expression(BaseSingleFieldConstraint instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint::expression;
  }-*/;

  private native static void _$623735007__525466253_expression(BaseSingleFieldConstraint instance, ExpressionFormLine value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.BaseSingleFieldConstraint::expression = value;
  }-*/;

  public SingleFieldConstraintEBLeftSide demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SingleFieldConstraintEBLeftSide.class, objId);
    }
    SingleFieldConstraintEBLeftSide entity = new SingleFieldConstraintEBLeftSide();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("expLeftSide")) && (!obj.get("expLeftSide").isNull())) {
      _$1217437139__525466253_expLeftSide(entity, org_drools_workbench_models_datamodel_rule_ExpressionFormLine.demarshall(obj.get("expLeftSide"), a1));
    }
    if ((obj.containsKey("fieldBinding")) && (!obj.get("fieldBinding").isNull())) {
      entity.setFieldBinding(java_lang_String.demarshall(obj.get("fieldBinding"), a1));
    }
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("fieldType")) && (!obj.get("fieldType").isNull())) {
      entity.setFieldType(java_lang_String.demarshall(obj.get("fieldType"), a1));
    }
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      entity.setParent((FieldConstraint) ((ObjectMarshaller) java_lang_Object).demarshall(FieldConstraint.class, obj.get("parent"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("connectives")) && (!obj.get("connectives").isNull())) {
      entity.setConnectives(arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1.demarshall(obj.get("connectives"), a1));
    }
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

  public String marshall(SingleFieldConstraintEBLeftSide a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.SingleFieldConstraintEBLeftSide\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"expLeftSide\":").append(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.marshall(_$1217437139__525466253_expLeftSide(a0), a1)).append(",").append("\"fieldBinding\":").append(java_lang_String.marshall(a0.getFieldBinding(), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"fieldType\":").append(java_lang_String.marshall(a0.getFieldType(), a1)).append(",").append("\"parent\":").append(java_lang_Object.marshall(a0.getParent(), a1)).append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"connectives\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1.marshall(a0.getConnectives(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append(",").append("\"constraintValueType\":").append(java_lang_Integer.marshall(a0.getConstraintValueType(), a1)).append(",").append("\"expression\":").append(org_drools_workbench_models_datamodel_rule_ExpressionFormLine.marshall(_$623735007__525466253_expression(a0), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(a0.getParameters(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_ExpressionFormLine == null) {
      org_drools_workbench_models_datamodel_rule_ExpressionFormLine = Marshalling.getMarshaller(ExpressionFormLine.class);
    }
    if (arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1 = Marshalling.getMarshaller(ConnectiveConstraint[].class, new DeferredMarshallerCreationCallback<ConnectiveConstraint[]>() {
        public Marshaller<ConnectiveConstraint[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ConnectiveConstraint_D1.class), ConnectiveConstraint[].class);
        }
      });
    }
  }
}