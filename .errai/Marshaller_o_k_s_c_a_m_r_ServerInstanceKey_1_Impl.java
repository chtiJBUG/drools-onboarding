package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.runtime.ServerInstanceKey;

public class Marshaller_o_k_s_c_a_m_r_ServerInstanceKey_1_Impl implements GeneratedMarshaller<ServerInstanceKey> {
  private ServerInstanceKey[] EMPTY_ARRAY = new ServerInstanceKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ServerInstanceKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerInstanceKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerInstanceKey.class, objId);
    }
    ServerInstanceKey entity = new ServerInstanceKey();
    a1.recordObject(objId, entity);
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

  public String marshall(ServerInstanceKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.runtime.ServerInstanceKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverInstanceId\":").append(java_lang_String.marshall(a0.getServerInstanceId(), a1)).append(",").append("\"serverName\":").append(java_lang_String.marshall(a0.getServerName(), a1)).append(",").append("\"serverTemplateId\":").append(java_lang_String.marshall(a0.getServerTemplateId(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}