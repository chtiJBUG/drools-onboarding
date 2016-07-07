package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm.JAVA_TYPE;

public class Marshaller_o_k_w_c_s_d_m_i_t_JavaTypeIndexTerm_erraiD_JAVA_erraiU_TYPE_Impl implements GeneratedMarshaller<JAVA_TYPE> {
  private JAVA_TYPE[] EMPTY_ARRAY = new JAVA_TYPE[0];
  public JAVA_TYPE[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public JAVA_TYPE demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    JAVA_TYPE entity = obj != null ? Enum.valueOf(JAVA_TYPE.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(JAVA_TYPE.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(JAVA_TYPE a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm$JAVA_TYPE\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}