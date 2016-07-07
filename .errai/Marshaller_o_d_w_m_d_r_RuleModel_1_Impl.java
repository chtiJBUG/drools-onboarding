package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.datamodel.rule.IAction;
import org.drools.workbench.models.datamodel.rule.IPattern;
import org.drools.workbench.models.datamodel.rule.RuleAttribute;
import org.drools.workbench.models.datamodel.rule.RuleMetadata;
import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_r_RuleModel_1_Impl implements GeneratedMarshaller<RuleModel> {
  private RuleModel[] EMPTY_ARRAY = new RuleModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<RuleAttribute[]> arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1 = null;
  private Marshaller<RuleMetadata[]> arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1 = null;
  private Marshaller<IPattern[]> arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1 = null;
  private Marshaller<IAction[]> arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1 = null;
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1 implements GeneratedMarshaller { }
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1 implements GeneratedMarshaller { }
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1 implements GeneratedMarshaller { }
  abstract class Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1 implements GeneratedMarshaller { }
  public RuleModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _$1288338448__64711720_isNegated(RuleModel instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.RuleModel::isNegated;
  }-*/;

  private native static void _$1288338448__64711720_isNegated(RuleModel instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.RuleModel::isNegated = value;
  }-*/;

  public RuleModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleModel.class, objId);
    }
    RuleModel entity = new RuleModel();
    a1.recordObject(objId, entity);
    entity.name = java_lang_String.demarshall(obj.get("name"), a1);
    entity.parentName = java_lang_String.demarshall(obj.get("parentName"), a1);
    entity.modelVersion = java_lang_String.demarshall(obj.get("modelVersion"), a1);
    entity.attributes = arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1.demarshall(obj.get("attributes"), a1);
    entity.metadataList = arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1.demarshall(obj.get("metadataList"), a1);
    entity.lhs = arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1.demarshall(obj.get("lhs"), a1);
    entity.rhs = arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1.demarshall(obj.get("rhs"), a1);
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("isNegated")) && (!obj.get("isNegated").isNull())) {
      _$1288338448__64711720_isNegated(entity, java_lang_Boolean.demarshall(obj.get("isNegated"), a1));
    }
    return entity;
  }

  public String marshall(RuleModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.RuleModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.name, a1)).append(",").append("\"parentName\":").append(java_lang_String.marshall(a0.parentName, a1)).append(",").append("\"modelVersion\":").append(java_lang_String.marshall(a0.modelVersion, a1)).append(",").append("\"attributes\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1.marshall(a0.attributes, a1)).append(",").append("\"metadataList\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1.marshall(a0.metadataList, a1)).append(",").append("\"lhs\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1.marshall(a0.lhs, a1)).append(",").append("\"rhs\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1.marshall(a0.rhs, a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"isNegated\":").append(java_lang_Boolean.marshall(_$1288338448__64711720_isNegated(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1 = Marshalling.getMarshaller(RuleAttribute[].class, new DeferredMarshallerCreationCallback<RuleAttribute[]>() {
        public Marshaller<RuleAttribute[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1.class), RuleAttribute[].class);
        }
      });
    }
    if (arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1 = Marshalling.getMarshaller(RuleMetadata[].class, new DeferredMarshallerCreationCallback<RuleMetadata[]>() {
        public Marshaller<RuleMetadata[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1.class), RuleMetadata[].class);
        }
      });
    }
    if (arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1 = Marshalling.getMarshaller(IPattern[].class, new DeferredMarshallerCreationCallback<IPattern[]>() {
        public Marshaller<IPattern[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1.class), IPattern[].class);
        }
      });
    }
    if (arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1 == null) {
      arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1 = Marshalling.getMarshaller(IAction[].class, new DeferredMarshallerCreationCallback<IAction[]>() {
        public Marshaller<IAction[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1.class), IAction[].class);
        }
      });
    }
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
  }
}