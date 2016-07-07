package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.impl.DirectoryStreamImpl;

public class Marshaller_o_u_b_v_i_DirectoryStreamImpl_1_Impl implements GeneratedMarshaller<DirectoryStreamImpl> {
  private DirectoryStreamImpl[] EMPTY_ARRAY = new DirectoryStreamImpl[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public DirectoryStreamImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1281341560__65821278_content(DirectoryStreamImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.DirectoryStreamImpl::content;
  }-*/;

  private native static void _1281341560__65821278_content(DirectoryStreamImpl instance, List<Path> value) /*-{
    instance.@org.uberfire.backend.vfs.impl.DirectoryStreamImpl::content = value;
  }-*/;

  public DirectoryStreamImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DirectoryStreamImpl.class, objId);
    }
    a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
    final List c0 = java_util_List.demarshall(obj.get("content"), a1);
    DirectoryStreamImpl entity = new DirectoryStreamImpl(c0);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("content")) && (!obj.get("content").isNull())) {
      a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
      _1281341560__65821278_content(entity, java_util_List.demarshall(obj.get("content"), a1));
    }
    return entity;
  }

  public String marshall(DirectoryStreamImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.DirectoryStreamImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"content\":").append(java_util_List.marshall(_1281341560__65821278_content(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}