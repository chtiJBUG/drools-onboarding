package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.MavenRepositoryMetadata;
import org.guvnor.common.services.project.model.ProjectRepositories.ProjectRepository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_ProjectRepositories_erraiD_ProjectRepository_Impl implements GeneratedMarshaller<ProjectRepository> {
  private ProjectRepository[] EMPTY_ARRAY = new ProjectRepository[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<MavenRepositoryMetadata> org_guvnor_common_services_project_model_MavenRepositoryMetadata = null;
  public ProjectRepository[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _1976951774__64711720_include(ProjectRepository instance) /*-{
    return instance.@org.guvnor.common.services.project.model.ProjectRepositories.ProjectRepository::include;
  }-*/;

  private native static void _1976951774__64711720_include(ProjectRepository instance, boolean value) /*-{
    instance.@org.guvnor.common.services.project.model.ProjectRepositories.ProjectRepository::include = value;
  }-*/;

  public ProjectRepository demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectRepository.class, objId);
    }
    final Boolean c0 = java_lang_Boolean.demarshall(obj.get("include"), a1);
    final MavenRepositoryMetadata c1 = org_guvnor_common_services_project_model_MavenRepositoryMetadata.demarshall(obj.get("metadata"), a1);
    ProjectRepository entity = new ProjectRepository(c0, c1);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("include")) && (!obj.get("include").isNull())) {
      _1976951774__64711720_include(entity, java_lang_Boolean.demarshall(obj.get("include"), a1));
    }
    return entity;
  }

  public String marshall(ProjectRepository a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.ProjectRepositories$ProjectRepository\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"include\":").append(java_lang_Boolean.marshall(_1976951774__64711720_include(a0), a1)).append(",").append("\"metadata\":").append(org_guvnor_common_services_project_model_MavenRepositoryMetadata.marshall(a0.getMetadata(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_MavenRepositoryMetadata == null) {
      org_guvnor_common_services_project_model_MavenRepositoryMetadata = Marshalling.getMarshaller(MavenRepositoryMetadata.class);
    }
  }
}