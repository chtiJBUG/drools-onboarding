package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.security.shared.api.identity.UserImpl;

public class Marshaller_o_j_e_s_s_a_i_UserImpl_1_Impl implements GeneratedMarshaller<UserImpl> {
  private UserImpl[] EMPTY_ARRAY = new UserImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public UserImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1728909782__1195259493_name(UserImpl instance) /*-{
    return instance.@org.jboss.errai.security.shared.api.identity.UserImpl::name;
  }-*/;

  private native static void _$1728909782__1195259493_name(UserImpl instance, String value) /*-{
    instance.@org.jboss.errai.security.shared.api.identity.UserImpl::name = value;
  }-*/;

  public UserImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserImpl.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    final Collection c1 = (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("roles"), a1);
    final Collection c2 = (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("groups"), a1);
    a1.setAssumedMapKeyType("java.lang.String");
    a1.setAssumedMapValueType("java.lang.String");
    final Map c3 = java_util_Map.demarshall(obj.get("properties"), a1);
    a1.resetAssumedTypes();
    UserImpl entity = new UserImpl(c0, c1, c2, c3);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$1728909782__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(UserImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jboss.errai.security.shared.api.identity.UserImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(_$1728909782__1195259493_name(a0), a1)).append(",").append("\"roles\":").append(java_util_Set.marshall(a0.getRoles(), a1)).append(",").append("\"groups\":").append(java_util_Set.marshall(a0.getGroups(), a1)).append(",").append("\"properties\":").append(java_util_Map.marshall(a0.getProperties(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}