package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.TerminationCompositionStyleModel;

public class Marshaller_o_o_w_s_s_m_TerminationCompositionStyleModel_1_Impl implements GeneratedMarshaller<TerminationCompositionStyleModel> {
  private TerminationCompositionStyleModel[] EMPTY_ARRAY = new TerminationCompositionStyleModel[0];
  public TerminationCompositionStyleModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TerminationCompositionStyleModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    TerminationCompositionStyleModel entity = obj != null ? Enum.valueOf(TerminationCompositionStyleModel.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(TerminationCompositionStyleModel.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(TerminationCompositionStyleModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.TerminationCompositionStyleModel\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}