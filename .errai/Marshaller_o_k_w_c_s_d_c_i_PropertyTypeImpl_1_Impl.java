package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.workbench.common.services.datamodeller.core.impl.PropertyTypeImpl;

public class Marshaller_o_k_w_c_s_d_c_i_PropertyTypeImpl_1_Impl implements GeneratedMarshaller<PropertyTypeImpl> {
  private PropertyTypeImpl[] EMPTY_ARRAY = new PropertyTypeImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public PropertyTypeImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public PropertyTypeImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PropertyTypeImpl.class, objId);
    }
    PropertyTypeImpl entity = new PropertyTypeImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("className")) && (!obj.get("className").isNull())) {
      entity.setClassName(java_lang_String.demarshall(obj.get("className"), a1));
    }
    return entity;
  }

  public String marshall(PropertyTypeImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.services.datamodeller.core.impl.PropertyTypeImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"className\":").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}