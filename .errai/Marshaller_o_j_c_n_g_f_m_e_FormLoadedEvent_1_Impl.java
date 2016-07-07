package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ga.forms.model.events.FormLoadedEvent;

public class Marshaller_o_j_c_n_g_f_m_e_FormLoadedEvent_1_Impl implements GeneratedMarshaller<FormLoadedEvent> {
  private FormLoadedEvent[] EMPTY_ARRAY = new FormLoadedEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public FormLoadedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1540985627__1195259493_jsonForm(FormLoadedEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ga.forms.model.events.FormLoadedEvent::jsonForm;
  }-*/;

  private native static void _$1540985627__1195259493_jsonForm(FormLoadedEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.ga.forms.model.events.FormLoadedEvent::jsonForm = value;
  }-*/;

  public FormLoadedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FormLoadedEvent.class, objId);
    }
    FormLoadedEvent entity = new FormLoadedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("jsonForm")) && (!obj.get("jsonForm").isNull())) {
      _$1540985627__1195259493_jsonForm(entity, java_lang_String.demarshall(obj.get("jsonForm"), a1));
    }
    return entity;
  }

  public String marshall(FormLoadedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.forms.model.events.FormLoadedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"jsonForm\":").append(java_lang_String.marshall(a0.getJsonForm(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}