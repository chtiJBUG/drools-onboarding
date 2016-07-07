package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.Date;
import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent;
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent.LINK_TYPE;
import org.kie.uberfire.social.activities.model.SocialUser;

public class Marshaller_o_k_u_s_a_m_SocialActivitiesEvent_1_Impl implements GeneratedMarshaller<SocialActivitiesEvent> {
  private SocialActivitiesEvent[] EMPTY_ARRAY = new SocialActivitiesEvent[0];
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<SocialUser> org_kie_uberfire_social_activities_model_SocialUser = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  private Marshaller<LINK_TYPE> org_kie_uberfire_social_activities_model_SocialActivitiesEvent_erraiD_LINK_erraiU_TYPE = null;
  private Marshaller<String[]> arrayOf_java_lang_String_D1 = Marshalling.getMarshaller(String[].class, new DeferredMarshallerCreationCallback<String[]>() {
    public Marshaller<String[]> create(Class type) {
      return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_String_D1.class), String[].class);
    }
  });
  abstract class Marshaller_for_arrayOf_java_lang_String_D1 implements GeneratedMarshaller { }
  public SocialActivitiesEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Date _$1031308914__65575278_timestamp(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::timestamp;
  }-*/;

  private native static void _$1031308914__65575278_timestamp(SocialActivitiesEvent instance, Date value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::timestamp = value;
  }-*/;

  private native static SocialUser _$1031308914__$1752651894_socialUser(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::socialUser;
  }-*/;

  private native static void _$1031308914__$1752651894_socialUser(SocialActivitiesEvent instance, SocialUser value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::socialUser = value;
  }-*/;

  private native static String _$1031308914__1195259493_type(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::type;
  }-*/;

  private native static void _$1031308914__1195259493_type(SocialActivitiesEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::type = value;
  }-*/;

  private native static String _$1031308914__1195259493_linkLabel(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkLabel;
  }-*/;

  private native static void _$1031308914__1195259493_linkLabel(SocialActivitiesEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkLabel = value;
  }-*/;

  private native static String _$1031308914__1195259493_linkTarget(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkTarget;
  }-*/;

  private native static void _$1031308914__1195259493_linkTarget(SocialActivitiesEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkTarget = value;
  }-*/;

  private native static Map _$1031308914__$1383349348_linkParams(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkParams;
  }-*/;

  private native static void _$1031308914__$1383349348_linkParams(SocialActivitiesEvent instance, Map<String, String> value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkParams = value;
  }-*/;

  private native static LINK_TYPE _$1031308914__$696398647_linkType(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkType;
  }-*/;

  private native static void _$1031308914__$696398647_linkType(SocialActivitiesEvent instance, LINK_TYPE value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::linkType = value;
  }-*/;

  private native static String[] _$1031308914__392722245_additionalInfo(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::additionalInfo;
  }-*/;

  private native static void _$1031308914__392722245_additionalInfo(SocialActivitiesEvent instance, String[] value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::additionalInfo = value;
  }-*/;

  private native static String _$1031308914__1195259493_description(SocialActivitiesEvent instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::description;
  }-*/;

  private native static void _$1031308914__1195259493_description(SocialActivitiesEvent instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialActivitiesEvent::description = value;
  }-*/;

  public SocialActivitiesEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SocialActivitiesEvent.class, objId);
    }
    SocialActivitiesEvent entity = new SocialActivitiesEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("timestamp")) && (!obj.get("timestamp").isNull())) {
      _$1031308914__65575278_timestamp(entity, java_util_Date.demarshall(obj.get("timestamp"), a1));
    }
    if ((obj.containsKey("socialUser")) && (!obj.get("socialUser").isNull())) {
      _$1031308914__$1752651894_socialUser(entity, org_kie_uberfire_social_activities_model_SocialUser.demarshall(obj.get("socialUser"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      _$1031308914__1195259493_type(entity, java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("linkLabel")) && (!obj.get("linkLabel").isNull())) {
      _$1031308914__1195259493_linkLabel(entity, java_lang_String.demarshall(obj.get("linkLabel"), a1));
    }
    if ((obj.containsKey("linkTarget")) && (!obj.get("linkTarget").isNull())) {
      _$1031308914__1195259493_linkTarget(entity, java_lang_String.demarshall(obj.get("linkTarget"), a1));
    }
    if ((obj.containsKey("linkParams")) && (!obj.get("linkParams").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.String");
      _$1031308914__$1383349348_linkParams(entity, java_util_Map.demarshall(obj.get("linkParams"), a1));
      a1.resetAssumedTypes();
    }
    if ((obj.containsKey("linkType")) && (!obj.get("linkType").isNull())) {
      _$1031308914__$696398647_linkType(entity, obj.get("linkType").isObject() != null ? Enum.valueOf(LINK_TYPE.class, obj.get("linkType").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("linkType").isString() != null ? Enum.valueOf(LINK_TYPE.class, obj.get("linkType").isString().stringValue()) : null);
    }
    if ((obj.containsKey("additionalInfo")) && (!obj.get("additionalInfo").isNull())) {
      _$1031308914__392722245_additionalInfo(entity, arrayOf_java_lang_String_D1.demarshall(obj.get("additionalInfo"), a1));
    }
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      _$1031308914__1195259493_description(entity, java_lang_String.demarshall(obj.get("description"), a1));
    }
    return entity;
  }

  public String marshall(SocialActivitiesEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialActivitiesEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"timestamp\":").append(java_util_Date.marshall(a0.getTimestamp(), a1)).append(",").append("\"socialUser\":").append(org_kie_uberfire_social_activities_model_SocialUser.marshall(a0.getSocialUser(), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"linkLabel\":").append(java_lang_String.marshall(a0.getLinkLabel(), a1)).append(",").append("\"linkTarget\":").append(java_lang_String.marshall(a0.getLinkTarget(), a1)).append(",").append("\"linkParams\":").append(java_util_Map.marshall(a0.getLinkParams(), a1)).append(",").append("\"linkType\":").append(a0.getLinkType() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialActivitiesEvent$LINK_TYPE\",\"^EnumStringValue\":\"").append(a0.getLinkType().name()).append("\"}") : "null").append(",").append("\"additionalInfo\":").append(arrayOf_java_lang_String_D1.marshall(a0.getAdditionalInfo(), a1)).append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_uberfire_social_activities_model_SocialUser == null) {
      org_kie_uberfire_social_activities_model_SocialUser = Marshalling.getMarshaller(SocialUser.class);
    }
    if (org_kie_uberfire_social_activities_model_SocialActivitiesEvent_erraiD_LINK_erraiU_TYPE == null) {
      org_kie_uberfire_social_activities_model_SocialActivitiesEvent_erraiD_LINK_erraiU_TYPE = Marshalling.getMarshaller(LINK_TYPE.class);
    }
  }
}