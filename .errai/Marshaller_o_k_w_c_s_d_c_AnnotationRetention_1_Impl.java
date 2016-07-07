package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.AnnotationRetention;

public class Marshaller_o_k_w_c_s_d_c_AnnotationRetention_1_Impl implements GeneratedMarshaller<AnnotationRetention> {
  private AnnotationRetention[] EMPTY_ARRAY = new AnnotationRetention[0];
  public AnnotationRetention[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public AnnotationRetention demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    AnnotationRetention entity = obj != null ? Enum.valueOf(AnnotationRetention.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(AnnotationRetention.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(AnnotationRetention a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.AnnotationRetention\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}