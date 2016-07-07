package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.impl.DataSetBuilderImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_i_DataSetBuilderImpl_1_Impl implements GeneratedMarshaller<DataSetBuilderImpl> {
  private DataSetBuilderImpl[] EMPTY_ARRAY = new DataSetBuilderImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataSetBuilderImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static DataSet _$673392148__$1144125293_dataSet(DataSetBuilderImpl instance) /*-{
    return instance.@org.dashbuilder.dataset.impl.DataSetBuilderImpl::dataSet;
  }-*/;

  private native static void _$673392148__$1144125293_dataSet(DataSetBuilderImpl instance, DataSet value) /*-{
    instance.@org.dashbuilder.dataset.impl.DataSetBuilderImpl::dataSet = value;
  }-*/;

  public DataSetBuilderImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetBuilderImpl.class, objId);
    }
    DataSetBuilderImpl entity = new DataSetBuilderImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataSet")) && (!obj.get("dataSet").isNull())) {
      _$673392148__$1144125293_dataSet(entity, (DataSet) ((ObjectMarshaller) java_lang_Object).demarshall(DataSet.class, obj.get("dataSet"), a1));
    }
    return entity;
  }

  public String marshall(DataSetBuilderImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.impl.DataSetBuilderImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataSet\":").append(java_lang_Object.marshall(_$673392148__$1144125293_dataSet(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}