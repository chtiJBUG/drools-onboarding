package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.events.SocialUserFollowedEvent;
import org.kie.uberfire.social.activities.model.SocialUser;

public class Marshaller_o_k_u_s_a_e_SocialUserFollowedEvent_1_Impl implements GeneratedMarshaller<SocialUserFollowedEvent> {
  private SocialUserFollowedEvent[] EMPTY_ARRAY = new SocialUserFollowedEvent[0];
  private Marshaller<SocialUser> org_kie_uberfire_social_activities_model_SocialUser = null;
  public SocialUserFollowedEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public SocialUserFollowedEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SocialUserFollowedEvent.class, objId);
    }
    final SocialUser c0 = org_kie_uberfire_social_activities_model_SocialUser.demarshall(obj.get("user"), a1);
    final SocialUser c1 = org_kie_uberfire_social_activities_model_SocialUser.demarshall(obj.get("follow"), a1);
    SocialUserFollowedEvent entity = new SocialUserFollowedEvent(c0, c1);
    a1.recordObject(objId, entity);
    return entity;
  }

  public String marshall(SocialUserFollowedEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.events.SocialUserFollowedEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"user\":").append(org_kie_uberfire_social_activities_model_SocialUser.marshall(a0.getUser(), a1)).append(",").append("\"follow\":").append(org_kie_uberfire_social_activities_model_SocialUser.marshall(a0.getFollow(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_uberfire_social_activities_model_SocialUser == null) {
      org_kie_uberfire_social_activities_model_SocialUser = Marshalling.getMarshaller(SocialUser.class);
    }
  }
}