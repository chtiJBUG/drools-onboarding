package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree;
import org.drools.workbench.models.guided.dtree.shared.model.nodes.TypeNode;
import org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_g_d_s_m_GuidedDecisionTree_1_Impl implements GeneratedMarshaller<GuidedDecisionTree> {
  private GuidedDecisionTree[] EMPTY_ARRAY = new GuidedDecisionTree[0];
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public GuidedDecisionTree[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _2075966084__65821278_errors(GuidedDecisionTree instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree::errors;
  }-*/;

  private native static void _2075966084__65821278_errors(GuidedDecisionTree instance, List<GuidedDecisionTreeParserError> value) /*-{
    instance.@org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree::errors = value;
  }-*/;

  public GuidedDecisionTree demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GuidedDecisionTree.class, objId);
    }
    GuidedDecisionTree entity = new GuidedDecisionTree();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("treeName")) && (!obj.get("treeName").isNull())) {
      entity.setTreeName(java_lang_String.demarshall(obj.get("treeName"), a1));
    }
    if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
      entity.setRoot((TypeNode) ((ObjectMarshaller) java_lang_Object).demarshall(TypeNode.class, obj.get("root"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtree.shared.model.parser.GuidedDecisionTreeParserError");
      _2075966084__65821278_errors(entity, java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(GuidedDecisionTree a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"treeName\":").append(java_lang_String.marshall(a0.getTreeName(), a1)).append(",").append("\"root\":").append(java_lang_Object.marshall(a0.getRoot(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(_2075966084__65821278_errors(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
  }
}