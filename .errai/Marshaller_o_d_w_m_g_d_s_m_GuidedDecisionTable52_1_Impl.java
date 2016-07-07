package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.auditlog.AuditLog;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.guided.dtable.shared.model.CompositeColumn;
import org.drools.workbench.models.guided.dtable.shared.model.DescriptionCol52;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52.TableFormat;
import org.drools.workbench.models.guided.dtable.shared.model.RowNumberCol52;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_GuidedDecisionTable52_1_Impl implements GeneratedMarshaller<GuidedDecisionTable52> {
  private GuidedDecisionTable52[] EMPTY_ARRAY = new GuidedDecisionTable52[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<RowNumberCol52> org_drools_workbench_models_guided_dtable_shared_model_RowNumberCol52 = null;
  private Marshaller<DescriptionCol52> org_drools_workbench_models_guided_dtable_shared_model_DescriptionCol52 = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<AuditLog> org_drools_workbench_models_datamodel_auditlog_AuditLog = null;
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<TableFormat> org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52_erraiD_TableFormat = null;
  public GuidedDecisionTable52[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static AuditLog _200646685__1600951609_auditLog(GuidedDecisionTable52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52::auditLog;
  }-*/;

  private native static void _200646685__1600951609_auditLog(GuidedDecisionTable52 instance, AuditLog value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52::auditLog = value;
  }-*/;

  public GuidedDecisionTable52 demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedDecisionTable52.class, objId);
    }
    GuidedDecisionTable52 entity = new GuidedDecisionTable52();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("tableName")) && (!obj.get("tableName").isNull())) {
      entity.setTableName(java_lang_String.demarshall(obj.get("tableName"), a1));
    }
    if ((obj.containsKey("parentName")) && (!obj.get("parentName").isNull())) {
      entity.setParentName(java_lang_String.demarshall(obj.get("parentName"), a1));
    }
    if ((obj.containsKey("rowNumberCol")) && (!obj.get("rowNumberCol").isNull())) {
      entity.setRowNumberCol(org_drools_workbench_models_guided_dtable_shared_model_RowNumberCol52.demarshall(obj.get("rowNumberCol"), a1));
    }
    if ((obj.containsKey("descriptionCol")) && (!obj.get("descriptionCol").isNull())) {
      entity.setDescriptionCol(org_drools_workbench_models_guided_dtable_shared_model_DescriptionCol52.demarshall(obj.get("descriptionCol"), a1));
    }
    if ((obj.containsKey("metadataCols")) && (!obj.get("metadataCols").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.model.MetadataCol52");
      entity.setMetadataCols(java_util_List.demarshall(obj.get("metadataCols"), a1));
    }
    if ((obj.containsKey("attributeCols")) && (!obj.get("attributeCols").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.model.AttributeCol52");
      entity.setAttributeCols(java_util_List.demarshall(obj.get("attributeCols"), a1));
    }
    if ((obj.containsKey("conditionPatterns")) && (!obj.get("conditionPatterns").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.model.CompositeColumn");
      entity.setConditionPatterns(java_util_List.demarshall(obj.get("conditionPatterns"), a1));
    }
    if ((obj.containsKey("actionCols")) && (!obj.get("actionCols").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.model.ActionCol52");
      entity.setActionCols(java_util_List.demarshall(obj.get("actionCols"), a1));
    }
    if ((obj.containsKey("auditLog")) && (!obj.get("auditLog").isNull())) {
      _200646685__1600951609_auditLog(entity, org_drools_workbench_models_datamodel_auditlog_AuditLog.demarshall(obj.get("auditLog"), a1));
    }
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("tableFormat")) && (!obj.get("tableFormat").isNull())) {
      entity.setTableFormat(obj.get("tableFormat").isObject() != null ? Enum.valueOf(TableFormat.class, obj.get("tableFormat").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("tableFormat").isString() != null ? Enum.valueOf(TableFormat.class, obj.get("tableFormat").isString().stringValue()) : null);
    }
    if ((obj.containsKey("data")) && (!obj.get("data").isNull())) {
      a1.setAssumedElementType("java.util.List");
      entity.setData(java_util_List.demarshall(obj.get("data"), a1));
    }
    return entity;
  }

  private native static List _200646685__65821278_conditionPatterns(GuidedDecisionTable52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52::conditionPatterns;
  }-*/;

  private native static void _200646685__65821278_conditionPatterns(GuidedDecisionTable52 instance, List<CompositeColumn> value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52::conditionPatterns = value;
  }-*/;

  public String marshall(GuidedDecisionTable52 a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"tableName\":").append(java_lang_String.marshall(a0.getTableName(), a1)).append(",").append("\"parentName\":").append(java_lang_String.marshall(a0.getParentName(), a1)).append(",").append("\"rowNumberCol\":").append(org_drools_workbench_models_guided_dtable_shared_model_RowNumberCol52.marshall(a0.getRowNumberCol(), a1)).append(",").append("\"descriptionCol\":").append(org_drools_workbench_models_guided_dtable_shared_model_DescriptionCol52.marshall(a0.getDescriptionCol(), a1)).append(",").append("\"metadataCols\":").append(java_util_List.marshall(a0.getMetadataCols(), a1)).append(",").append("\"attributeCols\":").append(java_util_List.marshall(a0.getAttributeCols(), a1)).append(",").append("\"conditionPatterns\":").append(java_util_List.marshall(_200646685__65821278_conditionPatterns(a0), a1)).append(",").append("\"actionCols\":").append(java_util_List.marshall(a0.getActionCols(), a1)).append(",").append("\"auditLog\":").append(org_drools_workbench_models_datamodel_auditlog_AuditLog.marshall(a0.getAuditLog(), a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"tableFormat\":").append(a0.getTableFormat() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52$TableFormat\",\"^EnumStringValue\":\"").append(a0.getTableFormat().name()).append("\"}") : "null").append(",").append("\"data\":").append(java_util_List.marshall(a0.getData(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtable_shared_model_RowNumberCol52 == null) {
      org_drools_workbench_models_guided_dtable_shared_model_RowNumberCol52 = Marshalling.getMarshaller(RowNumberCol52.class);
    }
    if (org_drools_workbench_models_guided_dtable_shared_model_DescriptionCol52 == null) {
      org_drools_workbench_models_guided_dtable_shared_model_DescriptionCol52 = Marshalling.getMarshaller(DescriptionCol52.class);
    }
    if (org_drools_workbench_models_datamodel_auditlog_AuditLog == null) {
      org_drools_workbench_models_datamodel_auditlog_AuditLog = Marshalling.getMarshaller(AuditLog.class);
    }
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
    if (org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52_erraiD_TableFormat == null) {
      org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52_erraiD_TableFormat = Marshalling.getMarshaller(TableFormat.class);
    }
  }
}