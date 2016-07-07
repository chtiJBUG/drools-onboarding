package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.impl.LockInfo;
import org.uberfire.backend.vfs.impl.LockResult;

public class Marshaller_o_u_b_v_i_LockResult_1_Impl implements GeneratedMarshaller<LockResult> {
  private LockResult[] EMPTY_ARRAY = new LockResult[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<LockInfo> org_uberfire_backend_vfs_impl_LockInfo = null;
  public LockResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public LockResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LockResult.class, objId);
    }
    final Boolean c0 = java_lang_Boolean.demarshall(obj.get("success"), a1);
    final LockInfo c1 = org_uberfire_backend_vfs_impl_LockInfo.demarshall(obj.get("lockInfo"), a1);
    LockResult entity = new LockResult(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(LockResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.backend.vfs.impl.LockResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"success\":").append(java_lang_Boolean.marshall(a0.isSuccess(), a1)).append(",").append("\"lockInfo\":").append(org_uberfire_backend_vfs_impl_LockInfo.marshall(a0.getLockInfo(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_backend_vfs_impl_LockInfo == null) {
      org_uberfire_backend_vfs_impl_LockInfo = Marshalling.getMarshaller(LockInfo.class);
    }
  }
}