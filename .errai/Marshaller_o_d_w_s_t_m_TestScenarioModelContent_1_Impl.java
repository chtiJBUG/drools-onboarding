package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.Scenario;
import org.drools.workbench.screens.testscenario.model.TestScenarioModelContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_d_w_s_t_m_TestScenarioModelContent_1_Impl implements GeneratedMarshaller<TestScenarioModelContent> {
  private TestScenarioModelContent[] EMPTY_ARRAY = new TestScenarioModelContent[0];
  private Marshaller<Scenario> org_drools_workbench_models_testscenarios_shared_Scenario = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PackageDataModelOracleBaselinePayload> org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public TestScenarioModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Scenario _$1347045890__$1014422890_scenario(TestScenarioModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::scenario;
  }-*/;

  private native static void _$1347045890__$1014422890_scenario(TestScenarioModelContent instance, Scenario value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::scenario = value;
  }-*/;

  private native static String _$1347045890__1195259493_packageName(TestScenarioModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::packageName;
  }-*/;

  private native static void _$1347045890__1195259493_packageName(TestScenarioModelContent instance, String value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::packageName = value;
  }-*/;

  private native static PackageDataModelOracleBaselinePayload _$1347045890__$174876271_dataModel(TestScenarioModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::dataModel;
  }-*/;

  private native static void _$1347045890__$174876271_dataModel(TestScenarioModelContent instance, PackageDataModelOracleBaselinePayload value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioModelContent::dataModel = value;
  }-*/;

  public TestScenarioModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TestScenarioModelContent.class, objId);
    }
    TestScenarioModelContent entity = new TestScenarioModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("scenario")) && (!obj.get("scenario").isNull())) {
      _$1347045890__$1014422890_scenario(entity, org_drools_workbench_models_testscenarios_shared_Scenario.demarshall(obj.get("scenario"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      _$1347045890__1195259493_packageName(entity, java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      _$1347045890__$174876271_dataModel(entity, org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.demarshall(obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(TestScenarioModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.testscenario.model.TestScenarioModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"scenario\":").append(org_drools_workbench_models_testscenarios_shared_Scenario.marshall(a0.getScenario(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"dataModel\":").append(org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload.marshall(a0.getDataModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_testscenarios_shared_Scenario == null) {
      org_drools_workbench_models_testscenarios_shared_Scenario = Marshalling.getMarshaller(Scenario.class);
    }
    if (org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload == null) {
      org_kie_workbench_common_services_datamodel_model_PackageDataModelOracleBaselinePayload = Marshalling.getMarshaller(PackageDataModelOracleBaselinePayload.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}