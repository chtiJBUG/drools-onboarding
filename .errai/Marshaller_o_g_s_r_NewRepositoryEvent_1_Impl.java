package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.NewRepositoryEvent;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_r_NewRepositoryEvent_1_Impl implements GeneratedMarshaller<NewRepositoryEvent> {
  private NewRepositoryEvent[] EMPTY_ARRAY = new NewRepositoryEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public NewRepositoryEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Repository _$260549568__$75759654_newRepository(NewRepositoryEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewRepositoryEvent::newRepository;
  }-*/;

  private native static void _$260549568__$75759654_newRepository(NewRepositoryEvent instance, Repository value) /*-{
    instance.@org.guvnor.structure.repositories.NewRepositoryEvent::newRepository = value;
  }-*/;

  private native static String _$260549568__1195259493_groupId(NewRepositoryEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewRepositoryEvent::groupId;
  }-*/;

  private native static void _$260549568__1195259493_groupId(NewRepositoryEvent instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.NewRepositoryEvent::groupId = value;
  }-*/;

  private native static String _$260549568__1195259493_artifactId(NewRepositoryEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewRepositoryEvent::artifactId;
  }-*/;

  private native static void _$260549568__1195259493_artifactId(NewRepositoryEvent instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.NewRepositoryEvent::artifactId = value;
  }-*/;

  private native static String _$260549568__1195259493_version(NewRepositoryEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewRepositoryEvent::version;
  }-*/;

  private native static void _$260549568__1195259493_version(NewRepositoryEvent instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.NewRepositoryEvent::version = value;
  }-*/;

  public NewRepositoryEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewRepositoryEvent.class, objId);
    }
    NewRepositoryEvent entity = new NewRepositoryEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("newRepository")) && (!obj.get("newRepository").isNull())) {
      _$260549568__$75759654_newRepository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("newRepository"), a1));
    }
    if ((obj.containsKey("groupId")) && (!obj.get("groupId").isNull())) {
      _$260549568__1195259493_groupId(entity, java_lang_String.demarshall(obj.get("groupId"), a1));
    }
    if ((obj.containsKey("artifactId")) && (!obj.get("artifactId").isNull())) {
      _$260549568__1195259493_artifactId(entity, java_lang_String.demarshall(obj.get("artifactId"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      _$260549568__1195259493_version(entity, java_lang_String.demarshall(obj.get("version"), a1));
    }
    return entity;
  }

  public String marshall(NewRepositoryEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.NewRepositoryEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"newRepository\":").append(java_lang_Object.marshall(a0.getNewRepository(), a1)).append(",").append("\"groupId\":").append(java_lang_String.marshall(a0.getGroupId(), a1)).append(",").append("\"artifactId\":").append(java_lang_String.marshall(a0.getArtifactId(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}