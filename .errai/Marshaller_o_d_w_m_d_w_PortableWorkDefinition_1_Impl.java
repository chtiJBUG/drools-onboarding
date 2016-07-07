package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.workitems.PortableParameterDefinition;
import org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_w_PortableWorkDefinition_1_Impl implements GeneratedMarshaller<PortableWorkDefinition> {
  private PortableWorkDefinition[] EMPTY_ARRAY = new PortableWorkDefinition[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public PortableWorkDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _558855891__$1383349348_parameters(PortableWorkDefinition instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition::parameters;
  }-*/;

  private native static void _558855891__$1383349348_parameters(PortableWorkDefinition instance, Map<String, PortableParameterDefinition> value) /*-{
    instance.@org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition::parameters = value;
  }-*/;

  private native static Map _558855891__$1383349348_results(PortableWorkDefinition instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition::results;
  }-*/;

  private native static void _558855891__$1383349348_results(PortableWorkDefinition instance, Map<String, PortableParameterDefinition> value) /*-{
    instance.@org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition::results = value;
  }-*/;

  public PortableWorkDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableWorkDefinition.class, objId);
    }
    PortableWorkDefinition entity = new PortableWorkDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("displayName")) && (!obj.get("displayName").isNull())) {
      entity.setDisplayName(java_lang_String.demarshall(obj.get("displayName"), a1));
    }
    if ((obj.containsKey("parameters")) && (!obj.get("parameters").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.drools.workbench.models.datamodel.workitems.PortableParameterDefinition");
      _558855891__$1383349348_parameters(entity, java_util_Map.demarshall(obj.get("parameters"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("results")) && (!obj.get("results").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("org.drools.workbench.models.datamodel.workitems.PortableParameterDefinition");
      _558855891__$1383349348_results(entity, java_util_Map.demarshall(obj.get("results"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(PortableWorkDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.workitems.PortableWorkDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"displayName\":").append(java_lang_String.marshall(a0.getDisplayName(), a1)).append(",").append("\"parameters\":").append(java_util_Map.marshall(_558855891__$1383349348_parameters(a0), a1)).append(",").append("\"results\":").append(java_util_Map.marshall(_558855891__$1383349348_results(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}