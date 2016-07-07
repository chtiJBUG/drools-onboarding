package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators;
import org.drools.workbench.models.datamodel.oracle.ModelField;
import org.drools.workbench.models.datamodel.oracle.ModelField.FIELD_CLASS_TYPE;
import org.drools.workbench.models.datamodel.oracle.ModelField.FIELD_ORIGIN;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.LazyModelField;

public class Marshaller_o_k_w_c_s_d_m_LazyModelField_1_Impl implements GeneratedMarshaller<LazyModelField> {
  private LazyModelField[] EMPTY_ARRAY = new LazyModelField[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<FieldAccessorsAndMutators> org_drools_workbench_models_datamodel_oracle_FieldAccessorsAndMutators = null;
  private Marshaller<FIELD_CLASS_TYPE> org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_CLASS_erraiU_TYPE = null;
  private Marshaller<FIELD_ORIGIN> org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_ORIGIN = null;
  public LazyModelField[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _440145612__1195259493_name(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::name;
  }-*/;

  private native static void _440145612__1195259493_name(ModelField instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::name = value;
  }-*/;

  private native static String _440145612__1195259493_className(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::className;
  }-*/;

  private native static void _440145612__1195259493_className(ModelField instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::className = value;
  }-*/;

  private native static FieldAccessorsAndMutators _440145612__$23856869_accessorsAndMutators(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::accessorsAndMutators;
  }-*/;

  private native static void _440145612__$23856869_accessorsAndMutators(ModelField instance, FieldAccessorsAndMutators value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::accessorsAndMutators = value;
  }-*/;

  private native static String _440145612__1195259493_type(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::type;
  }-*/;

  private native static void _440145612__1195259493_type(ModelField instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::type = value;
  }-*/;

  private native static FIELD_CLASS_TYPE _440145612__23410974_classType(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::classType;
  }-*/;

  private native static void _440145612__23410974_classType(ModelField instance, FIELD_CLASS_TYPE value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::classType = value;
  }-*/;

  private native static FIELD_ORIGIN _440145612__777809155_fieldOrigin(ModelField instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.ModelField::fieldOrigin;
  }-*/;

  private native static void _440145612__777809155_fieldOrigin(ModelField instance, FIELD_ORIGIN value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.ModelField::fieldOrigin = value;
  }-*/;

  public LazyModelField demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LazyModelField.class, objId);
    }
    LazyModelField entity = new LazyModelField();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _440145612__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      _440145612__1195259493_className(entity, java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("accessorsAndMutators")) && (!obj.get("accessorsAndMutators").isNull())) {
      _440145612__$23856869_accessorsAndMutators(entity, obj.get("accessorsAndMutators").isObject() != null ? Enum.valueOf(FieldAccessorsAndMutators.class, obj.get("accessorsAndMutators").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("accessorsAndMutators").isString() != null ? Enum.valueOf(FieldAccessorsAndMutators.class, obj.get("accessorsAndMutators").isString().stringValue()) : null);
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _440145612__1195259493_type(entity, java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("classType")) && (!obj.get("classType").isNull())) {
      _440145612__23410974_classType(entity, obj.get("classType").isObject() != null ? Enum.valueOf(FIELD_CLASS_TYPE.class, obj.get("classType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("classType").isString() != null ? Enum.valueOf(FIELD_CLASS_TYPE.class, obj.get("classType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("fieldOrigin")) && (!obj.get("fieldOrigin").isNull())) {
      _440145612__777809155_fieldOrigin(entity, obj.get("fieldOrigin").isObject() != null ? Enum.valueOf(FIELD_ORIGIN.class, obj.get("fieldOrigin").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("fieldOrigin").isString() != null ? Enum.valueOf(FIELD_ORIGIN.class, obj.get("fieldOrigin").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(LazyModelField a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodel.model.LazyModelField\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"accessorsAndMutators\":").append(a0.getAccessorsAndMutators() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators\",\"^EnumStringValue\":\"").append(a0.getAccessorsAndMutators().name()).append("\"}") : "null").append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"classType\":").append(a0.getClassType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.ModelField$FIELD_CLASS_TYPE\",\"^EnumStringValue\":\"").append(a0.getClassType().name()).append("\"}") : "null").append(",").append("\"fieldOrigin\":").append(_440145612__777809155_fieldOrigin(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.ModelField$FIELD_ORIGIN\",\"^EnumStringValue\":\"").append(_440145612__777809155_fieldOrigin(a0).name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_oracle_FieldAccessorsAndMutators == null) {
      org_drools_workbench_models_datamodel_oracle_FieldAccessorsAndMutators = Marshalling.getMarshaller(FieldAccessorsAndMutators.class);
    }
    if (org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_CLASS_erraiU_TYPE == null) {
      org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_CLASS_erraiU_TYPE = Marshalling.getMarshaller(FIELD_CLASS_TYPE.class);
    }
    if (org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_ORIGIN == null) {
      org_drools_workbench_models_datamodel_oracle_ModelField_erraiD_FIELD_erraiU_ORIGIN = Marshalling.getMarshaller(FIELD_ORIGIN.class);
    }
  }
}