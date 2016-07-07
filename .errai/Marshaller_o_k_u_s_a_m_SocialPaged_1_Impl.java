package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialPaged;
import org.kie.uberfire.social.activities.model.SocialPaged.Direction;

public class Marshaller_o_k_u_s_a_m_SocialPaged_1_Impl implements GeneratedMarshaller<SocialPaged> {
  private SocialPaged[] EMPTY_ARRAY = new SocialPaged[0];
  private Marshaller<SocialPaged> org_kie_uberfire_social_activities_model_SocialPaged = null;
  private Marshaller<Direction> org_kie_uberfire_social_activities_model_SocialPaged_erraiD_Direction = null;
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public SocialPaged[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Direction _1497213910__$2080937967_direction(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::direction;
  }-*/;

  private native static void _1497213910__$2080937967_direction(SocialPaged instance, Direction value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::direction = value;
  }-*/;

  private native static int _1497213910__104431_pageSize(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::pageSize;
  }-*/;

  private native static void _1497213910__104431_pageSize(SocialPaged instance, int value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::pageSize = value;
  }-*/;

  private native static int _1497213910__104431_lastFileIndex(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::lastFileIndex;
  }-*/;

  private native static void _1497213910__104431_lastFileIndex(SocialPaged instance, int value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::lastFileIndex = value;
  }-*/;

  private native static int _1497213910__104431_freshIndex(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::freshIndex;
  }-*/;

  private native static void _1497213910__104431_freshIndex(SocialPaged instance, int value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::freshIndex = value;
  }-*/;

  private native static boolean _1497213910__64711720_canIGoBackward(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::canIGoBackward;
  }-*/;

  private native static void _1497213910__64711720_canIGoBackward(SocialPaged instance, boolean value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::canIGoBackward = value;
  }-*/;

  private native static int _1497213910__104431_numberOfEventsOnFile(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::numberOfEventsOnFile;
  }-*/;

  private native static void _1497213910__104431_numberOfEventsOnFile(SocialPaged instance, int value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::numberOfEventsOnFile = value;
  }-*/;

  public SocialPaged demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SocialPaged.class, objId);
    }
    SocialPaged entity = new SocialPaged();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("lastQuery")) && (!obj.get("lastQuery").isNull())) {
      entity.setLastQuery(org_kie_uberfire_social_activities_model_SocialPaged.demarshall(obj.get("lastQuery"), a1));
    }
    if ((obj.containsKey("direction")) && (!obj.get("direction").isNull())) {
      _1497213910__$2080937967_direction(entity, obj.get("direction").isObject() != null ? Enum.valueOf(Direction.class, obj.get("direction").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("direction").isString() != null ? Enum.valueOf(Direction.class, obj.get("direction").isString().stringValue()) : null);
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      _1497213910__104431_pageSize(entity, java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    if ((obj.containsKey("lastFileReaded")) && (!obj.get("lastFileReaded").isNull())) {
      entity.setLastFileReaded(java_lang_String.demarshall(obj.get("lastFileReaded"), a1));
    }
    if ((obj.containsKey("lastFileIndex")) && (!obj.get("lastFileIndex").isNull())) {
      _1497213910__104431_lastFileIndex(entity, java_lang_Integer.demarshall(obj.get("lastFileIndex"), a1));
    }
    if ((obj.containsKey("freshIndex")) && (!obj.get("freshIndex").isNull())) {
      _1497213910__104431_freshIndex(entity, java_lang_Integer.demarshall(obj.get("freshIndex"), a1));
    }
    if ((obj.containsKey("canIGoForward")) && (!obj.get("canIGoForward").isNull())) {
      entity.setCanIGoForward(java_lang_Boolean.demarshall(obj.get("canIGoForward"), a1));
    }
    if ((obj.containsKey("canIGoBackward")) && (!obj.get("canIGoBackward").isNull())) {
      _1497213910__64711720_canIGoBackward(entity, java_lang_Boolean.demarshall(obj.get("canIGoBackward"), a1));
    }
    if ((obj.containsKey("numberOfEventsOnFile")) && (!obj.get("numberOfEventsOnFile").isNull())) {
      _1497213910__104431_numberOfEventsOnFile(entity, java_lang_Integer.demarshall(obj.get("numberOfEventsOnFile"), a1));
    }
    return entity;
  }

  private native static String _1497213910__1195259493_lastFileReaded(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::lastFileReaded;
  }-*/;

  private native static void _1497213910__1195259493_lastFileReaded(SocialPaged instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::lastFileReaded = value;
  }-*/;

  private native static boolean _1497213910__64711720_canIGoForward(SocialPaged instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialPaged::canIGoForward;
  }-*/;

  private native static void _1497213910__64711720_canIGoForward(SocialPaged instance, boolean value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialPaged::canIGoForward = value;
  }-*/;

  public String marshall(SocialPaged a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialPaged\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"lastQuery\":").append(org_kie_uberfire_social_activities_model_SocialPaged.marshall(a0.getLastQuery(), a1)).append(",").append("\"direction\":").append(_1497213910__$2080937967_direction(a0) != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialPaged$Direction\",\"^EnumStringValue\":\"").append(_1497213910__$2080937967_direction(a0).name()).append("\"}") : "null").append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append(",").append("\"lastFileReaded\":").append(java_lang_String.marshall(_1497213910__1195259493_lastFileReaded(a0), a1)).append(",").append("\"lastFileIndex\":").append(java_lang_Integer.marshall(_1497213910__104431_lastFileIndex(a0), a1)).append(",").append("\"freshIndex\":").append(java_lang_Integer.marshall(_1497213910__104431_freshIndex(a0), a1)).append(",").append("\"canIGoForward\":").append(java_lang_Boolean.marshall(_1497213910__64711720_canIGoForward(a0), a1)).append(",").append("\"canIGoBackward\":").append(java_lang_Boolean.marshall(_1497213910__64711720_canIGoBackward(a0), a1)).append(",").append("\"numberOfEventsOnFile\":").append(java_lang_Integer.marshall(_1497213910__104431_numberOfEventsOnFile(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_uberfire_social_activities_model_SocialPaged == null) {
      org_kie_uberfire_social_activities_model_SocialPaged = this;
    }
    if (org_kie_uberfire_social_activities_model_SocialPaged_erraiD_Direction == null) {
      org_kie_uberfire_social_activities_model_SocialPaged_erraiD_Direction = Marshalling.getMarshaller(Direction.class);
    }
  }
}