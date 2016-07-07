package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.Node;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ConstraintNodeImpl;
import org.drools.workbench.models.guided.dtree.shared.model.values.Value;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_n_i_ConstraintNodeImpl_1_Impl implements GeneratedMarshaller<ConstraintNodeImpl> {
  private ConstraintNodeImpl[] EMPTY_ARRAY = new ConstraintNodeImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public ConstraintNodeImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$1069102622__65821278_children(BaseNodeImpl instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl::children;
  }-*/;

  private native static void _$1069102622__65821278_children(BaseNodeImpl instance, List<Node> value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl::children = value;
  }-*/;

  public ConstraintNodeImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ConstraintNodeImpl.class, objId);
    }
    ConstraintNodeImpl entity = new ConstraintNodeImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("operator")) && (!obj.get("operator").isNull())) {
      entity.setOperator(java_lang_String.demarshall(obj.get("operator"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue((Value) ((ObjectMarshaller) java_lang_Object).demarshall(Value.class, obj.get("value"), a1));
    }
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      entity.setBinding(java_lang_String.demarshall(obj.get("binding"), a1));
    }
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      entity.setParent((Node) ((ObjectMarshaller) java_lang_Object).demarshall(Node.class, obj.get("parent"), a1));
    }
    if ((obj.containsKey("children")) && (!obj.get("children").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtree.shared.model.nodes.Node");
      _$1069102622__65821278_children(entity, java_util_List.demarshall(obj.get("children"), a1));
    }
    return entity;
  }

  public String marshall(ConstraintNodeImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ConstraintNodeImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"operator\":").append(java_lang_String.marshall(a0.getOperator(), a1)).append(",").append("\"value\":").append(java_lang_Object.marshall(a0.getValue(), a1)).append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"parent\":").append(java_lang_Object.marshall(a0.getParent(), a1)).append(",").append("\"children\":").append(java_util_List.marshall(a0.getChildren(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}