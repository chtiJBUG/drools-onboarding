package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.structure.navigator.DataContent;
import org.guvnor.structure.navigator.NavigatorContent;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_s_n_NavigatorContent_1_Impl implements GeneratedMarshaller<NavigatorContent> {
  private NavigatorContent[] EMPTY_ARRAY = new NavigatorContent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public NavigatorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$82725745__1195259493_repoName(NavigatorContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.NavigatorContent::repoName;
  }-*/;

  private native static void _$82725745__1195259493_repoName(NavigatorContent instance, String value) /*-{
    instance.@org.guvnor.structure.navigator.NavigatorContent::repoName = value;
  }-*/;

  private native static Path _$82725745__$2084529122_root(NavigatorContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.NavigatorContent::root;
  }-*/;

  private native static void _$82725745__$2084529122_root(NavigatorContent instance, Path value) /*-{
    instance.@org.guvnor.structure.navigator.NavigatorContent::root = value;
  }-*/;

  private native static List _$82725745__65821278_breadcrumbs(NavigatorContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.NavigatorContent::breadcrumbs;
  }-*/;

  private native static void _$82725745__65821278_breadcrumbs(NavigatorContent instance, List<Path> value) /*-{
    instance.@org.guvnor.structure.navigator.NavigatorContent::breadcrumbs = value;
  }-*/;

  private native static List _$82725745__65821278_content(NavigatorContent instance) /*-{
    return instance.@org.guvnor.structure.navigator.NavigatorContent::content;
  }-*/;

  private native static void _$82725745__65821278_content(NavigatorContent instance, List<DataContent> value) /*-{
    instance.@org.guvnor.structure.navigator.NavigatorContent::content = value;
  }-*/;

  public NavigatorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NavigatorContent.class, objId);
    }
    NavigatorContent entity = new NavigatorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("repoName")) && (!obj.get("repoName").isNull())) {
      _$82725745__1195259493_repoName(entity, java_lang_String.demarshall(obj.get("repoName"), a1));
    }
    if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
      _$82725745__$2084529122_root(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("root"), a1));
    }
    if ((obj.containsKey("breadcrumbs")) && (!obj.get("breadcrumbs").isNull())) {
      a1.setAssumedElementType("org.uberfire.backend.vfs.Path");
      _$82725745__65821278_breadcrumbs(entity, java_util_List.demarshall(obj.get("breadcrumbs"), a1));
    }
    if ((obj.containsKey("content")) && (!obj.get("content").isNull())) {
      a1.setAssumedElementType("org.guvnor.structure.navigator.DataContent");
      _$82725745__65821278_content(entity, java_util_List.demarshall(obj.get("content"), a1));
    }
    return entity;
  }

  public String marshall(NavigatorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.navigator.NavigatorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"repoName\":").append(java_lang_String.marshall(a0.getRepoName(), a1)).append(",").append("\"root\":").append(java_lang_Object.marshall(a0.getRoot(), a1)).append(",").append("\"breadcrumbs\":").append(java_util_List.marshall(a0.getBreadcrumbs(), a1)).append(",").append("\"content\":").append(java_util_List.marshall(a0.getContent(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}