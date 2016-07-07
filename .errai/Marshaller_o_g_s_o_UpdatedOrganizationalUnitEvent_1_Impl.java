package org.jboss.errai.marshalling.client.api;

import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.organizationalunit.UpdatedOrganizationalUnitEvent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_o_UpdatedOrganizationalUnitEvent_1_Impl implements GeneratedMarshaller<UpdatedOrganizationalUnitEvent> {
  private UpdatedOrganizationalUnitEvent[] EMPTY_ARRAY = new UpdatedOrganizationalUnitEvent[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public UpdatedOrganizationalUnitEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public UpdatedOrganizationalUnitEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UpdatedOrganizationalUnitEvent.class, objId);
    }
    UpdatedOrganizationalUnitEvent entity = new UpdatedOrganizationalUnitEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("organizationalUnit")) && (!obj.get("organizationalUnit").isNull())) {
      entity.setOrganizationalUnit((OrganizationalUnit) ((ObjectMarshaller) java_lang_Object).demarshall(OrganizationalUnit.class, obj.get("organizationalUnit"), a1));
    }
    if ((obj.containsKey("userName")) && (!obj.get("userName").isNull())) {
      entity.setUserName(java_lang_String.demarshall(obj.get("userName"), a1));
    }
    return entity;
  }

  public String marshall(UpdatedOrganizationalUnitEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.organizationalunit.UpdatedOrganizationalUnitEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"organizationalUnit\":").append(java_lang_Object.marshall(a0.getOrganizationalUnit(), a1)).append(",").append("\"userName\":").append(java_lang_String.marshall(a0.getUserName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}