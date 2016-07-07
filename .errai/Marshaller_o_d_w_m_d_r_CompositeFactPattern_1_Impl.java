package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.CompositeFactPattern;
import org.drools.workbench.models.datamodel.rule.IFactPattern;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_CompositeFactPattern_1_Impl implements GeneratedMarshaller<CompositeFactPattern> {
  private CompositeFactPattern[] EMPTY_ARRAY = new CompositeFactPattern[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<IFactPattern[]> arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1 implements GeneratedMarshaller { }
  public CompositeFactPattern[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static IFactPattern[] _203139130__$147086988_patterns(CompositeFactPattern instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.CompositeFactPattern::patterns;
  }-*/;

  private native static void _203139130__$147086988_patterns(CompositeFactPattern instance, IFactPattern[] value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.CompositeFactPattern::patterns = value;
  }-*/;

  public CompositeFactPattern demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CompositeFactPattern.class, objId);
    }
    CompositeFactPattern entity = new CompositeFactPattern();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("patterns")) && (!obj.get("patterns").isNull())) {
      _203139130__$147086988_patterns(entity, arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1.demarshall(obj.get("patterns"), a1));
    }
    return entity;
  }

  public String marshall(CompositeFactPattern a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.CompositeFactPattern\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"patterns\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1.marshall(a0.getPatterns(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1 = Marshalling.getMarshaller(IFactPattern[].class, new DeferredMarshallerCreationCallback<IFactPattern[]>() {
        public Marshaller<IFactPattern[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IFactPattern_D1.class), IFactPattern[].class);
        }
      });
    }
  }
}