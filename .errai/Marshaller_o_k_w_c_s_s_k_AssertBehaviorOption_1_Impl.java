package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.AssertBehaviorOption;

public class Marshaller_o_k_w_c_s_s_k_AssertBehaviorOption_1_Impl implements GeneratedMarshaller<AssertBehaviorOption> {
  private AssertBehaviorOption[] EMPTY_ARRAY = new AssertBehaviorOption[0];
  public AssertBehaviorOption[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public AssertBehaviorOption demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    AssertBehaviorOption entity = obj != null ? Enum.valueOf(AssertBehaviorOption.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(AssertBehaviorOption.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(AssertBehaviorOption a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.AssertBehaviorOption\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}