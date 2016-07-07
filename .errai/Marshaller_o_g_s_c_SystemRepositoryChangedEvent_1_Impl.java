package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.config.SystemRepositoryChangedEvent;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_s_c_SystemRepositoryChangedEvent_1_Impl implements GeneratedMarshaller<SystemRepositoryChangedEvent> {
  private SystemRepositoryChangedEvent[] EMPTY_ARRAY = new SystemRepositoryChangedEvent[0];
  public SystemRepositoryChangedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public SystemRepositoryChangedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SystemRepositoryChangedEvent.class, objId);
    }
    SystemRepositoryChangedEvent entity = new SystemRepositoryChangedEvent();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(SystemRepositoryChangedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.config.SystemRepositoryChangedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}