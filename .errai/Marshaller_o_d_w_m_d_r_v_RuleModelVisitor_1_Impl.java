package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.rule.IFactPattern;
import org.drools.workbench.models.datamodel.rule.InterpolationVariable;
import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_r_v_RuleModelVisitor_1_Impl implements GeneratedMarshaller<RuleModelVisitor> {
  private RuleModelVisitor[] EMPTY_ARRAY = new RuleModelVisitor[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public RuleModelVisitor[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static IFactPattern _1363439565__$455145960_factPattern(RuleModelVisitor instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::factPattern;
  }-*/;

  private native static void _1363439565__$455145960_factPattern(RuleModelVisitor instance, IFactPattern value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::factPattern = value;
  }-*/;

  private native static RuleModel _1363439565__$1288338448_model(RuleModelVisitor instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::model;
  }-*/;

  private native static void _1363439565__$1288338448_model(RuleModelVisitor instance, RuleModel value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::model = value;
  }-*/;

  private native static Map _1363439565__$1383349348_vars(RuleModelVisitor instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::vars;
  }-*/;

  private native static void _1363439565__$1383349348_vars(RuleModelVisitor instance, Map<InterpolationVariable, Integer> value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor::vars = value;
  }-*/;

  public RuleModelVisitor demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleModelVisitor.class, objId);
    }
    RuleModelVisitor entity = new RuleModelVisitor();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("factPattern")) && (!obj.get("factPattern").isNull())) {
      _1363439565__$455145960_factPattern(entity, (IFactPattern) ((ObjectMarshaller) java_lang_Object).demarshall(IFactPattern.class, obj.get("factPattern"), a1));
    }
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _1363439565__$1288338448_model(entity, (RuleModel) ((ObjectMarshaller) java_lang_Object).demarshall(RuleModel.class, obj.get("model"), a1));
    }
    if ((obj.containsKey("vars")) && (!obj.get("vars").isNull())) {
      a1.setAssumedMapKeyType("org.drools.workbench.models.datamodel.rule.InterpolationVariable");
      a1.setAssumedMapValueType("java.lang.Integer");
      _1363439565__$1383349348_vars(entity, java_util_Map.demarshall(obj.get("vars"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(RuleModelVisitor a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.visitors.RuleModelVisitor\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"factPattern\":").append(java_lang_Object.marshall(_1363439565__$455145960_factPattern(a0), a1)).append(",").append("\"model\":").append(java_lang_Object.marshall(_1363439565__$1288338448_model(a0), a1)).append(",").append("\"vars\":").append(java_util_Map.marshall(_1363439565__$1383349348_vars(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}