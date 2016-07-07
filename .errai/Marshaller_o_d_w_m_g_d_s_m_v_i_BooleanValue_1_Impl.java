package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.values.impl.BooleanValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_v_i_BooleanValue_1_Impl implements GeneratedMarshaller<BooleanValue> {
  private BooleanValue[] EMPTY_ARRAY = new BooleanValue[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public BooleanValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public BooleanValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BooleanValue.class, objId);
    }
    BooleanValue entity = new BooleanValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_Boolean.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(BooleanValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.values.impl.BooleanValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_Boolean.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}