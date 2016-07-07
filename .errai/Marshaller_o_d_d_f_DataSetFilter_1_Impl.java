package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.filter.ColumnFilter;
import org.dashbuilder.dataset.filter.DataSetFilter;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_f_DataSetFilter_1_Impl implements GeneratedMarshaller<DataSetFilter> {
  private DataSetFilter[] EMPTY_ARRAY = new DataSetFilter[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DataSetFilter[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$2037248673__65821278_columnFilterList(DataSetFilter instance) /*-{
    return instance.@org.dashbuilder.dataset.filter.DataSetFilter::columnFilterList;
  }-*/;

  private native static void _$2037248673__65821278_columnFilterList(DataSetFilter instance, List<ColumnFilter> value) /*-{
    instance.@org.dashbuilder.dataset.filter.DataSetFilter::columnFilterList = value;
  }-*/;

  public DataSetFilter demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetFilter.class, objId);
    }
    DataSetFilter entity = new DataSetFilter();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("columnFilterList")) && (!obj.get("columnFilterList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.filter.ColumnFilter");
      _$2037248673__65821278_columnFilterList(entity, java_util_List.demarshall(obj.get("columnFilterList"), a1));
    }
    if ((obj.containsKey("dataSetUUID")) && (!obj.get("dataSetUUID").isNull())) {
      entity.setDataSetUUID(java_lang_String.demarshall(obj.get("dataSetUUID"), a1));
    }
    return entity;
  }

  public String marshall(DataSetFilter a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.DataSetFilter\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"columnFilterList\":").append(java_util_List.marshall(a0.getColumnFilterList(), a1)).append(",").append("\"dataSetUUID\":").append(java_lang_String.marshall(a0.getDataSetUUID(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}