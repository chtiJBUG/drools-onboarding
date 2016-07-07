package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.Annotation;
import org.kie.workbench.common.services.datamodeller.core.Visibility;
import org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations;
import org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl;

public class Marshaller_o_k_w_c_s_d_c_i_ObjectPropertyImpl_1_Impl implements GeneratedMarshaller<ObjectPropertyImpl> {
  private ObjectPropertyImpl[] EMPTY_ARRAY = new ObjectPropertyImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Visibility> org_kie_workbench_common_services_datamodeller_core_Visibility = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public ObjectPropertyImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static int _$1518885766__104431_modifiers(ObjectPropertyImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::modifiers;
  }-*/;

  private native static void _$1518885766__104431_modifiers(ObjectPropertyImpl instance, int value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::modifiers = value;
  }-*/;

  private native static Visibility _$1518885766__$651930406_visibility(ObjectPropertyImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::visibility;
  }-*/;

  private native static void _$1518885766__$651930406_visibility(ObjectPropertyImpl instance, Visibility value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::visibility = value;
  }-*/;

  private native static boolean _$1518885766__64711720__static(ObjectPropertyImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::_static;
  }-*/;

  private native static void _$1518885766__64711720__static(ObjectPropertyImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::_static = value;
  }-*/;

  private native static boolean _$1518885766__64711720__final(ObjectPropertyImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::_final;
  }-*/;

  private native static void _$1518885766__64711720__final(ObjectPropertyImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::_final = value;
  }-*/;

  private native static List _623248370__65821278_annotations(AbstractHasAnnotations instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations::annotations;
  }-*/;

  private native static void _623248370__65821278_annotations(AbstractHasAnnotations instance, List<Annotation> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations::annotations = value;
  }-*/;

  public ObjectPropertyImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ObjectPropertyImpl.class, objId);
    }
    ObjectPropertyImpl entity = new ObjectPropertyImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("bag")) && (!obj.get("bag").isNull())) {
      entity.setBag(java_lang_String.demarshall(obj.get("bag"), a1));
    }
    if ((obj.containsKey("multiple")) && (!obj.get("multiple").isNull())) {
      entity.setMultiple(java_lang_Boolean.demarshall(obj.get("multiple"), a1));
    }
    if ((obj.containsKey("modifiers")) && (!obj.get("modifiers").isNull())) {
      _$1518885766__104431_modifiers(entity, java_lang_Integer.demarshall(obj.get("modifiers"), a1));
    }
    if ((obj.containsKey("fileOrder")) && (!obj.get("fileOrder").isNull())) {
      entity.setFileOrder(java_lang_Integer.demarshall(obj.get("fileOrder"), a1));
    }
    if ((obj.containsKey("visibility")) && (!obj.get("visibility").isNull())) {
      _$1518885766__$651930406_visibility(entity, obj.get("visibility").isObject() != null ? Enum.valueOf(Visibility.class, obj.get("visibility").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("visibility").isString() != null ? Enum.valueOf(Visibility.class, obj.get("visibility").isString().stringValue()) : null);
    }
    if ((obj.containsKey("_static")) && (!obj.get("_static").isNull())) {
      _$1518885766__64711720__static(entity, java_lang_Boolean.demarshall(obj.get("_static"), a1));
    }
    if ((obj.containsKey("_final")) && (!obj.get("_final").isNull())) {
      _$1518885766__64711720__final(entity, java_lang_Boolean.demarshall(obj.get("_final"), a1));
    }
    if ((obj.containsKey("annotations")) && (!obj.get("annotations").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.Annotation");
      _623248370__65821278_annotations(entity, java_util_List.demarshall(obj.get("annotations"), a1));
    }
    return entity;
  }

  private native static boolean _$1518885766__64711720_multiple(ObjectPropertyImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::multiple;
  }-*/;

  private native static void _$1518885766__64711720_multiple(ObjectPropertyImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl::multiple = value;
  }-*/;

  public String marshall(ObjectPropertyImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.ObjectPropertyImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"bag\":").append(java_lang_String.marshall(a0.getBag(), a1)).append(",").append("\"multiple\":").append(java_lang_Boolean.marshall(_$1518885766__64711720_multiple(a0), a1)).append(",").append("\"modifiers\":").append(java_lang_Integer.marshall(a0.getModifiers(), a1)).append(",").append("\"fileOrder\":").append(java_lang_Integer.marshall(a0.getFileOrder(), a1)).append(",").append("\"visibility\":").append(_$1518885766__$651930406_visibility(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.Visibility\",\"^EnumStringValue\":\"").append(_$1518885766__$651930406_visibility(a0).name()).append("\"}") : "null").append(",").append("\"_static\":").append(java_lang_Boolean.marshall(_$1518885766__64711720__static(a0), a1)).append(",").append("\"_final\":").append(java_lang_Boolean.marshall(_$1518885766__64711720__final(a0), a1)).append(",").append("\"annotations\":").append(java_util_List.marshall(a0.getAnnotations(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_datamodeller_core_Visibility == null) {
      org_kie_workbench_common_services_datamodeller_core_Visibility = Marshalling.getMarshaller(Visibility.class);
    }
  }
}