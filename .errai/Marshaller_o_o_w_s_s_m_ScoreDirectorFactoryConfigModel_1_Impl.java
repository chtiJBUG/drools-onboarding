package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.ScoreDefinitionTypeModel;
import org.optaplanner.workbench.screens.solver.model.ScoreDirectorFactoryConfigModel;

public class Marshaller_o_o_w_s_s_m_ScoreDirectorFactoryConfigModel_1_Impl implements GeneratedMarshaller<ScoreDirectorFactoryConfigModel> {
  private ScoreDirectorFactoryConfigModel[] EMPTY_ARRAY = new ScoreDirectorFactoryConfigModel[0];
  private Marshaller<ScoreDefinitionTypeModel> org_optaplanner_workbench_screens_solver_model_ScoreDefinitionTypeModel = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ScoreDirectorFactoryConfigModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ScoreDirectorFactoryConfigModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ScoreDirectorFactoryConfigModel.class, objId);
    }
    ScoreDirectorFactoryConfigModel entity = new ScoreDirectorFactoryConfigModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("scoreDefinitionType")) && (!obj.get("scoreDefinitionType").isNull())) {
      entity.setScoreDefinitionType(obj.get("scoreDefinitionType").isObject() != null ? Enum.valueOf(ScoreDefinitionTypeModel.class, obj.get("scoreDefinitionType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("scoreDefinitionType").isString() != null ? Enum.valueOf(ScoreDefinitionTypeModel.class, obj.get("scoreDefinitionType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("ksessionName")) && (!obj.get("ksessionName").isNull())) {
      entity.setKSessionName(java_lang_String.demarshall(obj.get("ksessionName"), a1));
    }
    return entity;
  }

  public String marshall(ScoreDirectorFactoryConfigModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.ScoreDirectorFactoryConfigModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"scoreDefinitionType\":").append(a0.getScoreDefinitionType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.ScoreDefinitionTypeModel\",\"^EnumStringValue\":\"").append(a0.getScoreDefinitionType().name()).append("\"}") : "null").append(",").append("\"ksessionName\":").append(java_lang_String.marshall(a0.getKSessionName(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_optaplanner_workbench_screens_solver_model_ScoreDefinitionTypeModel == null) {
      org_optaplanner_workbench_screens_solver_model_ScoreDefinitionTypeModel = Marshalling.getMarshaller(ScoreDefinitionTypeModel.class);
    }
  }
}