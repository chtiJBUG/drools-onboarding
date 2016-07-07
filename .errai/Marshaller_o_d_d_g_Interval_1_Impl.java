package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.group.Interval;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_g_Interval_1_Impl implements GeneratedMarshaller<Interval> {
  private Interval[] EMPTY_ARRAY = new Interval[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public Interval[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Interval demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Interval.class, objId);
    }
    Interval entity = new Interval();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("index")) && (!obj.get("index").isNull())) {
      entity.setIndex(java_lang_Integer.demarshall(obj.get("index"), a1));
    }
    if ((obj.containsKey("rows")) && (!obj.get("rows").isNull())) {
      a1.setAssumedElementType("java.lang.Integer");
      entity.setRows(java_util_List.demarshall(obj.get("rows"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("minValue")) && (!obj.get("minValue").isNull())) {
      entity.setMinValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("minValue"), a1));
    }
    if ((obj.containsKey("maxValue")) && (!obj.get("maxValue").isNull())) {
      entity.setMaxValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("maxValue"), a1));
    }
    return entity;
  }

  public String marshall(Interval a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.group.Interval\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"index\":").append(java_lang_Integer.marshall(a0.getIndex(), a1)).append(",").append("\"rows\":").append(java_util_List.marshall(a0.getRows(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"minValue\":").append(java_lang_Object.marshall(a0.getMinValue(), a1)).append(",").append("\"maxValue\":").append(java_lang_Object.marshall(a0.getMaxValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}