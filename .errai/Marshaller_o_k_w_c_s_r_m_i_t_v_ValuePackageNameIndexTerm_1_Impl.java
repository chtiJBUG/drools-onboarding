package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValuePackageNameIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValuePackageNameIndexTerm_1_Impl implements GeneratedMarshaller<ValuePackageNameIndexTerm> {
  private ValuePackageNameIndexTerm[] EMPTY_ARRAY = new ValuePackageNameIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValuePackageNameIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _625201769__1195259493_packageName(ValuePackageNameIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValuePackageNameIndexTerm::packageName;
  }-*/;

  private native static void _625201769__1195259493_packageName(ValuePackageNameIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValuePackageNameIndexTerm::packageName = value;
  }-*/;

  public ValuePackageNameIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValuePackageNameIndexTerm.class, objId);
    }
    ValuePackageNameIndexTerm entity = new ValuePackageNameIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      _625201769__1195259493_packageName(entity, java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    return entity;
  }

  public String marshall(ValuePackageNameIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValuePackageNameIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"packageName\":").append(java_lang_String.marshall(_625201769__1195259493_packageName(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}