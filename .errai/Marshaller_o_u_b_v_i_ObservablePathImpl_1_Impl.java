package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.impl.ObservablePathImpl;

public class Marshaller_o_u_b_v_i_ObservablePathImpl_1_Impl implements GeneratedMarshaller<ObservablePathImpl> {
  private ObservablePathImpl[] EMPTY_ARRAY = new ObservablePathImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ObservablePathImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1304194947__$2084529122_path(ObservablePathImpl instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::path;
  }-*/;

  private native static void _$1304194947__$2084529122_path(ObservablePathImpl instance, Path value) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::path = value;
  }-*/;

  public ObservablePathImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ObservablePathImpl.class, objId);
    }
    ObservablePathImpl entity = new ObservablePathImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _$1304194947__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  public String marshall(ObservablePathImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.ObservablePathImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(_$1304194947__$2084529122_path(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}