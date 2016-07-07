package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl;

public class Marshaller_o_k_w_c_s_d_c_i_JavaTypeInfoImpl_1_Impl implements GeneratedMarshaller<JavaTypeInfoImpl> {
  private JavaTypeInfoImpl[] EMPTY_ARRAY = new JavaTypeInfoImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public JavaTypeInfoImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$127089648__1195259493__name(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_name;
  }-*/;

  private native static void _$127089648__1195259493__name(JavaTypeInfoImpl instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_name = value;
  }-*/;

  private native static String _$127089648__1195259493__packageName(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_packageName;
  }-*/;

  private native static void _$127089648__1195259493__packageName(JavaTypeInfoImpl instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_packageName = value;
  }-*/;

  private native static boolean _$127089648__64711720__class(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_class;
  }-*/;

  private native static void _$127089648__64711720__class(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_class = value;
  }-*/;

  private native static boolean _$127089648__64711720__interface(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_interface;
  }-*/;

  private native static void _$127089648__64711720__interface(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_interface = value;
  }-*/;

  private native static boolean _$127089648__64711720__annotation(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_annotation;
  }-*/;

  private native static void _$127089648__64711720__annotation(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_annotation = value;
  }-*/;

  private native static boolean _$127089648__64711720__enum(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_enum;
  }-*/;

  private native static void _$127089648__64711720__enum(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_enum = value;
  }-*/;

  private native static boolean _$127089648__64711720__packagePrivate(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_packagePrivate;
  }-*/;

  private native static void _$127089648__64711720__packagePrivate(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_packagePrivate = value;
  }-*/;

  private native static boolean _$127089648__64711720__public(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_public;
  }-*/;

  private native static void _$127089648__64711720__public(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_public = value;
  }-*/;

  private native static boolean _$127089648__64711720__private(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_private;
  }-*/;

  private native static void _$127089648__64711720__private(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_private = value;
  }-*/;

  private native static boolean _$127089648__64711720__protected(JavaTypeInfoImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_protected;
  }-*/;

  private native static void _$127089648__64711720__protected(JavaTypeInfoImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl::_protected = value;
  }-*/;

  public JavaTypeInfoImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JavaTypeInfoImpl.class, objId);
    }
    JavaTypeInfoImpl entity = new JavaTypeInfoImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("_name")) && (!obj.get("_name").isNull())) {
      _$127089648__1195259493__name(entity, java_lang_String.demarshall(obj.get("_name"), a1));
    }
    if ((obj.containsKey("_packageName")) && (!obj.get("_packageName").isNull())) {
      _$127089648__1195259493__packageName(entity, java_lang_String.demarshall(obj.get("_packageName"), a1));
    }
    if ((obj.containsKey("_class")) && (!obj.get("_class").isNull())) {
      _$127089648__64711720__class(entity, java_lang_Boolean.demarshall(obj.get("_class"), a1));
    }
    if ((obj.containsKey("_interface")) && (!obj.get("_interface").isNull())) {
      _$127089648__64711720__interface(entity, java_lang_Boolean.demarshall(obj.get("_interface"), a1));
    }
    if ((obj.containsKey("_annotation")) && (!obj.get("_annotation").isNull())) {
      _$127089648__64711720__annotation(entity, java_lang_Boolean.demarshall(obj.get("_annotation"), a1));
    }
    if ((obj.containsKey("_enum")) && (!obj.get("_enum").isNull())) {
      _$127089648__64711720__enum(entity, java_lang_Boolean.demarshall(obj.get("_enum"), a1));
    }
    if ((obj.containsKey("_packagePrivate")) && (!obj.get("_packagePrivate").isNull())) {
      _$127089648__64711720__packagePrivate(entity, java_lang_Boolean.demarshall(obj.get("_packagePrivate"), a1));
    }
    if ((obj.containsKey("_public")) && (!obj.get("_public").isNull())) {
      _$127089648__64711720__public(entity, java_lang_Boolean.demarshall(obj.get("_public"), a1));
    }
    if ((obj.containsKey("_private")) && (!obj.get("_private").isNull())) {
      _$127089648__64711720__private(entity, java_lang_Boolean.demarshall(obj.get("_private"), a1));
    }
    if ((obj.containsKey("_protected")) && (!obj.get("_protected").isNull())) {
      _$127089648__64711720__protected(entity, java_lang_Boolean.demarshall(obj.get("_protected"), a1));
    }
    return entity;
  }

  public String marshall(JavaTypeInfoImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.JavaTypeInfoImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"_name\":").append(java_lang_String.marshall(_$127089648__1195259493__name(a0), a1)).append(",").append("\"_packageName\":").append(java_lang_String.marshall(_$127089648__1195259493__packageName(a0), a1)).append(",").append("\"_class\":").append(java_lang_Boolean.marshall(_$127089648__64711720__class(a0), a1)).append(",").append("\"_interface\":").append(java_lang_Boolean.marshall(_$127089648__64711720__interface(a0), a1)).append(",").append("\"_annotation\":").append(java_lang_Boolean.marshall(_$127089648__64711720__annotation(a0), a1)).append(",").append("\"_enum\":").append(java_lang_Boolean.marshall(_$127089648__64711720__enum(a0), a1)).append(",").append("\"_packagePrivate\":").append(java_lang_Boolean.marshall(_$127089648__64711720__packagePrivate(a0), a1)).append(",").append("\"_public\":").append(java_lang_Boolean.marshall(_$127089648__64711720__public(a0), a1)).append(",").append("\"_private\":").append(java_lang_Boolean.marshall(_$127089648__64711720__private(a0), a1)).append(",").append("\"_protected\":").append(java_lang_Boolean.marshall(_$127089648__64711720__protected(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}