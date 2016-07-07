package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.model.CodeType;

public class Marshaller_o_u_e_p_m_CodeType_1_Impl implements GeneratedMarshaller<CodeType> {
  private CodeType[] EMPTY_ARRAY = new CodeType[0];
  public CodeType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CodeType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    CodeType entity = obj != null ? Enum.valueOf(CodeType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(CodeType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(CodeType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.plugin.model.CodeType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}