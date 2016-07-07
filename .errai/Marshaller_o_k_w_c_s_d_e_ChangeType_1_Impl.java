package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.events.ChangeType;

public class Marshaller_o_k_w_c_s_d_e_ChangeType_1_Impl implements GeneratedMarshaller<ChangeType> {
  private ChangeType[] EMPTY_ARRAY = new ChangeType[0];
  public ChangeType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ChangeType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ChangeType entity = obj != null ? Enum.valueOf(ChangeType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ChangeType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ChangeType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.events.ChangeType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}