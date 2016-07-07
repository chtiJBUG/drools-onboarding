package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.controller.api.model.spec.ContainerConfig;

public class Marshaller_o_k_s_c_a_m_s_ContainerConfig_1_Impl implements GeneratedMarshaller<ContainerConfig> {
  private ContainerConfig[] EMPTY_ARRAY = new ContainerConfig[0];
  public ContainerConfig[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContainerConfig demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerConfig.class, objId);
    }
    ContainerConfig entity = new ContainerConfig();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ContainerConfig a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ContainerConfig\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}