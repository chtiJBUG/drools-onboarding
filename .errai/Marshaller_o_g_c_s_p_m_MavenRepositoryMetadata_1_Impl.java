package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.MavenRepositoryMetadata;
import org.guvnor.common.services.project.model.MavenRepositorySource;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_MavenRepositoryMetadata_1_Impl implements GeneratedMarshaller<MavenRepositoryMetadata> {
  private MavenRepositoryMetadata[] EMPTY_ARRAY = new MavenRepositoryMetadata[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<MavenRepositorySource> org_guvnor_common_services_project_model_MavenRepositorySource = null;
  public MavenRepositoryMetadata[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public MavenRepositoryMetadata demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(MavenRepositoryMetadata.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("id"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("url"), a1);
    final MavenRepositorySource c2 = obj.get("source").isObject() != null ? Enum.valueOf(MavenRepositorySource.class, obj.get("source").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("source").isString() != null ? Enum.valueOf(MavenRepositorySource.class, obj.get("source").isString().stringValue()) : null;
    MavenRepositoryMetadata entity = new MavenRepositoryMetadata(c0, c1, c2);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(MavenRepositoryMetadata a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.MavenRepositoryMetadata\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append(",").append("\"source\":").append(a0.getSource() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.common.services.project.model.MavenRepositorySource\",\"^EnumStringValue\":\"").append(a0.getSource().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_MavenRepositorySource == null) {
      org_guvnor_common_services_project_model_MavenRepositorySource = Marshalling.getMarshaller(MavenRepositorySource.class);
    }
  }
}