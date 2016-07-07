package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.events.DataSetDefRegisteredEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_e_DataSetDefRegisteredEvent_1_Impl implements GeneratedMarshaller<DataSetDefRegisteredEvent> {
  private DataSetDefRegisteredEvent[] EMPTY_ARRAY = new DataSetDefRegisteredEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataSetDefRegisteredEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataSetDefRegisteredEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetDefRegisteredEvent.class, objId);
    }
    DataSetDefRegisteredEvent entity = new DataSetDefRegisteredEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSetDef")) && (!obj.get("dataSetDef").isNull())) {
      entity.setDataSetDef((DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("dataSetDef"), a1));
    }
    return entity;
  }

  public String marshall(DataSetDefRegisteredEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.events.DataSetDefRegisteredEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSetDef\":").append(java_lang_Object.marshall(a0.getDataSetDef(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}