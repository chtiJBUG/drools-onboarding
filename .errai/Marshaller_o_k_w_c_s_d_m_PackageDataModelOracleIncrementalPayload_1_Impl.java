package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleIncrementalPayload;

public class Marshaller_o_k_w_c_s_d_m_PackageDataModelOracleIncrementalPayload_1_Impl implements GeneratedMarshaller<PackageDataModelOracleIncrementalPayload> {
  private PackageDataModelOracleIncrementalPayload[] EMPTY_ARRAY = new PackageDataModelOracleIncrementalPayload[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public PackageDataModelOracleIncrementalPayload[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PackageDataModelOracleIncrementalPayload demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PackageDataModelOracleIncrementalPayload.class, objId);
    }
    PackageDataModelOracleIncrementalPayload entity = new PackageDataModelOracleIncrementalPayload();
    a1.recordObject(objId, entity);
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
    return entity;
  }

  public String marshall(PackageDataModelOracleIncrementalPayload a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleIncrementalPayload\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"modelFields\":").append(java_util_Map.marshall(a0.getModelFields(), a1)).append(",").append("\"fieldParametersType\":").append(java_util_Map.marshall(a0.getFieldParametersType(), a1)).append(",").append("\"eventTypes\":").append(java_util_Map.marshall(a0.getEventTypes(), a1)).append(",").append("\"typeSources\":").append(java_util_Map.marshall(a0.getTypeSources(), a1)).append(",").append("\"superTypes\":").append(java_util_Map.marshall(a0.getSuperTypes(), a1)).append(",").append("\"typeAnnotations\":").append(java_util_Map.marshall(a0.getTypeAnnotations(), a1)).append(",").append("\"typeFieldsAnnotations\":").append(java_util_Map.marshall(a0.getTypeFieldsAnnotations(), a1)).append(",").append("\"methodInformation\":").append(java_util_Map.marshall(a0.getMethodInformation(), a1)).append(",").append("\"collectionTypes\":").append(java_util_Map.marshall(a0.getCollectionTypes(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}