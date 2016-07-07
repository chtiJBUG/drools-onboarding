package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.ga.model.PortableQueryFilter;

public class Marshaller_o_j_c_n_g_m_PortableQueryFilter_1_Impl implements GeneratedMarshaller<PortableQueryFilter> {
  private PortableQueryFilter[] EMPTY_ARRAY = new PortableQueryFilter[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public PortableQueryFilter[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static int _364129819__104431_offset(PortableQueryFilter instance) /*-{
    return instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::offset;
  }-*/;

  private native static void _364129819__104431_offset(PortableQueryFilter instance, int value) /*-{
    instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::offset = value;
  }-*/;

  private native static int _364129819__104431_count(PortableQueryFilter instance) /*-{
    return instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::count;
  }-*/;

  private native static void _364129819__104431_count(PortableQueryFilter instance, int value) /*-{
    instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::count = value;
  }-*/;

  private native static boolean _364129819__64711720_isAscending(PortableQueryFilter instance) /*-{
    return instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::isAscending;
  }-*/;

  private native static void _364129819__64711720_isAscending(PortableQueryFilter instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::isAscending = value;
  }-*/;

  public PortableQueryFilter demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(PortableQueryFilter.class, objId);
    }
    PortableQueryFilter entity = new PortableQueryFilter();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("offset")) && (!obj.get("offset").isNull())) {
      _364129819__104431_offset(entity, java_lang_Integer.demarshall(obj.get("offset"), a1));
    }
    if ((obj.containsKey("count")) && (!obj.get("count").isNull())) {
      _364129819__104431_count(entity, java_lang_Integer.demarshall(obj.get("count"), a1));
    }
    if ((obj.containsKey("isSingleResult")) && (!obj.get("isSingleResult").isNull())) {
      entity.setIsSingleResult(java_lang_Boolean.demarshall(obj.get("isSingleResult"), a1));
    }
    if ((obj.containsKey("language")) && (!obj.get("language").isNull())) {
      entity.setLanguage(java_lang_String.demarshall(obj.get("language"), a1));
    }
    if ((obj.containsKey("orderBy")) && (!obj.get("orderBy").isNull())) {
      entity.setOrderBy(java_lang_String.demarshall(obj.get("orderBy"), a1));
    }
    if ((obj.containsKey("isAscending")) && (!obj.get("isAscending").isNull())) {
      _364129819__64711720_isAscending(entity, java_lang_Boolean.demarshall(obj.get("isAscending"), a1));
    }
    if ((obj.containsKey("filterParams")) && (!obj.get("filterParams").isNull())) {
      entity.setFilterParams(java_lang_String.demarshall(obj.get("filterParams"), a1));
    }
    if ((obj.containsKey("params")) && (!obj.get("params").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Object");
      entity.setParams(java_util_Map.demarshall(obj.get("params"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  private native static boolean _364129819__64711720_isSingleResult(PortableQueryFilter instance) /*-{
    return instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::isSingleResult;
  }-*/;

  private native static void _364129819__64711720_isSingleResult(PortableQueryFilter instance, boolean value) /*-{
    instance.@org.jbpm.console.ng.ga.model.PortableQueryFilter::isSingleResult = value;
  }-*/;

  public String marshall(PortableQueryFilter a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.ga.model.PortableQueryFilter\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"offset\":").append(java_lang_Integer.marshall(_364129819__104431_offset(a0), a1)).append(",").append("\"count\":").append(java_lang_Integer.marshall(_364129819__104431_count(a0), a1)).append(",").append("\"isSingleResult\":").append(java_lang_Boolean.marshall(_364129819__64711720_isSingleResult(a0), a1)).append(",").append("\"language\":").append(java_lang_String.marshall(a0.getLanguage(), a1)).append(",").append("\"orderBy\":").append(java_lang_String.marshall(a0.getOrderBy(), a1)).append(",").append("\"isAscending\":").append(java_lang_Boolean.marshall(_364129819__64711720_isAscending(a0), a1)).append(",").append("\"filterParams\":").append(java_lang_String.marshall(a0.getFilterParams(), a1)).append(",").append("\"params\":").append(java_util_Map.marshall(a0.getParams(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}