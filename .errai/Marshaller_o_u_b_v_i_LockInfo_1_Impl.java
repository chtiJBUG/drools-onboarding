package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.impl.LockInfo;

public class Marshaller_o_u_b_v_i_LockInfo_1_Impl implements GeneratedMarshaller<LockInfo> {
  private LockInfo[] EMPTY_ARRAY = new LockInfo[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public LockInfo[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1416358126__1195259493_lockedBy(LockInfo instance) /*-{
    return instance.@org.uberfire.backend.vfs.impl.LockInfo::lockedBy;
  }-*/;

  private native static void _1416358126__1195259493_lockedBy(LockInfo instance, String value) /*-{
    instance.@org.uberfire.backend.vfs.impl.LockInfo::lockedBy = value;
  }-*/;

  public LockInfo demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LockInfo.class, objId);
    }
    final Boolean c0 = java_lang_Boolean.demarshall(obj.get("locked"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("lockedBy"), a1);
    final Path c2 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("file"), a1);
    LockInfo entity = new LockInfo(c0, c1, c2);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("lockedBy")) && (!obj.get("lockedBy").isNull())) {
      _1416358126__1195259493_lockedBy(entity, java_lang_String.demarshall(obj.get("lockedBy"), a1));
    }
    return entity;
  }

  public String marshall(LockInfo a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.LockInfo\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"locked\":").append(java_lang_Boolean.marshall(a0.isLocked(), a1)).append(",").append("\"lockedBy\":").append(java_lang_String.marshall(_1416358126__1195259493_lockedBy(a0), a1)).append(",").append("\"file\":").append(java_lang_Object.marshall(a0.getFile(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}