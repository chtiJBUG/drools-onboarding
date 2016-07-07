package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.properties.editor.model.PropertyEditorCategory;
import org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo;

public class Marshaller_o_u_e_p_e_m_PropertyEditorCategory_1_Impl implements GeneratedMarshaller<PropertyEditorCategory> {
  private PropertyEditorCategory[] EMPTY_ARRAY = new PropertyEditorCategory[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public PropertyEditorCategory[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _488487372__1195259493_name(PropertyEditorCategory instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::name;
  }-*/;

  private native static void _488487372__1195259493_name(PropertyEditorCategory instance, String value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::name = value;
  }-*/;

  private native static int _488487372__104431_priority(PropertyEditorCategory instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::priority;
  }-*/;

  private native static void _488487372__104431_priority(PropertyEditorCategory instance, int value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::priority = value;
  }-*/;

  private native static List _488487372__65821278_fields(PropertyEditorCategory instance) /*-{
    return instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::fields;
  }-*/;

  private native static void _488487372__65821278_fields(PropertyEditorCategory instance, List<PropertyEditorFieldInfo> value) /*-{
    instance.@org.uberfire.ext.properties.editor.model.PropertyEditorCategory::fields = value;
  }-*/;

  public PropertyEditorCategory demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PropertyEditorCategory.class, objId);
    }
    PropertyEditorCategory entity = new PropertyEditorCategory();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _488487372__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("priority")) && (!obj.get("priority").isNull())) {
      _488487372__104431_priority(entity, java_lang_Integer.demarshall(obj.get("priority"), a1));
    }
    if ((obj.containsKey("fields")) && (!obj.get("fields").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo");
      _488487372__65821278_fields(entity, java_util_List.demarshall(obj.get("fields"), a1));
    }
    if ((obj.containsKey("idEvent")) && (!obj.get("idEvent").isNull())) {
      entity.setIdEvent(java_lang_String.demarshall(obj.get("idEvent"), a1));
    }
    return entity;
  }

  public String marshall(PropertyEditorCategory a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.properties.editor.model.PropertyEditorCategory\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"priority\":").append(java_lang_Integer.marshall(a0.getPriority(), a1)).append(",").append("\"fields\":").append(java_util_List.marshall(a0.getFields(), a1)).append(",").append("\"idEvent\":").append(java_lang_String.marshall(a0.getIdEvent(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}