package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeParentIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueJavaTypeParentIndexTerm_1_Impl implements GeneratedMarshaller<ValueJavaTypeParentIndexTerm> {
  private ValueJavaTypeParentIndexTerm[] EMPTY_ARRAY = new ValueJavaTypeParentIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueJavaTypeParentIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1662212653__1195259493_javaTypeParent(ValueJavaTypeParentIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeParentIndexTerm::javaTypeParent;
  }-*/;

  private native static void _1662212653__1195259493_javaTypeParent(ValueJavaTypeParentIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeParentIndexTerm::javaTypeParent = value;
  }-*/;

  public ValueJavaTypeParentIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueJavaTypeParentIndexTerm.class, objId);
    }
    ValueJavaTypeParentIndexTerm entity = new ValueJavaTypeParentIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("javaTypeParent")) && (!obj.get("javaTypeParent").isNull())) {
      _1662212653__1195259493_javaTypeParent(entity, java_lang_String.demarshall(obj.get("javaTypeParent"), a1));
    }
    return entity;
  }

  public String marshall(ValueJavaTypeParentIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeParentIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"javaTypeParent\":").append(java_lang_String.marshall(_1662212653__1195259493_javaTypeParent(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}