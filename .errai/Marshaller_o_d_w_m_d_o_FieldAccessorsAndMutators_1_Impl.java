package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_FieldAccessorsAndMutators_1_Impl implements GeneratedMarshaller<FieldAccessorsAndMutators> {
  private FieldAccessorsAndMutators[] EMPTY_ARRAY = new FieldAccessorsAndMutators[0];
  public FieldAccessorsAndMutators[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FieldAccessorsAndMutators demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    FieldAccessorsAndMutators entity = obj != null ? Enum.valueOf(FieldAccessorsAndMutators.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(FieldAccessorsAndMutators.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(FieldAccessorsAndMutators a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}