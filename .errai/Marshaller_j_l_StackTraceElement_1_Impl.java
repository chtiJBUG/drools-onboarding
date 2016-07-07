package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_j_l_StackTraceElement_1_Impl implements GeneratedMarshaller<StackTraceElement> {
  private StackTraceElement[] EMPTY_ARRAY = new StackTraceElement[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public StackTraceElement[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public StackTraceElement demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(StackTraceElement.class, objId);
    }
    final String c2 = java_lang_String.demarshall(obj.get("fileName"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("methodName"), a1);
    final Integer c3 = java_lang_Integer.demarshall(obj.get("lineNumber"), a1);
    final String c0 = java_lang_String.demarshall(obj.get("declaringClass"), a1);
    StackTraceElement entity = new StackTraceElement(c0, c1, c2, c3);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(StackTraceElement a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"java.lang.StackTraceElement\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fileName\":").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"methodName\":").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"lineNumber\":").append(java_lang_Integer.marshall(a0.getLineNumber(), a1)).append(",").append("\"declaringClass\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}