package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.events.TaskCalendarEvent;

public class Marshaller_o_j_c_n_h_m_e_TaskCalendarEvent_1_Impl implements GeneratedMarshaller<TaskCalendarEvent> {
  private TaskCalendarEvent[] EMPTY_ARRAY = new TaskCalendarEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public TaskCalendarEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TaskCalendarEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskCalendarEvent.class, objId);
    }
    TaskCalendarEvent entity = new TaskCalendarEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskEventId")) && (!obj.get("taskEventId").isNull())) {
      entity.setTaskEventId(java_lang_Long.demarshall(obj.get("taskEventId"), a1));
    }
    return entity;
  }

  public String marshall(TaskCalendarEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.events.TaskCalendarEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskEventId\":").append(java_lang_Long.marshall(a0.getTaskEventId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}