package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.rule.ExpressionCollectionIndex;
import org.drools.workbench.models.datamodel.rule.ExpressionPart;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_r_ExpressionCollectionIndex_1_Impl implements GeneratedMarshaller<ExpressionCollectionIndex> {
  private ExpressionCollectionIndex[] EMPTY_ARRAY = new ExpressionCollectionIndex[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ExpressionCollectionIndex[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ExpressionPart _1493848616__1493848616_prev(ExpressionPart instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::prev;
  }-*/;

  private native static void _1493848616__1493848616_prev(ExpressionPart instance, ExpressionPart value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::prev = value;
  }-*/;

  private native static String _1493848616__1195259493_name(ExpressionPart instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::name;
  }-*/;

  private native static void _1493848616__1195259493_name(ExpressionPart instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::name = value;
  }-*/;

  private native static String _1493848616__1195259493_classType(ExpressionPart instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::classType;
  }-*/;

  private native static void _1493848616__1195259493_classType(ExpressionPart instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::classType = value;
  }-*/;

  private native static String _1493848616__1195259493_genericType(ExpressionPart instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::genericType;
  }-*/;

  private native static void _1493848616__1195259493_genericType(ExpressionPart instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::genericType = value;
  }-*/;

  private native static String _1493848616__1195259493_parametricType(ExpressionPart instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::parametricType;
  }-*/;

  private native static void _1493848616__1195259493_parametricType(ExpressionPart instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionPart::parametricType = value;
  }-*/;

  public ExpressionCollectionIndex demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ExpressionCollectionIndex.class, objId);
    }
    ExpressionCollectionIndex entity = new ExpressionCollectionIndex();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("params")) && (!obj.get("params").isNull())) {
      a1.setAssumedMapKeyType("org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition");
      a1.setAssumedMapValueType("org.drools.workbench.models.datamodel.rule.ExpressionFormLine");
      entity.setParams(java_util_Map.demarshall(obj.get("params"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("prev")) && (!obj.get("prev").isNull())) {
      _1493848616__1493848616_prev(entity, (ExpressionPart) ((ObjectMarshaller) java_lang_Object).demarshall(ExpressionPart.class, obj.get("prev"), a1));
    }
    if ((obj.containsKey("next")) && (!obj.get("next").isNull())) {
      entity.setNext((ExpressionPart) ((ObjectMarshaller) java_lang_Object).demarshall(ExpressionPart.class, obj.get("next"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _1493848616__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("classType")) && (!obj.get("classType").isNull())) {
      _1493848616__1195259493_classType(entity, java_lang_String.demarshall(obj.get("classType"), a1));
    }
    if ((obj.containsKey("genericType")) && (!obj.get("genericType").isNull())) {
      _1493848616__1195259493_genericType(entity, java_lang_String.demarshall(obj.get("genericType"), a1));
    }
    if ((obj.containsKey("parametricType")) && (!obj.get("parametricType").isNull())) {
      _1493848616__1195259493_parametricType(entity, java_lang_String.demarshall(obj.get("parametricType"), a1));
    }
    return entity;
  }

  public String marshall(ExpressionCollectionIndex a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ExpressionCollectionIndex\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"params\":").append(java_util_Map.marshall(a0.getParams(), a1)).append(",").append("\"prev\":").append(java_lang_Object.marshall(_1493848616__1493848616_prev(a0), a1)).append(",").append("\"next\":").append(java_lang_Object.marshall(a0.getNext(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"classType\":").append(java_lang_String.marshall(a0.getClassType(), a1)).append(",").append("\"genericType\":").append(java_lang_String.marshall(a0.getGenericType(), a1)).append(",").append("\"parametricType\":").append(java_lang_String.marshall(a0.getParametricType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}