package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.date.TimeAmount;
import org.dashbuilder.dataset.group.DateIntervalType;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_TimeAmount_1_Impl implements GeneratedMarshaller<TimeAmount> {
  private TimeAmount[] EMPTY_ARRAY = new TimeAmount[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<DateIntervalType> org_dashbuilder_dataset_group_DateIntervalType = null;
  public TimeAmount[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TimeAmount demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TimeAmount.class, objId);
    }
    TimeAmount entity = new TimeAmount();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("quantity")) && (!obj.get("quantity").isNull())) {
      entity.setQuantity(java_lang_Long.demarshall(obj.get("quantity"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(DateIntervalType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(DateIntervalType.class, obj.get("type").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(TimeAmount a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.date.TimeAmount\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"quantity\":").append(java_lang_Long.marshall(a0.getQuantity(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.DateIntervalType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_group_DateIntervalType == null) {
      org_dashbuilder_dataset_group_DateIntervalType = Marshalling.getMarshaller(DateIntervalType.class);
    }
  }
}