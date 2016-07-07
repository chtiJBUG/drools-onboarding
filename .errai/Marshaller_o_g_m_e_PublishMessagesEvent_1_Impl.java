package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.messageconsole.events.PublishBaseEvent;
import org.guvnor.messageconsole.events.PublishBaseEvent.Place;
import org.guvnor.messageconsole.events.PublishMessagesEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_m_e_PublishMessagesEvent_1_Impl implements GeneratedMarshaller<PublishMessagesEvent> {
  private PublishMessagesEvent[] EMPTY_ARRAY = new PublishMessagesEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Place> org_guvnor_messageconsole_events_PublishBaseEvent_erraiD_Place = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public PublishMessagesEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PublishMessagesEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PublishMessagesEvent.class, objId);
    }
    PublishMessagesEvent entity = new PublishMessagesEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sessionId")) && (!obj.get("sessionId").isNull())) {
      entity.setSessionId(java_lang_String.demarshall(obj.get("sessionId"), a1));
    }
    if ((obj.containsKey("userId")) && (!obj.get("userId").isNull())) {
      entity.setUserId(java_lang_String.demarshall(obj.get("userId"), a1));
    }
    if ((obj.containsKey("place")) && (!obj.get("place").isNull())) {
      entity.setPlace(obj.get("place").isObject() != null ? Enum.valueOf(Place.class, obj.get("place").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("place").isString() != null ? Enum.valueOf(Place.class, obj.get("place").isString().stringValue()) : null);
    }
    if ((obj.containsKey("messagesToPublish")) && (!obj.get("messagesToPublish").isNull())) {
      a1.setAssumedElementType("org.guvnor.messageconsole.events.SystemMessage");
      entity.setMessagesToPublish(java_util_List.demarshall(obj.get("messagesToPublish"), a1));
    }
    if ((obj.containsKey("showSystemConsole")) && (!obj.get("showSystemConsole").isNull())) {
      entity.setShowSystemConsole(java_lang_Boolean.demarshall(obj.get("showSystemConsole"), a1));
    }
    return entity;
  }

  private native static boolean _1757488460__64711720_showSystemConsole(PublishBaseEvent instance) /*-{
    return instance.@org.guvnor.messageconsole.events.PublishBaseEvent::showSystemConsole;
  }-*/;

  private native static void _1757488460__64711720_showSystemConsole(PublishBaseEvent instance, boolean value) /*-{
    instance.@org.guvnor.messageconsole.events.PublishBaseEvent::showSystemConsole = value;
  }-*/;

  public String marshall(PublishMessagesEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.messageconsole.events.PublishMessagesEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sessionId\":").append(java_lang_String.marshall(a0.getSessionId(), a1)).append(",").append("\"userId\":").append(java_lang_String.marshall(a0.getUserId(), a1)).append(",").append("\"place\":").append(a0.getPlace() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.messageconsole.events.PublishBaseEvent$Place\",\"^EnumStringValue\":\"").append(a0.getPlace().name()).append("\"}") : "null").append(",").append("\"messagesToPublish\":").append(java_util_List.marshall(a0.getMessagesToPublish(), a1)).append(",").append("\"showSystemConsole\":").append(java_lang_Boolean.marshall(_1757488460__64711720_showSystemConsole(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_messageconsole_events_PublishBaseEvent_erraiD_Place == null) {
      org_guvnor_messageconsole_events_PublishBaseEvent_erraiD_Place = Marshalling.getMarshaller(Place.class);
    }
  }
}