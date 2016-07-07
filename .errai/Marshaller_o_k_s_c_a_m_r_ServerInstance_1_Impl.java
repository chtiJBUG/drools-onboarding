package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.controller.api.model.runtime.ServerInstance;

public class Marshaller_o_k_s_c_a_m_r_ServerInstance_1_Impl implements GeneratedMarshaller<ServerInstance> {
  private ServerInstance[] EMPTY_ARRAY = new ServerInstance[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ServerInstance[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerInstance demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerInstance.class, objId);
    }
    ServerInstance entity = new ServerInstance();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      entity.setMessages((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("messages"), a1));
    }
    if ((obj.containsKey("containers")) && (!obj.get("containers").isNull())) {
      entity.setContainers((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("containers"), a1));
    }
    if ((obj.containsKey("serverInstanceId")) && (!obj.get("serverInstanceId").isNull())) {
      entity.setServerInstanceId(java_lang_String.demarshall(obj.get("serverInstanceId"), a1));
    }
    if ((obj.containsKey("serverName")) && (!obj.get("serverName").isNull())) {
      entity.setServerName(java_lang_String.demarshall(obj.get("serverName"), a1));
    }
    if ((obj.containsKey("serverTemplateId")) && (!obj.get("serverTemplateId").isNull())) {
      entity.setServerTemplateId(java_lang_String.demarshall(obj.get("serverTemplateId"), a1));
    }
    if ((obj.containsKey("url")) && (!obj.get("url").isNull())) {
      entity.setUrl(java_lang_String.demarshall(obj.get("url"), a1));
    }
    return entity;
  }

  public String marshall(ServerInstance a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.runtime.ServerInstance\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append(",").append("\"messages\":").append(java_lang_Object.marshall(a0.getMessages(), a1)).append(",").append("\"containers\":").append(java_lang_Object.marshall(a0.getContainers(), a1)).append(",").append("\"serverInstanceId\":").append(java_lang_String.marshall(a0.getServerInstanceId(), a1)).append(",").append("\"serverName\":").append(java_lang_String.marshall(a0.getServerName(), a1)).append(",").append("\"serverTemplateId\":").append(java_lang_String.marshall(a0.getServerTemplateId(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}