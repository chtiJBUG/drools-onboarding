package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.testscenarios.shared.VerifyFact;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_VerifyFact_1_Impl implements GeneratedMarshaller<VerifyFact> {
  private VerifyFact[] EMPTY_ARRAY = new VerifyFact[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public VerifyFact[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public VerifyFact demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(VerifyFact.class, objId);
    }
    VerifyFact entity = new VerifyFact();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldValues")) && (!obj.get("fieldValues").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.VerifyField");
      entity.setFieldValues(java_util_List.demarshall(obj.get("fieldValues"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      entity.setDescription(java_lang_String.demarshall(obj.get("description"), a1));
    }
    entity.anonymous = java_lang_Boolean.demarshall(obj.get("anonymous"), a1);
    return entity;
  }

  public String marshall(VerifyFact a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.VerifyFact\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldValues\":").append(java_util_List.marshall(a0.getFieldValues(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"anonymous\":").append(java_lang_Boolean.marshall(a0.anonymous, a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}