package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.workitems.PortableEnumParameterDefinition;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_w_PortableEnumParameterDefinition_1_Impl implements GeneratedMarshaller<PortableEnumParameterDefinition> {
  private PortableEnumParameterDefinition[] EMPTY_ARRAY = new PortableEnumParameterDefinition[0];
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  public PortableEnumParameterDefinition[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PortableEnumParameterDefinition demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableEnumParameterDefinition.class, objId);
    }
    PortableEnumParameterDefinition entity = new PortableEnumParameterDefinition();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("values")) && (!obj.get("values").isNull())) {
      entity.setValues(arrayOf_java_lang_String_D1.demarshall(obj.get("values"), a1));
    }
    if ((obj.containsKey("value")) && (!obj.get("value").isNull())) {
      entity.setValue(java_lang_String.demarshall(obj.get("value"), a1));
    }
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

  public String marshall(PortableEnumParameterDefinition a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.workitems.PortableEnumParameterDefinition\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"values\":").append(arrayOf_java_lang_String_D1.marshall(a0.getValues(), a1)).append(",").append("\"value\":").append(java_lang_String.marshall(a0.getValue(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}