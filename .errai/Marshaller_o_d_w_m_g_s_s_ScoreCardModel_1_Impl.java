package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_s_s_ScoreCardModel_1_Impl implements GeneratedMarshaller<ScoreCardModel> {
  private ScoreCardModel[] EMPTY_ARRAY = new ScoreCardModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Double> java_lang_Double = Marshalling.getMarshaller(Double.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  public ScoreCardModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ScoreCardModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ScoreCardModel.class, objId);
    }
    ScoreCardModel entity = new ScoreCardModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("baselineScore")) && (!obj.get("baselineScore").isNull())) {
      entity.setBaselineScore(java_lang_Double.demarshall(obj.get("baselineScore"), a1));
    }
    if ((obj.containsKey("initialScore")) && (!obj.get("initialScore").isNull())) {
      entity.setInitialScore(java_lang_Double.demarshall(obj.get("initialScore"), a1));
    }
    if ((obj.containsKey("useReasonCodes")) && (!obj.get("useReasonCodes").isNull())) {
      entity.setUseReasonCodes(java_lang_Boolean.demarshall(obj.get("useReasonCodes"), a1));
    }
    if ((obj.containsKey("factName")) && (!obj.get("factName").isNull())) {
      entity.setFactName(java_lang_String.demarshall(obj.get("factName"), a1));
    }
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      entity.setFieldName(java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("reasonCodesAlgorithm")) && (!obj.get("reasonCodesAlgorithm").isNull())) {
      entity.setReasonCodesAlgorithm(java_lang_String.demarshall(obj.get("reasonCodesAlgorithm"), a1));
    }
    if ((obj.containsKey("reasonCodeField")) && (!obj.get("reasonCodeField").isNull())) {
      entity.setReasonCodeField(java_lang_String.demarshall(obj.get("reasonCodeField"), a1));
    }
    if ((obj.containsKey("characteristics")) && (!obj.get("characteristics").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.scorecard.shared.Characteristic");
      entity.setCharacteristics(java_util_List.demarshall(obj.get("characteristics"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("agendaGroup")) && (!obj.get("agendaGroup").isNull())) {
      entity.setAgendaGroup(java_lang_String.demarshall(obj.get("agendaGroup"), a1));
    }
    if ((obj.containsKey("ruleFlowGroup")) && (!obj.get("ruleFlowGroup").isNull())) {
      entity.setRuleFlowGroup(java_lang_String.demarshall(obj.get("ruleFlowGroup"), a1));
    }
    return entity;
  }

  private native static boolean _$1952788636__64711720_useReasonCodes(ScoreCardModel instance) /*-{
    return instance.@org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel::useReasonCodes;
  }-*/;

  private native static void _$1952788636__64711720_useReasonCodes(ScoreCardModel instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel::useReasonCodes = value;
  }-*/;

  public String marshall(ScoreCardModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"baselineScore\":").append(java_lang_Double.marshall(a0.getBaselineScore(), a1)).append(",").append("\"initialScore\":").append(java_lang_Double.marshall(a0.getInitialScore(), a1)).append(",").append("\"useReasonCodes\":").append(java_lang_Boolean.marshall(_$1952788636__64711720_useReasonCodes(a0), a1)).append(",").append("\"factName\":").append(java_lang_String.marshall(a0.getFactName(), a1)).append(",").append("\"fieldName\":").append(java_lang_String.marshall(a0.getFieldName(), a1)).append(",").append("\"reasonCodesAlgorithm\":").append(java_lang_String.marshall(a0.getReasonCodesAlgorithm(), a1)).append(",").append("\"reasonCodeField\":").append(java_lang_String.marshall(a0.getReasonCodeField(), a1)).append(",").append("\"characteristics\":").append(java_util_List.marshall(a0.getCharacteristics(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"agendaGroup\":").append(java_lang_String.marshall(a0.getAgendaGroup(), a1)).append(",").append("\"ruleFlowGroup\":").append(java_lang_String.marshall(a0.getRuleFlowGroup(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
  }
}