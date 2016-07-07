package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.JavaTypeKind;

public class Marshaller_o_k_w_c_s_d_c_JavaTypeKind_1_Impl implements GeneratedMarshaller<JavaTypeKind> {
  private JavaTypeKind[] EMPTY_ARRAY = new JavaTypeKind[0];
  public JavaTypeKind[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public JavaTypeKind demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    JavaTypeKind entity = obj != null ? Enum.valueOf(JavaTypeKind.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(JavaTypeKind.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(JavaTypeKind a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.JavaTypeKind\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}