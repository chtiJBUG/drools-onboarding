package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.testscenarios.shared.CallFieldValue;
import org.drools.workbench.models.testscenarios.shared.CallMethod;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_t_s_CallMethod_1_Impl implements GeneratedMarshaller<CallMethod> {
  private CallMethod[] EMPTY_ARRAY = new CallMethod[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<CallFieldValue[]> arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1 implements GeneratedMarshaller { }
  public CallMethod[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CallMethod demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CallMethod.class, objId);
    }
    CallMethod entity = new CallMethod();
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
    if ((obj.containsKey("callFieldValues")) && (!obj.get("callFieldValues").isNull())) {
      entity.setCallFieldValues(arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1.demarshall(obj.get("callFieldValues"), a1));
    }
    return entity;
  }

  public String marshall(CallMethod a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.CallMethod\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"state\":").append(java_lang_Integer.marshall(a0.getState(), a1)).append(",").append("\"methodName\":").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"variable\":").append(java_lang_String.marshall(a0.getVariable(), a1)).append(",").append("\"callFieldValues\":").append(arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1.marshall(a0.getCallFieldValues(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1 == null) {
      arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1 = Marshalling.getMarshaller(CallFieldValue[].class, new DeferredMarshallerCreationCallback<CallFieldValue[]>() {
        public Marshaller<CallFieldValue[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_testscenarios_shared_CallFieldValue_D1.class), CallFieldValue[].class);
        }
      });
    }
  }
}