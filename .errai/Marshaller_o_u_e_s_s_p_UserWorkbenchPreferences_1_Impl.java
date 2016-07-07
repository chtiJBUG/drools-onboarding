package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.UserPreferencesType;
import org.uberfire.ext.services.shared.preferences.UserWorkbenchPreferences;

public class Marshaller_o_u_e_s_s_p_UserWorkbenchPreferences_1_Impl implements GeneratedMarshaller<UserWorkbenchPreferences> {
  private UserWorkbenchPreferences[] EMPTY_ARRAY = new UserWorkbenchPreferences[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<UserPreferencesType> org_uberfire_ext_services_shared_preferences_UserPreferencesType = null;
  public UserWorkbenchPreferences[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UserWorkbenchPreferences demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserWorkbenchPreferences.class, objId);
    }
    UserWorkbenchPreferences entity = new UserWorkbenchPreferences();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("language")) && (!obj.get("language").isNull())) {
      entity.setLanguage(java_lang_String.demarshall(obj.get("language"), a1));
    }
    if ((obj.containsKey("perspectiveViewMode")) && (!obj.get("perspectiveViewMode").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setPerspectiveViewMode(java_util_Map.demarshall(obj.get("perspectiveViewMode"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("useWorkbenchInCompactMode")) && (!obj.get("useWorkbenchInCompactMode").isNull())) {
      entity.setUseWorkbenchInCompactMode(java_lang_Boolean.demarshall(obj.get("useWorkbenchInCompactMode"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("preferenceKey")) && (!obj.get("preferenceKey").isNull())) {
      entity.setPreferenceKey(java_lang_String.demarshall(obj.get("preferenceKey"), a1));
    }
    return entity;
  }

  private native static boolean _$100385548__64711720_useWorkbenchInCompactMode(UserWorkbenchPreferences instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.UserWorkbenchPreferences::useWorkbenchInCompactMode;
  }-*/;

  private native static void _$100385548__64711720_useWorkbenchInCompactMode(UserWorkbenchPreferences instance, boolean value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.UserWorkbenchPreferences::useWorkbenchInCompactMode = value;
  }-*/;

  public String marshall(UserWorkbenchPreferences a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserWorkbenchPreferences\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"language\":").append(java_lang_String.marshall(a0.getLanguage(), a1)).append(",").append("\"perspectiveViewMode\":").append(java_util_Map.marshall(a0.getPerspectiveViewMode(), a1)).append(",").append("\"useWorkbenchInCompactMode\":").append(java_lang_Boolean.marshall(_$100385548__64711720_useWorkbenchInCompactMode(a0), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserPreferencesType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"preferenceKey\":").append(java_lang_String.marshall(a0.getPreferenceKey(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_services_shared_preferences_UserPreferencesType == null) {
      org_uberfire_ext_services_shared_preferences_UserPreferencesType = Marshalling.getMarshaller(UserPreferencesType.class);
    }
  }
}