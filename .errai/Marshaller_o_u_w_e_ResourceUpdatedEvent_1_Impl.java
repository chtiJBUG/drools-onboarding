package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceUpdatedEvent;

public class Marshaller_o_u_w_e_ResourceUpdatedEvent_1_Impl implements GeneratedMarshaller<ResourceUpdatedEvent> {
  private ResourceUpdatedEvent[] EMPTY_ARRAY = new ResourceUpdatedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceUpdatedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ResourceUpdatedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceUpdatedEvent.class, objId);
    }
    final Path c0 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1);
    final SessionInfo c2 = org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("message"), a1);
    ResourceUpdatedEvent entity = new ResourceUpdatedEvent(c0, c1, c2);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ResourceUpdatedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceUpdatedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}