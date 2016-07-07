package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.kie.server.controller.api.model.spec.ContainerSpec;
import org.kie.server.controller.api.model.spec.ContainerSpecList;

public class Marshaller_o_k_s_c_a_m_s_ContainerSpecList_1_Impl implements GeneratedMarshaller<ContainerSpecList> {
  private ContainerSpecList[] EMPTY_ARRAY = new ContainerSpecList[0];
  private Marshaller<ContainerSpec[]> arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1 = null;
  abstract class Marshaller_for_arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1 implements GeneratedMarshaller { }
  public ContainerSpecList[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ContainerSpecList demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ContainerSpecList.class, objId);
    }
    ContainerSpecList entity = new ContainerSpecList();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("containerSpecs")) && (!obj.get("containerSpecs").isNull())) {
      entity.setContainerSpecs(arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1.demarshall(obj.get("containerSpecs"), a1));
    }
    return entity;
  }

  public String marshall(ContainerSpecList a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.ContainerSpecList\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"containerSpecs\":").append(arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1.marshall(a0.getContainerSpecs(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1 == null) {
      arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1 = Marshalling.getMarshaller(ContainerSpec[].class, new DeferredMarshallerCreationCallback<ContainerSpec[]>() {
        public Marshaller<ContainerSpec[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_kie_server_controller_api_model_spec_ContainerSpec_D1.class), ContainerSpec[].class);
        }
      });
    }
  }
}