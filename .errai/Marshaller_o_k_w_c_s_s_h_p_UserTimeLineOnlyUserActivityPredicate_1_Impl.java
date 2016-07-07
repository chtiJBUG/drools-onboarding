package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.SocialUser;
import org.kie.workbench.common.screens.social.hp.predicate.UserTimeLineOnlyUserActivityPredicate;

public class Marshaller_o_k_w_c_s_s_h_p_UserTimeLineOnlyUserActivityPredicate_1_Impl implements GeneratedMarshaller<UserTimeLineOnlyUserActivityPredicate> {
  private UserTimeLineOnlyUserActivityPredicate[] EMPTY_ARRAY = new UserTimeLineOnlyUserActivityPredicate[0];
  private Marshaller<SocialUser> org_kie_uberfire_social_activities_model_SocialUser = null;
  public UserTimeLineOnlyUserActivityPredicate[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static SocialUser _1955368447__$1752651894_socialUser(UserTimeLineOnlyUserActivityPredicate instance) /*-{
    return instance.@org.kie.workbench.common.screens.social.hp.predicate.UserTimeLineOnlyUserActivityPredicate::socialUser;
  }-*/;

  private native static void _1955368447__$1752651894_socialUser(UserTimeLineOnlyUserActivityPredicate instance, SocialUser value) /*-{
    instance.@org.kie.workbench.common.screens.social.hp.predicate.UserTimeLineOnlyUserActivityPredicate::socialUser = value;
  }-*/;

  public UserTimeLineOnlyUserActivityPredicate demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UserTimeLineOnlyUserActivityPredicate.class, objId);
    }
    UserTimeLineOnlyUserActivityPredicate entity = new UserTimeLineOnlyUserActivityPredicate();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("socialUser")) && (!obj.get("socialUser").isNull())) {
      _1955368447__$1752651894_socialUser(entity, org_kie_uberfire_social_activities_model_SocialUser.demarshall(obj.get("socialUser"), a1));
    }
    return entity;
  }

  public String marshall(UserTimeLineOnlyUserActivityPredicate a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.social.hp.predicate.UserTimeLineOnlyUserActivityPredicate\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"socialUser\":").append(org_kie_uberfire_social_activities_model_SocialUser.marshall(_1955368447__$1752651894_socialUser(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_uberfire_social_activities_model_SocialUser == null) {
      org_kie_uberfire_social_activities_model_SocialUser = Marshalling.getMarshaller(SocialUser.class);
    }
  }
}