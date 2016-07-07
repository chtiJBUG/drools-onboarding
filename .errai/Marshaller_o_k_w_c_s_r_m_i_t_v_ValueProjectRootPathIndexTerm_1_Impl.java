package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueProjectRootPathIndexTerm;

public class Marshaller_o_k_w_c_s_r_m_i_t_v_ValueProjectRootPathIndexTerm_1_Impl implements GeneratedMarshaller<ValueProjectRootPathIndexTerm> {
  private ValueProjectRootPathIndexTerm[] EMPTY_ARRAY = new ValueProjectRootPathIndexTerm[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ValueProjectRootPathIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1530770138__1195259493_projectPath(ValueProjectRootPathIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueProjectRootPathIndexTerm::projectPath;
  }-*/;

  private native static void _1530770138__1195259493_projectPath(ValueProjectRootPathIndexTerm instance, String value) /*-{
    instance.@org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueProjectRootPathIndexTerm::projectPath = value;
  }-*/;

  public ValueProjectRootPathIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueProjectRootPathIndexTerm.class, objId);
    }
    ValueProjectRootPathIndexTerm entity = new ValueProjectRootPathIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("projectPath")) && (!obj.get("projectPath").isNull())) {
      _1530770138__1195259493_projectPath(entity, java_lang_String.demarshall(obj.get("projectPath"), a1));
    }
    return entity;
  }

  public String marshall(ValueProjectRootPathIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.refactoring.model.index.terms.valueterms.ValueProjectRootPathIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"projectPath\":").append(java_lang_String.marshall(_1530770138__1195259493_projectPath(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}