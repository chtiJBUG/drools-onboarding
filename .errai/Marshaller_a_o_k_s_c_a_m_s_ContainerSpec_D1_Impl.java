package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.spec.ContainerSpec;

public class Marshaller_a_o_k_s_c_a_m_s_ContainerSpec_D1_Impl implements Marshaller<ContainerSpec[]> {
  private Marshaller<ContainerSpec> org_kie_server_controller_api_model_spec_ContainerSpec = null;
  private Marshaller java_lang_Object = null;
  public org.kie.server.controller.api.model.spec.ContainerSpec[][] getEmptyArray() {
    return null;
  }

  public ContainerSpec[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private ContainerSpec[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    ContainerSpec[] newArray = new ContainerSpec[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = org_kie_server_controller_api_model_spec_ContainerSpec.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(ContainerSpec[] a0, MarshallingSession a1) {
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

  public String marshall(ContainerSpec[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_spec_ContainerSpec == null) {
      org_kie_server_controller_api_model_spec_ContainerSpec = Marshalling.getMarshaller(ContainerSpec.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}