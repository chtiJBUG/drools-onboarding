package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError;
import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.ParserMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_GuidedDecisionTreeParserError_1_Impl implements GeneratedMarshaller<GuidedDecisionTreeParserError> {
  private GuidedDecisionTreeParserError[] EMPTY_ARRAY = new GuidedDecisionTreeParserError[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public GuidedDecisionTreeParserError[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1378044230__1195259493_originalRuleName(GuidedDecisionTreeParserError instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::originalRuleName;
  }-*/;

  private native static void _$1378044230__1195259493_originalRuleName(GuidedDecisionTreeParserError instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::originalRuleName = value;
  }-*/;

  private native static String _$1378044230__1195259493_originalDrl(GuidedDecisionTreeParserError instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::originalDrl;
  }-*/;

  private native static void _$1378044230__1195259493_originalDrl(GuidedDecisionTreeParserError instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::originalDrl = value;
  }-*/;

  private native static List _$1378044230__65821278_messages(GuidedDecisionTreeParserError instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::messages;
  }-*/;

  private native static void _$1378044230__65821278_messages(GuidedDecisionTreeParserError instance, List<ParserMessage> value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError::messages = value;
  }-*/;

  public GuidedDecisionTreeParserError demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedDecisionTreeParserError.class, objId);
    }
    GuidedDecisionTreeParserError entity = new GuidedDecisionTreeParserError();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("originalRuleName")) && (!obj.get("originalRuleName").isNull())) {
      _$1378044230__1195259493_originalRuleName(entity, java_lang_String.demarshall(obj.get("originalRuleName"), a1));
    }
    if ((obj.containsKey("originalDrl")) && (!obj.get("originalDrl").isNull())) {
      _$1378044230__1195259493_originalDrl(entity, java_lang_String.demarshall(obj.get("originalDrl"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtree.shared.model.parser.messages.ParserMessage");
      _$1378044230__65821278_messages(entity, java_util_List.demarshall(obj.get("messages"), a1));
    }
    return entity;
  }

  public String marshall(GuidedDecisionTreeParserError a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"originalRuleName\":").append(java_lang_String.marshall(a0.getOriginalRuleName(), a1)).append(",").append("\"originalDrl\":").append(java_lang_String.marshall(a0.getOriginalDrl(), a1)).append(",").append("\"messages\":").append(java_util_List.marshall(a0.getMessages(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}