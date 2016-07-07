package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.social.OrganizationalUnitEventType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_s_s_OrganizationalUnitEventType_1_Impl implements GeneratedMarshaller<OrganizationalUnitEventType> {
  private OrganizationalUnitEventType[] EMPTY_ARRAY = new OrganizationalUnitEventType[0];
  public OrganizationalUnitEventType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public OrganizationalUnitEventType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    OrganizationalUnitEventType entity = obj != null ? Enum.valueOf(OrganizationalUnitEventType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(OrganizationalUnitEventType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(OrganizationalUnitEventType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.structure.social.OrganizationalUnitEventType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}