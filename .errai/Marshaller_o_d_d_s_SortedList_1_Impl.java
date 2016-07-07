package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.dashbuilder.dataset.sort.SortedList;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_s_SortedList_1_Impl implements GeneratedMarshaller<SortedList> {
  private SortedList[] EMPTY_ARRAY = new SortedList[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public SortedList[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _942551238__65821278_rows(SortedList instance) /*-{
    return instance.@org.dashbuilder.dataset.sort.SortedList::rows;
  }-*/;

  private native static void _942551238__65821278_rows(SortedList instance, List<Integer> value) /*-{
    instance.@org.dashbuilder.dataset.sort.SortedList::rows = value;
  }-*/;

  private native static List _942551238__65821278_realList(SortedList instance) /*-{
    return instance.@org.dashbuilder.dataset.sort.SortedList::realList;
  }-*/;

  private native static void _942551238__65821278_realList(SortedList instance, List value) /*-{
    instance.@org.dashbuilder.dataset.sort.SortedList::realList = value;
  }-*/;

  public SortedList demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SortedList.class, objId);
    }
    SortedList entity = new SortedList();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("rows")) && (!obj.get("rows").isNull())) {
      a1.setAssumedElementType("java.lang.Integer");
      _942551238__65821278_rows(entity, java_util_List.demarshall(obj.get("rows"), a1));
    }
    if ((obj.containsKey("realList")) && (!obj.get("realList").isNull())) {
      _942551238__65821278_realList(entity, java_util_List.demarshall(obj.get("realList"), a1));
    }
    return entity;
  }

  public String marshall(SortedList a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.dashbuilder.dataset.sort.SortedList\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"rows\":").append(java_util_List.marshall(_942551238__65821278_rows(a0), a1)).append(",").append("\"realList\":").append(java_util_List.marshall(_942551238__65821278_realList(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}