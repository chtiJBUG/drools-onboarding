package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.apps.api.DirectoryBreadCrumb;

public class Marshaller_o_u_e_a_a_DirectoryBreadCrumb_1_Impl implements GeneratedMarshaller<DirectoryBreadCrumb> {
  private DirectoryBreadCrumb[] EMPTY_ARRAY = new DirectoryBreadCrumb[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DirectoryBreadCrumb[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public native static DirectoryBreadCrumb _$1187665951__String_String(String a0, String a1) /*-{
    return @org.uberfire.ext.apps.api.DirectoryBreadCrumb::new(Ljava/lang/String;Ljava/lang/String;)(a0, a1);
  }-*/;

  public DirectoryBreadCrumb demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DirectoryBreadCrumb.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("uri"), a1);
    DirectoryBreadCrumb entity = _$1187665951__String_String(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(DirectoryBreadCrumb a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.apps.api.DirectoryBreadCrumb\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"uri\":").append(java_lang_String.marshall(a0.getUri(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}