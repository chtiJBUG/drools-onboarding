package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.ModelField.FIELD_ORIGIN;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_ModelField_erraiD_FIELD_erraiU_ORIGIN_Impl implements GeneratedMarshaller<FIELD_ORIGIN> {
  private FIELD_ORIGIN[] EMPTY_ARRAY = new FIELD_ORIGIN[0];
  public FIELD_ORIGIN[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FIELD_ORIGIN demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    FIELD_ORIGIN entity = obj != null ? Enum.valueOf(FIELD_ORIGIN.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(FIELD_ORIGIN.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(FIELD_ORIGIN a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.ModelField$FIELD_ORIGIN\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}