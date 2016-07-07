package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.group.AggregateFunctionType;
import org.dashbuilder.dataset.group.GroupFunction;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_g_GroupFunction_1_Impl implements GeneratedMarshaller<GroupFunction> {
  private GroupFunction[] EMPTY_ARRAY = new GroupFunction[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<AggregateFunctionType> org_dashbuilder_dataset_group_AggregateFunctionType = null;
  public GroupFunction[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GroupFunction demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GroupFunction.class, objId);
    }
    GroupFunction entity = new GroupFunction();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("sourceId")) && (!obj.get("sourceId").isNull())) {
      entity.setSourceId(java_lang_String.demarshall(obj.get("sourceId"), a1));
    }
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    if ((obj.containsKey("function")) && (!obj.get("function").isNull())) {
      entity.setFunction(obj.get("function").isObject() != null ? Enum.valueOf(AggregateFunctionType.class, obj.get("function").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("function").isString() != null ? Enum.valueOf(AggregateFunctionType.class, obj.get("function").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(GroupFunction a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.group.GroupFunction\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"sourceId\":").append(java_lang_String.marshall(a0.getSourceId(), a1)).append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append(",").append("\"function\":").append(a0.getFunction() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.AggregateFunctionType\",\"^EnumStringValue\":\"").append(a0.getFunction().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_group_AggregateFunctionType == null) {
      org_dashbuilder_dataset_group_AggregateFunctionType = Marshalling.getMarshaller(AggregateFunctionType.class);
    }
  }
}