package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.persistence.CachingType;

public class Marshaller_o_k_w_c_s_d_m_p_CachingType_1_Impl implements GeneratedMarshaller<CachingType> {
  private CachingType[] EMPTY_ARRAY = new CachingType[0];
  public CachingType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CachingType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    CachingType entity = obj != null ? Enum.valueOf(CachingType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(CachingType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(CachingType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.CachingType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}