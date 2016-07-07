package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.impl.SearchRequestImpl;

public class Marshaller_o_u_e_s_m_i_SearchRequestImpl_1_Impl implements GeneratedMarshaller<SearchRequestImpl> {
  private SearchRequestImpl[] EMPTY_ARRAY = new SearchRequestImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public SearchRequestImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1877232041__1195259493_searchPattern(SearchRequestImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::searchPattern;
  }-*/;

  private native static void _$1877232041__1195259493_searchPattern(SearchRequestImpl instance, String value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::searchPattern = value;
  }-*/;

  private native static int _$1877232041__104431_page(SearchRequestImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::page;
  }-*/;

  private native static void _$1877232041__104431_page(SearchRequestImpl instance, int value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::page = value;
  }-*/;

  private native static int _$1877232041__104431_pageSize(SearchRequestImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::pageSize;
  }-*/;

  private native static void _$1877232041__104431_pageSize(SearchRequestImpl instance, int value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SearchRequestImpl::pageSize = value;
  }-*/;

  public SearchRequestImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SearchRequestImpl.class, objId);
    }
    SearchRequestImpl entity = new SearchRequestImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("searchPattern")) && (!obj.get("searchPattern").isNull())) {
      _$1877232041__1195259493_searchPattern(entity, java_lang_String.demarshall(obj.get("searchPattern"), a1));
    }
    if ((obj.containsKey("constrainedIdentifiers")) && (!obj.get("constrainedIdentifiers").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setConstrainedIdentifiers(java_util_Set.demarshall(obj.get("constrainedIdentifiers"), a1));
    }
    if ((obj.containsKey("page")) && (!obj.get("page").isNull())) {
      _$1877232041__104431_page(entity, java_lang_Integer.demarshall(obj.get("page"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      _$1877232041__104431_pageSize(entity, java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(SearchRequestImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.SearchRequestImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"searchPattern\":").append(java_lang_String.marshall(a0.getSearchPattern(), a1)).append(",").append("\"constrainedIdentifiers\":").append(java_util_Set.marshall(a0.getConstrainedIdentifiers(), a1)).append(",").append("\"page\":").append(java_lang_Integer.marshall(a0.getPage(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}