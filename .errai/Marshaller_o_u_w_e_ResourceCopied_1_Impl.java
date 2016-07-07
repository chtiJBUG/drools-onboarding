package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.workbench.events.ResourceCopied;

public class Marshaller_o_u_w_e_ResourceCopied_1_Impl implements GeneratedMarshaller<ResourceCopied> {
  private ResourceCopied[] EMPTY_ARRAY = new ResourceCopied[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public ResourceCopied[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public ResourceCopied demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ResourceCopied.class, objId);
    }
    final Path c0 = (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("destinationPath"), a1);
    final String c1 = java_lang_String.demarshall(obj.get("message"), a1);
    ResourceCopied entity = new ResourceCopied(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(ResourceCopied a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.workbench.events.ResourceCopied\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"destinationPath\":").append(java_lang_Object.marshall(a0.getDestinationPath(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}