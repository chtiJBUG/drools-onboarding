package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.guvnor.asset.management.model.RepositoryStructureModel;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_a_m_m_RepositoryStructureModel_1_Impl implements GeneratedMarshaller<RepositoryStructureModel> {
  private RepositoryStructureModel[] EMPTY_ARRAY = new RepositoryStructureModel[0];
  private Marshaller<POM> org_guvnor_common_services_project_model_POM = null;
  private Marshaller<Metadata> org_guvnor_common_services_shared_metadata_model_Metadata = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public RepositoryStructureModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$313161961__$2084529122_pathToImports(RepositoryStructureModel instance) /*-{
    return instance.@org.guvnor.asset.management.model.RepositoryStructureModel::pathToImports;
  }-*/;

  private native static void _$313161961__$2084529122_pathToImports(RepositoryStructureModel instance, Path value) /*-{
    instance.@org.guvnor.asset.management.model.RepositoryStructureModel::pathToImports = value;
  }-*/;

  public RepositoryStructureModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryStructureModel.class, objId);
    }
    RepositoryStructureModel entity = new RepositoryStructureModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pom")) && (!obj.get("pom").isNull())) {
      entity.setPOM(org_guvnor_common_services_project_model_POM.demarshall(obj.get("pom"), a1));
    }
    if ((obj.containsKey("POMMetaData")) && (!obj.get("POMMetaData").isNull())) {
      entity.setPOMMetaData(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("POMMetaData"), a1));
    }
    if ((obj.containsKey("pathToPOM")) && (!obj.get("pathToPOM").isNull())) {
      entity.setPathToPOM((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToPOM"), a1));
    }
    if ((obj.containsKey("pathToImports")) && (!obj.get("pathToImports").isNull())) {
      _$313161961__$2084529122_pathToImports(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pathToImports"), a1));
    }
    if ((obj.containsKey("modules")) && (!obj.get("modules").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setModules(java_util_List.demarshall(obj.get("modules"), a1));
    }
    if ((obj.containsKey("modulesProject")) && (!obj.get("modulesProject").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.guvnor.common.services.project.model.Project");
      entity.setModulesProject(java_util_Map.demarshall(obj.get("modulesProject"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("orphanProjects")) && (!obj.get("orphanProjects").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Project");
      entity.setOrphanProjects(java_util_List.demarshall(obj.get("orphanProjects"), a1));
    }
    if ((obj.containsKey("orphanProjectsPOM")) && (!obj.get("orphanProjectsPOM").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.guvnor.common.services.project.model.POM");
      entity.setOrphanProjectsPOM(java_util_Map.demarshall(obj.get("orphanProjectsPOM"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("managed")) && (!obj.get("managed").isNull())) {
      entity.setManaged(java_lang_Boolean.demarshall(obj.get("managed"), a1));
    }
    return entity;
  }

  public String marshall(RepositoryStructureModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.asset.management.model.RepositoryStructureModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pom\":").append(org_guvnor_common_services_project_model_POM.marshall(a0.getPOM(), a1)).append(",").append("\"POMMetaData\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getPOMMetaData(), a1)).append(",").append("\"pathToPOM\":").append(java_lang_Object.marshall(a0.getPathToPOM(), a1)).append(",").append("\"pathToImports\":").append(java_lang_Object.marshall(a0.getPathToImports(), a1)).append(",").append("\"modules\":").append(java_util_List.marshall(a0.getModules(), a1)).append(",").append("\"modulesProject\":").append(java_util_Map.marshall(a0.getModulesProject(), a1)).append(",").append("\"orphanProjects\":").append(java_util_List.marshall(a0.getOrphanProjects(), a1)).append(",").append("\"orphanProjectsPOM\":").append(java_util_Map.marshall(a0.getOrphanProjectsPOM(), a1)).append(",").append("\"managed\":").append(java_lang_Boolean.marshall(a0.getManaged(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_POM == null) {
      org_guvnor_common_services_project_model_POM = Marshalling.getMarshaller(POM.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Metadata == null) {
      org_guvnor_common_services_shared_metadata_model_Metadata = Marshalling.getMarshaller(Metadata.class);
    }
  }
}