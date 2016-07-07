package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest;

public class Marshaller_o_k_w_c_s_d_d_m_AnnotationDefinitionRequest_1_Impl implements GeneratedMarshaller<AnnotationDefinitionRequest> {
  private AnnotationDefinitionRequest[] EMPTY_ARRAY = new AnnotationDefinitionRequest[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public AnnotationDefinitionRequest[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1252852023__1195259493_className(AnnotationDefinitionRequest instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest::className;
  }-*/;

  private native static void _$1252852023__1195259493_className(AnnotationDefinitionRequest instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest::className = value;
  }-*/;

  public AnnotationDefinitionRequest demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationDefinitionRequest.class, objId);
    }
    AnnotationDefinitionRequest entity = new AnnotationDefinitionRequest();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      _$1252852023__1195259493_className(entity, java_lang_String.demarshall(obj.get("className"), a1));
    }
    return entity;
  }

  public String marshall(AnnotationDefinitionRequest a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}