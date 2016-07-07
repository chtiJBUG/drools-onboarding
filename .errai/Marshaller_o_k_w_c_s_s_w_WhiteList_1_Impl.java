package org.jboss.errai.marshalling.client.api;

import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.whitelist.WhiteList;

public class Marshaller_o_k_w_c_s_s_w_WhiteList_1_Impl implements GeneratedMarshaller<WhiteList> {
  private WhiteList[] EMPTY_ARRAY = new WhiteList[0];
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  public WhiteList[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Set _$1358940796__$1383343454_whiteList(WhiteList instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.whitelist.WhiteList::whiteList;
  }-*/;

  private native static void _$1358940796__$1383343454_whiteList(WhiteList instance, Set<String> value) /*-{
    instance.@org.kie.workbench.common.services.shared.whitelist.WhiteList::whiteList = value;
  }-*/;

  public WhiteList demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WhiteList.class, objId);
    }
    WhiteList entity = new WhiteList();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("whiteList")) && (!obj.get("whiteList").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1358940796__$1383343454_whiteList(entity, java_util_Set.demarshall(obj.get("whiteList"), a1));
    }
    return entity;
  }

  public String marshall(WhiteList a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.whitelist.WhiteList\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"whiteList\":").append(java_util_Set.marshall(_$1358940796__$1383343454_whiteList(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}