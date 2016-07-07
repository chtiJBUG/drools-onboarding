package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.api.model.KieScannerStatus;

public class Marshaller_o_k_s_a_m_KieScannerStatus_1_Impl implements GeneratedMarshaller<KieScannerStatus> {
  private KieScannerStatus[] EMPTY_ARRAY = new KieScannerStatus[0];
  public KieScannerStatus[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public KieScannerStatus demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    KieScannerStatus entity = obj != null ? Enum.valueOf(KieScannerStatus.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(KieScannerStatus.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(KieScannerStatus a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.KieScannerStatus\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}