package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.drools.workbench.models.testscenarios.shared.Scenario;
import org.drools.workbench.screens.testscenario.model.TestScenarioResult;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_t_m_TestScenarioResult_1_Impl implements GeneratedMarshaller<TestScenarioResult> {
  private TestScenarioResult[] EMPTY_ARRAY = new TestScenarioResult[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Scenario> org_drools_workbench_models_testscenarios_shared_Scenario = null;
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public TestScenarioResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1169315957__1195259493_identifier(TestScenarioResult instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::identifier;
  }-*/;

  private native static void _$1169315957__1195259493_identifier(TestScenarioResult instance, String value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::identifier = value;
  }-*/;

  private native static Scenario _$1169315957__$1014422890_scenario(TestScenarioResult instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::scenario;
  }-*/;

  private native static void _$1169315957__$1014422890_scenario(TestScenarioResult instance, Scenario value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::scenario = value;
  }-*/;

  private native static Set _$1169315957__$1383343454_log(TestScenarioResult instance) /*-{
    return instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::log;
  }-*/;

  private native static void _$1169315957__$1383343454_log(TestScenarioResult instance, Set<String> value) /*-{
    instance.@org.drools.workbench.screens.testscenario.model.TestScenarioResult::log = value;
  }-*/;

  public TestScenarioResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TestScenarioResult.class, objId);
    }
    TestScenarioResult entity = new TestScenarioResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("identifier")) && (!obj.get("identifier").isNull())) {
      _$1169315957__1195259493_identifier(entity, java_lang_String.demarshall(obj.get("identifier"), a1));
    }
    if ((obj.containsKey("scenario")) && (!obj.get("scenario").isNull())) {
      _$1169315957__$1014422890_scenario(entity, org_drools_workbench_models_testscenarios_shared_Scenario.demarshall(obj.get("scenario"), a1));
    }
    if ((obj.containsKey("log")) && (!obj.get("log").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1169315957__$1383343454_log(entity, java_util_Set.demarshall(obj.get("log"), a1));
    }
    return entity;
  }

  public String marshall(TestScenarioResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.testscenario.model.TestScenarioResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"identifier\":").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"scenario\":").append(org_drools_workbench_models_testscenarios_shared_Scenario.marshall(a0.getScenario(), a1)).append(",").append("\"log\":").append(java_util_Set.marshall(a0.getLog(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_testscenarios_shared_Scenario == null) {
      org_drools_workbench_models_testscenarios_shared_Scenario = Marshalling.getMarshaller(Scenario.class);
    }
  }
}