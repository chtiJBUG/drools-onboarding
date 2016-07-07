package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.CommentSummary;

public class Marshaller_o_j_c_n_h_m_CommentSummary_1_Impl implements GeneratedMarshaller<CommentSummary> {
  private CommentSummary[] EMPTY_ARRAY = new CommentSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public CommentSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CommentSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CommentSummary.class, objId);
    }
    CommentSummary entity = new CommentSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("text")) && (!obj.get("text").isNull())) {
      entity.setText(java_lang_String.demarshall(obj.get("text"), a1));
    }
    if ((obj.containsKey("addedBy")) && (!obj.get("addedBy").isNull())) {
      entity.setAddedBy(java_lang_String.demarshall(obj.get("addedBy"), a1));
    }
    if ((obj.containsKey("addedAt")) && (!obj.get("addedAt").isNull())) {
      entity.setAddedAt(java_util_Date.demarshall(obj.get("addedAt"), a1));
    }
    return entity;
  }

  public String marshall(CommentSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.CommentSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"text\":").append(java_lang_String.marshall(a0.getText(), a1)).append(",").append("\"addedBy\":").append(java_lang_String.marshall(a0.getAddedBy(), a1)).append(",").append("\"addedAt\":").append(java_util_Date.marshall(a0.getAddedAt(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}