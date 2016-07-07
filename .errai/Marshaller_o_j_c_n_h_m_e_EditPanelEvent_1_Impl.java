package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.events.EditPanelEvent;

public class Marshaller_o_j_c_n_h_m_e_EditPanelEvent_1_Impl implements GeneratedMarshaller<EditPanelEvent> {
  private EditPanelEvent[] EMPTY_ARRAY = new EditPanelEvent[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public EditPanelEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public EditPanelEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EditPanelEvent.class, objId);
    }
    EditPanelEvent entity = new EditPanelEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      entity.setTaskId(java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    return entity;
  }

  public String marshall(EditPanelEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.events.EditPanelEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}