package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.controller.api.model.runtime.ServerInstanceKey;
import org.kie.server.controller.api.model.spec.ServerTemplate;

public class Marshaller_o_k_s_c_a_m_s_ServerTemplate_1_Impl implements GeneratedMarshaller<ServerTemplate> {
  private ServerTemplate[] EMPTY_ARRAY = new ServerTemplate[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ServerTemplate[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Collection _1169865407__$688322466_serverInstances(ServerTemplate instance) /*-{
    return instance.@org.kie.server.controller.api.model.spec.ServerTemplate::serverInstances;
  }-*/;

  private native static void _1169865407__$688322466_serverInstances(ServerTemplate instance, Collection<ServerInstanceKey> value) /*-{
    instance.@org.kie.server.controller.api.model.spec.ServerTemplate::serverInstances = value;
  }-*/;

  public ServerTemplate demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ServerTemplate.class, objId);
    }
    ServerTemplate entity = new ServerTemplate();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("containersSpec")) && (!obj.get("containersSpec").isNull())) {
      entity.setContainersSpec((Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("containersSpec"), a1));
    }
    if ((obj.containsKey("configs")) && (!obj.get("configs").isNull())) {
      a1.setAssumedMapKeyType("org.kie.server.controller.api.model.spec.Capability");
      a1.setAssumedMapValueType("org.kie.server.controller.api.model.spec.ServerConfig");
      entity.setConfigs(java_util_Map.demarshall(obj.get("configs"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("serverInstances")) && (!obj.get("serverInstances").isNull())) {
      _1169865407__$688322466_serverInstances(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("serverInstances"), a1));
    }
    if ((obj.containsKey("capabilities")) && (!obj.get("capabilities").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      entity.setCapabilities(java_util_List.demarshall(obj.get("capabilities"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ServerTemplate a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ServerTemplate\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"containersSpec\":").append(java_lang_Object.marshall(a0.getContainersSpec(), a1)).append(",").append("\"configs\":").append(java_util_Map.marshall(a0.getConfigs(), a1)).append(",").append("\"serverInstances\":").append(java_lang_Object.marshall(_1169865407__$688322466_serverInstances(a0), a1)).append(",").append("\"capabilities\":").append(java_util_List.marshall(a0.getCapabilities(), a1)).append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}