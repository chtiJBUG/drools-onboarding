package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.search.model.QueryMetadataPageRequest;

public class Marshaller_o_k_w_c_s_s_m_QueryMetadataPageRequest_1_Impl implements GeneratedMarshaller<QueryMetadataPageRequest> {
  private QueryMetadataPageRequest[] EMPTY_ARRAY = new QueryMetadataPageRequest[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public QueryMetadataPageRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public QueryMetadataPageRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(QueryMetadataPageRequest.class, objId);
    }
    a1.setAssumedMapKeyType("java.lang.String");
    a1.setAssumedMapValueType("java.lang.Object");
    final Map c0 = java_util_Map.demarshall(obj.get("metadata"), a1);
    a1.resetAssumedTypes();
    final Date c1 = java_util_Date.demarshall(obj.get("createdAfter"), a1);
    final Date c2 = java_util_Date.demarshall(obj.get("createdBefore"), a1);
    final Date c3 = java_util_Date.demarshall(obj.get("lastModifiedAfter"), a1);
    final Date c4 = java_util_Date.demarshall(obj.get("lastModifiedBefore"), a1);
    final Integer c5 = java_lang_Integer.demarshall(obj.get("startRowIndex"), a1);
    final Integer c6 = java_lang_Integer.demarshall(obj.get("pageSize"), a1);
    QueryMetadataPageRequest entity = new QueryMetadataPageRequest(c0, c1, c2, c3, c4, c5, c6);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("startRowIndex")) && (!obj.get("startRowIndex").isNull())) {
      entity.setStartRowIndex(java_lang_Integer.demarshall(obj.get("startRowIndex"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      entity.setPageSize(java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(QueryMetadataPageRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.search.model.QueryMetadataPageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"metadata\":").append(java_util_Map.marshall(a0.getMetadata(), a1)).append(",").append("\"createdAfter\":").append(java_util_Date.marshall(a0.getCreatedAfter(), a1)).append(",").append("\"createdBefore\":").append(java_util_Date.marshall(a0.getCreatedBefore(), a1)).append(",").append("\"lastModifiedAfter\":").append(java_util_Date.marshall(a0.getLastModifiedAfter(), a1)).append(",").append("\"lastModifiedBefore\":").append(java_util_Date.marshall(a0.getLastModifiedBefore(), a1)).append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}