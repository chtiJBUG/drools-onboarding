package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.ScoreDefinitionTypeModel;

public class Marshaller_o_o_w_s_s_m_ScoreDefinitionTypeModel_1_Impl implements GeneratedMarshaller<ScoreDefinitionTypeModel> {
  private ScoreDefinitionTypeModel[] EMPTY_ARRAY = new ScoreDefinitionTypeModel[0];
  public ScoreDefinitionTypeModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ScoreDefinitionTypeModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    ScoreDefinitionTypeModel entity = obj != null ? Enum.valueOf(ScoreDefinitionTypeModel.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(ScoreDefinitionTypeModel.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(ScoreDefinitionTypeModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.ScoreDefinitionTypeModel\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}