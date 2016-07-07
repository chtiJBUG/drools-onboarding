package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.persistence.CachingType;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceUnitModel;
import org.kie.workbench.common.screens.datamodeller.model.persistence.TransactionType;
import org.kie.workbench.common.screens.datamodeller.model.persistence.ValidationMode;

public class Marshaller_o_k_w_c_s_d_m_p_PersistenceUnitModel_1_Impl implements GeneratedMarshaller<PersistenceUnitModel> {
  private PersistenceUnitModel[] EMPTY_ARRAY = new PersistenceUnitModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<CachingType> org_kie_workbench_common_screens_datamodeller_model_persistence_CachingType = null;
  private Marshaller<ValidationMode> org_kie_workbench_common_screens_datamodeller_model_persistence_ValidationMode = null;
  private Marshaller<TransactionType> org_kie_workbench_common_screens_datamodeller_model_persistence_TransactionType = null;
  public PersistenceUnitModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PersistenceUnitModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PersistenceUnitModel.class, objId);
    }
    PersistenceUnitModel entity = new PersistenceUnitModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      entity.setDescription(java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("provider")) && (!obj.get("provider").isNull())) {
      entity.setProvider(java_lang_String.demarshall(obj.get("provider"), a1));
    }
    if ((obj.containsKey("jtaDataSource")) && (!obj.get("jtaDataSource").isNull())) {
      entity.setJtaDataSource(java_lang_String.demarshall(obj.get("jtaDataSource"), a1));
    }
    if ((obj.containsKey("nonJtaDataSource")) && (!obj.get("nonJtaDataSource").isNull())) {
      entity.setNonJtaDataSource(java_lang_String.demarshall(obj.get("nonJtaDataSource"), a1));
    }
    if ((obj.containsKey("mappingFile")) && (!obj.get("mappingFile").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setMappingFile(java_util_List.demarshall(obj.get("mappingFile"), a1));
    }
    if ((obj.containsKey("jarFile")) && (!obj.get("jarFile").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setJarFile(java_util_List.demarshall(obj.get("jarFile"), a1));
    }
    if ((obj.containsKey("classes")) && (!obj.get("classes").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setClasses(java_util_List.demarshall(obj.get("classes"), a1));
    }
    if ((obj.containsKey("excludeUnlistedClasses")) && (!obj.get("excludeUnlistedClasses").isNull())) {
      entity.setExcludeUnlistedClasses(java_lang_Boolean.demarshall(obj.get("excludeUnlistedClasses"), a1));
    }
    if ((obj.containsKey("sharedCacheMode")) && (!obj.get("sharedCacheMode").isNull())) {
      entity.setSharedCacheMode(obj.get("sharedCacheMode").isObject() != null ? Enum.valueOf(CachingType.class, obj.get("sharedCacheMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("sharedCacheMode").isString() != null ? Enum.valueOf(CachingType.class, obj.get("sharedCacheMode").isString().stringValue()) : null);
    }
    if ((obj.containsKey("validationMode")) && (!obj.get("validationMode").isNull())) {
      entity.setValidationMode(obj.get("validationMode").isObject() != null ? Enum.valueOf(ValidationMode.class, obj.get("validationMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("validationMode").isString() != null ? Enum.valueOf(ValidationMode.class, obj.get("validationMode").isString().stringValue()) : null);
    }
    if ((obj.containsKey("properties")) && (!obj.get("properties").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.datamodeller.model.persistence.Property");
      entity.setProperties(java_util_List.demarshall(obj.get("properties"), a1));
    }
    if ((obj.containsKey("transactionType")) && (!obj.get("transactionType").isNull())) {
      entity.setTransactionType(obj.get("transactionType").isObject() != null ? Enum.valueOf(TransactionType.class, obj.get("transactionType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("transactionType").isString() != null ? Enum.valueOf(TransactionType.class, obj.get("transactionType").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(PersistenceUnitModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceUnitModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"provider\":").append(java_lang_String.marshall(a0.getProvider(), a1)).append(",").append("\"jtaDataSource\":").append(java_lang_String.marshall(a0.getJtaDataSource(), a1)).append(",").append("\"nonJtaDataSource\":").append(java_lang_String.marshall(a0.getNonJtaDataSource(), a1)).append(",").append("\"mappingFile\":").append(java_util_List.marshall(a0.getMappingFile(), a1)).append(",").append("\"jarFile\":").append(java_util_List.marshall(a0.getJarFile(), a1)).append(",").append("\"classes\":").append(java_util_List.marshall(a0.getClasses(), a1)).append(",").append("\"excludeUnlistedClasses\":").append(java_lang_Boolean.marshall(a0.getExcludeUnlistedClasses(), a1)).append(",").append("\"sharedCacheMode\":").append(a0.getSharedCacheMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.CachingType\",\"^EnumStringValue\":\"").append(a0.getSharedCacheMode().name()).append("\"}") : "null").append(",").append("\"validationMode\":").append(a0.getValidationMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.ValidationMode\",\"^EnumStringValue\":\"").append(a0.getValidationMode().name()).append("\"}") : "null").append(",").append("\"properties\":").append(java_util_List.marshall(a0.getProperties(), a1)).append(",").append("\"transactionType\":").append(a0.getTransactionType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.TransactionType\",\"^EnumStringValue\":\"").append(a0.getTransactionType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_datamodeller_model_persistence_CachingType == null) {
      org_kie_workbench_common_screens_datamodeller_model_persistence_CachingType = Marshalling.getMarshaller(CachingType.class);
    }
    if (org_kie_workbench_common_screens_datamodeller_model_persistence_ValidationMode == null) {
      org_kie_workbench_common_screens_datamodeller_model_persistence_ValidationMode = Marshalling.getMarshaller(ValidationMode.class);
    }
    if (org_kie_workbench_common_screens_datamodeller_model_persistence_TransactionType == null) {
      org_kie_workbench_common_screens_datamodeller_model_persistence_TransactionType = Marshalling.getMarshaller(TransactionType.class);
    }
  }
}