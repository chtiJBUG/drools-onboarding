package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.builder.events.InvalidateDMOPackageCacheEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_c_s_p_b_e_InvalidateDMOPackageCacheEvent_1_Impl implements GeneratedMarshaller<InvalidateDMOPackageCacheEvent> {
  private InvalidateDMOPackageCacheEvent[] EMPTY_ARRAY = new InvalidateDMOPackageCacheEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public InvalidateDMOPackageCacheEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1769442312__$2084529122_resourcePath(InvalidateDMOPackageCacheEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOPackageCacheEvent::resourcePath;
  }-*/;

  private native static void _$1769442312__$2084529122_resourcePath(InvalidateDMOPackageCacheEvent instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOPackageCacheEvent::resourcePath = value;
  }-*/;

  public InvalidateDMOPackageCacheEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(InvalidateDMOPackageCacheEvent.class, objId);
    }
    InvalidateDMOPackageCacheEvent entity = new InvalidateDMOPackageCacheEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("resourcePath")) && (!obj.get("resourcePath").isNull())) {
      _$1769442312__$2084529122_resourcePath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("resourcePath"), a1));
    }
    return entity;
  }

  public String marshall(InvalidateDMOPackageCacheEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.builder.events.InvalidateDMOPackageCacheEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"resourcePath\":").append(java_lang_Object.marshall(a0.getResourcePath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}