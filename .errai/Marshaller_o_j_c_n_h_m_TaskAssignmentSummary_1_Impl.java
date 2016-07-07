package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ht.model.TaskAssignmentSummary;

public class Marshaller_o_j_c_n_h_m_TaskAssignmentSummary_1_Impl implements GeneratedMarshaller<TaskAssignmentSummary> {
  private TaskAssignmentSummary[] EMPTY_ARRAY = new TaskAssignmentSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public TaskAssignmentSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TaskAssignmentSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskAssignmentSummary.class, objId);
    }
    TaskAssignmentSummary entity = new TaskAssignmentSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      entity.setTaskId(java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("taskName")) && (!obj.get("taskName").isNull())) {
      entity.setTaskName(java_lang_String.demarshall(obj.get("taskName"), a1));
    }
    if ((obj.containsKey("actualOwner")) && (!obj.get("actualOwner").isNull())) {
      entity.setActualOwner(java_lang_String.demarshall(obj.get("actualOwner"), a1));
    }
    if ((obj.containsKey("potOwnersString")) && (!obj.get("potOwnersString").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setPotOwnersString(java_util_List.demarshall(obj.get("potOwnersString"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(TaskAssignmentSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TaskAssignmentSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"taskName\":").append(java_lang_String.marshall(a0.getTaskName(), a1)).append(",").append("\"actualOwner\":").append(java_lang_String.marshall(a0.getActualOwner(), a1)).append(",").append("\"potOwnersString\":").append(java_util_List.marshall(a0.getPotOwnersString(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}