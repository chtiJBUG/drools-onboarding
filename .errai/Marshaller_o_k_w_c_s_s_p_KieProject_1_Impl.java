package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.shared.project.KieProject;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_s_p_KieProject_1_Impl implements GeneratedMarshaller<KieProject> {
  private KieProject[] EMPTY_ARRAY = new KieProject[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<POM> org_guvnor_common_services_project_model_POM = null;
  public KieProject[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _374558147__$2084529122_kmoduleXMLPath(KieProject instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.KieProject::kmoduleXMLPath;
  }-*/;

  private native static void _374558147__$2084529122_kmoduleXMLPath(KieProject instance, Path value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.KieProject::kmoduleXMLPath = value;
  }-*/;

  private native static Path _374558147__$2084529122_importsPath(KieProject instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.KieProject::importsPath;
  }-*/;

  private native static void _374558147__$2084529122_importsPath(KieProject instance, Path value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.KieProject::importsPath = value;
  }-*/;

  private native static Path _374558147__$2084529122_repositoriesPath(KieProject instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.KieProject::repositoriesPath;
  }-*/;

  private native static void _374558147__$2084529122_repositoriesPath(KieProject instance, Path value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.KieProject::repositoriesPath = value;
  }-*/;

  private native static Path _374558147__$2084529122_packageNamesWhiteListPath(KieProject instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.project.KieProject::packageNamesWhiteListPath;
  }-*/;

  private native static void _374558147__$2084529122_packageNamesWhiteListPath(KieProject instance, Path value) /*-{
    instance.@org.kie.workbench.common.services.shared.project.KieProject::packageNamesWhiteListPath = value;
  }-*/;

  private native static Path _$608805097__$2084529122_rootPath(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::rootPath;
  }-*/;

  private native static void _$608805097__$2084529122_rootPath(Project instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::rootPath = value;
  }-*/;

  private native static Path _$608805097__$2084529122_pomXMLPath(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::pomXMLPath;
  }-*/;

  private native static void _$608805097__$2084529122_pomXMLPath(Project instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::pomXMLPath = value;
  }-*/;

  private native static String _$608805097__1195259493_projectName(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::projectName;
  }-*/;

  private native static void _$608805097__1195259493_projectName(Project instance, String value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::projectName = value;
  }-*/;

  private native static Collection _$608805097__$688322466_modules(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::modules;
  }-*/;

  private native static void _$608805097__$688322466_modules(Project instance, Collection<String> value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::modules = value;
  }-*/;

  private native static Collection _$608805097__$688322466_groups(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::groups;
  }-*/;

  private native static void _$608805097__$688322466_groups(Project instance, Collection<String> value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::groups = value;
  }-*/;

  private native static boolean _$608805097__64711720_requiresRefresh(Project instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Project::requiresRefresh;
  }-*/;

  private native static void _$608805097__64711720_requiresRefresh(Project instance, boolean value) /*-{
    instance.@org.guvnor.common.services.project.model.Project::requiresRefresh = value;
  }-*/;

  public KieProject demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KieProject.class, objId);
    }
    KieProject entity = new KieProject();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("kmoduleXMLPath")) && (!obj.get("kmoduleXMLPath").isNull())) {
      _374558147__$2084529122_kmoduleXMLPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("kmoduleXMLPath"), a1));
    }
    if ((obj.containsKey("importsPath")) && (!obj.get("importsPath").isNull())) {
      _374558147__$2084529122_importsPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("importsPath"), a1));
    }
    if ((obj.containsKey("repositoriesPath")) && (!obj.get("repositoriesPath").isNull())) {
      _374558147__$2084529122_repositoriesPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("repositoriesPath"), a1));
    }
    if ((obj.containsKey("packageNamesWhiteListPath")) && (!obj.get("packageNamesWhiteListPath").isNull())) {
      _374558147__$2084529122_packageNamesWhiteListPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("packageNamesWhiteListPath"), a1));
    }
    if ((obj.containsKey("rootPath")) && (!obj.get("rootPath").isNull())) {
      _$608805097__$2084529122_rootPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("rootPath"), a1));
    }
    if ((obj.containsKey("pomXMLPath")) && (!obj.get("pomXMLPath").isNull())) {
      _$608805097__$2084529122_pomXMLPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("pomXMLPath"), a1));
    }
    if ((obj.containsKey("projectName")) && (!obj.get("projectName").isNull())) {
      _$608805097__1195259493_projectName(entity, java_lang_String.demarshall(obj.get("projectName"), a1));
    }
    if ((obj.containsKey("modules")) && (!obj.get("modules").isNull())) {
      _$608805097__$688322466_modules(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("modules"), a1));
    }
    if ((obj.containsKey("groups")) && (!obj.get("groups").isNull())) {
      _$608805097__$688322466_groups(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("groups"), a1));
    }
    if ((obj.containsKey("requiresRefresh")) && (!obj.get("requiresRefresh").isNull())) {
      _$608805097__64711720_requiresRefresh(entity, java_lang_Boolean.demarshall(obj.get("requiresRefresh"), a1));
    }
    if ((obj.containsKey("pom")) && (!obj.get("pom").isNull())) {
      entity.setPom(org_guvnor_common_services_project_model_POM.demarshall(obj.get("pom"), a1));
    }
    return entity;
  }

  public String marshall(KieProject a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.project.KieProject\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"kmoduleXMLPath\":").append(java_lang_Object.marshall(a0.getKModuleXMLPath(), a1)).append(",").append("\"importsPath\":").append(java_lang_Object.marshall(a0.getImportsPath(), a1)).append(",").append("\"repositoriesPath\":").append(java_lang_Object.marshall(a0.getRepositoriesPath(), a1)).append(",").append("\"packageNamesWhiteListPath\":").append(java_lang_Object.marshall(a0.getPackageNamesWhiteListPath(), a1)).append(",").append("\"rootPath\":").append(java_lang_Object.marshall(a0.getRootPath(), a1)).append(",").append("\"pomXMLPath\":").append(java_lang_Object.marshall(a0.getPomXMLPath(), a1)).append(",").append("\"projectName\":").append(java_lang_String.marshall(a0.getProjectName(), a1)).append(",").append("\"modules\":").append(java_lang_Object.marshall(a0.getModules(), a1)).append(",").append("\"groups\":").append(java_lang_Object.marshall(a0.getGroups(), a1)).append(",").append("\"requiresRefresh\":").append(java_lang_Boolean.marshall(_$608805097__64711720_requiresRefresh(a0), a1)).append(",").append("\"pom\":").append(org_guvnor_common_services_project_model_POM.marshall(a0.getPom(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_POM == null) {
      org_guvnor_common_services_project_model_POM = Marshalling.getMarshaller(POM.class);
    }
  }
}