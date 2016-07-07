package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.formModeler.api.client.FormRenderContextTO;
import org.jbpm.formModeler.api.events.ResizeFormcontainerEvent;

public class Marshaller_o_j_f_a_e_ResizeFormcontainerEvent_1_Impl implements GeneratedMarshaller<ResizeFormcontainerEvent> {
  private ResizeFormcontainerEvent[] EMPTY_ARRAY = new ResizeFormcontainerEvent[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<FormRenderContextTO> org_jbpm_formModeler_api_client_FormRenderContextTO = null;
  public ResizeFormcontainerEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ResizeFormcontainerEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResizeFormcontainerEvent.class, objId);
    }
    ResizeFormcontainerEvent entity = new ResizeFormcontainerEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("width")) && (!obj.get("width").isNull())) {
      entity.setWidth(java_lang_Integer.demarshall(obj.get("width"), a1));
    }
    if ((obj.containsKey("height")) && (!obj.get("height").isNull())) {
      entity.setHeight(java_lang_Integer.demarshall(obj.get("height"), a1));
    }
    if ((obj.containsKey("context")) && (!obj.get("context").isNull())) {
      entity.setContext(org_jbpm_formModeler_api_client_FormRenderContextTO.demarshall(obj.get("context"), a1));
    }
    return entity;
  }

  public String marshall(ResizeFormcontainerEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.formModeler.api.events.ResizeFormcontainerEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"width\":").append(java_lang_Integer.marshall(a0.getWidth(), a1)).append(",").append("\"height\":").append(java_lang_Integer.marshall(a0.getHeight(), a1)).append(",").append("\"context\":").append(org_jbpm_formModeler_api_client_FormRenderContextTO.marshall(a0.getContext(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_jbpm_formModeler_api_client_FormRenderContextTO == null) {
      org_jbpm_formModeler_api_client_FormRenderContextTO = Marshalling.getMarshaller(FormRenderContextTO.class);
    }
  }
}