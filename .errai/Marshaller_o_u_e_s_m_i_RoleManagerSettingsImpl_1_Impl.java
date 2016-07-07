package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.impl.RoleManagerSettingsImpl;

public class Marshaller_o_u_e_s_m_i_RoleManagerSettingsImpl_1_Impl implements GeneratedMarshaller<RoleManagerSettingsImpl> {
  private RoleManagerSettingsImpl[] EMPTY_ARRAY = new RoleManagerSettingsImpl[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public RoleManagerSettingsImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RoleManagerSettingsImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RoleManagerSettingsImpl.class, objId);
    }
    a1.setAssumedMapKeyType("org.uberfire.ext.security.management.api.Capability");
    a1.setAssumedMapValueType("org.uberfire.ext.security.management.api.CapabilityStatus");
    final Map c0 = java_util_Map.demarshall(obj.get("capabilities"), a1);
    a1.resetAssumedTypes();
    RoleManagerSettingsImpl entity = new RoleManagerSettingsImpl(c0);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(RoleManagerSettingsImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.RoleManagerSettingsImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"capabilities\":").append(java_util_Map.marshall(a0.getCapabilities(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}