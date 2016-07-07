package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.backend.EditDataSetDef;
import org.dashbuilder.dataset.def.DataColumnDef;
import org.dashbuilder.dataset.def.DataSetDef;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_b_EditDataSetDef_1_Impl implements GeneratedMarshaller<EditDataSetDef> {
  private EditDataSetDef[] EMPTY_ARRAY = new EditDataSetDef[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public EditDataSetDef[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static DataSetDef _282174262__$1914125957_definition(EditDataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.backend.EditDataSetDef::definition;
  }-*/;

  private native static void _282174262__$1914125957_definition(EditDataSetDef instance, DataSetDef value) /*-{
    instance.@org.dashbuilder.dataset.backend.EditDataSetDef::definition = value;
  }-*/;

  private native static List _282174262__65821278_columns(EditDataSetDef instance) /*-{
    return instance.@org.dashbuilder.dataset.backend.EditDataSetDef::columns;
  }-*/;

  private native static void _282174262__65821278_columns(EditDataSetDef instance, List<DataColumnDef> value) /*-{
    instance.@org.dashbuilder.dataset.backend.EditDataSetDef::columns = value;
  }-*/;

  public EditDataSetDef demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EditDataSetDef.class, objId);
    }
    EditDataSetDef entity = new EditDataSetDef();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("definition")) && (!obj.get("definition").isNull())) {
      _282174262__$1914125957_definition(entity, (DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("definition"), a1));
    }
    if ((obj.containsKey("columns")) && (!obj.get("columns").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.def.DataColumnDef");
      _282174262__65821278_columns(entity, java_util_List.demarshall(obj.get("columns"), a1));
    }
    return entity;
  }

  public String marshall(EditDataSetDef a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.backend.EditDataSetDef\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"definition\":").append(java_lang_Object.marshall(a0.getDefinition(), a1)).append(",").append("\"columns\":").append(java_util_List.marshall(a0.getColumns(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}