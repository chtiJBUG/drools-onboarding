package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.paging.PageRequest;

public class Marshaller_o_u_p_PageRequest_1_Impl implements GeneratedMarshaller<PageRequest> {
  private PageRequest[] EMPTY_ARRAY = new PageRequest[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
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
    final Integer c0 = java_lang_Integer.demarshall(obj.get("startRowIndex"), a1);
    final Integer c1 = java_lang_Integer.demarshall(obj.get("pageSize"), a1);
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
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.paging.PageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}