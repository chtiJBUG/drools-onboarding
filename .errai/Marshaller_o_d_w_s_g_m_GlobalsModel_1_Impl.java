package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.screens.globals.model.GlobalsModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_g_m_GlobalsModel_1_Impl implements GeneratedMarshaller<GlobalsModel> {
  private GlobalsModel[] EMPTY_ARRAY = new GlobalsModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public GlobalsModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public GlobalsModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GlobalsModel.class, objId);
    }
    GlobalsModel entity = new GlobalsModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("globals")) && (!obj.get("globals").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.screens.globals.model.Global");
      entity.setGlobals(java_util_List.demarshall(obj.get("globals"), a1));
    }
    return entity;
  }

  public String marshall(GlobalsModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.globals.model.GlobalsModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"globals\":").append(java_util_List.marshall(a0.getGlobals(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}