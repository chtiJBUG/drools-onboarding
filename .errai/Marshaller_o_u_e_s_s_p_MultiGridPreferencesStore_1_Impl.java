package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore;
import org.uberfire.ext.services.shared.preferences.UserPreferencesType;

public class Marshaller_o_u_e_s_s_p_MultiGridPreferencesStore_1_Impl implements GeneratedMarshaller<MultiGridPreferencesStore> {
  private MultiGridPreferencesStore[] EMPTY_ARRAY = new MultiGridPreferencesStore[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<HashMap> java_util_HashMap = null;
  private Marshaller<ArrayList> java_util_ArrayList = null;
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<UserPreferencesType> org_uberfire_ext_services_shared_preferences_UserPreferencesType = null;
  public MultiGridPreferencesStore[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static HashMap _$1561305032__$1402722386_gridsSettings(MultiGridPreferencesStore instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore::gridsSettings;
  }-*/;

  private native static void _$1561305032__$1402722386_gridsSettings(MultiGridPreferencesStore instance, HashMap<String, HashMap> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore::gridsSettings = value;
  }-*/;

  private native static ArrayList _$1561305032__$1114099497_gridsIds(MultiGridPreferencesStore instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore::gridsIds;
  }-*/;

  private native static void _$1561305032__$1114099497_gridsIds(MultiGridPreferencesStore instance, ArrayList<String> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore::gridsIds = value;
  }-*/;

  public MultiGridPreferencesStore demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(MultiGridPreferencesStore.class, objId);
    }
    MultiGridPreferencesStore entity = new MultiGridPreferencesStore();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("multiGridId")) && (!obj.get("multiGridId").isNull())) {
      entity.setMultiGridId(java_lang_String.demarshall(obj.get("multiGridId"), a1));
    }
    if ((obj.containsKey("gridsSettings")) && (!obj.get("gridsSettings").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.HashMap");
      _$1561305032__$1402722386_gridsSettings(entity, java_util_HashMap.demarshall(obj.get("gridsSettings"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("gridsIds")) && (!obj.get("gridsIds").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1561305032__$1114099497_gridsIds(entity, java_util_ArrayList.demarshall(obj.get("gridsIds"), a1));
    }
    if ((obj.containsKey("selectedGrid")) && (!obj.get("selectedGrid").isNull())) {
      entity.setSelectedGrid(java_lang_String.demarshall(obj.get("selectedGrid"), a1));
    }
    if ((obj.containsKey("refreshInterval")) && (!obj.get("refreshInterval").isNull())) {
      entity.setRefreshInterval(java_lang_Integer.demarshall(obj.get("refreshInterval"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("preferenceKey")) && (!obj.get("preferenceKey").isNull())) {
      entity.setPreferenceKey(java_lang_String.demarshall(obj.get("preferenceKey"), a1));
    }
    return entity;
  }

  public String marshall(MultiGridPreferencesStore a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.MultiGridPreferencesStore\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"multiGridId\":").append(java_lang_String.marshall(a0.getMultiGridId(), a1)).append(",").append("\"gridsSettings\":").append(java_util_HashMap.marshall(_$1561305032__$1402722386_gridsSettings(a0), a1)).append(",").append("\"gridsIds\":").append(java_util_ArrayList.marshall(_$1561305032__$1114099497_gridsIds(a0), a1)).append(",").append("\"selectedGrid\":").append(java_lang_String.marshall(a0.getSelectedGrid(), a1)).append(",").append("\"refreshInterval\":").append(java_lang_Integer.marshall(a0.getRefreshInterval(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserPreferencesType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"preferenceKey\":").append(java_lang_String.marshall(a0.getPreferenceKey(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
    if (org_uberfire_ext_services_shared_preferences_UserPreferencesType == null) {
      org_uberfire_ext_services_shared_preferences_UserPreferencesType = Marshalling.getMarshaller(UserPreferencesType.class);
    }
  }
}