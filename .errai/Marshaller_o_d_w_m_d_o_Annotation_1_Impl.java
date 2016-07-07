package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.oracle.Annotation;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_Annotation_1_Impl implements GeneratedMarshaller<Annotation> {
  private Annotation[] EMPTY_ARRAY = new Annotation[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public Annotation[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1098431146__1195259493_qualifiedTypeName(Annotation instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.Annotation::qualifiedTypeName;
  }-*/;

  private native static void _1098431146__1195259493_qualifiedTypeName(Annotation instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.Annotation::qualifiedTypeName = value;
  }-*/;

  private native static Map _1098431146__$1383349348_attributes(Annotation instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.Annotation::attributes;
  }-*/;

  private native static void _1098431146__$1383349348_attributes(Annotation instance, Map<String, String> value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.Annotation::attributes = value;
  }-*/;

  public Annotation demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Annotation.class, objId);
    }
    Annotation entity = new Annotation();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("qualifiedTypeName")) && (!obj.get("qualifiedTypeName").isNull())) {
      _1098431146__1195259493_qualifiedTypeName(entity, java_lang_String.demarshall(obj.get("qualifiedTypeName"), a1));
    }
    if ((obj.containsKey("attributes")) && (!obj.get("attributes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _1098431146__$1383349348_attributes(entity, java_util_Map.demarshall(obj.get("attributes"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(Annotation a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.Annotation\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"qualifiedTypeName\":").append(java_lang_String.marshall(a0.getQualifiedTypeName(), a1)).append(",").append("\"attributes\":").append(java_util_Map.marshall(a0.getAttributes(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}