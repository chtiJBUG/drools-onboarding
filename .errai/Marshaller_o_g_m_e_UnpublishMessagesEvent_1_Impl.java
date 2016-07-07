package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.messageconsole.events.UnpublishMessagesEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_m_e_UnpublishMessagesEvent_1_Impl implements GeneratedMarshaller<UnpublishMessagesEvent> {
  private UnpublishMessagesEvent[] EMPTY_ARRAY = new UnpublishMessagesEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public UnpublishMessagesEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UnpublishMessagesEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UnpublishMessagesEvent.class, objId);
    }
    UnpublishMessagesEvent entity = new UnpublishMessagesEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sessionId")) && (!obj.get("sessionId").isNull())) {
      entity.setSessionId(java_lang_String.demarshall(obj.get("sessionId"), a1));
    }
    if ((obj.containsKey("userId")) && (!obj.get("userId").isNull())) {
      entity.setUserId(java_lang_String.demarshall(obj.get("userId"), a1));
    }
    if ((obj.containsKey("messageType")) && (!obj.get("messageType").isNull())) {
      entity.setMessageType(java_lang_String.demarshall(obj.get("messageType"), a1));
    }
    if ((obj.containsKey("messagesToUnpublish")) && (!obj.get("messagesToUnpublish").isNull())) {
      a1.setAssumedElementType("org.guvnor.messageconsole.events.SystemMessage");
      entity.setMessagesToUnpublish(java_util_List.demarshall(obj.get("messagesToUnpublish"), a1));
    }
    if ((obj.containsKey("showSystemConsole")) && (!obj.get("showSystemConsole").isNull())) {
      entity.setShowSystemConsole(java_lang_Boolean.demarshall(obj.get("showSystemConsole"), a1));
    }
    return entity;
  }

  private native static boolean _$310263350__64711720_showSystemConsole(UnpublishMessagesEvent instance) /*-{
    return instance.@org.guvnor.messageconsole.events.UnpublishMessagesEvent::showSystemConsole;
  }-*/;

  private native static void _$310263350__64711720_showSystemConsole(UnpublishMessagesEvent instance, boolean value) /*-{
    instance.@org.guvnor.messageconsole.events.UnpublishMessagesEvent::showSystemConsole = value;
  }-*/;

  public String marshall(UnpublishMessagesEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.messageconsole.events.UnpublishMessagesEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sessionId\":").append(java_lang_String.marshall(a0.getSessionId(), a1)).append(",").append("\"userId\":").append(java_lang_String.marshall(a0.getUserId(), a1)).append(",").append("\"messageType\":").append(java_lang_String.marshall(a0.getMessageType(), a1)).append(",").append("\"messagesToUnpublish\":").append(java_util_List.marshall(a0.getMessagesToUnpublish(), a1)).append(",").append("\"showSystemConsole\":").append(java_lang_Boolean.marshall(_$310263350__64711720_showSystemConsole(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}