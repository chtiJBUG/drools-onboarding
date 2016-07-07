package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.factmodel.model.FieldMetaModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_f_m_FieldMetaModel_1_Impl implements GeneratedMarshaller<FieldMetaModel> {
  private FieldMetaModel[] EMPTY_ARRAY = new FieldMetaModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public FieldMetaModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public FieldMetaModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FieldMetaModel.class, objId);
    }
    FieldMetaModel entity = new FieldMetaModel();
    a1.recordObject(objId, entity);
    entity.name = java_lang_String.demarshall(obj.get("name"), a1);
    entity.type = java_lang_String.demarshall(obj.get("type"), a1);
    return entity;
  }

  public String marshall(FieldMetaModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.factmodel.model.FieldMetaModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.name, a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.type, a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}