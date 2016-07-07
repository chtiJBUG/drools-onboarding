package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.api.model.Severity;

public class Marshaller_o_k_s_a_m_Severity_1_Impl implements GeneratedMarshaller<Severity> {
  private Severity[] EMPTY_ARRAY = new Severity[0];
  public Severity[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Severity demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Severity entity = obj != null ? Enum.valueOf(Severity.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Severity.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Severity a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.Severity\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}