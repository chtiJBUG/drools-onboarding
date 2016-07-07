package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldNameIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueFieldNameIndexTerm_1_Impl implements GeneratedMarshaller<ValueFieldNameIndexTerm> {
  private ValueFieldNameIndexTerm[] EMPTY_ARRAY = new ValueFieldNameIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueFieldNameIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1254538588__1195259493_fieldName(ValueFieldNameIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldNameIndexTerm::fieldName;
  }-*/;

  private native static void _$1254538588__1195259493_fieldName(ValueFieldNameIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldNameIndexTerm::fieldName = value;
  }-*/;

  public ValueFieldNameIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueFieldNameIndexTerm.class, objId);
    }
    ValueFieldNameIndexTerm entity = new ValueFieldNameIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      _$1254538588__1195259493_fieldName(entity, java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    return entity;
  }

  public String marshall(ValueFieldNameIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueFieldNameIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(_$1254538588__1195259493_fieldName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}