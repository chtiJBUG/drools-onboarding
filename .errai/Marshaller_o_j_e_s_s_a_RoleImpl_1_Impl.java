package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.security.shared.api.RoleImpl;

public class Marshaller_o_j_e_s_s_a_RoleImpl_1_Impl implements GeneratedMarshaller<RoleImpl> {
  private RoleImpl[] EMPTY_ARRAY = new RoleImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public RoleImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RoleImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RoleImpl.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    RoleImpl entity = new RoleImpl(c0);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(RoleImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jboss.errai.security.shared.api.RoleImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}