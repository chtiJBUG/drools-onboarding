package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.service.DeploymentMode;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_s_DeploymentMode_1_Impl implements GeneratedMarshaller<DeploymentMode> {
  private DeploymentMode[] EMPTY_ARRAY = new DeploymentMode[0];
  public DeploymentMode[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DeploymentMode demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DeploymentMode entity = obj != null ? Enum.valueOf(DeploymentMode.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DeploymentMode.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DeploymentMode a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.common.services.project.service.DeploymentMode\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}