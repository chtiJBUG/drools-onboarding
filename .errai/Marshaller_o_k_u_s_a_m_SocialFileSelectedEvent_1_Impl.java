package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialFileSelectedEvent;

public class Marshaller_o_k_u_s_a_m_SocialFileSelectedEvent_1_Impl implements GeneratedMarshaller<SocialFileSelectedEvent> {
  private SocialFileSelectedEvent[] EMPTY_ARRAY = new SocialFileSelectedEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public SocialFileSelectedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1302761284__1195259493_uri(SocialFileSelectedEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialFileSelectedEvent::uri;
  }-*/;

  private native static void _1302761284__1195259493_uri(SocialFileSelectedEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialFileSelectedEvent::uri = value;
  }-*/;

  private native static String _1302761284__1195259493_eventType(SocialFileSelectedEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialFileSelectedEvent::eventType;
  }-*/;

  private native static void _1302761284__1195259493_eventType(SocialFileSelectedEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialFileSelectedEvent::eventType = value;
  }-*/;

  public SocialFileSelectedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SocialFileSelectedEvent.class, objId);
    }
    SocialFileSelectedEvent entity = new SocialFileSelectedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("uri")) && (!obj.get("uri").isNull())) {
      _1302761284__1195259493_uri(entity, java_lang_String.demarshall(obj.get("uri"), a1));
    }
    if ((obj.containsKey("eventType")) && (!obj.get("eventType").isNull())) {
      _1302761284__1195259493_eventType(entity, java_lang_String.demarshall(obj.get("eventType"), a1));
    }
    return entity;
  }

  public String marshall(SocialFileSelectedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialFileSelectedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"uri\":").append(java_lang_String.marshall(a0.getUri(), a1)).append(",").append("\"eventType\":").append(java_lang_String.marshall(a0.getEventType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}