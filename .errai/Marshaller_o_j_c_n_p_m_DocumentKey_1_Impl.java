package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.DocumentKey;

public class Marshaller_o_j_c_n_p_m_DocumentKey_1_Impl implements GeneratedMarshaller<DocumentKey> {
  private DocumentKey[] EMPTY_ARRAY = new DocumentKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DocumentKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _146882690__1195259493_documentId(DocumentKey instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.DocumentKey::documentId;
  }-*/;

  private native static void _146882690__1195259493_documentId(DocumentKey instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.DocumentKey::documentId = value;
  }-*/;

  public DocumentKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DocumentKey.class, objId);
    }
    DocumentKey entity = new DocumentKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("documentId")) && (!obj.get("documentId").isNull())) {
      _146882690__1195259493_documentId(entity, java_lang_String.demarshall(obj.get("documentId"), a1));
    }
    return entity;
  }

  public String marshall(DocumentKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.DocumentKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"documentId\":").append(java_lang_String.marshall(a0.getDocumentId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}