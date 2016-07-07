package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.kie.workbench.common.screens.search.model.SearchPageRow;
import org.uberfire.backend.vfs.Path;
import org.uberfire.paging.AbstractPathPageRow;

public class Marshaller_o_k_w_c_s_s_m_SearchPageRow_1_Impl implements GeneratedMarshaller<SearchPageRow> {
  private SearchPageRow[] EMPTY_ARRAY = new SearchPageRow[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public SearchPageRow[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Path _1829700438__$2084529122_path(AbstractPathPageRow instance) /*-{
    return instance.@org.uberfire.paging.AbstractPathPageRow::path;
  }-*/;

  private native static void _1829700438__$2084529122_path(AbstractPathPageRow instance, Path value) /*-{
    instance.@org.uberfire.paging.AbstractPathPageRow::path = value;
  }-*/;

  public SearchPageRow demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(SearchPageRow.class, objId);
    }
    SearchPageRow entity = new SearchPageRow();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("description")) && (!obj.get("description").isNull())) {
      entity.setDescription(java_lang_String.demarshall(obj.get("description"), a1));
    }
    if ((obj.containsKey("abbreviatedDescription")) && (!obj.get("abbreviatedDescription").isNull())) {
      entity.setAbbreviatedDescription(java_lang_String.demarshall(obj.get("abbreviatedDescription"), a1));
    }
    if ((obj.containsKey("creator")) && (!obj.get("creator").isNull())) {
      entity.setCreator(java_lang_String.demarshall(obj.get("creator"), a1));
    }
    if ((obj.containsKey("createdDate")) && (!obj.get("createdDate").isNull())) {
      entity.setCreatedDate(java_util_Date.demarshall(obj.get("createdDate"), a1));
    }
    if ((obj.containsKey("lastContributor")) && (!obj.get("lastContributor").isNull())) {
      entity.setLastContributor(java_lang_String.demarshall(obj.get("lastContributor"), a1));
    }
    if ((obj.containsKey("lastModified")) && (!obj.get("lastModified").isNull())) {
      entity.setLastModified(java_util_Date.demarshall(obj.get("lastModified"), a1));
    }
    if ((obj.containsKey("disabled")) && (!obj.get("disabled").isNull())) {
      entity.setDisabled(java_lang_Boolean.demarshall(obj.get("disabled"), a1));
    }
    if ((obj.containsKey("path")) && (!obj.get("path").isNull())) {
      _1829700438__$2084529122_path(entity, (Path) ((ObjectMarshaller) java_lang_Object).demarshall(Path.class, obj.get("path"), a1));
    }
    return entity;
  }

  private native static boolean _$609574366__64711720_disabled(SearchPageRow instance) /*-{
    return instance.@org.kie.workbench.common.screens.search.model.SearchPageRow::disabled;
  }-*/;

  private native static void _$609574366__64711720_disabled(SearchPageRow instance, boolean value) /*-{
    instance.@org.kie.workbench.common.screens.search.model.SearchPageRow::disabled = value;
  }-*/;

  public String marshall(SearchPageRow a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.kie.workbench.common.screens.search.model.SearchPageRow\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"description\":").append(java_lang_String.marshall(a0.getDescription(), a1)).append(",").append("\"abbreviatedDescription\":").append(java_lang_String.marshall(a0.getAbbreviatedDescription(), a1)).append(",").append("\"creator\":").append(java_lang_String.marshall(a0.getCreator(), a1)).append(",").append("\"createdDate\":").append(java_util_Date.marshall(a0.getCreatedDate(), a1)).append(",").append("\"lastContributor\":").append(java_lang_String.marshall(a0.getLastContributor(), a1)).append(",").append("\"lastModified\":").append(java_util_Date.marshall(a0.getLastModified(), a1)).append(",").append("\"disabled\":").append(java_lang_Boolean.marshall(_$609574366__64711720_disabled(a0), a1)).append(",").append("\"path\":").append(java_lang_Object.marshall(a0.getPath(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}