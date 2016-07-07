package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.social.hp.model.HomePageTypes;

public class Marshaller_o_k_w_c_s_s_h_m_HomePageTypes_1_Impl implements GeneratedMarshaller<HomePageTypes> {
  private HomePageTypes[] EMPTY_ARRAY = new HomePageTypes[0];
  public HomePageTypes[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public HomePageTypes demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    HomePageTypes entity = obj != null ? Enum.valueOf(HomePageTypes.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(HomePageTypes.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(HomePageTypes a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.social.hp.model.HomePageTypes\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}