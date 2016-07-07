package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.pr.model.ProcessInstanceVariableSummary;

public class Marshaller_o_j_c_n_p_m_ProcessInstanceVariableSummary_1_Impl implements GeneratedMarshaller<ProcessInstanceVariableSummary> {
  private ProcessInstanceVariableSummary[] EMPTY_ARRAY = new ProcessInstanceVariableSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ProcessInstanceVariableSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessInstanceVariableSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstanceVariableSummary.class, objId);
    }
    ProcessInstanceVariableSummary entity = new ProcessInstanceVariableSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      entity.setProcessInstanceId(java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processName")) && (!obj.get("processName").isNull())) {
      entity.setProcessName(java_lang_String.demarshall(obj.get("processName"), a1));
    }
    if ((obj.containsKey("variableId")) && (!obj.get("variableId").isNull())) {
      entity.setVariableId(java_lang_Long.demarshall(obj.get("variableId"), a1));
    }
    if ((obj.containsKey("variableValue")) && (!obj.get("variableValue").isNull())) {
      entity.setVariableValue(java_lang_String.demarshall(obj.get("variableValue"), a1));
    }
    if ((obj.containsKey("variableName")) && (!obj.get("variableName").isNull())) {
      entity.setVariableName(java_lang_String.demarshall(obj.get("variableName"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstanceVariableSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessInstanceVariableSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processName\":").append(java_lang_String.marshall(a0.getProcessName(), a1)).append(",").append("\"variableId\":").append(java_lang_Long.marshall(a0.getVariableId(), a1)).append(",").append("\"variableValue\":").append(java_lang_String.marshall(a0.getVariableValue(), a1)).append(",").append("\"variableName\":").append(java_lang_String.marshall(a0.getVariableName(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}