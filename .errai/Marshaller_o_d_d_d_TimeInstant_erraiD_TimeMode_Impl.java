package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.date.TimeInstant.TimeMode;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_TimeInstant_erraiD_TimeMode_Impl implements GeneratedMarshaller<TimeMode> {
  private TimeMode[] EMPTY_ARRAY = new TimeMode[0];
  public TimeMode[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TimeMode demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    TimeMode entity = obj != null ? Enum.valueOf(TimeMode.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(TimeMode.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(TimeMode a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.date.TimeInstant$TimeMode\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}