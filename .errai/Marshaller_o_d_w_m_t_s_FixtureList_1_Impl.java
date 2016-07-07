package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import org.drools.workbench.models.testscenarios.shared.Fixture;
import org.drools.workbench.models.testscenarios.shared.FixtureList;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_FixtureList_1_Impl implements GeneratedMarshaller<FixtureList> {
  private FixtureList[] EMPTY_ARRAY = new FixtureList[0];
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public FixtureList[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ArrayList _1874632065__$1114099497_list(FixtureList instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.FixtureList::list;
  }-*/;

  private native static void _1874632065__$1114099497_list(FixtureList instance, ArrayList<Fixture> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.FixtureList::list = value;
  }-*/;

  public FixtureList demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FixtureList.class, objId);
    }
    FixtureList entity = new FixtureList();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("list")) && (!obj.get("list").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.Fixture");
      _1874632065__$1114099497_list(entity, java_util_ArrayList.demarshall(obj.get("list"), a1));
    }
    return entity;
  }

  public String marshall(FixtureList a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.FixtureList\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"list\":").append(java_util_ArrayList.marshall(_1874632065__$1114099497_list(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}