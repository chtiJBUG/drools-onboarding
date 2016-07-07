package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ExpressionMethodParameterDefinition_1_Impl implements GeneratedMarshaller<ExpressionMethodParameterDefinition> {
  private ExpressionMethodParameterDefinition[] EMPTY_ARRAY = new ExpressionMethodParameterDefinition[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ExpressionMethodParameterDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static int _788782118__104431_index(ExpressionMethodParameterDefinition instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition::index;
  }-*/;

  private native static void _788782118__104431_index(ExpressionMethodParameterDefinition instance, int value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition::index = value;
  }-*/;

  private native static String _788782118__1195259493_dataType(ExpressionMethodParameterDefinition instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition::dataType;
  }-*/;

  private native static void _788782118__1195259493_dataType(ExpressionMethodParameterDefinition instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition::dataType = value;
  }-*/;

  public ExpressionMethodParameterDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ExpressionMethodParameterDefinition.class, objId);
    }
    ExpressionMethodParameterDefinition entity = new ExpressionMethodParameterDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("index")) && (!obj.get("index").isNull())) {
      _788782118__104431_index(entity, java_lang_Integer.demarshall(obj.get("index"), a1));
    }
    if ((obj.containsKey("dataType")) && (!obj.get("dataType").isNull())) {
      _788782118__1195259493_dataType(entity, java_lang_String.demarshall(obj.get("dataType"), a1));
    }
    return entity;
  }

  public String marshall(ExpressionMethodParameterDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ExpressionMethodParameterDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"index\":").append(java_lang_Integer.marshall(a0.getIndex(), a1)).append(",").append("\"dataType\":").append(java_lang_String.marshall(a0.getDataType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}