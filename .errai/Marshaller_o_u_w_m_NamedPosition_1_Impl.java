package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.model.NamedPosition;

public class Marshaller_o_u_w_m_NamedPosition_1_Impl implements GeneratedMarshaller<NamedPosition> {
  private NamedPosition[] EMPTY_ARRAY = new NamedPosition[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public NamedPosition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public NamedPosition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NamedPosition.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("fieldName"), a1);
    NamedPosition entity = new NamedPosition(c0);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(NamedPosition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.model.NamedPosition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}