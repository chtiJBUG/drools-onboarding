package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.ext.plugin.model.Activity;
import org.uberfire.ext.plugin.model.DynamicMenu;
import org.uberfire.ext.plugin.model.Plugin;
import org.uberfire.ext.plugin.model.PluginType;

public class Marshaller_o_u_e_p_m_DynamicMenu_1_Impl implements GeneratedMarshaller<DynamicMenu> {
  private DynamicMenu[] EMPTY_ARRAY = new DynamicMenu[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PluginType> org_uberfire_ext_plugin_model_PluginType = null;
  public DynamicMenu[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1586984878__$2084529122_path(Plugin instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.Plugin::path;
  }-*/;

  private native static void _$1586984878__$2084529122_path(Plugin instance, Path value) /*-{
    instance.@org.uberfire.ext.plugin.model.Plugin::path = value;
  }-*/;

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

  public DynamicMenu demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DynamicMenu.class, objId);
    }
    final Collection c3 = (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("menuItems"), a1);
    final Path c2 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1);
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    final PluginType c1 = obj.get("type").isObject() != null ? Enum.valueOf(PluginType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PluginType.class, obj.get("type").isString().stringValue()) : null;
    DynamicMenu entity = new DynamicMenu(c0, c1, c2, c3);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1586984878__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$175423378__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$175423378__781193900_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(PluginType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PluginType.class, obj.get("type").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(DynamicMenu a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.DynamicMenu\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"menuItems\":").append(java_lang_Object.marshall(a0.getMenuItems(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_PluginType == null) {
      org_uberfire_ext_plugin_model_PluginType = Marshalling.getMarshaller(PluginType.class);
    }
  }
}