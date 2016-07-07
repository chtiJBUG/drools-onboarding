package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.bd.model.DeploymentUnitSummary;
import org.jbpm.console.ng.bd.model.KModuleDeploymentUnitSummary;

public class Marshaller_o_j_c_n_b_m_KModuleDeploymentUnitSummary_1_Impl implements GeneratedMarshaller<KModuleDeploymentUnitSummary> {
  private KModuleDeploymentUnitSummary[] EMPTY_ARRAY = new KModuleDeploymentUnitSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public KModuleDeploymentUnitSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public KModuleDeploymentUnitSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(KModuleDeploymentUnitSummary.class, objId);
    }
    KModuleDeploymentUnitSummary entity = new KModuleDeploymentUnitSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("groupId")) && (!obj.get("groupId").isNull())) {
      entity.setGroupId(java_lang_String.demarshall(obj.get("groupId"), a1));
    }
    if ((obj.containsKey("artifactId")) && (!obj.get("artifactId").isNull())) {
      entity.setArtifactId(java_lang_String.demarshall(obj.get("artifactId"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("kbaseName")) && (!obj.get("kbaseName").isNull())) {
      entity.setKbaseName(java_lang_String.demarshall(obj.get("kbaseName"), a1));
    }
    if ((obj.containsKey("ksessionName")) && (!obj.get("ksessionName").isNull())) {
      entity.setKsessionName(java_lang_String.demarshall(obj.get("ksessionName"), a1));
    }
    if ((obj.containsKey("strategy")) && (!obj.get("strategy").isNull())) {
      entity.setStrategy(java_lang_String.demarshall(obj.get("strategy"), a1));
    }
    if ((obj.containsKey("mergeMode")) && (!obj.get("mergeMode").isNull())) {
      entity.setMergeMode(java_lang_String.demarshall(obj.get("mergeMode"), a1));
    }
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

  public String marshall(KModuleDeploymentUnitSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.KModuleDeploymentUnitSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"groupId\":").append(java_lang_String.marshall(a0.getGroupId(), a1)).append(",").append("\"artifactId\":").append(java_lang_String.marshall(a0.getArtifactId(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append(",").append("\"kbaseName\":").append(java_lang_String.marshall(a0.getKbaseName(), a1)).append(",").append("\"ksessionName\":").append(java_lang_String.marshall(a0.getKsessionName(), a1)).append(",").append("\"strategy\":").append(java_lang_String.marshall(a0.getStrategy(), a1)).append(",").append("\"mergeMode\":").append(java_lang_String.marshall(a0.getMergeMode(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"active\":").append(java_lang_Boolean.marshall(_1558693755__64711720_active(a0), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}