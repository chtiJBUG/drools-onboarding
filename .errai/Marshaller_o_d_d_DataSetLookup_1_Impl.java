package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.DataSetLookup;
import org.dashbuilder.dataset.DataSetOp;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_DataSetLookup_1_Impl implements GeneratedMarshaller<DataSetLookup> {
  private DataSetLookup[] EMPTY_ARRAY = new DataSetLookup[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public DataSetLookup[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1130144749__65821278_operationList(DataSetLookup instance) /*-{
    return instance.@org.dashbuilder.dataset.DataSetLookup::operationList;
  }-*/;

  private native static void _1130144749__65821278_operationList(DataSetLookup instance, List<DataSetOp> value) /*-{
    instance.@org.dashbuilder.dataset.DataSetLookup::operationList = value;
  }-*/;

  public DataSetLookup demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetLookup.class, objId);
    }
    DataSetLookup entity = new DataSetLookup();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSetUUID")) && (!obj.get("dataSetUUID").isNull())) {
      entity.setDataSetUUID(java_lang_String.demarshall(obj.get("dataSetUUID"), a1));
    }
    if ((obj.containsKey("rowOffset")) && (!obj.get("rowOffset").isNull())) {
      entity.setRowOffset(java_lang_Integer.demarshall(obj.get("rowOffset"), a1));
    }
    if ((obj.containsKey("numberOfRows")) && (!obj.get("numberOfRows").isNull())) {
      entity.setNumberOfRows(java_lang_Integer.demarshall(obj.get("numberOfRows"), a1));
    }
    if ((obj.containsKey("testMode")) && (!obj.get("testMode").isNull())) {
      entity.setTestMode(java_lang_Boolean.demarshall(obj.get("testMode"), a1));
    }
    if ((obj.containsKey("operationList")) && (!obj.get("operationList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.DataSetOp");
      _1130144749__65821278_operationList(entity, java_util_List.demarshall(obj.get("operationList"), a1));
    }
    return entity;
  }

  private native static boolean _1130144749__64711720_testMode(DataSetLookup instance) /*-{
    return instance.@org.dashbuilder.dataset.DataSetLookup::testMode;
  }-*/;

  private native static void _1130144749__64711720_testMode(DataSetLookup instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.DataSetLookup::testMode = value;
  }-*/;

  public String marshall(DataSetLookup a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.DataSetLookup\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSetUUID\":").append(java_lang_String.marshall(a0.getDataSetUUID(), a1)).append(",").append("\"rowOffset\":").append(java_lang_Integer.marshall(a0.getRowOffset(), a1)).append(",").append("\"numberOfRows\":").append(java_lang_Integer.marshall(a0.getNumberOfRows(), a1)).append(",").append("\"testMode\":").append(java_lang_Boolean.marshall(_1130144749__64711720_testMode(a0), a1)).append(",").append("\"operationList\":").append(java_util_List.marshall(a0.getOperationList(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}