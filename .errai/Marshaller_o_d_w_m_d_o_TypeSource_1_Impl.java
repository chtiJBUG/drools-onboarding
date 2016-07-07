package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.TypeSource;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_TypeSource_1_Impl implements GeneratedMarshaller<TypeSource> {
  private TypeSource[] EMPTY_ARRAY = new TypeSource[0];
  public TypeSource[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TypeSource demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    TypeSource entity = obj != null ? Enum.valueOf(TypeSource.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(TypeSource.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(TypeSource a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.TypeSource\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}