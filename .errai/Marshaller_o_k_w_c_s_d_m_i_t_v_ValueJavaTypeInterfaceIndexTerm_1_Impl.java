package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeInterfaceIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueJavaTypeInterfaceIndexTerm_1_Impl implements GeneratedMarshaller<ValueJavaTypeInterfaceIndexTerm> {
  private ValueJavaTypeInterfaceIndexTerm[] EMPTY_ARRAY = new ValueJavaTypeInterfaceIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueJavaTypeInterfaceIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$794671828__1195259493_javaTypeInterface(ValueJavaTypeInterfaceIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeInterfaceIndexTerm::javaTypeInterface;
  }-*/;

  private native static void _$794671828__1195259493_javaTypeInterface(ValueJavaTypeInterfaceIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeInterfaceIndexTerm::javaTypeInterface = value;
  }-*/;

  public ValueJavaTypeInterfaceIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueJavaTypeInterfaceIndexTerm.class, objId);
    }
    ValueJavaTypeInterfaceIndexTerm entity = new ValueJavaTypeInterfaceIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("javaTypeInterface")) && (!obj.get("javaTypeInterface").isNull())) {
      _$794671828__1195259493_javaTypeInterface(entity, java_lang_String.demarshall(obj.get("javaTypeInterface"), a1));
    }
    return entity;
  }

  public String marshall(ValueJavaTypeInterfaceIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeInterfaceIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"javaTypeInterface\":").append(java_lang_String.marshall(_$794671828__1195259493_javaTypeInterface(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}