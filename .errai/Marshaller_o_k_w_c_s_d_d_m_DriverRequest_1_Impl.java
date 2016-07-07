package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverRequest;

public class Marshaller_o_k_w_c_s_d_d_m_DriverRequest_1_Impl implements GeneratedMarshaller<DriverRequest> {
  private DriverRequest[] EMPTY_ARRAY = new DriverRequest[0];
  public DriverRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DriverRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DriverRequest.class, objId);
    }
    DriverRequest entity = new DriverRequest();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(DriverRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.DriverRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}