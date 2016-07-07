package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.ProjectRootPathIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_ProjectRootPathIndexTerm_1_Impl implements GeneratedMarshaller<ProjectRootPathIndexTerm> {
  private ProjectRootPathIndexTerm[] EMPTY_ARRAY = new ProjectRootPathIndexTerm[0];
  public ProjectRootPathIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ProjectRootPathIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProjectRootPathIndexTerm.class, objId);
    }
    ProjectRootPathIndexTerm entity = new ProjectRootPathIndexTerm();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ProjectRootPathIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.ProjectRootPathIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}