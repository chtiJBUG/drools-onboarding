package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.enums.model.EnumModel;
import org.drools.workbench.screens.enums.model.EnumModelContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_e_m_EnumModelContent_1_Impl implements GeneratedMarshaller<EnumModelContent> {
  private EnumModelContent[] EMPTY_ARRAY = new EnumModelContent[0];
  private Marshaller<EnumModel> org_drools_workbench_screens_enums_model_EnumModel = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public EnumModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static EnumModel _$346837193__1674083042_model(EnumModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.enums.model.EnumModelContent::model;
  }-*/;

  private native static void _$346837193__1674083042_model(EnumModelContent instance, EnumModel value) /*-{
    instance.@org.drools.workbench.screens.enums.model.EnumModelContent::model = value;
  }-*/;

  private native static Overview _$346837193__1909091292_overview(EnumModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.enums.model.EnumModelContent::overview;
  }-*/;

  private native static void _$346837193__1909091292_overview(EnumModelContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.enums.model.EnumModelContent::overview = value;
  }-*/;

  public EnumModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EnumModelContent.class, objId);
    }
    EnumModelContent entity = new EnumModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _$346837193__1674083042_model(entity, org_drools_workbench_screens_enums_model_EnumModel.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$346837193__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(EnumModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.enums.model.EnumModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(org_drools_workbench_screens_enums_model_EnumModel.marshall(a0.getModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_screens_enums_model_EnumModel == null) {
      org_drools_workbench_screens_enums_model_EnumModel = Marshalling.getMarshaller(EnumModel.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}