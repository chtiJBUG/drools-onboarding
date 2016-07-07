package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.group.ColumnGroup;
import org.dashbuilder.dataset.group.DataSetGroup;
import org.dashbuilder.dataset.group.GroupFunction;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_g_DataSetGroup_1_Impl implements GeneratedMarshaller<DataSetGroup> {
  private DataSetGroup[] EMPTY_ARRAY = new DataSetGroup[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<ColumnGroup> org_dashbuilder_dataset_group_ColumnGroup = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DataSetGroup[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$812505861__65821278_groupFunctionList(DataSetGroup instance) /*-{
    return instance.@org.dashbuilder.dataset.group.DataSetGroup::groupFunctionList;
  }-*/;

  private native static void _$812505861__65821278_groupFunctionList(DataSetGroup instance, List<GroupFunction> value) /*-{
    instance.@org.dashbuilder.dataset.group.DataSetGroup::groupFunctionList = value;
  }-*/;

  public DataSetGroup demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetGroup.class, objId);
    }
    DataSetGroup entity = new DataSetGroup();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("join")) && (!obj.get("join").isNull())) {
      entity.setJoin(java_lang_Boolean.demarshall(obj.get("join"), a1));
    }
    if ((obj.containsKey("columnGroup")) && (!obj.get("columnGroup").isNull())) {
      entity.setColumnGroup(org_dashbuilder_dataset_group_ColumnGroup.demarshall(obj.get("columnGroup"), a1));
    }
    if ((obj.containsKey("groupFunctionList")) && (!obj.get("groupFunctionList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.group.GroupFunction");
      _$812505861__65821278_groupFunctionList(entity, java_util_List.demarshall(obj.get("groupFunctionList"), a1));
    }
    if ((obj.containsKey("selectedIntervalList")) && (!obj.get("selectedIntervalList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.group.Interval");
      entity.setSelectedIntervalList(java_util_List.demarshall(obj.get("selectedIntervalList"), a1));
    }
    if ((obj.containsKey("dataSetUUID")) && (!obj.get("dataSetUUID").isNull())) {
      entity.setDataSetUUID(java_lang_String.demarshall(obj.get("dataSetUUID"), a1));
    }
    return entity;
  }

  private native static boolean _$812505861__64711720_join(DataSetGroup instance) /*-{
    return instance.@org.dashbuilder.dataset.group.DataSetGroup::join;
  }-*/;

  private native static void _$812505861__64711720_join(DataSetGroup instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.group.DataSetGroup::join = value;
  }-*/;

  public String marshall(DataSetGroup a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.group.DataSetGroup\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"join\":").append(java_lang_Boolean.marshall(_$812505861__64711720_join(a0), a1)).append(",").append("\"columnGroup\":").append(org_dashbuilder_dataset_group_ColumnGroup.marshall(a0.getColumnGroup(), a1)).append(",").append("\"groupFunctionList\":").append(java_util_List.marshall(_$812505861__65821278_groupFunctionList(a0), a1)).append(",").append("\"selectedIntervalList\":").append(java_util_List.marshall(a0.getSelectedIntervalList(), a1)).append(",").append("\"dataSetUUID\":").append(java_lang_String.marshall(a0.getDataSetUUID(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_group_ColumnGroup == null) {
      org_dashbuilder_dataset_group_ColumnGroup = Marshalling.getMarshaller(ColumnGroup.class);
    }
  }
}