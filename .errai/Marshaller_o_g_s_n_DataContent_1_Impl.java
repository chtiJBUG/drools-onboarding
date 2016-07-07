package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.navigator.DataContent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_s_n_DataContent_1_Impl implements GeneratedMarshaller<DataContent> {
  private DataContent[] EMPTY_ARRAY = new DataContent[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _872359650__64711720_isDirectory(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::isDirectory;
  }-*/;

  private native static void _872359650__64711720_isDirectory(DataContent instance, boolean value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::isDirectory = value;
  }-*/;

  private native static String _872359650__1195259493_lastMessage(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::lastMessage;
  }-*/;

  private native static void _872359650__1195259493_lastMessage(DataContent instance, String value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::lastMessage = value;
  }-*/;

  private native static String _872359650__1195259493_lastCommiter(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::lastCommiter;
  }-*/;

  private native static void _872359650__1195259493_lastCommiter(DataContent instance, String value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::lastCommiter = value;
  }-*/;

  private native static String _872359650__1195259493_lastCommiterEmail(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::lastCommiterEmail;
  }-*/;

  private native static void _872359650__1195259493_lastCommiterEmail(DataContent instance, String value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::lastCommiterEmail = value;
  }-*/;

  private native static String _872359650__1195259493_age(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::age;
  }-*/;

  private native static void _872359650__1195259493_age(DataContent instance, String value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::age = value;
  }-*/;

  private native static Path _872359650__$2084529122_path(DataContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.DataContent::path;
  }-*/;

  private native static void _872359650__$2084529122_path(DataContent instance, Path value) /*-{
    instance.@org.guvnor.structure.navigator.DataContent::path = value;
  }-*/;

  public DataContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataContent.class, objId);
    }
    DataContent entity = new DataContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("isDirectory")) && (!obj.get("isDirectory").isNull())) {
      _872359650__64711720_isDirectory(entity, java_lang_Boolean.demarshall(obj.get("isDirectory"), a1));
    }
    if ((obj.containsKey("lastMessage")) && (!obj.get("lastMessage").isNull())) {
      _872359650__1195259493_lastMessage(entity, java_lang_String.demarshall(obj.get("lastMessage"), a1));
    }
    if ((obj.containsKey("lastCommiter")) && (!obj.get("lastCommiter").isNull())) {
      _872359650__1195259493_lastCommiter(entity, java_lang_String.demarshall(obj.get("lastCommiter"), a1));
    }
    if ((obj.containsKey("lastCommiterEmail")) && (!obj.get("lastCommiterEmail").isNull())) {
      _872359650__1195259493_lastCommiterEmail(entity, java_lang_String.demarshall(obj.get("lastCommiterEmail"), a1));
    }
    if ((obj.containsKey("age")) && (!obj.get("age").isNull())) {
      _872359650__1195259493_age(entity, java_lang_String.demarshall(obj.get("age"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _872359650__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  public String marshall(DataContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.navigator.DataContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"isDirectory\":").append(java_lang_Boolean.marshall(_872359650__64711720_isDirectory(a0), a1)).append(",").append("\"lastMessage\":").append(java_lang_String.marshall(a0.getLastMessage(), a1)).append(",").append("\"lastCommiter\":").append(java_lang_String.marshall(a0.getLastCommiter(), a1)).append(",").append("\"lastCommiterEmail\":").append(java_lang_String.marshall(a0.getLastCommiterEmail(), a1)).append(",").append("\"age\":").append(java_lang_String.marshall(a0.getAge(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}