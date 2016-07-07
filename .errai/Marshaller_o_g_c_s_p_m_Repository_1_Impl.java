package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_Repository_1_Impl implements GeneratedMarshaller<Repository> {
  private Repository[] EMPTY_ARRAY = new Repository[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Repository[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Repository demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Repository.class, objId);
    }
    Repository entity = new Repository();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("url")) && (!obj.get("url").isNull())) {
      entity.setUrl(java_lang_String.demarshall(obj.get("url"), a1));
    }
    return entity;
  }

  public String marshall(Repository a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Repository\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"url\":").append(java_lang_String.marshall(a0.getUrl(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}