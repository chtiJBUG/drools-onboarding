package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.kie.workbench.common.services.datamodeller.core.AnnotationDefinition;
import org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition.ValuePairType;
import org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl;

public class Marshaller_o_k_w_c_s_d_c_i_AnnotationValuePairDefinitionImpl_1_Impl implements GeneratedMarshaller<AnnotationValuePairDefinitionImpl> {
  private AnnotationValuePairDefinitionImpl[] EMPTY_ARRAY = new AnnotationValuePairDefinitionImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<ValuePairType> org_kie_workbench_common_services_datamodeller_core_AnnotationValuePairDefinition_erraiD_ValuePairType = null;
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  public AnnotationValuePairDefinitionImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Object _$1365020695__1063877011_defaultValue(AnnotationValuePairDefinitionImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::defaultValue;
  }-*/;

  private native static void _$1365020695__1063877011_defaultValue(AnnotationValuePairDefinitionImpl instance, Object value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::defaultValue = value;
  }-*/;

  private native static ValuePairType _$1365020695__1554532584_type(AnnotationValuePairDefinitionImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::type;
  }-*/;

  private native static void _$1365020695__1554532584_type(AnnotationValuePairDefinitionImpl instance, ValuePairType value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::type = value;
  }-*/;

  public AnnotationValuePairDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationValuePairDefinitionImpl.class, objId);
    }
    AnnotationValuePairDefinitionImpl entity = new AnnotationValuePairDefinitionImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("defaultValue")) && (!obj.get("defaultValue").isNull())) {
      _$1365020695__1063877011_defaultValue(entity, ((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("defaultValue"), a1));
    }
    if ((obj.containsKey("array")) && (!obj.get("array").isNull())) {
      entity.setArray(java_lang_Boolean.demarshall(obj.get("array"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$1365020695__1554532584_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(ValuePairType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(ValuePairType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("enumValues")) && (!obj.get("enumValues").isNull())) {
      entity.setEnumValues(arrayOf_java_lang_String_D1.demarshall(obj.get("enumValues"), a1));
    }
    if ((obj.containsKey("annotationDefinition")) && (!obj.get("annotationDefinition").isNull())) {
      entity.setAnnotationDefinition((AnnotationDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(AnnotationDefinition.class, obj.get("annotationDefinition"), a1));
    }
    return entity;
  }

  private native static boolean _$1365020695__64711720_array(AnnotationValuePairDefinitionImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::array;
  }-*/;

  private native static void _$1365020695__64711720_array(AnnotationValuePairDefinitionImpl instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::array = value;
  }-*/;

  private native static String[] _$1365020695__392722245_enumValues(AnnotationValuePairDefinitionImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::enumValues;
  }-*/;

  private native static void _$1365020695__392722245_enumValues(AnnotationValuePairDefinitionImpl instance, String[] value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl::enumValues = value;
  }-*/;

  public String marshall(AnnotationValuePairDefinitionImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.AnnotationValuePairDefinitionImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"defaultValue\":").append(java_lang_Object.marshall(a0.getDefaultValue(), a1)).append(",").append("\"array\":").append(java_lang_Boolean.marshall(_$1365020695__64711720_array(a0), a1)).append(",").append("\"type\":").append(_$1365020695__1554532584_type(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition$ValuePairType\",\"^EnumStringValue\":\"").append(_$1365020695__1554532584_type(a0).name()).append("\"}") : "null").append(",").append("\"enumValues\":").append(arrayOf_java_lang_String_D1.marshall(_$1365020695__392722245_enumValues(a0), a1)).append(",").append("\"annotationDefinition\":").append(java_lang_Object.marshall(a0.getAnnotationDefinition(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_datamodeller_core_AnnotationValuePairDefinition_erraiD_ValuePairType == null) {
      org_kie_workbench_common_services_datamodeller_core_AnnotationValuePairDefinition_erraiD_ValuePairType = Marshalling.getMarshaller(ValuePairType.class);
    }
  }
}