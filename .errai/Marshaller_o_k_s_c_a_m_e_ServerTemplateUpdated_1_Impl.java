package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.events.ServerTemplateUpdated;
import org.kie.server.controller.api.model.spec.ServerTemplate;

public class Marshaller_o_k_s_c_a_m_e_ServerTemplateUpdated_1_Impl implements GeneratedMarshaller<ServerTemplateUpdated> {
  private ServerTemplateUpdated[] EMPTY_ARRAY = new ServerTemplateUpdated[0];
  private Marshaller<ServerTemplate> org_kie_server_controller_api_model_spec_ServerTemplate = null;
  public ServerTemplateUpdated[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ServerTemplate _$1492144230__1169865407_serverTemplate(ServerTemplateUpdated instance) /*-{
    return instance.@org.kie.server.controller.api.model.events.ServerTemplateUpdated::serverTemplate;
  }-*/;

  private native static void _$1492144230__1169865407_serverTemplate(ServerTemplateUpdated instance, ServerTemplate value) /*-{
    instance.@org.kie.server.controller.api.model.events.ServerTemplateUpdated::serverTemplate = value;
  }-*/;

  public ServerTemplateUpdated demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerTemplateUpdated.class, objId);
    }
    ServerTemplateUpdated entity = new ServerTemplateUpdated();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverTemplate")) && (!obj.get("serverTemplate").isNull())) {
      _$1492144230__1169865407_serverTemplate(entity, org_kie_server_controller_api_model_spec_ServerTemplate.demarshall(obj.get("serverTemplate"), a1));
    }
    return entity;
  }

  public String marshall(ServerTemplateUpdated a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.events.ServerTemplateUpdated\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverTemplate\":").append(org_kie_server_controller_api_model_spec_ServerTemplate.marshall(a0.getServerTemplate(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_spec_ServerTemplate == null) {
      org_kie_server_controller_api_model_spec_ServerTemplate = Marshalling.getMarshaller(ServerTemplate.class);
    }
  }
}