package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.asset.management.model.ReleaseProjectEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_a_m_m_ReleaseProjectEvent_1_Impl implements GeneratedMarshaller<ReleaseProjectEvent> {
  private ReleaseProjectEvent[] EMPTY_ARRAY = new ReleaseProjectEvent[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public ReleaseProjectEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _368383633__$1383349348_params(ReleaseProjectEvent instance) /*-{
    return instance.@org.guvnor.asset.management.model.ReleaseProjectEvent::params;
  }-*/;

  private native static void _368383633__$1383349348_params(ReleaseProjectEvent instance, Map value) /*-{
    instance.@org.guvnor.asset.management.model.ReleaseProjectEvent::params = value;
  }-*/;

  public ReleaseProjectEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ReleaseProjectEvent.class, objId);
    }
    ReleaseProjectEvent entity = new ReleaseProjectEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("params")) && (!obj.get("params").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _368383633__$1383349348_params(entity, java_util_Map.demarshall(obj.get("params"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(ReleaseProjectEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.asset.management.model.ReleaseProjectEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"params\":").append(java_util_Map.marshall(a0.getParams(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}