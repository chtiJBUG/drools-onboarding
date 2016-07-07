package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.ScoreDirectorFactoryConfigModel;
import org.optaplanner.workbench.screens.solver.model.SolverConfigModel;
import org.optaplanner.workbench.screens.solver.model.TerminationConfigModel;

public class Marshaller_o_o_w_s_s_m_SolverConfigModel_1_Impl implements GeneratedMarshaller<SolverConfigModel> {
  private SolverConfigModel[] EMPTY_ARRAY = new SolverConfigModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<ScoreDirectorFactoryConfigModel> org_optaplanner_workbench_screens_solver_model_ScoreDirectorFactoryConfigModel = null;
  private Marshaller<TerminationConfigModel> org_optaplanner_workbench_screens_solver_model_TerminationConfigModel = null;
  public SolverConfigModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public SolverConfigModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SolverConfigModel.class, objId);
    }
    SolverConfigModel entity = new SolverConfigModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("solutionClass")) && (!obj.get("solutionClass").isNull())) {
      entity.setSolutionClass(java_lang_String.demarshall(obj.get("solutionClass"), a1));
    }
    if ((obj.containsKey("entityClassList")) && (!obj.get("entityClassList").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setEntityClassList(java_util_List.demarshall(obj.get("entityClassList"), a1));
    }
    if ((obj.containsKey("scoreDirectorFactoryConfig")) && (!obj.get("scoreDirectorFactoryConfig").isNull())) {
      entity.setScoreDirectorFactoryConfig(org_optaplanner_workbench_screens_solver_model_ScoreDirectorFactoryConfigModel.demarshall(obj.get("scoreDirectorFactoryConfig"), a1));
    }
    if ((obj.containsKey("terminationConfig")) && (!obj.get("terminationConfig").isNull())) {
      entity.setTerminationConfig(org_optaplanner_workbench_screens_solver_model_TerminationConfigModel.demarshall(obj.get("terminationConfig"), a1));
    }
    return entity;
  }

  private native static TerminationConfigModel _430978110__$2117226407_terminationConfig(SolverConfigModel instance) /*-{
    return instance.@org.optaplanner.workbench.screens.solver.model.SolverConfigModel::terminationConfig;
  }-*/;

  private native static void _430978110__$2117226407_terminationConfig(SolverConfigModel instance, TerminationConfigModel value) /*-{
    instance.@org.optaplanner.workbench.screens.solver.model.SolverConfigModel::terminationConfig = value;
  }-*/;

  public String marshall(SolverConfigModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.SolverConfigModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"solutionClass\":").append(java_lang_String.marshall(a0.getSolutionClass(), a1)).append(",").append("\"entityClassList\":").append(java_util_List.marshall(a0.getEntityClassList(), a1)).append(",").append("\"scoreDirectorFactoryConfig\":").append(org_optaplanner_workbench_screens_solver_model_ScoreDirectorFactoryConfigModel.marshall(a0.getScoreDirectorFactoryConfig(), a1)).append(",").append("\"terminationConfig\":").append(org_optaplanner_workbench_screens_solver_model_TerminationConfigModel.marshall(_430978110__$2117226407_terminationConfig(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_optaplanner_workbench_screens_solver_model_ScoreDirectorFactoryConfigModel == null) {
      org_optaplanner_workbench_screens_solver_model_ScoreDirectorFactoryConfigModel = Marshalling.getMarshaller(ScoreDirectorFactoryConfigModel.class);
    }
    if (org_optaplanner_workbench_screens_solver_model_TerminationConfigModel == null) {
      org_optaplanner_workbench_screens_solver_model_TerminationConfigModel = Marshalling.getMarshaller(TerminationConfigModel.class);
    }
  }
}