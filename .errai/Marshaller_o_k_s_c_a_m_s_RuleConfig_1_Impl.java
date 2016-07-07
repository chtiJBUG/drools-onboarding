package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.api.model.KieScannerStatus;
import org.kie.server.controller.api.model.spec.RuleConfig;

public class Marshaller_o_k_s_c_a_m_s_RuleConfig_1_Impl implements GeneratedMarshaller<RuleConfig> {
  private RuleConfig[] EMPTY_ARRAY = new RuleConfig[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<KieScannerStatus> org_kie_server_api_model_KieScannerStatus = null;
  public RuleConfig[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public RuleConfig demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(RuleConfig.class, objId);
    }
    RuleConfig entity = new RuleConfig();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pollInterval")) && (!obj.get("pollInterval").isNull())) {
      entity.setPollInterval(java_lang_Long.demarshall(obj.get("pollInterval"), a1));
    }
    if ((obj.containsKey("scannerStatus")) && (!obj.get("scannerStatus").isNull())) {
      entity.setScannerStatus(obj.get("scannerStatus").isObject() != null ? Enum.valueOf(KieScannerStatus.class, obj.get("scannerStatus").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("scannerStatus").isString() != null ? Enum.valueOf(KieScannerStatus.class, obj.get("scannerStatus").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(RuleConfig a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.controller.api.model.spec.RuleConfig\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pollInterval\":").append(java_lang_Long.marshall(a0.getPollInterval(), a1)).append(",").append("\"scannerStatus\":").append(a0.getScannerStatus() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.server.api.model.KieScannerStatus\",\"^EnumStringValue\":\"").append(a0.getScannerStatus().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_server_api_model_KieScannerStatus == null) {
      org_kie_server_api_model_KieScannerStatus = Marshalling.getMarshaller(KieScannerStatus.class);
    }
  }
}