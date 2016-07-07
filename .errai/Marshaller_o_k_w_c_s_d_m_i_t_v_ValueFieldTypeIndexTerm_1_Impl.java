package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldTypeIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueFieldTypeIndexTerm_1_Impl implements GeneratedMarshaller<ValueFieldTypeIndexTerm> {
  private ValueFieldTypeIndexTerm[] EMPTY_ARRAY = new ValueFieldTypeIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueFieldTypeIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1012858155__1195259493_fieldType(ValueFieldTypeIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldTypeIndexTerm::fieldType;
  }-*/;

  private native static void _$1012858155__1195259493_fieldType(ValueFieldTypeIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldTypeIndexTerm::fieldType = value;
  }-*/;

  public ValueFieldTypeIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueFieldTypeIndexTerm.class, objId);
    }
    ValueFieldTypeIndexTerm entity = new ValueFieldTypeIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldType")) && (!obj.get("fieldType").isNull())) {
      _$1012858155__1195259493_fieldType(entity, java_lang_String.demarshall(obj.get("fieldType"), a1));
    }
    return entity;
  }

  public String marshall(ValueFieldTypeIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldTypeIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldType\":").append(java_lang_String.marshall(_$1012858155__1195259493_fieldType(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}