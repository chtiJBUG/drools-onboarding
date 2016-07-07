package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.datamodeller.core.DataModel;
import org.kie.workbench.common.services.datamodeller.core.ObjectProperty;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverError;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverResult;
import org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_d_d_m_ModelDriverResult_1_Impl implements GeneratedMarshaller<ModelDriverResult> {
  private ModelDriverResult[] EMPTY_ARRAY = new ModelDriverResult[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public ModelDriverResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _424810410__$1383349348_classPaths(ModelDriverResult instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult::classPaths;
  }-*/;

  private native static void _424810410__$1383349348_classPaths(ModelDriverResult instance, Map<String, Path> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult::classPaths = value;
  }-*/;

  private native static Map _424810410__$1383349348_unmanagedProperties(ModelDriverResult instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult::unmanagedProperties;
  }-*/;

  private native static void _424810410__$1383349348_unmanagedProperties(ModelDriverResult instance, Map<String, List<ObjectProperty>> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult::unmanagedProperties = value;
  }-*/;

  private native static List _$814931607__65821278_errors(DriverResult instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors;
  }-*/;

  private native static void _$814931607__65821278_errors(DriverResult instance, List<DriverError> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors = value;
  }-*/;

  public ModelDriverResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ModelDriverResult.class, objId);
    }
    ModelDriverResult entity = new ModelDriverResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dataModel")) && (!obj.get("dataModel").isNull())) {
      entity.setDataModel((DataModel) ((ObjectMarshaller) java_lang_Object).demarshall(DataModel.class, obj.get("dataModel"), a1));
    }
    if ((obj.containsKey("classPaths")) && (!obj.get("classPaths").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.uberfire.backend.vfs.Path");
      _424810410__$1383349348_classPaths(entity, java_util_Map.demarshall(obj.get("classPaths"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("unmanagedProperties")) && (!obj.get("unmanagedProperties").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.List");
      _424810410__$1383349348_unmanagedProperties(entity, java_util_Map.demarshall(obj.get("unmanagedProperties"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.driver.model.DriverError");
      _$814931607__65821278_errors(entity, java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(ModelDriverResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.ModelDriverResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dataModel\":").append(java_lang_Object.marshall(a0.getDataModel(), a1)).append(",").append("\"classPaths\":").append(java_util_Map.marshall(a0.getClassPaths(), a1)).append(",").append("\"unmanagedProperties\":").append(java_util_Map.marshall(a0.getUnmanagedProperties(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}