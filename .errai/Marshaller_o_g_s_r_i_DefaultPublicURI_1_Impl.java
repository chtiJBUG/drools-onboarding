package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.impl.DefaultPublicURI;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_s_r_i_DefaultPublicURI_1_Impl implements GeneratedMarshaller<DefaultPublicURI> {
  private DefaultPublicURI[] EMPTY_ARRAY = new DefaultPublicURI[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DefaultPublicURI[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DefaultPublicURI demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DefaultPublicURI.class, objId);
    }
    DefaultPublicURI entity = new DefaultPublicURI();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("protocol")) && (!obj.get("protocol").isNull())) {
      entity.setProtocol(java_lang_String.demarshall(obj.get("protocol"), a1));
    }
    if ((obj.containsKey("uri")) && (!obj.get("uri").isNull())) {
      entity.setURI(java_lang_String.demarshall(obj.get("uri"), a1));
    }
    return entity;
  }

  public String marshall(DefaultPublicURI a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.impl.DefaultPublicURI\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"protocol\":").append(java_lang_String.marshall(a0.getProtocol(), a1)).append(",").append("\"uri\":").append(java_lang_String.marshall(a0.getURI(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}