package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.ActionFieldValue;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.Node;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_n_i_ActionInsertNodeImpl_1_Impl implements GeneratedMarshaller<ActionInsertNodeImpl> {
  private ActionInsertNodeImpl[] EMPTY_ARRAY = new ActionInsertNodeImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ActionInsertNodeImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _745091744__64711720_isLogicalInsertion(ActionInsertNodeImpl instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl::isLogicalInsertion;
  }-*/;

  private native static void _745091744__64711720_isLogicalInsertion(ActionInsertNodeImpl instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl::isLogicalInsertion = value;
  }-*/;

  private native static List _745091744__65821278_fieldValues(ActionInsertNodeImpl instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl::fieldValues;
  }-*/;

  private native static void _745091744__65821278_fieldValues(ActionInsertNodeImpl instance, List<ActionFieldValue> value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl::fieldValues = value;
  }-*/;

  private native static List _$1069102622__65821278_children(BaseNodeImpl instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl::children;
  }-*/;

  private native static void _$1069102622__65821278_children(BaseNodeImpl instance, List<Node> value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.BaseNodeImpl::children = value;
  }-*/;

  public ActionInsertNodeImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionInsertNodeImpl.class, objId);
    }
    ActionInsertNodeImpl entity = new ActionInsertNodeImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("isLogicalInsertion")) && (!obj.get("isLogicalInsertion").isNull())) {
      _745091744__64711720_isLogicalInsertion(entity, java_lang_Boolean.demarshall(obj.get("isLogicalInsertion"), a1));
    }
    if ((obj.containsKey("fieldValues")) && (!obj.get("fieldValues").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtree.shared.model.nodes.ActionFieldValue");
      _745091744__65821278_fieldValues(entity, java_util_List.demarshall(obj.get("fieldValues"), a1));
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

  public String marshall(ActionInsertNodeImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.nodes.impl.ActionInsertNodeImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"isLogicalInsertion\":").append(java_lang_Boolean.marshall(_745091744__64711720_isLogicalInsertion(a0), a1)).append(",").append("\"fieldValues\":").append(java_util_List.marshall(a0.getFieldValues(), a1)).append(",").append("\"parent\":").append(java_lang_Object.marshall(a0.getParent(), a1)).append(",").append("\"children\":").append(java_util_List.marshall(a0.getChildren(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}