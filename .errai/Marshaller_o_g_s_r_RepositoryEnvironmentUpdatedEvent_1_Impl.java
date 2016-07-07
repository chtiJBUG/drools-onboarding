package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.Repository;
import org.guvnor.structure.repositories.RepositoryEnvironmentUpdatedEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_r_RepositoryEnvironmentUpdatedEvent_1_Impl implements GeneratedMarshaller<RepositoryEnvironmentUpdatedEvent> {
  private RepositoryEnvironmentUpdatedEvent[] EMPTY_ARRAY = new RepositoryEnvironmentUpdatedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public RepositoryEnvironmentUpdatedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RepositoryEnvironmentUpdatedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryEnvironmentUpdatedEvent.class, objId);
    }
    RepositoryEnvironmentUpdatedEvent entity = new RepositoryEnvironmentUpdatedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("updatedRepository")) && (!obj.get("updatedRepository").isNull())) {
      entity.setUpdatedRepository((Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("updatedRepository"), a1));
    }
    return entity;
  }

  public String marshall(RepositoryEnvironmentUpdatedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.RepositoryEnvironmentUpdatedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"updatedRepository\":").append(java_lang_Object.marshall(a0.getUpdatedRepository(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}