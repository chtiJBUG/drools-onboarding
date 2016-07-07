package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.events.DeleteProjectEvent;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_e_DeleteProjectEvent_1_Impl implements GeneratedMarshaller<DeleteProjectEvent> {
  private DeleteProjectEvent[] EMPTY_ARRAY = new DeleteProjectEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DeleteProjectEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Project _$489776956__$608805097_project(DeleteProjectEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.DeleteProjectEvent::project;
  }-*/;

  private native static void _$489776956__$608805097_project(DeleteProjectEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.events.DeleteProjectEvent::project = value;
  }-*/;

  public DeleteProjectEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DeleteProjectEvent.class, objId);
    }
    DeleteProjectEvent entity = new DeleteProjectEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _$489776956__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    return entity;
  }

  public String marshall(DeleteProjectEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.events.DeleteProjectEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}