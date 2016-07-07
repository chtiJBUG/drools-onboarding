package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.query.RefactoringStringPageRow;

public class Marshaller_o_k_w_c_s_r_m_q_RefactoringStringPageRow_1_Impl implements GeneratedMarshaller<RefactoringStringPageRow> {
  private RefactoringStringPageRow[] EMPTY_ARRAY = new RefactoringStringPageRow[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public RefactoringStringPageRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RefactoringStringPageRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RefactoringStringPageRow.class, objId);
    }
    RefactoringStringPageRow entity = new RefactoringStringPageRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(RefactoringStringPageRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.query.RefactoringStringPageRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}