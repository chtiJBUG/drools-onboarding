package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.drools.workbench.screens.guided.rule.model.GuidedEditorContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_g_r_m_GuidedEditorContent_1_Impl implements GeneratedMarshaller<GuidedEditorContent> {
  private GuidedEditorContent[] EMPTY_ARRAY = new GuidedEditorContent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  public GuidedEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static RuleModel _376054382__$1288338448_model(GuidedEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::model;
  }-*/;

  private native static void _376054382__$1288338448_model(GuidedEditorContent instance, RuleModel value) /*-{
    instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::model = value;
  }-*/;

  private native static Overview _376054382__1909091292_overview(GuidedEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::overview;
  }-*/;

  private native static void _376054382__1909091292_overview(GuidedEditorContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::overview = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _376054382__$174876271_dataModel(GuidedEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::dataModel;
  }-*/;

  private native static void _376054382__$174876271_dataModel(GuidedEditorContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.guided.rule.model.GuidedEditorContent::dataModel = value;
  }-*/;

  public GuidedEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedEditorContent.class, objId);
    }
    GuidedEditorContent entity = new GuidedEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _376054382__$1288338448_model(entity, (RuleModel) ((ObjectMarshaller) java_lang_Object).demarshall(RuleModel.class, obj.get("model"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _376054382__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _376054382__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    return entity;
  }

  public String marshall(GuidedEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.guided.rule.model.GuidedEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(java_lang_Object.marshall(a0.getModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
  }
}