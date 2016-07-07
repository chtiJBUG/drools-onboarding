package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.ext.plugin.model.Activity;
import org.uberfire.ext.plugin.model.LayoutEditorModel;
import org.uberfire.ext.plugin.model.Plugin;
import org.uberfire.ext.plugin.model.PluginType;

public class Marshaller_o_u_e_p_m_LayoutEditorModel_1_Impl implements GeneratedMarshaller<LayoutEditorModel> {
  private LayoutEditorModel[] EMPTY_ARRAY = new LayoutEditorModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<PluginType> org_uberfire_ext_plugin_model_PluginType = null;
  public LayoutEditorModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$900529741__1195259493_layoutEditorModel(LayoutEditorModel instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.LayoutEditorModel::layoutEditorModel;
  }-*/;

  private native static void _$900529741__1195259493_layoutEditorModel(LayoutEditorModel instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.model.LayoutEditorModel::layoutEditorModel = value;
  }-*/;

  private native static boolean _$900529741__64711720_emptyLayout(LayoutEditorModel instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.LayoutEditorModel::emptyLayout;
  }-*/;

  private native static void _$900529741__64711720_emptyLayout(LayoutEditorModel instance, boolean value) /*-{
    instance.@org.uberfire.ext.plugin.model.LayoutEditorModel::emptyLayout = value;
  }-*/;

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

  public LayoutEditorModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LayoutEditorModel.class, objId);
    }
    LayoutEditorModel entity = new LayoutEditorModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("layoutEditorModel")) && (!obj.get("layoutEditorModel").isNull())) {
      _$900529741__1195259493_layoutEditorModel(entity, java_lang_String.demarshall(obj.get("layoutEditorModel"), a1));
    }
    if ((obj.containsKey("emptyLayout")) && (!obj.get("emptyLayout").isNull())) {
      _$900529741__64711720_emptyLayout(entity, java_lang_Boolean.demarshall(obj.get("emptyLayout"), a1));
    }
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

  public String marshall(LayoutEditorModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.LayoutEditorModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"layoutEditorModel\":").append(java_lang_String.marshall(a0.getLayoutEditorModel(), a1)).append(",").append("\"emptyLayout\":").append(java_lang_Boolean.marshall(_$900529741__64711720_emptyLayout(a0), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_PluginType == null) {
      org_uberfire_ext_plugin_model_PluginType = Marshalling.getMarshaller(PluginType.class);
    }
  }
}