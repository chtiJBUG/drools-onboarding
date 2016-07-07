package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.datamodeller.core.AnnotationDefinition;
import org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotation;
import org.kie.workbench.common.services.datamodeller.core.impl.AnnotationImpl;

public class Marshaller_o_k_w_c_s_d_c_i_AnnotationImpl_1_Impl implements GeneratedMarshaller<AnnotationImpl> {
  private AnnotationImpl[] EMPTY_ARRAY = new AnnotationImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public AnnotationImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static AnnotationDefinition _1425360631__1830708650_annotationDefinition(AbstractAnnotation instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotation::annotationDefinition;
  }-*/;

  private native static void _1425360631__1830708650_annotationDefinition(AbstractAnnotation instance, AnnotationDefinition value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotation::annotationDefinition = value;
  }-*/;

  private native static Map _1425360631__$1383349348_values(AbstractAnnotation instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotation::values;
  }-*/;

  private native static void _1425360631__$1383349348_values(AbstractAnnotation instance, Map value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.core.impl.AbstractAnnotation::values = value;
  }-*/;

  public AnnotationImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationImpl.class, objId);
    }
    AnnotationImpl entity = new AnnotationImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("annotationDefinition")) && (!obj.get("annotationDefinition").isNull())) {
      _1425360631__1830708650_annotationDefinition(entity, (AnnotationDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(AnnotationDefinition.class, obj.get("annotationDefinition"), a1));
    }
    if ((obj.containsKey("values")) && (!obj.get("values").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _1425360631__$1383349348_values(entity, java_util_Map.demarshall(obj.get("values"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(AnnotationImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.AnnotationImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"annotationDefinition\":").append(java_lang_Object.marshall(a0.getAnnotationDefinition(), a1)).append(",").append("\"values\":").append(java_util_Map.marshall(a0.getValues(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}