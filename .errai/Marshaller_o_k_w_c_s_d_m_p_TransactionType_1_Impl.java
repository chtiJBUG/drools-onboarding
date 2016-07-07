package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.persistence.TransactionType;

public class Marshaller_o_k_w_c_s_d_m_p_TransactionType_1_Impl implements GeneratedMarshaller<TransactionType> {
  private TransactionType[] EMPTY_ARRAY = new TransactionType[0];
  public TransactionType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TransactionType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    TransactionType entity = obj != null ? Enum.valueOf(TransactionType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(TransactionType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(TransactionType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.TransactionType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}