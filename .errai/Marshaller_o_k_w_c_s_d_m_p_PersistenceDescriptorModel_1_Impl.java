package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceUnitModel;

public class Marshaller_o_k_w_c_s_d_m_p_PersistenceDescriptorModel_1_Impl implements GeneratedMarshaller<PersistenceDescriptorModel> {
  private PersistenceDescriptorModel[] EMPTY_ARRAY = new PersistenceDescriptorModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<PersistenceUnitModel> org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceUnitModel = null;
  public PersistenceDescriptorModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PersistenceDescriptorModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PersistenceDescriptorModel.class, objId);
    }
    PersistenceDescriptorModel entity = new PersistenceDescriptorModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("persistenceUnit")) && (!obj.get("persistenceUnit").isNull())) {
      entity.setPersistenceUnit(org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceUnitModel.demarshall(obj.get("persistenceUnit"), a1));
    }
    return entity;
  }

  public String marshall(PersistenceDescriptorModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append(",").append("\"persistenceUnit\":").append(org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceUnitModel.marshall(a0.getPersistenceUnit(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceUnitModel == null) {
      org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceUnitModel = Marshalling.getMarshaller(PersistenceUnitModel.class);
    }
  }
}