package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.events.NotificationEvent.NotificationType;

public class Marshaller_o_u_w_e_NotificationEvent_erraiD_NotificationType_Impl implements GeneratedMarshaller<NotificationType> {
  private NotificationType[] EMPTY_ARRAY = new NotificationType[0];
  public NotificationType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public NotificationType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    NotificationType entity = obj != null ? Enum.valueOf(NotificationType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(NotificationType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(NotificationType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.events.NotificationEvent$NotificationType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}