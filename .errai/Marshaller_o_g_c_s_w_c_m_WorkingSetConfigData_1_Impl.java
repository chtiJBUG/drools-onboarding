package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.List;
import org.guvnor.common.services.workingset.client.factconstraints.ConstraintConfiguration;
import org.guvnor.common.services.workingset.client.factconstraints.customform.CustomFormConfiguration;
import org.guvnor.common.services.workingset.client.model.WorkingSetConfigData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_g_c_s_w_c_m_WorkingSetConfigData_1_Impl implements GeneratedMarshaller<WorkingSetConfigData> {
  private WorkingSetConfigData[] EMPTY_ARRAY = new WorkingSetConfigData[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  private Marshaller<WorkingSetConfigData[]> arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1 = null;
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  abstract class Marshaller_for_arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1 implements GeneratedMarshaller { }
  public WorkingSetConfigData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1620103152__1195259493_name(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::name;
  }-*/;

  private native static void _$1620103152__1195259493_name(WorkingSetConfigData instance, String value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::name = value;
  }-*/;

  private native static String _$1620103152__1195259493_description(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::description;
  }-*/;

  private native static void _$1620103152__1195259493_description(WorkingSetConfigData instance, String value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::description = value;
  }-*/;

  private native static List _$1620103152__65821278_constraints(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::constraints;
  }-*/;

  private native static void _$1620103152__65821278_constraints(WorkingSetConfigData instance, List<ConstraintConfiguration> value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::constraints = value;
  }-*/;

  private native static List _$1620103152__65821278_customForms(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::customForms;
  }-*/;

  private native static void _$1620103152__65821278_customForms(WorkingSetConfigData instance, List<CustomFormConfiguration> value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::customForms = value;
  }-*/;

  private native static String[] _$1620103152__392722245_validFacts(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::validFacts;
  }-*/;

  private native static void _$1620103152__392722245_validFacts(WorkingSetConfigData instance, String[] value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::validFacts = value;
  }-*/;

  private native static WorkingSetConfigData[] _$1620103152__$869796740_workingSets(WorkingSetConfigData instance) /*-{
    return instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::workingSets;
  }-*/;

  private native static void _$1620103152__$869796740_workingSets(WorkingSetConfigData instance, WorkingSetConfigData[] value) /*-{
    instance.@org.guvnor.common.services.workingset.client.model.WorkingSetConfigData::workingSets = value;
  }-*/;

  public WorkingSetConfigData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(WorkingSetConfigData.class, objId);
    }
    WorkingSetConfigData entity = new WorkingSetConfigData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$1620103152__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      _$1620103152__1195259493_description(entity, java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("constraints")) && (!obj.get("constraints").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.workingset.client.factconstraints.ConstraintConfiguration");
      _$1620103152__65821278_constraints(entity, java_util_List.demarshall(obj.get("constraints"), a1));
    }
    if ((obj.containsKey("customForms")) && (!obj.get("customForms").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.workingset.client.factconstraints.customform.CustomFormConfiguration");
      _$1620103152__65821278_customForms(entity, java_util_List.demarshall(obj.get("customForms"), a1));
    }
    if ((obj.containsKey("validFacts")) && (!obj.get("validFacts").isNull())) {
      _$1620103152__392722245_validFacts(entity, arrayOf_java_lang_String_D1.demarshall(obj.get("validFacts"), a1));
    }
    if ((obj.containsKey("workingSets")) && (!obj.get("workingSets").isNull())) {
      _$1620103152__$869796740_workingSets(entity, arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1.demarshall(obj.get("workingSets"), a1));
    }
    return entity;
  }

  public String marshall(WorkingSetConfigData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.workingset.client.model.WorkingSetConfigData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"constraints\":").append(java_util_List.marshall(a0.getConstraints(), a1)).append(",").append("\"customForms\":").append(java_util_List.marshall(a0.getCustomForms(), a1)).append(",").append("\"validFacts\":").append(arrayOf_java_lang_String_D1.marshall(a0.getValidFacts(), a1)).append(",").append("\"workingSets\":").append(arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1.marshall(a0.getWorkingSets(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1 == null) {
      arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1 = Marshalling.getMarshaller(WorkingSetConfigData[].class, new DeferredMarshallerCreationCallback<WorkingSetConfigData[]>() {
        public Marshaller<WorkingSetConfigData[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_org_guvnor_common_services_workingset_client_model_WorkingSetConfigData_D1.class), WorkingSetConfigData[].class);
        }
      });
    }
  }
}