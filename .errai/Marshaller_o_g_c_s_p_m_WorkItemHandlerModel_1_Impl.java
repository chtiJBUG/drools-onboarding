package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.WorkItemHandlerModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_WorkItemHandlerModel_1_Impl implements GeneratedMarshaller<WorkItemHandlerModel> {
  private WorkItemHandlerModel[] EMPTY_ARRAY = new WorkItemHandlerModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public WorkItemHandlerModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public WorkItemHandlerModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WorkItemHandlerModel.class, objId);
    }
    WorkItemHandlerModel entity = new WorkItemHandlerModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(WorkItemHandlerModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.WorkItemHandlerModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}