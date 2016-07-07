package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.VerifyRuleFired;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_VerifyRuleFired_1_Impl implements GeneratedMarshaller<VerifyRuleFired> {
  private VerifyRuleFired[] EMPTY_ARRAY = new VerifyRuleFired[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public VerifyRuleFired[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public VerifyRuleFired demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(VerifyRuleFired.class, objId);
    }
    VerifyRuleFired entity = new VerifyRuleFired();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("ruleName")) && (!obj.get("ruleName").isNull())) {
      entity.setRuleName(java_lang_String.demarshall(obj.get("ruleName"), a1));
    }
    if ((obj.containsKey("expectedCount")) && (!obj.get("expectedCount").isNull())) {
      entity.setExpectedCount(java_lang_Integer.demarshall(obj.get("expectedCount"), a1));
    }
    if ((obj.containsKey("explanation")) && (!obj.get("explanation").isNull())) {
      entity.setExplanation(java_lang_String.demarshall(obj.get("explanation"), a1));
    }
    if ((obj.containsKey("expectedFire")) && (!obj.get("expectedFire").isNull())) {
      entity.setExpectedFire(java_lang_Boolean.demarshall(obj.get("expectedFire"), a1));
    }
    if ((obj.containsKey("successResult")) && (!obj.get("successResult").isNull())) {
      entity.setSuccessResult(java_lang_Boolean.demarshall(obj.get("successResult"), a1));
    }
    if ((obj.containsKey("actualResult")) && (!obj.get("actualResult").isNull())) {
      entity.setActualResult(java_lang_Integer.demarshall(obj.get("actualResult"), a1));
    }
    return entity;
  }

  public String marshall(VerifyRuleFired a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.VerifyRuleFired\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"ruleName\":").append(java_lang_String.marshall(a0.getRuleName(), a1)).append(",").append("\"expectedCount\":").append(java_lang_Integer.marshall(a0.getExpectedCount(), a1)).append(",").append("\"explanation\":").append(java_lang_String.marshall(a0.getExplanation(), a1)).append(",").append("\"expectedFire\":").append(java_lang_Boolean.marshall(a0.getExpectedFire(), a1)).append(",").append("\"successResult\":").append(java_lang_Boolean.marshall(a0.getSuccessResult(), a1)).append(",").append("\"actualResult\":").append(java_lang_Integer.marshall(a0.getActualResult(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}