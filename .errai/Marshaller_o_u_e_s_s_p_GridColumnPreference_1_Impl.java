package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.GridColumnPreference;

public class Marshaller_o_u_e_s_s_p_GridColumnPreference_1_Impl implements GeneratedMarshaller<GridColumnPreference> {
  private GridColumnPreference[] EMPTY_ARRAY = new GridColumnPreference[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public GridColumnPreference[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GridColumnPreference demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GridColumnPreference.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    final Integer c1 = java_lang_Integer.demarshall(obj.get("position"), a1);
    final String c2 = java_lang_String.demarshall(obj.get("width"), a1);
    GridColumnPreference entity = new GridColumnPreference(c0, c1, c2);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(GridColumnPreference a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.GridColumnPreference\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"position\":").append(java_lang_Integer.marshall(a0.getPosition(), a1)).append(",").append("\"width\":").append(java_lang_String.marshall(a0.getWidth(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}