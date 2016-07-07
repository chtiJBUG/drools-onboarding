package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.List;
import java.util.Map;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.datamodel.rule.IAction;
import org.drools.workbench.models.datamodel.rule.IPattern;
import org.drools.workbench.models.datamodel.rule.RuleAttribute;
import org.drools.workbench.models.datamodel.rule.RuleMetadata;
import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.drools.workbench.models.guided.template.shared.TemplateModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_g_t_s_TemplateModel_1_Impl implements GeneratedMarshaller<TemplateModel> {
  private TemplateModel[] EMPTY_ARRAY = new TemplateModel[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
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
  public TemplateModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$772284102__$1383349348_table(TemplateModel instance) /*-{
    return instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::table;
  }-*/;

  private native static void _$772284102__$1383349348_table(TemplateModel instance, Map<String, List<String>> value) /*-{
    instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::table = value;
  }-*/;

  private native static int _$772284102__104431_rowsCount(TemplateModel instance) /*-{
    return instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::rowsCount;
  }-*/;

  private native static void _$772284102__104431_rowsCount(TemplateModel instance, int value) /*-{
    instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::rowsCount = value;
  }-*/;

  private native static boolean _$1288338448__64711720_isNegated(RuleModel instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.RuleModel::isNegated;
  }-*/;

  private native static void _$1288338448__64711720_isNegated(RuleModel instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.RuleModel::isNegated = value;
  }-*/;

  public TemplateModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TemplateModel.class, objId);
    }
    TemplateModel entity = new TemplateModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("table")) && (!obj.get("table").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.util.List");
      _$772284102__$1383349348_table(entity, java_util_Map.demarshall(obj.get("table"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("idCol")) && (!obj.get("idCol").isNull())) {
      entity.setIdCol(java_lang_Integer.demarshall(obj.get("idCol"), a1));
    }
    if ((obj.containsKey("rowsCount")) && (!obj.get("rowsCount").isNull())) {
      _$772284102__104431_rowsCount(entity, java_lang_Integer.demarshall(obj.get("rowsCount"), a1));
    }
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

  private native static int _$772284102__104431_idCol(TemplateModel instance) /*-{
    return instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::idCol;
  }-*/;

  private native static void _$772284102__104431_idCol(TemplateModel instance, int value) /*-{
    instance.@org.drools.workbench.models.guided.template.shared.TemplateModel::idCol = value;
  }-*/;

  public String marshall(TemplateModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.template.shared.TemplateModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"table\":").append(java_util_Map.marshall(a0.getTable(), a1)).append(",").append("\"idCol\":").append(java_lang_Integer.marshall(_$772284102__104431_idCol(a0), a1)).append(",").append("\"rowsCount\":").append(java_lang_Integer.marshall(a0.getRowsCount(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.name, a1)).append(",").append("\"parentName\":").append(java_lang_String.marshall(a0.parentName, a1)).append(",").append("\"modelVersion\":").append(java_lang_String.marshall(a0.modelVersion, a1)).append(",").append("\"attributes\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_RuleAttribute_D1.marshall(a0.attributes, a1)).append(",").append("\"metadataList\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_RuleMetadata_D1.marshall(a0.metadataList, a1)).append(",").append("\"lhs\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_IPattern_D1.marshall(a0.lhs, a1)).append(",").append("\"rhs\":").append(arrayOf_org_drools_workbench_models_datamodel_rule_IAction_D1.marshall(a0.rhs, a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"isNegated\":").append(java_lang_Boolean.marshall(_$1288338448__64711720_isNegated(a0), a1)).append("}").toString();
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