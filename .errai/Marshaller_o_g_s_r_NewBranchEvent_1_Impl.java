package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.NewBranchEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_s_r_NewBranchEvent_1_Impl implements GeneratedMarshaller<NewBranchEvent> {
  private NewBranchEvent[] EMPTY_ARRAY = new NewBranchEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public NewBranchEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$916412184__1195259493_repositoryAlias(NewBranchEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewBranchEvent::repositoryAlias;
  }-*/;

  private native static void _$916412184__1195259493_repositoryAlias(NewBranchEvent instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.NewBranchEvent::repositoryAlias = value;
  }-*/;

  private native static String _$916412184__1195259493_branchName(NewBranchEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewBranchEvent::branchName;
  }-*/;

  private native static void _$916412184__1195259493_branchName(NewBranchEvent instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.NewBranchEvent::branchName = value;
  }-*/;

  private native static Path _$916412184__$2084529122_branchPath(NewBranchEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewBranchEvent::branchPath;
  }-*/;

  private native static void _$916412184__$2084529122_branchPath(NewBranchEvent instance, Path value) /*-{
    instance.@org.guvnor.structure.repositories.NewBranchEvent::branchPath = value;
  }-*/;

  private native static Long _$916412184__398795216_timestamp(NewBranchEvent instance) /*-{
    return instance.@org.guvnor.structure.repositories.NewBranchEvent::timestamp;
  }-*/;

  private native static void _$916412184__398795216_timestamp(NewBranchEvent instance, Long value) /*-{
    instance.@org.guvnor.structure.repositories.NewBranchEvent::timestamp = value;
  }-*/;

  public NewBranchEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewBranchEvent.class, objId);
    }
    NewBranchEvent entity = new NewBranchEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("repositoryAlias")) && (!obj.get("repositoryAlias").isNull())) {
      _$916412184__1195259493_repositoryAlias(entity, java_lang_String.demarshall(obj.get("repositoryAlias"), a1));
    }
    if ((obj.containsKey("branchName")) && (!obj.get("branchName").isNull())) {
      _$916412184__1195259493_branchName(entity, java_lang_String.demarshall(obj.get("branchName"), a1));
    }
    if ((obj.containsKey("branchPath")) && (!obj.get("branchPath").isNull())) {
      _$916412184__$2084529122_branchPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("branchPath"), a1));
    }
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      _$916412184__398795216_timestamp(entity, java_lang_Long.demarshall(obj.get("timestamp"), a1));
    }
    return entity;
  }

  public String marshall(NewBranchEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.NewBranchEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"repositoryAlias\":").append(java_lang_String.marshall(a0.getRepositoryAlias(), a1)).append(",").append("\"branchName\":").append(java_lang_String.marshall(a0.getBranchName(), a1)).append(",").append("\"branchPath\":").append(java_lang_Object.marshall(a0.getBranchPath(), a1)).append(",").append("\"timestamp\":").append(java_lang_Long.marshall(a0.getTimestamp(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}