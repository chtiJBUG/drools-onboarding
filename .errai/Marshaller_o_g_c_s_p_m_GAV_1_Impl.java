package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.GAV;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_GAV_1_Impl implements GeneratedMarshaller<GAV> {
  private GAV[] EMPTY_ARRAY = new GAV[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public GAV[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GAV demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GAV.class, objId);
    }
    GAV entity = new GAV();
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

  public String marshall(GAV a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.GAV\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"groupId\":").append(java_lang_String.marshall(a0.getGroupId(), a1)).append(",").append("\"artifactId\":").append(java_lang_String.marshall(a0.getArtifactId(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}