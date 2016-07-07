package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest;

public class Marshaller_o_k_w_c_s_r_m_q_RefactoringPageRequest_1_Impl implements GeneratedMarshaller<RefactoringPageRequest> {
  private RefactoringPageRequest[] EMPTY_ARRAY = new RefactoringPageRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public RefactoringPageRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1328531418__64711720_useWildcards(RefactoringPageRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest::useWildcards;
  }-*/;

  private native static void _$1328531418__64711720_useWildcards(RefactoringPageRequest instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest::useWildcards = value;
  }-*/;

  public RefactoringPageRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RefactoringPageRequest.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("queryName"), a1);
    a1.setAssumedElementType("org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueIndexTerm");
    final Set c1 = java_util_Set.demarshall(obj.get("queryTerms"), a1);
    final Boolean c2 = java_lang_Boolean.demarshall(obj.get("useWildcards"), a1);
    final Integer c3 = java_lang_Integer.demarshall(obj.get("startRowIndex"), a1);
    final Integer c4 = java_lang_Integer.demarshall(obj.get("pageSize"), a1);
    RefactoringPageRequest entity = new RefactoringPageRequest(c0, c1, c2, c3, c4);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("useWildcards")) && (!obj.get("useWildcards").isNull())) {
      _$1328531418__64711720_useWildcards(entity, java_lang_Boolean.demarshall(obj.get("useWildcards"), a1));
    }
    if ((obj.containsKey("startRowIndex")) && (!obj.get("startRowIndex").isNull())) {
      entity.setStartRowIndex(java_lang_Integer.demarshall(obj.get("startRowIndex"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      entity.setPageSize(java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(RefactoringPageRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"queryName\":").append(java_lang_String.marshall(a0.getQueryName(), a1)).append(",").append("\"queryTerms\":").append(java_util_Set.marshall(a0.getQueryTerms(), a1)).append(",").append("\"useWildcards\":").append(java_lang_Boolean.marshall(_$1328531418__64711720_useWildcards(a0), a1)).append(",").append("\"startRowIndex\":").append(java_lang_Integer.marshall(a0.getStartRowIndex(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}