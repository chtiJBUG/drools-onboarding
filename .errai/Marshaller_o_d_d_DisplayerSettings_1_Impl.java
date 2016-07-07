package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.DataSetLookup;
import org.dashbuilder.displayer.DisplayerSettings;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_DisplayerSettings_1_Impl implements GeneratedMarshaller<DisplayerSettings> {
  private DisplayerSettings[] EMPTY_ARRAY = new DisplayerSettings[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<DataSetLookup> org_dashbuilder_dataset_DataSetLookup = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public DisplayerSettings[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$208136924__$1383349348_settings(DisplayerSettings instance) /*-{
    return instance.@org.dashbuilder.displayer.DisplayerSettings::settings;
  }-*/;

  private native static void _$208136924__$1383349348_settings(DisplayerSettings instance, Map<String, String> value) /*-{
    instance.@org.dashbuilder.displayer.DisplayerSettings::settings = value;
  }-*/;

  public DisplayerSettings demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DisplayerSettings.class, objId);
    }
    DisplayerSettings entity = new DisplayerSettings();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("UUID")) && (!obj.get("UUID").isNull())) {
      entity.setUUID(java_lang_String.demarshall(obj.get("UUID"), a1));
    }
    if ((obj.containsKey("dataSet")) && (!obj.get("dataSet").isNull())) {
      entity.setDataSet((DataSet) ((ObjectMarshaller) java_lang_Object).demarshall(DataSet.class, obj.get("dataSet"), a1));
    }
    if ((obj.containsKey("dataSetLookup")) && (!obj.get("dataSetLookup").isNull())) {
      entity.setDataSetLookup(org_dashbuilder_dataset_DataSetLookup.demarshall(obj.get("dataSetLookup"), a1));
    }
    if ((obj.containsKey("columnSettingsList")) && (!obj.get("columnSettingsList").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.displayer.ColumnSettings");
      entity.setColumnSettingsList(java_util_List.demarshall(obj.get("columnSettingsList"), a1));
    }
    if ((obj.containsKey("settings")) && (!obj.get("settings").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$208136924__$1383349348_settings(entity, java_util_Map.demarshall(obj.get("settings"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(DisplayerSettings a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.displayer.DisplayerSettings\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"UUID\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"dataSet\":").append(java_lang_Object.marshall(a0.getDataSet(), a1)).append(",").append("\"dataSetLookup\":").append(org_dashbuilder_dataset_DataSetLookup.marshall(a0.getDataSetLookup(), a1)).append(",").append("\"columnSettingsList\":").append(java_util_List.marshall(a0.getColumnSettingsList(), a1)).append(",").append("\"settings\":").append(java_util_Map.marshall(_$208136924__$1383349348_settings(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_DataSetLookup == null) {
      org_dashbuilder_dataset_DataSetLookup = Marshalling.getMarshaller(DataSetLookup.class);
    }
  }
}