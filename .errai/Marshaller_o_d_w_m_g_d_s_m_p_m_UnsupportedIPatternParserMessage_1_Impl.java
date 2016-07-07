package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedIPatternParserMessage;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_UnsupportedIPatternParserMessage_1_Impl implements GeneratedMarshaller<UnsupportedIPatternParserMessage> {
  private UnsupportedIPatternParserMessage[] EMPTY_ARRAY = new UnsupportedIPatternParserMessage[0];
  public UnsupportedIPatternParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UnsupportedIPatternParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UnsupportedIPatternParserMessage.class, objId);
    }
    UnsupportedIPatternParserMessage entity = new UnsupportedIPatternParserMessage();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(UnsupportedIPatternParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedIPatternParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}