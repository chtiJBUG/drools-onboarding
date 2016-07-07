package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.screens.dsltext.model.DSLTextEditorContent;
import org.guvnor.common.services.shared.metadata.model.Overview;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_s_d_m_DSLTextEditorContent_1_Impl implements GeneratedMarshaller<DSLTextEditorContent> {
  private DSLTextEditorContent[] EMPTY_ARRAY = new DSLTextEditorContent[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Overview> org_guvnor_common_services_shared_metadata_model_Overview = null;
  public DSLTextEditorContent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$23488432__1195259493_model(DSLTextEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.dsltext.model.DSLTextEditorContent::model;
  }-*/;

  private native static void _$23488432__1195259493_model(DSLTextEditorContent instance, String value) /*-{
    instance.@org.drools.workbench.screens.dsltext.model.DSLTextEditorContent::model = value;
  }-*/;

  private native static Overview _$23488432__1909091292_overview(DSLTextEditorContent instance) /*-{
    return instance.@org.drools.workbench.screens.dsltext.model.DSLTextEditorContent::overview;
  }-*/;

  private native static void _$23488432__1909091292_overview(DSLTextEditorContent instance, Overview value) /*-{
    instance.@org.drools.workbench.screens.dsltext.model.DSLTextEditorContent::overview = value;
  }-*/;

  public DSLTextEditorContent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DSLTextEditorContent.class, objId);
    }
    DSLTextEditorContent entity = new DSLTextEditorContent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("model")) && (!obj.get("model").isNull())) {
      _$23488432__1195259493_model(entity, java_lang_String.demarshall(obj.get("model"), a1));
    }
    if ((obj.containsKey("overview")) && (!obj.get("overview").isNull())) {
      _$23488432__1909091292_overview(entity, org_guvnor_common_services_shared_metadata_model_Overview.demarshall(obj.get("overview"), a1));
    }
    return entity;
  }

  public String marshall(DSLTextEditorContent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.screens.dsltext.model.DSLTextEditorContent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"model\":").append(java_lang_String.marshall(a0.getModel(), a1)).append(",").append("\"overview\":").append(org_guvnor_common_services_shared_metadata_model_Overview.marshall(a0.getOverview(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_shared_metadata_model_Overview == null) {
      org_guvnor_common_services_shared_metadata_model_Overview = Marshalling.getMarshaller(Overview.class);
    }
  }
}