package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.imports.Import;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_i_Import_1_Impl implements GeneratedMarshaller<Import> {
  private Import[] EMPTY_ARRAY = new Import[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Import[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _85376826__1195259493_type(Import instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.imports.Import::type;
  }-*/;

  private native static void _85376826__1195259493_type(Import instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.imports.Import::type = value;
  }-*/;

  public Import demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Import.class, objId);
    }
    Import entity = new Import();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _85376826__1195259493_type(entity, java_lang_String.demarshall(obj.get("type"), a1));
    }
    return entity;
  }

  public String marshall(Import a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.imports.Import\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}