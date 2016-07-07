package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.formModeler.api.client.FormRenderContextTO;
import org.jbpm.formModeler.api.events.FormRenderEvent;

public class Marshaller_o_j_f_a_e_FormRenderEvent_1_Impl implements GeneratedMarshaller<FormRenderEvent> {
  private FormRenderEvent[] EMPTY_ARRAY = new FormRenderEvent[0];
  private Marshaller<FormRenderContextTO> org_jbpm_formModeler_api_client_FormRenderContextTO = null;
  public FormRenderEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FormRenderEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FormRenderEvent.class, objId);
    }
    FormRenderEvent entity = new FormRenderEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("context")) && (!obj.get("context").isNull())) {
      entity.setContext(org_jbpm_formModeler_api_client_FormRenderContextTO.demarshall(obj.get("context"), a1));
    }
    return entity;
  }

  public String marshall(FormRenderEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.formModeler.api.events.FormRenderEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"context\":").append(org_jbpm_formModeler_api_client_FormRenderContextTO.marshall(a0.getContext(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_jbpm_formModeler_api_client_FormRenderContextTO == null) {
      org_jbpm_formModeler_api_client_FormRenderContextTO = Marshalling.getMarshaller(FormRenderContextTO.class);
    }
  }
}