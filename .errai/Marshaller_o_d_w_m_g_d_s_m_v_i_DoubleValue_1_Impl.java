package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.values.impl.DoubleValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_v_i_DoubleValue_1_Impl implements GeneratedMarshaller<DoubleValue> {
  private DoubleValue[] EMPTY_ARRAY = new DoubleValue[0];
  private Marshaller<Double> java_lang_Double = Marshalling.getMarshaller(Double.class);
  public DoubleValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DoubleValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DoubleValue.class, objId);
    }
    DoubleValue entity = new DoubleValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_Double.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(DoubleValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.values.impl.DoubleValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_Double.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}