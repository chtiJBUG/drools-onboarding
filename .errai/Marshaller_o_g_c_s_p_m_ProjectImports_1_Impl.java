package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.imports.Imports;
import org.guvnor.common.services.project.model.ProjectImports;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_ProjectImports_1_Impl implements GeneratedMarshaller<ProjectImports> {
  private ProjectImports[] EMPTY_ARRAY = new ProjectImports[0];
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProjectImports[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Imports _1718706775__$1648285575_imports(ProjectImports instance) /*-{
    return instance.@org.guvnor.common.services.project.model.ProjectImports::imports;
  }-*/;

  private native static void _1718706775__$1648285575_imports(ProjectImports instance, Imports value) /*-{
    instance.@org.guvnor.common.services.project.model.ProjectImports::imports = value;
  }-*/;

  private native static String _1718706775__1195259493_version(ProjectImports instance) /*-{
    return instance.@org.guvnor.common.services.project.model.ProjectImports::version;
  }-*/;

  private native static void _1718706775__1195259493_version(ProjectImports instance, String value) /*-{
    instance.@org.guvnor.common.services.project.model.ProjectImports::version = value;
  }-*/;

  public ProjectImports demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectImports.class, objId);
    }
    ProjectImports entity = new ProjectImports();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      _1718706775__$1648285575_imports(entity, org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      _1718706775__1195259493_version(entity, java_lang_String.demarshall(obj.get("version"), a1));
    }
    return entity;
  }

  public String marshall(ProjectImports a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.ProjectImports\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(_1718706775__1195259493_version(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
  }
}