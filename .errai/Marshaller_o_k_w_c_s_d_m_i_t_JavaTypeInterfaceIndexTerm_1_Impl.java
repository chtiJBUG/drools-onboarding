package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeInterfaceIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_JavaTypeInterfaceIndexTerm_1_Impl implements GeneratedMarshaller<JavaTypeInterfaceIndexTerm> {
  private JavaTypeInterfaceIndexTerm[] EMPTY_ARRAY = new JavaTypeInterfaceIndexTerm[0];
  public JavaTypeInterfaceIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public JavaTypeInterfaceIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JavaTypeInterfaceIndexTerm.class, objId);
    }
    JavaTypeInterfaceIndexTerm entity = new JavaTypeInterfaceIndexTerm();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(JavaTypeInterfaceIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeInterfaceIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}