package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource;

public class Marshaller_o_k_w_c_s_d_d_m_AnnotationSource_1_Impl implements GeneratedMarshaller<AnnotationSource> {
  private AnnotationSource[] EMPTY_ARRAY = new AnnotationSource[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public AnnotationSource[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _366694702__1195259493_source(AnnotationSource instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource::source;
  }-*/;

  private native static void _366694702__1195259493_source(AnnotationSource instance, String value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource::source = value;
  }-*/;

  private native static Map _366694702__$1383349348_valuePairSources(AnnotationSource instance) /*-{
    return instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource::valuePairSources;
  }-*/;

  private native static void _366694702__$1383349348_valuePairSources(AnnotationSource instance, Map<String, String> value) /*-{
    instance.@org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource::valuePairSources = value;
  }-*/;

  public AnnotationSource demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationSource.class, objId);
    }
    AnnotationSource entity = new AnnotationSource();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      _366694702__1195259493_source(entity, java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("valuePairSources")) && (!obj.get("valuePairSources").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _366694702__$1383349348_valuePairSources(entity, java_util_Map.demarshall(obj.get("valuePairSources"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(AnnotationSource a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSource\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"valuePairSources\":").append(java_util_Map.marshall(_366694702__$1383349348_valuePairSources(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}