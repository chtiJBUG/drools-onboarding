package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.workitems.PortableObjectParameterDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_w_PortableObjectParameterDefinition_1_Impl implements GeneratedMarshaller<PortableObjectParameterDefinition> {
  private PortableObjectParameterDefinition[] EMPTY_ARRAY = new PortableObjectParameterDefinition[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public PortableObjectParameterDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PortableObjectParameterDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableObjectParameterDefinition.class, objId);
    }
    PortableObjectParameterDefinition entity = new PortableObjectParameterDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      entity.setBinding(java_lang_String.demarshall(obj.get("binding"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(PortableObjectParameterDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.workitems.PortableObjectParameterDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}