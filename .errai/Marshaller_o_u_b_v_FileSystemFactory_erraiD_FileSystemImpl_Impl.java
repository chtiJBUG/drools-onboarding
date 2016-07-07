package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_u_b_v_FileSystemFactory_erraiD_FileSystemImpl_Impl implements GeneratedMarshaller<FileSystemImpl> {
  private FileSystemImpl[] EMPTY_ARRAY = new FileSystemImpl[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public FileSystemImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$1821390935__65821278_rootDirectories(FileSystemImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::rootDirectories;
  }-*/;

  private native static void _$1821390935__65821278_rootDirectories(FileSystemImpl instance, List<Path> value) /*-{
    instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::rootDirectories = value;
  }-*/;

  private native static Set _$1821390935__$1383343454_supportedViews(FileSystemImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::supportedViews;
  }-*/;

  private native static void _$1821390935__$1383343454_supportedViews(FileSystemImpl instance, Set<String> value) /*-{
    instance.@org.uberfire.backend.vfs.FileSystemFactory.FileSystemImpl::supportedViews = value;
  }-*/;

  public FileSystemImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FileSystemImpl.class, objId);
    }
    FileSystemImpl entity = new FileSystemImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("rootDirectories")) && (!obj.get("rootDirectories").isNull())) {
      a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
      _$1821390935__65821278_rootDirectories(entity, java_util_List.demarshall(obj.get("rootDirectories"), a1));
    }
    if ((obj.containsKey("supportedViews")) && (!obj.get("supportedViews").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1821390935__$1383343454_supportedViews(entity, java_util_Set.demarshall(obj.get("supportedViews"), a1));
    }
    return entity;
  }

  public String marshall(FileSystemImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.FileSystemFactory$FileSystemImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"rootDirectories\":").append(java_util_List.marshall(a0.getRootDirectories(), a1)).append(",").append("\"supportedViews\":").append(java_util_Set.marshall(_$1821390935__$1383343454_supportedViews(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}