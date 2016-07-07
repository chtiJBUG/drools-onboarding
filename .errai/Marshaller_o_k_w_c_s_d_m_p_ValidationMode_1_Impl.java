package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.persistence.ValidationMode;

public class Marshaller_o_k_w_c_s_d_m_p_ValidationMode_1_Impl implements GeneratedMarshaller<ValidationMode> {
  private ValidationMode[] EMPTY_ARRAY = new ValidationMode[0];
  public ValidationMode[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ValidationMode demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ValidationMode entity = obj != null ? Enum.valueOf(ValidationMode.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ValidationMode.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ValidationMode a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.ValidationMode\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}