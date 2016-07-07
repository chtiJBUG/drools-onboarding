package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.FileLogger;

public class Marshaller_o_k_w_c_s_s_k_FileLogger_1_Impl implements GeneratedMarshaller<FileLogger> {
  private FileLogger[] EMPTY_ARRAY = new FileLogger[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public FileLogger[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FileLogger demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FileLogger.class, objId);
    }
    FileLogger entity = new FileLogger();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("file")) && (!obj.get("file").isNull())) {
      entity.setFile(java_lang_String.demarshall(obj.get("file"), a1));
    }
    if ((obj.containsKey("threaded")) && (!obj.get("threaded").isNull())) {
      entity.setThreaded(java_lang_Boolean.demarshall(obj.get("threaded"), a1));
    }
    if ((obj.containsKey("interval")) && (!obj.get("interval").isNull())) {
      entity.setInterval(java_lang_Integer.demarshall(obj.get("interval"), a1));
    }
    return entity;
  }

  private native static boolean _$975857825__64711720_threaded(FileLogger instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.FileLogger::threaded;
  }-*/;

  private native static void _$975857825__64711720_threaded(FileLogger instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.FileLogger::threaded = value;
  }-*/;

  public String marshall(FileLogger a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.FileLogger\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"file\":").append(java_lang_String.marshall(a0.getFile(), a1)).append(",").append("\"threaded\":").append(java_lang_Boolean.marshall(_$975857825__64711720_threaded(a0), a1)).append(",").append("\"interval\":").append(java_lang_Integer.marshall(a0.getInterval(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}