package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.UserTaskSummary;

public class Marshaller_o_j_c_n_p_m_UserTaskSummary_1_Impl implements GeneratedMarshaller<UserTaskSummary> {
  private UserTaskSummary[] EMPTY_ARRAY = new UserTaskSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public UserTaskSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UserTaskSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserTaskSummary.class, objId);
    }
    UserTaskSummary entity = new UserTaskSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("owner")) && (!obj.get("owner").isNull())) {
      entity.setOwner(java_lang_String.demarshall(obj.get("owner"), a1));
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      entity.setStatus(java_lang_String.demarshall(obj.get("status"), a1));
    }
    return entity;
  }

  public String marshall(UserTaskSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.UserTaskSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"owner\":").append(java_lang_String.marshall(a0.getOwner(), a1)).append(",").append("\"status\":").append(java_lang_String.marshall(a0.getStatus(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}