package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessInstanceSelectionEvent_1_Impl implements GeneratedMarshaller<ProcessInstanceSelectionEvent> {
  private ProcessInstanceSelectionEvent[] EMPTY_ARRAY = new ProcessInstanceSelectionEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public ProcessInstanceSelectionEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _822909919__398795216_processInstanceId(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processInstanceId;
  }-*/;

  private native static void _822909919__398795216_processInstanceId(ProcessInstanceSelectionEvent instance, Long value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processInstanceId = value;
  }-*/;

  private native static String _822909919__1195259493_processDefId(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processDefId;
  }-*/;

  private native static void _822909919__1195259493_processDefId(ProcessInstanceSelectionEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processDefId = value;
  }-*/;

  private native static String _822909919__1195259493_deploymentId(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::deploymentId;
  }-*/;

  private native static void _822909919__1195259493_deploymentId(ProcessInstanceSelectionEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::deploymentId = value;
  }-*/;

  private native static Integer _822909919__$2056817302_processInstanceStatus(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processInstanceStatus;
  }-*/;

  private native static void _822909919__$2056817302_processInstanceStatus(ProcessInstanceSelectionEvent instance, Integer value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processInstanceStatus = value;
  }-*/;

  private native static String _822909919__1195259493_processDefName(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processDefName;
  }-*/;

  private native static void _822909919__1195259493_processDefName(ProcessInstanceSelectionEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::processDefName = value;
  }-*/;

  private native static boolean _822909919__64711720_forLog(ProcessInstanceSelectionEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::forLog;
  }-*/;

  private native static void _822909919__64711720_forLog(ProcessInstanceSelectionEvent instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent::forLog = value;
  }-*/;

  public ProcessInstanceSelectionEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstanceSelectionEvent.class, objId);
    }
    ProcessInstanceSelectionEvent entity = new ProcessInstanceSelectionEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      _822909919__398795216_processInstanceId(entity, java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processDefId")) && (!obj.get("processDefId").isNull())) {
      _822909919__1195259493_processDefId(entity, java_lang_String.demarshall(obj.get("processDefId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _822909919__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("processInstanceStatus")) && (!obj.get("processInstanceStatus").isNull())) {
      _822909919__$2056817302_processInstanceStatus(entity, java_lang_Integer.demarshall(obj.get("processInstanceStatus"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      _822909919__1195259493_processDefName(entity, java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    if ((obj.containsKey("forLog")) && (!obj.get("forLog").isNull())) {
      _822909919__64711720_forLog(entity, java_lang_Boolean.demarshall(obj.get("forLog"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstanceSelectionEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessInstanceSelectionEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processDefId\":").append(java_lang_String.marshall(a0.getProcessDefId(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"processInstanceStatus\":").append(java_lang_Integer.marshall(a0.getProcessInstanceStatus(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append(",").append("\"forLog\":").append(java_lang_Boolean.marshall(_822909919__64711720_forLog(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}