package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.server.management.model.MergeMode;

public class Marshaller_o_k_w_c_s_s_m_m_MergeMode_1_Impl implements GeneratedMarshaller<MergeMode> {
  private MergeMode[] EMPTY_ARRAY = new MergeMode[0];
  public MergeMode[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public MergeMode demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    MergeMode entity = obj != null ? Enum.valueOf(MergeMode.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(MergeMode.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(MergeMode a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.server.management.model.MergeMode\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}