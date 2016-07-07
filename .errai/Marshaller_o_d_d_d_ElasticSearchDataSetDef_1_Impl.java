package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.dashbuilder.dataprovider.DataSetProviderType;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.def.ElasticSearchDataSetDef;
import org.dashbuilder.dataset.filter.DataSetFilter;
import org.dashbuilder.dataset.sort.ColumnSort;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_ElasticSearchDataSetDef_1_Impl implements GeneratedMarshaller<ElasticSearchDataSetDef> {
  private ElasticSearchDataSetDef[] EMPTY_ARRAY = new ElasticSearchDataSetDef[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ColumnSort> org_dashbuilder_dataset_sort_ColumnSort = null;
  private Marshaller<DataSetProviderType> org_dashbuilder_dataprovider_DataSetProviderType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<DataSetFilter> org_dashbuilder_dataset_filter_DataSetFilter = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public ElasticSearchDataSetDef[] getEmptyArray() {
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

  public ElasticSearchDataSetDef demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ElasticSearchDataSetDef.class, objId);
    }
    ElasticSearchDataSetDef entity = new ElasticSearchDataSetDef();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("serverURL")) && (!obj.get("serverURL").isNull())) {
      entity.setServerURL(java_lang_String.demarshall(obj.get("serverURL"), a1));
    }
    if ((obj.containsKey("clusterName")) && (!obj.get("clusterName").isNull())) {
      entity.setClusterName(java_lang_String.demarshall(obj.get("clusterName"), a1));
    }
    if ((obj.containsKey("index")) && (!obj.get("index").isNull())) {
      entity.setIndex(java_lang_String.demarshall(obj.get("index"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("query")) && (!obj.get("query").isNull())) {
      entity.setQuery(java_lang_String.demarshall(obj.get("query"), a1));
    }
    if ((obj.containsKey("relevance")) && (!obj.get("relevance").isNull())) {
      entity.setRelevance(java_lang_String.demarshall(obj.get("relevance"), a1));
    }
    if ((obj.containsKey("columnSort")) && (!obj.get("columnSort").isNull())) {
      entity.setColumnSort(org_dashbuilder_dataset_sort_ColumnSort.demarshall(obj.get("columnSort"), a1));
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

  public String marshall(ElasticSearchDataSetDef a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.def.ElasticSearchDataSetDef\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"serverURL\":").append(java_lang_String.marshall(a0.getServerURL(), a1)).append(",").append("\"clusterName\":").append(java_lang_String.marshall(a0.getClusterName(), a1)).append(",").append("\"index\":").append(java_lang_String.marshall(a0.getIndex(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"query\":").append(java_lang_String.marshall(a0.getQuery(), a1)).append(",").append("\"relevance\":").append(java_lang_String.marshall(a0.getRelevance(), a1)).append(",").append("\"columnSort\":").append(org_dashbuilder_dataset_sort_ColumnSort.marshall(a0.getColumnSort(), a1)).append(",").append("\"UUID\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"provider\":").append(a0.getProvider() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataprovider.DataSetProviderType\",\"^EnumStringValue\":\"").append(a0.getProvider().name()).append("\"}") : "null").append(",").append("\"columns\":").append(java_util_List.marshall(a0.getColumns(), a1)).append(",").append("\"dataSetFilter\":").append(org_dashbuilder_dataset_filter_DataSetFilter.marshall(a0.getDataSetFilter(), a1)).append(",").append("\"isPublic\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_isPublic(a0), a1)).append(",").append("\"pushEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_pushEnabled(a0), a1)).append(",").append("\"pushMaxSize\":").append(java_lang_Integer.marshall(a0.getPushMaxSize(), a1)).append(",").append("\"cacheEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_cacheEnabled(a0), a1)).append(",").append("\"cacheMaxRows\":").append(java_lang_Integer.marshall(a0.getCacheMaxRows(), a1)).append(",").append("\"refreshTime\":").append(java_lang_String.marshall(a0.getRefreshTime(), a1)).append(",").append("\"refreshAlways\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_refreshAlways(a0), a1)).append(",").append("\"allColumnsEnabled\":").append(java_lang_Boolean.marshall(_$1914125957__64711720_allColumnsEnabled(a0), a1)).append(",").append("\"patternMap\":").append(java_util_Map.marshall(_$1914125957__$1383349348_patternMap(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_sort_ColumnSort == null) {
      org_dashbuilder_dataset_sort_ColumnSort = Marshalling.getMarshaller(ColumnSort.class);
    }
    if (org_dashbuilder_dataprovider_DataSetProviderType == null) {
      org_dashbuilder_dataprovider_DataSetProviderType = Marshalling.getMarshaller(DataSetProviderType.class);
    }
    if (org_dashbuilder_dataset_filter_DataSetFilter == null) {
      org_dashbuilder_dataset_filter_DataSetFilter = Marshalling.getMarshaller(DataSetFilter.class);
    }
  }
}