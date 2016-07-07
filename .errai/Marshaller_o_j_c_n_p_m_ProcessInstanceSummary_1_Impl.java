package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.pr.model.ProcessInstanceSummary;

public class Marshaller_o_j_c_n_p_m_ProcessInstanceSummary_1_Impl implements GeneratedMarshaller<ProcessInstanceSummary> {
  private ProcessInstanceSummary[] EMPTY_ARRAY = new ProcessInstanceSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ProcessInstanceSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$744947996__$1383349348_domainData(ProcessInstanceSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.ProcessInstanceSummary::domainData;
  }-*/;

  private native static void _$744947996__$1383349348_domainData(ProcessInstanceSummary instance, Map<String, String> value) /*-{
    instance.@org.jbpm.console.ng.pr.model.ProcessInstanceSummary::domainData = value;
  }-*/;

  public ProcessInstanceSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessInstanceSummary.class, objId);
    }
    ProcessInstanceSummary entity = new ProcessInstanceSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processInstanceId")) && (!obj.get("processInstanceId").isNull())) {
      entity.setProcessInstanceId(java_lang_Long.demarshall(obj.get("processInstanceId"), a1));
    }
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      entity.setProcessId(java_lang_String.demarshall(obj.get("processId"), a1));
    }
    if ((obj.containsKey("processName")) && (!obj.get("processName").isNull())) {
      entity.setProcessName(java_lang_String.demarshall(obj.get("processName"), a1));
    }
    if ((obj.containsKey("processVersion")) && (!obj.get("processVersion").isNull())) {
      entity.setProcessVersion(java_lang_String.demarshall(obj.get("processVersion"), a1));
    }
    if ((obj.containsKey("state")) && (!obj.get("state").isNull())) {
      entity.setState(java_lang_Integer.demarshall(obj.get("state"), a1));
    }
    if ((obj.containsKey("startTime")) && (!obj.get("startTime").isNull())) {
      entity.setStartTime(java_util_Date.demarshall(obj.get("startTime"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      entity.setDeploymentId(java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("initiator")) && (!obj.get("initiator").isNull())) {
      entity.setInitiator(java_lang_String.demarshall(obj.get("initiator"), a1));
    }
    if ((obj.containsKey("processInstanceDescription")) && (!obj.get("processInstanceDescription").isNull())) {
      entity.setProcessInstanceDescription(java_lang_String.demarshall(obj.get("processInstanceDescription"), a1));
    }
    if ((obj.containsKey("parentId")) && (!obj.get("parentId").isNull())) {
      entity.setParentId(java_lang_Long.demarshall(obj.get("parentId"), a1));
    }
    if ((obj.containsKey("correlationKey")) && (!obj.get("correlationKey").isNull())) {
      entity.setCorrelationKey(java_lang_String.demarshall(obj.get("correlationKey"), a1));
    }
    if ((obj.containsKey("domainData")) && (!obj.get("domainData").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$744947996__$1383349348_domainData(entity, java_util_Map.demarshall(obj.get("domainData"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("activeTasks")) && (!obj.get("activeTasks").isNull())) {
      a1.setAssumedElementType("org.jbpm.console.ng.pr.model.UserTaskSummary");
      entity.setActiveTasks(java_util_List.demarshall(obj.get("activeTasks"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ProcessInstanceSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessInstanceSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processInstanceId\":").append(java_lang_Long.marshall(a0.getProcessInstanceId(), a1)).append(",").append("\"processId\":").append(java_lang_String.marshall(a0.getProcessId(), a1)).append(",").append("\"processName\":").append(java_lang_String.marshall(a0.getProcessName(), a1)).append(",").append("\"processVersion\":").append(java_lang_String.marshall(a0.getProcessVersion(), a1)).append(",").append("\"state\":").append(java_lang_Integer.marshall(a0.getState(), a1)).append(",").append("\"startTime\":").append(java_util_Date.marshall(a0.getStartTime(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"initiator\":").append(java_lang_String.marshall(a0.getInitiator(), a1)).append(",").append("\"processInstanceDescription\":").append(java_lang_String.marshall(a0.getProcessInstanceDescription(), a1)).append(",").append("\"parentId\":").append(java_lang_Long.marshall(a0.getParentId(), a1)).append(",").append("\"correlationKey\":").append(java_lang_String.marshall(a0.getCorrelationKey(), a1)).append(",").append("\"domainData\":").append(java_util_Map.marshall(a0.getDomainData(), a1)).append(",").append("\"activeTasks\":").append(java_util_List.marshall(a0.getActiveTasks(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}