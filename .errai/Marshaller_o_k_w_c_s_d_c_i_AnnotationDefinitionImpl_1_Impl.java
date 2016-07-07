package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.AnnotationRetention;
import org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition;
import org.kie.workbench.common.services.datamodeller.core.ElementType;
import org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition;
import org.kie.workbench.common.services.datamodeller.core.impl.AnnotationDefinitionImpl;

public class Marshaller_o_k_w_c_s_d_c_i_AnnotationDefinitionImpl_1_Impl implements GeneratedMarshaller<AnnotationDefinitionImpl> {
  private AnnotationDefinitionImpl[] EMPTY_ARRAY = new AnnotationDefinitionImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<AnnotationRetention> org_kie_workbench_common_services_datamodeller_core_AnnotationRetention = null;
  public AnnotationDefinitionImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$761704534__1195259493_className(AbstractAnnotationDefinition instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::className;
  }-*/;

  private native static void _$761704534__1195259493_className(AbstractAnnotationDefinition instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::className = value;
  }-*/;

  private native static List _$761704534__65821278_valuePairs(AbstractAnnotationDefinition instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::valuePairs;
  }-*/;

  private native static void _$761704534__65821278_valuePairs(AbstractAnnotationDefinition instance, List<AnnotationValuePairDefinition> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::valuePairs = value;
  }-*/;

  private native static boolean _$761704534__64711720_objectAnnotation(AbstractAnnotationDefinition instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::objectAnnotation;
  }-*/;

  private native static void _$761704534__64711720_objectAnnotation(AbstractAnnotationDefinition instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::objectAnnotation = value;
  }-*/;

  private native static boolean _$761704534__64711720_propertyAnnotation(AbstractAnnotationDefinition instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::propertyAnnotation;
  }-*/;

  private native static void _$761704534__64711720_propertyAnnotation(AbstractAnnotationDefinition instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::propertyAnnotation = value;
  }-*/;

  private native static List _$761704534__65821278_targets(AbstractAnnotationDefinition instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::targets;
  }-*/;

  private native static void _$761704534__65821278_targets(AbstractAnnotationDefinition instance, List<ElementType> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotationDefinition::targets = value;
  }-*/;

  public AnnotationDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationDefinitionImpl.class, objId);
    }
    AnnotationDefinitionImpl entity = new AnnotationDefinitionImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      _$761704534__1195259493_className(entity, java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("valuePairs")) && (!obj.get("valuePairs").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition");
      _$761704534__65821278_valuePairs(entity, java_util_List.demarshall(obj.get("valuePairs"), a1));
    }
    if ((obj.containsKey("objectAnnotation")) && (!obj.get("objectAnnotation").isNull())) {
      _$761704534__64711720_objectAnnotation(entity, java_lang_Boolean.demarshall(obj.get("objectAnnotation"), a1));
    }
    if ((obj.containsKey("propertyAnnotation")) && (!obj.get("propertyAnnotation").isNull())) {
      _$761704534__64711720_propertyAnnotation(entity, java_lang_Boolean.demarshall(obj.get("propertyAnnotation"), a1));
    }
    if ((obj.containsKey("targets")) && (!obj.get("targets").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.ElementType");
      _$761704534__65821278_targets(entity, java_util_List.demarshall(obj.get("targets"), a1));
    }
    if ((obj.containsKey("retention")) && (!obj.get("retention").isNull())) {
      entity.setRetention(obj.get("retention").isObject() != null ? Enum.valueOf(AnnotationRetention.class, obj.get("retention").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("retention").isString() != null ? Enum.valueOf(AnnotationRetention.class, obj.get("retention").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(AnnotationDefinitionImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.AnnotationDefinitionImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"valuePairs\":").append(java_util_List.marshall(a0.getValuePairs(), a1)).append(",").append("\"objectAnnotation\":").append(java_lang_Boolean.marshall(_$761704534__64711720_objectAnnotation(a0), a1)).append(",").append("\"propertyAnnotation\":").append(java_lang_Boolean.marshall(_$761704534__64711720_propertyAnnotation(a0), a1)).append(",").append("\"targets\":").append(java_util_List.marshall(_$761704534__65821278_targets(a0), a1)).append(",").append("\"retention\":").append(a0.getRetention() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.AnnotationRetention\",\"^EnumStringValue\":\"").append(a0.getRetention().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_datamodeller_core_AnnotationRetention == null) {
      org_kie_workbench_common_services_datamodeller_core_AnnotationRetention = Marshalling.getMarshaller(AnnotationRetention.class);
    }
  }
}