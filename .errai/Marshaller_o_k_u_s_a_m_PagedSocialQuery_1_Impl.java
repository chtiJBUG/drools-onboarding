package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.kie.uberfire.social.activities.model.PagedSocialQuery;
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent;
import org.kie.uberfire.social.activities.model.SocialPaged;

public class Marshaller_o_k_u_s_a_m_PagedSocialQuery_1_Impl implements GeneratedMarshaller<PagedSocialQuery> {
  private PagedSocialQuery[] EMPTY_ARRAY = new PagedSocialQuery[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<SocialPaged> org_kie_uberfire_social_activities_model_SocialPaged = null;
  public PagedSocialQuery[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$1239329896__65821278_socialEvents(PagedSocialQuery instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.PagedSocialQuery::socialEvents;
  }-*/;

  private native static void _$1239329896__65821278_socialEvents(PagedSocialQuery instance, List<SocialActivitiesEvent> value) /*-{
    instance.@org.kie.uberfire.social.activities.model.PagedSocialQuery::socialEvents = value;
  }-*/;

  private native static SocialPaged _$1239329896__1497213910_socialPaged(PagedSocialQuery instance) /*-{
    return instance.@org.kie.uberfire.social.activities.model.PagedSocialQuery::socialPaged;
  }-*/;

  private native static void _$1239329896__1497213910_socialPaged(PagedSocialQuery instance, SocialPaged value) /*-{
    instance.@org.kie.uberfire.social.activities.model.PagedSocialQuery::socialPaged = value;
  }-*/;

  public PagedSocialQuery demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PagedSocialQuery.class, objId);
    }
    PagedSocialQuery entity = new PagedSocialQuery();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("socialEvents")) && (!obj.get("socialEvents").isNull())) {
      a1.setAssumedElementType("org.kie.uberfire.social.activities.model.SocialActivitiesEvent");
      _$1239329896__65821278_socialEvents(entity, java_util_List.demarshall(obj.get("socialEvents"), a1));
    }
    if ((obj.containsKey("socialPaged")) && (!obj.get("socialPaged").isNull())) {
      _$1239329896__1497213910_socialPaged(entity, org_kie_uberfire_social_activities_model_SocialPaged.demarshall(obj.get("socialPaged"), a1));
    }
    return entity;
  }

  public String marshall(PagedSocialQuery a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.uberfire.social.activities.model.PagedSocialQuery\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"socialEvents\":").append(java_util_List.marshall(_$1239329896__65821278_socialEvents(a0), a1)).append(",").append("\"socialPaged\":").append(org_kie_uberfire_social_activities_model_SocialPaged.marshall(_$1239329896__1497213910_socialPaged(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_kie_uberfire_social_activities_model_SocialPaged == null) {
      org_kie_uberfire_social_activities_model_SocialPaged = Marshalling.getMarshaller(SocialPaged.class);
    }
  }
}