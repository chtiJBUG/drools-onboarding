package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.formModeler.api.client.FormRenderContext;
import org.jbpm.formModeler.api.model.Form;

public class Marshaller_o_j_f_a_c_FormRenderContext_1_Impl implements GeneratedMarshaller<FormRenderContext> {
  private FormRenderContext[] EMPTY_ARRAY = new FormRenderContext[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Form> org_jbpm_formModeler_api_model_Form = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public FormRenderContext[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1730213391__1195259493_UID(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::UID;
  }-*/;

  private native static void _$1730213391__1195259493_UID(FormRenderContext instance, String value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::UID = value;
  }-*/;

  private native static Map _$1730213391__$1383349348_inputData(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::inputData;
  }-*/;

  private native static void _$1730213391__$1383349348_inputData(FormRenderContext instance, Map value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::inputData = value;
  }-*/;

  private native static Map _$1730213391__$1383349348_outputData(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::outputData;
  }-*/;

  private native static void _$1730213391__$1383349348_outputData(FormRenderContext instance, Map value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::outputData = value;
  }-*/;

  public FormRenderContext demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FormRenderContext.class, objId);
    }
    FormRenderContext entity = new FormRenderContext();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("UID")) && (!obj.get("UID").isNull())) {
      _$1730213391__1195259493_UID(entity, java_lang_String.demarshall(obj.get("UID"), a1));
    }
    if ((obj.containsKey("form")) && (!obj.get("form").isNull())) {
      entity.setForm(org_jbpm_formModeler_api_model_Form.demarshall(obj.get("form"), a1));
    }
    if ((obj.containsKey("readonly")) && (!obj.get("readonly").isNull())) {
      entity.setReadonly(java_lang_Boolean.demarshall(obj.get("readonly"), a1));
    }
    if ((obj.containsKey("inputData")) && (!obj.get("inputData").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$1730213391__$1383349348_inputData(entity, java_util_Map.demarshall(obj.get("inputData"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("outputData")) && (!obj.get("outputData").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$1730213391__$1383349348_outputData(entity, java_util_Map.demarshall(obj.get("outputData"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("submit")) && (!obj.get("submit").isNull())) {
      entity.setSubmit(java_lang_Boolean.demarshall(obj.get("submit"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      entity.setErrors(java_lang_Integer.demarshall(obj.get("errors"), a1));
    }
    if ((obj.containsKey("contextForms")) && (!obj.get("contextForms").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      entity.setContextForms(java_util_Map.demarshall(obj.get("contextForms"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("inUse")) && (!obj.get("inUse").isNull())) {
      entity.setInUse(java_lang_Boolean.demarshall(obj.get("inUse"), a1));
    }
    if ((obj.containsKey("deploymentId")) && (!obj.get("deploymentId").isNull())) {
      entity.setDeploymentId(java_lang_String.demarshall(obj.get("deploymentId"), a1));
    }
    return entity;
  }

  private native static boolean _$1730213391__64711720_readonly(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::readonly;
  }-*/;

  private native static void _$1730213391__64711720_readonly(FormRenderContext instance, boolean value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::readonly = value;
  }-*/;

  private native static boolean _$1730213391__64711720_submit(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::submit;
  }-*/;

  private native static void _$1730213391__64711720_submit(FormRenderContext instance, boolean value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::submit = value;
  }-*/;

  private native static boolean _$1730213391__64711720_inUse(FormRenderContext instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContext::inUse;
  }-*/;

  private native static void _$1730213391__64711720_inUse(FormRenderContext instance, boolean value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContext::inUse = value;
  }-*/;

  public String marshall(FormRenderContext a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.formModeler.api.client.FormRenderContext\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"UID\":").append(java_lang_String.marshall(a0.getUID(), a1)).append(",").append("\"form\":").append(org_jbpm_formModeler_api_model_Form.marshall(a0.getForm(), a1)).append(",").append("\"readonly\":").append(java_lang_Boolean.marshall(_$1730213391__64711720_readonly(a0), a1)).append(",").append("\"inputData\":").append(java_util_Map.marshall(a0.getInputData(), a1)).append(",").append("\"outputData\":").append(java_util_Map.marshall(a0.getOutputData(), a1)).append(",").append("\"submit\":").append(java_lang_Boolean.marshall(_$1730213391__64711720_submit(a0), a1)).append(",").append("\"errors\":").append(java_lang_Integer.marshall(a0.getErrors(), a1)).append(",").append("\"contextForms\":").append(java_util_Map.marshall(a0.getContextForms(), a1)).append(",").append("\"inUse\":").append(java_lang_Boolean.marshall(_$1730213391__64711720_inUse(a0), a1)).append(",").append("\"deploymentId\":").append(java_lang_String.marshall(a0.getDeploymentId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_jbpm_formModeler_api_model_Form == null) {
      org_jbpm_formModeler_api_model_Form = Marshalling.getMarshaller(Form.class);
    }
  }
}