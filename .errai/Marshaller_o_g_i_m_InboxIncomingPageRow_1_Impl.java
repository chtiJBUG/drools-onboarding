package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.guvnor.inbox.model.InboxIncomingPageRow;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_i_m_InboxIncomingPageRow_1_Impl implements GeneratedMarshaller<InboxIncomingPageRow> {
  private InboxIncomingPageRow[] EMPTY_ARRAY = new InboxIncomingPageRow[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public InboxIncomingPageRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public InboxIncomingPageRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(InboxIncomingPageRow.class, objId);
    }
    InboxIncomingPageRow entity = new InboxIncomingPageRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("from")) && (!obj.get("from").isNull())) {
      entity.setFrom(java_lang_String.demarshall(obj.get("from"), a1));
    }
    if ((obj.containsKey("note")) && (!obj.get("note").isNull())) {
      entity.setNote(java_lang_String.demarshall(obj.get("note"), a1));
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      entity.setTimestamp(java_util_Date.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("format")) && (!obj.get("format").isNull())) {
      entity.setFormat(java_lang_String.demarshall(obj.get("format"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      entity.setPath((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  public String marshall(InboxIncomingPageRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.inbox.model.InboxIncomingPageRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"from\":").append(java_lang_String.marshall(a0.getFrom(), a1)).append(",").append("\"note\":").append(java_lang_String.marshall(a0.getNote(), a1)).append(",").append("\"timestamp\":").append(java_util_Date.marshall(a0.getTimestamp(), a1)).append(",").append("\"format\":").append(java_lang_String.marshall(a0.getFormat(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}