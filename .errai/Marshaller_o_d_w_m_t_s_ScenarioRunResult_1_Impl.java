package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.testscenarios.shared.BuilderResultLine;
import org.drools.workbench.models.testscenarios.shared.Scenario;
import org.drools.workbench.models.testscenarios.shared.ScenarioRunResult;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_ScenarioRunResult_1_Impl implements GeneratedMarshaller<ScenarioRunResult> {
  private ScenarioRunResult[] EMPTY_ARRAY = new ScenarioRunResult[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Scenario> org_drools_workbench_models_testscenarios_shared_Scenario = null;
  public ScenarioRunResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1327145106__65821278_errors(ScenarioRunResult instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.ScenarioRunResult::errors;
  }-*/;

  private native static void _1327145106__65821278_errors(ScenarioRunResult instance, List<BuilderResultLine> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.ScenarioRunResult::errors = value;
  }-*/;

  private native static Scenario _1327145106__$1014422890_scenario(ScenarioRunResult instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.ScenarioRunResult::scenario;
  }-*/;

  private native static void _1327145106__$1014422890_scenario(ScenarioRunResult instance, Scenario value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.ScenarioRunResult::scenario = value;
  }-*/;

  public ScenarioRunResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ScenarioRunResult.class, objId);
    }
    ScenarioRunResult entity = new ScenarioRunResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.BuilderResultLine");
      _1327145106__65821278_errors(entity, java_util_List.demarshall(obj.get("errors"), a1));
    }
    if ((obj.containsKey("scenario")) && (!obj.get("scenario").isNull())) {
      _1327145106__$1014422890_scenario(entity, org_drools_workbench_models_testscenarios_shared_Scenario.demarshall(obj.get("scenario"), a1));
    }
    return entity;
  }

  public String marshall(ScenarioRunResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.ScenarioRunResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append(",").append("\"scenario\":").append(org_drools_workbench_models_testscenarios_shared_Scenario.marshall(a0.getScenario(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_testscenarios_shared_Scenario == null) {
      org_drools_workbench_models_testscenarios_shared_Scenario = Marshalling.getMarshaller(Scenario.class);
    }
  }
}