package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.properties.editor.model.validators.LongValidator;

public class Marshaller_o_u_e_p_e_m_v_LongValidator_1_Impl implements GeneratedMarshaller<LongValidator> {
  private LongValidator[] EMPTY_ARRAY = new LongValidator[0];
  public LongValidator[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public LongValidator demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LongValidator.class, objId);
    }
    LongValidator entity = new LongValidator();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(LongValidator a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.validators.LongValidator\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}