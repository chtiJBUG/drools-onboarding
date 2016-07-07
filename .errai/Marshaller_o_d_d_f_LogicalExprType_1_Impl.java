package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.filter.LogicalExprType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_f_LogicalExprType_1_Impl implements GeneratedMarshaller<LogicalExprType> {
  private LogicalExprType[] EMPTY_ARRAY = new LogicalExprType[0];
  public LogicalExprType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public LogicalExprType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    LogicalExprType entity = obj != null ? Enum.valueOf(LogicalExprType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(LogicalExprType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(LogicalExprType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.LogicalExprType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}