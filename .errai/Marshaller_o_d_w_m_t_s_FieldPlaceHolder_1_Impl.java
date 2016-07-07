package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.FieldPlaceHolder;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_FieldPlaceHolder_1_Impl implements GeneratedMarshaller<FieldPlaceHolder> {
  private FieldPlaceHolder[] EMPTY_ARRAY = new FieldPlaceHolder[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public FieldPlaceHolder[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1996537537__1195259493_name(FieldPlaceHolder instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.FieldPlaceHolder::name;
  }-*/;

  private native static void _$1996537537__1195259493_name(FieldPlaceHolder instance, String value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.FieldPlaceHolder::name = value;
  }-*/;

  public FieldPlaceHolder demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FieldPlaceHolder.class, objId);
    }
    FieldPlaceHolder entity = new FieldPlaceHolder();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$1996537537__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(FieldPlaceHolder a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.FieldPlaceHolder\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}