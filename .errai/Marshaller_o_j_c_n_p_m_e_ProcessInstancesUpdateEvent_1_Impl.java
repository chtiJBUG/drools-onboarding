package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessInstancesUpdateEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessInstancesUpdateEvent_1_Impl implements GeneratedMarshaller<ProcessInstancesUpdateEvent> {
  private ProcessInstancesUpdateEvent[] EMPTY_ARRAY = new ProcessInstancesUpdateEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public ProcessInstancesUpdateEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessInstancesUpdateEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstancesUpdateEvent.class, objId);
    }
    ProcessInstancesUpdateEvent entity = new ProcessInstancesUpdateEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      entity.setProcessInstanceId(java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstancesUpdateEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessInstancesUpdateEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}