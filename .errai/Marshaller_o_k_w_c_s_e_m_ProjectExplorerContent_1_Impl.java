package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.explorer.model.FolderItem;
import org.kie.workbench.common.screens.explorer.model.FolderListing;
import org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent;

public class Marshaller_o_k_w_c_s_e_m_ProjectExplorerContent_1_Impl implements GeneratedMarshaller<ProjectExplorerContent> {
  private ProjectExplorerContent[] EMPTY_ARRAY = new ProjectExplorerContent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<FolderListing> org_kie_workbench_common_screens_explorer_model_FolderListing = null;
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public ProjectExplorerContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static OrganizationalUnit _$139599637__632841304_organizationalUnit(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::organizationalUnit;
  }-*/;

  private native static void _$139599637__632841304_organizationalUnit(ProjectExplorerContent instance, OrganizationalUnit value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::organizationalUnit = value;
  }-*/;

  private native static Repository _$139599637__$75759654_repository(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::repository;
  }-*/;

  private native static void _$139599637__$75759654_repository(ProjectExplorerContent instance, Repository value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::repository = value;
  }-*/;

  private native static String _$139599637__1195259493_branch(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::branch;
  }-*/;

  private native static void _$139599637__1195259493_branch(ProjectExplorerContent instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::branch = value;
  }-*/;

  private native static Project _$139599637__$608805097_project(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::project;
  }-*/;

  private native static void _$139599637__$608805097_project(ProjectExplorerContent instance, Project value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::project = value;
  }-*/;

  private native static Set _$139599637__$1383343454_organizationalUnits(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::organizationalUnits;
  }-*/;

  private native static void _$139599637__$1383343454_organizationalUnits(ProjectExplorerContent instance, Set<OrganizationalUnit> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::organizationalUnits = value;
  }-*/;

  private native static Set _$139599637__$1383343454_repositories(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::repositories;
  }-*/;

  private native static void _$139599637__$1383343454_repositories(ProjectExplorerContent instance, Set<Repository> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::repositories = value;
  }-*/;

  private native static Set _$139599637__$1383343454_projects(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::projects;
  }-*/;

  private native static void _$139599637__$1383343454_projects(ProjectExplorerContent instance, Set<Project> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::projects = value;
  }-*/;

  private native static FolderListing _$139599637__$2000027412_folderListing(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::folderListing;
  }-*/;

  private native static void _$139599637__$2000027412_folderListing(ProjectExplorerContent instance, FolderListing value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::folderListing = value;
  }-*/;

  private native static Map _$139599637__$1383349348_siblings(ProjectExplorerContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::siblings;
  }-*/;

  private native static void _$139599637__$1383349348_siblings(ProjectExplorerContent instance, Map<FolderItem, List<FolderItem>> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent::siblings = value;
  }-*/;

  public ProjectExplorerContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectExplorerContent.class, objId);
    }
    ProjectExplorerContent entity = new ProjectExplorerContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("organizationalUnit")) && (!obj.get("organizationalUnit").isNull())) {
      _$139599637__632841304_organizationalUnit(entity, (OrganizationalUnit) ((ObjectMarshaller) java_lang_Object).demarshall(OrganizationalUnit.class, obj.get("organizationalUnit"), a1));
    }
    if ((obj.containsKey("repository")) && (!obj.get("repository").isNull())) {
      _$139599637__$75759654_repository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("repository"), a1));
    }
    if ((obj.containsKey("branch")) && (!obj.get("branch").isNull())) {
      _$139599637__1195259493_branch(entity, java_lang_String.demarshall(obj.get("branch"), a1));
    }
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _$139599637__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    if ((obj.containsKey("organizationalUnits")) && (!obj.get("organizationalUnits").isNull())) {
      a1.setAssumedElementType("org.guvnor.structure.organizationalunit.OrganizationalUnit");
      _$139599637__$1383343454_organizationalUnits(entity, java_util_Set.demarshall(obj.get("organizationalUnits"), a1));
    }
    if ((obj.containsKey("repositories")) && (!obj.get("repositories").isNull())) {
      a1.setAssumedElementType("org.guvnor.structure.repositories.Repository");
      _$139599637__$1383343454_repositories(entity, java_util_Set.demarshall(obj.get("repositories"), a1));
    }
    if ((obj.containsKey("projects")) && (!obj.get("projects").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Project");
      _$139599637__$1383343454_projects(entity, java_util_Set.demarshall(obj.get("projects"), a1));
    }
    if ((obj.containsKey("folderListing")) && (!obj.get("folderListing").isNull())) {
      _$139599637__$2000027412_folderListing(entity, org_kie_workbench_common_screens_explorer_model_FolderListing.demarshall(obj.get("folderListing"), a1));
    }
    if ((obj.containsKey("siblings")) && (!obj.get("siblings").isNull())) {
      a1.setAssumedMapKeyType("org.kie.workbench.common.screens.explorer.model.FolderItem");
      a1.setAssumedMapValueType("java.util.List");
      _$139599637__$1383349348_siblings(entity, java_util_Map.demarshall(obj.get("siblings"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(ProjectExplorerContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"organizationalUnit\":").append(java_lang_Object.marshall(a0.getOrganizationalUnit(), a1)).append(",").append("\"repository\":").append(java_lang_Object.marshall(a0.getRepository(), a1)).append(",").append("\"branch\":").append(java_lang_String.marshall(a0.getBranch(), a1)).append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append(",").append("\"organizationalUnits\":").append(java_util_Set.marshall(a0.getOrganizationalUnits(), a1)).append(",").append("\"repositories\":").append(java_util_Set.marshall(a0.getRepositories(), a1)).append(",").append("\"projects\":").append(java_util_Set.marshall(a0.getProjects(), a1)).append(",").append("\"folderListing\":").append(org_kie_workbench_common_screens_explorer_model_FolderListing.marshall(a0.getFolderListing(), a1)).append(",").append("\"siblings\":").append(java_util_Map.marshall(a0.getSiblings(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_explorer_model_FolderListing == null) {
      org_kie_workbench_common_screens_explorer_model_FolderListing = Marshalling.getMarshaller(FolderListing.class);
    }
  }
}