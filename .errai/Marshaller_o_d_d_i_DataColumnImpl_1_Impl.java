package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.ColumnType;
import org.dashbuilder.dataset.group.ColumnGroup;
import org.dashbuilder.dataset.group.GroupFunction;
import org.dashbuilder.dataset.impl.DataColumnImpl;
import org.dashbuilder.dataset.impl.DataSetImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_i_DataColumnImpl_1_Impl implements GeneratedMarshaller<DataColumnImpl> {
  private DataColumnImpl[] EMPTY_ARRAY = new DataColumnImpl[0];
  private Marshaller<DataSetImpl> org_dashbuilder_dataset_impl_DataSetImpl = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ColumnType> org_dashbuilder_dataset_ColumnType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<ColumnGroup> org_dashbuilder_dataset_group_ColumnGroup = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<GroupFunction> org_dashbuilder_dataset_group_GroupFunction = null;
  public DataColumnImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataColumnImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataColumnImpl.class, objId);
    }
    DataColumnImpl entity = new DataColumnImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSet")) && (!obj.get("dataSet").isNull())) {
      entity.setDataSet(org_dashbuilder_dataset_impl_DataSetImpl.demarshall(obj.get("dataSet"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("columnType")) && (!obj.get("columnType").isNull())) {
      entity.setColumnType(obj.get("columnType").isObject() != null ? Enum.valueOf(ColumnType.class, obj.get("columnType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("columnType").isString() != null ? Enum.valueOf(ColumnType.class, obj.get("columnType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("values")) && (!obj.get("values").isNull())) {
      entity.setValues(java_util_List.demarshall(obj.get("values"), a1));
    }
    if ((obj.containsKey("columnGroup")) && (!obj.get("columnGroup").isNull())) {
      entity.setColumnGroup(org_dashbuilder_dataset_group_ColumnGroup.demarshall(obj.get("columnGroup"), a1));
    }
    if ((obj.containsKey("intervalType")) && (!obj.get("intervalType").isNull())) {
      entity.setIntervalType(java_lang_String.demarshall(obj.get("intervalType"), a1));
    }
    if ((obj.containsKey("minValue")) && (!obj.get("minValue").isNull())) {
      entity.setMinValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("minValue"), a1));
    }
    if ((obj.containsKey("maxValue")) && (!obj.get("maxValue").isNull())) {
      entity.setMaxValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("maxValue"), a1));
    }
    if ((obj.containsKey("groupFunction")) && (!obj.get("groupFunction").isNull())) {
      entity.setGroupFunction(org_dashbuilder_dataset_group_GroupFunction.demarshall(obj.get("groupFunction"), a1));
    }
    return entity;
  }

  public String marshall(DataColumnImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.impl.DataColumnImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSet\":").append(org_dashbuilder_dataset_impl_DataSetImpl.marshall(a0.getDataSet(), a1)).append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"columnType\":").append(a0.getColumnType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.ColumnType\",\"^EnumStringValue\":\"").append(a0.getColumnType().name()).append("\"}") : "null").append(",").append("\"values\":").append(java_util_List.marshall(a0.getValues(), a1)).append(",").append("\"columnGroup\":").append(org_dashbuilder_dataset_group_ColumnGroup.marshall(a0.getColumnGroup(), a1)).append(",").append("\"intervalType\":").append(java_lang_String.marshall(a0.getIntervalType(), a1)).append(",").append("\"minValue\":").append(java_lang_Object.marshall(a0.getMinValue(), a1)).append(",").append("\"maxValue\":").append(java_lang_Object.marshall(a0.getMaxValue(), a1)).append(",").append("\"groupFunction\":").append(org_dashbuilder_dataset_group_GroupFunction.marshall(a0.getGroupFunction(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_impl_DataSetImpl == null) {
      org_dashbuilder_dataset_impl_DataSetImpl = Marshalling.getMarshaller(DataSetImpl.class);
    }
    if (org_dashbuilder_dataset_ColumnType == null) {
      org_dashbuilder_dataset_ColumnType = Marshalling.getMarshaller(ColumnType.class);
    }
    if (org_dashbuilder_dataset_group_ColumnGroup == null) {
      org_dashbuilder_dataset_group_ColumnGroup = Marshalling.getMarshaller(ColumnGroup.class);
    }
    if (org_dashbuilder_dataset_group_GroupFunction == null) {
      org_dashbuilder_dataset_group_GroupFunction = Marshalling.getMarshaller(GroupFunction.class);
    }
  }
}