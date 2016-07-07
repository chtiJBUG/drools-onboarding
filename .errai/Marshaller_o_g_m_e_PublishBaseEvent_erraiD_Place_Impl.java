package org.jboss.errai.marshalling.client.api;

import org.guvnor.messageconsole.events.PublishBaseEvent.Place;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_m_e_PublishBaseEvent_erraiD_Place_Impl implements GeneratedMarshaller<Place> {
  private Place[] EMPTY_ARRAY = new Place[0];
  public Place[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Place demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Place entity = obj != null ? Enum.valueOf(Place.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Place.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Place a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.messageconsole.events.PublishBaseEvent$Place\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}