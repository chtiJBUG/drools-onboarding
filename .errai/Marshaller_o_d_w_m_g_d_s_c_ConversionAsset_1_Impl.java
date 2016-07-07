package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_c_ConversionAsset_1_Impl implements GeneratedMarshaller<ConversionAsset> {
  private ConversionAsset[] EMPTY_ARRAY = new ConversionAsset[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ConversionAsset[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$764919993__1195259493_uuid(ConversionAsset instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset::uuid;
  }-*/;

  private native static void _$764919993__1195259493_uuid(ConversionAsset instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset::uuid = value;
  }-*/;

  private native static String _$764919993__1195259493_format(ConversionAsset instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset::format;
  }-*/;

  private native static void _$764919993__1195259493_format(ConversionAsset instance, String value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset::format = value;
  }-*/;

  public ConversionAsset demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ConversionAsset.class, objId);
    }
    ConversionAsset entity = new ConversionAsset();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("uuid")) && (!obj.get("uuid").isNull())) {
      _$764919993__1195259493_uuid(entity, java_lang_String.demarshall(obj.get("uuid"), a1));
    }
    if ((obj.containsKey("format")) && (!obj.get("format").isNull())) {
      _$764919993__1195259493_format(entity, java_lang_String.demarshall(obj.get("format"), a1));
    }
    return entity;
  }

  public String marshall(ConversionAsset a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"uuid\":").append(java_lang_String.marshall(a0.getUUID(), a1)).append(",").append("\"format\":").append(java_lang_String.marshall(a0.getFormat(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}