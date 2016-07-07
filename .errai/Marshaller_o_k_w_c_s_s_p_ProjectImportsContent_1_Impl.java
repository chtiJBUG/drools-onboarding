package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.ProjectImports;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.project.ProjectImportsContent;

public class Marshaller_o_k_w_c_s_s_p_ProjectImportsContent_1_Impl implements GeneratedMarshaller<ProjectImportsContent> {
  private ProjectImportsContent[] EMPTY_ARRAY = new ProjectImportsContent[0];
  private Marshaller<ProjectImports> org_guvnor_common_services_project_model_ProjectImports = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public ProjectImportsContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ProjectImports _$1742085485__1718706775_model(ProjectImportsContent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.ProjectImportsContent::model;
  }-*/;

  private native static void _$1742085485__1718706775_model(ProjectImportsContent instance, ProjectImports value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.ProjectImportsContent::model = value;
  }-*/;

  private native static Overview _$1742085485__1909091292_overview(ProjectImportsContent instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.ProjectImportsContent::overview;
  }-*/;

  private native static void _$1742085485__1909091292_overview(ProjectImportsContent instance, Overview value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.ProjectImportsContent::overview = value;
  }-*/;

  public ProjectImportsContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectImportsContent.class, objId);
    }
    ProjectImportsContent entity = new ProjectImportsContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _$1742085485__1718706775_model(entity, org_guvnor_common_services_project_model_ProjectImports.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$1742085485__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(ProjectImportsContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.project.ProjectImportsContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_guvnor_common_services_project_model_ProjectImports.marshall(a0.getModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_ProjectImports == null) {
      org_guvnor_common_services_project_model_ProjectImports = Marshalling.getMarshaller(ProjectImports.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}