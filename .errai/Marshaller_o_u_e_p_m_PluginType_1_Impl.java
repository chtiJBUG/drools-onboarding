package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.PluginType;

public class Marshaller_o_u_e_p_m_PluginType_1_Impl implements GeneratedMarshaller<PluginType> {
  private PluginType[] EMPTY_ARRAY = new PluginType[0];
  public PluginType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PluginType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    PluginType entity = obj != null ? Enum.valueOf(PluginType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(PluginType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(PluginType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}