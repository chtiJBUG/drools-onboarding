package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.layout.editor.api.editor.LayoutComponent;

public class Marshaller_o_u_e_l_e_a_e_LayoutComponent_1_Impl implements GeneratedMarshaller<LayoutComponent> {
  private LayoutComponent[] EMPTY_ARRAY = new LayoutComponent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public LayoutComponent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$282540636__1195259493_dragTypeName(LayoutComponent instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutComponent::dragTypeName;
  }-*/;

  private native static void _$282540636__1195259493_dragTypeName(LayoutComponent instance, String value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutComponent::dragTypeName = value;
  }-*/;

  private native static Map _$282540636__$1383349348_properties(LayoutComponent instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutComponent::properties;
  }-*/;

  private native static void _$282540636__$1383349348_properties(LayoutComponent instance, Map<String, String> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutComponent::properties = value;
  }-*/;

  public LayoutComponent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LayoutComponent.class, objId);
    }
    LayoutComponent entity = new LayoutComponent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dragTypeName")) && (!obj.get("dragTypeName").isNull())) {
      _$282540636__1195259493_dragTypeName(entity, java_lang_String.demarshall(obj.get("dragTypeName"), a1));
    }
    if ((obj.containsKey("properties")) && (!obj.get("properties").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$282540636__$1383349348_properties(entity, java_util_Map.demarshall(obj.get("properties"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(LayoutComponent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.layout.editor.api.editor.LayoutComponent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dragTypeName\":").append(java_lang_String.marshall(a0.getDragTypeName(), a1)).append(",").append("\"properties\":").append(java_util_Map.marshall(a0.getProperties(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}