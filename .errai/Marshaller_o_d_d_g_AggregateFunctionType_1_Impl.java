package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.group.AggregateFunctionType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_g_AggregateFunctionType_1_Impl implements GeneratedMarshaller<AggregateFunctionType> {
  private AggregateFunctionType[] EMPTY_ARRAY = new AggregateFunctionType[0];
  public AggregateFunctionType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public AggregateFunctionType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    AggregateFunctionType entity = obj != null ? Enum.valueOf(AggregateFunctionType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(AggregateFunctionType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(AggregateFunctionType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.AggregateFunctionType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}