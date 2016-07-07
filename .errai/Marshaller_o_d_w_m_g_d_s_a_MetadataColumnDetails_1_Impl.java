package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails;
import org.drools.workbench.models.guided.dtable.shared.auditlog.MetadataColumnDetails;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_MetadataColumnDetails_1_Impl implements GeneratedMarshaller<MetadataColumnDetails> {
  private MetadataColumnDetails[] EMPTY_ARRAY = new MetadataColumnDetails[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public MetadataColumnDetails[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1459406493__1195259493_metadata(MetadataColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.MetadataColumnDetails::metadata;
  }-*/;

  private native static void _1459406493__1195259493_metadata(MetadataColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.MetadataColumnDetails::metadata = value;
  }-*/;

  private native static String _$493965940__1195259493_columnHeader(ColumnDetails instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader;
  }-*/;

  private native static void _$493965940__1195259493_columnHeader(ColumnDetails instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.auditlog.ColumnDetails::columnHeader = value;
  }-*/;

  public MetadataColumnDetails demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(MetadataColumnDetails.class, objId);
    }
    MetadataColumnDetails entity = new MetadataColumnDetails();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("metadata")) && (!obj.get("metadata").isNull())) {
      _1459406493__1195259493_metadata(entity, java_lang_String.demarshall(obj.get("metadata"), a1));
    }
    if ((obj.containsKey("columnHeader")) && (!obj.get("columnHeader").isNull())) {
      _$493965940__1195259493_columnHeader(entity, java_lang_String.demarshall(obj.get("columnHeader"), a1));
    }
    return entity;
  }

  public String marshall(MetadataColumnDetails a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.MetadataColumnDetails\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"metadata\":").append(java_lang_String.marshall(a0.getMetadata(), a1)).append(",").append("\"columnHeader\":").append(java_lang_String.marshall(a0.getColumnHeader(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}