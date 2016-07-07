package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.sort.SortOrder;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_s_SortOrder_1_Impl implements GeneratedMarshaller<SortOrder> {
  private SortOrder[] EMPTY_ARRAY = new SortOrder[0];
  public SortOrder[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public SortOrder demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    SortOrder entity = obj != null ? Enum.valueOf(SortOrder.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(SortOrder.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(SortOrder a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.sort.SortOrder\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}