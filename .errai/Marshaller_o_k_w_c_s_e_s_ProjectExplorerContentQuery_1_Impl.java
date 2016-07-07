package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.Package;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.explorer.model.FolderItem;
import org.kie.workbench.common.screens.explorer.service.ActiveOptions;
import org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery;

public class Marshaller_o_k_w_c_s_e_s_ProjectExplorerContentQuery_1_Impl implements GeneratedMarshaller<ProjectExplorerContentQuery> {
  private ProjectExplorerContentQuery[] EMPTY_ARRAY = new ProjectExplorerContentQuery[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Package> org_guvnor_common_services_project_model_Package = null;
  private Marshaller<FolderItem> org_kie_workbench_common_screens_explorer_model_FolderItem = null;
  private Marshaller<ActiveOptions> org_kie_workbench_common_screens_explorer_service_ActiveOptions = null;
  public ProjectExplorerContentQuery[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static OrganizationalUnit _170289513__632841304_organizationalUnit(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::organizationalUnit;
  }-*/;

  private native static void _170289513__632841304_organizationalUnit(ProjectExplorerContentQuery instance, OrganizationalUnit value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::organizationalUnit = value;
  }-*/;

  private native static Repository _170289513__$75759654_repository(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::repository;
  }-*/;

  private native static void _170289513__$75759654_repository(ProjectExplorerContentQuery instance, Repository value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::repository = value;
  }-*/;

  private native static String _170289513__1195259493_branch(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::branch;
  }-*/;

  private native static void _170289513__1195259493_branch(ProjectExplorerContentQuery instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::branch = value;
  }-*/;

  private native static Project _170289513__$608805097_project(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::project;
  }-*/;

  private native static void _170289513__$608805097_project(ProjectExplorerContentQuery instance, Project value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::project = value;
  }-*/;

  private native static Package _170289513__$1106556860_pkg(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::pkg;
  }-*/;

  private native static void _170289513__$1106556860_pkg(ProjectExplorerContentQuery instance, Package value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::pkg = value;
  }-*/;

  private native static FolderItem _170289513__933498283_item(ProjectExplorerContentQuery instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::item;
  }-*/;

  private native static void _170289513__933498283_item(ProjectExplorerContentQuery instance, FolderItem value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery::item = value;
  }-*/;

  public ProjectExplorerContentQuery demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectExplorerContentQuery.class, objId);
    }
    ProjectExplorerContentQuery entity = new ProjectExplorerContentQuery();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("organizationalUnit")) && (!obj.get("organizationalUnit").isNull())) {
      _170289513__632841304_organizationalUnit(entity, (OrganizationalUnit) ((ObjectMarshaller) java_lang_Object).demarshall(OrganizationalUnit.class, obj.get("organizationalUnit"), a1));
    }
    if ((obj.containsKey("repository")) && (!obj.get("repository").isNull())) {
      _170289513__$75759654_repository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("repository"), a1));
    }
    if ((obj.containsKey("branch")) && (!obj.get("branch").isNull())) {
      _170289513__1195259493_branch(entity, java_lang_String.demarshall(obj.get("branch"), a1));
    }
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _170289513__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    if ((obj.containsKey("pkg")) && (!obj.get("pkg").isNull())) {
      _170289513__$1106556860_pkg(entity, org_guvnor_common_services_project_model_Package.demarshall(obj.get("pkg"), a1));
    }
    if ((obj.containsKey("item")) && (!obj.get("item").isNull())) {
      _170289513__933498283_item(entity, org_kie_workbench_common_screens_explorer_model_FolderItem.demarshall(obj.get("item"), a1));
    }
    if ((obj.containsKey("options")) && (!obj.get("options").isNull())) {
      entity.setOptions(org_kie_workbench_common_screens_explorer_service_ActiveOptions.demarshall(obj.get("options"), a1));
    }
    return entity;
  }

  public String marshall(ProjectExplorerContentQuery a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"organizationalUnit\":").append(java_lang_Object.marshall(a0.getOrganizationalUnit(), a1)).append(",").append("\"repository\":").append(java_lang_Object.marshall(a0.getRepository(), a1)).append(",").append("\"branch\":").append(java_lang_String.marshall(a0.getBranch(), a1)).append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append(",").append("\"pkg\":").append(org_guvnor_common_services_project_model_Package.marshall(a0.getPkg(), a1)).append(",").append("\"item\":").append(org_kie_workbench_common_screens_explorer_model_FolderItem.marshall(a0.getItem(), a1)).append(",").append("\"options\":").append(org_kie_workbench_common_screens_explorer_service_ActiveOptions.marshall(a0.getOptions(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_Package == null) {
      org_guvnor_common_services_project_model_Package = Marshalling.getMarshaller(Package.class);
    }
    if (org_kie_workbench_common_screens_explorer_model_FolderItem == null) {
      org_kie_workbench_common_screens_explorer_model_FolderItem = Marshalling.getMarshaller(FolderItem.class);
    }
    if (org_kie_workbench_common_screens_explorer_service_ActiveOptions == null) {
      org_kie_workbench_common_screens_explorer_service_ActiveOptions = Marshalling.getMarshaller(ActiveOptions.class);
    }
  }
}