package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.AmbiguousRootParserMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_AmbiguousRootParserMessage_1_Impl implements GeneratedMarshaller<AmbiguousRootParserMessage> {
  private AmbiguousRootParserMessage[] EMPTY_ARRAY = new AmbiguousRootParserMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public AmbiguousRootParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _81454575__1195259493_className(AmbiguousRootParserMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.AmbiguousRootParserMessage::className;
  }-*/;

  private native static void _81454575__1195259493_className(AmbiguousRootParserMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.AmbiguousRootParserMessage::className = value;
  }-*/;

  public AmbiguousRootParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AmbiguousRootParserMessage.class, objId);
    }
    AmbiguousRootParserMessage entity = new AmbiguousRootParserMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      _81454575__1195259493_className(entity, java_lang_String.demarshall(obj.get("className"), a1));
    }
    return entity;
  }

  public String marshall(AmbiguousRootParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.AmbiguousRootParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}