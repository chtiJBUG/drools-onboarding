package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ActionExecuteWorkItem;
import org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ActionExecuteWorkItem_1_Impl implements GeneratedMarshaller<ActionExecuteWorkItem> {
  private ActionExecuteWorkItem[] EMPTY_ARRAY = new ActionExecuteWorkItem[0];
  private Marshaller<PortableWorkDefinition> org_drools_workbench_models_datamodel_workitems_PortableWorkDefinition = null;
  public ActionExecuteWorkItem[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ActionExecuteWorkItem demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ActionExecuteWorkItem.class, objId);
    }
    ActionExecuteWorkItem entity = new ActionExecuteWorkItem();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("workDefinition")) && (!obj.get("workDefinition").isNull())) {
      entity.setWorkDefinition(org_drools_workbench_models_datamodel_workitems_PortableWorkDefinition.demarshall(obj.get("workDefinition"), a1));
    }
    return entity;
  }

  public String marshall(ActionExecuteWorkItem a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ActionExecuteWorkItem\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"workDefinition\":").append(org_drools_workbench_models_datamodel_workitems_PortableWorkDefinition.marshall(a0.getWorkDefinition(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_workitems_PortableWorkDefinition == null) {
      org_drools_workbench_models_datamodel_workitems_PortableWorkDefinition = Marshalling.getMarshaller(PortableWorkDefinition.class);
    }
  }
}