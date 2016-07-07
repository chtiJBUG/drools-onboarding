package org.jboss.errai.marshalling.client.api;

import java.util.HashMap;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.PathFactory.PathImpl;

public class Marshaller_o_u_b_v_PathFactory_erraiD_PathImpl_Impl implements GeneratedMarshaller<PathImpl> {
  private PathImpl[] EMPTY_ARRAY = new PathImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<HashMap> java_util_HashMap = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public PathImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1656217245__1195259493_uri(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::uri;
  }-*/;

  private native static void _1656217245__1195259493_uri(PathImpl instance, String value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::uri = value;
  }-*/;

  private native static String _1656217245__1195259493_fileName(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fileName;
  }-*/;

  private native static void _1656217245__1195259493_fileName(PathImpl instance, String value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::fileName = value;
  }-*/;

  private native static HashMap _1656217245__$1402722386_attributes(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::attributes;
  }-*/;

  private native static void _1656217245__$1402722386_attributes(PathImpl instance, HashMap value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::attributes = value;
  }-*/;

  private native static boolean _1656217245__64711720_hasVersionSupport(PathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::hasVersionSupport;
  }-*/;

  private native static void _1656217245__64711720_hasVersionSupport(PathImpl instance, boolean value) /*-{
    instance.@org.uberfire.backend.vfs.PathFactory.PathImpl::hasVersionSupport = value;
  }-*/;

  public PathImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PathImpl.class, objId);
    }
    PathImpl entity = new PathImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("uri")) && (!obj.get("uri").isNull())) {
      _1656217245__1195259493_uri(entity, java_lang_String.demarshall(obj.get("uri"), a1));
    }
    if ((obj.containsKey("fileName")) && (!obj.get("fileName").isNull())) {
      _1656217245__1195259493_fileName(entity, java_lang_String.demarshall(obj.get("fileName"), a1));
    }
    if ((obj.containsKey("attributes")) && (!obj.get("attributes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _1656217245__$1402722386_attributes(entity, java_util_HashMap.demarshall(obj.get("attributes"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("hasVersionSupport")) && (!obj.get("hasVersionSupport").isNull())) {
      _1656217245__64711720_hasVersionSupport(entity, java_lang_Boolean.demarshall(obj.get("hasVersionSupport"), a1));
    }
    return entity;
  }

  public String marshall(PathImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.PathFactory$PathImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"uri\":").append(java_lang_String.marshall(_1656217245__1195259493_uri(a0), a1)).append(",").append("\"fileName\":").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"attributes\":").append(java_util_HashMap.marshall(_1656217245__$1402722386_attributes(a0), a1)).append(",").append("\"hasVersionSupport\":").append(java_lang_Boolean.marshall(_1656217245__64711720_hasVersionSupport(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
  }
}