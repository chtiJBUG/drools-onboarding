package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent;

public class Marshaller_o_j_c_n_g_f_m_e_PaletteItemAddedEvent_1_Impl implements GeneratedMarshaller<PaletteItemAddedEvent> {
  private PaletteItemAddedEvent[] EMPTY_ARRAY = new PaletteItemAddedEvent[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public PaletteItemAddedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$90612740__$1383349348_menuItemDesc(PaletteItemAddedEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent::menuItemDesc;
  }-*/;

  private native static void _$90612740__$1383349348_menuItemDesc(PaletteItemAddedEvent instance, Map value) /*-{
    instance.@org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent::menuItemDesc = value;
  }-*/;

  private native static String _$90612740__1195259493_groupName(PaletteItemAddedEvent instance) /*-{
    return instance.@org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent::groupName;
  }-*/;

  private native static void _$90612740__1195259493_groupName(PaletteItemAddedEvent instance, String value) /*-{
    instance.@org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent::groupName = value;
  }-*/;

  public PaletteItemAddedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PaletteItemAddedEvent.class, objId);
    }
    PaletteItemAddedEvent entity = new PaletteItemAddedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("menuItemDesc")) && (!obj.get("menuItemDesc").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$90612740__$1383349348_menuItemDesc(entity, java_util_Map.demarshall(obj.get("menuItemDesc"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("groupName")) && (!obj.get("groupName").isNull())) {
      _$90612740__1195259493_groupName(entity, java_lang_String.demarshall(obj.get("groupName"), a1));
    }
    return entity;
  }

  public String marshall(PaletteItemAddedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.forms.model.events.PaletteItemAddedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"menuItemDesc\":").append(java_util_Map.marshall(_$90612740__$1383349348_menuItemDesc(a0), a1)).append(",").append("\"groupName\":").append(java_lang_String.marshall(a0.getGroupName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}