package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent.LINK_TYPE;

public class Marshaller_o_k_u_s_a_m_SocialActivitiesEvent_erraiD_LINK_erraiU_TYPE_Impl implements GeneratedMarshaller<LINK_TYPE> {
  private LINK_TYPE[] EMPTY_ARRAY = new LINK_TYPE[0];
  public LINK_TYPE[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public LINK_TYPE demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    LINK_TYPE entity = obj != null ? Enum.valueOf(LINK_TYPE.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(LINK_TYPE.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(LINK_TYPE a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialActivitiesEvent$LINK_TYPE\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}