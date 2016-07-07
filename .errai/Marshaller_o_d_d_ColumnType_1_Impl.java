package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.ColumnType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_ColumnType_1_Impl implements GeneratedMarshaller<ColumnType> {
  private ColumnType[] EMPTY_ARRAY = new ColumnType[0];
  public ColumnType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ColumnType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ColumnType entity = obj != null ? Enum.valueOf(ColumnType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ColumnType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ColumnType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.ColumnType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}