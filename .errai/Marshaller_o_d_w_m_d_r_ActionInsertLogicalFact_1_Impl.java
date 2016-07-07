package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.ActionFieldValue;
import org.drools.workbench.models.datamodel.rule.ActionInsertFact;
import org.drools.workbench.models.datamodel.rule.ActionInsertLogicalFact;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_ActionInsertLogicalFact_1_Impl implements GeneratedMarshaller<ActionInsertLogicalFact> {
  private ActionInsertLogicalFact[] EMPTY_ARRAY = new ActionInsertLogicalFact[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<ActionFieldValue[]> arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 implements GeneratedMarshaller { }
  public ActionInsertLogicalFact[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1283547176__64711720_isBound(ActionInsertFact instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ActionInsertFact::isBound;
  }-*/;

  private native static void _$1283547176__64711720_isBound(ActionInsertFact instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ActionInsertFact::isBound = value;
  }-*/;

  public ActionInsertLogicalFact demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionInsertLogicalFact.class, objId);
    }
    ActionInsertLogicalFact entity = new ActionInsertLogicalFact();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("boundName")) && (!obj.get("boundName").isNull())) {
      entity.setBoundName(java_lang_String.demarshall(obj.get("boundName"), a1));
    }
    if ((obj.containsKey("isBound")) && (!obj.get("isBound").isNull())) {
      _$1283547176__64711720_isBound(entity, java_lang_Boolean.demarshall(obj.get("isBound"), a1));
    }
    if ((obj.containsKey("fieldValues")) && (!obj.get("fieldValues").isNull())) {
      entity.setFieldValues(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.demarshall(obj.get("fieldValues"), a1));
    }
    return entity;
  }

  public String marshall(ActionInsertLogicalFact a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionInsertLogicalFact\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"isBound\":").append(java_lang_Boolean.marshall(_$1283547176__64711720_isBound(a0), a1)).append(",").append("\"fieldValues\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.marshall(a0.getFieldValues(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 = Marshalling.getMarshaller(ActionFieldValue[].class, new DeferredMarshallerCreationCallback<ActionFieldValue[]>() {
        public Marshaller<ActionFieldValue[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.class), ActionFieldValue[].class);
        }
      });
    }
  }
}