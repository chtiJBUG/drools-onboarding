package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialPaged.Direction;

public class Marshaller_o_k_u_s_a_m_SocialPaged_erraiD_Direction_Impl implements GeneratedMarshaller<Direction> {
  private Direction[] EMPTY_ARRAY = new Direction[0];
  public Direction[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Direction demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Direction entity = obj != null ? Enum.valueOf(Direction.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Direction.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Direction a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialPaged$Direction\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}