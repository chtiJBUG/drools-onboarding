package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.events.TaskRefreshedEvent;

public class Marshaller_o_j_c_n_h_m_e_TaskRefreshedEvent_1_Impl implements GeneratedMarshaller<TaskRefreshedEvent> {
  private TaskRefreshedEvent[] EMPTY_ARRAY = new TaskRefreshedEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public TaskRefreshedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TaskRefreshedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskRefreshedEvent.class, objId);
    }
    TaskRefreshedEvent entity = new TaskRefreshedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      entity.setTaskId(java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("taskName")) && (!obj.get("taskName").isNull())) {
      entity.setTaskName(java_lang_String.demarshall(obj.get("taskName"), a1));
    }
    return entity;
  }

  public String marshall(TaskRefreshedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.events.TaskRefreshedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"taskName\":").append(java_lang_String.marshall(a0.getTaskName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}