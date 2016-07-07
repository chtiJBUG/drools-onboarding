package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.events.DataSetDefModifiedEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_e_DataSetDefModifiedEvent_1_Impl implements GeneratedMarshaller<DataSetDefModifiedEvent> {
  private DataSetDefModifiedEvent[] EMPTY_ARRAY = new DataSetDefModifiedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataSetDefModifiedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataSetDefModifiedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetDefModifiedEvent.class, objId);
    }
    DataSetDefModifiedEvent entity = new DataSetDefModifiedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("oldDataSetDef")) && (!obj.get("oldDataSetDef").isNull())) {
      entity.setOldDataSetDef((DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("oldDataSetDef"), a1));
    }
    if ((obj.containsKey("newDataSetDef")) && (!obj.get("newDataSetDef").isNull())) {
      entity.setNewDataSetDef((DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("newDataSetDef"), a1));
    }
    return entity;
  }

  public String marshall(DataSetDefModifiedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.events.DataSetDefModifiedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"oldDataSetDef\":").append(java_lang_Object.marshall(a0.getOldDataSetDef(), a1)).append(",").append("\"newDataSetDef\":").append(java_lang_Object.marshall(a0.getNewDataSetDef(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}