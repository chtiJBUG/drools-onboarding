package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.date.DayOfWeek;
import org.dashbuilder.dataset.date.Month;
import org.dashbuilder.dataset.group.ColumnGroup;
import org.dashbuilder.dataset.group.GroupStrategy;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_g_ColumnGroup_1_Impl implements GeneratedMarshaller<ColumnGroup> {
  private ColumnGroup[] EMPTY_ARRAY = new ColumnGroup[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<GroupStrategy> org_dashbuilder_dataset_group_GroupStrategy = null;
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Month> org_dashbuilder_dataset_date_Month = null;
  private Marshaller<DayOfWeek> org_dashbuilder_dataset_date_DayOfWeek = null;
  public ColumnGroup[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _1938564693__64711720_emptyIntervals(ColumnGroup instance) /*-{
    return instance.@org.dashbuilder.dataset.group.ColumnGroup::emptyIntervals;
  }-*/;

  private native static void _1938564693__64711720_emptyIntervals(ColumnGroup instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.group.ColumnGroup::emptyIntervals = value;
  }-*/;

  public ColumnGroup demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ColumnGroup.class, objId);
    }
    ColumnGroup entity = new ColumnGroup();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sourceId")) && (!obj.get("sourceId").isNull())) {
      entity.setSourceId(java_lang_String.demarshall(obj.get("sourceId"), a1));
    }
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    if ((obj.containsKey("strategy")) && (!obj.get("strategy").isNull())) {
      entity.setStrategy(obj.get("strategy").isObject() != null ? Enum.valueOf(GroupStrategy.class, obj.get("strategy").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("strategy").isString() != null ? Enum.valueOf(GroupStrategy.class, obj.get("strategy").isString().stringValue()) : null);
    }
    if ((obj.containsKey("maxIntervals")) && (!obj.get("maxIntervals").isNull())) {
      entity.setMaxIntervals(java_lang_Integer.demarshall(obj.get("maxIntervals"), a1));
    }
    if ((obj.containsKey("intervalSize")) && (!obj.get("intervalSize").isNull())) {
      entity.setIntervalSize(java_lang_String.demarshall(obj.get("intervalSize"), a1));
    }
    if ((obj.containsKey("emptyIntervals")) && (!obj.get("emptyIntervals").isNull())) {
      _1938564693__64711720_emptyIntervals(entity, java_lang_Boolean.demarshall(obj.get("emptyIntervals"), a1));
    }
    if ((obj.containsKey("ascendingOrder")) && (!obj.get("ascendingOrder").isNull())) {
      entity.setAscendingOrder(java_lang_Boolean.demarshall(obj.get("ascendingOrder"), a1));
    }
    if ((obj.containsKey("firstMonthOfYear")) && (!obj.get("firstMonthOfYear").isNull())) {
      entity.setFirstMonthOfYear(obj.get("firstMonthOfYear").isObject() != null ? Enum.valueOf(Month.class, obj.get("firstMonthOfYear").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("firstMonthOfYear").isString() != null ? Enum.valueOf(Month.class, obj.get("firstMonthOfYear").isString().stringValue()) : null);
    }
    if ((obj.containsKey("firstDayOfWeek")) && (!obj.get("firstDayOfWeek").isNull())) {
      entity.setFirstDayOfWeek(obj.get("firstDayOfWeek").isObject() != null ? Enum.valueOf(DayOfWeek.class, obj.get("firstDayOfWeek").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("firstDayOfWeek").isString() != null ? Enum.valueOf(DayOfWeek.class, obj.get("firstDayOfWeek").isString().stringValue()) : null);
    }
    return entity;
  }

  private native static boolean _1938564693__64711720_ascendingOrder(ColumnGroup instance) /*-{
    return instance.@org.dashbuilder.dataset.group.ColumnGroup::ascendingOrder;
  }-*/;

  private native static void _1938564693__64711720_ascendingOrder(ColumnGroup instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.group.ColumnGroup::ascendingOrder = value;
  }-*/;

  public String marshall(ColumnGroup a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.group.ColumnGroup\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sourceId\":").append(java_lang_String.marshall(a0.getSourceId(), a1)).append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append(",").append("\"strategy\":").append(a0.getStrategy() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.GroupStrategy\",\"^EnumStringValue\":\"").append(a0.getStrategy().name()).append("\"}") : "null").append(",").append("\"maxIntervals\":").append(java_lang_Integer.marshall(a0.getMaxIntervals(), a1)).append(",").append("\"intervalSize\":").append(java_lang_String.marshall(a0.getIntervalSize(), a1)).append(",").append("\"emptyIntervals\":").append(java_lang_Boolean.marshall(_1938564693__64711720_emptyIntervals(a0), a1)).append(",").append("\"ascendingOrder\":").append(java_lang_Boolean.marshall(_1938564693__64711720_ascendingOrder(a0), a1)).append(",").append("\"firstMonthOfYear\":").append(a0.getFirstMonthOfYear() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.date.Month\",\"^EnumStringValue\":\"").append(a0.getFirstMonthOfYear().name()).append("\"}") : "null").append(",").append("\"firstDayOfWeek\":").append(a0.getFirstDayOfWeek() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.date.DayOfWeek\",\"^EnumStringValue\":\"").append(a0.getFirstDayOfWeek().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_group_GroupStrategy == null) {
      org_dashbuilder_dataset_group_GroupStrategy = Marshalling.getMarshaller(GroupStrategy.class);
    }
    if (org_dashbuilder_dataset_date_Month == null) {
      org_dashbuilder_dataset_date_Month = Marshalling.getMarshaller(Month.class);
    }
    if (org_dashbuilder_dataset_date_DayOfWeek == null) {
      org_dashbuilder_dataset_date_DayOfWeek = Marshalling.getMarshaller(DayOfWeek.class);
    }
  }
}