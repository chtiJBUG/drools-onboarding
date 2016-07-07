package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.server.management.model.RuntimeStrategy;

public class Marshaller_o_k_w_c_s_s_m_m_RuntimeStrategy_1_Impl implements GeneratedMarshaller<RuntimeStrategy> {
  private RuntimeStrategy[] EMPTY_ARRAY = new RuntimeStrategy[0];
  public RuntimeStrategy[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuntimeStrategy demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    RuntimeStrategy entity = obj != null ? Enum.valueOf(RuntimeStrategy.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(RuntimeStrategy.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(RuntimeStrategy a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.server.management.model.RuntimeStrategy\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}