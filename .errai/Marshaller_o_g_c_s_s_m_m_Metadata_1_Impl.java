package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import java.util.List;
import org.guvnor.common.services.shared.metadata.model.DiscussionRecord;
import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.impl.LockInfo;
import org.uberfire.java.nio.base.version.VersionRecord;

public class Marshaller_o_g_c_s_s_m_m_Metadata_1_Impl implements GeneratedMarshaller<Metadata> {
  private Metadata[] EMPTY_ARRAY = new Metadata[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<LockInfo> org_uberfire_backend_vfs_impl_LockInfo = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public Metadata[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _928971154__$2084529122_path(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::path;
  }-*/;

  private native static void _928971154__$2084529122_path(Metadata instance, Path value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::path = value;
  }-*/;

  private native static Path _928971154__$2084529122_realPath(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::realPath;
  }-*/;

  private native static void _928971154__$2084529122_realPath(Metadata instance, Path value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::realPath = value;
  }-*/;

  private native static String _928971154__1195259493_checkinComment(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::checkinComment;
  }-*/;

  private native static void _928971154__1195259493_checkinComment(Metadata instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::checkinComment = value;
  }-*/;

  private native static String _928971154__1195259493_lastContributor(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::lastContributor;
  }-*/;

  private native static void _928971154__1195259493_lastContributor(Metadata instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::lastContributor = value;
  }-*/;

  private native static String _928971154__1195259493_creator(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::creator;
  }-*/;

  private native static void _928971154__1195259493_creator(Metadata instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::creator = value;
  }-*/;

  private native static Date _928971154__65575278_lastModified(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::lastModified;
  }-*/;

  private native static void _928971154__65575278_lastModified(Metadata instance, Date value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::lastModified = value;
  }-*/;

  private native static Date _928971154__65575278_dateCreated(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::dateCreated;
  }-*/;

  private native static void _928971154__65575278_dateCreated(Metadata instance, Date value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::dateCreated = value;
  }-*/;

  private native static List _928971154__65821278_tags(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::tags;
  }-*/;

  private native static void _928971154__65821278_tags(Metadata instance, List<String> value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::tags = value;
  }-*/;

  private native static List _928971154__65821278_discussion(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::discussion;
  }-*/;

  private native static void _928971154__65821278_discussion(Metadata instance, List<DiscussionRecord> value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::discussion = value;
  }-*/;

  private native static List _928971154__65821278_version(Metadata instance) /*-{
    return instance.@org.guvnor.common.services.shared.metadata.model.Metadata::version;
  }-*/;

  private native static void _928971154__65821278_version(Metadata instance, List<VersionRecord> value) /*-{
    instance.@org.guvnor.common.services.shared.metadata.model.Metadata::version = value;
  }-*/;

  public Metadata demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Metadata.class, objId);
    }
    Metadata entity = new Metadata();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _928971154__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    if ((obj.containsKey("realPath")) && (!obj.get("realPath").isNull())) {
      _928971154__$2084529122_realPath(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("realPath"), a1));
    }
    if ((obj.containsKey("lockInfo")) && (!obj.get("lockInfo").isNull())) {
      entity.setLockInfo(org_uberfire_backend_vfs_impl_LockInfo.demarshall(obj.get("lockInfo"), a1));
    }
    if ((obj.containsKey("checkinComment")) && (!obj.get("checkinComment").isNull())) {
      _928971154__1195259493_checkinComment(entity, java_lang_String.demarshall(obj.get("checkinComment"), a1));
    }
    if ((obj.containsKey("lastContributor")) && (!obj.get("lastContributor").isNull())) {
      _928971154__1195259493_lastContributor(entity, java_lang_String.demarshall(obj.get("lastContributor"), a1));
    }
    if ((obj.containsKey("creator")) && (!obj.get("creator").isNull())) {
      _928971154__1195259493_creator(entity, java_lang_String.demarshall(obj.get("creator"), a1));
    }
    if ((obj.containsKey("lastModified")) && (!obj.get("lastModified").isNull())) {
      _928971154__65575278_lastModified(entity, java_util_Date.demarshall(obj.get("lastModified"), a1));
    }
    if ((obj.containsKey("dateCreated")) && (!obj.get("dateCreated").isNull())) {
      _928971154__65575278_dateCreated(entity, java_util_Date.demarshall(obj.get("dateCreated"), a1));
    }
    if ((obj.containsKey("subject")) && (!obj.get("subject").isNull())) {
      entity.setSubject(java_lang_String.demarshall(obj.get("subject"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("externalRelation")) && (!obj.get("externalRelation").isNull())) {
      entity.setExternalRelation(java_lang_String.demarshall(obj.get("externalRelation"), a1));
    }
    if ((obj.containsKey("externalSource")) && (!obj.get("externalSource").isNull())) {
      entity.setExternalSource(java_lang_String.demarshall(obj.get("externalSource"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      entity.setDescription(java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("tags")) && (!obj.get("tags").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _928971154__65821278_tags(entity, java_util_List.demarshall(obj.get("tags"), a1));
    }
    if ((obj.containsKey("discussion")) && (!obj.get("discussion").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.shared.metadata.model.DiscussionRecord");
      _928971154__65821278_discussion(entity, java_util_List.demarshall(obj.get("discussion"), a1));
    }
    if ((obj.containsKey("version")) && (!obj.get("version").isNull())) {
      a1.setAssumedElementType("org.uberfire.java.nio.base.version.VersionRecord");
      _928971154__65821278_version(entity, java_util_List.demarshall(obj.get("version"), a1));
    }
    return entity;
  }

  public String marshall(Metadata a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.shared.metadata.model.Metadata\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append(",").append("\"realPath\":").append(java_lang_Object.marshall(a0.getRealPath(), a1)).append(",").append("\"lockInfo\":").append(org_uberfire_backend_vfs_impl_LockInfo.marshall(a0.getLockInfo(), a1)).append(",").append("\"checkinComment\":").append(java_lang_String.marshall(a0.getCheckinComment(), a1)).append(",").append("\"lastContributor\":").append(java_lang_String.marshall(a0.getLastContributor(), a1)).append(",").append("\"creator\":").append(java_lang_String.marshall(a0.getCreator(), a1)).append(",").append("\"lastModified\":").append(java_util_Date.marshall(a0.getLastModified(), a1)).append(",").append("\"dateCreated\":").append(java_util_Date.marshall(a0.getDateCreated(), a1)).append(",").append("\"subject\":").append(java_lang_String.marshall(a0.getSubject(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"externalRelation\":").append(java_lang_String.marshall(a0.getExternalRelation(), a1)).append(",").append("\"externalSource\":").append(java_lang_String.marshall(a0.getExternalSource(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"tags\":").append(java_util_List.marshall(a0.getTags(), a1)).append(",").append("\"discussion\":").append(java_util_List.marshall(a0.getDiscussion(), a1)).append(",").append("\"version\":").append(java_util_List.marshall(a0.getVersion(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_backend_vfs_impl_LockInfo == null) {
      org_uberfire_backend_vfs_impl_LockInfo = Marshalling.getMarshaller(LockInfo.class);
    }
  }
}