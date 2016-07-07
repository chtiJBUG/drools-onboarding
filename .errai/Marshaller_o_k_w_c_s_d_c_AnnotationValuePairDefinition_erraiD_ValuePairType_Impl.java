package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition.ValuePairType;

public class Marshaller_o_k_w_c_s_d_c_AnnotationValuePairDefinition_erraiD_ValuePairType_Impl implements GeneratedMarshaller<ValuePairType> {
  private ValuePairType[] EMPTY_ARRAY = new ValuePairType[0];
  public ValuePairType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ValuePairType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ValuePairType entity = obj != null ? Enum.valueOf(ValuePairType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ValuePairType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ValuePairType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition$ValuePairType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}