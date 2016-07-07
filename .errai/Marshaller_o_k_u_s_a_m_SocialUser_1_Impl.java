package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialUser;

public class Marshaller_o_k_u_s_a_m_SocialUser_1_Impl implements GeneratedMarshaller<SocialUser> {
  private SocialUser[] EMPTY_ARRAY = new SocialUser[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public SocialUser[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1752651894__1195259493_userName(SocialUser instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialUser::userName;
  }-*/;

  private native static void _$1752651894__1195259493_userName(SocialUser instance, String value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialUser::userName = value;
  }-*/;

  private native static List _$1752651894__65821278_followersName(SocialUser instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialUser::followersName;
  }-*/;

  private native static void _$1752651894__65821278_followersName(SocialUser instance, List<String> value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialUser::followersName = value;
  }-*/;

  private native static List _$1752651894__65821278_followingName(SocialUser instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.SocialUser::followingName;
  }-*/;

  private native static void _$1752651894__65821278_followingName(SocialUser instance, List<String> value) /*-{
    instance.@org.kie.uberfire.social.activities.model.SocialUser::followingName = value;
  }-*/;

  public SocialUser demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SocialUser.class, objId);
    }
    SocialUser entity = new SocialUser();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("userName")) && (!obj.get("userName").isNull())) {
      _$1752651894__1195259493_userName(entity, java_lang_String.demarshall(obj.get("userName"), a1));
    }
    if ((obj.containsKey("realName")) && (!obj.get("realName").isNull())) {
      entity.setRealName(java_lang_String.demarshall(obj.get("realName"), a1));
    }
    if ((obj.containsKey("email")) && (!obj.get("email").isNull())) {
      entity.setEmail(java_lang_String.demarshall(obj.get("email"), a1));
    }
    if ((obj.containsKey("followersName")) && (!obj.get("followersName").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1752651894__65821278_followersName(entity, java_util_List.demarshall(obj.get("followersName"), a1));
    }
    if ((obj.containsKey("followingName")) && (!obj.get("followingName").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1752651894__65821278_followingName(entity, java_util_List.demarshall(obj.get("followingName"), a1));
    }
    return entity;
  }

  public String marshall(SocialUser a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.SocialUser\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"userName\":").append(java_lang_String.marshall(a0.getUserName(), a1)).append(",").append("\"realName\":").append(java_lang_String.marshall(a0.getRealName(), a1)).append(",").append("\"email\":").append(java_lang_String.marshall(a0.getEmail(), a1)).append(",").append("\"followersName\":").append(java_util_List.marshall(a0.getFollowersName(), a1)).append(",").append("\"followingName\":").append(java_util_List.marshall(a0.getFollowingName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}