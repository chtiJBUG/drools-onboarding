package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.rule.CEPWindow;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_CEPWindow_1_Impl implements GeneratedMarshaller<CEPWindow> {
  private CEPWindow[] EMPTY_ARRAY = new CEPWindow[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public CEPWindow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CEPWindow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CEPWindow.class, objId);
    }
    CEPWindow entity = new CEPWindow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("operator")) && (!obj.get("operator").isNull())) {
      entity.setOperator(java_lang_String.demarshall(obj.get("operator"), a1));
    }
    if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setParameters(java_util_Map.demarshall(obj.get("parameters"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(CEPWindow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.CEPWindow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(a0.getParameters(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}