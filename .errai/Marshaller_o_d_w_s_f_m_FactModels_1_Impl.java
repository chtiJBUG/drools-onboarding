package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.screens.factmodel.model.FactMetaModel;
import org.drools.workbench.screens.factmodel.model.FactModels;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_f_m_FactModels_1_Impl implements GeneratedMarshaller<FactModels> {
  private FactModels[] EMPTY_ARRAY = new FactModels[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public FactModels[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _745397041__65821278_models(FactModels instance) /*-{
    return instance.@org.drools.workbench.screens.factmodel.model.FactModels::models;
  }-*/;

  private native static void _745397041__65821278_models(FactModels instance, List<FactMetaModel> value) /*-{
    instance.@org.drools.workbench.screens.factmodel.model.FactModels::models = value;
  }-*/;

  public FactModels demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FactModels.class, objId);
    }
    FactModels entity = new FactModels();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("models")) && (!obj.get("models").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.screens.factmodel.model.FactMetaModel");
      _745397041__65821278_models(entity, java_util_List.demarshall(obj.get("models"), a1));
    }
    return entity;
  }

  public String marshall(FactModels a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.factmodel.model.FactModels\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"models\":").append(java_util_List.marshall(a0.getModels(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
  }
}