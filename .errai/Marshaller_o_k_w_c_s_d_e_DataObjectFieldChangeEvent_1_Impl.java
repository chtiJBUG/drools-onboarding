package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.events.ChangeType;
import org.kie.workbench.common.screens.datamodeller.events.DataModelerValueChangeEvent;
import org.kie.workbench.common.screens.datamodeller.events.DataObjectFieldChangeEvent;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.kie.workbench.common.services.datamodeller.core.ObjectProperty;

public class Marshaller_o_k_w_c_s_d_e_DataObjectFieldChangeEvent_1_Impl implements GeneratedMarshaller<DataObjectFieldChangeEvent> {
  private DataObjectFieldChangeEvent[] EMPTY_ARRAY = new DataObjectFieldChangeEvent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ChangeType> org_kie_workbench_common_screens_datamodeller_events_ChangeType = null;
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public DataObjectFieldChangeEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ChangeType _$1689582854__1767652533_changeType(DataModelerValueChangeEvent instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.events.DataModelerValueChangeEvent::changeType;
  }-*/;

  private native static void _$1689582854__1767652533_changeType(DataModelerValueChangeEvent instance, ChangeType value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.events.DataModelerValueChangeEvent::changeType = value;
  }-*/;

  private native static Map _$1689582854__$1383349348_changeParams(DataModelerValueChangeEvent instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.events.DataModelerValueChangeEvent::changeParams;
  }-*/;

  private native static void _$1689582854__$1383349348_changeParams(DataModelerValueChangeEvent instance, Map value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.events.DataModelerValueChangeEvent::changeParams = value;
  }-*/;

  public DataObjectFieldChangeEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataObjectFieldChangeEvent.class, objId);
    }
    DataObjectFieldChangeEvent entity = new DataObjectFieldChangeEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("valueName")) && (!obj.get("valueName").isNull())) {
      entity.setValueName(java_lang_String.demarshall(obj.get("valueName"), a1));
    }
    if ((obj.containsKey("oldValue")) && (!obj.get("oldValue").isNull())) {
      entity.setOldValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("oldValue"), a1));
    }
    if ((obj.containsKey("newValue")) && (!obj.get("newValue").isNull())) {
      entity.setNewValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("newValue"), a1));
    }
    if ((obj.containsKey("changeType")) && (!obj.get("changeType").isNull())) {
      _$1689582854__1767652533_changeType(entity, obj.get("changeType").isObject() != null ? Enum.valueOf(ChangeType.class, obj.get("changeType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("changeType").isString() != null ? Enum.valueOf(ChangeType.class, obj.get("changeType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("changeParams")) && (!obj.get("changeParams").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$1689582854__$1383349348_changeParams(entity, java_util_Map.demarshall(obj.get("changeParams"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("currentDataObject")) && (!obj.get("currentDataObject").isNull())) {
      entity.setCurrentDataObject((DataObject) ((ObjectMarshaller) java_lang_Object).demarshall(DataObject.class, obj.get("currentDataObject"), a1));
    }
    if ((obj.containsKey("currentField")) && (!obj.get("currentField").isNull())) {
      entity.setCurrentField((ObjectProperty) ((ObjectMarshaller) java_lang_Object).demarshall(ObjectProperty.class, obj.get("currentField"), a1));
    }
    if ((obj.containsKey("currentProject")) && (!obj.get("currentProject").isNull())) {
      entity.setCurrentProject((Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("currentProject"), a1));
    }
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      entity.setSource(java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("contextId")) && (!obj.get("contextId").isNull())) {
      entity.setContextId(java_lang_String.demarshall(obj.get("contextId"), a1));
    }
    return entity;
  }

  public String marshall(DataObjectFieldChangeEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.events.DataObjectFieldChangeEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"valueName\":").append(java_lang_String.marshall(a0.getValueName(), a1)).append(",").append("\"oldValue\":").append(java_lang_Object.marshall(a0.getOldValue(), a1)).append(",").append("\"newValue\":").append(java_lang_Object.marshall(a0.getNewValue(), a1)).append(",").append("\"changeType\":").append(a0.getChangeType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.events.ChangeType\",\"^EnumStringValue\":\"").append(a0.getChangeType().name()).append("\"}") : "null").append(",").append("\"changeParams\":").append(java_util_Map.marshall(_$1689582854__$1383349348_changeParams(a0), a1)).append(",").append("\"currentDataObject\":").append(java_lang_Object.marshall(a0.getCurrentDataObject(), a1)).append(",").append("\"currentField\":").append(java_lang_Object.marshall(a0.getCurrentField(), a1)).append(",").append("\"currentProject\":").append(java_lang_Object.marshall(a0.getCurrentProject(), a1)).append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"contextId\":").append(java_lang_String.marshall(a0.getContextId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_datamodeller_events_ChangeType == null) {
      org_kie_workbench_common_screens_datamodeller_events_ChangeType = Marshalling.getMarshaller(ChangeType.class);
    }
  }
}