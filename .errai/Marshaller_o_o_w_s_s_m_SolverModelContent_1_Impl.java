package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.optaplanner.workbench.screens.solver.model.SolverConfigModel;
import org.optaplanner.workbench.screens.solver.model.SolverModelContent;

public class Marshaller_o_o_w_s_s_m_SolverModelContent_1_Impl implements GeneratedMarshaller<SolverModelContent> {
  private SolverModelContent[] EMPTY_ARRAY = new SolverModelContent[0];
  private Marshaller<SolverConfigModel> org_optaplanner_workbench_screens_solver_model_SolverConfigModel = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public SolverModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static SolverConfigModel _1264915641__430978110_config(SolverModelContent instance) /*-{
    return instance.@org.optaplanner.workbench.screens.solver.model.SolverModelContent::config;
  }-*/;

  private native static void _1264915641__430978110_config(SolverModelContent instance, SolverConfigModel value) /*-{
    instance.@org.optaplanner.workbench.screens.solver.model.SolverModelContent::config = value;
  }-*/;

  private native static Overview _1264915641__1909091292_overview(SolverModelContent instance) /*-{
    return instance.@org.optaplanner.workbench.screens.solver.model.SolverModelContent::overview;
  }-*/;

  private native static void _1264915641__1909091292_overview(SolverModelContent instance, Overview value) /*-{
    instance.@org.optaplanner.workbench.screens.solver.model.SolverModelContent::overview = value;
  }-*/;

  public SolverModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SolverModelContent.class, objId);
    }
    SolverModelContent entity = new SolverModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("config")) && (!obj.get("config").isNull())) {
      _1264915641__430978110_config(entity, org_optaplanner_workbench_screens_solver_model_SolverConfigModel.demarshall(obj.get("config"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _1264915641__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(SolverModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.optaplanner.workbench.screens.solver.model.SolverModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"config\":").append(org_optaplanner_workbench_screens_solver_model_SolverConfigModel.marshall(a0.getConfig(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_optaplanner_workbench_screens_solver_model_SolverConfigModel == null) {
      org_optaplanner_workbench_screens_solver_model_SolverConfigModel = Marshalling.getMarshaller(SolverConfigModel.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}