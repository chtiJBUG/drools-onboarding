package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.OperatorsOracle;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_OperatorsOracle_1_Impl implements GeneratedMarshaller<OperatorsOracle> {
  private OperatorsOracle[] EMPTY_ARRAY = new OperatorsOracle[0];
  public OperatorsOracle[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public OperatorsOracle demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(OperatorsOracle.class, objId);
    }
    OperatorsOracle entity = new OperatorsOracle();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(OperatorsOracle a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.OperatorsOracle\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}