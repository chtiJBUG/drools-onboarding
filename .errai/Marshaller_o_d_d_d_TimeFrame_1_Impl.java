package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.date.TimeFrame;
import org.dashbuilder.dataset.date.TimeInstant;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_TimeFrame_1_Impl implements GeneratedMarshaller<TimeFrame> {
  private TimeFrame[] EMPTY_ARRAY = new TimeFrame[0];
  private Marshaller<TimeInstant> org_dashbuilder_dataset_date_TimeInstant = null;
  public TimeFrame[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TimeFrame demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TimeFrame.class, objId);
    }
    TimeFrame entity = new TimeFrame();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("from")) && (!obj.get("from").isNull())) {
      entity.setFrom(org_dashbuilder_dataset_date_TimeInstant.demarshall(obj.get("from"), a1));
    }
    if ((obj.containsKey("to")) && (!obj.get("to").isNull())) {
      entity.setTo(org_dashbuilder_dataset_date_TimeInstant.demarshall(obj.get("to"), a1));
    }
    return entity;
  }

  public String marshall(TimeFrame a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.date.TimeFrame\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"from\":").append(org_dashbuilder_dataset_date_TimeInstant.marshall(a0.getFrom(), a1)).append(",").append("\"to\":").append(org_dashbuilder_dataset_date_TimeInstant.marshall(a0.getTo(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_date_TimeInstant == null) {
      org_dashbuilder_dataset_date_TimeInstant = Marshalling.getMarshaller(TimeInstant.class);
    }
  }
}