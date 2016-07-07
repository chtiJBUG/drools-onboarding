package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.Repository;
import org.guvnor.structure.repositories.RepositoryRemovedEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_r_RepositoryRemovedEvent_1_Impl implements GeneratedMarshaller<RepositoryRemovedEvent> {
  private RepositoryRemovedEvent[] EMPTY_ARRAY = new RepositoryRemovedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public RepositoryRemovedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Repository _727974676__$75759654_repository(RepositoryRemovedEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryRemovedEvent::repository;
  }-*/;

  private native static void _727974676__$75759654_repository(RepositoryRemovedEvent instance, Repository value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryRemovedEvent::repository = value;
  }-*/;

  public RepositoryRemovedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryRemovedEvent.class, objId);
    }
    RepositoryRemovedEvent entity = new RepositoryRemovedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("repository")) && (!obj.get("repository").isNull())) {
      _727974676__$75759654_repository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("repository"), a1));
    }
    return entity;
  }

  public String marshall(RepositoryRemovedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.RepositoryRemovedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"repository\":").append(java_lang_Object.marshall(a0.getRepository(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}