package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.ext.security.management.api.Capability;
import org.uberfire.ext.security.management.api.CapabilityStatus;
import org.uberfire.ext.security.management.impl.SettingsImpl;
import org.uberfire.ext.security.management.impl.UserManagerSettingsImpl;

public class Marshaller_o_u_e_s_m_i_UserManagerSettingsImpl_1_Impl implements GeneratedMarshaller<UserManagerSettingsImpl> {
  private UserManagerSettingsImpl[] EMPTY_ARRAY = new UserManagerSettingsImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public UserManagerSettingsImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _1349550867__$1383349348_capabilities(SettingsImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SettingsImpl::capabilities;
  }-*/;

  private native static void _1349550867__$1383349348_capabilities(SettingsImpl instance, Map<Capability, CapabilityStatus> value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SettingsImpl::capabilities = value;
  }-*/;

  public UserManagerSettingsImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserManagerSettingsImpl.class, objId);
    }
    final Collection c1 = (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("supportedAttributes"), a1);
    a1.setAssumedMapKeyType("org.uberfire.ext.security.management.api.Capability");
    a1.setAssumedMapValueType("org.uberfire.ext.security.management.api.CapabilityStatus");
    final Map c0 = java_util_Map.demarshall(obj.get("capabilities"), a1);
    a1.resetAssumedTypes();
    UserManagerSettingsImpl entity = new UserManagerSettingsImpl(c0, c1);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("capabilities")) && (!obj.get("capabilities").isNull())) {
      a1.setAssumedMapKeyType("org.uberfire.ext.security.management.api.Capability");
      a1.setAssumedMapValueType("org.uberfire.ext.security.management.api.CapabilityStatus");
      _1349550867__$1383349348_capabilities(entity, java_util_Map.demarshall(obj.get("capabilities"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(UserManagerSettingsImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.UserManagerSettingsImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"supportedAttributes\":").append(java_lang_Object.marshall(a0.getSupportedAttributes(), a1)).append(",").append("\"capabilities\":").append(java_util_Map.marshall(a0.getCapabilities(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}