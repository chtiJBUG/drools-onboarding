package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.BindingNotFoundParserMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_BindingNotFoundParserMessage_1_Impl implements GeneratedMarshaller<BindingNotFoundParserMessage> {
  private BindingNotFoundParserMessage[] EMPTY_ARRAY = new BindingNotFoundParserMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public BindingNotFoundParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1696417129__1195259493_binding(BindingNotFoundParserMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.BindingNotFoundParserMessage::binding;
  }-*/;

  private native static void _1696417129__1195259493_binding(BindingNotFoundParserMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.BindingNotFoundParserMessage::binding = value;
  }-*/;

  public BindingNotFoundParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BindingNotFoundParserMessage.class, objId);
    }
    BindingNotFoundParserMessage entity = new BindingNotFoundParserMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      _1696417129__1195259493_binding(entity, java_lang_String.demarshall(obj.get("binding"), a1));
    }
    return entity;
  }

  public String marshall(BindingNotFoundParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.BindingNotFoundParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}