package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.EnvironmentParameters;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_s_r_EnvironmentParameters_1_Impl implements GeneratedMarshaller<EnvironmentParameters> {
  private EnvironmentParameters[] EMPTY_ARRAY = new EnvironmentParameters[0];
  public EnvironmentParameters[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public EnvironmentParameters demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EnvironmentParameters.class, objId);
    }
    EnvironmentParameters entity = new EnvironmentParameters();
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(EnvironmentParameters a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.EnvironmentParameters\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",\"^InstantiateOnly\":true").append("}").toString();
  }

  private void lazyInit() {

  }
}