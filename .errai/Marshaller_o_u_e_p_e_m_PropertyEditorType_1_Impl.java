package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.properties.editor.model.PropertyEditorType;

public class Marshaller_o_u_e_p_e_m_PropertyEditorType_1_Impl implements GeneratedMarshaller<PropertyEditorType> {
  private PropertyEditorType[] EMPTY_ARRAY = new PropertyEditorType[0];
  public PropertyEditorType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PropertyEditorType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    PropertyEditorType entity = obj != null ? Enum.valueOf(PropertyEditorType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(PropertyEditorType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(PropertyEditorType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.PropertyEditorType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}