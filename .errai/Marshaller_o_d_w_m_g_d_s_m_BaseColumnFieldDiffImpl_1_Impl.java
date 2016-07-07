package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.model.BaseColumnFieldDiffImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_BaseColumnFieldDiffImpl_1_Impl implements GeneratedMarshaller<BaseColumnFieldDiffImpl> {
  private BaseColumnFieldDiffImpl[] EMPTY_ARRAY = new BaseColumnFieldDiffImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public BaseColumnFieldDiffImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Object _1473496526__1063877011_newValue(BaseColumnFieldDiffImpl instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.BaseColumnFieldDiffImpl::newValue;
  }-*/;

  private native static void _1473496526__1063877011_newValue(BaseColumnFieldDiffImpl instance, Object value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.BaseColumnFieldDiffImpl::newValue = value;
  }-*/;

  public BaseColumnFieldDiffImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BaseColumnFieldDiffImpl.class, objId);
    }
    BaseColumnFieldDiffImpl entity = new BaseColumnFieldDiffImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("oldValue")) && (!obj.get("oldValue").isNull())) {
      entity.setOldValue(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("oldValue"), a1));
    }
    if ((obj.containsKey("newValue")) && (!obj.get("newValue").isNull())) {
      _1473496526__1063877011_newValue(entity, ((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("newValue"), a1));
    }
    return entity;
  }

  public String marshall(BaseColumnFieldDiffImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.BaseColumnFieldDiffImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"oldValue\":").append(java_lang_Object.marshall(a0.getOldValue(), a1)).append(",").append("\"newValue\":").append(java_lang_Object.marshall(_1473496526__1063877011_newValue(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}