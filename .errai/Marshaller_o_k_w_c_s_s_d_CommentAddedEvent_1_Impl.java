package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.shared.discussion.CommentAddedEvent;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_s_d_CommentAddedEvent_1_Impl implements GeneratedMarshaller<CommentAddedEvent> {
  private CommentAddedEvent[] EMPTY_ARRAY = new CommentAddedEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public CommentAddedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1767428305__1195259493_userName(CommentAddedEvent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::userName;
  }-*/;

  private native static void _$1767428305__1195259493_userName(CommentAddedEvent instance, String value) /*-{
    instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::userName = value;
  }-*/;

  private native static String _$1767428305__1195259493_comment(CommentAddedEvent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::comment;
  }-*/;

  private native static void _$1767428305__1195259493_comment(CommentAddedEvent instance, String value) /*-{
    instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::comment = value;
  }-*/;

  private native static Long _$1767428305__398795216_timestamp(CommentAddedEvent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::timestamp;
  }-*/;

  private native static void _$1767428305__398795216_timestamp(CommentAddedEvent instance, Long value) /*-{
    instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::timestamp = value;
  }-*/;

  private native static Path _$1767428305__$2084529122_path(CommentAddedEvent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::path;
  }-*/;

  private native static void _$1767428305__$2084529122_path(CommentAddedEvent instance, Path value) /*-{
    instance.@org.kie.workbench.common.services.shared.discussion.CommentAddedEvent::path = value;
  }-*/;

  public CommentAddedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CommentAddedEvent.class, objId);
    }
    CommentAddedEvent entity = new CommentAddedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("userName")) && (!obj.get("userName").isNull())) {
      _$1767428305__1195259493_userName(entity, java_lang_String.demarshall(obj.get("userName"), a1));
    }
    if ((obj.containsKey("comment")) && (!obj.get("comment").isNull())) {
      _$1767428305__1195259493_comment(entity, java_lang_String.demarshall(obj.get("comment"), a1));
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      _$1767428305__398795216_timestamp(entity, java_lang_Long.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1767428305__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  public String marshall(CommentAddedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.discussion.CommentAddedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"userName\":").append(java_lang_String.marshall(a0.getUserName(), a1)).append(",").append("\"comment\":").append(java_lang_String.marshall(a0.getComment(), a1)).append(",").append("\"timestamp\":").append(java_lang_Long.marshall(a0.getTimestamp(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}