package org.jboss.errai.marshalling.client.api;

import org.guvnor.asset.management.social.ProjectDeployedEvent.DeployType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_a_m_s_ProjectDeployedEvent_erraiD_DeployType_Impl implements GeneratedMarshaller<DeployType> {
  private DeployType[] EMPTY_ARRAY = new DeployType[0];
  public DeployType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DeployType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DeployType entity = obj != null ? Enum.valueOf(DeployType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DeployType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DeployType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.asset.management.social.ProjectDeployedEvent$DeployType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}