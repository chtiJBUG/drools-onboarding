package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ht.model.TaskKey;

public class Marshaller_o_j_c_n_h_m_TaskKey_1_Impl implements GeneratedMarshaller<TaskKey> {
  private TaskKey[] EMPTY_ARRAY = new TaskKey[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  public TaskKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Long _68534370__398795216_taskId(TaskKey instance) /*-{
    return instance.@org.jbpm.console.ng.ht.model.TaskKey::taskId;
  }-*/;

  private native static void _68534370__398795216_taskId(TaskKey instance, Long value) /*-{
    instance.@org.jbpm.console.ng.ht.model.TaskKey::taskId = value;
  }-*/;

  public TaskKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TaskKey.class, objId);
    }
    TaskKey entity = new TaskKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("taskId")) && (!obj.get("taskId").isNull())) {
      _68534370__398795216_taskId(entity, java_lang_Long.demarshall(obj.get("taskId"), a1));
    }
    return entity;
  }

  public String marshall(TaskKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ht.model.TaskKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"taskId\":").append(java_lang_Long.marshall(a0.getTaskId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}