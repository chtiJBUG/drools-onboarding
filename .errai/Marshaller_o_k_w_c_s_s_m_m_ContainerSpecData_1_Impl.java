package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.controller.api.model.runtime.Container;
import org.kie.server.controller.api.model.spec.ContainerSpec;
import org.kie.workbench.common.screens.server.management.model.ContainerSpecData;

public class Marshaller_o_k_w_c_s_s_m_m_ContainerSpecData_1_Impl implements GeneratedMarshaller<ContainerSpecData> {
  private ContainerSpecData[] EMPTY_ARRAY = new ContainerSpecData[0];
  private Marshaller<ContainerSpec> org_kie_server_controller_api_model_spec_ContainerSpec = null;
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public ContainerSpecData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ContainerSpec _$649245929__1903230394_containerSpec(ContainerSpecData instance) /*-{
    return instance.@org.kie.workbench.common.screens.server.management.model.ContainerSpecData::containerSpec;
  }-*/;

  private native static void _$649245929__1903230394_containerSpec(ContainerSpecData instance, ContainerSpec value) /*-{
    instance.@org.kie.workbench.common.screens.server.management.model.ContainerSpecData::containerSpec = value;
  }-*/;

  private native static Collection _$649245929__$688322466_containers(ContainerSpecData instance) /*-{
    return instance.@org.kie.workbench.common.screens.server.management.model.ContainerSpecData::containers;
  }-*/;

  private native static void _$649245929__$688322466_containers(ContainerSpecData instance, Collection<Container> value) /*-{
    instance.@org.kie.workbench.common.screens.server.management.model.ContainerSpecData::containers = value;
  }-*/;

  public ContainerSpecData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerSpecData.class, objId);
    }
    ContainerSpecData entity = new ContainerSpecData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("containerSpec")) && (!obj.get("containerSpec").isNull())) {
      _$649245929__1903230394_containerSpec(entity, org_kie_server_controller_api_model_spec_ContainerSpec.demarshall(obj.get("containerSpec"), a1));
    }
    if ((obj.containsKey("containers")) && (!obj.get("containers").isNull())) {
      _$649245929__$688322466_containers(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("containers"), a1));
    }
    return entity;
  }

  public String marshall(ContainerSpecData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.server.management.model.ContainerSpecData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"containerSpec\":").append(org_kie_server_controller_api_model_spec_ContainerSpec.marshall(a0.getContainerSpec(), a1)).append(",").append("\"containers\":").append(java_lang_Object.marshall(a0.getContainers(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_spec_ContainerSpec == null) {
      org_kie_server_controller_api_model_spec_ContainerSpec = Marshalling.getMarshaller(ContainerSpec.class);
    }
  }
}