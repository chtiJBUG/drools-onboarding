package org.jboss.errai.marshalling.client.api;

import java.math.BigInteger;
import org.drools.workbench.models.guided.dtree.shared.model.values.impl.BigIntegerValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_v_i_BigIntegerValue_1_Impl implements GeneratedMarshaller<BigIntegerValue> {
  private BigIntegerValue[] EMPTY_ARRAY = new BigIntegerValue[0];
  private Marshaller<BigInteger> java_math_BigInteger = Marshalling.getMarshaller(BigInteger.class);
  public BigIntegerValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public BigIntegerValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BigIntegerValue.class, objId);
    }
    BigIntegerValue entity = new BigIntegerValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_math_BigInteger.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(BigIntegerValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.values.impl.BigIntegerValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_math_BigInteger.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}