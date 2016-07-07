package org.jboss.errai.marshalling.client.api;

import org.guvnor.inbox.model.InboxPageRequest;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_i_m_InboxPageRequest_1_Impl implements GeneratedMarshaller<InboxPageRequest> {
  private InboxPageRequest[] EMPTY_ARRAY = new InboxPageRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public InboxPageRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public InboxPageRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(InboxPageRequest.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("inboxName"), a1);
    final Integer c1 = java_lang_Integer.demarshall(obj.get("startRowIndex"), a1);
    final Integer c2 = java_lang_Integer.demarshall(obj.get("pageSize"), a1);
    InboxPageRequest entity = new InboxPageRequest(c0, c1, c2);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("startRowIndex")) && (!obj.get("startRowIndex").isNull())) {
      entity.setStartRowIndex(java_lang_Integer.demarshall(obj.get("startRowIndex"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      entity.setPageSize(java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(InboxPageRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.inbox.model.InboxPageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"inboxName\":").append(java_lang_String.marshall(a0.getInboxName(), a1)).append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}