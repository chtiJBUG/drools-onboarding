package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.testscenarios.shared.FactData;
import org.drools.workbench.models.testscenarios.shared.Fixture;
import org.drools.workbench.models.testscenarios.shared.Scenario;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_Scenario_1_Impl implements GeneratedMarshaller<Scenario> {
  private Scenario[] EMPTY_ARRAY = new Scenario[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<Imports> org_drools_workbench_models_datamodel_imports_Imports = null;
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public Scenario[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static int _$1014422890__104431_maxRuleFirings(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::maxRuleFirings;
  }-*/;

  private native static void _$1014422890__104431_maxRuleFirings(Scenario instance, int value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::maxRuleFirings = value;
  }-*/;

  private native static List _$1014422890__65821278_globals(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::globals;
  }-*/;

  private native static void _$1014422890__65821278_globals(Scenario instance, List<FactData> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::globals = value;
  }-*/;

  private native static List _$1014422890__65821278_fixtures(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::fixtures;
  }-*/;

  private native static void _$1014422890__65821278_fixtures(Scenario instance, List<Fixture> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::fixtures = value;
  }-*/;

  private native static List _$1014422890__65821278_rules(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::rules;
  }-*/;

  private native static void _$1014422890__65821278_rules(Scenario instance, List<String> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::rules = value;
  }-*/;

  private native static ArrayList _$1014422890__$1114099497_ksessions(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::ksessions;
  }-*/;

  private native static void _$1014422890__$1114099497_ksessions(Scenario instance, ArrayList<String> value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::ksessions = value;
  }-*/;

  public Scenario demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Scenario.class, objId);
    }
    Scenario entity = new Scenario();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("maxRuleFirings")) && (!obj.get("maxRuleFirings").isNull())) {
      _$1014422890__104431_maxRuleFirings(entity, java_lang_Integer.demarshall(obj.get("maxRuleFirings"), a1));
    }
    if ((obj.containsKey("globals")) && (!obj.get("globals").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.FactData");
      _$1014422890__65821278_globals(entity, java_util_List.demarshall(obj.get("globals"), a1));
    }
    if ((obj.containsKey("fixtures")) && (!obj.get("fixtures").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.Fixture");
      _$1014422890__65821278_fixtures(entity, java_util_List.demarshall(obj.get("fixtures"), a1));
    }
    if ((obj.containsKey("lastRunResult")) && (!obj.get("lastRunResult").isNull())) {
      entity.setLastRunResult(java_util_Date.demarshall(obj.get("lastRunResult"), a1));
    }
    if ((obj.containsKey("rules")) && (!obj.get("rules").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1014422890__65821278_rules(entity, java_util_List.demarshall(obj.get("rules"), a1));
    }
    if ((obj.containsKey("inclusive")) && (!obj.get("inclusive").isNull())) {
      entity.setInclusive(java_lang_Boolean.demarshall(obj.get("inclusive"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      entity.setPackageName(java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      entity.setImports(org_drools_workbench_models_datamodel_imports_Imports.demarshall(obj.get("imports"), a1));
    }
    if ((obj.containsKey("ksessions")) && (!obj.get("ksessions").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1014422890__$1114099497_ksessions(entity, java_util_ArrayList.demarshall(obj.get("ksessions"), a1));
    }
    return entity;
  }

  private native static boolean _$1014422890__64711720_inclusive(Scenario instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.Scenario::inclusive;
  }-*/;

  private native static void _$1014422890__64711720_inclusive(Scenario instance, boolean value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.Scenario::inclusive = value;
  }-*/;

  public String marshall(Scenario a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.Scenario\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"maxRuleFirings\":").append(java_lang_Integer.marshall(a0.getMaxRuleFirings(), a1)).append(",").append("\"globals\":").append(java_util_List.marshall(a0.getGlobals(), a1)).append(",").append("\"fixtures\":").append(java_util_List.marshall(a0.getFixtures(), a1)).append(",").append("\"lastRunResult\":").append(java_util_Date.marshall(a0.getLastRunResult(), a1)).append(",").append("\"rules\":").append(java_util_List.marshall(a0.getRules(), a1)).append(",").append("\"inclusive\":").append(java_lang_Boolean.marshall(_$1014422890__64711720_inclusive(a0), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"imports\":").append(org_drools_workbench_models_datamodel_imports_Imports.marshall(a0.getImports(), a1)).append(",").append("\"ksessions\":").append(java_util_ArrayList.marshall(_$1014422890__$1114099497_ksessions(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_imports_Imports == null) {
      org_drools_workbench_models_datamodel_imports_Imports = Marshalling.getMarshaller(Imports.class);
    }
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}