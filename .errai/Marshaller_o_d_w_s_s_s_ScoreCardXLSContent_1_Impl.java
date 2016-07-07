package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_s_s_ScoreCardXLSContent_1_Impl implements GeneratedMarshaller<ScoreCardXLSContent> {
  private ScoreCardXLSContent[] EMPTY_ARRAY = new ScoreCardXLSContent[0];
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public ScoreCardXLSContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ScoreCardXLSContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ScoreCardXLSContent.class, objId);
    }
    ScoreCardXLSContent entity = new ScoreCardXLSContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      entity.setOverview(org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(ScoreCardXLSContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSContent\",\"^ObjectID\"");
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