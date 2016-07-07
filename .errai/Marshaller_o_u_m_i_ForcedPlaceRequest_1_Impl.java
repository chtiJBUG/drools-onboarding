package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.mvp.impl.ForcedPlaceRequest;

public class Marshaller_o_u_m_i_ForcedPlaceRequest_1_Impl implements GeneratedMarshaller<ForcedPlaceRequest> {
  private ForcedPlaceRequest[] EMPTY_ARRAY = new ForcedPlaceRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public ForcedPlaceRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$1575363562__$1383349348_parameters(DefaultPlaceRequest instance) /*-{
    return instance.@org.uberfire.mvp.impl.DefaultPlaceRequest::parameters;
  }-*/;

  private native static void _$1575363562__$1383349348_parameters(DefaultPlaceRequest instance, Map<String, String> value) /*-{
    instance.@org.uberfire.mvp.impl.DefaultPlaceRequest::parameters = value;
  }-*/;

  private native static boolean _$1575363562__64711720_updateLocationBar(DefaultPlaceRequest instance) /*-{
    return instance.@org.uberfire.mvp.impl.DefaultPlaceRequest::updateLocationBar;
  }-*/;

  private native static void _$1575363562__64711720_updateLocationBar(DefaultPlaceRequest instance, boolean value) /*-{
    instance.@org.uberfire.mvp.impl.DefaultPlaceRequest::updateLocationBar = value;
  }-*/;

  public ForcedPlaceRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ForcedPlaceRequest.class, objId);
    }
    ForcedPlaceRequest entity = new ForcedPlaceRequest();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("identifier")) && (!obj.get("identifier").isNull())) {
      entity.setIdentifier(java_lang_String.demarshall(obj.get("identifier"), a1));
    }
    if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$1575363562__$1383349348_parameters(entity, java_util_Map.demarshall(obj.get("parameters"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("updateLocationBar")) && (!obj.get("updateLocationBar").isNull())) {
      _$1575363562__64711720_updateLocationBar(entity, java_lang_Boolean.demarshall(obj.get("updateLocationBar"), a1));
    }
    return entity;
  }

  public String marshall(ForcedPlaceRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.mvp.impl.ForcedPlaceRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"identifier\":").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(a0.getParameters(), a1)).append(",").append("\"updateLocationBar\":").append(java_lang_Boolean.marshall(_$1575363562__64711720_updateLocationBar(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}