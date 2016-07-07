package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52.TableFormat;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_GuidedDecisionTable52_erraiD_TableFormat_Impl implements GeneratedMarshaller<TableFormat> {
  private TableFormat[] EMPTY_ARRAY = new TableFormat[0];
  public TableFormat[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TableFormat demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    TableFormat entity = obj != null ? Enum.valueOf(TableFormat.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(TableFormat.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(TableFormat a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52$TableFormat\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}