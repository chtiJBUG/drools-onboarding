package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessDefSelectionEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessDefSelectionEvent_1_Impl implements GeneratedMarshaller<ProcessDefSelectionEvent> {
  private ProcessDefSelectionEvent[] EMPTY_ARRAY = new ProcessDefSelectionEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProcessDefSelectionEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessDefSelectionEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessDefSelectionEvent.class, objId);
    }
    ProcessDefSelectionEvent entity = new ProcessDefSelectionEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      entity.setProcessId(java_lang_String.demarshall(obj.get("processId"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      entity.setDeploymentId(java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    return entity;
  }

  public String marshall(ProcessDefSelectionEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessDefSelectionEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processId\":").append(java_lang_String.marshall(a0.getProcessId(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}