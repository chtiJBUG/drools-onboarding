package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_c_s_p_m_Project_1_Impl implements GeneratedMarshaller<Project> {
  private Project[] EMPTY_ARRAY = new Project[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<POM> org_guvnor_common_services_project_model_POM = null;
  public Project[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

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

  public Project demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Project.class, objId);
    }
    Project entity = new Project();
    a1.recordObject(objId, entity);
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

  public String marshall(Project a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Project\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"rootPath\":").append(java_lang_Object.marshall(a0.getRootPath(), a1)).append(",").append("\"pomXMLPath\":").append(java_lang_Object.marshall(a0.getPomXMLPath(), a1)).append(",").append("\"projectName\":").append(java_lang_String.marshall(a0.getProjectName(), a1)).append(",").append("\"modules\":").append(java_lang_Object.marshall(a0.getModules(), a1)).append(",").append("\"groups\":").append(java_lang_Object.marshall(a0.getGroups(), a1)).append(",").append("\"requiresRefresh\":").append(java_lang_Boolean.marshall(_$608805097__64711720_requiresRefresh(a0), a1)).append(",").append("\"pom\":").append(org_guvnor_common_services_project_model_POM.marshall(a0.getPom(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_POM == null) {
      org_guvnor_common_services_project_model_POM = Marshalling.getMarshaller(POM.class);
    }
  }
}