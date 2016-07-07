package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.api.model.KieContainerStatus;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.controller.api.model.spec.ContainerSpec;
import org.kie.server.controller.api.model.spec.ServerTemplateKey;

public class Marshaller_o_k_s_c_a_m_s_ContainerSpec_1_Impl implements GeneratedMarshaller<ContainerSpec> {
  private ContainerSpec[] EMPTY_ARRAY = new ContainerSpec[0];
  private Marshaller<ReleaseId> org_kie_server_api_model_ReleaseId = null;
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<KieContainerStatus> org_kie_server_api_model_KieContainerStatus = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ContainerSpec[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContainerSpec demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerSpec.class, objId);
    }
    ContainerSpec entity = new ContainerSpec();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("releasedId")) && (!obj.get("releasedId").isNull())) {
      entity.setReleasedId(org_kie_server_api_model_ReleaseId.demarshall(obj.get("releasedId"), a1));
    }
    if ((obj.containsKey("configs")) && (!obj.get("configs").isNull())) {
      a1.setAssumedMapKeyType("org.kie.server.controller.api.model.spec.Capability");
      a1.setAssumedMapValueType("java.lang.Object");
      entity.setConfigs(java_util_Map.demarshall(obj.get("configs"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      entity.setStatus(obj.get("status").isObject() != null ? Enum.valueOf(KieContainerStatus.class, obj.get("status").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("status").isString() != null ? Enum.valueOf(KieContainerStatus.class, obj.get("status").isString().stringValue()) : null);
    }
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

  public String marshall(ContainerSpec a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ContainerSpec\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"releasedId\":").append(org_kie_server_api_model_ReleaseId.marshall(a0.getReleasedId(), a1)).append(",").append("\"configs\":").append(java_util_Map.marshall(a0.getConfigs(), a1)).append(",").append("\"status\":").append(a0.getStatus() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.KieContainerStatus\",\"^EnumStringValue\":\"").append(a0.getStatus().name()).append("\"}") : "null").append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"containerName\":").append(java_lang_String.marshall(a0.getContainerName(), a1)).append(",").append("\"serverTemplateKey\":").append(java_lang_Object.marshall(a0.getServerTemplateKey(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_api_model_ReleaseId == null) {
      org_kie_server_api_model_ReleaseId = Marshalling.getMarshaller(ReleaseId.class);
    }
    if (org_kie_server_api_model_KieContainerStatus == null) {
      org_kie_server_api_model_KieContainerStatus = Marshalling.getMarshaller(KieContainerStatus.class);
    }
  }
}