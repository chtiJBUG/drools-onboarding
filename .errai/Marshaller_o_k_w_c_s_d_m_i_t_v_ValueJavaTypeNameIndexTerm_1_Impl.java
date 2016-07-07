package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeNameIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueJavaTypeNameIndexTerm_1_Impl implements GeneratedMarshaller<ValueJavaTypeNameIndexTerm> {
  private ValueJavaTypeNameIndexTerm[] EMPTY_ARRAY = new ValueJavaTypeNameIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueJavaTypeNameIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _508524460__1195259493_javaTypeName(ValueJavaTypeNameIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeNameIndexTerm::javaTypeName;
  }-*/;

  private native static void _508524460__1195259493_javaTypeName(ValueJavaTypeNameIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeNameIndexTerm::javaTypeName = value;
  }-*/;

  public ValueJavaTypeNameIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueJavaTypeNameIndexTerm.class, objId);
    }
    ValueJavaTypeNameIndexTerm entity = new ValueJavaTypeNameIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("javaTypeName")) && (!obj.get("javaTypeName").isNull())) {
      _508524460__1195259493_javaTypeName(entity, java_lang_String.demarshall(obj.get("javaTypeName"), a1));
    }
    return entity;
  }

  public String marshall(ValueJavaTypeNameIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeNameIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"javaTypeName\":").append(java_lang_String.marshall(_508524460__1195259493_javaTypeName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}