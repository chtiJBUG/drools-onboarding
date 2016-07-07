package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceResponse;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverError;
import org.kie.workbench.common.services.datamodeller.driver.model.DriverResult;

public class Marshaller_o_k_w_c_s_d_d_m_AnnotationSourceResponse_1_Impl implements GeneratedMarshaller<AnnotationSourceResponse> {
  private AnnotationSourceResponse[] EMPTY_ARRAY = new AnnotationSourceResponse[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public AnnotationSourceResponse[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _1171766159__$1383349348_annotationSources(AnnotationSourceResponse instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceResponse::annotationSources;
  }-*/;

  private native static void _1171766159__$1383349348_annotationSources(AnnotationSourceResponse instance, Map<String, AnnotationSource> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceResponse::annotationSources = value;
  }-*/;

  private native static List _$814931607__65821278_errors(DriverResult instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors;
  }-*/;

  private native static void _$814931607__65821278_errors(DriverResult instance, List<DriverError> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.DriverResult::errors = value;
  }-*/;

  public AnnotationSourceResponse demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationSourceResponse.class, objId);
    }
    AnnotationSourceResponse entity = new AnnotationSourceResponse();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("annotationSources")) && (!obj.get("annotationSources").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource");
      _1171766159__$1383349348_annotationSources(entity, java_util_Map.demarshall(obj.get("annotationSources"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.driver.model.DriverError");
      _$814931607__65821278_errors(entity, java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(AnnotationSourceResponse a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceResponse\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"annotationSources\":").append(java_util_Map.marshall(a0.getAnnotationSources(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}