package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.User;

public class Marshaller_o_j_c_n_h_m_User_1_Impl implements GeneratedMarshaller<User> {
  private User[] EMPTY_ARRAY = new User[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public User[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public User demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(User.class, objId);
    }
    User entity = new User();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("typesRole")) && (!obj.get("typesRole").isNull())) {
      a1.setAssumedElementType("org.jbpm.console.ng.ht.model.TypeRole");
      entity.setTypesRole(java_util_List.demarshall(obj.get("typesRole"), a1));
    }
    if ((obj.containsKey("groups")) && (!obj.get("groups").isNull())) {
      a1.setAssumedElementType("org.jbpm.console.ng.ht.model.Group");
      entity.setGroups(java_util_List.demarshall(obj.get("groups"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(User a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.User\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"typesRole\":").append(java_util_List.marshall(a0.getTypesRole(), a1)).append(",").append("\"groups\":").append(java_util_List.marshall(a0.getGroups(), a1)).append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}