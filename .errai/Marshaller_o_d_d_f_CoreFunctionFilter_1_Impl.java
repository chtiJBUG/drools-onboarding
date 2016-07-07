package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.filter.CoreFunctionFilter;
import org.dashbuilder.dataset.filter.CoreFunctionType;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_f_CoreFunctionFilter_1_Impl implements GeneratedMarshaller<CoreFunctionFilter> {
  private CoreFunctionFilter[] EMPTY_ARRAY = new CoreFunctionFilter[0];
  private Marshaller<CoreFunctionType> org_dashbuilder_dataset_filter_CoreFunctionType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public CoreFunctionFilter[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CoreFunctionFilter demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CoreFunctionFilter.class, objId);
    }
    CoreFunctionFilter entity = new CoreFunctionFilter();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(obj.get("type").isObject() != null ? Enum.valueOf(CoreFunctionType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(CoreFunctionType.class, obj.get("type").isString().stringValue()) : null);
    }
    if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
      entity.setParameters(java_util_List.demarshall(obj.get("parameters"), a1));
    }
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    return entity;
  }

  public String marshall(CoreFunctionFilter a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.CoreFunctionFilter\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.CoreFunctionType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"parameters\":").append(java_util_List.marshall(a0.getParameters(), a1)).append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_filter_CoreFunctionType == null) {
      org_dashbuilder_dataset_filter_CoreFunctionType = Marshalling.getMarshaller(CoreFunctionType.class);
    }
  }
}