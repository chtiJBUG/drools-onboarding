package org.jboss.errai.marshalling.client.api;

import java.util.HashMap;
import org.drools.workbench.models.testscenarios.shared.CallFixtureMap;
import org.drools.workbench.models.testscenarios.shared.FixtureList;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_CallFixtureMap_1_Impl implements GeneratedMarshaller<CallFixtureMap> {
  private CallFixtureMap[] EMPTY_ARRAY = new CallFixtureMap[0];
  private Marshaller<HashMap> java_util_HashMap = null;
  public CallFixtureMap[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static HashMap _$815507945__$1402722386_map(CallFixtureMap instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.CallFixtureMap::map;
  }-*/;

  private native static void _$815507945__$1402722386_map(CallFixtureMap instance, HashMap<String, FixtureList> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.CallFixtureMap::map = value;
  }-*/;

  public CallFixtureMap demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CallFixtureMap.class, objId);
    }
    CallFixtureMap entity = new CallFixtureMap();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("map")) && (!obj.get("map").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.drools.workbench.models.testscenarios.shared.FixtureList");
      _$815507945__$1402722386_map(entity, java_util_HashMap.demarshall(obj.get("map"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(CallFixtureMap a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.CallFixtureMap\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"map\":").append(java_util_HashMap.marshall(_$815507945__$1402722386_map(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
  }
}