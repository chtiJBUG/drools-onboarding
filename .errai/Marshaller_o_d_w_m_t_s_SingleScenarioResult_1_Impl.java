package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.testscenarios.shared.ScenarioRunResult;
import org.drools.workbench.models.testscenarios.shared.SingleScenarioResult;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_SingleScenarioResult_1_Impl implements GeneratedMarshaller<SingleScenarioResult> {
  private SingleScenarioResult[] EMPTY_ARRAY = new SingleScenarioResult[0];
  private Marshaller<ScenarioRunResult> org_drools_workbench_models_testscenarios_shared_ScenarioRunResult = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public SingleScenarioResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ScenarioRunResult _$1399012293__1327145106_result(SingleScenarioResult instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.SingleScenarioResult::result;
  }-*/;

  private native static void _$1399012293__1327145106_result(SingleScenarioResult instance, ScenarioRunResult value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.SingleScenarioResult::result = value;
  }-*/;

  private native static List _$1399012293__65821278_auditLog(SingleScenarioResult instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.SingleScenarioResult::auditLog;
  }-*/;

  private native static void _$1399012293__65821278_auditLog(SingleScenarioResult instance, List<String[]> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.SingleScenarioResult::auditLog = value;
  }-*/;

  public SingleScenarioResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SingleScenarioResult.class, objId);
    }
    SingleScenarioResult entity = new SingleScenarioResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("result")) && (!obj.get("result").isNull())) {
      _$1399012293__1327145106_result(entity, org_drools_workbench_models_testscenarios_shared_ScenarioRunResult.demarshall(obj.get("result"), a1));
    }
    if ((obj.containsKey("auditLog")) && (!obj.get("auditLog").isNull())) {
      a1.setAssumedElementType("[Ljava.lang.String;");
      _$1399012293__65821278_auditLog(entity, java_util_List.demarshall(obj.get("auditLog"), a1));
    }
    return entity;
  }

  public String marshall(SingleScenarioResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.SingleScenarioResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"result\":").append(org_drools_workbench_models_testscenarios_shared_ScenarioRunResult.marshall(a0.getResult(), a1)).append(",").append("\"auditLog\":").append(java_util_List.marshall(a0.getAuditLog(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_testscenarios_shared_ScenarioRunResult == null) {
      org_drools_workbench_models_testscenarios_shared_ScenarioRunResult = Marshalling.getMarshaller(ScenarioRunResult.class);
    }
  }
}