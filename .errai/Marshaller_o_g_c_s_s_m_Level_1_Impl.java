package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.message.Level;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_s_m_Level_1_Impl implements GeneratedMarshaller<Level> {
  private Level[] EMPTY_ARRAY = new Level[0];
  public Level[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Level demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Level entity = obj != null ? Enum.valueOf(Level.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Level.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Level a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.common.services.shared.message.Level\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}