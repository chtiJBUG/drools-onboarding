package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.rule.CEPWindow;
import org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactFieldsPattern;
import org.drools.workbench.models.guided.dtable.shared.model.ConditionCol52;
import org.drools.workbench.models.guided.dtable.shared.model.Pattern52;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_m_ActionInsertFactFieldsPattern_1_Impl implements GeneratedMarshaller<ActionInsertFactFieldsPattern> {
  private ActionInsertFactFieldsPattern[] EMPTY_ARRAY = new ActionInsertFactFieldsPattern[0];
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<CEPWindow> org_drools_workbench_models_datamodel_rule_CEPWindow = null;
  public ActionInsertFactFieldsPattern[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _975668082__64711720_isInsertedLogically(ActionInsertFactFieldsPattern instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactFieldsPattern::isInsertedLogically;
  }-*/;

  private native static void _975668082__64711720_isInsertedLogically(ActionInsertFactFieldsPattern instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactFieldsPattern::isInsertedLogically = value;
  }-*/;

  private native static boolean _465111523__64711720_isNegated(Pattern52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.Pattern52::isNegated;
  }-*/;

  private native static void _465111523__64711720_isNegated(Pattern52 instance, boolean value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.Pattern52::isNegated = value;
  }-*/;

  private native static List _465111523__65821278_conditions(Pattern52 instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.Pattern52::conditions;
  }-*/;

  private native static void _465111523__65821278_conditions(Pattern52 instance, List<ConditionCol52> value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.Pattern52::conditions = value;
  }-*/;

  public ActionInsertFactFieldsPattern demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionInsertFactFieldsPattern.class, objId);
    }
    ActionInsertFactFieldsPattern entity = new ActionInsertFactFieldsPattern();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("isInsertedLogically")) && (!obj.get("isInsertedLogically").isNull())) {
      _975668082__64711720_isInsertedLogically(entity, java_lang_Boolean.demarshall(obj.get("isInsertedLogically"), a1));
    }
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("boundName")) && (!obj.get("boundName").isNull())) {
      entity.setBoundName(java_lang_String.demarshall(obj.get("boundName"), a1));
    }
    if ((obj.containsKey("isNegated")) && (!obj.get("isNegated").isNull())) {
      _465111523__64711720_isNegated(entity, java_lang_Boolean.demarshall(obj.get("isNegated"), a1));
    }
    if ((obj.containsKey("conditions")) && (!obj.get("conditions").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.model.ConditionCol52");
      _465111523__65821278_conditions(entity, java_util_List.demarshall(obj.get("conditions"), a1));
    }
    if ((obj.containsKey("window")) && (!obj.get("window").isNull())) {
      entity.setWindow(org_drools_workbench_models_datamodel_rule_CEPWindow.demarshall(obj.get("window"), a1));
    }
    if ((obj.containsKey("entryPointName")) && (!obj.get("entryPointName").isNull())) {
      entity.setEntryPointName(java_lang_String.demarshall(obj.get("entryPointName"), a1));
    }
    return entity;
  }

  public String marshall(ActionInsertFactFieldsPattern a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.ActionInsertFactFieldsPattern\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"isInsertedLogically\":").append(java_lang_Boolean.marshall(_975668082__64711720_isInsertedLogically(a0), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"isNegated\":").append(java_lang_Boolean.marshall(_465111523__64711720_isNegated(a0), a1)).append(",").append("\"conditions\":").append(java_util_List.marshall(_465111523__65821278_conditions(a0), a1)).append(",").append("\"window\":").append(org_drools_workbench_models_datamodel_rule_CEPWindow.marshall(a0.getWindow(), a1)).append(",").append("\"entryPointName\":").append(java_lang_String.marshall(a0.getEntryPointName(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_CEPWindow == null) {
      org_drools_workbench_models_datamodel_rule_CEPWindow = Marshalling.getMarshaller(CEPWindow.class);
    }
  }
}