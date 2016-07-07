package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.datamodeller.core.Annotation;
import org.kie.workbench.common.services.datamodeller.core.JavaType;
import org.kie.workbench.common.services.datamodeller.core.JavaTypeKind;
import org.kie.workbench.common.services.datamodeller.core.Visibility;
import org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations;
import org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType;
import org.kie.workbench.common.services.datamodeller.core.impl.JavaInterfaceImpl;

public class Marshaller_o_k_w_c_s_d_c_i_JavaInterfaceImpl_1_Impl implements GeneratedMarshaller<JavaInterfaceImpl> {
  private JavaInterfaceImpl[] EMPTY_ARRAY = new JavaInterfaceImpl[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Visibility> org_kie_workbench_common_services_datamodeller_core_Visibility = null;
  private Marshaller<JavaTypeKind> org_kie_workbench_common_services_datamodeller_core_JavaTypeKind = null;
  public JavaInterfaceImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _954753329__65821278_interfaces(JavaInterfaceImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaInterfaceImpl::interfaces;
  }-*/;

  private native static void _954753329__65821278_interfaces(JavaInterfaceImpl instance, List<String> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.JavaInterfaceImpl::interfaces = value;
  }-*/;

  private native static JavaType _2125298244__$1750888380_enclosingType(AbstractJavaType instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::enclosingType;
  }-*/;

  private native static void _2125298244__$1750888380_enclosingType(AbstractJavaType instance, JavaType value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::enclosingType = value;
  }-*/;

  private native static List _2125298244__65821278_nestedTypes(AbstractJavaType instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::nestedTypes;
  }-*/;

  private native static void _2125298244__65821278_nestedTypes(AbstractJavaType instance, List<JavaType> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::nestedTypes = value;
  }-*/;

  private native static Visibility _2125298244__$651930406_visibility(AbstractJavaType instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::visibility;
  }-*/;

  private native static void _2125298244__$651930406_visibility(AbstractJavaType instance, Visibility value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::visibility = value;
  }-*/;

  private native static JavaTypeKind _2125298244__$12747272_typeKind(AbstractJavaType instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::typeKind;
  }-*/;

  private native static void _2125298244__$12747272_typeKind(AbstractJavaType instance, JavaTypeKind value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractJavaType::typeKind = value;
  }-*/;

  private native static List _623248370__65821278_annotations(AbstractHasAnnotations instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations::annotations;
  }-*/;

  private native static void _623248370__65821278_annotations(AbstractHasAnnotations instance, List<Annotation> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractHasAnnotations::annotations = value;
  }-*/;

  public JavaInterfaceImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JavaInterfaceImpl.class, objId);
    }
    JavaInterfaceImpl entity = new JavaInterfaceImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("interfaces")) && (!obj.get("interfaces").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _954753329__65821278_interfaces(entity, java_util_List.demarshall(obj.get("interfaces"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("enclosingType")) && (!obj.get("enclosingType").isNull())) {
      _2125298244__$1750888380_enclosingType(entity, (JavaType) ((ObjectMarshaller) java_lang_Object).demarshall(JavaType.class, obj.get("enclosingType"), a1));
    }
    if ((obj.containsKey("nestedTypes")) && (!obj.get("nestedTypes").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.JavaType");
      _2125298244__65821278_nestedTypes(entity, java_util_List.demarshall(obj.get("nestedTypes"), a1));
    }
    if ((obj.containsKey("visibility")) && (!obj.get("visibility").isNull())) {
      _2125298244__$651930406_visibility(entity, obj.get("visibility").isObject() != null ? Enum.valueOf(Visibility.class, obj.get("visibility").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("visibility").isString() != null ? Enum.valueOf(Visibility.class, obj.get("visibility").isString().stringValue()) : null);
    }
    if ((obj.containsKey("typeKind")) && (!obj.get("typeKind").isNull())) {
      _2125298244__$12747272_typeKind(entity, obj.get("typeKind").isObject() != null ? Enum.valueOf(JavaTypeKind.class, obj.get("typeKind").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("typeKind").isString() != null ? Enum.valueOf(JavaTypeKind.class, obj.get("typeKind").isString().stringValue()) : null);
    }
    if ((obj.containsKey("annotations")) && (!obj.get("annotations").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.Annotation");
      _623248370__65821278_annotations(entity, java_util_List.demarshall(obj.get("annotations"), a1));
    }
    return entity;
  }

  public String marshall(JavaInterfaceImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.JavaInterfaceImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"interfaces\":").append(java_util_List.marshall(a0.getInterfaces(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"enclosingType\":").append(java_lang_Object.marshall(a0.getEnclosingType(), a1)).append(",").append("\"nestedTypes\":").append(java_util_List.marshall(a0.getNestedTypes(), a1)).append(",").append("\"visibility\":").append(_2125298244__$651930406_visibility(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.Visibility\",\"^EnumStringValue\":\"").append(_2125298244__$651930406_visibility(a0).name()).append("\"}") : "null").append(",").append("\"typeKind\":").append(a0.getTypeKind() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.JavaTypeKind\",\"^EnumStringValue\":\"").append(a0.getTypeKind().name()).append("\"}") : "null").append(",").append("\"annotations\":").append(java_util_List.marshall(a0.getAnnotations(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_datamodeller_core_Visibility == null) {
      org_kie_workbench_common_services_datamodeller_core_Visibility = Marshalling.getMarshaller(Visibility.class);
    }
    if (org_kie_workbench_common_services_datamodeller_core_JavaTypeKind == null) {
      org_kie_workbench_common_services_datamodeller_core_JavaTypeKind = Marshalling.getMarshaller(JavaTypeKind.class);
    }
  }
}