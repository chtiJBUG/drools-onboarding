package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.ProcessDefinitionKey;

public class Marshaller_o_j_c_n_p_m_ProcessDefinitionKey_1_Impl implements GeneratedMarshaller<ProcessDefinitionKey> {
  private ProcessDefinitionKey[] EMPTY_ARRAY = new ProcessDefinitionKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProcessDefinitionKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _579570271__1195259493_deploymentId(ProcessDefinitionKey instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.ProcessDefinitionKey::deploymentId;
  }-*/;

  private native static void _579570271__1195259493_deploymentId(ProcessDefinitionKey instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.ProcessDefinitionKey::deploymentId = value;
  }-*/;

  private native static String _579570271__1195259493_processId(ProcessDefinitionKey instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.ProcessDefinitionKey::processId;
  }-*/;

  private native static void _579570271__1195259493_processId(ProcessDefinitionKey instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.ProcessDefinitionKey::processId = value;
  }-*/;

  public ProcessDefinitionKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessDefinitionKey.class, objId);
    }
    ProcessDefinitionKey entity = new ProcessDefinitionKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      _579570271__1195259493_deploymentId(entity, java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      _579570271__1195259493_processId(entity, java_lang_String.demarshall(obj.get("processId"), a1));
    }
    return entity;
  }

  public String marshall(ProcessDefinitionKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessDefinitionKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append(",").append("\"processId\":").append(java_lang_String.marshall(a0.getProcessId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}