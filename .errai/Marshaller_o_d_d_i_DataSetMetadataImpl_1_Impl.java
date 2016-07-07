package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.ColumnType;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.impl.DataSetMetadataImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_i_DataSetMetadataImpl_1_Impl implements GeneratedMarshaller<DataSetMetadataImpl> {
  private DataSetMetadataImpl[] EMPTY_ARRAY = new DataSetMetadataImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public DataSetMetadataImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _2069822078__1195259493_uuid(DataSetMetadataImpl instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::uuid;
  }-*/;

  private native static void _2069822078__1195259493_uuid(DataSetMetadataImpl instance, String value) /*-{
    instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::uuid = value;
  }-*/;

  private native static int _2069822078__104431_numberOfColumns(DataSetMetadataImpl instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::numberOfColumns;
  }-*/;

  private native static void _2069822078__104431_numberOfColumns(DataSetMetadataImpl instance, int value) /*-{
    instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::numberOfColumns = value;
  }-*/;

  private native static List _2069822078__65821278_columnIds(DataSetMetadataImpl instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::columnIds;
  }-*/;

  private native static void _2069822078__65821278_columnIds(DataSetMetadataImpl instance, List<String> value) /*-{
    instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::columnIds = value;
  }-*/;

  private native static List _2069822078__65821278_columnTypes(DataSetMetadataImpl instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::columnTypes;
  }-*/;

  private native static void _2069822078__65821278_columnTypes(DataSetMetadataImpl instance, List<ColumnType> value) /*-{
    instance.@org.dashbuilder.dataset.impl.DataSetMetadataImpl::columnTypes = value;
  }-*/;

  public DataSetMetadataImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetMetadataImpl.class, objId);
    }
    DataSetMetadataImpl entity = new DataSetMetadataImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("definition")) && (!obj.get("definition").isNull())) {
      entity.setDefinition((DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("definition"), a1));
    }
    if ((obj.containsKey("uuid")) && (!obj.get("uuid").isNull())) {
      _2069822078__1195259493_uuid(entity, java_lang_String.demarshall(obj.get("uuid"), a1));
    }
    if ((obj.containsKey("numberOfRows")) && (!obj.get("numberOfRows").isNull())) {
      entity.setNumberOfRows(java_lang_Integer.demarshall(obj.get("numberOfRows"), a1));
    }
    if ((obj.containsKey("numberOfColumns")) && (!obj.get("numberOfColumns").isNull())) {
      _2069822078__104431_numberOfColumns(entity, java_lang_Integer.demarshall(obj.get("numberOfColumns"), a1));
    }
    if ((obj.containsKey("columnIds")) && (!obj.get("columnIds").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _2069822078__65821278_columnIds(entity, java_util_List.demarshall(obj.get("columnIds"), a1));
    }
    if ((obj.containsKey("columnTypes")) && (!obj.get("columnTypes").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.ColumnType");
      _2069822078__65821278_columnTypes(entity, java_util_List.demarshall(obj.get("columnTypes"), a1));
    }
    if ((obj.containsKey("estimatedSize")) && (!obj.get("estimatedSize").isNull())) {
      entity.setEstimatedSize(java_lang_Integer.demarshall(obj.get("estimatedSize"), a1));
    }
    return entity;
  }

  public String marshall(DataSetMetadataImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.impl.DataSetMetadataImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"definition\":").append(java_lang_Object.marshall(a0.getDefinition(), a1)).append(",").append("\"uuid\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"numberOfRows\":").append(java_lang_Integer.marshall(a0.getNumberOfRows(), a1)).append(",").append("\"numberOfColumns\":").append(java_lang_Integer.marshall(a0.getNumberOfColumns(), a1)).append(",").append("\"columnIds\":").append(java_util_List.marshall(a0.getColumnIds(), a1)).append(",").append("\"columnTypes\":").append(java_util_List.marshall(a0.getColumnTypes(), a1)).append(",").append("\"estimatedSize\":").append(java_lang_Integer.marshall(a0.getEstimatedSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}