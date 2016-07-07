package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.guvnor.structure.repositories.impl.git.GitRepository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_s_r_i_g_GitRepository_1_Impl implements GeneratedMarshaller<GitRepository> {
  private GitRepository[] EMPTY_ARRAY = new GitRepository[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public GitRepository[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$1253447774__$1383349348_environment(GitRepository instance) /*-{
    return instance.@org.guvnor.structure.repositories.impl.git.GitRepository::environment;
  }-*/;

  private native static void _$1253447774__$1383349348_environment(GitRepository instance, Map value) /*-{
    instance.@org.guvnor.structure.repositories.impl.git.GitRepository::environment = value;
  }-*/;

  private native static String _$1253447774__1195259493_alias(GitRepository instance) /*-{
    return instance.@org.guvnor.structure.repositories.impl.git.GitRepository::alias;
  }-*/;

  private native static void _$1253447774__1195259493_alias(GitRepository instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.impl.git.GitRepository::alias = value;
  }-*/;

  private native static boolean _$1253447774__64711720_requiresRefresh(GitRepository instance) /*-{
    return instance.@org.guvnor.structure.repositories.impl.git.GitRepository::requiresRefresh;
  }-*/;

  private native static void _$1253447774__64711720_requiresRefresh(GitRepository instance, boolean value) /*-{
    instance.@org.guvnor.structure.repositories.impl.git.GitRepository::requiresRefresh = value;
  }-*/;

  public GitRepository demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GitRepository.class, objId);
    }
    GitRepository entity = new GitRepository();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("environment")) && (!obj.get("environment").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$1253447774__$1383349348_environment(entity, java_util_Map.demarshall(obj.get("environment"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("publicURIs")) && (!obj.get("publicURIs").isNull())) {
      a1.setAssumedElementType("org.guvnor.structure.repositories.PublicURI");
      entity.setPublicURIs(java_util_List.demarshall(obj.get("publicURIs"), a1));
    }
    if ((obj.containsKey("alias")) && (!obj.get("alias").isNull())) {
      _$1253447774__1195259493_alias(entity, java_lang_String.demarshall(obj.get("alias"), a1));
    }
    if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
      entity.setRoot((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("root"), a1));
    }
    if ((obj.containsKey("groups")) && (!obj.get("groups").isNull())) {
      entity.setGroups((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("groups"), a1));
    }
    if ((obj.containsKey("requiresRefresh")) && (!obj.get("requiresRefresh").isNull())) {
      _$1253447774__64711720_requiresRefresh(entity, java_lang_Boolean.demarshall(obj.get("requiresRefresh"), a1));
    }
    if ((obj.containsKey("branches")) && (!obj.get("branches").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.uberfire.backend.vfs.Path");
      entity.setBranches(java_util_Map.demarshall(obj.get("branches"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  private native static Map _$1253447774__$1383349348_branches(GitRepository instance) /*-{
    return instance.@org.guvnor.structure.repositories.impl.git.GitRepository::branches;
  }-*/;

  private native static void _$1253447774__$1383349348_branches(GitRepository instance, Map<String, Path> value) /*-{
    instance.@org.guvnor.structure.repositories.impl.git.GitRepository::branches = value;
  }-*/;

  public String marshall(GitRepository a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.impl.git.GitRepository\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"environment\":").append(java_util_Map.marshall(a0.getEnvironment(), a1)).append(",").append("\"publicURIs\":").append(java_util_List.marshall(a0.getPublicURIs(), a1)).append(",").append("\"alias\":").append(java_lang_String.marshall(a0.getAlias(), a1)).append(",").append("\"root\":").append(java_lang_Object.marshall(a0.getRoot(), a1)).append(",").append("\"groups\":").append(java_lang_Object.marshall(a0.getGroups(), a1)).append(",").append("\"requiresRefresh\":").append(java_lang_Boolean.marshall(_$1253447774__64711720_requiresRefresh(a0), a1)).append(",").append("\"branches\":").append(java_util_Map.marshall(_$1253447774__$1383349348_branches(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}