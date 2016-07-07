package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.model.EditorModelContent;
import org.kie.workbench.common.services.datamodeller.core.DataModel;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.kie.workbench.common.services.shared.project.KieProject;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_d_m_EditorModelContent_1_Impl implements GeneratedMarshaller<EditorModelContent> {
  private EditorModelContent[] EMPTY_ARRAY = new EditorModelContent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<KieProject> org_kie_workbench_common_services_shared_project_KieProject = null;
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public EditorModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public EditorModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EditorModelContent.class, objId);
    }
    EditorModelContent entity = new EditorModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      entity.setDataModel((DataModel) ((ObjectMarshaller) java_lang_Object).demarshall(DataModel.class, obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("dataObject")) && (!obj.get("dataObject").isNull())) {
      entity.setDataObject((DataObject) ((ObjectMarshaller) java_lang_Object).demarshall(DataObject.class, obj.get("dataObject"), a1));
    }
    if ((obj.containsKey("originalClassName")) && (!obj.get("originalClassName").isNull())) {
      entity.setOriginalClassName(java_lang_String.demarshall(obj.get("originalClassName"), a1));
    }
    if ((obj.containsKey("originalPackageName")) && (!obj.get("originalPackageName").isNull())) {
      entity.setOriginalPackageName(java_lang_String.demarshall(obj.get("originalPackageName"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      entity.setPath((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      entity.setSource(java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    if ((obj.containsKey("elapsedTime")) && (!obj.get("elapsedTime").isNull())) {
      entity.setElapsedTime(java_lang_Long.demarshall(obj.get("elapsedTime"), a1));
    }
    if ((obj.containsKey("currentProject")) && (!obj.get("currentProject").isNull())) {
      entity.setCurrentProject(org_kie_workbench_common_services_shared_project_KieProject.demarshall(obj.get("currentProject"), a1));
    }
    if ((obj.containsKey("currentProjectPackages")) && (!obj.get("currentProjectPackages").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setCurrentProjectPackages(java_util_Set.demarshall(obj.get("currentProjectPackages"), a1));
    }
    if ((obj.containsKey("dataObjectPaths")) && (!obj.get("dataObjectPaths").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.uberfire.backend.vfs.Path");
      entity.setDataObjectPaths(java_util_Map.demarshall(obj.get("dataObjectPaths"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("annotationDefinitions")) && (!obj.get("annotationDefinitions").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.datamodeller.core.AnnotationDefinition");
      entity.setAnnotationDefinitions(java_util_Map.demarshall(obj.get("annotationDefinitions"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("propertyTypes")) && (!obj.get("propertyTypes").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.PropertyType");
      entity.setPropertyTypes(java_util_List.demarshall(obj.get("propertyTypes"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.datamodeller.model.DataModelerError");
      entity.setErrors(java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(EditorModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.EditorModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataModel\":").append(java_lang_Object.marshall(a0.getDataModel(), a1)).append(",").append("\"dataObject\":").append(java_lang_Object.marshall(a0.getDataObject(), a1)).append(",").append("\"originalClassName\":").append(java_lang_String.marshall(a0.getOriginalClassName(), a1)).append(",").append("\"originalPackageName\":").append(java_lang_String.marshall(a0.getOriginalPackageName(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append(",").append("\"elapsedTime\":").append(java_lang_Long.marshall(a0.getElapsedTime(), a1)).append(",").append("\"currentProject\":").append(org_kie_workbench_common_services_shared_project_KieProject.marshall(a0.getCurrentProject(), a1)).append(",").append("\"currentProjectPackages\":").append(java_util_Set.marshall(a0.getCurrentProjectPackages(), a1)).append(",").append("\"dataObjectPaths\":").append(java_util_Map.marshall(a0.getDataObjectPaths(), a1)).append(",").append("\"annotationDefinitions\":").append(java_util_Map.marshall(a0.getAnnotationDefinitions(), a1)).append(",").append("\"propertyTypes\":").append(java_util_List.marshall(a0.getPropertyTypes(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
    if (org_kie_workbench_common_services_shared_project_KieProject == null) {
      org_kie_workbench_common_services_shared_project_KieProject = Marshalling.getMarshaller(KieProject.class);
    }
  }
}