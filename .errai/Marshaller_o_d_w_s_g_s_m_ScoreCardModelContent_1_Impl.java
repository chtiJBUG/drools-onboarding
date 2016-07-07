package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel;
import org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_g_s_m_ScoreCardModelContent_1_Impl implements GeneratedMarshaller<ScoreCardModelContent> {
  private ScoreCardModelContent[] EMPTY_ARRAY = new ScoreCardModelContent[0];
  private Marshaller<ScoreCardModel> org_drools_workbench_models_guided_scorecard_shared_ScoreCardModel = null;
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public ScoreCardModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ScoreCardModel _$742534048__$1952788636_model(ScoreCardModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::model;
  }-*/;

  private native static void _$742534048__$1952788636_model(ScoreCardModelContent instance, ScoreCardModel value) /*-{
    instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::model = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _$742534048__$174876271_dataModel(ScoreCardModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::dataModel;
  }-*/;

  private native static void _$742534048__$174876271_dataModel(ScoreCardModelContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::dataModel = value;
  }-*/;

  private native static Overview _$742534048__1909091292_overview(ScoreCardModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::overview;
  }-*/;

  private native static void _$742534048__1909091292_overview(ScoreCardModelContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent::overview = value;
  }-*/;

  public ScoreCardModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ScoreCardModelContent.class, objId);
    }
    ScoreCardModelContent entity = new ScoreCardModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _$742534048__$1952788636_model(entity, org_drools_workbench_models_guided_scorecard_shared_ScoreCardModel.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _$742534048__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$742534048__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(ScoreCardModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_models_guided_scorecard_shared_ScoreCardModel.marshall(a0.getModel(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_scorecard_shared_ScoreCardModel == null) {
      org_drools_workbench_models_guided_scorecard_shared_ScoreCardModel = Marshalling.getMarshaller(ScoreCardModel.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}