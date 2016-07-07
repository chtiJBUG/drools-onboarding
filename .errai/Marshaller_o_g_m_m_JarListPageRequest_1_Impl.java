package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.m2repo.model.JarListPageRequest;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_m_m_JarListPageRequest_1_Impl implements GeneratedMarshaller<JarListPageRequest> {
  private JarListPageRequest[] EMPTY_ARRAY = new JarListPageRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public JarListPageRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$801798776__64711720_isAscending(JarListPageRequest instance) /*-{
    return instance.@org.guvnor.m2repo.model.JarListPageRequest::isAscending;
  }-*/;

  private native static void _$801798776__64711720_isAscending(JarListPageRequest instance, boolean value) /*-{
    instance.@org.guvnor.m2repo.model.JarListPageRequest::isAscending = value;
  }-*/;

  public JarListPageRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JarListPageRequest.class, objId);
    }
    final String c2 = java_lang_String.demarshall(obj.get("filters"), a1);
    a1.setAssumedElementType("java.lang.String");
    final List c3 = java_util_List.demarshall(obj.get("fileFormats"), a1);
    final String c4 = java_lang_String.demarshall(obj.get("dataSourceName"), a1);
    final Boolean c5 = java_lang_Boolean.demarshall(obj.get("isAscending"), a1);
    final Integer c0 = java_lang_Integer.demarshall(obj.get("startRowIndex"), a1);
    final Integer c1 = java_lang_Integer.demarshall(obj.get("pageSize"), a1);
    JarListPageRequest entity = new JarListPageRequest(c0, c1, c2, c3, c4, c5);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("isAscending")) && (!obj.get("isAscending").isNull())) {
      _$801798776__64711720_isAscending(entity, java_lang_Boolean.demarshall(obj.get("isAscending"), a1));
    }
    if ((obj.containsKey("startRowIndex")) && (!obj.get("startRowIndex").isNull())) {
      entity.setStartRowIndex(java_lang_Integer.demarshall(obj.get("startRowIndex"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      entity.setPageSize(java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(JarListPageRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.m2repo.model.JarListPageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"filters\":").append(java_lang_String.marshall(a0.getFilters(), a1)).append(",").append("\"fileFormats\":").append(java_util_List.marshall(a0.getFileFormats(), a1)).append(",").append("\"dataSourceName\":").append(java_lang_String.marshall(a0.getDataSourceName(), a1)).append(",").append("\"isAscending\":").append(java_lang_Boolean.marshall(_$801798776__64711720_isAscending(a0), a1)).append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}