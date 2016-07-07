package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.List;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.impl.DataSetImpl;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_d_i_DataSetImpl_1_Impl implements GeneratedMarshaller<DataSetImpl> {
  private DataSetImpl[] EMPTY_ARRAY = new DataSetImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public DataSetImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataSetImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataSetImpl.class, objId);
    }
    DataSetImpl entity = new DataSetImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("definition")) && (!obj.get("definition").isNull())) {
      entity.setDefinition((DataSetDef) ((ObjectMarshaller) java_lang_Object).demarshall(DataSetDef.class, obj.get("definition"), a1));
    }
    if ((obj.containsKey("uuid")) && (!obj.get("uuid").isNull())) {
      entity.setUUID(java_lang_String.demarshall(obj.get("uuid"), a1));
    }
    if ((obj.containsKey("creationDate")) && (!obj.get("creationDate").isNull())) {
      entity.setCreationDate(java_util_Date.demarshall(obj.get("creationDate"), a1));
    }
    if ((obj.containsKey("columns")) && (!obj.get("columns").isNull())) {
      a1.setAssumedElementType("org.dashbuilder.dataset.impl.DataColumnImpl");
      entity.setColumns(java_util_List.demarshall(obj.get("columns"), a1));
    }
    if ((obj.containsKey("rowCountNonTrimmed")) && (!obj.get("rowCountNonTrimmed").isNull())) {
      entity.setRowCountNonTrimmed(java_lang_Integer.demarshall(obj.get("rowCountNonTrimmed"), a1));
    }
    return entity;
  }

  public String marshall(DataSetImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.impl.DataSetImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"definition\":").append(java_lang_Object.marshall(a0.getDefinition(), a1)).append(",").append("\"uuid\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"creationDate\":").append(java_util_Date.marshall(a0.getCreationDate(), a1)).append(",").append("\"columns\":").append(java_util_List.marshall(a0.getColumns(), a1)).append(",").append("\"rowCountNonTrimmed\":").append(java_lang_Integer.marshall(a0.getRowCountNonTrimmed(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}