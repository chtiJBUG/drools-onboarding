package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.template.shared.TemplateModel;
import org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_g_t_m_GuidedTemplateEditorContent_1_Impl implements GeneratedMarshaller<GuidedTemplateEditorContent> {
  private GuidedTemplateEditorContent[] EMPTY_ARRAY = new GuidedTemplateEditorContent[0];
  private Marshaller<TemplateModel> org_drools_workbench_models_guided_template_shared_TemplateModel = null;
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public GuidedTemplateEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static TemplateModel _510019474__$772284102_model(GuidedTemplateEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::model;
  }-*/;

  private native static void _510019474__$772284102_model(GuidedTemplateEditorContent instance, TemplateModel value) /*-{
    instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::model = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _510019474__$174876271_dataModel(GuidedTemplateEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::dataModel;
  }-*/;

  private native static void _510019474__$174876271_dataModel(GuidedTemplateEditorContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::dataModel = value;
  }-*/;

  private native static Overview _510019474__1909091292_overview(GuidedTemplateEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::overview;
  }-*/;

  private native static void _510019474__1909091292_overview(GuidedTemplateEditorContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent::overview = value;
  }-*/;

  public GuidedTemplateEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedTemplateEditorContent.class, objId);
    }
    GuidedTemplateEditorContent entity = new GuidedTemplateEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _510019474__$772284102_model(entity, org_drools_workbench_models_guided_template_shared_TemplateModel.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _510019474__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _510019474__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(GuidedTemplateEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_models_guided_template_shared_TemplateModel.marshall(a0.getModel(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_template_shared_TemplateModel == null) {
      org_drools_workbench_models_guided_template_shared_TemplateModel = Marshalling.getMarshaller(TemplateModel.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}