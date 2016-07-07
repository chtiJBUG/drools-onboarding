package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.ext.plugin.event.BaseNewPlugin;
import org.uberfire.ext.plugin.event.PluginRenamed;
import org.uberfire.ext.plugin.model.Plugin;
import org.uberfire.rpc.SessionInfo;

public class Marshaller_o_u_e_p_e_PluginRenamed_1_Impl implements GeneratedMarshaller<PluginRenamed> {
  private PluginRenamed[] EMPTY_ARRAY = new PluginRenamed[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  public PluginRenamed[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Plugin _$918170412__$1586984878_plugin(BaseNewPlugin instance) /*-{
    return instance.@org.uberfire.ext.plugin.event.BaseNewPlugin::plugin;
  }-*/;

  private native static void _$918170412__$1586984878_plugin(BaseNewPlugin instance, Plugin value) /*-{
    instance.@org.uberfire.ext.plugin.event.BaseNewPlugin::plugin = value;
  }-*/;

  private native static SessionInfo _$918170412__291376327_sessionInfo(BaseNewPlugin instance) /*-{
    return instance.@org.uberfire.ext.plugin.event.BaseNewPlugin::sessionInfo;
  }-*/;

  private native static void _$918170412__291376327_sessionInfo(BaseNewPlugin instance, SessionInfo value) /*-{
    instance.@org.uberfire.ext.plugin.event.BaseNewPlugin::sessionInfo = value;
  }-*/;

  public PluginRenamed demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PluginRenamed.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("oldPluginName"), a1);
    final Plugin c1 = (Plugin) ((ObjectMarshaller) java_lang_Object).demarshall(Plugin.class, obj.get("plugin"), a1);
    final SessionInfo c2 = org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1);
    PluginRenamed entity = new PluginRenamed(c0, c1, c2);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("plugin")) && (!obj.get("plugin").isNull())) {
      _$918170412__$1586984878_plugin(entity, (Plugin) ((ObjectMarshaller) java_lang_Object).demarshall(Plugin.class, obj.get("plugin"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _$918170412__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    return entity;
  }

  public String marshall(PluginRenamed a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.event.PluginRenamed\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"oldPluginName\":").append(java_lang_String.marshall(a0.getOldPluginName(), a1)).append(",").append("\"plugin\":").append(java_lang_Object.marshall(a0.getPlugin(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}