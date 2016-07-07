package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.DecisionTableAuditEvents;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_DecisionTableAuditEvents_1_Impl implements GeneratedMarshaller<DecisionTableAuditEvents> {
  private DecisionTableAuditEvents[] EMPTY_ARRAY = new DecisionTableAuditEvents[0];
  public DecisionTableAuditEvents[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DecisionTableAuditEvents demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DecisionTableAuditEvents entity = obj != null ? Enum.valueOf(DecisionTableAuditEvents.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DecisionTableAuditEvents.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DecisionTableAuditEvents a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.DecisionTableAuditEvents\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}