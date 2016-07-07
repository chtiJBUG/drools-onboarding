package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.displayer.ColumnSettings;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_ColumnSettings_1_Impl implements GeneratedMarshaller<ColumnSettings> {
  private ColumnSettings[] EMPTY_ARRAY = new ColumnSettings[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ColumnSettings[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ColumnSettings demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ColumnSettings.class, objId);
    }
    ColumnSettings entity = new ColumnSettings();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("columnId")) && (!obj.get("columnId").isNull())) {
      entity.setColumnId(java_lang_String.demarshall(obj.get("columnId"), a1));
    }
    if ((obj.containsKey("columnName")) && (!obj.get("columnName").isNull())) {
      entity.setColumnName(java_lang_String.demarshall(obj.get("columnName"), a1));
    }
    if ((obj.containsKey("valueExpression")) && (!obj.get("valueExpression").isNull())) {
      entity.setValueExpression(java_lang_String.demarshall(obj.get("valueExpression"), a1));
    }
    if ((obj.containsKey("emptyTemplate")) && (!obj.get("emptyTemplate").isNull())) {
      entity.setEmptyTemplate(java_lang_String.demarshall(obj.get("emptyTemplate"), a1));
    }
    if ((obj.containsKey("valuePattern")) && (!obj.get("valuePattern").isNull())) {
      entity.setValuePattern(java_lang_String.demarshall(obj.get("valuePattern"), a1));
    }
    return entity;
  }

  public String marshall(ColumnSettings a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.displayer.ColumnSettings\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"columnId\":").append(java_lang_String.marshall(a0.getColumnId(), a1)).append(",").append("\"columnName\":").append(java_lang_String.marshall(a0.getColumnName(), a1)).append(",").append("\"valueExpression\":").append(java_lang_String.marshall(a0.getValueExpression(), a1)).append(",").append("\"emptyTemplate\":").append(java_lang_String.marshall(a0.getEmptyTemplate(), a1)).append(",").append("\"valuePattern\":").append(java_lang_String.marshall(a0.getValuePattern(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}