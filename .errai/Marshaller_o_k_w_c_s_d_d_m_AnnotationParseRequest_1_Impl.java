package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.ElementType;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest;

public class Marshaller_o_k_w_c_s_d_d_m_AnnotationParseRequest_1_Impl implements GeneratedMarshaller<AnnotationParseRequest> {
  private AnnotationParseRequest[] EMPTY_ARRAY = new AnnotationParseRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ElementType> org_kie_workbench_common_services_datamodeller_core_ElementType = null;
  public AnnotationParseRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1895767855__1195259493_annotationClassName(AnnotationParseRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::annotationClassName;
  }-*/;

  private native static void _1895767855__1195259493_annotationClassName(AnnotationParseRequest instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::annotationClassName = value;
  }-*/;

  private native static String _1895767855__1195259493_valuePairName(AnnotationParseRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::valuePairName;
  }-*/;

  private native static void _1895767855__1195259493_valuePairName(AnnotationParseRequest instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::valuePairName = value;
  }-*/;

  private native static String _1895767855__1195259493_valuePairLiteralValue(AnnotationParseRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::valuePairLiteralValue;
  }-*/;

  private native static void _1895767855__1195259493_valuePairLiteralValue(AnnotationParseRequest instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::valuePairLiteralValue = value;
  }-*/;

  private native static ElementType _1895767855__1887144846_target(AnnotationParseRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::target;
  }-*/;

  private native static void _1895767855__1887144846_target(AnnotationParseRequest instance, ElementType value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest::target = value;
  }-*/;

  public AnnotationParseRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationParseRequest.class, objId);
    }
    AnnotationParseRequest entity = new AnnotationParseRequest();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("annotationClassName")) && (!obj.get("annotationClassName").isNull())) {
      _1895767855__1195259493_annotationClassName(entity, java_lang_String.demarshall(obj.get("annotationClassName"), a1));
    }
    if ((obj.containsKey("valuePairName")) && (!obj.get("valuePairName").isNull())) {
      _1895767855__1195259493_valuePairName(entity, java_lang_String.demarshall(obj.get("valuePairName"), a1));
    }
    if ((obj.containsKey("valuePairLiteralValue")) && (!obj.get("valuePairLiteralValue").isNull())) {
      _1895767855__1195259493_valuePairLiteralValue(entity, java_lang_String.demarshall(obj.get("valuePairLiteralValue"), a1));
    }
    if ((obj.containsKey("target")) && (!obj.get("target").isNull())) {
      _1895767855__1887144846_target(entity, obj.get("target").isObject() != null ? Enum.valueOf(ElementType.class, obj.get("target").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("target").isString() != null ? Enum.valueOf(ElementType.class, obj.get("target").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(AnnotationParseRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"annotationClassName\":").append(java_lang_String.marshall(a0.getAnnotationClassName(), a1)).append(",").append("\"valuePairName\":").append(java_lang_String.marshall(a0.getValuePairName(), a1)).append(",").append("\"valuePairLiteralValue\":").append(java_lang_String.marshall(a0.getValuePairLiteralValue(), a1)).append(",").append("\"target\":").append(a0.getTarget() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.ElementType\",\"^EnumStringValue\":\"").append(a0.getTarget().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_datamodeller_core_ElementType == null) {
      org_kie_workbench_common_services_datamodeller_core_ElementType = Marshalling.getMarshaller(ElementType.class);
    }
  }
}