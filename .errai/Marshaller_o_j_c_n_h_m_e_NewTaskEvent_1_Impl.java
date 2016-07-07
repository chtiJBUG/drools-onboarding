package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.events.NewTaskEvent;

public class Marshaller_o_j_c_n_h_m_e_NewTaskEvent_1_Impl implements GeneratedMarshaller<NewTaskEvent> {
  private NewTaskEvent[] EMPTY_ARRAY = new NewTaskEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public NewTaskEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public NewTaskEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewTaskEvent.class, objId);
    }
    NewTaskEvent entity = new NewTaskEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("newTaskId")) && (!obj.get("newTaskId").isNull())) {
      entity.setNewTaskId(java_lang_Long.demarshall(obj.get("newTaskId"), a1));
    }
    if ((obj.containsKey("newTaskName")) && (!obj.get("newTaskName").isNull())) {
      entity.setNewTaskName(java_lang_String.demarshall(obj.get("newTaskName"), a1));
    }
    return entity;
  }

  public String marshall(NewTaskEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.events.NewTaskEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"newTaskId\":").append(java_lang_Long.marshall(a0.getNewTaskId(), a1)).append(",").append("\"newTaskName\":").append(java_lang_String.marshall(a0.getNewTaskName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}