package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.model.Notification.State;

public class Marshaller_o_u_w_m_Notification_erraiD_State_Impl implements GeneratedMarshaller<State> {
  private State[] EMPTY_ARRAY = new State[0];
  public State[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public State demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    State entity = obj != null ? Enum.valueOf(State.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(State.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(State a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.model.Notification$State\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}