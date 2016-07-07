package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.events.ServerInstanceUpdated;
import org.kie.server.controller.api.model.runtime.ServerInstance;

public class Marshaller_o_k_s_c_a_m_e_ServerInstanceUpdated_1_Impl implements GeneratedMarshaller<ServerInstanceUpdated> {
  private ServerInstanceUpdated[] EMPTY_ARRAY = new ServerInstanceUpdated[0];
  private Marshaller<ServerInstance> org_kie_server_controller_api_model_runtime_ServerInstance = null;
  public ServerInstanceUpdated[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerInstanceUpdated demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerInstanceUpdated.class, objId);
    }
    ServerInstanceUpdated entity = new ServerInstanceUpdated();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverInstance")) && (!obj.get("serverInstance").isNull())) {
      entity.setServerInstance(org_kie_server_controller_api_model_runtime_ServerInstance.demarshall(obj.get("serverInstance"), a1));
    }
    return entity;
  }

  public String marshall(ServerInstanceUpdated a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.events.ServerInstanceUpdated\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverInstance\":").append(org_kie_server_controller_api_model_runtime_ServerInstance.marshall(a0.getServerInstance(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_runtime_ServerInstance == null) {
      org_kie_server_controller_api_model_runtime_ServerInstance = Marshalling.getMarshaller(ServerInstance.class);
    }
  }
}