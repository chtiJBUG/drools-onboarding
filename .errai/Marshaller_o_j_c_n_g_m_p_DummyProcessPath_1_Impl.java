package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ga.model.process.DummyProcessPath;

public class Marshaller_o_j_c_n_g_m_p_DummyProcessPath_1_Impl implements GeneratedMarshaller<DummyProcessPath> {
  private DummyProcessPath[] EMPTY_ARRAY = new DummyProcessPath[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DummyProcessPath[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$2018355019__1195259493_fileName(DummyProcessPath instance) /*-{
    return instance.@org.jbpm.console.ng.ga.model.process.DummyProcessPath::fileName;
  }-*/;

  private native static void _$2018355019__1195259493_fileName(DummyProcessPath instance, String value) /*-{
    instance.@org.jbpm.console.ng.ga.model.process.DummyProcessPath::fileName = value;
  }-*/;

  public DummyProcessPath demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DummyProcessPath.class, objId);
    }
    DummyProcessPath entity = new DummyProcessPath();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fileName")) && (!obj.get("fileName").isNull())) {
      _$2018355019__1195259493_fileName(entity, java_lang_String.demarshall(obj.get("fileName"), a1));
    }
    return entity;
  }

  public String marshall(DummyProcessPath a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.model.process.DummyProcessPath\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fileName\":").append(java_lang_String.marshall(a0.getFileName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}