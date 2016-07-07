package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ActionWorkItemFieldValue_1_Impl implements GeneratedMarshaller<ActionWorkItemFieldValue> {
  private ActionWorkItemFieldValue[] EMPTY_ARRAY = new ActionWorkItemFieldValue[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public ActionWorkItemFieldValue[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$396518002__1195259493_workItemName(ActionWorkItemFieldValue instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemName;
  }-*/;

  private native static void _$396518002__1195259493_workItemName(ActionWorkItemFieldValue instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemName = value;
  }-*/;

  private native static String _$396518002__1195259493_workItemParameterName(ActionWorkItemFieldValue instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemParameterName;
  }-*/;

  private native static void _$396518002__1195259493_workItemParameterName(ActionWorkItemFieldValue instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemParameterName = value;
  }-*/;

  private native static String _$396518002__1195259493_workItemParameterClassName(ActionWorkItemFieldValue instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemParameterClassName;
  }-*/;

  private native static void _$396518002__1195259493_workItemParameterClassName(ActionWorkItemFieldValue instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue::workItemParameterClassName = value;
  }-*/;

  public ActionWorkItemFieldValue demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionWorkItemFieldValue.class, objId);
    }
    ActionWorkItemFieldValue entity = new ActionWorkItemFieldValue();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("workItemName")) && (!obj.get("workItemName").isNull())) {
      _$396518002__1195259493_workItemName(entity, java_lang_String.demarshall(obj.get("workItemName"), a1));
    }
    if ((obj.containsKey("workItemParameterName")) && (!obj.get("workItemParameterName").isNull())) {
      _$396518002__1195259493_workItemParameterName(entity, java_lang_String.demarshall(obj.get("workItemParameterName"), a1));
    }
    if ((obj.containsKey("workItemParameterClassName")) && (!obj.get("workItemParameterClassName").isNull())) {
      _$396518002__1195259493_workItemParameterClassName(entity, java_lang_String.demarshall(obj.get("workItemParameterClassName"), a1));
    }
    if ((obj.containsKey("field")) && (!obj.get("field").isNull())) {
      entity.setField(java_lang_String.demarshall(obj.get("field"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("nature")) && (!obj.get("nature").isNull())) {
      entity.setNature(java_lang_Integer.demarshall(obj.get("nature"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    return entity;
  }

  public String marshall(ActionWorkItemFieldValue a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionWorkItemFieldValue\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"workItemName\":").append(java_lang_String.marshall(a0.getWorkItemName(), a1)).append(",").append("\"workItemParameterName\":").append(java_lang_String.marshall(a0.getWorkItemParameterName(), a1)).append(",").append("\"workItemParameterClassName\":").append(java_lang_String.marshall(a0.getWorkItemParameterClassName(), a1)).append(",").append("\"field\":").append(java_lang_String.marshall(a0.getField(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"nature\":").append(java_lang_Integer.marshall(a0.getNature(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}