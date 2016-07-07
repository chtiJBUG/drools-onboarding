package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactCol52;
import org.drools.workbench.models.guided.dtable.shared.model.DTCellValue52;
import org.drools.workbench.models.guided.dtable.shared.model.DTColumnConfig52;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_ActionInsertFactCol52_1_Impl implements GeneratedMarshaller<ActionInsertFactCol52> {
  private ActionInsertFactCol52[] EMPTY_ARRAY = new ActionInsertFactCol52[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<DTCellValue52> org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 = null;
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public ActionInsertFactCol52[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1290599432__64711720_isInsertLogical(ActionInsertFactCol52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactCol52::isInsertLogical;
  }-*/;

  private native static void _$1290599432__64711720_isInsertLogical(ActionInsertFactCol52 instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactCol52::isInsertLogical = value;
  }-*/;

  private native static DTCellValue52 _$1926208785__$1211268558_typedDefaultValue(DTColumnConfig52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTColumnConfig52::typedDefaultValue;
  }-*/;

  private native static void _$1926208785__$1211268558_typedDefaultValue(DTColumnConfig52 instance, DTCellValue52 value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTColumnConfig52::typedDefaultValue = value;
  }-*/;

  public ActionInsertFactCol52 demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionInsertFactCol52.class, objId);
    }
    ActionInsertFactCol52 entity = new ActionInsertFactCol52();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("boundName")) && (!obj.get("boundName").isNull())) {
      entity.setBoundName(java_lang_String.demarshall(obj.get("boundName"), a1));
    }
    if ((obj.containsKey("factField")) && (!obj.get("factField").isNull())) {
      entity.setFactField(java_lang_String.demarshall(obj.get("factField"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("valueList")) && (!obj.get("valueList").isNull())) {
      entity.setValueList(java_lang_String.demarshall(obj.get("valueList"), a1));
    }
    if ((obj.containsKey("isInsertLogical")) && (!obj.get("isInsertLogical").isNull())) {
      _$1290599432__64711720_isInsertLogical(entity, java_lang_Boolean.demarshall(obj.get("isInsertLogical"), a1));
    }
    entity.defaultValue = java_lang_String.demarshall(obj.get("defaultValue"), a1);
    if ((obj.containsKey("typedDefaultValue")) && (!obj.get("typedDefaultValue").isNull())) {
      _$1926208785__$1211268558_typedDefaultValue(entity, org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52.demarshall(obj.get("typedDefaultValue"), a1));
    }
    if ((obj.containsKey("hideColumn")) && (!obj.get("hideColumn").isNull())) {
      entity.setHideColumn(java_lang_Boolean.demarshall(obj.get("hideColumn"), a1));
    }
    if ((obj.containsKey("width")) && (!obj.get("width").isNull())) {
      entity.setWidth(java_lang_Integer.demarshall(obj.get("width"), a1));
    }
    if ((obj.containsKey("header")) && (!obj.get("header").isNull())) {
      entity.setHeader(java_lang_String.demarshall(obj.get("header"), a1));
    }
    return entity;
  }

  private native static boolean _$1926208785__64711720_hideColumn(DTColumnConfig52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.DTColumnConfig52::hideColumn;
  }-*/;

  private native static void _$1926208785__64711720_hideColumn(DTColumnConfig52 instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.DTColumnConfig52::hideColumn = value;
  }-*/;

  public String marshall(ActionInsertFactCol52 a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactCol52\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"factField\":").append(java_lang_String.marshall(a0.getFactField(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"valueList\":").append(java_lang_String.marshall(a0.getValueList(), a1)).append(",").append("\"isInsertLogical\":").append(java_lang_Boolean.marshall(_$1290599432__64711720_isInsertLogical(a0), a1)).append(",").append("\"defaultValue\":").append(java_lang_String.marshall(a0.defaultValue, a1)).append(",").append("\"typedDefaultValue\":").append(org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52.marshall(_$1926208785__$1211268558_typedDefaultValue(a0), a1)).append(",").append("\"hideColumn\":").append(java_lang_Boolean.marshall(_$1926208785__64711720_hideColumn(a0), a1)).append(",").append("\"width\":").append(java_lang_Integer.marshall(a0.getWidth(), a1)).append(",").append("\"header\":").append(java_lang_String.marshall(a0.getHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 == null) {
      org_drools_workbench_models_guided_dtable_shared_model_DTCellValue52 = Marshalling.getMarshaller(DTCellValue52.class);
    }
  }
}