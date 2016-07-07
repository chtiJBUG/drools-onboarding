package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ht.model.TaskSummary;

public class Marshaller_o_j_c_n_h_m_TaskSummary_1_Impl implements GeneratedMarshaller<TaskSummary> {
  private TaskSummary[] EMPTY_ARRAY = new TaskSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public TaskSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _1252266025__398795216_taskId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::taskId;
  }-*/;

  private native static void _1252266025__398795216_taskId(TaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::taskId = value;
  }-*/;

  private native static String _1252266025__1195259493_taskName(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::taskName;
  }-*/;

  private native static void _1252266025__1195259493_taskName(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::taskName = value;
  }-*/;

  private native static String _1252266025__1195259493_description(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::description;
  }-*/;

  private native static void _1252266025__1195259493_description(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::description = value;
  }-*/;

  private native static String _1252266025__1195259493_status(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::status;
  }-*/;

  private native static void _1252266025__1195259493_status(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::status = value;
  }-*/;

  private native static int _1252266025__104431_priority(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::priority;
  }-*/;

  private native static void _1252266025__104431_priority(TaskSummary instance, int value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::priority = value;
  }-*/;

  private native static String _1252266025__1195259493_actualOwner(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::actualOwner;
  }-*/;

  private native static void _1252266025__1195259493_actualOwner(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::actualOwner = value;
  }-*/;

  private native static String _1252266025__1195259493_createdBy(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::createdBy;
  }-*/;

  private native static void _1252266025__1195259493_createdBy(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::createdBy = value;
  }-*/;

  private native static Date _1252266025__65575278_createdOn(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::createdOn;
  }-*/;

  private native static void _1252266025__65575278_createdOn(TaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::createdOn = value;
  }-*/;

  private native static Date _1252266025__65575278_activationTime(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::activationTime;
  }-*/;

  private native static void _1252266025__65575278_activationTime(TaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::activationTime = value;
  }-*/;

  private native static Date _1252266025__65575278_expirationTime(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::expirationTime;
  }-*/;

  private native static void _1252266025__65575278_expirationTime(TaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::expirationTime = value;
  }-*/;

  private native static Long _1252266025__398795216_processInstanceId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::processInstanceId;
  }-*/;

  private native static void _1252266025__398795216_processInstanceId(TaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::processInstanceId = value;
  }-*/;

  private native static String _1252266025__1195259493_processId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::processId;
  }-*/;

  private native static void _1252266025__1195259493_processId(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::processId = value;
  }-*/;

  private native static Long _1252266025__398795216_processSessionId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::processSessionId;
  }-*/;

  private native static void _1252266025__398795216_processSessionId(TaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::processSessionId = value;
  }-*/;

  private native static String _1252266025__1195259493_deploymentId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::deploymentId;
  }-*/;

  private native static void _1252266025__1195259493_deploymentId(TaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::deploymentId = value;
  }-*/;

  private native static boolean _1252266025__64711720_isForAdmin(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::isForAdmin;
  }-*/;

  private native static void _1252266025__64711720_isForAdmin(TaskSummary instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::isForAdmin = value;
  }-*/;

  private native static boolean _1252266025__64711720_isLogOnly(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::isLogOnly;
  }-*/;

  private native static void _1252266025__64711720_isLogOnly(TaskSummary instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::isLogOnly = value;
  }-*/;

  private native static Long _1252266025__398795216_parentId(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::parentId;
  }-*/;

  private native static void _1252266025__398795216_parentId(TaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::parentId = value;
  }-*/;

  private native static Map _1252266025__$1383349348_domainData(TaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskSummary::domainData;
  }-*/;

  private native static void _1252266025__$1383349348_domainData(TaskSummary instance, Map<String, String> value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskSummary::domainData = value;
  }-*/;

  public TaskSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskSummary.class, objId);
    }
    TaskSummary entity = new TaskSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      _1252266025__398795216_taskId(entity, java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("taskName")) && (!obj.get("taskName").isNull())) {
      _1252266025__1195259493_taskName(entity, java_lang_String.demarshall(obj.get("taskName"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      _1252266025__1195259493_description(entity, java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      _1252266025__1195259493_status(entity, java_lang_String.demarshall(obj.get("status"), a1));
    }
    if ((obj.containsKey("priority")) && (!obj.get("priority").isNull())) {
      _1252266025__104431_priority(entity, java_lang_Integer.demarshall(obj.get("priority"), a1));
    }
    if ((obj.containsKey("actualOwner")) && (!obj.get("actualOwner").isNull())) {
      _1252266025__1195259493_actualOwner(entity, java_lang_String.demarshall(obj.get("actualOwner"), a1));
    }
    if ((obj.containsKey("createdBy")) && (!obj.get("createdBy").isNull())) {
      _1252266025__1195259493_createdBy(entity, java_lang_String.demarshall(obj.get("createdBy"), a1));
    }
    if ((obj.containsKey("createdOn")) && (!obj.get("createdOn").isNull())) {
      _1252266025__65575278_createdOn(entity, java_util_Date.demarshall(obj.get("createdOn"), a1));
    }
    if ((obj.containsKey("activationTime")) && (!obj.get("activationTime").isNull())) {
      _1252266025__65575278_activationTime(entity, java_util_Date.demarshall(obj.get("activationTime"), a1));
    }
    if ((obj.containsKey("expirationTime")) && (!obj.get("expirationTime").isNull())) {
      _1252266025__65575278_expirationTime(entity, java_util_Date.demarshall(obj.get("expirationTime"), a1));
    }
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      _1252266025__398795216_processInstanceId(entity, java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      _1252266025__1195259493_processId(entity, java_lang_String.demarshall(obj.get("processId"), a1));
    }
    if ((obj.containsKey("processSessionId")) && (!obj.get("processSessionId").isNull())) {
      _1252266025__398795216_processSessionId(entity, java_lang_Long.demarshall(obj.get("processSessionId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _1252266025__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("isForAdmin")) && (!obj.get("isForAdmin").isNull())) {
      _1252266025__64711720_isForAdmin(entity, java_lang_Boolean.demarshall(obj.get("isForAdmin"), a1));
    }
    if ((obj.containsKey("isLogOnly")) && (!obj.get("isLogOnly").isNull())) {
      _1252266025__64711720_isLogOnly(entity, java_lang_Boolean.demarshall(obj.get("isLogOnly"), a1));
    }
    if ((obj.containsKey("parentId")) && (!obj.get("parentId").isNull())) {
      _1252266025__398795216_parentId(entity, java_lang_Long.demarshall(obj.get("parentId"), a1));
    }
    if ((obj.containsKey("potOwnersString")) && (!obj.get("potOwnersString").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setPotOwnersString(java_util_List.demarshall(obj.get("potOwnersString"), a1));
    }
    if ((obj.containsKey("domainData")) && (!obj.get("domainData").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _1252266025__$1383349348_domainData(entity, java_util_Map.demarshall(obj.get("domainData"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(TaskSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TaskSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"taskName\":").append(java_lang_String.marshall(a0.getTaskName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"status\":").append(java_lang_String.marshall(a0.getStatus(), a1)).append(",").append("\"priority\":").append(java_lang_Integer.marshall(a0.getPriority(), a1)).append(",").append("\"actualOwner\":").append(java_lang_String.marshall(a0.getActualOwner(), a1)).append(",").append("\"createdBy\":").append(java_lang_String.marshall(a0.getCreatedBy(), a1)).append(",").append("\"createdOn\":").append(java_util_Date.marshall(a0.getCreatedOn(), a1)).append(",").append("\"activationTime\":").append(java_util_Date.marshall(a0.getActivationTime(), a1)).append(",").append("\"expirationTime\":").append(java_util_Date.marshall(a0.getExpirationTime(), a1)).append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(_1252266025__398795216_processInstanceId(a0), a1)).append(",").append("\"processId\":").append(java_lang_String.marshall(a0.getProcessId(), a1)).append(",").append("\"processSessionId\":").append(java_lang_Long.marshall(_1252266025__398795216_processSessionId(a0), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"isForAdmin\":").append(java_lang_Boolean.marshall(_1252266025__64711720_isForAdmin(a0), a1)).append(",").append("\"isLogOnly\":").append(java_lang_Boolean.marshall(_1252266025__64711720_isLogOnly(a0), a1)).append(",").append("\"parentId\":").append(java_lang_Long.marshall(_1252266025__398795216_parentId(a0), a1)).append(",").append("\"potOwnersString\":").append(java_util_List.marshall(a0.getPotOwnersString(), a1)).append(",").append("\"domainData\":").append(java_util_Map.marshall(a0.getDomainData(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}