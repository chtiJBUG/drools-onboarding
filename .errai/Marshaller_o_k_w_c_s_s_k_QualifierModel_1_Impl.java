package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.QualifierModel;

public class Marshaller_o_k_w_c_s_s_k_QualifierModel_1_Impl implements GeneratedMarshaller<QualifierModel> {
  private QualifierModel[] EMPTY_ARRAY = new QualifierModel[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public QualifierModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1192169390__64711720_simple(QualifierModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.QualifierModel::simple;
  }-*/;

  private native static void _$1192169390__64711720_simple(QualifierModel instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.QualifierModel::simple = value;
  }-*/;

  private native static Map _$1192169390__$1383349348_arguments(QualifierModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.QualifierModel::arguments;
  }-*/;

  private native static void _$1192169390__$1383349348_arguments(QualifierModel instance, Map<String, String> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.QualifierModel::arguments = value;
  }-*/;

  public QualifierModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(QualifierModel.class, objId);
    }
    QualifierModel entity = new QualifierModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("simple")) && (!obj.get("simple").isNull())) {
      _$1192169390__64711720_simple(entity, java_lang_Boolean.demarshall(obj.get("simple"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("arguments")) && (!obj.get("arguments").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$1192169390__$1383349348_arguments(entity, java_util_Map.demarshall(obj.get("arguments"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(QualifierModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.QualifierModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"simple\":").append(java_lang_Boolean.marshall(_$1192169390__64711720_simple(a0), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"arguments\":").append(java_util_Map.marshall(a0.getArguments(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}