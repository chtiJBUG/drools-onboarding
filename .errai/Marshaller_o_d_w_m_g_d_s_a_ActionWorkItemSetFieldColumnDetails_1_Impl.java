package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_ActionWorkItemSetFieldColumnDetails_1_Impl implements GeneratedMarshaller<ActionWorkItemSetFieldColumnDetails> {
  private ActionWorkItemSetFieldColumnDetails[] EMPTY_ARRAY = new ActionWorkItemSetFieldColumnDetails[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ActionWorkItemSetFieldColumnDetails[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1890199366__1195259493_boundName(ActionWorkItemSetFieldColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::boundName;
  }-*/;

  private native static void _$1890199366__1195259493_boundName(ActionWorkItemSetFieldColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::boundName = value;
  }-*/;

  private native static String _$1890199366__1195259493_factField(ActionWorkItemSetFieldColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::factField;
  }-*/;

  private native static void _$1890199366__1195259493_factField(ActionWorkItemSetFieldColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::factField = value;
  }-*/;

  private native static String _$1890199366__1195259493_workItemName(ActionWorkItemSetFieldColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::workItemName;
  }-*/;

  private native static void _$1890199366__1195259493_workItemName(ActionWorkItemSetFieldColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::workItemName = value;
  }-*/;

  private native static String _$1890199366__1195259493_workItemResultParameterName(ActionWorkItemSetFieldColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::workItemResultParameterName;
  }-*/;

  private native static void _$1890199366__1195259493_workItemResultParameterName(ActionWorkItemSetFieldColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails::workItemResultParameterName = value;
  }-*/;

  private native static String _$493965940__1195259493_columnHeader(ColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader;
  }-*/;

  private native static void _$493965940__1195259493_columnHeader(ColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader = value;
  }-*/;

  public ActionWorkItemSetFieldColumnDetails demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionWorkItemSetFieldColumnDetails.class, objId);
    }
    ActionWorkItemSetFieldColumnDetails entity = new ActionWorkItemSetFieldColumnDetails();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("boundName")) && (!obj.get("boundName").isNull())) {
      _$1890199366__1195259493_boundName(entity, java_lang_String.demarshall(obj.get("boundName"), a1));
    }
    if ((obj.containsKey("factField")) && (!obj.get("factField").isNull())) {
      _$1890199366__1195259493_factField(entity, java_lang_String.demarshall(obj.get("factField"), a1));
    }
    if ((obj.containsKey("workItemName")) && (!obj.get("workItemName").isNull())) {
      _$1890199366__1195259493_workItemName(entity, java_lang_String.demarshall(obj.get("workItemName"), a1));
    }
    if ((obj.containsKey("workItemResultParameterName")) && (!obj.get("workItemResultParameterName").isNull())) {
      _$1890199366__1195259493_workItemResultParameterName(entity, java_lang_String.demarshall(obj.get("workItemResultParameterName"), a1));
    }
    if ((obj.containsKey("columnHeader")) && (!obj.get("columnHeader").isNull())) {
      _$493965940__1195259493_columnHeader(entity, java_lang_String.demarshall(obj.get("columnHeader"), a1));
    }
    return entity;
  }

  public String marshall(ActionWorkItemSetFieldColumnDetails a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.ActionWorkItemSetFieldColumnDetails\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"factField\":").append(java_lang_String.marshall(a0.getFactField(), a1)).append(",").append("\"workItemName\":").append(java_lang_String.marshall(a0.getWorkItemName(), a1)).append(",").append("\"workItemResultParameterName\":").append(java_lang_String.marshall(a0.getWorkItemResultParameterName(), a1)).append(",").append("\"columnHeader\":").append(java_lang_String.marshall(a0.getColumnHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}