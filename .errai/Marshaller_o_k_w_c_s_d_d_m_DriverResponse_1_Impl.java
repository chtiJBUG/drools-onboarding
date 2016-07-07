package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverError;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverResponse;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverResult;

public class Marshaller_o_k_w_c_s_d_d_m_DriverResponse_1_Impl implements GeneratedMarshaller<DriverResponse> {
  private DriverResponse[] EMPTY_ARRAY = new DriverResponse[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public DriverResponse[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$814931607__65821278_errors(DriverResult instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors;
  }-*/;

  private native static void _$814931607__65821278_errors(DriverResult instance, List<DriverError> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors = value;
  }-*/;

  public DriverResponse demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DriverResponse.class, objId);
    }
    DriverResponse entity = new DriverResponse();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.driver.model.DriverError");
      _$814931607__65821278_errors(entity, java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(DriverResponse a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.DriverResponse\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}