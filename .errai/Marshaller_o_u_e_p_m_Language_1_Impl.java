package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.Language;

public class Marshaller_o_u_e_p_m_Language_1_Impl implements GeneratedMarshaller<Language> {
  private Language[] EMPTY_ARRAY = new Language[0];
  public Language[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Language demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    Language entity = obj != null ? Enum.valueOf(Language.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(Language.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(Language a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.Language\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}