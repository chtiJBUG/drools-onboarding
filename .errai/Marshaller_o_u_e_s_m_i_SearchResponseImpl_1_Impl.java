package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.impl.SearchResponseImpl;

public class Marshaller_o_u_e_s_m_i_SearchResponseImpl_1_Impl implements GeneratedMarshaller<SearchResponseImpl> {
  private SearchResponseImpl[] EMPTY_ARRAY = new SearchResponseImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public SearchResponseImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _2091496953__1195259493_searchPattern(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::searchPattern;
  }-*/;

  private native static void _2091496953__1195259493_searchPattern(SearchResponseImpl instance, String value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::searchPattern = value;
  }-*/;

  private native static int _2091496953__104431_page(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::page;
  }-*/;

  private native static void _2091496953__104431_page(SearchResponseImpl instance, int value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::page = value;
  }-*/;

  private native static int _2091496953__104431_pageSize(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::pageSize;
  }-*/;

  private native static void _2091496953__104431_pageSize(SearchResponseImpl instance, int value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::pageSize = value;
  }-*/;

  private native static List _2091496953__65821278_results(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::results;
  }-*/;

  private native static void _2091496953__65821278_results(SearchResponseImpl instance, List value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::results = value;
  }-*/;

  private native static int _2091496953__104431_total(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::total;
  }-*/;

  private native static void _2091496953__104431_total(SearchResponseImpl instance, int value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::total = value;
  }-*/;

  private native static boolean _2091496953__64711720_hasNextPage(SearchResponseImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::hasNextPage;
  }-*/;

  private native static void _2091496953__64711720_hasNextPage(SearchResponseImpl instance, boolean value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchResponseImpl::hasNextPage = value;
  }-*/;

  public SearchResponseImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SearchResponseImpl.class, objId);
    }
    SearchResponseImpl entity = new SearchResponseImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("searchPattern")) && (!obj.get("searchPattern").isNull())) {
      _2091496953__1195259493_searchPattern(entity, java_lang_String.demarshall(obj.get("searchPattern"), a1));
    }
    if ((obj.containsKey("page")) && (!obj.get("page").isNull())) {
      _2091496953__104431_page(entity, java_lang_Integer.demarshall(obj.get("page"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      _2091496953__104431_pageSize(entity, java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    if ((obj.containsKey("results")) && (!obj.get("results").isNull())) {
      _2091496953__65821278_results(entity, java_util_List.demarshall(obj.get("results"), a1));
    }
    if ((obj.containsKey("total")) && (!obj.get("total").isNull())) {
      _2091496953__104431_total(entity, java_lang_Integer.demarshall(obj.get("total"), a1));
    }
    if ((obj.containsKey("hasNextPage")) && (!obj.get("hasNextPage").isNull())) {
      _2091496953__64711720_hasNextPage(entity, java_lang_Boolean.demarshall(obj.get("hasNextPage"), a1));
    }
    return entity;
  }

  public String marshall(SearchResponseImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.SearchResponseImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"searchPattern\":").append(java_lang_String.marshall(a0.getSearchPattern(), a1)).append(",").append("\"page\":").append(java_lang_Integer.marshall(a0.getPage(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append(",").append("\"results\":").append(java_util_List.marshall(a0.getResults(), a1)).append(",").append("\"total\":").append(java_lang_Integer.marshall(a0.getTotal(), a1)).append(",").append("\"hasNextPage\":").append(java_lang_Boolean.marshall(_2091496953__64711720_hasNextPage(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}