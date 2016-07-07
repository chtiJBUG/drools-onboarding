package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedFieldNatureTypeParserMessage;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_UnsupportedFieldNatureTypeParserMessage_1_Impl implements GeneratedMarshaller<UnsupportedFieldNatureTypeParserMessage> {
  private UnsupportedFieldNatureTypeParserMessage[] EMPTY_ARRAY = new UnsupportedFieldNatureTypeParserMessage[0];
  public UnsupportedFieldNatureTypeParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UnsupportedFieldNatureTypeParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UnsupportedFieldNatureTypeParserMessage.class, objId);
    }
    UnsupportedFieldNatureTypeParserMessage entity = new UnsupportedFieldNatureTypeParserMessage();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(UnsupportedFieldNatureTypeParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedFieldNatureTypeParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}