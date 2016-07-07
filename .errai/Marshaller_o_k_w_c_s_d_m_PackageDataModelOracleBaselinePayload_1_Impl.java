package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;

public class Marshaller_o_k_w_c_s_d_m_PackageDataModelOracleBaselinePayload_1_Impl implements GeneratedMarshaller<PackageDataModelOracleBaselinePayload> {
  private PackageDataModelOracleBaselinePayload[] EMPTY_ARRAY = new PackageDataModelOracleBaselinePayload[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public PackageDataModelOracleBaselinePayload[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$174876271__$1383349348_javaEnumLists(PackageDataModelOracleBaselinePayload instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::javaEnumLists;
  }-*/;

  private native static void _$174876271__$1383349348_javaEnumLists(PackageDataModelOracleBaselinePayload instance, Map<String, String[]> value) /*-{
    instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::javaEnumLists = value;
  }-*/;

  private native static Map _$174876271__$1383349348_workbenchEnumLists(PackageDataModelOracleBaselinePayload instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::workbenchEnumLists;
  }-*/;

  private native static void _$174876271__$1383349348_workbenchEnumLists(PackageDataModelOracleBaselinePayload instance, Map<String, String[]> value) /*-{
    instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::workbenchEnumLists = value;
  }-*/;

  public PackageDataModelOracleBaselinePayload demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PackageDataModelOracleBaselinePayload.class, objId);
    }
    PackageDataModelOracleBaselinePayload entity = new PackageDataModelOracleBaselinePayload();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("projectName")) && (!obj.get("projectName").isNull())) {
      entity.setProjectName(java_lang_String.demarshall(obj.get("projectName"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("modelFields")) && (!obj.get("modelFields").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("[Lorg.drools.workbench.models.datamodel.oracle.ModelField;");
      entity.setModelFields(java_util_Map.demarshall(obj.get("modelFields"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("fieldParametersType")) && (!obj.get("fieldParametersType").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setFieldParametersType(java_util_Map.demarshall(obj.get("fieldParametersType"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("eventTypes")) && (!obj.get("eventTypes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Boolean");
      entity.setEventTypes(java_util_Map.demarshall(obj.get("eventTypes"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("typeSources")) && (!obj.get("typeSources").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.drools.workbench.models.datamodel.oracle.TypeSource");
      entity.setTypeSources(java_util_Map.demarshall(obj.get("typeSources"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("superTypes")) && (!obj.get("superTypes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.List");
      entity.setSuperTypes(java_util_Map.demarshall(obj.get("superTypes"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("typeAnnotations")) && (!obj.get("typeAnnotations").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.Set");
      entity.setTypeAnnotations(java_util_Map.demarshall(obj.get("typeAnnotations"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("typeFieldsAnnotations")) && (!obj.get("typeFieldsAnnotations").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.Map");
      entity.setTypeFieldsAnnotations(java_util_Map.demarshall(obj.get("typeFieldsAnnotations"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("javaEnumLists")) && (!obj.get("javaEnumLists").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("[Ljava.lang.String;");
      _$174876271__$1383349348_javaEnumLists(entity, java_util_Map.demarshall(obj.get("javaEnumLists"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("workbenchEnumLists")) && (!obj.get("workbenchEnumLists").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("[Ljava.lang.String;");
      _$174876271__$1383349348_workbenchEnumLists(entity, java_util_Map.demarshall(obj.get("workbenchEnumLists"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("methodInformation")) && (!obj.get("methodInformation").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.List");
      entity.setMethodInformation(java_util_Map.demarshall(obj.get("methodInformation"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("collectionTypes")) && (!obj.get("collectionTypes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Boolean");
      entity.setCollectionTypes(java_util_Map.demarshall(obj.get("collectionTypes"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("dslConditionSentences")) && (!obj.get("dslConditionSentences").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.DSLSentence");
      entity.setDslConditionSentences(java_util_List.demarshall(obj.get("dslConditionSentences"), a1));
    }
    if ((obj.containsKey("dslActionSentences")) && (!obj.get("dslActionSentences").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.DSLSentence");
      entity.setDslActionSentences(java_util_List.demarshall(obj.get("dslActionSentences"), a1));
    }
    if ((obj.containsKey("globalTypes")) && (!obj.get("globalTypes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setGlobalTypes(java_util_Map.demarshall(obj.get("globalTypes"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("packageNames")) && (!obj.get("packageNames").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setPackageNames(java_util_List.demarshall(obj.get("packageNames"), a1));
    }
    return entity;
  }

  private native static Map _$174876271__$1383349348_globalTypes(PackageDataModelOracleBaselinePayload instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::globalTypes;
  }-*/;

  private native static void _$174876271__$1383349348_globalTypes(PackageDataModelOracleBaselinePayload instance, Map<String, String> value) /*-{
    instance.@org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload::globalTypes = value;
  }-*/;

  public String marshall(PackageDataModelOracleBaselinePayload a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"projectName\":").append(java_lang_String.marshall(a0.getProjectName(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"modelFields\":").append(java_util_Map.marshall(a0.getModelFields(), a1)).append(",").append("\"fieldParametersType\":").append(java_util_Map.marshall(a0.getFieldParametersType(), a1)).append(",").append("\"eventTypes\":").append(java_util_Map.marshall(a0.getEventTypes(), a1)).append(",").append("\"typeSources\":").append(java_util_Map.marshall(a0.getTypeSources(), a1)).append(",").append("\"superTypes\":").append(java_util_Map.marshall(a0.getSuperTypes(), a1)).append(",").append("\"typeAnnotations\":").append(java_util_Map.marshall(a0.getTypeAnnotations(), a1)).append(",").append("\"typeFieldsAnnotations\":").append(java_util_Map.marshall(a0.getTypeFieldsAnnotations(), a1)).append(",").append("\"javaEnumLists\":").append(java_util_Map.marshall(_$174876271__$1383349348_javaEnumLists(a0), a1)).append(",").append("\"workbenchEnumLists\":").append(java_util_Map.marshall(_$174876271__$1383349348_workbenchEnumLists(a0), a1)).append(",").append("\"methodInformation\":").append(java_util_Map.marshall(a0.getMethodInformation(), a1)).append(",").append("\"collectionTypes\":").append(java_util_Map.marshall(a0.getCollectionTypes(), a1)).append(",").append("\"dslConditionSentences\":").append(java_util_List.marshall(a0.getDslConditionSentences(), a1)).append(",").append("\"dslActionSentences\":").append(java_util_List.marshall(a0.getDslActionSentences(), a1)).append(",").append("\"globalTypes\":").append(java_util_Map.marshall(_$174876271__$1383349348_globalTypes(a0), a1)).append(",").append("\"packageNames\":").append(java_util_List.marshall(a0.getPackageNames(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}