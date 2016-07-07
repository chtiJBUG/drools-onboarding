package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.DataSetMetadata;
import org.dashbuilder.dataset.events.DataSetPushingEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_e_DataSetPushingEvent_1_Impl implements GeneratedMarshaller<DataSetPushingEvent> {
  private DataSetPushingEvent[] EMPTY_ARRAY = new DataSetPushingEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataSetPushingEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataSetPushingEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetPushingEvent.class, objId);
    }
    DataSetPushingEvent entity = new DataSetPushingEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSetMetadata")) && (!obj.get("dataSetMetadata").isNull())) {
      entity.setDataSetMetadata((DataSetMetadata) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetMetadata.class, obj.get("dataSetMetadata"), a1));
    }
    return entity;
  }

  public String marshall(DataSetPushingEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.events.DataSetPushingEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSetMetadata\":").append(java_lang_Object.marshall(a0.getDataSetMetadata(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}