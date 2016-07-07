package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.workbench.model.ContextDefinition;
import org.uberfire.workbench.model.ContextDisplayMode;
import org.uberfire.workbench.model.PanelDefinition;
import org.uberfire.workbench.model.PartDefinition;
import org.uberfire.workbench.model.Position;
import org.uberfire.workbench.model.impl.PanelDefinitionImpl;

public class Marshaller_o_u_w_m_i_PanelDefinitionImpl_1_Impl implements GeneratedMarshaller<PanelDefinitionImpl> {
  private PanelDefinitionImpl[] EMPTY_ARRAY = new PanelDefinitionImpl[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<ContextDisplayMode> org_uberfire_workbench_model_ContextDisplayMode = null;
  public PanelDefinitionImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Set _1059474417__$1383343454_parts(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::parts;
  }-*/;

  private native static void _1059474417__$1383343454_parts(PanelDefinitionImpl instance, Set<PartDefinition> value) /*-{
    instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::parts = value;
  }-*/;

  private native static List _1059474417__65821278_children(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::children;
  }-*/;

  private native static void _1059474417__65821278_children(PanelDefinitionImpl instance, List<PanelDefinition> value) /*-{
    instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::children = value;
  }-*/;

  private native static boolean _1059474417__64711720_isRoot(PanelDefinitionImpl instance) /*-{
    return instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::isRoot;
  }-*/;

  private native static void _1059474417__64711720_isRoot(PanelDefinitionImpl instance, boolean value) /*-{
    instance.@org.uberfire.workbench.model.impl.PanelDefinitionImpl::isRoot = value;
  }-*/;

  public PanelDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PanelDefinitionImpl.class, objId);
    }
    PanelDefinitionImpl entity = new PanelDefinitionImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("height")) && (!obj.get("height").isNull())) {
      entity.setHeight(java_lang_Integer.demarshall(obj.get("height"), a1));
    }
    if ((obj.containsKey("width")) && (!obj.get("width").isNull())) {
      entity.setWidth(java_lang_Integer.demarshall(obj.get("width"), a1));
    }
    if ((obj.containsKey("minHeight")) && (!obj.get("minHeight").isNull())) {
      entity.setMinHeight(java_lang_Integer.demarshall(obj.get("minHeight"), a1));
    }
    if ((obj.containsKey("minWidth")) && (!obj.get("minWidth").isNull())) {
      entity.setMinWidth(java_lang_Integer.demarshall(obj.get("minWidth"), a1));
    }
    if ((obj.containsKey("parts")) && (!obj.get("parts").isNull())) {
      a1.setAssumedElementType("org.uberfire.workbench.model.PartDefinition");
      _1059474417__$1383343454_parts(entity, java_util_Set.demarshall(obj.get("parts"), a1));
    }
    if ((obj.containsKey("children")) && (!obj.get("children").isNull())) {
      a1.setAssumedElementType("org.uberfire.workbench.model.PanelDefinition");
      _1059474417__65821278_children(entity, java_util_List.demarshall(obj.get("children"), a1));
    }
    if ((obj.containsKey("elementId")) && (!obj.get("elementId").isNull())) {
      entity.setElementId(java_lang_String.demarshall(obj.get("elementId"), a1));
    }
    if ((obj.containsKey("position")) && (!obj.get("position").isNull())) {
      entity.setPosition((Position) ((ObjectMarshaller) java_lang_Object).demarshall(Position.class, obj.get("position"), a1));
    }
    if ((obj.containsKey("panelType")) && (!obj.get("panelType").isNull())) {
      entity.setPanelType(java_lang_String.demarshall(obj.get("panelType"), a1));
    }
    if ((obj.containsKey("isRoot")) && (!obj.get("isRoot").isNull())) {
      _1059474417__64711720_isRoot(entity, java_lang_Boolean.demarshall(obj.get("isRoot"), a1));
    }
    if ((obj.containsKey("contextDefinition")) && (!obj.get("contextDefinition").isNull())) {
      entity.setContextDefinition((ContextDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(ContextDefinition.class, obj.get("contextDefinition"), a1));
    }
    if ((obj.containsKey("contextDisplayMode")) && (!obj.get("contextDisplayMode").isNull())) {
      entity.setContextDisplayMode(obj.get("contextDisplayMode").isObject() != null ? Enum.valueOf(ContextDisplayMode.class, obj.get("contextDisplayMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("contextDisplayMode").isString() != null ? Enum.valueOf(ContextDisplayMode.class, obj.get("contextDisplayMode").isString().stringValue()) : null);
    }
    if ((obj.containsKey("parent")) && (!obj.get("parent").isNull())) {
      entity.setParent((PanelDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(PanelDefinition.class, obj.get("parent"), a1));
    }
    return entity;
  }

  public String marshall(PanelDefinitionImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.model.impl.PanelDefinitionImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"height\":").append(java_lang_Integer.marshall(a0.getHeight(), a1)).append(",").append("\"width\":").append(java_lang_Integer.marshall(a0.getWidth(), a1)).append(",").append("\"minHeight\":").append(java_lang_Integer.marshall(a0.getMinHeight(), a1)).append(",").append("\"minWidth\":").append(java_lang_Integer.marshall(a0.getMinWidth(), a1)).append(",").append("\"parts\":").append(java_util_Set.marshall(a0.getParts(), a1)).append(",").append("\"children\":").append(java_util_List.marshall(a0.getChildren(), a1)).append(",").append("\"elementId\":").append(java_lang_String.marshall(a0.getElementId(), a1)).append(",").append("\"position\":").append(java_lang_Object.marshall(a0.getPosition(), a1)).append(",").append("\"panelType\":").append(java_lang_String.marshall(a0.getPanelType(), a1)).append(",").append("\"isRoot\":").append(java_lang_Boolean.marshall(_1059474417__64711720_isRoot(a0), a1)).append(",").append("\"contextDefinition\":").append(java_lang_Object.marshall(a0.getContextDefinition(), a1)).append(",").append("\"contextDisplayMode\":").append(a0.getContextDisplayMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.model.ContextDisplayMode\",\"^EnumStringValue\":\"").append(a0.getContextDisplayMode().name()).append("\"}") : "null").append(",").append("\"parent\":").append(java_lang_Object.marshall(a0.getParent(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_workbench_model_ContextDisplayMode == null) {
      org_uberfire_workbench_model_ContextDisplayMode = Marshalling.getMarshaller(ContextDisplayMode.class);
    }
  }
}