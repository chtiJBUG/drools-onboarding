package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ActionRetractFact;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ActionRetractFact_1_Impl implements GeneratedMarshaller<ActionRetractFact> {
  private ActionRetractFact[] EMPTY_ARRAY = new ActionRetractFact[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ActionRetractFact[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionRetractFact demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionRetractFact.class, objId);
    }
    ActionRetractFact entity = new ActionRetractFact();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("variableName")) && (!obj.get("variableName").isNull())) {
      entity.setVariableName(java_lang_String.demarshall(obj.get("variableName"), a1));
    }
    return entity;
  }

  public String marshall(ActionRetractFact a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionRetractFact\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"variableName\":").append(java_lang_String.marshall(a0.getVariableName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}