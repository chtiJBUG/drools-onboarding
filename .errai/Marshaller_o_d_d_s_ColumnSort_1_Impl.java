package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.sort.ColumnSort;
import org.dashbuilder.dataset.sort.SortOrder;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_s_ColumnSort_1_Impl implements GeneratedMarshaller<ColumnSort> {
  private ColumnSort[] EMPTY_ARRAY = new ColumnSort[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<SortOrder> org_dashbuilder_dataset_sort_SortOrder = null;
  public ColumnSort[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ColumnSort demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ColumnSort.class, objId);
    }
    ColumnSort entity = new ColumnSort();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    if ((obj.containsKey("order")) && (!obj.get("order").isNull())) {
      entity.setOrder(obj.get("order").isObject() != null ? Enum.valueOf(SortOrder.class, obj.get("order").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("order").isString() != null ? Enum.valueOf(SortOrder.class, obj.get("order").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(ColumnSort a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.sort.ColumnSort\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append(",").append("\"order\":").append(a0.getOrder() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.sort.SortOrder\",\"^EnumStringValue\":\"").append(a0.getOrder().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_sort_SortOrder == null) {
      org_dashbuilder_dataset_sort_SortOrder = Marshalling.getMarshaller(SortOrder.class);
    }
  }
}