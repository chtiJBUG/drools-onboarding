package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessDefStyleEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessDefStyleEvent_1_Impl implements GeneratedMarshaller<ProcessDefStyleEvent> {
  private ProcessDefStyleEvent[] EMPTY_ARRAY = new ProcessDefStyleEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProcessDefStyleEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessDefStyleEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessDefStyleEvent.class, objId);
    }
    ProcessDefStyleEvent entity = new ProcessDefStyleEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processDefVersion")) && (!obj.get("processDefVersion").isNull())) {
      entity.setProcessDefVersion(java_lang_String.demarshall(obj.get("processDefVersion"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      entity.setProcessDefName(java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    return entity;
  }

  public String marshall(ProcessDefStyleEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessDefStyleEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processDefVersion\":").append(java_lang_String.marshall(a0.getProcessDefVersion(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}