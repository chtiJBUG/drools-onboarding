package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.ext.editor.commons.readonly.ReadOnlyPathPlaceRequest;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.mvp.impl.PathPlaceRequest;

public class Marshaller_o_u_e_e_c_r_ReadOnlyPathPlaceRequest_1_Impl implements GeneratedMarshaller<ReadOnlyPathPlaceRequest> {
  private ReadOnlyPathPlaceRequest[] EMPTY_ARRAY = new ReadOnlyPathPlaceRequest[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public ReadOnlyPathPlaceRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ObservablePath _$1966400576__1685375169_path(PathPlaceRequest instance) /*-{
    return instance.@org.uberfire.mvp.impl.PathPlaceRequest::path;
  }-*/;

  private native static void _$1966400576__1685375169_path(PathPlaceRequest instance, ObservablePath value) /*-{
    instance.@org.uberfire.mvp.impl.PathPlaceRequest::path = value;
  }-*/;

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

  public ReadOnlyPathPlaceRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ReadOnlyPathPlaceRequest.class, objId);
    }
    ReadOnlyPathPlaceRequest entity = new ReadOnlyPathPlaceRequest();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1966400576__1685375169_path(entity, (ObservablePath) ((ObjectMarshaller) java_lang_Object).demarshall(ObservablePath.class, obj.get("path"), a1));
    }
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

  public String marshall(ReadOnlyPathPlaceRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.editor.commons.readonly.ReadOnlyPathPlaceRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"identifier\":").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(a0.getParameters(), a1)).append(",").append("\"updateLocationBar\":").append(java_lang_Boolean.marshall(_$1575363562__64711720_updateLocationBar(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}