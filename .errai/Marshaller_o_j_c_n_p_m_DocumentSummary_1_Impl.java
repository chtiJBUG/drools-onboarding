package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.pr.model.DocumentSummary;

public class Marshaller_o_j_c_n_p_m_DocumentSummary_1_Impl implements GeneratedMarshaller<DocumentSummary> {
  private DocumentSummary[] EMPTY_ARRAY = new DocumentSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DocumentSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _257065033__1195259493_documentId(DocumentSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentId;
  }-*/;

  private native static void _257065033__1195259493_documentId(DocumentSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentId = value;
  }-*/;

  private native static Date _257065033__65575278_documentLastModified(DocumentSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentLastModified;
  }-*/;

  private native static void _257065033__65575278_documentLastModified(DocumentSummary instance, Date value) /*-{
    instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentLastModified = value;
  }-*/;

  private native static Long _257065033__398795216_documentSize(DocumentSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentSize;
  }-*/;

  private native static void _257065033__398795216_documentSize(DocumentSummary instance, Long value) /*-{
    instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentSize = value;
  }-*/;

  private native static String _257065033__1195259493_documentLink(DocumentSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentLink;
  }-*/;

  private native static void _257065033__1195259493_documentLink(DocumentSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.DocumentSummary::documentLink = value;
  }-*/;

  public DocumentSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DocumentSummary.class, objId);
    }
    DocumentSummary entity = new DocumentSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("documentId")) && (!obj.get("documentId").isNull())) {
      _257065033__1195259493_documentId(entity, java_lang_String.demarshall(obj.get("documentId"), a1));
    }
    if ((obj.containsKey("documentLastModified")) && (!obj.get("documentLastModified").isNull())) {
      _257065033__65575278_documentLastModified(entity, java_util_Date.demarshall(obj.get("documentLastModified"), a1));
    }
    if ((obj.containsKey("documentSize")) && (!obj.get("documentSize").isNull())) {
      _257065033__398795216_documentSize(entity, java_lang_Long.demarshall(obj.get("documentSize"), a1));
    }
    if ((obj.containsKey("documentLink")) && (!obj.get("documentLink").isNull())) {
      _257065033__1195259493_documentLink(entity, java_lang_String.demarshall(obj.get("documentLink"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(DocumentSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.DocumentSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"documentId\":").append(java_lang_String.marshall(a0.getDocumentId(), a1)).append(",").append("\"documentLastModified\":").append(java_util_Date.marshall(a0.getDocumentLastModified(), a1)).append(",").append("\"documentSize\":").append(java_lang_Long.marshall(a0.getDocumentSize(), a1)).append(",").append("\"documentLink\":").append(java_lang_String.marshall(a0.getDocumentLink(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}