package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.bd.model.DeploymentUnitSummary;

public class Marshaller_o_j_c_n_b_m_DeploymentUnitSummary_1_Impl implements GeneratedMarshaller<DeploymentUnitSummary> {
  private DeploymentUnitSummary[] EMPTY_ARRAY = new DeploymentUnitSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DeploymentUnitSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DeploymentUnitSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DeploymentUnitSummary.class, objId);
    }
    DeploymentUnitSummary entity = new DeploymentUnitSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("active")) && (!obj.get("active").isNull())) {
      entity.setActive(java_lang_Boolean.demarshall(obj.get("active"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  private native static boolean _1558693755__64711720_active(DeploymentUnitSummary instance) /*-{
    return instance.@org.jbpm.console.ng.bd.model.DeploymentUnitSummary::active;
  }-*/;

  private native static void _1558693755__64711720_active(DeploymentUnitSummary instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.bd.model.DeploymentUnitSummary::active = value;
  }-*/;

  public String marshall(DeploymentUnitSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.DeploymentUnitSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"active\":").append(java_lang_Boolean.marshall(_1558693755__64711720_active(a0), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}