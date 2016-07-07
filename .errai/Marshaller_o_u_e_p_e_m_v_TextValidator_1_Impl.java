package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.properties.editor.model.validators.TextValidator;

public class Marshaller_o_u_e_p_e_m_v_TextValidator_1_Impl implements GeneratedMarshaller<TextValidator> {
  private TextValidator[] EMPTY_ARRAY = new TextValidator[0];
  public TextValidator[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TextValidator demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TextValidator.class, objId);
    }
    TextValidator entity = new TextValidator();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(TextValidator a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.validators.TextValidator\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}