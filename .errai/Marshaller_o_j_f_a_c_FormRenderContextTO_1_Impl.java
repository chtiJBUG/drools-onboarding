package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.formModeler.api.client.FormRenderContextTO;

public class Marshaller_o_j_f_a_c_FormRenderContextTO_1_Impl implements GeneratedMarshaller<FormRenderContextTO> {
  private FormRenderContextTO[] EMPTY_ARRAY = new FormRenderContextTO[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public FormRenderContextTO[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FormRenderContextTO demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FormRenderContextTO.class, objId);
    }
    FormRenderContextTO entity = new FormRenderContextTO();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("ctxUID")) && (!obj.get("ctxUID").isNull())) {
      entity.setCtxUID(java_lang_String.demarshall(obj.get("ctxUID"), a1));
    }
    if ((obj.containsKey("submit")) && (!obj.get("submit").isNull())) {
      entity.setSubmit(java_lang_Boolean.demarshall(obj.get("submit"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      entity.setErrors(java_lang_Integer.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  private native static boolean _$582722516__64711720_submit(FormRenderContextTO instance) /*-{
    return instance.@org.jbpm.formModeler.api.client.FormRenderContextTO::submit;
  }-*/;

  private native static void _$582722516__64711720_submit(FormRenderContextTO instance, boolean value) /*-{
    instance.@org.jbpm.formModeler.api.client.FormRenderContextTO::submit = value;
  }-*/;

  public String marshall(FormRenderContextTO a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.formModeler.api.client.FormRenderContextTO\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"ctxUID\":").append(java_lang_String.marshall(a0.getCtxUID(), a1)).append(",").append("\"submit\":").append(java_lang_Boolean.marshall(_$582722516__64711720_submit(a0), a1)).append(",").append("\"errors\":").append(java_lang_Integer.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}