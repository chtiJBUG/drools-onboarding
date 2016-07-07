package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.drools.workbench.models.datamodel.oracle.DataType.DataTypes;
import org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_DTCellValue52_1_Impl implements GeneratedMarshaller<DTCellValue52> {
  private DTCellValue52[] EMPTY_ARRAY = new DTCellValue52[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<DataTypes> org_drools_workbench_models_datamodel_oracle_DataType_erraiD_DataTypes = null;
  public DTCellValue52[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Boolean _$1211268558__344809556_valueBoolean(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueBoolean;
  }-*/;

  private native static void _$1211268558__344809556_valueBoolean(DTCellValue52 instance, Boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueBoolean = value;
  }-*/;

  private native static Date _$1211268558__65575278_valueDate(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueDate;
  }-*/;

  private native static void _$1211268558__65575278_valueDate(DTCellValue52 instance, Date value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueDate = value;
  }-*/;

  private native static Number _$1211268558__1052881309_valueNumeric(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueNumeric;
  }-*/;

  private native static void _$1211268558__1052881309_valueNumeric(DTCellValue52 instance, Number value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueNumeric = value;
  }-*/;

  private native static String _$1211268558__1195259493_valueString(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueString;
  }-*/;

  private native static void _$1211268558__1195259493_valueString(DTCellValue52 instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::valueString = value;
  }-*/;

  private native static DataTypes _$1211268558__$729007958_dataType(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::dataType;
  }-*/;

  private native static void _$1211268558__$729007958_dataType(DTCellValue52 instance, DataTypes value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::dataType = value;
  }-*/;

  private native static boolean _$1211268558__64711720_isOtherwise(DTCellValue52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::isOtherwise;
  }-*/;

  private native static void _$1211268558__64711720_isOtherwise(DTCellValue52 instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52::isOtherwise = value;
  }-*/;

  public DTCellValue52 demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DTCellValue52.class, objId);
    }
    DTCellValue52 entity = new DTCellValue52();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("valueBoolean")) && (!obj.get("valueBoolean").isNull())) {
      _$1211268558__344809556_valueBoolean(entity, java_lang_Boolean.demarshall(obj.get("valueBoolean"), a1));
    }
    if ((obj.containsKey("valueDate")) && (!obj.get("valueDate").isNull())) {
      _$1211268558__65575278_valueDate(entity, java_util_Date.demarshall(obj.get("valueDate"), a1));
    }
    if ((obj.containsKey("valueNumeric")) && (!obj.get("valueNumeric").isNull())) {
      _$1211268558__1052881309_valueNumeric(entity, (Number) ((ObjectMarshaller) java_lang_Object).demarshall(Number.class, obj.get("valueNumeric"), a1));
    }
    if ((obj.containsKey("valueString")) && (!obj.get("valueString").isNull())) {
      _$1211268558__1195259493_valueString(entity, java_lang_String.demarshall(obj.get("valueString"), a1));
    }
    if ((obj.containsKey("dataType")) && (!obj.get("dataType").isNull())) {
      _$1211268558__$729007958_dataType(entity, obj.get("dataType").isObject() != null ? Enum.valueOf(DataTypes.class, obj.get("dataType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("dataType").isString() != null ? Enum.valueOf(DataTypes.class, obj.get("dataType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("isOtherwise")) && (!obj.get("isOtherwise").isNull())) {
      _$1211268558__64711720_isOtherwise(entity, java_lang_Boolean.demarshall(obj.get("isOtherwise"), a1));
    }
    return entity;
  }

  public String marshall(DTCellValue52 a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"valueBoolean\":").append(java_lang_Boolean.marshall(_$1211268558__344809556_valueBoolean(a0), a1)).append(",").append("\"valueDate\":").append(java_util_Date.marshall(_$1211268558__65575278_valueDate(a0), a1)).append(",").append("\"valueNumeric\":").append(java_lang_Object.marshall(_$1211268558__1052881309_valueNumeric(a0), a1)).append(",").append("\"valueString\":").append(java_lang_String.marshall(_$1211268558__1195259493_valueString(a0), a1)).append(",").append("\"dataType\":").append(a0.getDataType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.DataType$DataTypes\",\"^EnumStringValue\":\"").append(a0.getDataType().name()).append("\"}") : "null").append(",").append("\"isOtherwise\":").append(java_lang_Boolean.marshall(_$1211268558__64711720_isOtherwise(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_oracle_DataType_erraiD_DataTypes == null) {
      org_drools_workbench_models_datamodel_oracle_DataType_erraiD_DataTypes = Marshalling.getMarshaller(DataTypes.class);
    }
  }
}