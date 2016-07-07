package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.NodeInstanceSummary;

public class Marshaller_o_j_c_n_p_m_NodeInstanceSummary_1_Impl implements GeneratedMarshaller<NodeInstanceSummary> {
  private NodeInstanceSummary[] EMPTY_ARRAY = new NodeInstanceSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public NodeInstanceSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$374966739__1195259493_nodeUniqueName(NodeInstanceSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.NodeInstanceSummary::nodeUniqueName;
  }-*/;

  private native static void _$374966739__1195259493_nodeUniqueName(NodeInstanceSummary instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.NodeInstanceSummary::nodeUniqueName = value;
  }-*/;

  public NodeInstanceSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NodeInstanceSummary.class, objId);
    }
    NodeInstanceSummary entity = new NodeInstanceSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("processId")) && (!obj.get("processId").isNull())) {
      entity.setProcessId(java_lang_Long.demarshall(obj.get("processId"), a1));
    }
    if ((obj.containsKey("nodeName")) && (!obj.get("nodeName").isNull())) {
      entity.setNodeName(java_lang_String.demarshall(obj.get("nodeName"), a1));
    }
    if ((obj.containsKey("nodeUniqueName")) && (!obj.get("nodeUniqueName").isNull())) {
      _$374966739__1195259493_nodeUniqueName(entity, java_lang_String.demarshall(obj.get("nodeUniqueName"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      entity.setTimestamp(java_lang_String.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("connection")) && (!obj.get("connection").isNull())) {
      entity.setConnection(java_lang_String.demarshall(obj.get("connection"), a1));
    }
    if ((obj.containsKey("completed")) && (!obj.get("completed").isNull())) {
      entity.setCompleted(java_lang_Boolean.demarshall(obj.get("completed"), a1));
    }
    return entity;
  }

  private native static boolean _$374966739__64711720_completed(NodeInstanceSummary instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.NodeInstanceSummary::completed;
  }-*/;

  private native static void _$374966739__64711720_completed(NodeInstanceSummary instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.pr.model.NodeInstanceSummary::completed = value;
  }-*/;

  public String marshall(NodeInstanceSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.NodeInstanceSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"processId\":").append(java_lang_Long.marshall(a0.getProcessId(), a1)).append(",").append("\"nodeName\":").append(java_lang_String.marshall(a0.getNodeName(), a1)).append(",").append("\"nodeUniqueName\":").append(java_lang_String.marshall(a0.getNodeUniqueName(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"timestamp\":").append(java_lang_String.marshall(a0.getTimestamp(), a1)).append(",").append("\"connection\":").append(java_lang_String.marshall(a0.getConnection(), a1)).append(",").append("\"completed\":").append(java_lang_Boolean.marshall(_$374966739__64711720_completed(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}