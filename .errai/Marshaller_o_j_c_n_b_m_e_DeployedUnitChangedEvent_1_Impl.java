package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.bd.model.events.DeployedUnitChangedEvent;

public class Marshaller_o_j_c_n_b_m_e_DeployedUnitChangedEvent_1_Impl implements GeneratedMarshaller<DeployedUnitChangedEvent> {
  private DeployedUnitChangedEvent[] EMPTY_ARRAY = new DeployedUnitChangedEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DeployedUnitChangedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DeployedUnitChangedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DeployedUnitChangedEvent.class, objId);
    }
    DeployedUnitChangedEvent entity = new DeployedUnitChangedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("unitId")) && (!obj.get("unitId").isNull())) {
      entity.setUnitId(java_lang_String.demarshall(obj.get("unitId"), a1));
    }
    return entity;
  }

  public String marshall(DeployedUnitChangedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.events.DeployedUnitChangedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"unitId\":").append(java_lang_String.marshall(a0.getUnitId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}