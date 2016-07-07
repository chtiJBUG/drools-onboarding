package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.api.model.Message;
import org.kie.server.api.model.Severity;

public class Marshaller_o_k_s_a_m_Message_1_Impl implements GeneratedMarshaller<Message> {
  private Message[] EMPTY_ARRAY = new Message[0];
  private Marshaller<Severity> org_kie_server_api_model_Severity = null;
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public Message[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Message demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Message.class, objId);
    }
    Message entity = new Message();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("severity")) && (!obj.get("severity").isNull())) {
      entity.setSeverity(obj.get("severity").isObject() != null ? Enum.valueOf(Severity.class, obj.get("severity").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("severity").isString() != null ? Enum.valueOf(Severity.class, obj.get("severity").isString().stringValue()) : null);
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      entity.setTimestamp(java_util_Date.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setMessages(java_util_List.demarshall(obj.get("messages"), a1));
    }
    return entity;
  }

  private native static List _559193972__65821278_messages(Message instance) /*-{
    return instance.@org.kie.server.api.model.Message::messages;
  }-*/;

  private native static void _559193972__65821278_messages(Message instance, List<String> value) /*-{
    instance.@org.kie.server.api.model.Message::messages = value;
  }-*/;

  public String marshall(Message a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.api.model.Message\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"severity\":").append(a0.getSeverity() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.Severity\",\"^EnumStringValue\":\"").append(a0.getSeverity().name()).append("\"}") : "null").append(",").append("\"timestamp\":").append(java_util_Date.marshall(a0.getTimestamp(), a1)).append(",").append("\"messages\":").append(java_util_List.marshall(_559193972__65821278_messages(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_api_model_Severity == null) {
      org_kie_server_api_model_Severity = Marshalling.getMarshaller(Severity.class);
    }
  }
}