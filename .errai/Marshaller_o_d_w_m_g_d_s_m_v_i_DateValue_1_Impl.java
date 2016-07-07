package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.drools.workbench.models.guided.dtree.shared.model.values.impl.DateValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_v_i_DateValue_1_Impl implements GeneratedMarshaller<DateValue> {
  private DateValue[] EMPTY_ARRAY = new DateValue[0];
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public DateValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DateValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DateValue.class, objId);
    }
    DateValue entity = new DateValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_util_Date.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(DateValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.values.impl.DateValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_util_Date.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}