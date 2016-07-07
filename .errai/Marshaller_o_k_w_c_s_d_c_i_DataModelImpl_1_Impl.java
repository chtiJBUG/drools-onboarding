package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl;

public class Marshaller_o_k_w_c_s_d_c_i_DataModelImpl_1_Impl implements GeneratedMarshaller<DataModelImpl> {
  private DataModelImpl[] EMPTY_ARRAY = new DataModelImpl[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public DataModelImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$282278247__$1383349348_dataObjects(DataModelImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl::dataObjects;
  }-*/;

  private native static void _$282278247__$1383349348_dataObjects(DataModelImpl instance, Map<String, DataObject> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl::dataObjects = value;
  }-*/;

  private native static Map _$282278247__$1383349348_dependencyDataObjects(DataModelImpl instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl::dependencyDataObjects;
  }-*/;

  private native static void _$282278247__$1383349348_dependencyDataObjects(DataModelImpl instance, Map<String, DataObject> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl::dependencyDataObjects = value;
  }-*/;

  public DataModelImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataModelImpl.class, objId);
    }
    DataModelImpl entity = new DataModelImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataObjects")) && (!obj.get("dataObjects").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.datamodeller.core.DataObject");
      _$282278247__$1383349348_dataObjects(entity, java_util_Map.demarshall(obj.get("dataObjects"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("dependencyDataObjects")) && (!obj.get("dependencyDataObjects").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.datamodeller.core.DataObject");
      _$282278247__$1383349348_dependencyDataObjects(entity, java_util_Map.demarshall(obj.get("dependencyDataObjects"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(DataModelImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.DataModelImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataObjects\":").append(java_util_Map.marshall(_$282278247__$1383349348_dataObjects(a0), a1)).append(",").append("\"dependencyDataObjects\":").append(java_util_Map.marshall(_$282278247__$1383349348_dependencyDataObjects(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}