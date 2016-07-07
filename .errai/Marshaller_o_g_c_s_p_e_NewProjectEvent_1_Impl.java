package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.events.NewProjectEvent;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_e_NewProjectEvent_1_Impl implements GeneratedMarshaller<NewProjectEvent> {
  private NewProjectEvent[] EMPTY_ARRAY = new NewProjectEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public NewProjectEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Project _$253184183__$608805097_project(NewProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.NewProjectEvent::project;
  }-*/;

  private native static void _$253184183__$608805097_project(NewProjectEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.events.NewProjectEvent::project = value;
  }-*/;

  private native static String _$253184183__1195259493_sessionId(NewProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.NewProjectEvent::sessionId;
  }-*/;

  private native static void _$253184183__1195259493_sessionId(NewProjectEvent instance, String value) /*-{
    instance.@org.guvnor.common.services.project.events.NewProjectEvent::sessionId = value;
  }-*/;

  private native static String _$253184183__1195259493_identity(NewProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.NewProjectEvent::identity;
  }-*/;

  private native static void _$253184183__1195259493_identity(NewProjectEvent instance, String value) /*-{
    instance.@org.guvnor.common.services.project.events.NewProjectEvent::identity = value;
  }-*/;

  public NewProjectEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewProjectEvent.class, objId);
    }
    NewProjectEvent entity = new NewProjectEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _$253184183__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    if ((obj.containsKey("sessionId")) && (!obj.get("sessionId").isNull())) {
      _$253184183__1195259493_sessionId(entity, java_lang_String.demarshall(obj.get("sessionId"), a1));
    }
    if ((obj.containsKey("identity")) && (!obj.get("identity").isNull())) {
      _$253184183__1195259493_identity(entity, java_lang_String.demarshall(obj.get("identity"), a1));
    }
    return entity;
  }

  public String marshall(NewProjectEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.events.NewProjectEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append(",").append("\"sessionId\":").append(java_lang_String.marshall(a0.getSessionId(), a1)).append(",").append("\"identity\":").append(java_lang_String.marshall(a0.getIdentity(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}