package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.layout.editor.api.editor.LayoutColumn;
import org.uberfire.ext.layout.editor.api.editor.LayoutRow;

public class Marshaller_o_u_e_l_e_a_e_LayoutRow_1_Impl implements GeneratedMarshaller<LayoutRow> {
  private LayoutRow[] EMPTY_ARRAY = new LayoutRow[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public LayoutRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _2123672513__65821278_rowSpam(LayoutRow instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutRow::rowSpam;
  }-*/;

  private native static void _2123672513__65821278_rowSpam(LayoutRow instance, List<String> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutRow::rowSpam = value;
  }-*/;

  private native static List _2123672513__65821278_layoutColumns(LayoutRow instance) /*-{
    return instance.@org.uberfire.ext.layout.editor.api.editor.LayoutRow::layoutColumns;
  }-*/;

  private native static void _2123672513__65821278_layoutColumns(LayoutRow instance, List<LayoutColumn> value) /*-{
    instance.@org.uberfire.ext.layout.editor.api.editor.LayoutRow::layoutColumns = value;
  }-*/;

  public LayoutRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LayoutRow.class, objId);
    }
    LayoutRow entity = new LayoutRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("rowSpam")) && (!obj.get("rowSpam").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _2123672513__65821278_rowSpam(entity, java_util_List.demarshall(obj.get("rowSpam"), a1));
    }
    if ((obj.containsKey("layoutColumns")) && (!obj.get("layoutColumns").isNull())) {
      a1.setAssumedElementType("org.uberfire.ext.layout.editor.api.editor.LayoutColumn");
      _2123672513__65821278_layoutColumns(entity, java_util_List.demarshall(obj.get("layoutColumns"), a1));
    }
    return entity;
  }

  public String marshall(LayoutRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.layout.editor.api.editor.LayoutRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"rowSpam\":").append(java_util_List.marshall(a0.getRowSpam(), a1)).append(",").append("\"layoutColumns\":").append(java_util_List.marshall(a0.getLayoutColumns(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}