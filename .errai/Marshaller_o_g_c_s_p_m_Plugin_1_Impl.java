package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.common.services.project.model.Plugin;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_Plugin_1_Impl implements GeneratedMarshaller<Plugin> {
  private Plugin[] EMPTY_ARRAY = new Plugin[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public Plugin[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public Plugin demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Plugin.class, objId);
    }
    Plugin entity = new Plugin();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dependencies")) && (!obj.get("dependencies").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Dependency");
      entity.setDependencies(java_util_List.demarshall(obj.get("dependencies"), a1));
    }
    if ((obj.containsKey("groupId")) && (!obj.get("groupId").isNull())) {
      entity.setGroupId(java_lang_String.demarshall(obj.get("groupId"), a1));
    }
    if ((obj.containsKey("artifactId")) && (!obj.get("artifactId").isNull())) {
      entity.setArtifactId(java_lang_String.demarshall(obj.get("artifactId"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      entity.setVersion(java_lang_String.demarshall(obj.get("version"), a1));
    }
    if ((obj.containsKey("extensions")) && (!obj.get("extensions").isNull())) {
      entity.setExtensions(java_lang_Boolean.demarshall(obj.get("extensions"), a1));
    }
    return entity;
  }

  private native static boolean _$1271929995__64711720_extensions(Plugin instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Plugin::extensions;
  }-*/;

  private native static void _$1271929995__64711720_extensions(Plugin instance, boolean value) /*-{
    instance.@org.guvnor.common.services.project.model.Plugin::extensions = value;
  }-*/;

  public String marshall(Plugin a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Plugin\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dependencies\":").append(java_util_List.marshall(a0.getDependencies(), a1)).append(",").append("\"groupId\":").append(java_lang_String.marshall(a0.getGroupId(), a1)).append(",").append("\"artifactId\":").append(java_lang_String.marshall(a0.getArtifactId(), a1)).append(",").append("\"version\":").append(java_lang_String.marshall(a0.getVersion(), a1)).append(",").append("\"extensions\":").append(java_lang_Boolean.marshall(_$1271929995__64711720_extensions(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}