package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.designer.service.DesignerContent;

public class Marshaller_o_j_d_s_DesignerContent_1_Impl implements GeneratedMarshaller<DesignerContent> {
  private DesignerContent[] EMPTY_ARRAY = new DesignerContent[0];
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public DesignerContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DesignerContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DesignerContent.class, objId);
    }
    DesignerContent entity = new DesignerContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(DesignerContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.designer.service.DesignerContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}