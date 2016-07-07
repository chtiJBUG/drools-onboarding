package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.ActionInsertFactColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.LimitedEntryActionInsertFactColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_LimitedEntryActionInsertFactColumnDetails_1_Impl implements GeneratedMarshaller<LimitedEntryActionInsertFactColumnDetails> {
  private LimitedEntryActionInsertFactColumnDetails[] EMPTY_ARRAY = new LimitedEntryActionInsertFactColumnDetails[0];
  private Marshaller<DTCellValue52> org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public LimitedEntryActionInsertFactColumnDetails[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static DTCellValue52 _1458649497__$1211268558_value(LimitedEntryActionInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.LimitedEntryActionInsertFactColumnDetails::value;
  }-*/;

  private native static void _1458649497__$1211268558_value(LimitedEntryActionInsertFactColumnDetails instance, DTCellValue52 value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.LimitedEntryActionInsertFactColumnDetails::value = value;
  }-*/;

  private native static String _1292089777__1195259493_factType(ActionInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionInsertFactColumnDetails::factType;
  }-*/;

  private native static void _1292089777__1195259493_factType(ActionInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionInsertFactColumnDetails::factType = value;
  }-*/;

  private native static String _1292089777__1195259493_factField(ActionInsertFactColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionInsertFactColumnDetails::factField;
  }-*/;

  private native static void _1292089777__1195259493_factField(ActionInsertFactColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ActionInsertFactColumnDetails::factField = value;
  }-*/;

  private native static String _$493965940__1195259493_columnHeader(ColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader;
  }-*/;

  private native static void _$493965940__1195259493_columnHeader(ColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader = value;
  }-*/;

  public LimitedEntryActionInsertFactColumnDetails demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(LimitedEntryActionInsertFactColumnDetails.class, objId);
    }
    LimitedEntryActionInsertFactColumnDetails entity = new LimitedEntryActionInsertFactColumnDetails();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      _1458649497__$1211268558_value(entity, org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      _1292089777__1195259493_factType(entity, java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("factField")) && (!obj.get("factField").isNull())) {
      _1292089777__1195259493_factField(entity, java_lang_String.demarshall(obj.get("factField"), a1));
    }
    if ((obj.containsKey("columnHeader")) && (!obj.get("columnHeader").isNull())) {
      _$493965940__1195259493_columnHeader(entity, java_lang_String.demarshall(obj.get("columnHeader"), a1));
    }
    return entity;
  }

  public String marshall(LimitedEntryActionInsertFactColumnDetails a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.LimitedEntryActionInsertFactColumnDetails\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"value\":").append(org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52.marshall(a0.getValue(), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"factField\":").append(java_lang_String.marshall(a0.getFactField(), a1)).append(",").append("\"columnHeader\":").append(java_lang_String.marshall(a0.getColumnHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 == null) {
      org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 = Marshalling.getMarshaller(DTCellValue52.class);
    }
  }
}