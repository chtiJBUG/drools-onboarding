package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.InterpolationVariable;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_InterpolationVariable_1_Impl implements GeneratedMarshaller<InterpolationVariable> {
  private InterpolationVariable[] EMPTY_ARRAY = new InterpolationVariable[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public InterpolationVariable[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _374055459__1195259493_dataType(InterpolationVariable instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.InterpolationVariable::dataType;
  }-*/;

  private native static void _374055459__1195259493_dataType(InterpolationVariable instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.InterpolationVariable::dataType = value;
  }-*/;

  public InterpolationVariable demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(InterpolationVariable.class, objId);
    }
    InterpolationVariable entity = new InterpolationVariable();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("varName")) && (!obj.get("varName").isNull())) {
      entity.setVarName(java_lang_String.demarshall(obj.get("varName"), a1));
    }
    if ((obj.containsKey("dataType")) && (!obj.get("dataType").isNull())) {
      _374055459__1195259493_dataType(entity, java_lang_String.demarshall(obj.get("dataType"), a1));
    }
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("factField")) && (!obj.get("factField").isNull())) {
      entity.setFactField(java_lang_String.demarshall(obj.get("factField"), a1));
    }
    return entity;
  }

  public String marshall(InterpolationVariable a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.InterpolationVariable\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"varName\":").append(java_lang_String.marshall(a0.getVarName(), a1)).append(",").append("\"dataType\":").append(java_lang_String.marshall(a0.getDataType(), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"factField\":").append(java_lang_String.marshall(a0.getFactField(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}