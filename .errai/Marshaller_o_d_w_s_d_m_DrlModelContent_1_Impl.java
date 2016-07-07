package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.rule.DSLSentence;
import org.drools.workbench.screens.drltext.model.DrlModelContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_d_m_DrlModelContent_1_Impl implements GeneratedMarshaller<DrlModelContent> {
  private DrlModelContent[] EMPTY_ARRAY = new DrlModelContent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public DrlModelContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$743406783__1195259493_drl(DrlModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::drl;
  }-*/;

  private native static void _$743406783__1195259493_drl(DrlModelContent instance, String value) /*-{
    instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::drl = value;
  }-*/;

  private native static List _$743406783__65821278_fullyQualifiedClassNames(DrlModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::fullyQualifiedClassNames;
  }-*/;

  private native static void _$743406783__65821278_fullyQualifiedClassNames(DrlModelContent instance, List<String> value) /*-{
    instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::fullyQualifiedClassNames = value;
  }-*/;

  private native static List _$743406783__65821278_dslConditions(DrlModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::dslConditions;
  }-*/;

  private native static void _$743406783__65821278_dslConditions(DrlModelContent instance, List<DSLSentence> value) /*-{
    instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::dslConditions = value;
  }-*/;

  private native static List _$743406783__65821278_dslActions(DrlModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::dslActions;
  }-*/;

  private native static void _$743406783__65821278_dslActions(DrlModelContent instance, List<DSLSentence> value) /*-{
    instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::dslActions = value;
  }-*/;

  private native static Overview _$743406783__1909091292_overview(DrlModelContent instance) /*-{
    return instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::overview;
  }-*/;

  private native static void _$743406783__1909091292_overview(DrlModelContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.drltext.model.DrlModelContent::overview = value;
  }-*/;

  public DrlModelContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DrlModelContent.class, objId);
    }
    DrlModelContent entity = new DrlModelContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("drl")) && (!obj.get("drl").isNull())) {
      _$743406783__1195259493_drl(entity, java_lang_String.demarshall(obj.get("drl"), a1));
    }
    if ((obj.containsKey("fullyQualifiedClassNames")) && (!obj.get("fullyQualifiedClassNames").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$743406783__65821278_fullyQualifiedClassNames(entity, java_util_List.demarshall(obj.get("fullyQualifiedClassNames"), a1));
    }
    if ((obj.containsKey("dslConditions")) && (!obj.get("dslConditions").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.DSLSentence");
      _$743406783__65821278_dslConditions(entity, java_util_List.demarshall(obj.get("dslConditions"), a1));
    }
    if ((obj.containsKey("dslActions")) && (!obj.get("dslActions").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.DSLSentence");
      _$743406783__65821278_dslActions(entity, java_util_List.demarshall(obj.get("dslActions"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$743406783__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(DrlModelContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.drltext.model.DrlModelContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"drl\":").append(java_lang_String.marshall(a0.getDrl(), a1)).append(",").append("\"fullyQualifiedClassNames\":").append(java_util_List.marshall(a0.getFullyQualifiedClassNames(), a1)).append(",").append("\"dslConditions\":").append(java_util_List.marshall(a0.getDslConditions(), a1)).append(",").append("\"dslActions\":").append(java_util_List.marshall(a0.getDslActions(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}