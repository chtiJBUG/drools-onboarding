package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.TerminationCompositionStyleModel;
import org.optaplanner.workbench.screens.solver.model.TerminationConfigModel;

public class Marshaller_o_o_w_s_s_m_TerminationConfigModel_1_Impl implements GeneratedMarshaller<TerminationConfigModel> {
  private TerminationConfigModel[] EMPTY_ARRAY = new TerminationConfigModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<TerminationCompositionStyleModel> org_optaplanner_workbench_screens_solver_model_TerminationCompositionStyleModel = null;
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public TerminationConfigModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TerminationConfigModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TerminationConfigModel.class, objId);
    }
    TerminationConfigModel entity = new TerminationConfigModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("terminationClass")) && (!obj.get("terminationClass").isNull())) {
      entity.setTerminationClass(java_lang_String.demarshall(obj.get("terminationClass"), a1));
    }
    if ((obj.containsKey("terminationCompositionStyle")) && (!obj.get("terminationCompositionStyle").isNull())) {
      entity.setTerminationCompositionStyle(obj.get("terminationCompositionStyle").isObject() != null ? Enum.valueOf(TerminationCompositionStyleModel.class, obj.get("terminationCompositionStyle").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("terminationCompositionStyle").isString() != null ? Enum.valueOf(TerminationCompositionStyleModel.class, obj.get("terminationCompositionStyle").isString().stringValue()) : null);
    }
    if ((obj.containsKey("millisecondsSpentLimit")) && (!obj.get("millisecondsSpentLimit").isNull())) {
      entity.setMillisecondsSpentLimit(java_lang_Long.demarshall(obj.get("millisecondsSpentLimit"), a1));
    }
    if ((obj.containsKey("secondsSpentLimit")) && (!obj.get("secondsSpentLimit").isNull())) {
      entity.setSecondsSpentLimit(java_lang_Long.demarshall(obj.get("secondsSpentLimit"), a1));
    }
    if ((obj.containsKey("minutesSpentLimit")) && (!obj.get("minutesSpentLimit").isNull())) {
      entity.setMinutesSpentLimit(java_lang_Long.demarshall(obj.get("minutesSpentLimit"), a1));
    }
    if ((obj.containsKey("hoursSpentLimit")) && (!obj.get("hoursSpentLimit").isNull())) {
      entity.setHoursSpentLimit(java_lang_Long.demarshall(obj.get("hoursSpentLimit"), a1));
    }
    if ((obj.containsKey("unimprovedMillisecondsSpentLimit")) && (!obj.get("unimprovedMillisecondsSpentLimit").isNull())) {
      entity.setUnimprovedMillisecondsSpentLimit(java_lang_Long.demarshall(obj.get("unimprovedMillisecondsSpentLimit"), a1));
    }
    if ((obj.containsKey("unimprovedSecondsSpentLimit")) && (!obj.get("unimprovedSecondsSpentLimit").isNull())) {
      entity.setUnimprovedSecondsSpentLimit(java_lang_Long.demarshall(obj.get("unimprovedSecondsSpentLimit"), a1));
    }
    if ((obj.containsKey("unimprovedMinutesSpentLimit")) && (!obj.get("unimprovedMinutesSpentLimit").isNull())) {
      entity.setUnimprovedMinutesSpentLimit(java_lang_Long.demarshall(obj.get("unimprovedMinutesSpentLimit"), a1));
    }
    if ((obj.containsKey("unimprovedHoursSpentLimit")) && (!obj.get("unimprovedHoursSpentLimit").isNull())) {
      entity.setUnimprovedHoursSpentLimit(java_lang_Long.demarshall(obj.get("unimprovedHoursSpentLimit"), a1));
    }
    if ((obj.containsKey("bestScoreLimit")) && (!obj.get("bestScoreLimit").isNull())) {
      entity.setBestScoreLimit(java_lang_String.demarshall(obj.get("bestScoreLimit"), a1));
    }
    if ((obj.containsKey("bestScoreFeasible")) && (!obj.get("bestScoreFeasible").isNull())) {
      entity.setBestScoreFeasible(java_lang_Boolean.demarshall(obj.get("bestScoreFeasible"), a1));
    }
    if ((obj.containsKey("stepCountLimit")) && (!obj.get("stepCountLimit").isNull())) {
      entity.setStepCountLimit(java_lang_Integer.demarshall(obj.get("stepCountLimit"), a1));
    }
    if ((obj.containsKey("unimprovedStepCountLimit")) && (!obj.get("unimprovedStepCountLimit").isNull())) {
      entity.setUnimprovedStepCountLimit(java_lang_Integer.demarshall(obj.get("unimprovedStepCountLimit"), a1));
    }
    if ((obj.containsKey("terminationConfigList")) && (!obj.get("terminationConfigList").isNull())) {
      a1.setAssumedElementType("org.optaplanner.workbench.screens.solver.model.TerminationConfigModel");
      entity.setTerminationConfigList(java_util_List.demarshall(obj.get("terminationConfigList"), a1));
    }
    if ((obj.containsKey("daysSpentLimit")) && (!obj.get("daysSpentLimit").isNull())) {
      entity.setDaysSpentLimit(java_lang_Long.demarshall(obj.get("daysSpentLimit"), a1));
    }
    if ((obj.containsKey("unimprovedDaysSpentLimit")) && (!obj.get("unimprovedDaysSpentLimit").isNull())) {
      entity.setUnimprovedDaysSpentLimit(java_lang_Long.demarshall(obj.get("unimprovedDaysSpentLimit"), a1));
    }
    return entity;
  }

  public String marshall(TerminationConfigModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.TerminationConfigModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"terminationClass\":").append(java_lang_String.marshall(a0.getTerminationClass(), a1)).append(",").append("\"terminationCompositionStyle\":").append(a0.getTerminationCompositionStyle() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.TerminationCompositionStyleModel\",\"^EnumStringValue\":\"").append(a0.getTerminationCompositionStyle().name()).append("\"}") : "null").append(",").append("\"millisecondsSpentLimit\":").append(java_lang_Long.marshall(a0.getMillisecondsSpentLimit(), a1)).append(",").append("\"secondsSpentLimit\":").append(java_lang_Long.marshall(a0.getSecondsSpentLimit(), a1)).append(",").append("\"minutesSpentLimit\":").append(java_lang_Long.marshall(a0.getMinutesSpentLimit(), a1)).append(",").append("\"hoursSpentLimit\":").append(java_lang_Long.marshall(a0.getHoursSpentLimit(), a1)).append(",").append("\"unimprovedMillisecondsSpentLimit\":").append(java_lang_Long.marshall(a0.getUnimprovedMillisecondsSpentLimit(), a1)).append(",").append("\"unimprovedSecondsSpentLimit\":").append(java_lang_Long.marshall(a0.getUnimprovedSecondsSpentLimit(), a1)).append(",").append("\"unimprovedMinutesSpentLimit\":").append(java_lang_Long.marshall(a0.getUnimprovedMinutesSpentLimit(), a1)).append(",").append("\"unimprovedHoursSpentLimit\":").append(java_lang_Long.marshall(a0.getUnimprovedHoursSpentLimit(), a1)).append(",").append("\"bestScoreLimit\":").append(java_lang_String.marshall(a0.getBestScoreLimit(), a1)).append(",").append("\"bestScoreFeasible\":").append(java_lang_Boolean.marshall(a0.getBestScoreFeasible(), a1)).append(",").append("\"stepCountLimit\":").append(java_lang_Integer.marshall(a0.getStepCountLimit(), a1)).append(",").append("\"unimprovedStepCountLimit\":").append(java_lang_Integer.marshall(a0.getUnimprovedStepCountLimit(), a1)).append(",").append("\"terminationConfigList\":").append(java_util_List.marshall(a0.getTerminationConfigList(), a1)).append(",").append("\"daysSpentLimit\":").append(java_lang_Long.marshall(a0.getDaysSpentLimit(), a1)).append(",").append("\"unimprovedDaysSpentLimit\":").append(java_lang_Long.marshall(a0.getUnimprovedDaysSpentLimit(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_optaplanner_workbench_screens_solver_model_TerminationCompositionStyleModel == null) {
      org_optaplanner_workbench_screens_solver_model_TerminationCompositionStyleModel = Marshalling.getMarshaller(TerminationCompositionStyleModel.class);
    }
  }
}