package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.drools.workbench.models.datamodel.oracle.DropDownData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_d_w_m_d_o_DropDownData_1_Impl implements GeneratedMarshaller<DropDownData> {
  private DropDownData[] EMPTY_ARRAY = new DropDownData[0];
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  public DropDownData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String[] _689600566__392722245_fixedList(DropDownData instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::fixedList;
  }-*/;

  private native static void _689600566__392722245_fixedList(DropDownData instance, String[] value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::fixedList = value;
  }-*/;

  private native static String _689600566__1195259493_queryExpression(DropDownData instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::queryExpression;
  }-*/;

  private native static void _689600566__1195259493_queryExpression(DropDownData instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::queryExpression = value;
  }-*/;

  private native static String[] _689600566__392722245_valuePairs(DropDownData instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::valuePairs;
  }-*/;

  private native static void _689600566__392722245_valuePairs(DropDownData instance, String[] value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.DropDownData::valuePairs = value;
  }-*/;

  public DropDownData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DropDownData.class, objId);
    }
    DropDownData entity = new DropDownData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("fixedList")) && (!obj.get("fixedList").isNull())) {
      _689600566__392722245_fixedList(entity, arrayOf_java_lang_String_D1.demarshall(obj.get("fixedList"), a1));
    }
    if ((obj.containsKey("queryExpression")) && (!obj.get("queryExpression").isNull())) {
      _689600566__1195259493_queryExpression(entity, java_lang_String.demarshall(obj.get("queryExpression"), a1));
    }
    if ((obj.containsKey("valuePairs")) && (!obj.get("valuePairs").isNull())) {
      _689600566__392722245_valuePairs(entity, arrayOf_java_lang_String_D1.demarshall(obj.get("valuePairs"), a1));
    }
    return entity;
  }

  public String marshall(DropDownData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.DropDownData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"fixedList\":").append(arrayOf_java_lang_String_D1.marshall(a0.getFixedList(), a1)).append(",").append("\"queryExpression\":").append(java_lang_String.marshall(a0.getQueryExpression(), a1)).append(",").append("\"valuePairs\":").append(arrayOf_java_lang_String_D1.marshall(a0.getValuePairs(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}