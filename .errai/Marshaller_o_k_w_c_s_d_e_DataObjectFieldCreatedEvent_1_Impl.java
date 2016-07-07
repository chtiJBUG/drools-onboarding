package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.Project;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.datamodeller.events.DataObjectFieldCreatedEvent;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.kie.workbench.common.services.datamodeller.core.ObjectProperty;

public class Marshaller_o_k_w_c_s_d_e_DataObjectFieldCreatedEvent_1_Impl implements GeneratedMarshaller<DataObjectFieldCreatedEvent> {
  private DataObjectFieldCreatedEvent[] EMPTY_ARRAY = new DataObjectFieldCreatedEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public DataObjectFieldCreatedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataObjectFieldCreatedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataObjectFieldCreatedEvent.class, objId);
    }
    DataObjectFieldCreatedEvent entity = new DataObjectFieldCreatedEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("currentDataObject")) && (!obj.get("currentDataObject").isNull())) {
      entity.setCurrentDataObject((DataObject) ((ObjectMarshaller) java_lang_Object).demarshall(DataObject.class, obj.get("currentDataObject"), a1));
    }
    if ((obj.containsKey("currentField")) && (!obj.get("currentField").isNull())) {
      entity.setCurrentField((ObjectProperty) ((ObjectMarshaller) java_lang_Object).demarshall(ObjectProperty.class, obj.get("currentField"), a1));
    }
    if ((obj.containsKey("currentProject")) && (!obj.get("currentProject").isNull())) {
      entity.setCurrentProject((Project) ((ObjectMarshaller) java_lang_Object).demarshall(Project.class, obj.get("currentProject"), a1));
    }
    if ((obj.containsKey("source")) && (!obj.get("source").isNull())) {
      entity.setSource(java_lang_String.demarshall(obj.get("source"), a1));
    }
    if ((obj.containsKey("contextId")) && (!obj.get("contextId").isNull())) {
      entity.setContextId(java_lang_String.demarshall(obj.get("contextId"), a1));
    }
    return entity;
  }

  public String marshall(DataObjectFieldCreatedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.datamodeller.events.DataObjectFieldCreatedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"currentDataObject\":").append(java_lang_Object.marshall(a0.getCurrentDataObject(), a1)).append(",").append("\"currentField\":").append(java_lang_Object.marshall(a0.getCurrentField(), a1)).append(",").append("\"currentProject\":").append(java_lang_Object.marshall(a0.getCurrentProject(), a1)).append(",").append("\"source\":").append(java_lang_String.marshall(a0.getSource(), a1)).append(",").append("\"contextId\":").append(java_lang_String.marshall(a0.getContextId(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}