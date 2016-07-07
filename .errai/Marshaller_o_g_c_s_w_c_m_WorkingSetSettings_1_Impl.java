package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.common.services.workingset.client.model.WorkingSetConfigData;
import org.guvnor.common.services.workingset.client.model.WorkingSetSettings;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_c_s_w_c_m_WorkingSetSettings_1_Impl implements GeneratedMarshaller<WorkingSetSettings> {
  private WorkingSetSettings[] EMPTY_ARRAY = new WorkingSetSettings[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public WorkingSetSettings[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$753391833__$1383349348_configData(WorkingSetSettings instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetSettings::configData;
  }-*/;

  private native static void _$753391833__$1383349348_configData(WorkingSetSettings instance, Map<Path, WorkingSetConfigData> value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetSettings::configData = value;
  }-*/;

  public WorkingSetSettings demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WorkingSetSettings.class, objId);
    }
    WorkingSetSettings entity = new WorkingSetSettings();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("configData")) && (!obj.get("configData").isNull())) {
      a1.setAssumedMapKeyType("org.uberfire.backend.vfs.Path");
      a1.setAssumedMapValueType("org.guvnor.common.services.workingset.client.model.WorkingSetConfigData");
      _$753391833__$1383349348_configData(entity, java_util_Map.demarshall(obj.get("configData"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(WorkingSetSettings a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.workingset.client.model.WorkingSetSettings\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"configData\":").append(java_util_Map.marshall(_$753391833__$1383349348_configData(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}