package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.ListenerModel;
import org.kie.workbench.common.services.shared.kmodule.ListenerModel.Kind;

public class Marshaller_o_k_w_c_s_s_k_ListenerModel_1_Impl implements GeneratedMarshaller<ListenerModel> {
  private ListenerModel[] EMPTY_ARRAY = new ListenerModel[0];
  private Marshaller<Kind> org_kie_workbench_common_services_shared_kmodule_ListenerModel_erraiD_Kind = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ListenerModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ListenerModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ListenerModel.class, objId);
    }
    ListenerModel entity = new ListenerModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("kind")) && (!obj.get("kind").isNull())) {
      entity.setKind(obj.get("kind").isObject() != null ? Enum.valueOf(Kind.class, obj.get("kind").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("kind").isString() != null ? Enum.valueOf(Kind.class, obj.get("kind").isString().stringValue()) : null);
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    return entity;
  }

  public String marshall(ListenerModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.ListenerModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"kind\":").append(a0.getKind() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.ListenerModel$Kind\",\"^EnumStringValue\":\"").append(a0.getKind().name()).append("\"}") : "null").append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_shared_kmodule_ListenerModel_erraiD_Kind == null) {
      org_kie_workbench_common_services_shared_kmodule_ListenerModel_erraiD_Kind = Marshalling.getMarshaller(Kind.class);
    }
  }
}