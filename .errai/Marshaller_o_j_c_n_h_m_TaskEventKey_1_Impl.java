package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.TaskEventKey;

public class Marshaller_o_j_c_n_h_m_TaskEventKey_1_Impl implements GeneratedMarshaller<TaskEventKey> {
  private TaskEventKey[] EMPTY_ARRAY = new TaskEventKey[0];
  public TaskEventKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TaskEventKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskEventKey.class, objId);
    }
    TaskEventKey entity = new TaskEventKey();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(TaskEventKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TaskEventKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}