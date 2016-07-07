package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.rpc.SessionInfo;

public class Marshaller_o_g_c_s_p_b_e_InvalidateDMOProjectCacheEvent_1_Impl implements GeneratedMarshaller<InvalidateDMOProjectCacheEvent> {
  private InvalidateDMOProjectCacheEvent[] EMPTY_ARRAY = new InvalidateDMOProjectCacheEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<SessionInfo> org_uberfire_rpc_SessionInfo = Marshalling.getMarshaller(SessionInfo.class);
  public InvalidateDMOProjectCacheEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _978280203__$2084529122_resourcePath(InvalidateDMOProjectCacheEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::resourcePath;
  }-*/;

  private native static void _978280203__$2084529122_resourcePath(InvalidateDMOProjectCacheEvent instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::resourcePath = value;
  }-*/;

  private native static Project _978280203__$608805097_project(InvalidateDMOProjectCacheEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::project;
  }-*/;

  private native static void _978280203__$608805097_project(InvalidateDMOProjectCacheEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::project = value;
  }-*/;

  private native static SessionInfo _978280203__291376327_sessionInfo(InvalidateDMOProjectCacheEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::sessionInfo;
  }-*/;

  private native static void _978280203__291376327_sessionInfo(InvalidateDMOProjectCacheEvent instance, SessionInfo value) /*-{
    instance.@org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent::sessionInfo = value;
  }-*/;

  public InvalidateDMOProjectCacheEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(InvalidateDMOProjectCacheEvent.class, objId);
    }
    InvalidateDMOProjectCacheEvent entity = new InvalidateDMOProjectCacheEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("resourcePath")) && (!obj.get("resourcePath").isNull())) {
      _978280203__$2084529122_resourcePath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("resourcePath"), a1));
    }
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _978280203__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    if ((obj.containsKey("sessionInfo")) && (!obj.get("sessionInfo").isNull())) {
      _978280203__291376327_sessionInfo(entity, org_uberfire_rpc_SessionInfo.demarshall(obj.get("sessionInfo"), a1));
    }
    return entity;
  }

  public String marshall(InvalidateDMOProjectCacheEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.builder.events.InvalidateDMOProjectCacheEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"resourcePath\":").append(java_lang_Object.marshall(a0.getResourcePath(), a1)).append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append(",").append("\"sessionInfo\":").append(org_uberfire_rpc_SessionInfo.marshall(a0.getSessionInfo(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}