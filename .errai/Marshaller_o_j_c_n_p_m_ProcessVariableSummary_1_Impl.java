package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.pr.model.ProcessVariableSummary;

public class Marshaller_o_j_c_n_p_m_ProcessVariableSummary_1_Impl implements GeneratedMarshaller<ProcessVariableSummary> {
  private ProcessVariableSummary[] EMPTY_ARRAY = new ProcessVariableSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ProcessVariableSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessVariableSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessVariableSummary.class, objId);
    }
    ProcessVariableSummary entity = new ProcessVariableSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("variableId")) && (!obj.get("variableId").isNull())) {
      entity.setVariableId(java_lang_String.demarshall(obj.get("variableId"), a1));
    }
    if ((obj.containsKey("variableInstanceId")) && (!obj.get("variableInstanceId").isNull())) {
      entity.setVariableInstanceId(java_lang_String.demarshall(obj.get("variableInstanceId"), a1));
    }
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      entity.setProcessInstanceId(java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("oldValue")) && (!obj.get("oldValue").isNull())) {
      entity.setOldValue(java_lang_String.demarshall(obj.get("oldValue"), a1));
    }
    if ((obj.containsKey("newValue")) && (!obj.get("newValue").isNull())) {
      entity.setNewValue(java_lang_String.demarshall(obj.get("newValue"), a1));
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      entity.setTimestamp(java_lang_Long.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ProcessVariableSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessVariableSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"variableId\":").append(java_lang_String.marshall(a0.getVariableId(), a1)).append(",").append("\"variableInstanceId\":").append(java_lang_String.marshall(a0.getVariableInstanceId(), a1)).append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"oldValue\":").append(java_lang_String.marshall(a0.getOldValue(), a1)).append(",").append("\"newValue\":").append(java_lang_String.marshall(a0.getNewValue(), a1)).append(",").append("\"timestamp\":").append(java_lang_Long.marshall(a0.getTimestamp(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}