package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.date.Month;
import org.dashbuilder.dataset.date.TimeAmount;
import org.dashbuilder.dataset.date.TimeInstant;
import org.dashbuilder.dataset.date.TimeInstant.TimeMode;
import org.dashbuilder.dataset.group.DateIntervalType;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_TimeInstant_1_Impl implements GeneratedMarshaller<TimeInstant> {
  private TimeInstant[] EMPTY_ARRAY = new TimeInstant[0];
  private Marshaller<TimeMode> org_dashbuilder_dataset_date_TimeInstant_erraiD_TimeMode = null;
  private Marshaller<DateIntervalType> org_dashbuilder_dataset_group_DateIntervalType = null;
  private Marshaller<Month> org_dashbuilder_dataset_date_Month = null;
  private Marshaller<TimeAmount> org_dashbuilder_dataset_date_TimeAmount = null;
  public TimeInstant[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TimeInstant demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TimeInstant.class, objId);
    }
    TimeInstant entity = new TimeInstant();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("timeMode")) && (!obj.get("timeMode").isNull())) {
      entity.setTimeMode(obj.get("timeMode").isObject() != null ? Enum.valueOf(TimeMode.class, obj.get("timeMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("timeMode").isString() != null ? Enum.valueOf(TimeMode.class, obj.get("timeMode").isString().stringValue()) : null);
    }
    if ((obj.containsKey("intervalType")) && (!obj.get("intervalType").isNull())) {
      entity.setIntervalType(obj.get("intervalType").isObject() != null ? Enum.valueOf(DateIntervalType.class, obj.get("intervalType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("intervalType").isString() != null ? Enum.valueOf(DateIntervalType.class, obj.get("intervalType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("firstMonthOfYear")) && (!obj.get("firstMonthOfYear").isNull())) {
      entity.setFirstMonthOfYear(obj.get("firstMonthOfYear").isObject() != null ? Enum.valueOf(Month.class, obj.get("firstMonthOfYear").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("firstMonthOfYear").isString() != null ? Enum.valueOf(Month.class, obj.get("firstMonthOfYear").isString().stringValue()) : null);
    }
    if ((obj.containsKey("timeAmount")) && (!obj.get("timeAmount").isNull())) {
      entity.setTimeAmount(org_dashbuilder_dataset_date_TimeAmount.demarshall(obj.get("timeAmount"), a1));
    }
    return entity;
  }

  public String marshall(TimeInstant a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.date.TimeInstant\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"timeMode\":").append(a0.getTimeMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.date.TimeInstant$TimeMode\",\"^EnumStringValue\":\"").append(a0.getTimeMode().name()).append("\"}") : "null").append(",").append("\"intervalType\":").append(a0.getIntervalType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.DateIntervalType\",\"^EnumStringValue\":\"").append(a0.getIntervalType().name()).append("\"}") : "null").append(",").append("\"firstMonthOfYear\":").append(a0.getFirstMonthOfYear() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.date.Month\",\"^EnumStringValue\":\"").append(a0.getFirstMonthOfYear().name()).append("\"}") : "null").append(",").append("\"timeAmount\":").append(org_dashbuilder_dataset_date_TimeAmount.marshall(a0.getTimeAmount(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_date_TimeInstant_erraiD_TimeMode == null) {
      org_dashbuilder_dataset_date_TimeInstant_erraiD_TimeMode = Marshalling.getMarshaller(TimeMode.class);
    }
    if (org_dashbuilder_dataset_group_DateIntervalType == null) {
      org_dashbuilder_dataset_group_DateIntervalType = Marshalling.getMarshaller(DateIntervalType.class);
    }
    if (org_dashbuilder_dataset_date_Month == null) {
      org_dashbuilder_dataset_date_Month = Marshalling.getMarshaller(Month.class);
    }
    if (org_dashbuilder_dataset_date_TimeAmount == null) {
      org_dashbuilder_dataset_date_TimeAmount = Marshalling.getMarshaller(TimeAmount.class);
    }
  }
}