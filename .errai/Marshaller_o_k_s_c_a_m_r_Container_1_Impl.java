package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.api.model.KieContainerStatus;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.controller.api.model.runtime.Container;

public class Marshaller_o_k_s_c_a_m_r_Container_1_Impl implements GeneratedMarshaller<Container> {
  private Container[] EMPTY_ARRAY = new Container[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ReleaseId> org_kie_server_api_model_ReleaseId = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<KieContainerStatus> org_kie_server_api_model_KieContainerStatus = null;
  public Container[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Container demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Container.class, objId);
    }
    Container entity = new Container();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverInstanceId")) && (!obj.get("serverInstanceId").isNull())) {
      entity.setServerInstanceId(java_lang_String.demarshall(obj.get("serverInstanceId"), a1));
    }
    if ((obj.containsKey("resolvedReleasedId")) && (!obj.get("resolvedReleasedId").isNull())) {
      entity.setResolvedReleasedId(org_kie_server_api_model_ReleaseId.demarshall(obj.get("resolvedReleasedId"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      entity.setMessages((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("messages"), a1));
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      entity.setStatus(obj.get("status").isObject() != null ? Enum.valueOf(KieContainerStatus.class, obj.get("status").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("status").isString() != null ? Enum.valueOf(KieContainerStatus.class, obj.get("status").isString().stringValue()) : null);
    }
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

  public String marshall(Container a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.runtime.Container\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverInstanceId\":").append(java_lang_String.marshall(a0.getServerInstanceId(), a1)).append(",").append("\"resolvedReleasedId\":").append(org_kie_server_api_model_ReleaseId.marshall(a0.getResolvedReleasedId(), a1)).append(",").append("\"messages\":").append(java_lang_Object.marshall(a0.getMessages(), a1)).append(",").append("\"status\":").append(a0.getStatus() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.KieContainerStatus\",\"^EnumStringValue\":\"").append(a0.getStatus().name()).append("\"}") : "null").append(",").append("\"serverTemplateId\":").append(java_lang_String.marshall(a0.getServerTemplateId(), a1)).append(",").append("\"containerSpecId\":").append(java_lang_String.marshall(a0.getContainerSpecId(), a1)).append(",").append("\"containerName\":").append(java_lang_String.marshall(a0.getContainerName(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append("}").toString();
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