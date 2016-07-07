package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.shared.message.Level;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.model.DataModelerError;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_d_m_DataModelerError_1_Impl implements GeneratedMarshaller<DataModelerError> {
  private DataModelerError[] EMPTY_ARRAY = new DataModelerError[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Level> org_guvnor_common_services_shared_message_Level = null;
  public DataModelerError[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataModelerError demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataModelerError.class, objId);
    }
    DataModelerError entity = new DataModelerError();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      entity.setMessage(java_lang_String.demarshall(obj.get("message"), a1));
    }
    if ((obj.containsKey("file")) && (!obj.get("file").isNull())) {
      entity.setFile((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("file"), a1));
    }
    if ((obj.containsKey("line")) && (!obj.get("line").isNull())) {
      entity.setLine(java_lang_Integer.demarshall(obj.get("line"), a1));
    }
    if ((obj.containsKey("column")) && (!obj.get("column").isNull())) {
      entity.setColumn(java_lang_Integer.demarshall(obj.get("column"), a1));
    }
    if ((obj.containsKey("level")) && (!obj.get("level").isNull())) {
      entity.setLevel(obj.get("level").isObject() != null ? Enum.valueOf(Level.class, obj.get("level").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("level").isString() != null ? Enum.valueOf(Level.class, obj.get("level").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(DataModelerError a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.DataModelerError\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"file\":").append(java_lang_Object.marshall(a0.getFile(), a1)).append(",").append("\"line\":").append(java_lang_Integer.marshall(a0.getLine(), a1)).append(",").append("\"column\":").append(java_lang_Integer.marshall(a0.getColumn(), a1)).append(",").append("\"level\":").append(a0.getLevel() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.guvnor.common.services.shared.message.Level\",\"^EnumStringValue\":\"").append(a0.getLevel().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_message_Level == null) {
      org_guvnor_common_services_shared_message_Level = Marshalling.getMarshaller(Level.class);
    }
  }
}