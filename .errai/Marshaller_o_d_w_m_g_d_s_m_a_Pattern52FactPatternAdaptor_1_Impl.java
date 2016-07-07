package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.CEPWindow;
import org.drools.workbench.models.datamodel.rule.CompositeFieldConstraint;
import org.drools.workbench.models.datamodel.rule.FactPattern;
import org.drools.workbench.models.guided.dtable.shared.model.Pattern52;
import org.drools.workbench.models.guided.dtable.shared.model.adaptors.Pattern52FactPatternAdaptor;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_a_Pattern52FactPatternAdaptor_1_Impl implements GeneratedMarshaller<Pattern52FactPatternAdaptor> {
  private Pattern52FactPatternAdaptor[] EMPTY_ARRAY = new Pattern52FactPatternAdaptor[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<CompositeFieldConstraint> org_drools_workbench_models_datamodel_rule_CompositeFieldConstraint = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<CEPWindow> org_drools_workbench_models_datamodel_rule_CEPWindow = null;
  public Pattern52FactPatternAdaptor[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Pattern52 _1662022232__465111523_pattern(Pattern52FactPatternAdaptor instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.model.adaptors.Pattern52FactPatternAdaptor::pattern;
  }-*/;

  private native static void _1662022232__465111523_pattern(Pattern52FactPatternAdaptor instance, Pattern52 value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.model.adaptors.Pattern52FactPatternAdaptor::pattern = value;
  }-*/;

  private native static CompositeFieldConstraint _317710631__212640813_constraintList(FactPattern instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.FactPattern::constraintList;
  }-*/;

  private native static void _317710631__212640813_constraintList(FactPattern instance, CompositeFieldConstraint value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.FactPattern::constraintList = value;
  }-*/;

  private native static boolean _317710631__64711720_isNegated(FactPattern instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.FactPattern::isNegated;
  }-*/;

  private native static void _317710631__64711720_isNegated(FactPattern instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.FactPattern::isNegated = value;
  }-*/;

  public Pattern52FactPatternAdaptor demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Pattern52FactPatternAdaptor.class, objId);
    }
    Pattern52FactPatternAdaptor entity = new Pattern52FactPatternAdaptor();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pattern")) && (!obj.get("pattern").isNull())) {
      _1662022232__465111523_pattern(entity, (Pattern52) ((ObjectMarshaller) java_lang_Object).demarshall(Pattern52.class, obj.get("pattern"), a1));
    }
    if ((obj.containsKey("constraintList")) && (!obj.get("constraintList").isNull())) {
      _317710631__212640813_constraintList(entity, org_drools_workbench_models_datamodel_rule_CompositeFieldConstraint.demarshall(obj.get("constraintList"), a1));
    }
    if ((obj.containsKey("factType")) && (!obj.get("factType").isNull())) {
      entity.setFactType(java_lang_String.demarshall(obj.get("factType"), a1));
    }
    if ((obj.containsKey("boundName")) && (!obj.get("boundName").isNull())) {
      entity.setBoundName(java_lang_String.demarshall(obj.get("boundName"), a1));
    }
    if ((obj.containsKey("isNegated")) && (!obj.get("isNegated").isNull())) {
      _317710631__64711720_isNegated(entity, java_lang_Boolean.demarshall(obj.get("isNegated"), a1));
    }
    if ((obj.containsKey("window")) && (!obj.get("window").isNull())) {
      entity.setWindow(org_drools_workbench_models_datamodel_rule_CEPWindow.demarshall(obj.get("window"), a1));
    }
    return entity;
  }

  public String marshall(Pattern52FactPatternAdaptor a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.model.adaptors.Pattern52FactPatternAdaptor\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pattern\":").append(java_lang_Object.marshall(_1662022232__465111523_pattern(a0), a1)).append(",").append("\"constraintList\":").append(org_drools_workbench_models_datamodel_rule_CompositeFieldConstraint.marshall(a0.getConstraintList(), a1)).append(",").append("\"factType\":").append(java_lang_String.marshall(a0.getFactType(), a1)).append(",").append("\"boundName\":").append(java_lang_String.marshall(a0.getBoundName(), a1)).append(",").append("\"isNegated\":").append(java_lang_Boolean.marshall(_317710631__64711720_isNegated(a0), a1)).append(",").append("\"window\":").append(org_drools_workbench_models_datamodel_rule_CEPWindow.marshall(a0.getWindow(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_CompositeFieldConstraint == null) {
      org_drools_workbench_models_datamodel_rule_CompositeFieldConstraint = Marshalling.getMarshaller(CompositeFieldConstraint.class);
    }
    if (org_drools_workbench_models_datamodel_rule_CEPWindow == null) {
      org_drools_workbench_models_datamodel_rule_CEPWindow = Marshalling.getMarshaller(CEPWindow.class);
    }
  }
}