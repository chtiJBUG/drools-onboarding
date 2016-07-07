package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jbpm.console.ng.ga.model.DataMockSummary;

public class Marshaller_o_j_c_n_g_m_DataMockSummary_1_Impl implements GeneratedMarshaller<DataMockSummary> {
  private DataMockSummary[] EMPTY_ARRAY = new DataMockSummary[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public DataMockSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataMockSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DataMockSummary.class, objId);
    }
    DataMockSummary entity = new DataMockSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_String.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("column1")) && (!obj.get("column1").isNull())) {
      entity.setColumn1(java_lang_String.demarshall(obj.get("column1"), a1));
    }
    if ((obj.containsKey("column2")) && (!obj.get("column2").isNull())) {
      entity.setColumn2(java_lang_String.demarshall(obj.get("column2"), a1));
    }
    if ((obj.containsKey("column3")) && (!obj.get("column3").isNull())) {
      entity.setColumn3(java_lang_String.demarshall(obj.get("column3"), a1));
    }
    if ((obj.containsKey("column4")) && (!obj.get("column4").isNull())) {
      entity.setColumn4(java_lang_String.demarshall(obj.get("column4"), a1));
    }
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(((ObjectMarshaller) java_lang_Object).demarshall(Object.class, obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(DataMockSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.model.DataMockSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_String.marshall(a0.getId(), a1)).append(",").append("\"column1\":").append(java_lang_String.marshall(a0.getColumn1(), a1)).append(",").append("\"column2\":").append(java_lang_String.marshall(a0.getColumn2(), a1)).append(",").append("\"column3\":").append(java_lang_String.marshall(a0.getColumn3(), a1)).append(",").append("\"column4\":").append(java_lang_String.marshall(a0.getColumn4(), a1)).append(",").append("\"id\":").append(java_lang_Object.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}