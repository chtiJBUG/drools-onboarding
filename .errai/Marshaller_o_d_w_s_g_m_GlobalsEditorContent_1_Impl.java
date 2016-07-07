package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.screens.globals.model.GlobalsEditorContent;
import org.drools.workbench.screens.globals.model.GlobalsModel;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_g_m_GlobalsEditorContent_1_Impl implements GeneratedMarshaller<GlobalsEditorContent> {
  private GlobalsEditorContent[] EMPTY_ARRAY = new GlobalsEditorContent[0];
  private Marshaller<GlobalsModel> org_drools_workbench_screens_globals_model_GlobalsModel = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public GlobalsEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GlobalsModel _$111550236__1917930945_model(GlobalsEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::model;
  }-*/;

  private native static void _$111550236__1917930945_model(GlobalsEditorContent instance, GlobalsModel value) /*-{
    instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::model = value;
  }-*/;

  private native static List _$111550236__65821278_fullyQualifiedClassNames(GlobalsEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::fullyQualifiedClassNames;
  }-*/;

  private native static void _$111550236__65821278_fullyQualifiedClassNames(GlobalsEditorContent instance, List<String> value) /*-{
    instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::fullyQualifiedClassNames = value;
  }-*/;

  private native static Overview _$111550236__1909091292_overview(GlobalsEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::overview;
  }-*/;

  private native static void _$111550236__1909091292_overview(GlobalsEditorContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.globals.model.GlobalsEditorContent::overview = value;
  }-*/;

  public GlobalsEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GlobalsEditorContent.class, objId);
    }
    GlobalsEditorContent entity = new GlobalsEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _$111550236__1917930945_model(entity, org_drools_workbench_screens_globals_model_GlobalsModel.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("fullyQualifiedClassNames")) && (!obj.get("fullyQualifiedClassNames").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$111550236__65821278_fullyQualifiedClassNames(entity, java_util_List.demarshall(obj.get("fullyQualifiedClassNames"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$111550236__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(GlobalsEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.globals.model.GlobalsEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_screens_globals_model_GlobalsModel.marshall(a0.getModel(), a1)).append(",").append("\"fullyQualifiedClassNames\":").append(java_util_List.marshall(a0.getFullyQualifiedClassNames(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_screens_globals_model_GlobalsModel == null) {
      org_drools_workbench_screens_globals_model_GlobalsModel = Marshalling.getMarshaller(GlobalsModel.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}