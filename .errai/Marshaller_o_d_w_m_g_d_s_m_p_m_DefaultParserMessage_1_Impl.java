package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DefaultParserMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_DefaultParserMessage_1_Impl implements GeneratedMarshaller<DefaultParserMessage> {
  private DefaultParserMessage[] EMPTY_ARRAY = new DefaultParserMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DefaultParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$2065798308__1195259493_message(DefaultParserMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DefaultParserMessage::message;
  }-*/;

  private native static void _$2065798308__1195259493_message(DefaultParserMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DefaultParserMessage::message = value;
  }-*/;

  public DefaultParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DefaultParserMessage.class, objId);
    }
    DefaultParserMessage entity = new DefaultParserMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$2065798308__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(DefaultParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DefaultParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}