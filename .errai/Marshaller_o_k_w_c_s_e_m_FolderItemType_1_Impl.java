package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.explorer.model.FolderItemType;

public class Marshaller_o_k_w_c_s_e_m_FolderItemType_1_Impl implements GeneratedMarshaller<FolderItemType> {
  private FolderItemType[] EMPTY_ARRAY = new FolderItemType[0];
  public FolderItemType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FolderItemType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    FolderItemType entity = obj != null ? Enum.valueOf(FolderItemType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(FolderItemType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(FolderItemType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.FolderItemType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}