package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.events.RenameProjectEvent;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_e_RenameProjectEvent_1_Impl implements GeneratedMarshaller<RenameProjectEvent> {
  private RenameProjectEvent[] EMPTY_ARRAY = new RenameProjectEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public RenameProjectEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Project _$781285929__$608805097_oldProject(RenameProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.RenameProjectEvent::oldProject;
  }-*/;

  private native static void _$781285929__$608805097_oldProject(RenameProjectEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.events.RenameProjectEvent::oldProject = value;
  }-*/;

  private native static Project _$781285929__$608805097_newProject(RenameProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.RenameProjectEvent::newProject;
  }-*/;

  private native static void _$781285929__$608805097_newProject(RenameProjectEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.events.RenameProjectEvent::newProject = value;
  }-*/;

  public RenameProjectEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RenameProjectEvent.class, objId);
    }
    RenameProjectEvent entity = new RenameProjectEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("oldProject")) && (!obj.get("oldProject").isNull())) {
      _$781285929__$608805097_oldProject(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("oldProject"), a1));
    }
    if ((obj.containsKey("newProject")) && (!obj.get("newProject").isNull())) {
      _$781285929__$608805097_newProject(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("newProject"), a1));
    }
    return entity;
  }

  public String marshall(RenameProjectEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.events.RenameProjectEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"oldProject\":").append(java_lang_Object.marshall(a0.getOldProject(), a1)).append(",").append("\"newProject\":").append(java_lang_Object.marshall(a0.getNewProject(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}