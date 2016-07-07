package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.controller.api.model.events.RuleConfigUpdated;
import org.kie.server.controller.api.model.spec.ContainerSpecKey;
import org.kie.server.controller.api.model.spec.RuleConfig;

public class Marshaller_o_k_s_c_a_m_e_RuleConfigUpdated_1_Impl implements GeneratedMarshaller<RuleConfigUpdated> {
  private RuleConfigUpdated[] EMPTY_ARRAY = new RuleConfigUpdated[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<RuleConfig> org_kie_server_controller_api_model_spec_RuleConfig = null;
  private Marshaller<ReleaseId> org_kie_server_api_model_ReleaseId = null;
  public RuleConfigUpdated[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuleConfigUpdated demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleConfigUpdated.class, objId);
    }
    RuleConfigUpdated entity = new RuleConfigUpdated();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("containerSpecKey")) && (!obj.get("containerSpecKey").isNull())) {
      entity.setContainerSpecKey((ContainerSpecKey) ((ObjectMarshaller) java_lang_Object).demarshall(ContainerSpecKey.class, obj.get("containerSpecKey"), a1));
    }
    if ((obj.containsKey("ruleConfig")) && (!obj.get("ruleConfig").isNull())) {
      entity.setRuleConfig(org_kie_server_controller_api_model_spec_RuleConfig.demarshall(obj.get("ruleConfig"), a1));
    }
    if ((obj.containsKey("releasedId")) && (!obj.get("releasedId").isNull())) {
      entity.setReleasedId(org_kie_server_api_model_ReleaseId.demarshall(obj.get("releasedId"), a1));
    }
    return entity;
  }

  public String marshall(RuleConfigUpdated a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.events.RuleConfigUpdated\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"containerSpecKey\":").append(java_lang_Object.marshall(a0.getContainerSpecKey(), a1)).append(",").append("\"ruleConfig\":").append(org_kie_server_controller_api_model_spec_RuleConfig.marshall(a0.getRuleConfig(), a1)).append(",").append("\"releasedId\":").append(org_kie_server_api_model_ReleaseId.marshall(a0.getReleasedId(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_controller_api_model_spec_RuleConfig == null) {
      org_kie_server_controller_api_model_spec_RuleConfig = Marshalling.getMarshaller(RuleConfig.class);
    }
    if (org_kie_server_api_model_ReleaseId == null) {
      org_kie_server_api_model_ReleaseId = Marshalling.getMarshaller(ReleaseId.class);
    }
  }
}