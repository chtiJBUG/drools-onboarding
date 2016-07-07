package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.api.Capability;

public class Marshaller_o_u_e_s_m_a_Capability_1_Impl implements GeneratedMarshaller<Capability> {
  private Capability[] EMPTY_ARRAY = new Capability[0];
  public Capability[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Capability demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Capability entity = obj != null ? Enum.valueOf(Capability.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Capability.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Capability a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.security.management.api.Capability\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}