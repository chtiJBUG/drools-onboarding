package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.events.TaskSelectionEvent;

public class Marshaller_o_j_c_n_h_m_e_TaskSelectionEvent_1_Impl implements GeneratedMarshaller<TaskSelectionEvent> {
  private TaskSelectionEvent[] EMPTY_ARRAY = new TaskSelectionEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public TaskSelectionEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _730632272__398795216_taskId(TaskSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::taskId;
  }-*/;

  private native static void _730632272__398795216_taskId(TaskSelectionEvent instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::taskId = value;
  }-*/;

  private native static String _730632272__1195259493_taskName(TaskSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::taskName;
  }-*/;

  private native static void _730632272__1195259493_taskName(TaskSelectionEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::taskName = value;
  }-*/;

  private native static boolean _730632272__64711720_forAdmin(TaskSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::forAdmin;
  }-*/;

  private native static void _730632272__64711720_forAdmin(TaskSelectionEvent instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::forAdmin = value;
  }-*/;

  private native static boolean _730632272__64711720_forLog(TaskSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::forLog;
  }-*/;

  private native static void _730632272__64711720_forLog(TaskSelectionEvent instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ht.model.events.TaskSelectionEvent::forLog = value;
  }-*/;

  public TaskSelectionEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskSelectionEvent.class, objId);
    }
    TaskSelectionEvent entity = new TaskSelectionEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      _730632272__398795216_taskId(entity, java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("taskName")) && (!obj.get("taskName").isNull())) {
      _730632272__1195259493_taskName(entity, java_lang_String.demarshall(obj.get("taskName"), a1));
    }
    if ((obj.containsKey("forAdmin")) && (!obj.get("forAdmin").isNull())) {
      _730632272__64711720_forAdmin(entity, java_lang_Boolean.demarshall(obj.get("forAdmin"), a1));
    }
    if ((obj.containsKey("forLog")) && (!obj.get("forLog").isNull())) {
      _730632272__64711720_forLog(entity, java_lang_Boolean.demarshall(obj.get("forLog"), a1));
    }
    return entity;
  }

  public String marshall(TaskSelectionEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.events.TaskSelectionEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"taskName\":").append(java_lang_String.marshall(a0.getTaskName(), a1)).append(",").append("\"forAdmin\":").append(java_lang_Boolean.marshall(_730632272__64711720_forAdmin(a0), a1)).append(",").append("\"forLog\":").append(java_lang_Boolean.marshall(_730632272__64711720_forLog(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}