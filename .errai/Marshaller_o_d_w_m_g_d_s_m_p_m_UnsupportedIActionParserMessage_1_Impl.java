package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedIActionParserMessage;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_UnsupportedIActionParserMessage_1_Impl implements GeneratedMarshaller<UnsupportedIActionParserMessage> {
  private UnsupportedIActionParserMessage[] EMPTY_ARRAY = new UnsupportedIActionParserMessage[0];
  public UnsupportedIActionParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UnsupportedIActionParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UnsupportedIActionParserMessage.class, objId);
    }
    UnsupportedIActionParserMessage entity = new UnsupportedIActionParserMessage();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(UnsupportedIActionParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.UnsupportedIActionParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}