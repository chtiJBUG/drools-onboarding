package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.screens.workitems.model.WorkItemDefinitionElements;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_w_m_WorkItemDefinitionElements_1_Impl implements GeneratedMarshaller<WorkItemDefinitionElements> {
  private WorkItemDefinitionElements[] EMPTY_ARRAY = new WorkItemDefinitionElements[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public WorkItemDefinitionElements[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$1959896905__$1383349348_workItemDefinitionElements(WorkItemDefinitionElements instance) /*-{
    return instance.@org.drools.workbench.screens.workitems.model.WorkItemDefinitionElements::workItemDefinitionElements;
  }-*/;

  private native static void _$1959896905__$1383349348_workItemDefinitionElements(WorkItemDefinitionElements instance, Map<String, String> value) /*-{
    instance.@org.drools.workbench.screens.workitems.model.WorkItemDefinitionElements::workItemDefinitionElements = value;
  }-*/;

  public WorkItemDefinitionElements demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WorkItemDefinitionElements.class, objId);
    }
    WorkItemDefinitionElements entity = new WorkItemDefinitionElements();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("workItemDefinitionElements")) && (!obj.get("workItemDefinitionElements").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$1959896905__$1383349348_workItemDefinitionElements(entity, java_util_Map.demarshall(obj.get("workItemDefinitionElements"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(WorkItemDefinitionElements a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.workitems.model.WorkItemDefinitionElements\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"workItemDefinitionElements\":").append(java_util_Map.marshall(_$1959896905__$1383349348_workItemDefinitionElements(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}