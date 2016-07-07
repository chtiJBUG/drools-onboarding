package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.api.CapabilityStatus;

public class Marshaller_o_u_e_s_m_a_CapabilityStatus_1_Impl implements GeneratedMarshaller<CapabilityStatus> {
  private CapabilityStatus[] EMPTY_ARRAY = new CapabilityStatus[0];
  public CapabilityStatus[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CapabilityStatus demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    CapabilityStatus entity = obj != null ? Enum.valueOf(CapabilityStatus.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(CapabilityStatus.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(CapabilityStatus a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.security.management.api.CapabilityStatus\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}