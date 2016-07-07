package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.guvnor.common.services.project.model.ProjectRepositories;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_ProjectRepositories_1_Impl implements GeneratedMarshaller<ProjectRepositories> {
  private ProjectRepositories[] EMPTY_ARRAY = new ProjectRepositories[0];
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public ProjectRepositories[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProjectRepositories demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectRepositories.class, objId);
    }
    a1.setAssumedElementType("org.guvnor.common.services.project.model.ProjectRepositories$ProjectRepository");
    final Set c0 = java_util_Set.demarshall(obj.get("repositories"), a1);
    ProjectRepositories entity = new ProjectRepositories(c0);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ProjectRepositories a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.ProjectRepositories\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"repositories\":").append(java_util_Set.marshall(a0.getRepositories(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}