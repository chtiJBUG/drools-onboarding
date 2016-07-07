package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.paging.PageResponse;

public class Marshaller_o_u_p_PageResponse_1_Impl implements GeneratedMarshaller<PageResponse> {
  private PageResponse[] EMPTY_ARRAY = new PageResponse[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public PageResponse[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PageResponse demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PageResponse.class, objId);
    }
    PageResponse entity = new PageResponse();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("totalRowSizeExact")) && (!obj.get("totalRowSizeExact").isNull())) {
      entity.setTotalRowSizeExact(java_lang_Boolean.demarshall(obj.get("totalRowSizeExact"), a1));
    }
    if ((obj.containsKey("totalRowSize")) && (!obj.get("totalRowSize").isNull())) {
      entity.setTotalRowSize(java_lang_Integer.demarshall(obj.get("totalRowSize"), a1));
    }
    if ((obj.containsKey("startRowIndex")) && (!obj.get("startRowIndex").isNull())) {
      entity.setStartRowIndex(java_lang_Integer.demarshall(obj.get("startRowIndex"), a1));
    }
    if ((obj.containsKey("pageRowList")) && (!obj.get("pageRowList").isNull())) {
      entity.setPageRowList(java_util_List.demarshall(obj.get("pageRowList"), a1));
    }
    if ((obj.containsKey("lastPage")) && (!obj.get("lastPage").isNull())) {
      entity.setLastPage(java_lang_Boolean.demarshall(obj.get("lastPage"), a1));
    }
    return entity;
  }

  private native static boolean _1317078078__64711720_totalRowSizeExact(PageResponse instance) /*-{
    return instance.@org.uberfire.paging.PageResponse::totalRowSizeExact;
  }-*/;

  private native static void _1317078078__64711720_totalRowSizeExact(PageResponse instance, boolean value) /*-{
    instance.@org.uberfire.paging.PageResponse::totalRowSizeExact = value;
  }-*/;

  private native static boolean _1317078078__64711720_lastPage(PageResponse instance) /*-{
    return instance.@org.uberfire.paging.PageResponse::lastPage;
  }-*/;

  private native static void _1317078078__64711720_lastPage(PageResponse instance, boolean value) /*-{
    instance.@org.uberfire.paging.PageResponse::lastPage = value;
  }-*/;

  public String marshall(PageResponse a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.paging.PageResponse\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"totalRowSizeExact\":").append(java_lang_Boolean.marshall(_1317078078__64711720_totalRowSizeExact(a0), a1)).append(",").append("\"totalRowSize\":").append(java_lang_Integer.marshall(a0.getTotalRowSize(), a1)).append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageRowList\":").append(java_util_List.marshall(a0.getPageRowList(), a1)).append(",").append("\"lastPage\":").append(java_lang_Boolean.marshall(_1317078078__64711720_lastPage(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}