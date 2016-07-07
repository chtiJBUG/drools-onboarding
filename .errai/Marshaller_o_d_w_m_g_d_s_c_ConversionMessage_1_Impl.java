package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage;
import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessageType;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_c_ConversionMessage_1_Impl implements GeneratedMarshaller<ConversionMessage> {
  private ConversionMessage[] EMPTY_ARRAY = new ConversionMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ConversionMessageType> org_drools_workbench_models_guided_dtable_shared_conversion_ConversionMessageType = null;
  public ConversionMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1010997918__1195259493_message(ConversionMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage::message;
  }-*/;

  private native static void _1010997918__1195259493_message(ConversionMessage instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage::message = value;
  }-*/;

  private native static ConversionMessageType _1010997918__$834658568_messageType(ConversionMessage instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage::messageType;
  }-*/;

  private native static void _1010997918__$834658568_messageType(ConversionMessage instance, ConversionMessageType value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage::messageType = value;
  }-*/;

  public ConversionMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ConversionMessage.class, objId);
    }
    ConversionMessage entity = new ConversionMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _1010997918__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    if ((obj.containsKey("messageType")) && (!obj.get("messageType").isNull())) {
      _1010997918__$834658568_messageType(entity, obj.get("messageType").isObject() != null ? Enum.valueOf(ConversionMessageType.class, obj.get("messageType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("messageType").isString() != null ? Enum.valueOf(ConversionMessageType.class, obj.get("messageType").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(ConversionMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"messageType\":").append(a0.getMessageType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessageType\",\"^EnumStringValue\":\"").append(a0.getMessageType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtable_shared_conversion_ConversionMessageType == null) {
      org_drools_workbench_models_guided_dtable_shared_conversion_ConversionMessageType = Marshalling.getMarshaller(ConversionMessageType.class);
    }
  }
}