package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessInstancesWithDetailsRequestEvent_1_Impl implements GeneratedMarshaller<ProcessInstancesWithDetailsRequestEvent> {
  private ProcessInstancesWithDetailsRequestEvent[] EMPTY_ARRAY = new ProcessInstancesWithDetailsRequestEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public ProcessInstancesWithDetailsRequestEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _$2035735003__398795216_processInstanceId(ProcessInstancesWithDetailsRequestEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processInstanceId;
  }-*/;

  private native static void _$2035735003__398795216_processInstanceId(ProcessInstancesWithDetailsRequestEvent instance, Long value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processInstanceId = value;
  }-*/;

  private native static String _$2035735003__1195259493_processDefId(ProcessInstancesWithDetailsRequestEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processDefId;
  }-*/;

  private native static void _$2035735003__1195259493_processDefId(ProcessInstancesWithDetailsRequestEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processDefId = value;
  }-*/;

  private native static String _$2035735003__1195259493_deploymentId(ProcessInstancesWithDetailsRequestEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::deploymentId;
  }-*/;

  private native static void _$2035735003__1195259493_deploymentId(ProcessInstancesWithDetailsRequestEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::deploymentId = value;
  }-*/;

  private native static Integer _$2035735003__$2056817302_processInstanceStatus(ProcessInstancesWithDetailsRequestEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processInstanceStatus;
  }-*/;

  private native static void _$2035735003__$2056817302_processInstanceStatus(ProcessInstancesWithDetailsRequestEvent instance, Integer value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processInstanceStatus = value;
  }-*/;

  private native static String _$2035735003__1195259493_processDefName(ProcessInstancesWithDetailsRequestEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processDefName;
  }-*/;

  private native static void _$2035735003__1195259493_processDefName(ProcessInstancesWithDetailsRequestEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent::processDefName = value;
  }-*/;

  public ProcessInstancesWithDetailsRequestEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstancesWithDetailsRequestEvent.class, objId);
    }
    ProcessInstancesWithDetailsRequestEvent entity = new ProcessInstancesWithDetailsRequestEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      _$2035735003__398795216_processInstanceId(entity, java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processDefId")) && (!obj.get("processDefId").isNull())) {
      _$2035735003__1195259493_processDefId(entity, java_lang_String.demarshall(obj.get("processDefId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _$2035735003__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("processInstanceStatus")) && (!obj.get("processInstanceStatus").isNull())) {
      _$2035735003__$2056817302_processInstanceStatus(entity, java_lang_Integer.demarshall(obj.get("processInstanceStatus"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      _$2035735003__1195259493_processDefName(entity, java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstancesWithDetailsRequestEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessInstancesWithDetailsRequestEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processDefId\":").append(java_lang_String.marshall(a0.getProcessDefId(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"processInstanceStatus\":").append(java_lang_Integer.marshall(a0.getProcessInstanceStatus(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}