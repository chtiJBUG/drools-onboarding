package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.bd.model.RuleNotificationSummary;

public class Marshaller_o_j_c_n_b_m_RuleNotificationSummary_1_Impl implements GeneratedMarshaller<RuleNotificationSummary> {
  private RuleNotificationSummary[] EMPTY_ARRAY = new RuleNotificationSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public RuleNotificationSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuleNotificationSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleNotificationSummary.class, objId);
    }
    RuleNotificationSummary entity = new RuleNotificationSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("notification")) && (!obj.get("notification").isNull())) {
      entity.setNotification(java_lang_String.demarshall(obj.get("notification"), a1));
    }
    if ((obj.containsKey("sessionId")) && (!obj.get("sessionId").isNull())) {
      entity.setSessionId(java_lang_Integer.demarshall(obj.get("sessionId"), a1));
    }
    if ((obj.containsKey("dataTimeStamp")) && (!obj.get("dataTimeStamp").isNull())) {
      entity.setDataTimeStamp(java_util_Date.demarshall(obj.get("dataTimeStamp"), a1));
    }
    return entity;
  }

  public String marshall(RuleNotificationSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.RuleNotificationSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"notification\":").append(java_lang_String.marshall(a0.getNotification(), a1)).append(",").append("\"sessionId\":").append(java_lang_Integer.marshall(a0.getSessionId(), a1)).append(",").append("\"dataTimeStamp\":").append(java_util_Date.marshall(a0.getDataTimeStamp(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}