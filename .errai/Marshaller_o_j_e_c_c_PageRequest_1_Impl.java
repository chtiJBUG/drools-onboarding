package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.common.client.PageRequest;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_j_e_c_c_PageRequest_1_Impl implements GeneratedMarshaller<PageRequest> {
  private PageRequest[] EMPTY_ARRAY = new PageRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public PageRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PageRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PageRequest.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("pageName"), a1);
    a1.setAssumedMapKeyType("java.lang.String");
    a1.setAssumedMapValueType("java.lang.Object");
    final Map c1 = java_util_Map.demarshall(obj.get("state"), a1);
    a1.resetAssumedTypes();
    PageRequest entity = new PageRequest(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(PageRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jboss.errai.common.client.PageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pageName\":").append(java_lang_String.marshall(a0.getPageName(), a1)).append(",").append("\"state\":").append(java_util_Map.marshall(a0.getState(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}