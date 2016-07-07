package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.model.TypeInfoResult;
import org.kie.workbench.common.services.datamodeller.core.JavaTypeInfo;

public class Marshaller_o_k_w_c_s_d_m_TypeInfoResult_1_Impl implements GeneratedMarshaller<TypeInfoResult> {
  private TypeInfoResult[] EMPTY_ARRAY = new TypeInfoResult[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public TypeInfoResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public TypeInfoResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TypeInfoResult.class, objId);
    }
    TypeInfoResult entity = new TypeInfoResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("javaTypeInfo")) && (!obj.get("javaTypeInfo").isNull())) {
      entity.setJavaTypeInfo((JavaTypeInfo) ((ObjectMarshaller) java_lang_Object).demarshall(JavaTypeInfo.class, obj.get("javaTypeInfo"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.datamodeller.model.DataModelerError");
      entity.setErrors(java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(TypeInfoResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.TypeInfoResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"javaTypeInfo\":").append(java_lang_Object.marshall(a0.getJavaTypeInfo(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}