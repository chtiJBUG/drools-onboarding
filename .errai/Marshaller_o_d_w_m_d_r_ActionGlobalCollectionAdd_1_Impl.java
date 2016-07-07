package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ActionGlobalCollectionAdd;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ActionGlobalCollectionAdd_1_Impl implements GeneratedMarshaller<ActionGlobalCollectionAdd> {
  private ActionGlobalCollectionAdd[] EMPTY_ARRAY = new ActionGlobalCollectionAdd[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ActionGlobalCollectionAdd[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionGlobalCollectionAdd demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionGlobalCollectionAdd.class, objId);
    }
    ActionGlobalCollectionAdd entity = new ActionGlobalCollectionAdd();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("globalName")) && (!obj.get("globalName").isNull())) {
      entity.setGlobalName(java_lang_String.demarshall(obj.get("globalName"), a1));
    }
    if ((obj.containsKey("factName")) && (!obj.get("factName").isNull())) {
      entity.setFactName(java_lang_String.demarshall(obj.get("factName"), a1));
    }
    return entity;
  }

  public String marshall(ActionGlobalCollectionAdd a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionGlobalCollectionAdd\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"globalName\":").append(java_lang_String.marshall(a0.getGlobalName(), a1)).append(",").append("\"factName\":").append(java_lang_String.marshall(a0.getFactName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}