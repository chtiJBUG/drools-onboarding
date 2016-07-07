package org.jboss.errai.marshalling.client.api;

import java.util.HashMap;
import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.GridColumnPreference;
import org.uberfire.ext.services.shared.preferences.GridGlobalPreferences;
import org.uberfire.ext.services.shared.preferences.GridPreferencesStore;
import org.uberfire.ext.services.shared.preferences.UserPreferencesType;

public class Marshaller_o_u_e_s_s_p_GridPreferencesStore_1_Impl implements GeneratedMarshaller<GridPreferencesStore> {
  private GridPreferencesStore[] EMPTY_ARRAY = new GridPreferencesStore[0];
  private Marshaller<GridGlobalPreferences> org_uberfire_ext_services_shared_preferences_GridGlobalPreferences = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<HashMap> java_util_HashMap = null;
  private Marshaller<UserPreferencesType> org_uberfire_ext_services_shared_preferences_UserPreferencesType = null;
  public GridPreferencesStore[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GridGlobalPreferences _$798628609__$1440754209_globalPreferences(GridPreferencesStore instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::globalPreferences;
  }-*/;

  private native static void _$798628609__$1440754209_globalPreferences(GridPreferencesStore instance, GridGlobalPreferences value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::globalPreferences = value;
  }-*/;

  private native static List _$798628609__65821278_columnPreferences(GridPreferencesStore instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::columnPreferences;
  }-*/;

  private native static void _$798628609__65821278_columnPreferences(GridPreferencesStore instance, List<GridColumnPreference> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::columnPreferences = value;
  }-*/;

  private native static HashMap _$798628609__$1402722386_customFilters(GridPreferencesStore instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::customFilters;
  }-*/;

  private native static void _$798628609__$1402722386_customFilters(GridPreferencesStore instance, HashMap<String, HashMap> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridPreferencesStore::customFilters = value;
  }-*/;

  public GridPreferencesStore demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GridPreferencesStore.class, objId);
    }
    GridPreferencesStore entity = new GridPreferencesStore();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("globalPreferences")) && (!obj.get("globalPreferences").isNull())) {
      _$798628609__$1440754209_globalPreferences(entity, org_uberfire_ext_services_shared_preferences_GridGlobalPreferences.demarshall(obj.get("globalPreferences"), a1));
    }
    if ((obj.containsKey("columnPreferences")) && (!obj.get("columnPreferences").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.services.shared.preferences.GridColumnPreference");
      _$798628609__65821278_columnPreferences(entity, java_util_List.demarshall(obj.get("columnPreferences"), a1));
    }
    if ((obj.containsKey("pageSizePreferences")) && (!obj.get("pageSizePreferences").isNull())) {
      entity.setPageSizePreferences(java_lang_Integer.demarshall(obj.get("pageSizePreferences"), a1));
    }
    if ((obj.containsKey("selectedFilterKey")) && (!obj.get("selectedFilterKey").isNull())) {
      entity.setSelectedFilterKey(java_lang_String.demarshall(obj.get("selectedFilterKey"), a1));
    }
    if ((obj.containsKey("customFilters")) && (!obj.get("customFilters").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.HashMap");
      _$798628609__$1402722386_customFilters(entity, java_util_HashMap.demarshall(obj.get("customFilters"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("preferenceKey")) && (!obj.get("preferenceKey").isNull())) {
      entity.setPreferenceKey(java_lang_String.demarshall(obj.get("preferenceKey"), a1));
    }
    return entity;
  }

  public String marshall(GridPreferencesStore a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.GridPreferencesStore\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"globalPreferences\":").append(org_uberfire_ext_services_shared_preferences_GridGlobalPreferences.marshall(a0.getGlobalPreferences(), a1)).append(",").append("\"columnPreferences\":").append(java_util_List.marshall(a0.getColumnPreferences(), a1)).append(",").append("\"pageSizePreferences\":").append(java_lang_Integer.marshall(a0.getPageSizePreferences(), a1)).append(",").append("\"selectedFilterKey\":").append(java_lang_String.marshall(a0.getSelectedFilterKey(), a1)).append(",").append("\"customFilters\":").append(java_util_HashMap.marshall(a0.getCustomFilters(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserPreferencesType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"preferenceKey\":").append(java_lang_String.marshall(a0.getPreferenceKey(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_services_shared_preferences_GridGlobalPreferences == null) {
      org_uberfire_ext_services_shared_preferences_GridGlobalPreferences = Marshalling.getMarshaller(GridGlobalPreferences.class);
    }
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
    if (org_uberfire_ext_services_shared_preferences_UserPreferencesType == null) {
      org_uberfire_ext_services_shared_preferences_UserPreferencesType = Marshalling.getMarshaller(UserPreferencesType.class);
    }
  }
}