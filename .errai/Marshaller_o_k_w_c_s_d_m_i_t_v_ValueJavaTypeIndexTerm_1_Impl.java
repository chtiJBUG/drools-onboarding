package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm.JAVA_TYPE;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeIndexTerm;

public class Marshaller_o_k_w_c_s_d_m_i_t_v_ValueJavaTypeIndexTerm_1_Impl implements GeneratedMarshaller<ValueJavaTypeIndexTerm> {
  private ValueJavaTypeIndexTerm[] EMPTY_ARRAY = new ValueJavaTypeIndexTerm[0];
  private Marshaller<JAVA_TYPE> org_kie_workbench_common_screens_datamodeller_model_index_terms_JavaTypeIndexTerm_erraiD_JAVA_erraiU_TYPE = null;
  public ValueJavaTypeIndexTerm[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static JAVA_TYPE _2091899511__2082096387_javaType(ValueJavaTypeIndexTerm instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeIndexTerm::javaType;
  }-*/;

  private native static void _2091899511__2082096387_javaType(ValueJavaTypeIndexTerm instance, JAVA_TYPE value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeIndexTerm::javaType = value;
  }-*/;

  public ValueJavaTypeIndexTerm demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ValueJavaTypeIndexTerm.class, objId);
    }
    ValueJavaTypeIndexTerm entity = new ValueJavaTypeIndexTerm();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("javaType")) && (!obj.get("javaType").isNull())) {
      _2091899511__2082096387_javaType(entity, obj.get("javaType").isObject() != null ? Enum.valueOf(JAVA_TYPE.class, obj.get("javaType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("javaType").isString() != null ? Enum.valueOf(JAVA_TYPE.class, obj.get("javaType").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(ValueJavaTypeIndexTerm a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.valueterms.ValueJavaTypeIndexTerm\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"javaType\":").append(_2091899511__2082096387_javaType(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.index.terms.JavaTypeIndexTerm$JAVA_TYPE\",\"^EnumStringValue\":\"").append(_2091899511__2082096387_javaType(a0).name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_datamodeller_model_index_terms_JavaTypeIndexTerm_erraiD_JAVA_erraiU_TYPE == null) {
      org_kie_workbench_common_screens_datamodeller_model_index_terms_JavaTypeIndexTerm_erraiD_JAVA_erraiU_TYPE = Marshalling.getMarshaller(JAVA_TYPE.class);
    }
  }
}