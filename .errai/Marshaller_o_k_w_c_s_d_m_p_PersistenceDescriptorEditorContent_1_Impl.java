package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_d_m_p_PersistenceDescriptorEditorContent_1_Impl implements GeneratedMarshaller<PersistenceDescriptorEditorContent> {
  private PersistenceDescriptorEditorContent[] EMPTY_ARRAY = new PersistenceDescriptorEditorContent[0];
  private Marshaller<PersistenceDescriptorModel> org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceDescriptorModel = null;
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public PersistenceDescriptorEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PersistenceDescriptorEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PersistenceDescriptorEditorContent.class, objId);
    }
    PersistenceDescriptorEditorContent entity = new PersistenceDescriptorEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("descriptorModel")) && (!obj.get("descriptorModel").isNull())) {
      entity.setDescriptorModel(org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceDescriptorModel.demarshall(obj.get("descriptorModel"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      entity.setSource(java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      entity.setPath((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("created")) && (!obj.get("created").isNull())) {
      entity.setCreated(java_lang_Boolean.demarshall(obj.get("created"), a1));
    }
    return entity;
  }

  private native static boolean _$509980836__64711720_created(PersistenceDescriptorEditorContent instance) /*-{
    return instance.@org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent::created;
  }-*/;

  private native static void _$509980836__64711720_created(PersistenceDescriptorEditorContent instance, boolean value) /*-{
    instance.@org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent::created = value;
  }-*/;

  public String marshall(PersistenceDescriptorEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"descriptorModel\":").append(org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceDescriptorModel.marshall(a0.getDescriptorModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"created\":").append(java_lang_Boolean.marshall(_$509980836__64711720_created(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceDescriptorModel == null) {
      org_kie_workbench_common_screens_datamodeller_model_persistence_PersistenceDescriptorModel = Marshalling.getMarshaller(PersistenceDescriptorModel.class);
    }
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}