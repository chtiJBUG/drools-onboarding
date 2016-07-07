package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_r_RepositoryEnvironmentConfiguration_1_Impl implements GeneratedMarshaller<RepositoryEnvironmentConfiguration> {
  private RepositoryEnvironmentConfiguration[] EMPTY_ARRAY = new RepositoryEnvironmentConfiguration[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public RepositoryEnvironmentConfiguration[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1518821277__1195259493_name(RepositoryEnvironmentConfiguration instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration::name;
  }-*/;

  private native static void _1518821277__1195259493_name(RepositoryEnvironmentConfiguration instance, String value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration::name = value;
  }-*/;

  private native static Object _1518821277__1063877011_value(RepositoryEnvironmentConfiguration instance) /*-{
    return instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration::value;
  }-*/;

  private native static void _1518821277__1063877011_value(RepositoryEnvironmentConfiguration instance, Object value) /*-{
    instance.@org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration::value = value;
  }-*/;

  public RepositoryEnvironmentConfiguration demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RepositoryEnvironmentConfiguration.class, objId);
    }
    RepositoryEnvironmentConfiguration entity = new RepositoryEnvironmentConfiguration();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _1518821277__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      _1518821277__1063877011_value(entity, ((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("value"), a1));
    }
    return entity;
  }

  public String marshall(RepositoryEnvironmentConfiguration a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.repositories.RepositoryEnvironmentConfiguration\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"value\":").append(java_lang_Object.marshall(a0.getValue(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}