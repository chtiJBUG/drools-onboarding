package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.ActionFieldValue;
import org.drools.workbench.models.datamodel.rule.ActionInsertFact;
import org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactCol52;
import org.drools.workbench.models.guided.dtable.shared.model.adaptors.ActionInsertFactCol52ActionInsertFactAdaptor;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_g_d_s_m_a_ActionInsertFactCol52ActionInsertFactAdaptor_1_Impl implements GeneratedMarshaller<ActionInsertFactCol52ActionInsertFactAdaptor> {
  private ActionInsertFactCol52ActionInsertFactAdaptor[] EMPTY_ARRAY = new ActionInsertFactCol52ActionInsertFactAdaptor[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<ActionFieldValue[]> arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 implements GeneratedMarshaller { }
  public ActionInsertFactCol52ActionInsertFactAdaptor[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ActionInsertFactCol52 _$1070730978__$1290599432_action(ActionInsertFactCol52ActionInsertFactAdaptor instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.adaptors.ActionInsertFactCol52ActionInsertFactAdaptor::action;
  }-*/;

  private native static void _$1070730978__$1290599432_action(ActionInsertFactCol52ActionInsertFactAdaptor instance, ActionInsertFactCol52 value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.adaptors.ActionInsertFactCol52ActionInsertFactAdaptor::action = value;
  }-*/;

  private native static boolean _$1283547176__64711720_isBound(ActionInsertFact instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ActionInsertFact::isBound;
  }-*/;

  private native static void _$1283547176__64711720_isBound(ActionInsertFact instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ActionInsertFact::isBound = value;
  }-*/;

  public ActionInsertFactCol52ActionInsertFactAdaptor demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionInsertFactCol52ActionInsertFactAdaptor.class, objId);
    }
    ActionInsertFactCol52ActionInsertFactAdaptor entity = new ActionInsertFactCol52ActionInsertFactAdaptor();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("action")) && (!obj.get("action").isNull())) {
      _$1070730978__$1290599432_action(entity, (ActionInsertFactCol52) ((ObjectMarshaller) java_lang_Object).demarshall(ActionInsertFactCol52.class, obj.get("action"), a1));
    }
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

  public String marshall(ActionInsertFactCol52ActionInsertFactAdaptor a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.adaptors.ActionInsertFactCol52ActionInsertFactAdaptor\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"action\":").append(java_lang_Object.marshall(_$1070730978__$1290599432_action(a0), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"isBound\":").append(java_lang_Boolean.marshall(_$1283547176__64711720_isBound(a0), a1)).append(",").append("\"fieldValues\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.marshall(a0.getFieldValues(), a1)).append("}").toString();
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