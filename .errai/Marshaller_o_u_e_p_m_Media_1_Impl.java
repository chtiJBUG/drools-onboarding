package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.ext.plugin.model.Media;

public class Marshaller_o_u_e_p_m_Media_1_Impl implements GeneratedMarshaller<Media> {
  private Media[] EMPTY_ARRAY = new Media[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public Media[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _84358885__1195259493_externalURI(Media instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.Media::externalURI;
  }-*/;

  private native static void _84358885__1195259493_externalURI(Media instance, String value) /*-{
    instance.@org.uberfire.ext.plugin.model.Media::externalURI = value;
  }-*/;

  private native static Path _84358885__$2084529122_path(Media instance) /*-{
    return instance.@org.uberfire.ext.plugin.model.Media::path;
  }-*/;

  private native static void _84358885__$2084529122_path(Media instance, Path value) /*-{
    instance.@org.uberfire.ext.plugin.model.Media::path = value;
  }-*/;

  public Media demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Media.class, objId);
    }
    Media entity = new Media();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("externalURI")) && (!obj.get("externalURI").isNull())) {
      _84358885__1195259493_externalURI(entity, java_lang_String.demarshall(obj.get("externalURI"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _84358885__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  public String marshall(Media a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.Media\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"externalURI\":").append(java_lang_String.marshall(a0.getExternalURI(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}