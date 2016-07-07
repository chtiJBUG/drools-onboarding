package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.structure.repositories.PublicURI;
import org.guvnor.structure.repositories.RepositoryInfo;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.java.nio.base.version.VersionRecord;

public class Marshaller_o_g_s_r_RepositoryInfo_1_Impl implements GeneratedMarshaller<RepositoryInfo> {
  private RepositoryInfo[] EMPTY_ARRAY = new RepositoryInfo[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public RepositoryInfo[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$611886168__1195259493_alias(RepositoryInfo instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryInfo::alias;
  }-*/;

  private native static void _$611886168__1195259493_alias(RepositoryInfo instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryInfo::alias = value;
  }-*/;

  private native static String _$611886168__1195259493_owner(RepositoryInfo instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryInfo::owner;
  }-*/;

  private native static void _$611886168__1195259493_owner(RepositoryInfo instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryInfo::owner = value;
  }-*/;

  private native static Path _$611886168__$2084529122_root(RepositoryInfo instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryInfo::root;
  }-*/;

  private native static void _$611886168__$2084529122_root(RepositoryInfo instance, Path value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryInfo::root = value;
  }-*/;

  private native static List _$611886168__65821278_publicURIs(RepositoryInfo instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryInfo::publicURIs;
  }-*/;

  private native static void _$611886168__65821278_publicURIs(RepositoryInfo instance, List<PublicURI> value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryInfo::publicURIs = value;
  }-*/;

  private native static List _$611886168__65821278_versionList(RepositoryInfo instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryInfo::versionList;
  }-*/;

  private native static void _$611886168__65821278_versionList(RepositoryInfo instance, List<VersionRecord> value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryInfo::versionList = value;
  }-*/;

  public RepositoryInfo demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryInfo.class, objId);
    }
    RepositoryInfo entity = new RepositoryInfo();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("alias")) && (!obj.get("alias").isNull())) {
      _$611886168__1195259493_alias(entity, java_lang_String.demarshall(obj.get("alias"), a1));
    }
    if ((obj.containsKey("owner")) && (!obj.get("owner").isNull())) {
      _$611886168__1195259493_owner(entity, java_lang_String.demarshall(obj.get("owner"), a1));
    }
    if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
      _$611886168__$2084529122_root(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("root"), a1));
    }
    if ((obj.containsKey("publicURIs")) && (!obj.get("publicURIs").isNull())) {
      a1.setAssumedElementType("org.guvnor.structure.repositories.PublicURI");
      _$611886168__65821278_publicURIs(entity, java_util_List.demarshall(obj.get("publicURIs"), a1));
    }
    if ((obj.containsKey("versionList")) && (!obj.get("versionList").isNull())) {
      a1.setAssumedElementType("org.uberfire.java.nio.base.version.VersionRecord");
      _$611886168__65821278_versionList(entity, java_util_List.demarshall(obj.get("versionList"), a1));
    }
    return entity;
  }

  public String marshall(RepositoryInfo a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.RepositoryInfo\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"alias\":").append(java_lang_String.marshall(a0.getAlias(), a1)).append(",").append("\"owner\":").append(java_lang_String.marshall(a0.getOwner(), a1)).append(",").append("\"root\":").append(java_lang_Object.marshall(a0.getRoot(), a1)).append(",").append("\"publicURIs\":").append(java_util_List.marshall(a0.getPublicURIs(), a1)).append(",").append("\"versionList\":").append(java_util_List.marshall(_$611886168__65821278_versionList(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}