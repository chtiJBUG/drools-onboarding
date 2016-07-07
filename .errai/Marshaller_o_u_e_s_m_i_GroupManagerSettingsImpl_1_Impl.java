package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.ext.security.management.api.Capability;
import org.uberfire.ext.security.management.api.CapabilityStatus;
import org.uberfire.ext.security.management.impl.GroupManagerSettingsImpl;
import org.uberfire.ext.security.management.impl.SettingsImpl;

public class Marshaller_o_u_e_s_m_i_GroupManagerSettingsImpl_1_Impl implements GeneratedMarshaller<GroupManagerSettingsImpl> {
  private GroupManagerSettingsImpl[] EMPTY_ARRAY = new GroupManagerSettingsImpl[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public GroupManagerSettingsImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _56127073__64711720_allowEmpty(GroupManagerSettingsImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.GroupManagerSettingsImpl::allowEmpty;
  }-*/;

  private native static void _56127073__64711720_allowEmpty(GroupManagerSettingsImpl instance, boolean value) /*-{
    instance.@org.uberfire.ext.security.management.impl.GroupManagerSettingsImpl::allowEmpty = value;
  }-*/;

  private native static Map _1349550867__$1383349348_capabilities(SettingsImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.SettingsImpl::capabilities;
  }-*/;

  private native static void _1349550867__$1383349348_capabilities(SettingsImpl instance, Map<Capability, CapabilityStatus> value) /*-{
    instance.@org.uberfire.ext.security.management.impl.SettingsImpl::capabilities = value;
  }-*/;

  public GroupManagerSettingsImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GroupManagerSettingsImpl.class, objId);
    }
    a1.setAssumedMapKeyType("org.uberfire.ext.security.management.api.Capability");
    a1.setAssumedMapValueType("org.uberfire.ext.security.management.api.CapabilityStatus");
    final Map c0 = java_util_Map.demarshall(obj.get("capabilities"), a1);
    a1.resetAssumedTypes();
    final Boolean c1 = java_lang_Boolean.demarshall(obj.get("allowEmpty"), a1);
    GroupManagerSettingsImpl entity = new GroupManagerSettingsImpl(c0, c1);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("allowEmpty")) && (!obj.get("allowEmpty").isNull())) {
      _56127073__64711720_allowEmpty(entity, java_lang_Boolean.demarshall(obj.get("allowEmpty"), a1));
    }
    if ((obj.containsKey("constrainedGroups")) && (!obj.get("constrainedGroups").isNull())) {
      entity.setConstrainedGroups((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("constrainedGroups"), a1));
    }
    if ((obj.containsKey("capabilities")) && (!obj.get("capabilities").isNull())) {
      a1.setAssumedMapKeyType("org.uberfire.ext.security.management.api.Capability");
      a1.setAssumedMapValueType("org.uberfire.ext.security.management.api.CapabilityStatus");
      _1349550867__$1383349348_capabilities(entity, java_util_Map.demarshall(obj.get("capabilities"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(GroupManagerSettingsImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.GroupManagerSettingsImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"allowEmpty\":").append(java_lang_Boolean.marshall(_56127073__64711720_allowEmpty(a0), a1)).append(",").append("\"constrainedGroups\":").append(java_lang_Object.marshall(a0.getConstrainedGroups(), a1)).append(",").append("\"capabilities\":").append(java_util_Map.marshall(a0.getCapabilities(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}