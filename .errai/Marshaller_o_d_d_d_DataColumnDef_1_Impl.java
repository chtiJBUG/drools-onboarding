package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.ColumnType;
import org.dashbuilder.dataset.def.DataColumnDef;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_d_DataColumnDef_1_Impl implements GeneratedMarshaller<DataColumnDef> {
  private DataColumnDef[] EMPTY_ARRAY = new DataColumnDef[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ColumnType> org_dashbuilder_dataset_ColumnType = null;
  public DataColumnDef[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataColumnDef demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataColumnDef.class, objId);
    }
    DataColumnDef entity = new DataColumnDef();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("columnType")) && (!obj.get("columnType").isNull())) {
      entity.setColumnType(obj.get("columnType").isObject() != null ? Enum.valueOf(ColumnType.class, obj.get("columnType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("columnType").isString() != null ? Enum.valueOf(ColumnType.class, obj.get("columnType").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(DataColumnDef a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.def.DataColumnDef\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"columnType\":").append(a0.getColumnType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.ColumnType\",\"^EnumStringValue\":\"").append(a0.getColumnType().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_dashbuilder_dataset_ColumnType == null) {
      org_dashbuilder_dataset_ColumnType = Marshalling.getMarshaller(ColumnType.class);
    }
  }
}