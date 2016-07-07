package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.controller.api.model.spec.ContainerSpecKey;
import org.kie.server.controller.api.model.spec.ServerTemplateKey;

public class Marshaller_o_k_s_c_a_m_s_ContainerSpecKey_1_Impl implements GeneratedMarshaller<ContainerSpecKey> {
  private ContainerSpecKey[] EMPTY_ARRAY = new ContainerSpecKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ContainerSpecKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContainerSpecKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerSpecKey.class, objId);
    }
    ContainerSpecKey entity = new ContainerSpecKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("containerName")) && (!obj.get("containerName").isNull())) {
      entity.setContainerName(java_lang_String.demarshall(obj.get("containerName"), a1));
    }
    if ((obj.containsKey("serverTemplateKey")) && (!obj.get("serverTemplateKey").isNull())) {
      entity.setServerTemplateKey((ServerTemplateKey) ((ObjectMarshaller) java_lang_Object).demarshall(ServerTemplateKey.class, obj.get("serverTemplateKey"), a1));
    }
    return entity;
  }

  public String marshall(ContainerSpecKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ContainerSpecKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"containerName\":").append(java_lang_String.marshall(a0.getContainerName(), a1)).append(",").append("\"serverTemplateKey\":").append(java_lang_Object.marshall(a0.getServerTemplateKey(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}