package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.common.services.project.model.WorkItemHandlerModel;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.services.shared.kmodule.ClockTypeOption;
import org.kie.workbench.common.services.shared.kmodule.KSessionLogger;
import org.kie.workbench.common.services.shared.kmodule.KSessionModel;

public class Marshaller_o_k_w_c_s_s_k_KSessionModel_1_Impl implements GeneratedMarshaller<KSessionModel> {
  private KSessionModel[] EMPTY_ARRAY = new KSessionModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<ClockTypeOption> org_kie_workbench_common_services_shared_kmodule_ClockTypeOption = null;
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public KSessionModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _1423967275__64711720_theDefault(KSessionModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KSessionModel::theDefault;
  }-*/;

  private native static void _1423967275__64711720_theDefault(KSessionModel instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KSessionModel::theDefault = value;
  }-*/;

  private native static List _1423967275__65821278_workItemHandelerModels(KSessionModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KSessionModel::workItemHandelerModels;
  }-*/;

  private native static void _1423967275__65821278_workItemHandelerModels(KSessionModel instance, List<WorkItemHandlerModel> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KSessionModel::workItemHandelerModels = value;
  }-*/;

  public KSessionModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KSessionModel.class, objId);
    }
    KSessionModel entity = new KSessionModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("clockType")) && (!obj.get("clockType").isNull())) {
      entity.setClockType(obj.get("clockType").isObject() != null ? Enum.valueOf(ClockTypeOption.class, obj.get("clockType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("clockType").isString() != null ? Enum.valueOf(ClockTypeOption.class, obj.get("clockType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("theDefault")) && (!obj.get("theDefault").isNull())) {
      _1423967275__64711720_theDefault(entity, java_lang_Boolean.demarshall(obj.get("theDefault"), a1));
    }
    if ((obj.containsKey("scope")) && (!obj.get("scope").isNull())) {
      entity.setScope(java_lang_String.demarshall(obj.get("scope"), a1));
    }
    if ((obj.containsKey("workItemHandelerModels")) && (!obj.get("workItemHandelerModels").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.WorkItemHandlerModel");
      _1423967275__65821278_workItemHandelerModels(entity, java_util_List.demarshall(obj.get("workItemHandelerModels"), a1));
    }
    if ((obj.containsKey("listeners")) && (!obj.get("listeners").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.shared.kmodule.ListenerModel");
      entity.setListeners(java_util_List.demarshall(obj.get("listeners"), a1));
    }
    if ((obj.containsKey("logger")) && (!obj.get("logger").isNull())) {
      entity.setLogger((KSessionLogger) ((ObjectMarshaller) java_lang_Object).demarshall(KSessionLogger.class, obj.get("logger"), a1));
    }
    return entity;
  }

  public String marshall(KSessionModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.KSessionModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"clockType\":").append(a0.getClockType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.ClockTypeOption\",\"^EnumStringValue\":\"").append(a0.getClockType().name()).append("\"}") : "null").append(",").append("\"theDefault\":").append(java_lang_Boolean.marshall(_1423967275__64711720_theDefault(a0), a1)).append(",").append("\"scope\":").append(java_lang_String.marshall(a0.getScope(), a1)).append(",").append("\"workItemHandelerModels\":").append(java_util_List.marshall(a0.getWorkItemHandelerModels(), a1)).append(",").append("\"listeners\":").append(java_util_List.marshall(a0.getListeners(), a1)).append(",").append("\"logger\":").append(java_lang_Object.marshall(a0.getLogger(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_shared_kmodule_ClockTypeOption == null) {
      org_kie_workbench_common_services_shared_kmodule_ClockTypeOption = Marshalling.getMarshaller(ClockTypeOption.class);
    }
  }
}