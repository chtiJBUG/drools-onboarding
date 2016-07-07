package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.explorer.model.FolderItem;
import org.kie.workbench.common.screens.explorer.model.FolderListing;

public class Marshaller_o_k_w_c_s_e_m_FolderListing_1_Impl implements GeneratedMarshaller<FolderListing> {
  private FolderListing[] EMPTY_ARRAY = new FolderListing[0];
  private Marshaller<FolderItem> org_kie_workbench_common_screens_explorer_model_FolderItem = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public FolderListing[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static FolderItem _$2000027412__933498283_item(FolderListing instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::item;
  }-*/;

  private native static void _$2000027412__933498283_item(FolderListing instance, FolderItem value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::item = value;
  }-*/;

  private native static List _$2000027412__65821278_content(FolderListing instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::content;
  }-*/;

  private native static void _$2000027412__65821278_content(FolderListing instance, List<FolderItem> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::content = value;
  }-*/;

  private native static List _$2000027412__65821278_segments(FolderListing instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::segments;
  }-*/;

  private native static void _$2000027412__65821278_segments(FolderListing instance, List<FolderItem> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderListing::segments = value;
  }-*/;

  public FolderListing demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FolderListing.class, objId);
    }
    FolderListing entity = new FolderListing();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("item")) && (!obj.get("item").isNull())) {
      _$2000027412__933498283_item(entity, org_kie_workbench_common_screens_explorer_model_FolderItem.demarshall(obj.get("item"), a1));
    }
    if ((obj.containsKey("content")) && (!obj.get("content").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.explorer.model.FolderItem");
      _$2000027412__65821278_content(entity, java_util_List.demarshall(obj.get("content"), a1));
    }
    if ((obj.containsKey("segments")) && (!obj.get("segments").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.explorer.model.FolderItem");
      _$2000027412__65821278_segments(entity, java_util_List.demarshall(obj.get("segments"), a1));
    }
    return entity;
  }

  public String marshall(FolderListing a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.FolderListing\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"item\":").append(org_kie_workbench_common_screens_explorer_model_FolderItem.marshall(a0.getItem(), a1)).append(",").append("\"content\":").append(java_util_List.marshall(a0.getContent(), a1)).append(",").append("\"segments\":").append(java_util_List.marshall(a0.getSegments(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_explorer_model_FolderItem == null) {
      org_kie_workbench_common_screens_explorer_model_FolderItem = Marshalling.getMarshaller(FolderItem.class);
    }
  }
}