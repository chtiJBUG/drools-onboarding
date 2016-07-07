package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.m2repo.model.JarListPageRow;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_m_m_JarListPageRow_1_Impl implements GeneratedMarshaller<JarListPageRow> {
  private JarListPageRow[] EMPTY_ARRAY = new JarListPageRow[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  public JarListPageRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public JarListPageRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(JarListPageRow.class, objId);
    }
    JarListPageRow entity = new JarListPageRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      entity.setPath(java_lang_String.demarshall(obj.get("path"), a1));
    }
    if ((obj.containsKey("gav")) && (!obj.get("gav").isNull())) {
      entity.setGav((GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("gav"), a1));
    }
    if ((obj.containsKey("lastModified")) && (!obj.get("lastModified").isNull())) {
      entity.setLastModified(java_util_Date.demarshall(obj.get("lastModified"), a1));
    }
    return entity;
  }

  public String marshall(JarListPageRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.m2repo.model.JarListPageRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"path\":").append(java_lang_String.marshall(a0.getPath(), a1)).append(",").append("\"gav\":").append(java_lang_Object.marshall(a0.getGav(), a1)).append(",").append("\"lastModified\":").append(java_util_Date.marshall(a0.getLastModified(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}