package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.DeclarativeAgendaOption;

public class Marshaller_o_k_w_c_s_s_k_DeclarativeAgendaOption_1_Impl implements GeneratedMarshaller<DeclarativeAgendaOption> {
  private DeclarativeAgendaOption[] EMPTY_ARRAY = new DeclarativeAgendaOption[0];
  public DeclarativeAgendaOption[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DeclarativeAgendaOption demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DeclarativeAgendaOption entity = obj != null ? Enum.valueOf(DeclarativeAgendaOption.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DeclarativeAgendaOption.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DeclarativeAgendaOption a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.DeclarativeAgendaOption\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}