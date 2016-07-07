package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.uberfire.java.nio.file.FileSystemException;
import org.uberfire.java.nio.file.NotDirectoryException;

public class Marshaller_o_u_j_n_f_NotDirectoryException_1_Impl implements GeneratedMarshaller<NotDirectoryException> {
  private NotDirectoryException[] EMPTY_ARRAY = new NotDirectoryException[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Throwable> java_lang_Throwable = null;
  private Marshaller<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1 = null;
  abstract class Marshaller_for_arrayOf_java_lang_StackTraceElement_D1 implements GeneratedMarshaller { }
  public NotDirectoryException[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$538084060__1195259493_file(FileSystemException instance) /*-{
    return instance.@org.uberfire.java.nio.file.FileSystemException::file;
  }-*/;

  private native static void _$538084060__1195259493_file(FileSystemException instance, String value) /*-{
    instance.@org.uberfire.java.nio.file.FileSystemException::file = value;
  }-*/;

  private native static String _$538084060__1195259493_other(FileSystemException instance) /*-{
    return instance.@org.uberfire.java.nio.file.FileSystemException::other;
  }-*/;

  private native static void _$538084060__1195259493_other(FileSystemException instance, String value) /*-{
    instance.@org.uberfire.java.nio.file.FileSystemException::other = value;
  }-*/;

  private native static String _$538084060__1195259493_reason(FileSystemException instance) /*-{
    return instance.@org.uberfire.java.nio.file.FileSystemException::reason;
  }-*/;

  private native static void _$538084060__1195259493_reason(FileSystemException instance, String value) /*-{
    instance.@org.uberfire.java.nio.file.FileSystemException::reason = value;
  }-*/;

  private native static String _1630335596__1195259493_detailMessage(Throwable instance) /*-{
    return instance.@java.lang.Throwable::detailMessage;
  }-*/;

  private native static void _1630335596__1195259493_detailMessage(Throwable instance, String value) /*-{
    instance.@java.lang.Throwable::detailMessage = value;
  }-*/;

  public NotDirectoryException demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NotDirectoryException.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("message"), a1);
    NotDirectoryException entity = new NotDirectoryException(c0);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("file")) && (!obj.get("file").isNull())) {
      _$538084060__1195259493_file(entity, java_lang_String.demarshall(obj.get("file"), a1));
    }
    if ((obj.containsKey("other")) && (!obj.get("other").isNull())) {
      _$538084060__1195259493_other(entity, java_lang_String.demarshall(obj.get("other"), a1));
    }
    if ((obj.containsKey("reason")) && (!obj.get("reason").isNull())) {
      _$538084060__1195259493_reason(entity, java_lang_String.demarshall(obj.get("reason"), a1));
    }
    if ((obj.containsKey("detailMessage")) && (!obj.get("detailMessage").isNull())) {
      _1630335596__1195259493_detailMessage(entity, java_lang_String.demarshall(obj.get("detailMessage"), a1));
    }
    if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
      entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
    }
    if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
      entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
    }
    return entity;
  }

  public String marshall(NotDirectoryException a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.java.nio.file.NotDirectoryException\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"file\":").append(java_lang_String.marshall(a0.getFile(), a1)).append(",").append("\"other\":").append(java_lang_String.marshall(_$538084060__1195259493_other(a0), a1)).append(",").append("\"reason\":").append(java_lang_String.marshall(a0.getReason(), a1)).append(",").append("\"detailMessage\":").append(java_lang_String.marshall(_1630335596__1195259493_detailMessage(a0), a1)).append(",").append("\"stackTrace\":").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\":").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_lang_Throwable == null) {
      java_lang_Throwable = Marshalling.getMarshaller(Throwable.class);
    }
    if (arrayOf_java_lang_StackTraceElement_D1 == null) {
      arrayOf_java_lang_StackTraceElement_D1 = Marshalling.getMarshaller(StackTraceElement[].class, new DeferredMarshallerCreationCallback<StackTraceElement[]>() {
        public Marshaller<StackTraceElement[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_StackTraceElement_D1.class), StackTraceElement[].class);
        }
      });
    }
  }
}