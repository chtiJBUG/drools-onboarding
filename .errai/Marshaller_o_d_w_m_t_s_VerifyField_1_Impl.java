package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.VerifyField;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_VerifyField_1_Impl implements GeneratedMarshaller<VerifyField> {
  private VerifyField[] EMPTY_ARRAY = new VerifyField[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public VerifyField[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public VerifyField demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(VerifyField.class, objId);
    }
    VerifyField entity = new VerifyField();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("expected")) && (!obj.get("expected").isNull())) {
      entity.setExpected(java_lang_String.demarshall(obj.get("expected"), a1));
    }
    if ((obj.containsKey("actualResult")) && (!obj.get("actualResult").isNull())) {
      entity.setActualResult(java_lang_String.demarshall(obj.get("actualResult"), a1));
    }
    if ((obj.containsKey("successResult")) && (!obj.get("successResult").isNull())) {
      entity.setSuccessResult(java_lang_Boolean.demarshall(obj.get("successResult"), a1));
    }
    if ((obj.containsKey("explanation")) && (!obj.get("explanation").isNull())) {
      entity.setExplanation(java_lang_String.demarshall(obj.get("explanation"), a1));
    }
    if ((obj.containsKey("operator")) && (!obj.get("operator").isNull())) {
      entity.setOperator(java_lang_String.demarshall(obj.get("operator"), a1));
    }
    if ((obj.containsKey("nature")) && (!obj.get("nature").isNull())) {
      entity.setNature(java_lang_Long.demarshall(obj.get("nature"), a1));
    }
    return entity;
  }

  public String marshall(VerifyField a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.VerifyField\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"expected\":").append(java_lang_String.marshall(a0.getExpected(), a1)).append(",").append("\"actualResult\":").append(java_lang_String.marshall(a0.getActualResult(), a1)).append(",").append("\"successResult\":").append(java_lang_Boolean.marshall(a0.getSuccessResult(), a1)).append(",").append("\"explanation\":").append(java_lang_String.marshall(a0.getExplanation(), a1)).append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append(",").append("\"nature\":").append(java_lang_Long.marshall(a0.getNature(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}