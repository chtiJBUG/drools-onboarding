package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.shared.kmodule.AssertBehaviorOption;
import org.kie.workbench.common.services.shared.kmodule.DeclarativeAgendaOption;
import org.kie.workbench.common.services.shared.kmodule.EventProcessingOption;
import org.kie.workbench.common.services.shared.kmodule.KBaseModel;
import org.kie.workbench.common.services.shared.kmodule.KSessionModel;

public class Marshaller_o_k_w_c_s_s_k_KBaseModel_1_Impl implements GeneratedMarshaller<KBaseModel> {
  private KBaseModel[] EMPTY_ARRAY = new KBaseModel[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<AssertBehaviorOption> org_kie_workbench_common_services_shared_kmodule_AssertBehaviorOption = null;
  private Marshaller<EventProcessingOption> org_kie_workbench_common_services_shared_kmodule_EventProcessingOption = null;
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<DeclarativeAgendaOption> org_kie_workbench_common_services_shared_kmodule_DeclarativeAgendaOption = null;
  public KBaseModel[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$1953508384__65821278_kSessions(KBaseModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::kSessions;
  }-*/;

  private native static void _$1953508384__65821278_kSessions(KBaseModel instance, List<KSessionModel> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::kSessions = value;
  }-*/;

  private native static List _$1953508384__65821278_includes(KBaseModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::includes;
  }-*/;

  private native static void _$1953508384__65821278_includes(KBaseModel instance, List<String> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::includes = value;
  }-*/;

  private native static boolean _$1953508384__64711720_theDefault(KBaseModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::theDefault;
  }-*/;

  private native static void _$1953508384__64711720_theDefault(KBaseModel instance, boolean value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::theDefault = value;
  }-*/;

  private native static List _$1953508384__65821278_packages(KBaseModel instance) /*-{
    return instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::packages;
  }-*/;

  private native static void _$1953508384__65821278_packages(KBaseModel instance, List<String> value) /*-{
    instance.@org.kie.workbench.common.services.shared.kmodule.KBaseModel::packages = value;
  }-*/;

  public KBaseModel demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KBaseModel.class, objId);
    }
    KBaseModel entity = new KBaseModel();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("equalsBehavior")) && (!obj.get("equalsBehavior").isNull())) {
      entity.setEqualsBehavior(obj.get("equalsBehavior").isObject() != null ? Enum.valueOf(AssertBehaviorOption.class, obj.get("equalsBehavior").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("equalsBehavior").isString() != null ? Enum.valueOf(AssertBehaviorOption.class, obj.get("equalsBehavior").isString().stringValue()) : null);
    }
    if ((obj.containsKey("eventProcessingMode")) && (!obj.get("eventProcessingMode").isNull())) {
      entity.setEventProcessingMode(obj.get("eventProcessingMode").isObject() != null ? Enum.valueOf(EventProcessingOption.class, obj.get("eventProcessingMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("eventProcessingMode").isString() != null ? Enum.valueOf(EventProcessingOption.class, obj.get("eventProcessingMode").isString().stringValue()) : null);
    }
    if ((obj.containsKey("kSessions")) && (!obj.get("kSessions").isNull())) {
      a1.setAssumedElementType("org.kie.workbench.common.services.shared.kmodule.KSessionModel");
      _$1953508384__65821278_kSessions(entity, java_util_List.demarshall(obj.get("kSessions"), a1));
    }
    if ((obj.containsKey("includes")) && (!obj.get("includes").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1953508384__65821278_includes(entity, java_util_List.demarshall(obj.get("includes"), a1));
    }
    if ((obj.containsKey("theDefault")) && (!obj.get("theDefault").isNull())) {
      _$1953508384__64711720_theDefault(entity, java_lang_Boolean.demarshall(obj.get("theDefault"), a1));
    }
    if ((obj.containsKey("scope")) && (!obj.get("scope").isNull())) {
      entity.setScope(java_lang_String.demarshall(obj.get("scope"), a1));
    }
    if ((obj.containsKey("packages")) && (!obj.get("packages").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1953508384__65821278_packages(entity, java_util_List.demarshall(obj.get("packages"), a1));
    }
    if ((obj.containsKey("declarativeAgenda")) && (!obj.get("declarativeAgenda").isNull())) {
      entity.setDeclarativeAgenda(obj.get("declarativeAgenda").isObject() != null ? Enum.valueOf(DeclarativeAgendaOption.class, obj.get("declarativeAgenda").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("declarativeAgenda").isString() != null ? Enum.valueOf(DeclarativeAgendaOption.class, obj.get("declarativeAgenda").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(KBaseModel a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.KBaseModel\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"equalsBehavior\":").append(a0.getEqualsBehavior() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.AssertBehaviorOption\",\"^EnumStringValue\":\"").append(a0.getEqualsBehavior().name()).append("\"}") : "null").append(",").append("\"eventProcessingMode\":").append(a0.getEventProcessingMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.EventProcessingOption\",\"^EnumStringValue\":\"").append(a0.getEventProcessingMode().name()).append("\"}") : "null").append(",").append("\"kSessions\":").append(java_util_List.marshall(a0.getKSessions(), a1)).append(",").append("\"includes\":").append(java_util_List.marshall(a0.getIncludes(), a1)).append(",").append("\"theDefault\":").append(java_lang_Boolean.marshall(_$1953508384__64711720_theDefault(a0), a1)).append(",").append("\"scope\":").append(java_lang_String.marshall(a0.getScope(), a1)).append(",").append("\"packages\":").append(java_util_List.marshall(a0.getPackages(), a1)).append(",").append("\"declarativeAgenda\":").append(a0.getDeclarativeAgenda() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.workbench.common.services.shared.kmodule.DeclarativeAgendaOption\",\"^EnumStringValue\":\"").append(a0.getDeclarativeAgenda().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_workbench_common_services_shared_kmodule_AssertBehaviorOption == null) {
      org_kie_workbench_common_services_shared_kmodule_AssertBehaviorOption = Marshalling.getMarshaller(AssertBehaviorOption.class);
    }
    if (org_kie_workbench_common_services_shared_kmodule_EventProcessingOption == null) {
      org_kie_workbench_common_services_shared_kmodule_EventProcessingOption = Marshalling.getMarshaller(EventProcessingOption.class);
    }
    if (org_kie_workbench_common_services_shared_kmodule_DeclarativeAgendaOption == null) {
      org_kie_workbench_common_services_shared_kmodule_DeclarativeAgendaOption = Marshalling.getMarshaller(DeclarativeAgendaOption.class);
    }
  }
}