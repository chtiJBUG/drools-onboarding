package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ht.model.AuditTaskSummary;

public class Marshaller_o_j_c_n_h_m_AuditTaskSummary_1_Impl implements GeneratedMarshaller<AuditTaskSummary> {
  private AuditTaskSummary[] EMPTY_ARRAY = new AuditTaskSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public AuditTaskSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _$158898498__398795216_taskId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::taskId;
  }-*/;

  private native static void _$158898498__398795216_taskId(AuditTaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::taskId = value;
  }-*/;

  private native static String _$158898498__1195259493_status(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::status;
  }-*/;

  private native static void _$158898498__1195259493_status(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::status = value;
  }-*/;

  private native static Date _$158898498__65575278_activationTime(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::activationTime;
  }-*/;

  private native static void _$158898498__65575278_activationTime(AuditTaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::activationTime = value;
  }-*/;

  private native static String _$158898498__1195259493_taskName(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::taskName;
  }-*/;

  private native static void _$158898498__1195259493_taskName(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::taskName = value;
  }-*/;

  private native static String _$158898498__1195259493_description(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::description;
  }-*/;

  private native static void _$158898498__1195259493_description(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::description = value;
  }-*/;

  private native static int _$158898498__104431_priority(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::priority;
  }-*/;

  private native static void _$158898498__104431_priority(AuditTaskSummary instance, int value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::priority = value;
  }-*/;

  private native static String _$158898498__1195259493_createdBy(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::createdBy;
  }-*/;

  private native static void _$158898498__1195259493_createdBy(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::createdBy = value;
  }-*/;

  private native static String _$158898498__1195259493_actualOwner(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::actualOwner;
  }-*/;

  private native static void _$158898498__1195259493_actualOwner(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::actualOwner = value;
  }-*/;

  private native static Date _$158898498__65575278_createdOn(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::createdOn;
  }-*/;

  private native static void _$158898498__65575278_createdOn(AuditTaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::createdOn = value;
  }-*/;

  private native static Date _$158898498__65575278_dueDate(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::dueDate;
  }-*/;

  private native static void _$158898498__65575278_dueDate(AuditTaskSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::dueDate = value;
  }-*/;

  private native static Long _$158898498__398795216_processInstanceId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processInstanceId;
  }-*/;

  private native static void _$158898498__398795216_processInstanceId(AuditTaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processInstanceId = value;
  }-*/;

  private native static String _$158898498__1195259493_processId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processId;
  }-*/;

  private native static void _$158898498__1195259493_processId(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processId = value;
  }-*/;

  private native static Long _$158898498__398795216_processSessionId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processSessionId;
  }-*/;

  private native static void _$158898498__398795216_processSessionId(AuditTaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::processSessionId = value;
  }-*/;

  private native static Long _$158898498__398795216_parentId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::parentId;
  }-*/;

  private native static void _$158898498__398795216_parentId(AuditTaskSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::parentId = value;
  }-*/;

  private native static String _$158898498__1195259493_deploymentId(AuditTaskSummary instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::deploymentId;
  }-*/;

  private native static void _$158898498__1195259493_deploymentId(AuditTaskSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.ht.model.AuditTaskSummary::deploymentId = value;
  }-*/;

  public AuditTaskSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AuditTaskSummary.class, objId);
    }
    AuditTaskSummary entity = new AuditTaskSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      _$158898498__398795216_taskId(entity, java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      _$158898498__1195259493_status(entity, java_lang_String.demarshall(obj.get("status"), a1));
    }
    if ((obj.containsKey("activationTime")) && (!obj.get("activationTime").isNull())) {
      _$158898498__65575278_activationTime(entity, java_util_Date.demarshall(obj.get("activationTime"), a1));
    }
    if ((obj.containsKey("taskName")) && (!obj.get("taskName").isNull())) {
      _$158898498__1195259493_taskName(entity, java_lang_String.demarshall(obj.get("taskName"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      _$158898498__1195259493_description(entity, java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("priority")) && (!obj.get("priority").isNull())) {
      _$158898498__104431_priority(entity, java_lang_Integer.demarshall(obj.get("priority"), a1));
    }
    if ((obj.containsKey("createdBy")) && (!obj.get("createdBy").isNull())) {
      _$158898498__1195259493_createdBy(entity, java_lang_String.demarshall(obj.get("createdBy"), a1));
    }
    if ((obj.containsKey("actualOwner")) && (!obj.get("actualOwner").isNull())) {
      _$158898498__1195259493_actualOwner(entity, java_lang_String.demarshall(obj.get("actualOwner"), a1));
    }
    if ((obj.containsKey("createdOn")) && (!obj.get("createdOn").isNull())) {
      _$158898498__65575278_createdOn(entity, java_util_Date.demarshall(obj.get("createdOn"), a1));
    }
    if ((obj.containsKey("dueDate")) && (!obj.get("dueDate").isNull())) {
      _$158898498__65575278_dueDate(entity, java_util_Date.demarshall(obj.get("dueDate"), a1));
    }
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      _$158898498__398795216_processInstanceId(entity, java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      _$158898498__1195259493_processId(entity, java_lang_String.demarshall(obj.get("processId"), a1));
    }
    if ((obj.containsKey("processSessionId")) && (!obj.get("processSessionId").isNull())) {
      _$158898498__398795216_processSessionId(entity, java_lang_Long.demarshall(obj.get("processSessionId"), a1));
    }
    if ((obj.containsKey("parentId")) && (!obj.get("parentId").isNull())) {
      _$158898498__398795216_parentId(entity, java_lang_Long.demarshall(obj.get("parentId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _$158898498__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(AuditTaskSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.AuditTaskSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append(",").append("\"status\":").append(java_lang_String.marshall(a0.getStatus(), a1)).append(",").append("\"activationTime\":").append(java_util_Date.marshall(a0.getActivationTime(), a1)).append(",").append("\"taskName\":").append(java_lang_String.marshall(a0.getTaskName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"priority\":").append(java_lang_Integer.marshall(a0.getPriority(), a1)).append(",").append("\"createdBy\":").append(java_lang_String.marshall(a0.getCreatedBy(), a1)).append(",").append("\"actualOwner\":").append(java_lang_String.marshall(a0.getActualOwner(), a1)).append(",").append("\"createdOn\":").append(java_util_Date.marshall(a0.getCreatedOn(), a1)).append(",").append("\"dueDate\":").append(java_util_Date.marshall(a0.getDueDate(), a1)).append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processId\":").append(java_lang_String.marshall(a0.getProcessId(), a1)).append(",").append("\"processSessionId\":").append(java_lang_Long.marshall(_$158898498__398795216_processSessionId(a0), a1)).append(",").append("\"parentId\":").append(java_lang_Long.marshall(a0.getParentId(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}