package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.FreeFormLine;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_FreeFormLine_1_Impl implements GeneratedMarshaller<FreeFormLine> {
  private FreeFormLine[] EMPTY_ARRAY = new FreeFormLine[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public FreeFormLine[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FreeFormLine demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FreeFormLine.class, objId);
    }
    FreeFormLine entity = new FreeFormLine();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("text")) && (!obj.get("text").isNull())) {
      entity.setText(java_lang_String.demarshall(obj.get("text"), a1));
    }
    return entity;
  }

  public String marshall(FreeFormLine a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.FreeFormLine\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"text\":").append(java_lang_String.marshall(a0.getText(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}