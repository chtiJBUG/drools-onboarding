package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_s_m_m_Overview_1_Impl implements GeneratedMarshaller<Overview> {
  private Overview[] EMPTY_ARRAY = new Overview[0];
  private Marshaller<Metadata> org_guvnor_common_services_shared_metadata_model_Metadata = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Overview[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Overview demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Overview.class, objId);
    }
    Overview entity = new Overview();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("metadata")) && (!obj.get("metadata").isNull())) {
      entity.setMetadata(org_guvnor_common_services_shared_metadata_model_Metadata.demarshall(obj.get("metadata"), a1));
    }
    if ((obj.containsKey("projectName")) && (!obj.get("projectName").isNull())) {
      entity.setProjectName(java_lang_String.demarshall(obj.get("projectName"), a1));
    }
    return entity;
  }

  public String marshall(Overview a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.shared.metadata.model.Overview\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"metadata\":").append(org_guvnor_common_services_shared_metadata_model_Metadata.marshall(a0.getMetadata(), a1)).append(",").append("\"projectName\":").append(java_lang_String.marshall(a0.getProjectName(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Metadata == null) {
      org_guvnor_common_services_shared_metadata_model_Metadata = Marshalling.getMarshaller(Metadata.class);
    }
  }
}