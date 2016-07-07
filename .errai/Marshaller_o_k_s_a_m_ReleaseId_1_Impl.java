package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.server.api.model.ReleaseId;

public class Marshaller_o_k_s_a_m_ReleaseId_1_Impl implements GeneratedMarshaller<ReleaseId> {
  private ReleaseId[] EMPTY_ARRAY = new ReleaseId[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ReleaseId[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ReleaseId demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ReleaseId.class, objId);
    }
    ReleaseId entity = new ReleaseId();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("groupId")) && (!obj.get("groupId").isNull())) {
      entity.setGroupId(java_lang_String.demarshall(obj.get("groupId"), a1));
    }
    if ((obj.containsKey("artifactId")) && (!obj.get("artifactId").isNull())) {
      entity.setArtifactId(java_lang_String.demarshall(obj.get("artifactId"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    return entity;
  }

  public String marshall(ReleaseId a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.server.api.model.ReleaseId\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"groupId\":").append(java_lang_String.marshall(a0.getGroupId(), a1)).append(",").append("\"artifactId\":").append(java_lang_String.marshall(a0.getArtifactId(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}