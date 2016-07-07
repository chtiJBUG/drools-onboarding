package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.rule.CompositeFieldConstraint;
import org.drools.workbench.models.datamodel.rule.FieldConstraint;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_CompositeFieldConstraint_1_Impl implements GeneratedMarshaller<CompositeFieldConstraint> {
  private CompositeFieldConstraint[] EMPTY_ARRAY = new CompositeFieldConstraint[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<FieldConstraint[]> arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1 = null;
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1 implements GeneratedMarshaller { }
  public CompositeFieldConstraint[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CompositeFieldConstraint demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CompositeFieldConstraint.class, objId);
    }
    CompositeFieldConstraint entity = new CompositeFieldConstraint();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("compositeJunctionType")) && (!obj.get("compositeJunctionType").isNull())) {
      entity.setCompositeJunctionType(java_lang_String.demarshall(obj.get("compositeJunctionType"), a1));
    }
    if ((obj.containsKey("constraints")) && (!obj.get("constraints").isNull())) {
      entity.setConstraints(arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1.demarshall(obj.get("constraints"), a1));
    }
    return entity;
  }

  public String marshall(CompositeFieldConstraint a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.CompositeFieldConstraint\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"compositeJunctionType\":").append(java_lang_String.marshall(a0.getCompositeJunctionType(), a1)).append(",").append("\"constraints\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1.marshall(a0.getConstraints(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1 = Marshalling.getMarshaller(FieldConstraint[].class, new DeferredMarshallerCreationCallback<FieldConstraint[]>() {
        public Marshaller<FieldConstraint[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_FieldConstraint_D1.class), FieldConstraint[].class);
        }
      });
    }
  }
}