package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.runtime.ContainerKey;

public class Marshaller_o_k_s_c_a_m_r_ContainerKey_1_Impl implements GeneratedMarshaller<ContainerKey> {
  private ContainerKey[] EMPTY_ARRAY = new ContainerKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ContainerKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContainerKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerKey.class, objId);
    }
    ContainerKey entity = new ContainerKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverTemplateId")) && (!obj.get("serverTemplateId").isNull())) {
      entity.setServerTemplateId(java_lang_String.demarshall(obj.get("serverTemplateId"), a1));
    }
    if ((obj.containsKey("containerSpecId")) && (!obj.get("containerSpecId").isNull())) {
      entity.setContainerSpecId(java_lang_String.demarshall(obj.get("containerSpecId"), a1));
    }
    if ((obj.containsKey("containerName")) && (!obj.get("containerName").isNull())) {
      entity.setContainerName(java_lang_String.demarshall(obj.get("containerName"), a1));
    }
    if ((obj.containsKey("url")) && (!obj.get("url").isNull())) {
      entity.setUrl(java_lang_String.demarshall(obj.get("url"), a1));
    }
    return entity;
  }

  public String marshall(ContainerKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.runtime.ContainerKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverTemplateId\":").append(java_lang_String.marshall(a0.getServerTemplateId(), a1)).append(",").append("\"containerSpecId\":").append(java_lang_String.marshall(a0.getContainerSpecId(), a1)).append(",").append("\"containerName\":").append(java_lang_String.marshall(a0.getContainerName(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}