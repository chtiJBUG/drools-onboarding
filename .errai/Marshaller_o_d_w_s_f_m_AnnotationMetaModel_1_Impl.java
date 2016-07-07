package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.screens.factmodel.model.AnnotationMetaModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_f_m_AnnotationMetaModel_1_Impl implements GeneratedMarshaller<AnnotationMetaModel> {
  private AnnotationMetaModel[] EMPTY_ARRAY = new AnnotationMetaModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public AnnotationMetaModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public AnnotationMetaModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AnnotationMetaModel.class, objId);
    }
    AnnotationMetaModel entity = new AnnotationMetaModel();
    a1.recordObject(objId, entity);
    entity.name = java_lang_String.demarshall(obj.get("name"), a1);
    entity.values = java_util_Map.demarshall(obj.get("values"), a1);
    return entity;
  }

  public String marshall(AnnotationMetaModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.factmodel.model.AnnotationMetaModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.name, a1)).append(",").append("\"values\":").append(java_util_Map.marshall(a0.values, a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}