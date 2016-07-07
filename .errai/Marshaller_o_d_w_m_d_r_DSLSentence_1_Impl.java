package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.rule.DSLSentence;
import org.drools.workbench.models.datamodel.rule.DSLVariableValue;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_DSLSentence_1_Impl implements GeneratedMarshaller<DSLSentence> {
  private DSLSentence[] EMPTY_ARRAY = new DSLSentence[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public DSLSentence[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1140896995__1195259493_sentence(DSLSentence instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.DSLSentence::sentence;
  }-*/;

  private native static void _1140896995__1195259493_sentence(DSLSentence instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.DSLSentence::sentence = value;
  }-*/;

  private native static List _1140896995__65821278_values(DSLSentence instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.DSLSentence::values;
  }-*/;

  private native static void _1140896995__65821278_values(DSLSentence instance, List<DSLVariableValue> value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.DSLSentence::values = value;
  }-*/;

  public DSLSentence demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DSLSentence.class, objId);
    }
    DSLSentence entity = new DSLSentence();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("drl")) && (!obj.get("drl").isNull())) {
      entity.setDrl(java_lang_String.demarshall(obj.get("drl"), a1));
    }
    if ((obj.containsKey("sentence")) && (!obj.get("sentence").isNull())) {
      _1140896995__1195259493_sentence(entity, java_lang_String.demarshall(obj.get("sentence"), a1));
    }
    if ((obj.containsKey("definition")) && (!obj.get("definition").isNull())) {
      entity.setDefinition(java_lang_String.demarshall(obj.get("definition"), a1));
    }
    if ((obj.containsKey("values")) && (!obj.get("values").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.DSLVariableValue");
      _1140896995__65821278_values(entity, java_util_List.demarshall(obj.get("values"), a1));
    }
    return entity;
  }

  public String marshall(DSLSentence a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.DSLSentence\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"drl\":").append(java_lang_String.marshall(a0.getDrl(), a1)).append(",").append("\"sentence\":").append(java_lang_String.marshall(_1140896995__1195259493_sentence(a0), a1)).append(",").append("\"definition\":").append(java_lang_String.marshall(a0.getDefinition(), a1)).append(",").append("\"values\":").append(java_util_List.marshall(a0.getValues(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}