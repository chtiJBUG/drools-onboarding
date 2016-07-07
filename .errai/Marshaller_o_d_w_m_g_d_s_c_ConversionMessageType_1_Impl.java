package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessageType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_c_ConversionMessageType_1_Impl implements GeneratedMarshaller<ConversionMessageType> {
  private ConversionMessageType[] EMPTY_ARRAY = new ConversionMessageType[0];
  public ConversionMessageType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ConversionMessageType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ConversionMessageType entity = obj != null ? Enum.valueOf(ConversionMessageType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ConversionMessageType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ConversionMessageType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessageType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}