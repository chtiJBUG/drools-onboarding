package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ht.model.TaskEventSummary;

public class Marshaller_o_j_c_n_h_m_TaskEventSummary_1_Impl implements GeneratedMarshaller<TaskEventSummary> {
  private TaskEventSummary[] EMPTY_ARRAY = new TaskEventSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public TaskEventSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _$1212678903__398795216_eventId(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::eventId;
  }-*/;

  private native static void _$1212678903__398795216_eventId(TaskEventSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::eventId = value;
  }-*/;

  private native static Long _$1212678903__398795216_taskId(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::taskId;
  }-*/;

  private native static void _$1212678903__398795216_taskId(TaskEventSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::taskId = value;
  }-*/;

  private native static String _$1212678903__1195259493_type(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::type;
  }-*/;

  private native static void _$1212678903__1195259493_type(TaskEventSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::type = value;
  }-*/;

  private native static String _$1212678903__1195259493_userId(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::userId;
  }-*/;

  private native static void _$1212678903__1195259493_userId(TaskEventSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::userId = value;
  }-*/;

  private native static Date _$1212678903__65575278_logTime(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::logTime;
  }-*/;

  private native static void _$1212678903__65575278_logTime(TaskEventSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::logTime = value;
  }-*/;

  private native static Long _$1212678903__398795216_workItemId(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::workItemId;
  }-*/;

  private native static void _$1212678903__398795216_workItemId(TaskEventSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::workItemId = value;
  }-*/;

  private native static String _$1212678903__1195259493_message(TaskEventSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::message;
  }-*/;

  private native static void _$1212678903__1195259493_message(TaskEventSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskEventSummary::message = value;
  }-*/;

  public TaskEventSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskEventSummary.class, objId);
    }
    TaskEventSummary entity = new TaskEventSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("eventId")) && (!obj.get("eventId").isNull())) {
      _$1212678903__398795216_eventId(entity, java_lang_Long.demarshall(obj.get("eventId"), a1));
    }
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      _$1212678903__398795216_taskId(entity, java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$1212678903__1195259493_type(entity, java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("userId")) && (!obj.get("userId").isNull())) {
      _$1212678903__1195259493_userId(entity, java_lang_String.demarshall(obj.get("userId"), a1));
    }
    if ((obj.containsKey("logTime")) && (!obj.get("logTime").isNull())) {
      _$1212678903__65575278_logTime(entity, java_util_Date.demarshall(obj.get("logTime"), a1));
    }
    if ((obj.containsKey("workItemId")) && (!obj.get("workItemId").isNull())) {
      _$1212678903__398795216_workItemId(entity, java_lang_Long.demarshall(obj.get("workItemId"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$1212678903__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(TaskEventSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TaskEventSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"eventId\":").append(java_lang_Long.marshall(a0.getEventId(), a1)).append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"userId\":").append(java_lang_String.marshall(a0.getUserId(), a1)).append(",").append("\"logTime\":").append(java_util_Date.marshall(a0.getLogTime(), a1)).append(",").append("\"workItemId\":").append(java_lang_Long.marshall(a0.getWorkItemId(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}