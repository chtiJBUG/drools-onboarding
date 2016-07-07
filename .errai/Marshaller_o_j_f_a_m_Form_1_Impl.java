package org.jboss.errai.marshalling.client.api;

import java.util.HashMap;
import java.util.Set;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.formModeler.api.model.Form;

public class Marshaller_o_j_f_a_m_Form_1_Impl implements GeneratedMarshaller<Form> {
  private Form[] EMPTY_ARRAY = new Form[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<HashMap> java_util_HashMap = null;
  public Form[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static HashMap _$773653656__$1402722386_dataHolderRenderInfo(Form instance) /*-{
    return instance.@org.jbpm.formModeler.api.model.Form::dataHolderRenderInfo;
  }-*/;

  private native static void _$773653656__$1402722386_dataHolderRenderInfo(Form instance, HashMap value) /*-{
    instance.@org.jbpm.formModeler.api.model.Form::dataHolderRenderInfo = value;
  }-*/;

  public Form demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Form.class, objId);
    }
    Form entity = new Form();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("subject")) && (!obj.get("subject").isNull())) {
      entity.setSubject(java_lang_String.demarshall(obj.get("subject"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("displayMode")) && (!obj.get("displayMode").isNull())) {
      entity.setDisplayMode(java_lang_String.demarshall(obj.get("displayMode"), a1));
    }
    if ((obj.containsKey("labelMode")) && (!obj.get("labelMode").isNull())) {
      entity.setLabelMode(java_lang_String.demarshall(obj.get("labelMode"), a1));
    }
    if ((obj.containsKey("showMode")) && (!obj.get("showMode").isNull())) {
      entity.setShowMode(java_lang_String.demarshall(obj.get("showMode"), a1));
    }
    if ((obj.containsKey("status")) && (!obj.get("status").isNull())) {
      entity.setStatus(java_lang_Long.demarshall(obj.get("status"), a1));
    }
    if ((obj.containsKey("formDisplayInfos")) && (!obj.get("formDisplayInfos").isNull())) {
      a1.setAssumedElementType("org.jbpm.formModeler.api.model.FormDisplayInfo");
      entity.setFormDisplayInfos(java_util_Set.demarshall(obj.get("formDisplayInfos"), a1));
    }
    if ((obj.containsKey("formFields")) && (!obj.get("formFields").isNull())) {
      a1.setAssumedElementType("org.jbpm.formModeler.api.model.Field");
      entity.setFormFields(java_util_Set.demarshall(obj.get("formFields"), a1));
    }
    if ((obj.containsKey("holders")) && (!obj.get("holders").isNull())) {
      a1.setAssumedElementType("org.jbpm.formModeler.api.model.DataHolder");
      entity.setHolders(java_util_Set.demarshall(obj.get("holders"), a1));
    }
    if ((obj.containsKey("dataHolderRenderInfo")) && (!obj.get("dataHolderRenderInfo").isNull())) {
      _$773653656__$1402722386_dataHolderRenderInfo(entity, java_util_HashMap.demarshall(obj.get("dataHolderRenderInfo"), a1));
    }
    return entity;
  }

  public String marshall(Form a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.formModeler.api.model.Form\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"subject\":").append(java_lang_String.marshall(a0.getSubject(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"displayMode\":").append(java_lang_String.marshall(a0.getDisplayMode(), a1)).append(",").append("\"labelMode\":").append(java_lang_String.marshall(a0.getLabelMode(), a1)).append(",").append("\"showMode\":").append(java_lang_String.marshall(a0.getShowMode(), a1)).append(",").append("\"status\":").append(java_lang_Long.marshall(a0.getStatus(), a1)).append(",").append("\"formDisplayInfos\":").append(java_util_Set.marshall(a0.getFormDisplayInfos(), a1)).append(",").append("\"formFields\":").append(java_util_Set.marshall(a0.getFormFields(), a1)).append(",").append("\"holders\":").append(java_util_Set.marshall(a0.getHolders(), a1)).append(",").append("\"dataHolderRenderInfo\":").append(java_util_HashMap.marshall(_$773653656__$1402722386_dataHolderRenderInfo(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_HashMap == null) {
      java_util_HashMap = Marshalling.getMarshaller(HashMap.class);
    }
  }
}