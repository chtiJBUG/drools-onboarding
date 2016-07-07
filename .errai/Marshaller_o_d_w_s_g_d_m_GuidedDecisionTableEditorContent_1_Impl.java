package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_g_d_m_GuidedDecisionTableEditorContent_1_Impl implements GeneratedMarshaller<GuidedDecisionTableEditorContent> {
  private GuidedDecisionTableEditorContent[] EMPTY_ARRAY = new GuidedDecisionTableEditorContent[0];
  private Marshaller<GuidedDecisionTable52> org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52 = null;
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public GuidedDecisionTableEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GuidedDecisionTable52 _1162736330__200646685_model(GuidedDecisionTableEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::model;
  }-*/;

  private native static void _1162736330__200646685_model(GuidedDecisionTableEditorContent instance, GuidedDecisionTable52 value) /*-{
    instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::model = value;
  }-*/;

  private native static Set _1162736330__$1383343454_workItemDefinitions(GuidedDecisionTableEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::workItemDefinitions;
  }-*/;

  private native static void _1162736330__$1383343454_workItemDefinitions(GuidedDecisionTableEditorContent instance, Set<PortableWorkDefinition> value) /*-{
    instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::workItemDefinitions = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _1162736330__$174876271_dataModel(GuidedDecisionTableEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::dataModel;
  }-*/;

  private native static void _1162736330__$174876271_dataModel(GuidedDecisionTableEditorContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent::dataModel = value;
  }-*/;

  public GuidedDecisionTableEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedDecisionTableEditorContent.class, objId);
    }
    GuidedDecisionTableEditorContent entity = new GuidedDecisionTableEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _1162736330__200646685_model(entity, org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("workItemDefinitions")) && (!obj.get("workItemDefinitions").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition");
      _1162736330__$1383343454_workItemDefinitions(entity, java_util_Set.demarshall(obj.get("workItemDefinitions"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _1162736330__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(GuidedDecisionTableEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52.marshall(a0.getModel(), a1)).append(",").append("\"workItemDefinitions\":").append(java_util_Set.marshall(a0.getWorkItemDefinitions(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52 == null) {
      org_drools_workbench_models_guided_dtable_shared_model_GuidedDecisionTable52 = Marshalling.getMarshaller(GuidedDecisionTable52.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}