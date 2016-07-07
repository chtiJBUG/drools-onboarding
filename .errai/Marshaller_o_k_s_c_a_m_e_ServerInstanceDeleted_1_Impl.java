package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.events.ServerInstanceDeleted;

public class Marshaller_o_k_s_c_a_m_e_ServerInstanceDeleted_1_Impl implements GeneratedMarshaller<ServerInstanceDeleted> {
  private ServerInstanceDeleted[] EMPTY_ARRAY = new ServerInstanceDeleted[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ServerInstanceDeleted[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerInstanceDeleted demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerInstanceDeleted.class, objId);
    }
    ServerInstanceDeleted entity = new ServerInstanceDeleted();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverInstanceId")) && (!obj.get("serverInstanceId").isNull())) {
      entity.setServerInstanceId(java_lang_String.demarshall(obj.get("serverInstanceId"), a1));
    }
    return entity;
  }

  public String marshall(ServerInstanceDeleted a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.events.ServerInstanceDeleted\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverInstanceId\":").append(java_lang_String.marshall(a0.getServerInstanceId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}