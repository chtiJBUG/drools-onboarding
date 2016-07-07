package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.designer.notification.DesignerNotificationEvent;
import org.uberfire.workbench.events.NotificationEvent.NotificationType;

public class Marshaller_o_j_d_n_DesignerNotificationEvent_1_Impl implements GeneratedMarshaller<DesignerNotificationEvent> {
  private DesignerNotificationEvent[] EMPTY_ARRAY = new DesignerNotificationEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<NotificationType> org_uberfire_workbench_events_NotificationEvent_erraiD_NotificationType = null;
  public DesignerNotificationEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _407445461__1195259493_notification(DesignerNotificationEvent instance) /*-{
    return instance.@org.jbpm.designer.notification.DesignerNotificationEvent::notification;
  }-*/;

  private native static void _407445461__1195259493_notification(DesignerNotificationEvent instance, String value) /*-{
    instance.@org.jbpm.designer.notification.DesignerNotificationEvent::notification = value;
  }-*/;

  private native static NotificationType _407445461__$73684180_type(DesignerNotificationEvent instance) /*-{
    return instance.@org.jbpm.designer.notification.DesignerNotificationEvent::type;
  }-*/;

  private native static void _407445461__$73684180_type(DesignerNotificationEvent instance, NotificationType value) /*-{
    instance.@org.jbpm.designer.notification.DesignerNotificationEvent::type = value;
  }-*/;

  private native static String _407445461__1195259493_userId(DesignerNotificationEvent instance) /*-{
    return instance.@org.jbpm.designer.notification.DesignerNotificationEvent::userId;
  }-*/;

  private native static void _407445461__1195259493_userId(DesignerNotificationEvent instance, String value) /*-{
    instance.@org.jbpm.designer.notification.DesignerNotificationEvent::userId = value;
  }-*/;

  public DesignerNotificationEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DesignerNotificationEvent.class, objId);
    }
    DesignerNotificationEvent entity = new DesignerNotificationEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("notification")) && (!obj.get("notification").isNull())) {
      _407445461__1195259493_notification(entity, java_lang_String.demarshall(obj.get("notification"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _407445461__$73684180_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(NotificationType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(NotificationType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("userId")) && (!obj.get("userId").isNull())) {
      _407445461__1195259493_userId(entity, java_lang_String.demarshall(obj.get("userId"), a1));
    }
    return entity;
  }

  public String marshall(DesignerNotificationEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.designer.notification.DesignerNotificationEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"notification\":").append(java_lang_String.marshall(a0.getNotification(), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.events.NotificationEvent$NotificationType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"userId\":").append(java_lang_String.marshall(a0.getUserId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_workbench_events_NotificationEvent_erraiD_NotificationType == null) {
      org_uberfire_workbench_events_NotificationEvent_erraiD_NotificationType = Marshalling.getMarshaller(NotificationType.class);
    }
  }
}