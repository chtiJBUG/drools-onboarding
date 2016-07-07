package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.Annotation;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest;

public class Marshaller_o_k_w_c_s_d_d_m_AnnotationSourceRequest_1_Impl implements GeneratedMarshaller<AnnotationSourceRequest> {
  private AnnotationSourceRequest[] EMPTY_ARRAY = new AnnotationSourceRequest[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public AnnotationSourceRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1005922689__65821278_annotations(AnnotationSourceRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest::annotations;
  }-*/;

  private native static void _1005922689__65821278_annotations(AnnotationSourceRequest instance, List<Annotation> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest::annotations = value;
  }-*/;

  public AnnotationSourceRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationSourceRequest.class, objId);
    }
    AnnotationSourceRequest entity = new AnnotationSourceRequest();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("annotations")) && (!obj.get("annotations").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.datamodeller.core.Annotation");
      _1005922689__65821278_annotations(entity, java_util_List.demarshall(obj.get("annotations"), a1));
    }
    return entity;
  }

  public String marshall(AnnotationSourceRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"annotations\":").append(java_util_List.marshall(a0.getAnnotations(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}