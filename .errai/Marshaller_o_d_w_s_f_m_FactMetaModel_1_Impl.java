package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.screens.factmodel.model.FactMetaModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_f_m_FactMetaModel_1_Impl implements GeneratedMarshaller<FactMetaModel> {
  private FactMetaModel[] EMPTY_ARRAY = new FactMetaModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public FactMetaModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FactMetaModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FactMetaModel.class, objId);
    }
    FactMetaModel entity = new FactMetaModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("superType")) && (!obj.get("superType").isNull())) {
      entity.setSuperType(java_lang_String.demarshall(obj.get("superType"), a1));
    }
    if ((obj.containsKey("fields")) && (!obj.get("fields").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.screens.factmodel.model.FieldMetaModel");
      entity.setFields(java_util_List.demarshall(obj.get("fields"), a1));
    }
    if ((obj.containsKey("annotations")) && (!obj.get("annotations").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.screens.factmodel.model.AnnotationMetaModel");
      entity.setAnnotations(java_util_List.demarshall(obj.get("annotations"), a1));
    }
    return entity;
  }

  public String marshall(FactMetaModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.factmodel.model.FactMetaModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"superType\":").append(java_lang_String.marshall(a0.getSuperType(), a1)).append(",").append("\"fields\":").append(java_util_List.marshall(a0.getFields(), a1)).append(",").append("\"annotations\":").append(java_util_List.marshall(a0.getAnnotations(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}