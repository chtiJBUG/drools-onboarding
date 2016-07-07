package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.workbench.events.ResourceRenamed;
import org.uberfire.workbench.events.ResourceRenamedEvent;

public class Marshaller_o_u_w_e_ResourceRenamedEvent_1_Impl implements GeneratedMarshaller<ResourceRenamedEvent> {
  private ResourceRenamedEvent[] EMPTY_ARRAY = new ResourceRenamedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceRenamedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1239515980__$2084529122_sourcePath(ResourceRenamedEvent instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceRenamedEvent::sourcePath;
  }-*/;

  private native static void _$1239515980__$2084529122_sourcePath(ResourceRenamedEvent instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceRenamedEvent::sourcePath = value;
  }-*/;

  private native static Path _$1179907706__$2084529122_destinationPath(ResourceRenamed instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceRenamed::destinationPath;
  }-*/;

  private native static void _$1179907706__$2084529122_destinationPath(ResourceRenamed instance, Path value) /*-{
    instance.@org.uberfire.workbench.events.ResourceRenamed::destinationPath = value;
  }-*/;

  private native static String _$1179907706__1195259493_message(ResourceRenamed instance) /*-{
    return instance.@org.uberfire.workbench.events.ResourceRenamed::message;
  }-*/;

  private native static void _$1179907706__1195259493_message(ResourceRenamed instance, String value) /*-{
    instance.@org.uberfire.workbench.events.ResourceRenamed::message = value;
  }-*/;

  public ResourceRenamedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceRenamedEvent.class, objId);
    }
    final Path c0 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("sourcePath"), a1);
    final SessionInfo c3 = org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1);
    final Path c1 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("destinationPath"), a1);
    final String c2 = java_lang_String.demarshall(obj.get("message"), a1);
    ResourceRenamedEvent entity = new ResourceRenamedEvent(c0, c1, c2, c3);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sourcePath")) && (!obj.get("sourcePath").isNull())) {
      _$1239515980__$2084529122_sourcePath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("sourcePath"), a1));
    }
    if ((obj.containsKey("destinationPath")) && (!obj.get("destinationPath").isNull())) {
      _$1179907706__$2084529122_destinationPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("destinationPath"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      _$1179907706__1195259493_message(entity, java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(ResourceRenamedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceRenamedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sourcePath\":").append(java_lang_Object.marshall(_$1239515980__$2084529122_sourcePath(a0), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append(",").append("\"destinationPath\":").append(java_lang_Object.marshall(a0.getDestinationPath(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}