package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.DataSetLookup;
import org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder;
import org.dashbuilder.dataset.impl.DataSetLookupBuilderImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_i_DataSetLookupBuilderImpl_1_Impl implements GeneratedMarshaller<DataSetLookupBuilderImpl> {
  private DataSetLookupBuilderImpl[] EMPTY_ARRAY = new DataSetLookupBuilderImpl[0];
  private Marshaller<DataSetLookup> org_dashbuilder_dataset_DataSetLookup = null;
  public DataSetLookupBuilderImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static DataSetLookup _$1763033004__1130144749_dataSetLookup(AbstractDataSetLookupBuilder instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder::dataSetLookup;
  }-*/;

  private native static void _$1763033004__1130144749_dataSetLookup(AbstractDataSetLookupBuilder instance, DataSetLookup value) /*-{
    instance.@org.dashbuilder.dataset.impl.AbstractDataSetLookupBuilder::dataSetLookup = value;
  }-*/;

  public DataSetLookupBuilderImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetLookupBuilderImpl.class, objId);
    }
    DataSetLookupBuilderImpl entity = new DataSetLookupBuilderImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSetLookup")) && (!obj.get("dataSetLookup").isNull())) {
      _$1763033004__1130144749_dataSetLookup(entity, org_dashbuilder_dataset_DataSetLookup.demarshall(obj.get("dataSetLookup"), a1));
    }
    return entity;
  }

  public String marshall(DataSetLookupBuilderImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.impl.DataSetLookupBuilderImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSetLookup\":").append(org_dashbuilder_dataset_DataSetLookup.marshall(_$1763033004__1130144749_dataSetLookup(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_DataSetLookup == null) {
      org_dashbuilder_dataset_DataSetLookup = Marshalling.getMarshaller(DataSetLookup.class);
    }
  }
}