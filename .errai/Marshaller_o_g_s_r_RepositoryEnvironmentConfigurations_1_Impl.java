package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_s_r_RepositoryEnvironmentConfigurations_1_Impl implements GeneratedMarshaller<RepositoryEnvironmentConfigurations> {
  private RepositoryEnvironmentConfigurations[] EMPTY_ARRAY = new RepositoryEnvironmentConfigurations[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public RepositoryEnvironmentConfigurations[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$161180554__$1383349348_configurationMap(RepositoryEnvironmentConfigurations instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations::configurationMap;
  }-*/;

  private native static void _$161180554__$1383349348_configurationMap(RepositoryEnvironmentConfigurations instance, Map value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations::configurationMap = value;
  }-*/;

  public RepositoryEnvironmentConfigurations demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryEnvironmentConfigurations.class, objId);
    }
    RepositoryEnvironmentConfigurations entity = new RepositoryEnvironmentConfigurations();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("configurationMap")) && (!obj.get("configurationMap").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      _$161180554__$1383349348_configurationMap(entity, java_util_Map.demarshall(obj.get("configurationMap"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(RepositoryEnvironmentConfigurations a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"configurationMap\":").append(java_util_Map.marshall(a0.getConfigurationMap(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}