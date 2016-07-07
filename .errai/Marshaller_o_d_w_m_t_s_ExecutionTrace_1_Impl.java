package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.Date;
import org.drools.workbench.models.testscenarios.shared.ExecutionTrace;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_t_s_ExecutionTrace_1_Impl implements GeneratedMarshaller<ExecutionTrace> {
  private ExecutionTrace[] EMPTY_ARRAY = new ExecutionTrace[0];
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  public ExecutionTrace[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ExecutionTrace demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ExecutionTrace.class, objId);
    }
    ExecutionTrace entity = new ExecutionTrace();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("scenarioSimulatedDate")) && (!obj.get("scenarioSimulatedDate").isNull())) {
      entity.setScenarioSimulatedDate(java_util_Date.demarshall(obj.get("scenarioSimulatedDate"), a1));
    }
    if ((obj.containsKey("executionTimeResult")) && (!obj.get("executionTimeResult").isNull())) {
      entity.setExecutionTimeResult(java_lang_Long.demarshall(obj.get("executionTimeResult"), a1));
    }
    if ((obj.containsKey("numberOfRulesFired")) && (!obj.get("numberOfRulesFired").isNull())) {
      entity.setNumberOfRulesFired(java_lang_Long.demarshall(obj.get("numberOfRulesFired"), a1));
    }
    if ((obj.containsKey("rulesFired")) && (!obj.get("rulesFired").isNull())) {
      entity.setRulesFired(arrayOf_java_lang_String_D1.demarshall(obj.get("rulesFired"), a1));
    }
    return entity;
  }

  public String marshall(ExecutionTrace a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.ExecutionTrace\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"scenarioSimulatedDate\":").append(java_util_Date.marshall(a0.getScenarioSimulatedDate(), a1)).append(",").append("\"executionTimeResult\":").append(java_lang_Long.marshall(a0.getExecutionTimeResult(), a1)).append(",").append("\"numberOfRulesFired\":").append(java_lang_Long.marshall(a0.getNumberOfRulesFired(), a1)).append(",").append("\"rulesFired\":").append(arrayOf_java_lang_String_D1.marshall(a0.getRulesFired(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}