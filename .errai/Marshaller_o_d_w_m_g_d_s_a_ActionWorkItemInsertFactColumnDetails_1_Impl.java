package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_ActionWorkItemInsertFactColumnDetails_1_Impl implements GeneratedMarshaller<ActionWorkItemInsertFactColumnDetails> {
  private ActionWorkItemInsertFactColumnDetails[] EMPTY_ARRAY = new ActionWorkItemInsertFactColumnDetails[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ActionWorkItemInsertFactColumnDetails[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$428112563__1195259493_factType(ActionWorkItemInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::factType;
  }-*/;

  private native static void _$428112563__1195259493_factType(ActionWorkItemInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::factType = value;
  }-*/;

  private native static String _$428112563__1195259493_factField(ActionWorkItemInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::factField;
  }-*/;

  private native static void _$428112563__1195259493_factField(ActionWorkItemInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::factField = value;
  }-*/;

  private native static String _$428112563__1195259493_workItemName(ActionWorkItemInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::workItemName;
  }-*/;

  private native static void _$428112563__1195259493_workItemName(ActionWorkItemInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::workItemName = value;
  }-*/;

  private native static String _$428112563__1195259493_workItemResultParameterName(ActionWorkItemInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::workItemResultParameterName;
  }-*/;

  private native static void _$428112563__1195259493_workItemResultParameterName(ActionWorkItemInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails::workItemResultParameterName = value;
  }-*/;

  private native static String _$493965940__1195259493_columnHeader(ColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader;
  }-*/;

  private native static void _$493965940__1195259493_columnHeader(ColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader = value;
  }-*/;

  public ActionWorkItemInsertFactColumnDetails demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionWorkItemInsertFactColumnDetails.class, objId);
    }
    ActionWorkItemInsertFactColumnDetails entity = new ActionWorkItemInsertFactColumnDetails();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      _$428112563__1195259493_factType(entity, java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("factField")) && (!obj.get("factField").isNull())) {
      _$428112563__1195259493_factField(entity, java_lang_String.demarshall(obj.get("factField"), a1));
    }
    if ((obj.containsKey("workItemName")) && (!obj.get("workItemName").isNull())) {
      _$428112563__1195259493_workItemName(entity, java_lang_String.demarshall(obj.get("workItemName"), a1));
    }
    if ((obj.containsKey("workItemResultParameterName")) && (!obj.get("workItemResultParameterName").isNull())) {
      _$428112563__1195259493_workItemResultParameterName(entity, java_lang_String.demarshall(obj.get("workItemResultParameterName"), a1));
    }
    if ((obj.containsKey("columnHeader")) && (!obj.get("columnHeader").isNull())) {
      _$493965940__1195259493_columnHeader(entity, java_lang_String.demarshall(obj.get("columnHeader"), a1));
    }
    return entity;
  }

  public String marshall(ActionWorkItemInsertFactColumnDetails a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemInsertFactColumnDetails\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"factField\":").append(java_lang_String.marshall(a0.getFactField(), a1)).append(",").append("\"workItemName\":").append(java_lang_String.marshall(a0.getWorkItemName(), a1)).append(",").append("\"workItemResultParameterName\":").append(java_lang_String.marshall(a0.getWorkItemResultParameterName(), a1)).append(",").append("\"columnHeader\":").append(java_lang_String.marshall(a0.getColumnHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}