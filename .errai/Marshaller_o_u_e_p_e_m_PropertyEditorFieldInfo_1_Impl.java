package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.properties.editor.model.PropertyEditorCategory;
import org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo;
import org.uberfire.ext.properties.editor.model.PropertyEditorType;
import org.uberfire.ext.properties.editor.model.validators.PropertyFieldValidator;

public class Marshaller_o_u_e_p_e_m_PropertyEditorFieldInfo_1_Impl implements GeneratedMarshaller<PropertyEditorFieldInfo> {
  private PropertyEditorFieldInfo[] EMPTY_ARRAY = new PropertyEditorFieldInfo[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PropertyEditorCategory> org_uberfire_ext_properties_editor_model_PropertyEditorCategory = null;
  private Marshaller<PropertyEditorType> org_uberfire_ext_properties_editor_model_PropertyEditorType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public PropertyEditorFieldInfo[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1957235130__1195259493_label(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::label;
  }-*/;

  private native static void _1957235130__1195259493_label(PropertyEditorFieldInfo instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::label = value;
  }-*/;

  private native static String _1957235130__1195259493_originalValue(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::originalValue;
  }-*/;

  private native static void _1957235130__1195259493_originalValue(PropertyEditorFieldInfo instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::originalValue = value;
  }-*/;

  private native static PropertyEditorCategory _1957235130__488487372_category(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::category;
  }-*/;

  private native static void _1957235130__488487372_category(PropertyEditorFieldInfo instance, PropertyEditorCategory value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::category = value;
  }-*/;

  private native static PropertyEditorType _1957235130__1643913992_type(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::type;
  }-*/;

  private native static void _1957235130__1643913992_type(PropertyEditorFieldInfo instance, PropertyEditorType value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::type = value;
  }-*/;

  private native static List _1957235130__65821278_comboValues(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::comboValues;
  }-*/;

  private native static void _1957235130__65821278_comboValues(PropertyEditorFieldInfo instance, List<String> value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::comboValues = value;
  }-*/;

  private native static int _1957235130__104431_priority(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::priority;
  }-*/;

  private native static void _1957235130__104431_priority(PropertyEditorFieldInfo instance, int value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::priority = value;
  }-*/;

  private native static List _1957235130__65821278_validators(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::validators;
  }-*/;

  private native static void _1957235130__65821278_validators(PropertyEditorFieldInfo instance, List<PropertyFieldValidator> value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::validators = value;
  }-*/;

  private native static String _1957235130__1195259493_key(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::key;
  }-*/;

  private native static void _1957235130__1195259493_key(PropertyEditorFieldInfo instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::key = value;
  }-*/;

  private native static boolean _1957235130__64711720_isRemovalSupported(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::isRemovalSupported;
  }-*/;

  private native static void _1957235130__64711720_isRemovalSupported(PropertyEditorFieldInfo instance, boolean value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::isRemovalSupported = value;
  }-*/;

  private native static String _1957235130__1195259493_helpHeading(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::helpHeading;
  }-*/;

  private native static void _1957235130__1195259493_helpHeading(PropertyEditorFieldInfo instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::helpHeading = value;
  }-*/;

  private native static String _1957235130__1195259493_helpText(PropertyEditorFieldInfo instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::helpText;
  }-*/;

  private native static void _1957235130__1195259493_helpText(PropertyEditorFieldInfo instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo::helpText = value;
  }-*/;

  public PropertyEditorFieldInfo demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PropertyEditorFieldInfo.class, objId);
    }
    PropertyEditorFieldInfo entity = new PropertyEditorFieldInfo();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("label")) && (!obj.get("label").isNull())) {
      _1957235130__1195259493_label(entity, java_lang_String.demarshall(obj.get("label"), a1));
    }
    if ((obj.containsKey("currentStringValue")) && (!obj.get("currentStringValue").isNull())) {
      entity.setCurrentStringValue(java_lang_String.demarshall(obj.get("currentStringValue"), a1));
    }
    if ((obj.containsKey("originalValue")) && (!obj.get("originalValue").isNull())) {
      _1957235130__1195259493_originalValue(entity, java_lang_String.demarshall(obj.get("originalValue"), a1));
    }
    if ((obj.containsKey("category")) && (!obj.get("category").isNull())) {
      _1957235130__488487372_category(entity, org_uberfire_ext_properties_editor_model_PropertyEditorCategory.demarshall(obj.get("category"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _1957235130__1643913992_type(entity, obj.get("type").isObject() != null ? Enum.valueOf(PropertyEditorType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(PropertyEditorType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("comboValues")) && (!obj.get("comboValues").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _1957235130__65821278_comboValues(entity, java_util_List.demarshall(obj.get("comboValues"), a1));
    }
    if ((obj.containsKey("priority")) && (!obj.get("priority").isNull())) {
      _1957235130__104431_priority(entity, java_lang_Integer.demarshall(obj.get("priority"), a1));
    }
    if ((obj.containsKey("validators")) && (!obj.get("validators").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.properties.editor.model.validators.PropertyFieldValidator");
      _1957235130__65821278_validators(entity, java_util_List.demarshall(obj.get("validators"), a1));
    }
    if ((obj.containsKey("key")) && (!obj.get("key").isNull())) {
      _1957235130__1195259493_key(entity, java_lang_String.demarshall(obj.get("key"), a1));
    }
    if ((obj.containsKey("isRemovalSupported")) && (!obj.get("isRemovalSupported").isNull())) {
      _1957235130__64711720_isRemovalSupported(entity, java_lang_Boolean.demarshall(obj.get("isRemovalSupported"), a1));
    }
    if ((obj.containsKey("helpHeading")) && (!obj.get("helpHeading").isNull())) {
      _1957235130__1195259493_helpHeading(entity, java_lang_String.demarshall(obj.get("helpHeading"), a1));
    }
    if ((obj.containsKey("helpText")) && (!obj.get("helpText").isNull())) {
      _1957235130__1195259493_helpText(entity, java_lang_String.demarshall(obj.get("helpText"), a1));
    }
    return entity;
  }

  public String marshall(PropertyEditorFieldInfo a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"label\":").append(java_lang_String.marshall(a0.getLabel(), a1)).append(",").append("\"currentStringValue\":").append(java_lang_String.marshall(a0.getCurrentStringValue(), a1)).append(",").append("\"originalValue\":").append(java_lang_String.marshall(a0.getOriginalValue(), a1)).append(",").append("\"category\":").append(org_uberfire_ext_properties_editor_model_PropertyEditorCategory.marshall(_1957235130__488487372_category(a0), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.PropertyEditorType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"comboValues\":").append(java_util_List.marshall(a0.getComboValues(), a1)).append(",").append("\"priority\":").append(java_lang_Integer.marshall(a0.getPriority(), a1)).append(",").append("\"validators\":").append(java_util_List.marshall(a0.getValidators(), a1)).append(",").append("\"key\":").append(java_lang_String.marshall(a0.getKey(), a1)).append(",").append("\"isRemovalSupported\":").append(java_lang_Boolean.marshall(_1957235130__64711720_isRemovalSupported(a0), a1)).append(",").append("\"helpHeading\":").append(java_lang_String.marshall(a0.getHelpHeading(), a1)).append(",").append("\"helpText\":").append(java_lang_String.marshall(a0.getHelpText(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_properties_editor_model_PropertyEditorCategory == null) {
      org_uberfire_ext_properties_editor_model_PropertyEditorCategory = Marshalling.getMarshaller(PropertyEditorCategory.class);
    }
    if (org_uberfire_ext_properties_editor_model_PropertyEditorType == null) {
      org_uberfire_ext_properties_editor_model_PropertyEditorType = Marshalling.getMarshaller(PropertyEditorType.class);
    }
  }
}