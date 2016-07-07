package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.Fact;
import org.drools.workbench.models.testscenarios.shared.FactAssignmentField;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_t_s_FactAssignmentField_1_Impl implements GeneratedMarshaller<FactAssignmentField> {
  private FactAssignmentField[] EMPTY_ARRAY = new FactAssignmentField[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public FactAssignmentField[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$284299429__1195259493_fieldName(FactAssignmentField instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.FactAssignmentField::fieldName;
  }-*/;

  private native static void _$284299429__1195259493_fieldName(FactAssignmentField instance, String value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.FactAssignmentField::fieldName = value;
  }-*/;

  public FactAssignmentField demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FactAssignmentField.class, objId);
    }
    FactAssignmentField entity = new FactAssignmentField();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fieldName")) && (!obj.get("fieldName").isNull())) {
      _$284299429__1195259493_fieldName(entity, java_lang_String.demarshall(obj.get("fieldName"), a1));
    }
    if ((obj.containsKey("fact")) && (!obj.get("fact").isNull())) {
      entity.setFact((Fact) ((ObjectMarshaller) java_lang_Object).demarshall(Fact.class, obj.get("fact"), a1));
    }
    return entity;
  }

  public String marshall(FactAssignmentField a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.FactAssignmentField\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fieldName\":").append(java_lang_String.marshall(_$284299429__1195259493_fieldName(a0), a1)).append(",").append("\"fact\":").append(java_lang_Object.marshall(a0.getFact(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}