package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.DefaultTypes;

public class Marshaller_o_k_u_s_a_m_DefaultTypes_1_Impl implements GeneratedMarshaller<DefaultTypes> {
  private DefaultTypes[] EMPTY_ARRAY = new DefaultTypes[0];
  public DefaultTypes[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DefaultTypes demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DefaultTypes entity = obj != null ? Enum.valueOf(DefaultTypes.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DefaultTypes.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DefaultTypes a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.DefaultTypes\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}