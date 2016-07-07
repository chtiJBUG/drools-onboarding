package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.spec.ServerConfig;

public class Marshaller_o_k_s_c_a_m_s_ServerConfig_1_Impl implements GeneratedMarshaller<ServerConfig> {
  private ServerConfig[] EMPTY_ARRAY = new ServerConfig[0];
  public ServerConfig[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerConfig demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerConfig.class, objId);
    }
    ServerConfig entity = new ServerConfig();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ServerConfig a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ServerConfig\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}