package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.common.services.project.model.Build;
import org.guvnor.common.services.project.model.Dependency;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_m_POM_1_Impl implements GeneratedMarshaller<POM> {
  private POM[] EMPTY_ARRAY = new POM[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Build> org_guvnor_common_services_project_model_Build = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public POM[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GAV _$1747095220__$1747104294_gav(POM instance) /*-{
    return instance.@org.guvnor.common.services.project.model.POM::gav;
  }-*/;

  private native static void _$1747095220__$1747104294_gav(POM instance, GAV value) /*-{
    instance.@org.guvnor.common.services.project.model.POM::gav = value;
  }-*/;

  private native static List _$1747095220__65821278_repositories(POM instance) /*-{
    return instance.@org.guvnor.common.services.project.model.POM::repositories;
  }-*/;

  private native static void _$1747095220__65821278_repositories(POM instance, List<Repository> value) /*-{
    instance.@org.guvnor.common.services.project.model.POM::repositories = value;
  }-*/;

  public POM demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(POM.class, objId);
    }
    POM entity = new POM();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      entity.setParent((GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("parent"), a1));
    }
    if ((obj.containsKey("gav")) && (!obj.get("gav").isNull())) {
      _$1747095220__$1747104294_gav(entity, (GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("gav"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      entity.setDescription(java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("packaging")) && (!obj.get("packaging").isNull())) {
      entity.setPackaging(java_lang_String.demarshall(obj.get("packaging"), a1));
    }
    if ((obj.containsKey("build")) && (!obj.get("build").isNull())) {
      entity.setBuild(org_guvnor_common_services_project_model_Build.demarshall(obj.get("build"), a1));
    }
    if ((obj.containsKey("dependencies")) && (!obj.get("dependencies").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Dependency");
      entity.setDependencies(java_util_List.demarshall(obj.get("dependencies"), a1));
    }
    if ((obj.containsKey("repositories")) && (!obj.get("repositories").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Repository");
      _$1747095220__65821278_repositories(entity, java_util_List.demarshall(obj.get("repositories"), a1));
    }
    if ((obj.containsKey("modules")) && (!obj.get("modules").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setModules(java_util_List.demarshall(obj.get("modules"), a1));
    }
    return entity;
  }

  private native static List _$1747095220__65821278_dependencies(POM instance) /*-{
    return instance.@org.guvnor.common.services.project.model.POM::dependencies;
  }-*/;

  private native static void _$1747095220__65821278_dependencies(POM instance, List<Dependency> value) /*-{
    instance.@org.guvnor.common.services.project.model.POM::dependencies = value;
  }-*/;

  public String marshall(POM a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.POM\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"parent\":").append(java_lang_Object.marshall(a0.getParent(), a1)).append(",").append("\"gav\":").append(java_lang_Object.marshall(a0.getGav(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"packaging\":").append(java_lang_String.marshall(a0.getPackaging(), a1)).append(",").append("\"build\":").append(org_guvnor_common_services_project_model_Build.marshall(a0.getBuild(), a1)).append(",").append("\"dependencies\":").append(java_util_List.marshall(_$1747095220__65821278_dependencies(a0), a1)).append(",").append("\"repositories\":").append(java_util_List.marshall(a0.getRepositories(), a1)).append(",").append("\"modules\":").append(java_util_List.marshall(a0.getModules(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_Build == null) {
      org_guvnor_common_services_project_model_Build = Marshalling.getMarshaller(Build.class);
    }
  }
}