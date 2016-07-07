package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.pr.model.ProcessSummary;

public class Marshaller_o_j_c_n_p_m_ProcessSummary_1_Impl implements GeneratedMarshaller<ProcessSummary> {
  private ProcessSummary[] EMPTY_ARRAY = new ProcessSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ProcessSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessSummary.class, objId);
    }
    ProcessSummary entity = new ProcessSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processDefId")) && (!obj.get("processDefId").isNull())) {
      entity.setProcessDefId(java_lang_String.demarshall(obj.get("processDefId"), a1));
    }
    if ((obj.containsKey("processDefName")) && (!obj.get("processDefName").isNull())) {
      entity.setProcessDefName(java_lang_String.demarshall(obj.get("processDefName"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("originalPath")) && (!obj.get("originalPath").isNull())) {
      entity.setOriginalPath(java_lang_String.demarshall(obj.get("originalPath"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      entity.setDeploymentId(java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("encodedProcessSource")) && (!obj.get("encodedProcessSource").isNull())) {
      entity.setEncodedProcessSource(java_lang_String.demarshall(obj.get("encodedProcessSource"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ProcessSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processDefId\":").append(java_lang_String.marshall(a0.getProcessDefId(), a1)).append(",").append("\"processDefName\":").append(java_lang_String.marshall(a0.getProcessDefName(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append(",").append("\"originalPath\":").append(java_lang_String.marshall(a0.getOriginalPath(), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"encodedProcessSource\":").append(java_lang_String.marshall(a0.getEncodedProcessSource(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}