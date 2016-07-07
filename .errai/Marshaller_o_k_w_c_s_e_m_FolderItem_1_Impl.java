package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.explorer.model.FolderItem;
import org.kie.workbench.common.screens.explorer.model.FolderItemOperation;
import org.kie.workbench.common.screens.explorer.model.FolderItemType;

public class Marshaller_o_k_w_c_s_e_m_FolderItem_1_Impl implements GeneratedMarshaller<FolderItem> {
  private FolderItem[] EMPTY_ARRAY = new FolderItem[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<FolderItemType> org_kie_workbench_common_screens_explorer_model_FolderItemType = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public FolderItem[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _933498283__1195259493_itemName(FolderItem instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::itemName;
  }-*/;

  private native static void _933498283__1195259493_itemName(FolderItem instance, String value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::itemName = value;
  }-*/;

  private native static boolean _933498283__64711720_lockedItems(FolderItem instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::lockedItems;
  }-*/;

  private native static void _933498283__64711720_lockedItems(FolderItem instance, boolean value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::lockedItems = value;
  }-*/;

  private native static List _933498283__65821278_restrictedOperations(FolderItem instance) /*-{
    return instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::restrictedOperations;
  }-*/;

  private native static void _933498283__65821278_restrictedOperations(FolderItem instance, List<FolderItemOperation> value) /*-{
    instance.@org.kie.workbench.common.screens.explorer.model.FolderItem::restrictedOperations = value;
  }-*/;

  public FolderItem demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FolderItem.class, objId);
    }
    final Object c0 = ((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("item"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("itemName"), a1);
    final FolderItemType c2 = obj.get("type").isObject() != null ? Enum.valueOf(FolderItemType.class, obj.get("type").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("type").isString() != null ? Enum.valueOf(FolderItemType.class, obj.get("type").isString().stringValue()) : null;
    final String c4 = java_lang_String.demarshall(obj.get("lockedBy"), a1);
    final Boolean c3 = java_lang_Boolean.demarshall(obj.get("lockedItems"), a1);
    a1.setAssumedElementType("java.lang.String");
    final List c5 = java_util_List.demarshall(obj.get("tags"), a1);
    a1.setAssumedElementType("org.kie.workbench.common.screens.explorer.model.FolderItemOperation");
    final List c6 = java_util_List.demarshall(obj.get("restrictedOperations"), a1);
    FolderItem entity = new FolderItem(c0, c1, c2, c3, c4, c5, c6);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("itemName")) && (!obj.get("itemName").isNull())) {
      _933498283__1195259493_itemName(entity, java_lang_String.demarshall(obj.get("itemName"), a1));
    }
    if ((obj.containsKey("lockedItems")) && (!obj.get("lockedItems").isNull())) {
      _933498283__64711720_lockedItems(entity, java_lang_Boolean.demarshall(obj.get("lockedItems"), a1));
    }
    if ((obj.containsKey("restrictedOperations")) && (!obj.get("restrictedOperations").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.explorer.model.FolderItemOperation");
      _933498283__65821278_restrictedOperations(entity, java_util_List.demarshall(obj.get("restrictedOperations"), a1));
    }
    return entity;
  }

  public String marshall(FolderItem a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.FolderItem\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"item\":").append(java_lang_Object.marshall(a0.getItem(), a1)).append(",").append("\"itemName\":").append(java_lang_String.marshall(_933498283__1195259493_itemName(a0), a1)).append(",").append("\"type\":").append(a0.getType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.screens.explorer.model.FolderItemType\",\"^EnumStringValue\":\"").append(a0.getType().name()).append("\"}") : "null").append(",").append("\"lockedBy\":").append(java_lang_String.marshall(a0.getLockedBy(), a1)).append(",").append("\"lockedItems\":").append(java_lang_Boolean.marshall(_933498283__64711720_lockedItems(a0), a1)).append(",").append("\"tags\":").append(java_util_List.marshall(a0.getTags(), a1)).append(",").append("\"restrictedOperations\":").append(java_util_List.marshall(_933498283__65821278_restrictedOperations(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_explorer_model_FolderItemType == null) {
      org_kie_workbench_common_screens_explorer_model_FolderItemType = Marshalling.getMarshaller(FolderItemType.class);
    }
  }
}