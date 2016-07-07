package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.ActionFieldValue;
import org.drools.workbench.models.datamodel.rule.ActionUpdateField;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_ActionUpdateField_1_Impl implements GeneratedMarshaller<ActionUpdateField> {
  private ActionUpdateField[] EMPTY_ARRAY = new ActionUpdateField[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ActionFieldValue[]> arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 implements GeneratedMarshaller { }
  public ActionUpdateField[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionUpdateField demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionUpdateField.class, objId);
    }
    ActionUpdateField entity = new ActionUpdateField();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("variable")) && (!obj.get("variable").isNull())) {
      entity.setVariable(java_lang_String.demarshall(obj.get("variable"), a1));
    }
    if ((obj.containsKey("fieldValues")) && (!obj.get("fieldValues").isNull())) {
      entity.setFieldValues(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.demarshall(obj.get("fieldValues"), a1));
    }
    return entity;
  }

  public String marshall(ActionUpdateField a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionUpdateField\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"variable\":").append(java_lang_String.marshall(a0.getVariable(), a1)).append(",").append("\"fieldValues\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.marshall(a0.getFieldValues(), a1)).append("}").toString();
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