package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.spec.ProcessConfig;

public class Marshaller_o_k_s_c_a_m_s_ProcessConfig_1_Impl implements GeneratedMarshaller<ProcessConfig> {
  private ProcessConfig[] EMPTY_ARRAY = new ProcessConfig[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProcessConfig[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProcessConfig demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessConfig.class, objId);
    }
    ProcessConfig entity = new ProcessConfig();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("runtimeStrategy")) && (!obj.get("runtimeStrategy").isNull())) {
      entity.setRuntimeStrategy(java_lang_String.demarshall(obj.get("runtimeStrategy"), a1));
    }
    if ((obj.containsKey("kBase")) && (!obj.get("kBase").isNull())) {
      entity.setKBase(java_lang_String.demarshall(obj.get("kBase"), a1));
    }
    if ((obj.containsKey("kSession")) && (!obj.get("kSession").isNull())) {
      entity.setKSession(java_lang_String.demarshall(obj.get("kSession"), a1));
    }
    if ((obj.containsKey("mergeMode")) && (!obj.get("mergeMode").isNull())) {
      entity.setMergeMode(java_lang_String.demarshall(obj.get("mergeMode"), a1));
    }
    return entity;
  }

  public String marshall(ProcessConfig a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ProcessConfig\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"runtimeStrategy\":").append(java_lang_String.marshall(a0.getRuntimeStrategy(), a1)).append(",").append("\"kBase\":").append(java_lang_String.marshall(a0.getKBase(), a1)).append(",").append("\"kSession\":").append(java_lang_String.marshall(a0.getKSession(), a1)).append(",").append("\"mergeMode\":").append(java_lang_String.marshall(a0.getMergeMode(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}