package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.events.ServerTemplateDeleted;

public class Marshaller_o_k_s_c_a_m_e_ServerTemplateDeleted_1_Impl implements GeneratedMarshaller<ServerTemplateDeleted> {
  private ServerTemplateDeleted[] EMPTY_ARRAY = new ServerTemplateDeleted[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ServerTemplateDeleted[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerTemplateDeleted demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerTemplateDeleted.class, objId);
    }
    ServerTemplateDeleted entity = new ServerTemplateDeleted();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverTemplateId")) && (!obj.get("serverTemplateId").isNull())) {
      entity.setServerTemplateId(java_lang_String.demarshall(obj.get("serverTemplateId"), a1));
    }
    return entity;
  }

  public String marshall(ServerTemplateDeleted a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.events.ServerTemplateDeleted\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverTemplateId\":").append(java_lang_String.marshall(a0.getServerTemplateId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}