package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent;

public class Marshaller_o_j_c_n_p_m_e_NewProcessInstanceEvent_1_Impl implements GeneratedMarshaller<NewProcessInstanceEvent> {
  private NewProcessInstanceEvent[] EMPTY_ARRAY = new NewProcessInstanceEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public NewProcessInstanceEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _$1680051581__398795216_newProcessInstanceId(NewProcessInstanceEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessInstanceId;
  }-*/;

  private native static void _$1680051581__398795216_newProcessInstanceId(NewProcessInstanceEvent instance, Long value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessInstanceId = value;
  }-*/;

  private native static String _$1680051581__1195259493_newProcessDefId(NewProcessInstanceEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessDefId;
  }-*/;

  private native static void _$1680051581__1195259493_newProcessDefId(NewProcessInstanceEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessDefId = value;
  }-*/;

  private native static String _$1680051581__1195259493_deploymentId(NewProcessInstanceEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::deploymentId;
  }-*/;

  private native static void _$1680051581__1195259493_deploymentId(NewProcessInstanceEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::deploymentId = value;
  }-*/;

  private native static Integer _$1680051581__$2056817302_newProcessInstanceStatus(NewProcessInstanceEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessInstanceStatus;
  }-*/;

  private native static void _$1680051581__$2056817302_newProcessInstanceStatus(NewProcessInstanceEvent instance, Integer value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::newProcessInstanceStatus = value;
  }-*/;

  private native static String _$1680051581__1195259493_processDefName(NewProcessInstanceEvent instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::processDefName;
  }-*/;

  private native static void _$1680051581__1195259493_processDefName(NewProcessInstanceEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent::processDefName = value;
  }-*/;

  public NewProcessInstanceEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewProcessInstanceEvent.class, objId);
    }
    NewProcessInstanceEvent entity = new NewProcessInstanceEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("newProcessInstanceId")) && (!obj.get("newProcessInstanceId").isNull())) {
      _$1680051581__398795216_newProcessInstanceId(entity, java_lang_Long.demarshall(obj.get("newProcessInstanceId"), a1));
    }
    if ((obj.containsKey("newProcessDefId")) && (!obj.get("newProcessDefId").isNull())) {
      _$1680051581__1195259493_newProcessDefId(entity, java_lang_String.demarshall(obj.get("newProcessDefId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _$1680051581__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("newProcessInstanceStatus")) && (!obj.get("newProcessInstanceStatus").isNull())) {
      _$1680051581__$2056817302_newProcessInstanceStatus(entity, java_lang_Integer.demarshall(obj.get("newProcessInstanceStatus"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      _$1680051581__1195259493_processDefName(entity, java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    return entity;
  }

  public String marshall(NewProcessInstanceEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.NewProcessInstanceEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"newProcessInstanceId\":").append(java_lang_Long.marshall(a0.getNewProcessInstanceId(), a1)).append(",").append("\"newProcessDefId\":").append(java_lang_String.marshall(a0.getNewProcessDefId(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"newProcessInstanceStatus\":").append(java_lang_Integer.marshall(a0.getNewProcessInstanceStatus(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}