package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.Group;

public class Marshaller_o_j_c_n_h_m_Group_1_Impl implements GeneratedMarshaller<Group> {
  private Group[] EMPTY_ARRAY = new Group[0];
  private Marshaller<Group> org_jbpm_console_ng_ht_model_Group = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Group[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Group demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Group.class, objId);
    }
    Group entity = new Group();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      entity.setParent(org_jbpm_console_ng_ht_model_Group.demarshall(obj.get("parent"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(Group a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.Group\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"parent\":").append(org_jbpm_console_ng_ht_model_Group.marshall(a0.getParent(), a1)).append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_jbpm_console_ng_ht_model_Group == null) {
      org_jbpm_console_ng_ht_model_Group = this;
    }
  }
}