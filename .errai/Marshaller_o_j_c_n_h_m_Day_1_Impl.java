package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.Day;

public class Marshaller_o_j_c_n_h_m_Day_1_Impl implements GeneratedMarshaller<Day> {
  private Day[] EMPTY_ARRAY = new Day[0];
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Day[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Day demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Day.class, objId);
    }
    final Date c0 = java_util_Date.demarshall(obj.get("date"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("dayOfWeekName"), a1);
    Day entity = new Day(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(Day a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.Day\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"date\":").append(java_util_Date.marshall(a0.getDate(), a1)).append(",").append("\"dayOfWeekName\":").append(java_lang_String.marshall(a0.getDayOfWeekName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}