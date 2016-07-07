package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.refactoring.model.query.RefactoringPathPageRow;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_r_m_q_RefactoringPathPageRow_1_Impl implements GeneratedMarshaller<RefactoringPathPageRow> {
  private RefactoringPathPageRow[] EMPTY_ARRAY = new RefactoringPathPageRow[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public RefactoringPathPageRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RefactoringPathPageRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RefactoringPathPageRow.class, objId);
    }
    RefactoringPathPageRow entity = new RefactoringPathPageRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(RefactoringPathPageRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.query.RefactoringPathPageRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_Object.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}