package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueTypeIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValueTypeIndexTerm_1_Impl implements GeneratedMarshaller<ValueTypeIndexTerm> {
  private ValueTypeIndexTerm[] EMPTY_ARRAY = new ValueTypeIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueTypeIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _972726984__1195259493_fullyQualifiedClassName(ValueTypeIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueTypeIndexTerm::fullyQualifiedClassName;
  }-*/;

  private native static void _972726984__1195259493_fullyQualifiedClassName(ValueTypeIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueTypeIndexTerm::fullyQualifiedClassName = value;
  }-*/;

  public ValueTypeIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueTypeIndexTerm.class, objId);
    }
    ValueTypeIndexTerm entity = new ValueTypeIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fullyQualifiedClassName")) && (!obj.get("fullyQualifiedClassName").isNull())) {
      _972726984__1195259493_fullyQualifiedClassName(entity, java_lang_String.demarshall(obj.get("fullyQualifiedClassName"), a1));
    }
    return entity;
  }

  public String marshall(ValueTypeIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueTypeIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fullyQualifiedClassName\":").append(java_lang_String.marshall(_972726984__1195259493_fullyQualifiedClassName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}