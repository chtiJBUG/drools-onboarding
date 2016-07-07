package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.explorer.service.Option;

public class Marshaller_o_k_w_c_s_e_s_Option_1_Impl implements GeneratedMarshaller<Option> {
  private Option[] EMPTY_ARRAY = new Option[0];
  public Option[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Option demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Option entity = obj != null ? Enum.valueOf(Option.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Option.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Option a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.service.Option\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}