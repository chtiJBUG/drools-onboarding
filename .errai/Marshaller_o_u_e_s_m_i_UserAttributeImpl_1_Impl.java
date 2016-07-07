package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.security.management.impl.UserAttributeImpl;

public class Marshaller_o_u_e_s_m_i_UserAttributeImpl_1_Impl implements GeneratedMarshaller<UserAttributeImpl> {
  private UserAttributeImpl[] EMPTY_ARRAY = new UserAttributeImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public UserAttributeImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1018561375__64711720_isEditable(UserAttributeImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.UserAttributeImpl::isEditable;
  }-*/;

  private native static void _$1018561375__64711720_isEditable(UserAttributeImpl instance, boolean value) /*-{
    instance.@org.uberfire.ext.security.management.impl.UserAttributeImpl::isEditable = value;
  }-*/;

  private native static boolean _$1018561375__64711720_isMandatory(UserAttributeImpl instance) /*-{
    return instance.@org.uberfire.ext.security.management.impl.UserAttributeImpl::isMandatory;
  }-*/;

  private native static void _$1018561375__64711720_isMandatory(UserAttributeImpl instance, boolean value) /*-{
    instance.@org.uberfire.ext.security.management.impl.UserAttributeImpl::isMandatory = value;
  }-*/;

  public UserAttributeImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserAttributeImpl.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("name"), a1);
    final Boolean c2 = java_lang_Boolean.demarshall(obj.get("isEditable"), a1);
    final Boolean c1 = java_lang_Boolean.demarshall(obj.get("isMandatory"), a1);
    final String c3 = java_lang_String.demarshall(obj.get("defaultValue"), a1);
    UserAttributeImpl entity = new UserAttributeImpl(c0, c1, c2, c3);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("isEditable")) && (!obj.get("isEditable").isNull())) {
      _$1018561375__64711720_isEditable(entity, java_lang_Boolean.demarshall(obj.get("isEditable"), a1));
    }
    if ((obj.containsKey("isMandatory")) && (!obj.get("isMandatory").isNull())) {
      _$1018561375__64711720_isMandatory(entity, java_lang_Boolean.demarshall(obj.get("isMandatory"), a1));
    }
    return entity;
  }

  public String marshall(UserAttributeImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.impl.UserAttributeImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"isEditable\":").append(java_lang_Boolean.marshall(_$1018561375__64711720_isEditable(a0), a1)).append(",").append("\"isMandatory\":").append(java_lang_Boolean.marshall(_$1018561375__64711720_isMandatory(a0), a1)).append(",").append("\"defaultValue\":").append(java_lang_String.marshall(a0.getDefaultValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}