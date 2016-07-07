package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.dashbuilder.dataprovider.DataSetProviderType;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.def.SQLDataSetDef;
import org.dashbuilder.dataset.filter.DataSetFilter;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_SQLDataSetDef_1_Impl implements GeneratedMarshaller<SQLDataSetDef> {
  private SQLDataSetDef[] EMPTY_ARRAY = new SQLDataSetDef[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<DataSetProviderType> org_dashbuilder_dataprovider_DataSetProviderType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<DataSetFilter> org_dashbuilder_dataset_filter_DataSetFilter = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public SQLDataSetDef[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1914125957__64711720_isPublic(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::isPublic;
  }-*/;

  private native static void _$1914125957__64711720_isPublic(DataSetDef instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::isPublic = value;
  }-*/;

  private native static Map _$1914125957__$1383349348_patternMap(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::patternMap;
  }-*/;

  private native static void _$1914125957__$1383349348_patternMap(DataSetDef instance, Map<String, String> value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::patternMap = value;
  }-*/;

  public SQLDataSetDef demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SQLDataSetDef.class, objId);
    }
    SQLDataSetDef entity = new SQLDataSetDef();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSource")) && (!obj.get("dataSource").isNull())) {
      entity.setDataSource(java_lang_String.demarshall(obj.get("dataSource"), a1));
    }
    if ((obj.containsKey("dbSchema")) && (!obj.get("dbSchema").isNull())) {
      entity.setDbSchema(java_lang_String.demarshall(obj.get("dbSchema"), a1));
    }
    if ((obj.containsKey("dbTable")) && (!obj.get("dbTable").isNull())) {
      entity.setDbTable(java_lang_String.demarshall(obj.get("dbTable"), a1));
    }
    if ((obj.containsKey("dbSQL")) && (!obj.get("dbSQL").isNull())) {
      entity.setDbSQL(java_lang_String.demarshall(obj.get("dbSQL"), a1));
    }
    if ((obj.containsKey("UUID")) && (!obj.get("UUID").isNull())) {
      entity.setUUID(java_lang_String.demarshall(obj.get("UUID"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("provider")) && (!obj.get("provider").isNull())) {
      entity.setProvider(obj.get("provider").isObject() != null ? Enum.valueOf(DataSetProviderType.class, obj.get("provider").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("provider").isString() != null ? Enum.valueOf(DataSetProviderType.class, obj.get("provider").isString().stringValue()) : null);
    }
    if ((obj.containsKey("columns")) && (!obj.get("columns").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.def.DataColumnDef");
      entity.setColumns(java_util_List.demarshall(obj.get("columns"), a1));
    }
    if ((obj.containsKey("dataSetFilter")) && (!obj.get("dataSetFilter").isNull())) {
      entity.setDataSetFilter(org_dashbuilder_dataset_filter_DataSetFilter.demarshall(obj.get("dataSetFilter"), a1));
    }
    if ((obj.containsKey("isPublic")) && (!obj.get("isPublic").isNull())) {
      _$1914125957__64711720_isPublic(entity, java_lang_Boolean.demarshall(obj.get("isPublic"), a1));
    }
    if ((obj.containsKey("pushEnabled")) && (!obj.get("pushEnabled").isNull())) {
      entity.setPushEnabled(java_lang_Boolean.demarshall(obj.get("pushEnabled"), a1));
    }
    if ((obj.containsKey("pushMaxSize")) && (!obj.get("pushMaxSize").isNull())) {
      entity.setPushMaxSize(java_lang_Integer.demarshall(obj.get("pushMaxSize"), a1));
    }
    if ((obj.containsKey("cacheEnabled")) && (!obj.get("cacheEnabled").isNull())) {
      entity.setCacheEnabled(java_lang_Boolean.demarshall(obj.get("cacheEnabled"), a1));
    }
    if ((obj.containsKey("cacheMaxRows")) && (!obj.get("cacheMaxRows").isNull())) {
      entity.setCacheMaxRows(java_lang_Integer.demarshall(obj.get("cacheMaxRows"), a1));
    }
    if ((obj.containsKey("refreshTime")) && (!obj.get("refreshTime").isNull())) {
      entity.setRefreshTime(java_lang_String.demarshall(obj.get("refreshTime"), a1));
    }
    if ((obj.containsKey("refreshAlways")) && (!obj.get("refreshAlways").isNull())) {
      entity.setRefreshAlways(java_lang_Boolean.demarshall(obj.get("refreshAlways"), a1));
    }
    if ((obj.containsKey("allColumnsEnabled")) && (!obj.get("allColumnsEnabled").isNull())) {
      entity.setAllColumnsEnabled(java_lang_Boolean.demarshall(obj.get("allColumnsEnabled"), a1));
    }
    if ((obj.containsKey("patternMap")) && (!obj.get("patternMap").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$1914125957__$1383349348_patternMap(entity, java_util_Map.demarshall(obj.get("patternMap"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  private native static boolean _$1914125957__64711720_pushEnabled(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::pushEnabled;
  }-*/;

  private native static void _$1914125957__64711720_pushEnabled(DataSetDef instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::pushEnabled = value;
  }-*/;

  private native static boolean _$1914125957__64711720_cacheEnabled(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::cacheEnabled;
  }-*/;

  private native static void _$1914125957__64711720_cacheEnabled(DataSetDef instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::cacheEnabled = value;
  }-*/;

  private native static boolean _$1914125957__64711720_refreshAlways(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::refreshAlways;
  }-*/;

  private native static void _$1914125957__64711720_refreshAlways(DataSetDef instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::refreshAlways = value;
  }-*/;

  private native static boolean _$1914125957__64711720_allColumnsEnabled(DataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.def.DataSetDef::allColumnsEnabled;
  }-*/;

  private native static void _$1914125957__64711720_allColumnsEnabled(DataSetDef instance, boolean value) /*-{
    instance.@org.dashbuilder.dataset.def.DataSetDef::allColumnsEnabled = value;
  }-*/;

  public String marshall(SQLDataSetDef a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.def.SQLDataSetDef\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSource\":").append(java_lang_String.marshall(a0.getDataSource(), a1)).append(",").append("\"dbSchema\":").append(java_lang_String.marshall(a0.getDbSchema(), a1)).append(",").append("\"dbTable\":").append(java_lang_String.marshall(a0.getDbTable(), a1)).append(",").append("\"dbSQL\":").append(java_lang_String.marshall(a0.getDbSQL(), a1)).append(",").append("\"UUID\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"provider\":").append(a0.getProvider() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataprovider.DataSetProviderType\",\"^EnumStringValue\":\"").append(a0.getProvider().name()).append("\"}") : "null").append(",").append("\"columns\":").append(java_util_List.marshall(a0.getColumns(), a1)).append(",").append("\"dataSetFilter\":").append(org_dashbuilder_dataset_filter_DataSetFilter.marshall(a0.getDataSetFilter(), a1)).append(",").append("\"isPublic\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_isPublic(a0), a1)).append(",").append("\"pushEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_pushEnabled(a0), a1)).append(",").append("\"pushMaxSize\":").append(java_lang_Integer.marshall(a0.getPushMaxSize(), a1)).append(",").append("\"cacheEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_cacheEnabled(a0), a1)).append(",").append("\"cacheMaxRows\":").append(java_lang_Integer.marshall(a0.getCacheMaxRows(), a1)).append(",").append("\"refreshTime\":").append(java_lang_String.marshall(a0.getRefreshTime(), a1)).append(",").append("\"refreshAlways\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_refreshAlways(a0), a1)).append(",").append("\"allColumnsEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_allColumnsEnabled(a0), a1)).append(",").append("\"patternMap\":").append(java_util_Map.marshall(_$1914125957__$1383349348_patternMap(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataprovider_DataSetProviderType == null) {
      org_dashbuilder_dataprovider_DataSetProviderType = Marshalling.getMarshaller(DataSetProviderType.class);
    }
    if (org_dashbuilder_dataset_filter_DataSetFilter == null) {
      org_dashbuilder_dataset_filter_DataSetFilter = Marshalling.getMarshaller(DataSetFilter.class);
    }
  }
}