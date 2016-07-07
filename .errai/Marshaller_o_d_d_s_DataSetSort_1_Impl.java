package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.sort.ColumnSort;
import org.dashbuilder.dataset.sort.DataSetSort;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_s_DataSetSort_1_Impl implements GeneratedMarshaller<DataSetSort> {
  private DataSetSort[] EMPTY_ARRAY = new DataSetSort[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DataSetSort[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1991119787__65821278_columnSortList(DataSetSort instance) /*-{
    return instance.@org.dashbuilder.dataset.sort.DataSetSort::columnSortList;
  }-*/;

  private native static void _1991119787__65821278_columnSortList(DataSetSort instance, List<ColumnSort> value) /*-{
    instance.@org.dashbuilder.dataset.sort.DataSetSort::columnSortList = value;
  }-*/;

  public DataSetSort demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetSort.class, objId);
    }
    DataSetSort entity = new DataSetSort();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("columnSortList")) && (!obj.get("columnSortList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.sort.ColumnSort");
      _1991119787__65821278_columnSortList(entity, java_util_List.demarshall(obj.get("columnSortList"), a1));
    }
    if ((obj.containsKey("dataSetUUID")) && (!obj.get("dataSetUUID").isNull())) {
      entity.setDataSetUUID(java_lang_String.demarshall(obj.get("dataSetUUID"), a1));
    }
    return entity;
  }

  public String marshall(DataSetSort a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.sort.DataSetSort\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"columnSortList\":").append(java_util_List.marshall(a0.getColumnSortList(), a1)).append(",").append("\"dataSetUUID\":").append(java_lang_String.marshall(a0.getDataSetUUID(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}