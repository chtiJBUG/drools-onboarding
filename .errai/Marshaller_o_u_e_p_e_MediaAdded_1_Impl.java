package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.plugin.event.MediaAdded;
import org.uberfire.ext.plugin.model.Media;

public class Marshaller_o_u_e_p_e_MediaAdded_1_Impl implements GeneratedMarshaller<MediaAdded> {
  private MediaAdded[] EMPTY_ARRAY = new MediaAdded[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Media> org_uberfire_ext_plugin_model_Media = null;
  public MediaAdded[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public MediaAdded demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(MediaAdded.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("pluginName"), a1);
    final Media c1 = org_uberfire_ext_plugin_model_Media.demarshall(obj.get("media"), a1);
    MediaAdded entity = new MediaAdded(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(MediaAdded a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.plugin.event.MediaAdded\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pluginName\":").append(java_lang_String.marshall(a0.getPluginName(), a1)).append(",").append("\"media\":").append(org_uberfire_ext_plugin_model_Media.marshall(a0.getMedia(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_plugin_model_Media == null) {
      org_uberfire_ext_plugin_model_Media = Marshalling.getMarshaller(Media.class);
    }
  }
}