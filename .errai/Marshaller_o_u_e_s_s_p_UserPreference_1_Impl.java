package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.UserPreference;
import org.uberfire.ext.services.shared.preferences.UserPreferencesType;

public class Marshaller_o_u_e_s_s_p_UserPreference_1_Impl implements GeneratedMarshaller<UserPreference> {
  private UserPreference[] EMPTY_ARRAY = new UserPreference[0];
  private Marshaller<UserPreferencesType> org_uberfire_ext_services_shared_preferences_UserPreferencesType = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public UserPreference[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UserPreference demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserPreference.class, objId);
    }
    UserPreference entity = new UserPreference();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(UserPreferencesType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("preferenceKey")) && (!obj.get("preferenceKey").isNull())) {
      entity.setPreferenceKey(java_lang_String.demarshall(obj.get("preferenceKey"), a1));
    }
    return entity;
  }

  public String marshall(UserPreference a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserPreference\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.UserPreferencesType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"preferenceKey\":").append(java_lang_String.marshall(a0.getPreferenceKey(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_services_shared_preferences_UserPreferencesType == null) {
      org_uberfire_ext_services_shared_preferences_UserPreferencesType = Marshalling.getMarshaller(UserPreferencesType.class);
    }
  }
}