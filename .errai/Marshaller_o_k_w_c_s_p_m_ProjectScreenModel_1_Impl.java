package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.ProjectImports;
import org.guvnor.common.services.project.model.ProjectRepositories;
import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel;
import org.kie.workbench.common.services.shared.kmodule.KModuleModel;
import org.kie.workbench.common.services.shared.whitelist.WhiteList;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_p_m_ProjectScreenModel_1_Impl implements GeneratedMarshaller<ProjectScreenModel> {
  private ProjectScreenModel[] EMPTY_ARRAY = new ProjectScreenModel[0];
  private Marshaller<POM> org_guvnor_common_services_project_model_POM = null;
  private Marshaller<KModuleModel> org_kie_workbench_common_services_shared_kmodule_KModuleModel = null;
  private Marshaller<ProjectImports> org_guvnor_common_services_project_model_ProjectImports = null;
  private Marshaller<ProjectRepositories> org_guvnor_common_services_project_model_ProjectRepositories = null;
  private Marshaller<WhiteList> org_kie_workbench_common_services_shared_whitelist_WhiteList = null;
  private Marshaller<Metadata> org_guvnor_common_services_shared_metadata_model_Metadata = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ProjectScreenModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProjectScreenModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectScreenModel.class, objId);
    }
    ProjectScreenModel entity = new ProjectScreenModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pom")) && (!obj.get("pom").isNull())) {
      entity.setPOM(org_guvnor_common_services_project_model_POM.demarshall(obj.get("pom"), a1));
    }
    if ((obj.containsKey("KModule")) && (!obj.get("KModule").isNull())) {
      entity.setKModule(org_kie_workbench_common_services_shared_kmodule_KModuleModel.demarshall(obj.get("KModule"), a1));
    }
    if ((obj.containsKey("projectImports")) && (!obj.get("projectImports").isNull())) {
      entity.setProjectImports(org_guvnor_common_services_project_model_ProjectImports.demarshall(obj.get("projectImports"), a1));
    }
    if ((obj.containsKey("repositories")) && (!obj.get("repositories").isNull())) {
      entity.setRepositories(org_guvnor_common_services_project_model_ProjectRepositories.demarshall(obj.get("repositories"), a1));
    }
    if ((obj.containsKey("whiteList")) && (!obj.get("whiteList").isNull())) {
      entity.setWhiteList(org_kie_workbench_common_services_shared_whitelist_WhiteList.demarshall(obj.get("whiteList"), a1));
    }
    if ((obj.containsKey("POMMetaData")) && (!obj.get("POMMetaData").isNull())) {
      entity.setPOMMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("POMMetaData"), a1));
    }
    if ((obj.containsKey("KModuleMetaData")) && (!obj.get("KModuleMetaData").isNull())) {
      entity.setKModuleMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("KModuleMetaData"), a1));
    }
    if ((obj.containsKey("projectImportsMetaData")) && (!obj.get("projectImportsMetaData").isNull())) {
      entity.setProjectImportsMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("projectImportsMetaData"), a1));
    }
    if ((obj.containsKey("projectTagsMetaData")) && (!obj.get("projectTagsMetaData").isNull())) {
      entity.setProjectTagsMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("projectTagsMetaData"), a1));
    }
    if ((obj.containsKey("whiteListMetaData")) && (!obj.get("whiteListMetaData").isNull())) {
      entity.setWhiteListMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("whiteListMetaData"), a1));
    }
    if ((obj.containsKey("pathToPOM")) && (!obj.get("pathToPOM").isNull())) {
      entity.setPathToPOM((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToPOM"), a1));
    }
    if ((obj.containsKey("pathToKModule")) && (!obj.get("pathToKModule").isNull())) {
      entity.setPathToKModule((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToKModule"), a1));
    }
    if ((obj.containsKey("pathToImports")) && (!obj.get("pathToImports").isNull())) {
      entity.setPathToImports((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToImports"), a1));
    }
    if ((obj.containsKey("pathToRepositories")) && (!obj.get("pathToRepositories").isNull())) {
      entity.setPathToRepositories((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToRepositories"), a1));
    }
    if ((obj.containsKey("pathToWhiteList")) && (!obj.get("pathToWhiteList").isNull())) {
      entity.setPathToWhiteList((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToWhiteList"), a1));
    }
    return entity;
  }

  public String marshall(ProjectScreenModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pom\":").append(org_guvnor_common_services_project_model_POM.marshall(a0.getPOM(), a1)).append(",").append("\"KModule\":").append(org_kie_workbench_common_services_shared_kmodule_KModuleModel.marshall(a0.getKModule(), a1)).append(",").append("\"projectImports\":").append(org_guvnor_common_services_project_model_ProjectImports.marshall(a0.getProjectImports(), a1)).append(",").append("\"repositories\":").append(org_guvnor_common_services_project_model_ProjectRepositories.marshall(a0.getRepositories(), a1)).append(",").append("\"whiteList\":").append(org_kie_workbench_common_services_shared_whitelist_WhiteList.marshall(a0.getWhiteList(), a1)).append(",").append("\"POMMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getPOMMetaData(), a1)).append(",").append("\"KModuleMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getKModuleMetaData(), a1)).append(",").append("\"projectImportsMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getProjectImportsMetaData(), a1)).append(",").append("\"projectTagsMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getProjectTagsMetaData(), a1)).append(",").append("\"whiteListMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getWhiteListMetaData(), a1)).append(",").append("\"pathToPOM\":").append(java_lang_Object.marshall(a0.getPathToPOM(), a1)).append(",").append("\"pathToKModule\":").append(java_lang_Object.marshall(a0.getPathToKModule(), a1)).append(",").append("\"pathToImports\":").append(java_lang_Object.marshall(a0.getPathToImports(), a1)).append(",").append("\"pathToRepositories\":").append(java_lang_Object.marshall(a0.getPathToRepositories(), a1)).append(",").append("\"pathToWhiteList\":").append(java_lang_Object.marshall(a0.getPathToWhiteList(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_POM == null) {
      org_guvnor_common_services_project_model_POM = Marshalling.getMarshaller(POM.class);
    }
    if (org_kie_workbench_common_services_shared_kmodule_KModuleModel == null) {
      org_kie_workbench_common_services_shared_kmodule_KModuleModel = Marshalling.getMarshaller(KModuleModel.class);
    }
    if (org_guvnor_common_services_project_model_ProjectImports == null) {
      org_guvnor_common_services_project_model_ProjectImports = Marshalling.getMarshaller(ProjectImports.class);
    }
    if (org_guvnor_common_services_project_model_ProjectRepositories == null) {
      org_guvnor_common_services_project_model_ProjectRepositories = Marshalling.getMarshaller(ProjectRepositories.class);
    }
    if (org_kie_workbench_common_services_shared_whitelist_WhiteList == null) {
      org_kie_workbench_common_services_shared_whitelist_WhiteList = Marshalling.getMarshaller(WhiteList.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Metadata == null) {
      org_guvnor_common_services_shared_metadata_model_Metadata = Marshalling.getMarshaller(Metadata.class);
    }
  }
}