package org.jboss.errai.marshalling.client.api;

import java.math.BigDecimal;
import org.drools.workbench.models.guided.dtree.shared.model.values.impl.BigDecimalValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_v_i_BigDecimalValue_1_Impl implements GeneratedMarshaller<BigDecimalValue> {
  private BigDecimalValue[] EMPTY_ARRAY = new BigDecimalValue[0];
  private Marshaller<BigDecimal> java_math_BigDecimal = Marshalling.getMarshaller(BigDecimal.class);
  public BigDecimalValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public BigDecimalValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BigDecimalValue.class, objId);
    }
    BigDecimalValue entity = new BigDecimalValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_math_BigDecimal.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(BigDecimalValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.values.impl.BigDecimalValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_math_BigDecimal.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}