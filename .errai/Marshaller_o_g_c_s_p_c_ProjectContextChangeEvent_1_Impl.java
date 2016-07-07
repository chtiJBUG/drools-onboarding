package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.context.ProjectContextChangeEvent;
import org.guvnor.common.services.project.model.Package;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_c_ProjectContextChangeEvent_1_Impl implements GeneratedMarshaller<ProjectContextChangeEvent> {
  private ProjectContextChangeEvent[] EMPTY_ARRAY = new ProjectContextChangeEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Package> org_guvnor_common_services_project_model_Package = null;
  public ProjectContextChangeEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static OrganizationalUnit _$1231552168__632841304_ou(ProjectContextChangeEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::ou;
  }-*/;

  private native static void _$1231552168__632841304_ou(ProjectContextChangeEvent instance, OrganizationalUnit value) /*-{
    instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::ou = value;
  }-*/;

  private native static Repository _$1231552168__$75759654_repository(ProjectContextChangeEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::repository;
  }-*/;

  private native static void _$1231552168__$75759654_repository(ProjectContextChangeEvent instance, Repository value) /*-{
    instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::repository = value;
  }-*/;

  private native static String _$1231552168__1195259493_branch(ProjectContextChangeEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::branch;
  }-*/;

  private native static void _$1231552168__1195259493_branch(ProjectContextChangeEvent instance, String value) /*-{
    instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::branch = value;
  }-*/;

  private native static Project _$1231552168__$608805097_project(ProjectContextChangeEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::project;
  }-*/;

  private native static void _$1231552168__$608805097_project(ProjectContextChangeEvent instance, Project value) /*-{
    instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::project = value;
  }-*/;

  private native static Package _$1231552168__$1106556860_pkg(ProjectContextChangeEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::pkg;
  }-*/;

  private native static void _$1231552168__$1106556860_pkg(ProjectContextChangeEvent instance, Package value) /*-{
    instance.@org.guvnor.common.services.project.context.ProjectContextChangeEvent::pkg = value;
  }-*/;

  public ProjectContextChangeEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectContextChangeEvent.class, objId);
    }
    ProjectContextChangeEvent entity = new ProjectContextChangeEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("ou")) && (!obj.get("ou").isNull())) {
      _$1231552168__632841304_ou(entity, (OrganizationalUnit) ((ObjectMarshaller) java_lang_Object).demarshall(OrganizationalUnit.class, obj.get("ou"), a1));
    }
    if ((obj.containsKey("repository")) && (!obj.get("repository").isNull())) {
      _$1231552168__$75759654_repository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("repository"), a1));
    }
    if ((obj.containsKey("branch")) && (!obj.get("branch").isNull())) {
      _$1231552168__1195259493_branch(entity, java_lang_String.demarshall(obj.get("branch"), a1));
    }
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _$1231552168__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    if ((obj.containsKey("pkg")) && (!obj.get("pkg").isNull())) {
      _$1231552168__$1106556860_pkg(entity, org_guvnor_common_services_project_model_Package.demarshall(obj.get("pkg"), a1));
    }
    return entity;
  }

  public String marshall(ProjectContextChangeEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.context.ProjectContextChangeEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"ou\":").append(java_lang_Object.marshall(_$1231552168__632841304_ou(a0), a1)).append(",").append("\"repository\":").append(java_lang_Object.marshall(a0.getRepository(), a1)).append(",").append("\"branch\":").append(java_lang_String.marshall(a0.getBranch(), a1)).append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append(",").append("\"pkg\":").append(org_guvnor_common_services_project_model_Package.marshall(_$1231552168__$1106556860_pkg(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_Package == null) {
      org_guvnor_common_services_project_model_Package = Marshalling.getMarshaller(Package.class);
    }
  }
}