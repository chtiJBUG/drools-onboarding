package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.test.Failure;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_s_t_Failure_1_Impl implements GeneratedMarshaller<Failure> {
  private Failure[] EMPTY_ARRAY = new Failure[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Failure[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$727475985__1195259493_message(Failure instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.Failure::message;
  }-*/;

  private native static void _$727475985__1195259493_message(Failure instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.test.Failure::message = value;
  }-*/;

  private native static String _$727475985__1195259493_displayName(Failure instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.Failure::displayName;
  }-*/;

  private native static void _$727475985__1195259493_displayName(Failure instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.test.Failure::displayName = value;
  }-*/;

  public Failure demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Failure.class, objId);
    }
    Failure entity = new Failure();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$727475985__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    if ((obj.containsKey("displayName")) && (!obj.get("displayName").isNull())) {
      _$727475985__1195259493_displayName(entity, java_lang_String.demarshall(obj.get("displayName"), a1));
    }
    return entity;
  }

  public String marshall(Failure a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.shared.test.Failure\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"displayName\":").append(java_lang_String.marshall(a0.getDisplayName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}