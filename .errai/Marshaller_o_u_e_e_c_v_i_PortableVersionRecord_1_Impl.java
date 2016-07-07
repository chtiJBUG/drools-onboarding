package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord;

public class Marshaller_o_u_e_e_c_v_i_PortableVersionRecord_1_Impl implements GeneratedMarshaller<PortableVersionRecord> {
  private PortableVersionRecord[] EMPTY_ARRAY = new PortableVersionRecord[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public PortableVersionRecord[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$59696772__1195259493_id(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::id;
  }-*/;

  private native static void _$59696772__1195259493_id(PortableVersionRecord instance, String value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::id = value;
  }-*/;

  private native static String _$59696772__1195259493_author(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::author;
  }-*/;

  private native static void _$59696772__1195259493_author(PortableVersionRecord instance, String value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::author = value;
  }-*/;

  private native static String _$59696772__1195259493_email(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::email;
  }-*/;

  private native static void _$59696772__1195259493_email(PortableVersionRecord instance, String value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::email = value;
  }-*/;

  private native static String _$59696772__1195259493_comment(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::comment;
  }-*/;

  private native static void _$59696772__1195259493_comment(PortableVersionRecord instance, String value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::comment = value;
  }-*/;

  private native static Date _$59696772__65575278_date(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::date;
  }-*/;

  private native static void _$59696772__65575278_date(PortableVersionRecord instance, Date value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::date = value;
  }-*/;

  private native static String _$59696772__1195259493_uri(PortableVersionRecord instance) /*-{
    return instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::uri;
  }-*/;

  private native static void _$59696772__1195259493_uri(PortableVersionRecord instance, String value) /*-{
    instance.@org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord::uri = value;
  }-*/;

  public PortableVersionRecord demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableVersionRecord.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("id"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("author"), a1);
    final String c2 = java_lang_String.demarshall(obj.get("email"), a1);
    final String c3 = java_lang_String.demarshall(obj.get("comment"), a1);
    final Date c4 = java_util_Date.demarshall(obj.get("date"), a1);
    final String c5 = java_lang_String.demarshall(obj.get("uri"), a1);
    PortableVersionRecord entity = new PortableVersionRecord(c0, c1, c2, c3, c4, c5);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      _$59696772__1195259493_id(entity, java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("author")) && (!obj.get("author").isNull())) {
      _$59696772__1195259493_author(entity, java_lang_String.demarshall(obj.get("author"), a1));
    }
    if ((obj.containsKey("email")) && (!obj.get("email").isNull())) {
      _$59696772__1195259493_email(entity, java_lang_String.demarshall(obj.get("email"), a1));
    }
    if ((obj.containsKey("comment")) && (!obj.get("comment").isNull())) {
      _$59696772__1195259493_comment(entity, java_lang_String.demarshall(obj.get("comment"), a1));
    }
    if ((obj.containsKey("date")) && (!obj.get("date").isNull())) {
      _$59696772__65575278_date(entity, java_util_Date.demarshall(obj.get("date"), a1));
    }
    if ((obj.containsKey("uri")) && (!obj.get("uri").isNull())) {
      _$59696772__1195259493_uri(entity, java_lang_String.demarshall(obj.get("uri"), a1));
    }
    return entity;
  }

  public String marshall(PortableVersionRecord a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.editor.commons.version.impl.PortableVersionRecord\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(_$59696772__1195259493_id(a0), a1)).append(",").append("\"author\":").append(java_lang_String.marshall(_$59696772__1195259493_author(a0), a1)).append(",").append("\"email\":").append(java_lang_String.marshall(_$59696772__1195259493_email(a0), a1)).append(",").append("\"comment\":").append(java_lang_String.marshall(_$59696772__1195259493_comment(a0), a1)).append(",").append("\"date\":").append(java_util_Date.marshall(_$59696772__65575278_date(a0), a1)).append(",").append("\"uri\":").append(java_lang_String.marshall(_$59696772__1195259493_uri(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}