package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.metadata.model.DiscussionRecord;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_s_m_m_DiscussionRecord_1_Impl implements GeneratedMarshaller<DiscussionRecord> {
  private DiscussionRecord[] EMPTY_ARRAY = new DiscussionRecord[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DiscussionRecord[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _$1933033988__398795216_timestamp(DiscussionRecord instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::timestamp;
  }-*/;

  private native static void _$1933033988__398795216_timestamp(DiscussionRecord instance, Long value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::timestamp = value;
  }-*/;

  private native static String _$1933033988__1195259493_note(DiscussionRecord instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::note;
  }-*/;

  private native static void _$1933033988__1195259493_note(DiscussionRecord instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::note = value;
  }-*/;

  private native static String _$1933033988__1195259493_author(DiscussionRecord instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::author;
  }-*/;

  private native static void _$1933033988__1195259493_author(DiscussionRecord instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.DiscussionRecord::author = value;
  }-*/;

  public DiscussionRecord demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DiscussionRecord.class, objId);
    }
    DiscussionRecord entity = new DiscussionRecord();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      _$1933033988__398795216_timestamp(entity, java_lang_Long.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("note")) && (!obj.get("note").isNull())) {
      _$1933033988__1195259493_note(entity, java_lang_String.demarshall(obj.get("note"), a1));
    }
    if ((obj.containsKey("author")) && (!obj.get("author").isNull())) {
      _$1933033988__1195259493_author(entity, java_lang_String.demarshall(obj.get("author"), a1));
    }
    return entity;
  }

  public String marshall(DiscussionRecord a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.shared.metadata.model.DiscussionRecord\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"timestamp\":").append(java_lang_Long.marshall(a0.getTimestamp(), a1)).append(",").append("\"note\":").append(java_lang_String.marshall(a0.getNote(), a1)).append(",").append("\"author\":").append(java_lang_String.marshall(a0.getAuthor(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}