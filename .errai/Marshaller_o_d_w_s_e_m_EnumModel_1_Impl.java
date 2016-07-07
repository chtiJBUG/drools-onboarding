package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.enums.model.EnumModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_e_m_EnumModel_1_Impl implements GeneratedMarshaller<EnumModel> {
  private EnumModel[] EMPTY_ARRAY = new EnumModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public EnumModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1674083042__1195259493_enums(EnumModel instance) /*-{
    return instance.@org.drools.workbench.screens.enums.model.EnumModel::enums;
  }-*/;

  private native static void _1674083042__1195259493_enums(EnumModel instance, String value) /*-{
    instance.@org.drools.workbench.screens.enums.model.EnumModel::enums = value;
  }-*/;

  public EnumModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(EnumModel.class, objId);
    }
    EnumModel entity = new EnumModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("enums")) && (!obj.get("enums").isNull())) {
      _1674083042__1195259493_enums(entity, java_lang_String.demarshall(obj.get("enums"), a1));
    }
    return entity;
  }

  public String marshall(EnumModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.enums.model.EnumModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"enums\":").append(java_lang_String.marshall(_1674083042__1195259493_enums(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}