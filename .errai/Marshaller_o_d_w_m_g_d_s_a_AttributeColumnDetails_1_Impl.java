package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.AttributeColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_AttributeColumnDetails_1_Impl implements GeneratedMarshaller<AttributeColumnDetails> {
  private AttributeColumnDetails[] EMPTY_ARRAY = new AttributeColumnDetails[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public AttributeColumnDetails[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1588640080__1195259493_attribute(AttributeColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.AttributeColumnDetails::attribute;
  }-*/;

  private native static void _1588640080__1195259493_attribute(AttributeColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.AttributeColumnDetails::attribute = value;
  }-*/;

  private native static String _$493965940__1195259493_columnHeader(ColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader;
  }-*/;

  private native static void _$493965940__1195259493_columnHeader(ColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader = value;
  }-*/;

  public AttributeColumnDetails demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AttributeColumnDetails.class, objId);
    }
    AttributeColumnDetails entity = new AttributeColumnDetails();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("attribute")) && (!obj.get("attribute").isNull())) {
      _1588640080__1195259493_attribute(entity, java_lang_String.demarshall(obj.get("attribute"), a1));
    }
    if ((obj.containsKey("columnHeader")) && (!obj.get("columnHeader").isNull())) {
      _$493965940__1195259493_columnHeader(entity, java_lang_String.demarshall(obj.get("columnHeader"), a1));
    }
    return entity;
  }

  public String marshall(AttributeColumnDetails a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.AttributeColumnDetails\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"attribute\":").append(java_lang_String.marshall(a0.getAttribute(), a1)).append(",").append("\"columnHeader\":").append(java_lang_String.marshall(a0.getColumnHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}