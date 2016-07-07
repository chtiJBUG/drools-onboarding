package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.workitems.PortableStringParameterDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_w_PortableStringParameterDefinition_1_Impl implements GeneratedMarshaller<PortableStringParameterDefinition> {
  private PortableStringParameterDefinition[] EMPTY_ARRAY = new PortableStringParameterDefinition[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public PortableStringParameterDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PortableStringParameterDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableStringParameterDefinition.class, objId);
    }
    PortableStringParameterDefinition entity = new PortableStringParameterDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      entity.setBinding(java_lang_String.demarshall(obj.get("binding"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(PortableStringParameterDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.workitems.PortableStringParameterDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}