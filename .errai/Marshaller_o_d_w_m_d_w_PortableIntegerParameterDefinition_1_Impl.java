package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.workitems.PortableIntegerParameterDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_w_PortableIntegerParameterDefinition_1_Impl implements GeneratedMarshaller<PortableIntegerParameterDefinition> {
  private PortableIntegerParameterDefinition[] EMPTY_ARRAY = new PortableIntegerParameterDefinition[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public PortableIntegerParameterDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PortableIntegerParameterDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableIntegerParameterDefinition.class, objId);
    }
    PortableIntegerParameterDefinition entity = new PortableIntegerParameterDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      entity.setBinding(java_lang_String.demarshall(obj.get("binding"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_Integer.demarshall(obj.get("value"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(PortableIntegerParameterDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.workitems.PortableIntegerParameterDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"value\":").append(java_lang_Integer.marshall(a0.getValue(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}