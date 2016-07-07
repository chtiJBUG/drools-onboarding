package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.events.ProcessInstanceStyleEvent;

public class Marshaller_o_j_c_n_p_m_e_ProcessInstanceStyleEvent_1_Impl implements GeneratedMarshaller<ProcessInstanceStyleEvent> {
  private ProcessInstanceStyleEvent[] EMPTY_ARRAY = new ProcessInstanceStyleEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public ProcessInstanceStyleEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessInstanceStyleEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstanceStyleEvent.class, objId);
    }
    ProcessInstanceStyleEvent entity = new ProcessInstanceStyleEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      entity.setProcessInstanceId(java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      entity.setProcessDefName(java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    if ((obj.containsKey("processDefVersion")) && (!obj.get("processDefVersion").isNull())) {
      entity.setProcessDefVersion(java_lang_String.demarshall(obj.get("processDefVersion"), a1));
    }
    if ((obj.containsKey("processInstanceStartDate")) && (!obj.get("processInstanceStartDate").isNull())) {
      entity.setProcessInstanceStartDate(java_util_Date.demarshall(obj.get("processInstanceStartDate"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstanceStyleEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.events.ProcessInstanceStyleEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append(",").append("\"processDefVersion\":").append(java_lang_String.marshall(a0.getProcessDefVersion(), a1)).append(",").append("\"processInstanceStartDate\":").append(java_util_Date.marshall(a0.getProcessInstanceStartDate(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}