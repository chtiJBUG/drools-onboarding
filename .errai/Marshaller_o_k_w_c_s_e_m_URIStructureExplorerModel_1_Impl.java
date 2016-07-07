package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.Project;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel;

public class Marshaller_o_k_w_c_s_e_m_URIStructureExplorerModel_1_Impl implements GeneratedMarshaller<URIStructureExplorerModel> {
  private URIStructureExplorerModel[] EMPTY_ARRAY = new URIStructureExplorerModel[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public URIStructureExplorerModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static OrganizationalUnit _2016849337__632841304_organizationalUnit(URIStructureExplorerModel instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::organizationalUnit;
  }-*/;

  private native static void _2016849337__632841304_organizationalUnit(URIStructureExplorerModel instance, OrganizationalUnit value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::organizationalUnit = value;
  }-*/;

  private native static Repository _2016849337__$75759654_repository(URIStructureExplorerModel instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::repository;
  }-*/;

  private native static void _2016849337__$75759654_repository(URIStructureExplorerModel instance, Repository value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::repository = value;
  }-*/;

  private native static Project _2016849337__$608805097_project(URIStructureExplorerModel instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::project;
  }-*/;

  private native static void _2016849337__$608805097_project(URIStructureExplorerModel instance, Project value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel::project = value;
  }-*/;

  public URIStructureExplorerModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(URIStructureExplorerModel.class, objId);
    }
    URIStructureExplorerModel entity = new URIStructureExplorerModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("organizationalUnit")) && (!obj.get("organizationalUnit").isNull())) {
      _2016849337__632841304_organizationalUnit(entity, (OrganizationalUnit) ((ObjectMarshaller) java_lang_Object).demarshall(OrganizationalUnit.class, obj.get("organizationalUnit"), a1));
    }
    if ((obj.containsKey("repository")) && (!obj.get("repository").isNull())) {
      _2016849337__$75759654_repository(entity, (Repository) ((ObjectMarshaller) java_lang_Object).demarshall(Repository.class, obj.get("repository"), a1));
    }
    if ((obj.containsKey("project")) && (!obj.get("project").isNull())) {
      _2016849337__$608805097_project(entity, (Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("project"), a1));
    }
    return entity;
  }

  public String marshall(URIStructureExplorerModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"organizationalUnit\":").append(java_lang_Object.marshall(a0.getOrganizationalUnit(), a1)).append(",").append("\"repository\":").append(java_lang_Object.marshall(a0.getRepository(), a1)).append(",").append("\"project\":").append(java_lang_Object.marshall(a0.getProject(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}