package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.pr.model.ProcessVariableKey;

public class Marshaller_o_j_c_n_p_m_ProcessVariableKey_1_Impl implements GeneratedMarshaller<ProcessVariableKey> {
  private ProcessVariableKey[] EMPTY_ARRAY = new ProcessVariableKey[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ProcessVariableKey[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1306334890__1195259493_processVariableId(ProcessVariableKey instance) /*-{
    return instance.@org.jbpm.console.ng.pr.model.ProcessVariableKey::processVariableId;
  }-*/;

  private native static void _$1306334890__1195259493_processVariableId(ProcessVariableKey instance, String value) /*-{
    instance.@org.jbpm.console.ng.pr.model.ProcessVariableKey::processVariableId = value;
  }-*/;

  public ProcessVariableKey demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ProcessVariableKey.class, objId);
    }
    ProcessVariableKey entity = new ProcessVariableKey();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("processVariableId")) && (!obj.get("processVariableId").isNull())) {
      _$1306334890__1195259493_processVariableId(entity, java_lang_String.demarshall(obj.get("processVariableId"), a1));
    }
    return entity;
  }

  public String marshall(ProcessVariableKey a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.pr.model.ProcessVariableKey\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"processVariableId\":").append(java_lang_String.marshall(a0.getProcessVariableId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}