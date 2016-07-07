package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.EventProcessingOption;

public class Marshaller_o_k_w_c_s_s_k_EventProcessingOption_1_Impl implements GeneratedMarshaller<EventProcessingOption> {
  private EventProcessingOption[] EMPTY_ARRAY = new EventProcessingOption[0];
  public EventProcessingOption[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public EventProcessingOption demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    EventProcessingOption entity = obj != null ? Enum.valueOf(EventProcessingOption.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(EventProcessingOption.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(EventProcessingOption a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.EventProcessingOption\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}