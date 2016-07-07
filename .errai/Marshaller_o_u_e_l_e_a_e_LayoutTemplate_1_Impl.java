package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.layout.editor.api.editor.LayoutRow;
import org.uberfire.ext.layout.editor.api.editor.LayoutTemplate;

public class Marshaller_o_u_e_l_e_a_e_LayoutTemplate_1_Impl implements GeneratedMarshaller<LayoutTemplate> {
  private LayoutTemplate[] EMPTY_ARRAY = new LayoutTemplate[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public LayoutTemplate[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static int _1208349427__104431_version(LayoutTemplate instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::version;
  }-*/;

  private native static void _1208349427__104431_version(LayoutTemplate instance, int value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::version = value;
  }-*/;

  private native static Map _1208349427__$1383349348_layoutProperties(LayoutTemplate instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::layoutProperties;
  }-*/;

  private native static void _1208349427__$1383349348_layoutProperties(LayoutTemplate instance, Map<String, String> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::layoutProperties = value;
  }-*/;

  private native static List _1208349427__65821278_rows(LayoutTemplate instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::rows;
  }-*/;

  private native static void _1208349427__65821278_rows(LayoutTemplate instance, List<LayoutRow> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutTemplate::rows = value;
  }-*/;

  public LayoutTemplate demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LayoutTemplate.class, objId);
    }
    LayoutTemplate entity = new LayoutTemplate();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      _1208349427__104431_version(entity, java_lang_Integer.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("layoutProperties")) && (!obj.get("layoutProperties").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _1208349427__$1383349348_layoutProperties(entity, java_util_Map.demarshall(obj.get("layoutProperties"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("rows")) && (!obj.get("rows").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.layout.editor.api.editor.LayoutRow");
      _1208349427__65821278_rows(entity, java_util_List.demarshall(obj.get("rows"), a1));
    }
    return entity;
  }

  public String marshall(LayoutTemplate a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.layout.editor.api.editor.LayoutTemplate\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"version\":").append(java_lang_Integer.marshall(a0.getVersion(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"layoutProperties\":").append(java_util_Map.marshall(a0.getLayoutProperties(), a1)).append(",").append("\"rows\":").append(java_util_List.marshall(a0.getRows(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}