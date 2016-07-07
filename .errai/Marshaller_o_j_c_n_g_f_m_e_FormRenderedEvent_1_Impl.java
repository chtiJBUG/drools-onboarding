package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ga.forms.model.events.FormRenderedEvent;

public class Marshaller_o_j_c_n_g_f_m_e_FormRenderedEvent_1_Impl implements GeneratedMarshaller<FormRenderedEvent> {
  private FormRenderedEvent[] EMPTY_ARRAY = new FormRenderedEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public FormRenderedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _949925429__1195259493_form(FormRenderedEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ga.forms.model.events.FormRenderedEvent::form;
  }-*/;

  private native static void _949925429__1195259493_form(FormRenderedEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.ga.forms.model.events.FormRenderedEvent::form = value;
  }-*/;

  public FormRenderedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FormRenderedEvent.class, objId);
    }
    FormRenderedEvent entity = new FormRenderedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("form")) && (!obj.get("form").isNull())) {
      _949925429__1195259493_form(entity, java_lang_String.demarshall(obj.get("form"), a1));
    }
    return entity;
  }

  public String marshall(FormRenderedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.forms.model.events.FormRenderedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"form\":").append(java_lang_String.marshall(a0.getForm(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}