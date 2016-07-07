package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.screens.workitems.model.WorkItemsModelContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_w_m_WorkItemsModelContent_1_Impl implements GeneratedMarshaller<WorkItemsModelContent> {
  private WorkItemsModelContent[] EMPTY_ARRAY = new WorkItemsModelContent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public WorkItemsModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _604132310__1195259493_definition(WorkItemsModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::definition;
  }-*/;

  private native static void _604132310__1195259493_definition(WorkItemsModelContent instance, String value) /*-{
    instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::definition = value;
  }-*/;

  private native static List _604132310__65821278_workItemImages(WorkItemsModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::workItemImages;
  }-*/;

  private native static void _604132310__65821278_workItemImages(WorkItemsModelContent instance, List<String> value) /*-{
    instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::workItemImages = value;
  }-*/;

  private native static Overview _604132310__1909091292_overview(WorkItemsModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::overview;
  }-*/;

  private native static void _604132310__1909091292_overview(WorkItemsModelContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.workitems.model.WorkItemsModelContent::overview = value;
  }-*/;

  public WorkItemsModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WorkItemsModelContent.class, objId);
    }
    WorkItemsModelContent entity = new WorkItemsModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("definition")) && (!obj.get("definition").isNull())) {
      _604132310__1195259493_definition(entity, java_lang_String.demarshall(obj.get("definition"), a1));
    }
    if ((obj.containsKey("workItemImages")) && (!obj.get("workItemImages").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _604132310__65821278_workItemImages(entity, java_util_List.demarshall(obj.get("workItemImages"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _604132310__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(WorkItemsModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.workitems.model.WorkItemsModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"definition\":").append(java_lang_String.marshall(a0.getDefinition(), a1)).append(",").append("\"workItemImages\":").append(java_util_List.marshall(a0.getWorkItemImages(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}