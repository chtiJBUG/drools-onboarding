package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.filter.LogicalExprFilter;
import org.dashbuilder.dataset.filter.LogicalExprType;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_f_LogicalExprFilter_1_Impl implements GeneratedMarshaller<LogicalExprFilter> {
  private LogicalExprFilter[] EMPTY_ARRAY = new LogicalExprFilter[0];
  private Marshaller<LogicalExprType> org_dashbuilder_dataset_filter_LogicalExprType = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public LogicalExprFilter[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public LogicalExprFilter demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LogicalExprFilter.class, objId);
    }
    LogicalExprFilter entity = new LogicalExprFilter();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("logicalOperator")) && (!obj.get("logicalOperator").isNull())) {
      entity.setLogicalOperator(obj.get("logicalOperator").isObject() != null ? Enum.valueOf(LogicalExprType.class, obj.get("logicalOperator").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("logicalOperator").isString() != null ? Enum.valueOf(LogicalExprType.class, obj.get("logicalOperator").isString().stringValue()) : null);
    }
    if ((obj.containsKey("logicalTerms")) && (!obj.get("logicalTerms").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.filter.ColumnFilter");
      entity.setLogicalTerms(java_util_List.demarshall(obj.get("logicalTerms"), a1));
    }
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    return entity;
  }

  public String marshall(LogicalExprFilter a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.LogicalExprFilter\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"logicalOperator\":").append(a0.getLogicalOperator() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.filter.LogicalExprType\",\"^EnumStringValue\":\"").append(a0.getLogicalOperator().name()).append("\"}") : "null").append(",").append("\"logicalTerms\":").append(java_util_List.marshall(a0.getLogicalTerms(), a1)).append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_filter_LogicalExprType == null) {
      org_dashbuilder_dataset_filter_LogicalExprType = Marshalling.getMarshaller(LogicalExprType.class);
    }
  }
}