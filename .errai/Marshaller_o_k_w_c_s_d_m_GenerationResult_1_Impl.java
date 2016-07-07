package org.jboss.errai.marshalling.client.api;

import java.util.List;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.model.GenerationResult;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_k_w_c_s_d_m_GenerationResult_1_Impl implements GeneratedMarshaller<GenerationResult> {
  private GenerationResult[] EMPTY_ARRAY = new GenerationResult[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public GenerationResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GenerationResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GenerationResult.class, objId);
    }
    GenerationResult entity = new GenerationResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("generationTime")) && (!obj.get("generationTime").isNull())) {
      entity.setGenerationTime(java_lang_Long.demarshall(obj.get("generationTime"), a1));
    }
    if ((obj.containsKey("objectFingerPrints")) && (!obj.get("objectFingerPrints").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      entity.setObjectFingerPrints(java_util_Map.demarshall(obj.get("objectFingerPrints"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      entity.setSource(java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("dataObject")) && (!obj.get("dataObject").isNull())) {
      entity.setDataObject((DataObject) ((ObjectMarshaller) java_lang_Object).demarshall(DataObject.class, obj.get("dataObject"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      entity.setPath((Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("errors")) && (!obj.get("errors").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.screens.datamodeller.model.DataModelerError");
      entity.setErrors(java_util_List.demarshall(obj.get("errors"), a1));
    }
    return entity;
  }

  public String marshall(GenerationResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.model.GenerationResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"generationTime\":").append(java_lang_Long.marshall(a0.getGenerationTime(), a1)).append(",").append("\"objectFingerPrints\":").append(java_util_Map.marshall(a0.getObjectFingerPrints(), a1)).append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"dataObject\":").append(java_lang_Object.marshall(a0.getDataObject(), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"errors\":").append(java_util_List.marshall(a0.getErrors(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}