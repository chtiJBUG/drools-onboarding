package org.jboss.errai.marshalling.client.api;

import org.guvnor.asset.management.social.AssetManagementEventTypes;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_a_m_s_AssetManagementEventTypes_1_Impl implements GeneratedMarshaller<AssetManagementEventTypes> {
  private AssetManagementEventTypes[] EMPTY_ARRAY = new AssetManagementEventTypes[0];
  public AssetManagementEventTypes[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public AssetManagementEventTypes demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    AssetManagementEventTypes entity = obj != null ? Enum.valueOf(AssetManagementEventTypes.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(AssetManagementEventTypes.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(AssetManagementEventTypes a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.asset.management.social.AssetManagementEventTypes\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}