package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataset.group.GroupStrategy;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_g_GroupStrategy_1_Impl implements GeneratedMarshaller<GroupStrategy> {
  private GroupStrategy[] EMPTY_ARRAY = new GroupStrategy[0];
  public GroupStrategy[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GroupStrategy demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    GroupStrategy entity = obj != null ? Enum.valueOf(GroupStrategy.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(GroupStrategy.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(GroupStrategy a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataset.group.GroupStrategy\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}