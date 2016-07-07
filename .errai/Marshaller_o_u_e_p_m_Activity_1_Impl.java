package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.Activity;
import org.uberfire.ext.plugin.model.PluginType;

public class Marshaller_o_u_e_p_m_Activity_1_Impl implements GeneratedMarshaller<Activity> {
  private Activity[] EMPTY_ARRAY = new Activity[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PluginType> org_uberfire_ext_plugin_model_PluginType = null;
  public Activity[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$175423378__1195259493_name(Activity instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.Activity::name;
  }-*/;

  private native static void _$175423378__1195259493_name(Activity instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.model.Activity::name = value;
  }-*/;

  private native static PluginType _$175423378__781193900_type(Activity instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.Activity::type;
  }-*/;

  private native static void _$175423378__781193900_type(Activity instance, PluginType value) /*-{
    instance.@org.uberfire.ext.plugin.model.Activity::type = value;
  }-*/;

  public Activity demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Activity.class, objId);
    }
    Activity entity = new Activity();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$175423378__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$175423378__781193900_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(PluginType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PluginType.class, obj.get("type").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(Activity a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.Activity\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_PluginType == null) {
      org_uberfire_ext_plugin_model_PluginType = Marshalling.getMarshaller(PluginType.class);
    }
  }
}