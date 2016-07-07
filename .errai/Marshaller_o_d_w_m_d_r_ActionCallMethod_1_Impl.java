package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.ActionCallMethod;
import org.drools.workbench.models.datamodel.rule.ActionFieldValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_ActionCallMethod_1_Impl implements GeneratedMarshaller<ActionCallMethod> {
  private ActionCallMethod[] EMPTY_ARRAY = new ActionCallMethod[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ActionFieldValue[]> arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1 implements GeneratedMarshaller { }
  public ActionCallMethod[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionCallMethod demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionCallMethod.class, objId);
    }
    ActionCallMethod entity = new ActionCallMethod();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("state")) && (!obj.get("state").isNull())) {
      entity.setState(java_lang_Integer.demarshall(obj.get("state"), a1));
    }
    if ((obj.containsKey("methodName")) && (!obj.get("methodName").isNull())) {
      entity.setMethodName(java_lang_String.demarshall(obj.get("methodName"), a1));
    }
    if ((obj.containsKey("variable")) && (!obj.get("variable").isNull())) {
      entity.setVariable(java_lang_String.demarshall(obj.get("variable"), a1));
    }
    if ((obj.containsKey("fieldValues")) && (!obj.get("fieldValues").isNull())) {
      entity.setFieldValues(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.demarshall(obj.get("fieldValues"), a1));
    }
    return entity;
  }

  public String marshall(ActionCallMethod a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionCallMethod\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"state\":").append(java_lang_Integer.marshall(a0.getState(), a1)).append(",").append("\"methodName\":").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"variable\":").append(java_lang_String.marshall(a0.getVariable(), a1)).append(",").append("\"fieldValues\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_ActionFieldValue_D1.marshall(a0.getFieldValues(), a1)).append("}").toString();
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