package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.kie.server.controller.api.model.spec.ServerTemplate;
import org.kie.server.controller.api.model.spec.ServerTemplateList;

public class Marshaller_o_k_s_c_a_m_s_ServerTemplateList_1_Impl implements GeneratedMarshaller<ServerTemplateList> {
  private ServerTemplateList[] EMPTY_ARRAY = new ServerTemplateList[0];
  private Marshaller<ServerTemplate[]> arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1 = null;
  abstract class Marshaller_for_arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1 implements GeneratedMarshaller { }
  public ServerTemplateList[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ServerTemplateList demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerTemplateList.class, objId);
    }
    ServerTemplateList entity = new ServerTemplateList();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverTemplates")) && (!obj.get("serverTemplates").isNull())) {
      entity.setServerTemplates(arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1.demarshall(obj.get("serverTemplates"), a1));
    }
    return entity;
  }

  public String marshall(ServerTemplateList a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ServerTemplateList\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverTemplates\":").append(arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1.marshall(a0.getServerTemplates(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1 == null) {
      arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1 = Marshalling.getMarshaller(ServerTemplate[].class, new DeferredMarshallerCreationCallback<ServerTemplate[]>() {
        public Marshaller<ServerTemplate[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_kie_server_controller_api_model_spec_ServerTemplate_D1.class), ServerTemplate[].class);
        }
      });
    }
  }
}