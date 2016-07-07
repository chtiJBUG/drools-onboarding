package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.ObjectSource;

public class Marshaller_o_k_w_c_s_d_c_ObjectSource_1_Impl implements GeneratedMarshaller<ObjectSource> {
  private ObjectSource[] EMPTY_ARRAY = new ObjectSource[0];
  public ObjectSource[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ObjectSource demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ObjectSource entity = obj != null ? Enum.valueOf(ObjectSource.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ObjectSource.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ObjectSource a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.ObjectSource\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}