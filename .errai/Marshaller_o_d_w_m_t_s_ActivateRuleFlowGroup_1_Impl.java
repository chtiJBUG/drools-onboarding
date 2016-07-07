package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.ActivateRuleFlowGroup;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_ActivateRuleFlowGroup_1_Impl implements GeneratedMarshaller<ActivateRuleFlowGroup> {
  private ActivateRuleFlowGroup[] EMPTY_ARRAY = new ActivateRuleFlowGroup[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ActivateRuleFlowGroup[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActivateRuleFlowGroup demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActivateRuleFlowGroup.class, objId);
    }
    ActivateRuleFlowGroup entity = new ActivateRuleFlowGroup();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(ActivateRuleFlowGroup a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.ActivateRuleFlowGroup\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}