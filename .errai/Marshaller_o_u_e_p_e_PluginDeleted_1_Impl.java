package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.event.BasePluginEvent;
import org.uberfire.ext.plugin.event.PluginDeleted;
import org.uberfire.ext.plugin.model.PluginType;
import org.uberfire.rpc.SessionInfo;

public class Marshaller_o_u_e_p_e_PluginDeleted_1_Impl implements GeneratedMarshaller<PluginDeleted> {
  private PluginDeleted[] EMPTY_ARRAY = new PluginDeleted[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PluginType> org_uberfire_ext_plugin_model_PluginType = null;
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  public PluginDeleted[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$417091896__1195259493_pluginName(BasePluginEvent instance) /*-{
    return instance.@org.uberfire.ext.plugin.event.BasePluginEvent::pluginName;
  }-*/;

  private native static void _$417091896__1195259493_pluginName(BasePluginEvent instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.event.BasePluginEvent::pluginName = value;
  }-*/;

  private native static PluginType _$417091896__781193900_type(BasePluginEvent instance) /*-{
    return instance.@org.uberfire.ext.plugin.event.BasePluginEvent::type;
  }-*/;

  private native static void _$417091896__781193900_type(BasePluginEvent instance, PluginType value) /*-{
    instance.@org.uberfire.ext.plugin.event.BasePluginEvent::type = value;
  }-*/;

  private native static SessionInfo _$417091896__291376327_sessionInfo(BasePluginEvent instance) /*-{
    return instance.@org.uberfire.ext.plugin.event.BasePluginEvent::sessionInfo;
  }-*/;

  private native static void _$417091896__291376327_sessionInfo(BasePluginEvent instance, SessionInfo value) /*-{
    instance.@org.uberfire.ext.plugin.event.BasePluginEvent::sessionInfo = value;
  }-*/;

  public PluginDeleted demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PluginDeleted.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("pluginName"), a1);
    final PluginType c1 = obj.get("type").isObject() != null ? Enum.valueOf(PluginType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PluginType.class, obj.get("type").isString().stringValue()) : null;
    final SessionInfo c2 = org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1);
    PluginDeleted entity = new PluginDeleted(c0, c1, c2);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pluginName")) && (!obj.get("pluginName").isNull())) {
      _$417091896__1195259493_pluginName(entity, java_lang_String.demarshall(obj.get("pluginName"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$417091896__781193900_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(PluginType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PluginType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _$417091896__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    return entity;
  }

  public String marshall(PluginDeleted a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.event.PluginDeleted\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pluginName\":").append(java_lang_String.marshall(a0.getPluginName(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_PluginType == null) {
      org_uberfire_ext_plugin_model_PluginType = Marshalling.getMarshaller(PluginType.class);
    }
  }
}