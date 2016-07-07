package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.bd.model.KieSessionSummary;

public class Marshaller_o_j_c_n_b_m_KieSessionSummary_1_Impl implements GeneratedMarshaller<KieSessionSummary> {
  private KieSessionSummary[] EMPTY_ARRAY = new KieSessionSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public KieSessionSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public KieSessionSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KieSessionSummary.class, objId);
    }
    KieSessionSummary entity = new KieSessionSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sessionId")) && (!obj.get("sessionId").isNull())) {
      entity.setSessionId(java_lang_Long.demarshall(obj.get("sessionId"), a1));
    }
    return entity;
  }

  public String marshall(KieSessionSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.KieSessionSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sessionId\":").append(java_lang_Long.marshall(a0.getSessionId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}