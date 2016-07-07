package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.apps.api.Directory;

public class Marshaller_o_u_e_a_a_Directory_1_Impl implements GeneratedMarshaller<Directory> {
  private Directory[] EMPTY_ARRAY = new Directory[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Directory> org_uberfire_ext_apps_api_Directory = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public Directory[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1143658146__1195259493_name(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::name;
  }-*/;

  private native static void _$1143658146__1195259493_name(Directory instance, String value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::name = value;
  }-*/;

  private native static Map _$1143658146__$1383349348_tagMap(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::tagMap;
  }-*/;

  private native static void _$1143658146__$1383349348_tagMap(Directory instance, Map<String, List<String>> value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::tagMap = value;
  }-*/;

  private native static String _$1143658146__1195259493_fullPath(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::fullPath;
  }-*/;

  private native static void _$1143658146__1195259493_fullPath(Directory instance, String value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::fullPath = value;
  }-*/;

  private native static Directory _$1143658146__$1143658146_parent(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::parent;
  }-*/;

  private native static void _$1143658146__$1143658146_parent(Directory instance, Directory value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::parent = value;
  }-*/;

  private native static String _$1143658146__1195259493_URI(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::URI;
  }-*/;

  private native static void _$1143658146__1195259493_URI(Directory instance, String value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::URI = value;
  }-*/;

  private native static List _$1143658146__65821278_childsDirectories(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::childsDirectories;
  }-*/;

  private native static void _$1143658146__65821278_childsDirectories(Directory instance, List<Directory> value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::childsDirectories = value;
  }-*/;

  private native static List _$1143658146__65821278_childComponents(Directory instance) /*-{
    return instance.@org.uberfire.ext.apps.api.Directory::childComponents;
  }-*/;

  private native static void _$1143658146__65821278_childComponents(Directory instance, List<String> value) /*-{
    instance.@org.uberfire.ext.apps.api.Directory::childComponents = value;
  }-*/;

  public Directory demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Directory.class, objId);
    }
    Directory entity = new Directory();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$1143658146__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("tagMap")) && (!obj.get("tagMap").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.List");
      _$1143658146__$1383349348_tagMap(entity, java_util_Map.demarshall(obj.get("tagMap"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("fullPath")) && (!obj.get("fullPath").isNull())) {
      _$1143658146__1195259493_fullPath(entity, java_lang_String.demarshall(obj.get("fullPath"), a1));
    }
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      _$1143658146__$1143658146_parent(entity, org_uberfire_ext_apps_api_Directory.demarshall(obj.get("parent"), a1));
    }
    if ((obj.containsKey("URI")) && (!obj.get("URI").isNull())) {
      _$1143658146__1195259493_URI(entity, java_lang_String.demarshall(obj.get("URI"), a1));
    }
    if ((obj.containsKey("childsDirectories")) && (!obj.get("childsDirectories").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.apps.api.Directory");
      _$1143658146__65821278_childsDirectories(entity, java_util_List.demarshall(obj.get("childsDirectories"), a1));
    }
    if ((obj.containsKey("childComponents")) && (!obj.get("childComponents").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1143658146__65821278_childComponents(entity, java_util_List.demarshall(obj.get("childComponents"), a1));
    }
    return entity;
  }

  public String marshall(Directory a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.apps.api.Directory\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"tagMap\":").append(java_util_Map.marshall(a0.getTagMap(), a1)).append(",").append("\"fullPath\":").append(java_lang_String.marshall(a0.getFullPath(), a1)).append(",").append("\"parent\":").append(org_uberfire_ext_apps_api_Directory.marshall(a0.getParent(), a1)).append(",").append("\"URI\":").append(java_lang_String.marshall(a0.getURI(), a1)).append(",").append("\"childsDirectories\":").append(java_util_List.marshall(a0.getChildsDirectories(), a1)).append(",").append("\"childComponents\":").append(java_util_List.marshall(a0.getChildComponents(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_apps_api_Directory == null) {
      org_uberfire_ext_apps_api_Directory = this;
    }
  }
}