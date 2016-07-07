package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.filter.CoreFunctionType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_f_CoreFunctionType_1_Impl implements GeneratedMarshaller<CoreFunctionType> {
  private CoreFunctionType[] EMPTY_ARRAY = new CoreFunctionType[0];
  public CoreFunctionType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CoreFunctionType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    CoreFunctionType entity = obj != null ? Enum.valueOf(CoreFunctionType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(CoreFunctionType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(CoreFunctionType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.CoreFunctionType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}