package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.spec.ServerTemplate;

public class Marshaller_a_o_k_s_c_a_m_s_ServerTemplate_D1_Impl implements Marshaller<ServerTemplate[]> {
  private Marshaller<ServerTemplate> org_kie_server_controller_api_model_spec_ServerTemplate = null;
  private Marshaller java_lang_Object = null;
  public org.kie.server.controller.api.model.spec.ServerTemplate[][] getEmptyArray() {
    return null;
  }

  public ServerTemplate[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private ServerTemplate[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    ServerTemplate[] newArray = new ServerTemplate[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = org_kie_server_controller_api_model_spec_ServerTemplate.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(ServerTemplate[] a0, MarshallingSession a1) {
    lazyInit();
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < a0.length; i++) {
      if (i > 0) {
        sb.append(",");
      }
      sb.append(java_lang_Object.marshall(a0[i], a1));
    }
    return sb.append("]").toString();
  }

  public String marshall(ServerTemplate[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_spec_ServerTemplate == null) {
      org_kie_server_controller_api_model_spec_ServerTemplate = Marshalling.getMarshaller(ServerTemplate.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}