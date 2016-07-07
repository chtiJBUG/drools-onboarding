package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.DataSetLookup;
import org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder;
import org.dashbuilder.displayer.DisplayerSettings;
import org.dashbuilder.displayer.impl.AbstractDisplayerSettingsBuilder;
import org.dashbuilder.displayer.impl.TableDisplayerSettingsBuilderImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_i_TableDisplayerSettingsBuilderImpl_1_Impl implements GeneratedMarshaller<TableDisplayerSettingsBuilderImpl> {
  private TableDisplayerSettingsBuilderImpl[] EMPTY_ARRAY = new TableDisplayerSettingsBuilderImpl[0];
  private Marshaller<DisplayerSettings> org_dashbuilder_displayer_DisplayerSettings = null;
  private Marshaller<DataSetLookup> org_dashbuilder_dataset_DataSetLookup = null;
  public TableDisplayerSettingsBuilderImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static DisplayerSettings _$528145525__$208136924_displayerSettings(AbstractDisplayerSettingsBuilder instance) /*-{
    return instance.@org.dashbuilder.displayer.impl.AbstractDisplayerSettingsBuilder::displayerSettings;
  }-*/;

  private native static void _$528145525__$208136924_displayerSettings(AbstractDisplayerSettingsBuilder instance, DisplayerSettings value) /*-{
    instance.@org.dashbuilder.displayer.impl.AbstractDisplayerSettingsBuilder::displayerSettings = value;
  }-*/;

  private native static DataSetLookup _$1763033004__1130144749_dataSetLookup(AbstractDataSetLookupBuilder instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder::dataSetLookup;
  }-*/;

  private native static void _$1763033004__1130144749_dataSetLookup(AbstractDataSetLookupBuilder instance, DataSetLookup value) /*-{
    instance.@org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder::dataSetLookup = value;
  }-*/;

  public TableDisplayerSettingsBuilderImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TableDisplayerSettingsBuilderImpl.class, objId);
    }
    TableDisplayerSettingsBuilderImpl entity = new TableDisplayerSettingsBuilderImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("displayerSettings")) && (!obj.get("displayerSettings").isNull())) {
      _$528145525__$208136924_displayerSettings(entity, org_dashbuilder_displayer_DisplayerSettings.demarshall(obj.get("displayerSettings"), a1));
    }
    if ((obj.containsKey("dataSetLookup")) && (!obj.get("dataSetLookup").isNull())) {
      _$1763033004__1130144749_dataSetLookup(entity, org_dashbuilder_dataset_DataSetLookup.demarshall(obj.get("dataSetLookup"), a1));
    }
    return entity;
  }

  public String marshall(TableDisplayerSettingsBuilderImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.displayer.impl.TableDisplayerSettingsBuilderImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"displayerSettings\":").append(org_dashbuilder_displayer_DisplayerSettings.marshall(_$528145525__$208136924_displayerSettings(a0), a1)).append(",").append("\"dataSetLookup\":").append(org_dashbuilder_dataset_DataSetLookup.marshall(_$1763033004__1130144749_dataSetLookup(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_displayer_DisplayerSettings == null) {
      org_dashbuilder_displayer_DisplayerSettings = Marshalling.getMarshaller(DisplayerSettings.class);
    }
    if (org_dashbuilder_dataset_DataSetLookup == null) {
      org_dashbuilder_dataset_DataSetLookup = Marshalling.getMarshaller(DataSetLookup.class);
    }
  }
}