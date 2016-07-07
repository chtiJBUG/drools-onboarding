package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.layout.editor.api.editor.LayoutColumn;
import org.uberfire.ext.layout.editor.api.editor.LayoutComponent;
import org.uberfire.ext.layout.editor.api.editor.LayoutRow;

public class Marshaller_o_u_e_l_e_a_e_LayoutColumn_1_Impl implements GeneratedMarshaller<LayoutColumn> {
  private LayoutColumn[] EMPTY_ARRAY = new LayoutColumn[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public LayoutColumn[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _1029915663__65821278_rows(LayoutColumn instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutColumn::rows;
  }-*/;

  private native static void _1029915663__65821278_rows(LayoutColumn instance, List<LayoutRow> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutColumn::rows = value;
  }-*/;

  private native static List _1029915663__65821278_layoutComponents(LayoutColumn instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutColumn::layoutComponents;
  }-*/;

  private native static void _1029915663__65821278_layoutComponents(LayoutColumn instance, List<LayoutComponent> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutColumn::layoutComponents = value;
  }-*/;

  public LayoutColumn demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LayoutColumn.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("span"), a1);
    LayoutColumn entity = new LayoutColumn(c0);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("rows")) && (!obj.get("rows").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.layout.editor.api.editor.LayoutRow");
      _1029915663__65821278_rows(entity, java_util_List.demarshall(obj.get("rows"), a1));
    }
    if ((obj.containsKey("layoutComponents")) && (!obj.get("layoutComponents").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.layout.editor.api.editor.LayoutComponent");
      _1029915663__65821278_layoutComponents(entity, java_util_List.demarshall(obj.get("layoutComponents"), a1));
    }
    return entity;
  }

  public String marshall(LayoutColumn a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.layout.editor.api.editor.LayoutColumn\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"span\":").append(java_lang_String.marshall(a0.getSpan(), a1)).append(",").append("\"rows\":").append(java_util_List.marshall(a0.getRows(), a1)).append(",").append("\"layoutComponents\":").append(java_util_List.marshall(a0.getLayoutComponents(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}