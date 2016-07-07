package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionFieldValueImpl;
import org.drools.workbench.models.guided.dtree.shared.model.values.Value;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_n_i_ActionFieldValueImpl_1_Impl implements GeneratedMarshaller<ActionFieldValueImpl> {
  private ActionFieldValueImpl[] EMPTY_ARRAY = new ActionFieldValueImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ActionFieldValueImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionFieldValueImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionFieldValueImpl.class, objId);
    }
    ActionFieldValueImpl entity = new ActionFieldValueImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue((Value) ((ObjectMarshaller) java_lang_Object).demarshall(Value.class, obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(ActionFieldValueImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionFieldValueImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"value\":").append(java_lang_Object.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}