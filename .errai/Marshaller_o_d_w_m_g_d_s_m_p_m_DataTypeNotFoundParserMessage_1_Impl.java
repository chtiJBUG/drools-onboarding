package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_p_m_DataTypeNotFoundParserMessage_1_Impl implements GeneratedMarshaller<DataTypeNotFoundParserMessage> {
  private DataTypeNotFoundParserMessage[] EMPTY_ARRAY = new DataTypeNotFoundParserMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DataTypeNotFoundParserMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1453178496__1195259493_className(DataTypeNotFoundParserMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage::className;
  }-*/;

  private native static void _$1453178496__1195259493_className(DataTypeNotFoundParserMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage::className = value;
  }-*/;

  private native static String _$1453178496__1195259493_fieldName(DataTypeNotFoundParserMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage::fieldName;
  }-*/;

  private native static void _$1453178496__1195259493_fieldName(DataTypeNotFoundParserMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage::fieldName = value;
  }-*/;

  public DataTypeNotFoundParserMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataTypeNotFoundParserMessage.class, objId);
    }
    DataTypeNotFoundParserMessage entity = new DataTypeNotFoundParserMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      _$1453178496__1195259493_className(entity, java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      _$1453178496__1195259493_fieldName(entity, java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    return entity;
  }

  public String marshall(DataTypeNotFoundParserMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.parser.messages.DataTypeNotFoundParserMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}