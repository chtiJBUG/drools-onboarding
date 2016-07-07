package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.common.services.project.model.POM;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.KBaseModel;
import org.kie.workbench.common.services.shared.kmodule.KModuleModel;

public class Marshaller_o_k_w_c_s_s_k_KModuleModel_1_Impl implements GeneratedMarshaller<KModuleModel> {
  private KModuleModel[] EMPTY_ARRAY = new KModuleModel[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<POM> org_guvnor_common_services_project_model_POM = null;
  public KModuleModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$865887451__$1383349348_kBases(KModuleModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KModuleModel::kBases;
  }-*/;

  private native static void _$865887451__$1383349348_kBases(KModuleModel instance, Map<String, KBaseModel> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KModuleModel::kBases = value;
  }-*/;

  public KModuleModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KModuleModel.class, objId);
    }
    KModuleModel entity = new KModuleModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("kBases")) && (!obj.get("kBases").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.shared.kmodule.KBaseModel");
      _$865887451__$1383349348_kBases(entity, java_util_Map.demarshall(obj.get("kBases"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("kBasesPath")) && (!obj.get("kBasesPath").isNull())) {
      entity.setKBasesPath(java_lang_String.demarshall(obj.get("kBasesPath"), a1));
    }
    if ((obj.containsKey("kModulePath")) && (!obj.get("kModulePath").isNull())) {
      entity.setKModulePath(java_lang_String.demarshall(obj.get("kModulePath"), a1));
    }
    if ((obj.containsKey("groupArtifactVersion")) && (!obj.get("groupArtifactVersion").isNull())) {
      entity.setGroupArtifactVersion(org_guvnor_common_services_project_model_POM.demarshall(obj.get("groupArtifactVersion"), a1));
    }
    return entity;
  }

  public String marshall(KModuleModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.KModuleModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"kBases\":").append(java_util_Map.marshall(a0.getKBases(), a1)).append(",").append("\"kBasesPath\":").append(java_lang_String.marshall(a0.getKBasesPath(), a1)).append(",").append("\"kModulePath\":").append(java_lang_String.marshall(a0.getKModulePath(), a1)).append(",").append("\"groupArtifactVersion\":").append(org_guvnor_common_services_project_model_POM.marshall(a0.getGroupArtifactVersion(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_POM == null) {
      org_guvnor_common_services_project_model_POM = Marshalling.getMarshaller(POM.class);
    }
  }
}