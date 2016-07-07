package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.model.Package;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;

public class Marshaller_o_g_c_s_p_m_Package_1_Impl implements GeneratedMarshaller<Package> {
  private Package[] EMPTY_ARRAY = new Package[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public Package[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _$1106556860__$2084529122_projectRootPath(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::projectRootPath;
  }-*/;

  private native static void _$1106556860__$2084529122_projectRootPath(Package instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::projectRootPath = value;
  }-*/;

  private native static Path _$1106556860__$2084529122_packageMainSrcPath(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::packageMainSrcPath;
  }-*/;

  private native static void _$1106556860__$2084529122_packageMainSrcPath(Package instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::packageMainSrcPath = value;
  }-*/;

  private native static Path _$1106556860__$2084529122_packageTestSrcPath(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::packageTestSrcPath;
  }-*/;

  private native static void _$1106556860__$2084529122_packageTestSrcPath(Package instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::packageTestSrcPath = value;
  }-*/;

  private native static Path _$1106556860__$2084529122_packageMainResourcesPath(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::packageMainResourcesPath;
  }-*/;

  private native static void _$1106556860__$2084529122_packageMainResourcesPath(Package instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::packageMainResourcesPath = value;
  }-*/;

  private native static Path _$1106556860__$2084529122_packageTestResourcesPath(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::packageTestResourcesPath;
  }-*/;

  private native static void _$1106556860__$2084529122_packageTestResourcesPath(Package instance, Path value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::packageTestResourcesPath = value;
  }-*/;

  private native static String _$1106556860__1195259493_packageName(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::packageName;
  }-*/;

  private native static void _$1106556860__1195259493_packageName(Package instance, String value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::packageName = value;
  }-*/;

  private native static String _$1106556860__1195259493_caption(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::caption;
  }-*/;

  private native static void _$1106556860__1195259493_caption(Package instance, String value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::caption = value;
  }-*/;

  private native static String _$1106556860__1195259493_relativeCaption(Package instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Package::relativeCaption;
  }-*/;

  private native static void _$1106556860__1195259493_relativeCaption(Package instance, String value) /*-{
    instance.@org.guvnor.common.services.project.model.Package::relativeCaption = value;
  }-*/;

  public Package demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Package.class, objId);
    }
    Package entity = new Package();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("projectRootPath")) && (!obj.get("projectRootPath").isNull())) {
      _$1106556860__$2084529122_projectRootPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("projectRootPath"), a1));
    }
    if ((obj.containsKey("packageMainSrcPath")) && (!obj.get("packageMainSrcPath").isNull())) {
      _$1106556860__$2084529122_packageMainSrcPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("packageMainSrcPath"), a1));
    }
    if ((obj.containsKey("packageTestSrcPath")) && (!obj.get("packageTestSrcPath").isNull())) {
      _$1106556860__$2084529122_packageTestSrcPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("packageTestSrcPath"), a1));
    }
    if ((obj.containsKey("packageMainResourcesPath")) && (!obj.get("packageMainResourcesPath").isNull())) {
      _$1106556860__$2084529122_packageMainResourcesPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("packageMainResourcesPath"), a1));
    }
    if ((obj.containsKey("packageTestResourcesPath")) && (!obj.get("packageTestResourcesPath").isNull())) {
      _$1106556860__$2084529122_packageTestResourcesPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("packageTestResourcesPath"), a1));
    }
    if ((obj.containsKey("packageName")) && (!obj.get("packageName").isNull())) {
      _$1106556860__1195259493_packageName(entity, java_lang_String.demarshall(obj.get("packageName"), a1));
    }
    if ((obj.containsKey("caption")) && (!obj.get("caption").isNull())) {
      _$1106556860__1195259493_caption(entity, java_lang_String.demarshall(obj.get("caption"), a1));
    }
    if ((obj.containsKey("relativeCaption")) && (!obj.get("relativeCaption").isNull())) {
      _$1106556860__1195259493_relativeCaption(entity, java_lang_String.demarshall(obj.get("relativeCaption"), a1));
    }
    return entity;
  }

  public String marshall(Package a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Package\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"projectRootPath\":").append(java_lang_Object.marshall(a0.getProjectRootPath(), a1)).append(",").append("\"packageMainSrcPath\":").append(java_lang_Object.marshall(a0.getPackageMainSrcPath(), a1)).append(",").append("\"packageTestSrcPath\":").append(java_lang_Object.marshall(a0.getPackageTestSrcPath(), a1)).append(",").append("\"packageMainResourcesPath\":").append(java_lang_Object.marshall(a0.getPackageMainResourcesPath(), a1)).append(",").append("\"packageTestResourcesPath\":").append(java_lang_Object.marshall(a0.getPackageTestResourcesPath(), a1)).append(",").append("\"packageName\":").append(java_lang_String.marshall(a0.getPackageName(), a1)).append(",").append("\"caption\":").append(java_lang_String.marshall(a0.getCaption(), a1)).append(",").append("\"relativeCaption\":").append(java_lang_String.marshall(a0.getRelativeCaption(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}