package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.ext.plugin.model.Activity;
import org.uberfire.ext.plugin.model.CodeType;
import org.uberfire.ext.plugin.model.Framework;
import org.uberfire.ext.plugin.model.Language;
import org.uberfire.ext.plugin.model.Media;
import org.uberfire.ext.plugin.model.Plugin;
import org.uberfire.ext.plugin.model.PluginContent;
import org.uberfire.ext.plugin.model.PluginSimpleContent;
import org.uberfire.ext.plugin.model.PluginType;

public class Marshaller_o_u_e_p_m_PluginContent_1_Impl implements GeneratedMarshaller<PluginContent> {
  private PluginContent[] EMPTY_ARRAY = new PluginContent[0];
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Language> org_uberfire_ext_plugin_model_Language = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<PluginType> org_uberfire_ext_plugin_model_PluginType = null;
  public PluginContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Set _$75586617__$1383343454_mediaLibrary(PluginContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginContent::mediaLibrary;
  }-*/;

  private native static void _$75586617__$1383343454_mediaLibrary(PluginContent instance, Set<Media> value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginContent::mediaLibrary = value;
  }-*/;

  private native static String _$96605387__1195259493_template(PluginSimpleContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::template;
  }-*/;

  private native static void _$96605387__1195259493_template(PluginSimpleContent instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::template = value;
  }-*/;

  private native static String _$96605387__1195259493_css(PluginSimpleContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::css;
  }-*/;

  private native static void _$96605387__1195259493_css(PluginSimpleContent instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::css = value;
  }-*/;

  private native static Map _$96605387__$1383349348_codeMap(PluginSimpleContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::codeMap;
  }-*/;

  private native static void _$96605387__$1383349348_codeMap(PluginSimpleContent instance, Map<CodeType, String> value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::codeMap = value;
  }-*/;

  private native static Set _$96605387__$1383343454_frameworks(PluginSimpleContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::frameworks;
  }-*/;

  private native static void _$96605387__$1383343454_frameworks(PluginSimpleContent instance, Set<Framework> value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::frameworks = value;
  }-*/;

  private native static Language _$96605387__$133046089_language(PluginSimpleContent instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::language;
  }-*/;

  private native static void _$96605387__$133046089_language(PluginSimpleContent instance, Language value) /*-{
    instance.@org.uberfire.ext.plugin.model.PluginSimpleContent::language = value;
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

  public PluginContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PluginContent.class, objId);
    }
    PluginContent entity = new PluginContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("mediaLibrary")) && (!obj.get("mediaLibrary").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.plugin.model.Media");
      _$75586617__$1383343454_mediaLibrary(entity, java_util_Set.demarshall(obj.get("mediaLibrary"), a1));
    }
    if ((obj.containsKey("template")) && (!obj.get("template").isNull())) {
      _$96605387__1195259493_template(entity, java_lang_String.demarshall(obj.get("template"), a1));
    }
    if ((obj.containsKey("css")) && (!obj.get("css").isNull())) {
      _$96605387__1195259493_css(entity, java_lang_String.demarshall(obj.get("css"), a1));
    }
    if ((obj.containsKey("codeMap")) && (!obj.get("codeMap").isNull())) {
      a1.setAssumedMapKeyType("org.uberfire.ext.plugin.model.CodeType");
      a1.setAssumedMapValueType("java.lang.String");
      _$96605387__$1383349348_codeMap(entity, java_util_Map.demarshall(obj.get("codeMap"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("frameworks")) && (!obj.get("frameworks").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.plugin.model.Framework");
      _$96605387__$1383343454_frameworks(entity, java_util_Set.demarshall(obj.get("frameworks"), a1));
    }
    if ((obj.containsKey("language")) && (!obj.get("language").isNull())) {
      _$96605387__$133046089_language(entity, obj.get("language").isObject() != null ? Enum.valueOf(Language.class, obj.get("language").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("language").isString() != null ? Enum.valueOf(Language.class, obj.get("language").isString().stringValue()) : null);
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

  public String marshall(PluginContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"mediaLibrary\":").append(java_util_Set.marshall(a0.getMediaLibrary(), a1)).append(",").append("\"template\":").append(java_lang_String.marshall(a0.getTemplate(), a1)).append(",").append("\"css\":").append(java_lang_String.marshall(a0.getCss(), a1)).append(",").append("\"codeMap\":").append(java_util_Map.marshall(a0.getCodeMap(), a1)).append(",").append("\"frameworks\":").append(java_util_Set.marshall(_$96605387__$1383343454_frameworks(a0), a1)).append(",").append("\"language\":").append(a0.getLanguage() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.Language\",\"^EnumStringValue\":\"").append(a0.getLanguage().name()).append("\"}") : "null").append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.PluginType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_Language == null) {
      org_uberfire_ext_plugin_model_Language = Marshalling.getMarshaller(Language.class);
    }
    if (org_uberfire_ext_plugin_model_PluginType == null) {
      org_uberfire_ext_plugin_model_PluginType = Marshalling.getMarshaller(PluginType.class);
    }
  }
}