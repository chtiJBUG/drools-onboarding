package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.asset.management.model.ConfigureRepositoryEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_a_m_m_ConfigureRepositoryEvent_1_Impl implements GeneratedMarshaller<ConfigureRepositoryEvent> {
  private ConfigureRepositoryEvent[] EMPTY_ARRAY = new ConfigureRepositoryEvent[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public ConfigureRepositoryEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$844649119__$1383349348_params(ConfigureRepositoryEvent instance) /*-{
    return instance.@org.guvnor.asset.management.model.ConfigureRepositoryEvent::params;
  }-*/;

  private native static void _$844649119__$1383349348_params(ConfigureRepositoryEvent instance, Map value) /*-{
    instance.@org.guvnor.asset.management.model.ConfigureRepositoryEvent::params = value;
  }-*/;

  public ConfigureRepositoryEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ConfigureRepositoryEvent.class, objId);
    }
    ConfigureRepositoryEvent entity = new ConfigureRepositoryEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("params")) && (!obj.get("params").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$844649119__$1383349348_params(entity, java_util_Map.demarshall(obj.get("params"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(ConfigureRepositoryEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.asset.management.model.ConfigureRepositoryEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"params\":").append(java_util_Map.marshall(a0.getParams(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}