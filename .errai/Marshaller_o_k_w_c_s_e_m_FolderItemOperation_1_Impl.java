package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.explorer.model.FolderItemOperation;

public class Marshaller_o_k_w_c_s_e_m_FolderItemOperation_1_Impl implements GeneratedMarshaller<FolderItemOperation> {
  private FolderItemOperation[] EMPTY_ARRAY = new FolderItemOperation[0];
  public FolderItemOperation[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FolderItemOperation demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    FolderItemOperation entity = obj != null ? Enum.valueOf(FolderItemOperation.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(FolderItemOperation.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(FolderItemOperation a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.FolderItemOperation\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}