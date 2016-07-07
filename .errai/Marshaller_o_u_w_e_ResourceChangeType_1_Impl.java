package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.workbench.events.ResourceChangeType;

public class Marshaller_o_u_w_e_ResourceChangeType_1_Impl implements GeneratedMarshaller<ResourceChangeType> {
  private ResourceChangeType[] EMPTY_ARRAY = new ResourceChangeType[0];
  public ResourceChangeType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ResourceChangeType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ResourceChangeType entity = obj != null ? Enum.valueOf(ResourceChangeType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ResourceChangeType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ResourceChangeType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceChangeType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}