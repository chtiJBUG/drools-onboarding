package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree;
import org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_g_d_m_GuidedDecisionTreeEditorContent_1_Impl implements GeneratedMarshaller<GuidedDecisionTreeEditorContent> {
  private GuidedDecisionTreeEditorContent[] EMPTY_ARRAY = new GuidedDecisionTreeEditorContent[0];
  private Marshaller<GuidedDecisionTree> org_drools_workbench_models_guided_dtree_shared_model_GuidedDecisionTree = null;
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public GuidedDecisionTreeEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GuidedDecisionTree _1001706392__2075966084_model(GuidedDecisionTreeEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent::model;
  }-*/;

  private native static void _1001706392__2075966084_model(GuidedDecisionTreeEditorContent instance, GuidedDecisionTree value) /*-{
    instance.@org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent::model = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _1001706392__$174876271_dataModel(GuidedDecisionTreeEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent::dataModel;
  }-*/;

  private native static void _1001706392__$174876271_dataModel(GuidedDecisionTreeEditorContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent::dataModel = value;
  }-*/;

  public GuidedDecisionTreeEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedDecisionTreeEditorContent.class, objId);
    }
    GuidedDecisionTreeEditorContent entity = new GuidedDecisionTreeEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _1001706392__2075966084_model(entity, org_drools_workbench_models_guided_dtree_shared_model_GuidedDecisionTree.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _1001706392__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(GuidedDecisionTreeEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_models_guided_dtree_shared_model_GuidedDecisionTree.marshall(a0.getModel(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtree_shared_model_GuidedDecisionTree == null) {
      org_drools_workbench_models_guided_dtree_shared_model_GuidedDecisionTree = Marshalling.getMarshaller(GuidedDecisionTree.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}