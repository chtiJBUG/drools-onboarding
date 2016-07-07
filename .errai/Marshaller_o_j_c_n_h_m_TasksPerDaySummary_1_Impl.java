package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ht.model.Day;
import org.jbpm.console.ng.ht.model.TaskSummary;
import org.jbpm.console.ng.ht.model.TasksPerDaySummary;

public class Marshaller_o_j_c_n_h_m_TasksPerDaySummary_1_Impl implements GeneratedMarshaller<TasksPerDaySummary> {
  private TasksPerDaySummary[] EMPTY_ARRAY = new TasksPerDaySummary[0];
  private Marshaller<Day> org_jbpm_console_ng_ht_model_Day = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public TasksPerDaySummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Day _$938490447__1699488100_day(TasksPerDaySummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TasksPerDaySummary::day;
  }-*/;

  private native static void _$938490447__1699488100_day(TasksPerDaySummary instance, Day value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TasksPerDaySummary::day = value;
  }-*/;

  private native static List _$938490447__65821278_tasks(TasksPerDaySummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TasksPerDaySummary::tasks;
  }-*/;

  private native static void _$938490447__65821278_tasks(TasksPerDaySummary instance, List<TaskSummary> value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TasksPerDaySummary::tasks = value;
  }-*/;

  public TasksPerDaySummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TasksPerDaySummary.class, objId);
    }
    TasksPerDaySummary entity = new TasksPerDaySummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("day")) && (!obj.get("day").isNull())) {
      _$938490447__1699488100_day(entity, org_jbpm_console_ng_ht_model_Day.demarshall(obj.get("day"), a1));
    }
    if ((obj.containsKey("tasks")) && (!obj.get("tasks").isNull())) {
      a1.setAssumedElementType("org.jbpm.console.ng.ht.model.TaskSummary");
      _$938490447__65821278_tasks(entity, java_util_List.demarshall(obj.get("tasks"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(TasksPerDaySummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TasksPerDaySummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"day\":").append(org_jbpm_console_ng_ht_model_Day.marshall(a0.getDay(), a1)).append(",").append("\"tasks\":").append(java_util_List.marshall(a0.getTasks(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_jbpm_console_ng_ht_model_Day == null) {
      org_jbpm_console_ng_ht_model_Day = Marshalling.getMarshaller(Day.class);
    }
  }
}