package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.workbench.model.ContextDefinition;
import org.uberfire.workbench.model.ContextDisplayMode;
import org.uberfire.workbench.model.PanelDefinition;
import org.uberfire.workbench.model.impl.PartDefinitionImpl;

public class Marshaller_o_u_w_m_i_PartDefinitionImpl_1_Impl implements GeneratedMarshaller<PartDefinitionImpl> {
  private PartDefinitionImpl[] EMPTY_ARRAY = new PartDefinitionImpl[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ContextDisplayMode> org_uberfire_workbench_model_ContextDisplayMode = null;
  public PartDefinitionImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PartDefinitionImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PartDefinitionImpl.class, objId);
    }
    PartDefinitionImpl entity = new PartDefinitionImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("place")) && (!obj.get("place").isNull())) {
      entity.setPlace((PlaceRequest) ((ObjectMarshaller) java_lang_Object).demarshall(PlaceRequest.class, obj.get("place"), a1));
    }
    if ((obj.containsKey("parentPanel")) && (!obj.get("parentPanel").isNull())) {
      entity.setParentPanel((PanelDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(PanelDefinition.class, obj.get("parentPanel"), a1));
    }
    if ((obj.containsKey("contextDefinition")) && (!obj.get("contextDefinition").isNull())) {
      entity.setContextDefinition((ContextDefinition) ((ObjectMarshaller) java_lang_Object).demarshall(ContextDefinition.class, obj.get("contextDefinition"), a1));
    }
    if ((obj.containsKey("contextDisplayMode")) && (!obj.get("contextDisplayMode").isNull())) {
      entity.setContextDisplayMode(obj.get("contextDisplayMode").isObject() != null ? Enum.valueOf(ContextDisplayMode.class, obj.get("contextDisplayMode").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("contextDisplayMode").isString() != null ? Enum.valueOf(ContextDisplayMode.class, obj.get("contextDisplayMode").isString().stringValue()) : null);
    }
    return entity;
  }

  public String marshall(PartDefinitionImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.model.impl.PartDefinitionImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"place\":").append(java_lang_Object.marshall(a0.getPlace(), a1)).append(",").append("\"parentPanel\":").append(java_lang_Object.marshall(a0.getParentPanel(), a1)).append(",").append("\"contextDefinition\":").append(java_lang_Object.marshall(a0.getContextDefinition(), a1)).append(",").append("\"contextDisplayMode\":").append(a0.getContextDisplayMode() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.workbench.model.ContextDisplayMode\",\"^EnumStringValue\":\"").append(a0.getContextDisplayMode().name()).append("\"}") : "null").append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_workbench_model_ContextDisplayMode == null) {
      org_uberfire_workbench_model_ContextDisplayMode = Marshalling.getMarshaller(ContextDisplayMode.class);
    }
  }
}