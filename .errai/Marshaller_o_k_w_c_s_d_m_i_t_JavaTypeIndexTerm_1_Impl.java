package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_JavaTypeIndexTerm_1_Impl implements GeneratedMarshaller<JavaTypeIndexTerm> {
  private JavaTypeIndexTerm[] EMPTY_ARRAY = new JavaTypeIndexTerm[0];
  public JavaTypeIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public JavaTypeIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JavaTypeIndexTerm.class, objId);
    }
    JavaTypeIndexTerm entity = new JavaTypeIndexTerm();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(JavaTypeIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}