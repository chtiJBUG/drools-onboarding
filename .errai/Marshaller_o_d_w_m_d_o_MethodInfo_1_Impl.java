package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.datamodel.oracle.MethodInfo;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_MethodInfo_1_Impl implements GeneratedMarshaller<MethodInfo> {
  private MethodInfo[] EMPTY_ARRAY = new MethodInfo[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public MethodInfo[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1930174634__1195259493_name(MethodInfo instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::name;
  }-*/;

  private native static void _1930174634__1195259493_name(MethodInfo instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::name = value;
  }-*/;

  private native static List _1930174634__65821278_params(MethodInfo instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::params;
  }-*/;

  private native static void _1930174634__65821278_params(MethodInfo instance, List<String> value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::params = value;
  }-*/;

  private native static String _1930174634__1195259493_returnClassType(MethodInfo instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::returnClassType;
  }-*/;

  private native static void _1930174634__1195259493_returnClassType(MethodInfo instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::returnClassType = value;
  }-*/;

  private native static String _1930174634__1195259493_parametricReturnType(MethodInfo instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::parametricReturnType;
  }-*/;

  private native static void _1930174634__1195259493_parametricReturnType(MethodInfo instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::parametricReturnType = value;
  }-*/;

  private native static String _1930174634__1195259493_genericType(MethodInfo instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::genericType;
  }-*/;

  private native static void _1930174634__1195259493_genericType(MethodInfo instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.oracle.MethodInfo::genericType = value;
  }-*/;

  public MethodInfo demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(MethodInfo.class, objId);
    }
    MethodInfo entity = new MethodInfo();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _1930174634__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("params")) && (!obj.get("params").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _1930174634__65821278_params(entity, java_util_List.demarshall(obj.get("params"), a1));
    }
    if ((obj.containsKey("returnClassType")) && (!obj.get("returnClassType").isNull())) {
      _1930174634__1195259493_returnClassType(entity, java_lang_String.demarshall(obj.get("returnClassType"), a1));
    }
    if ((obj.containsKey("parametricReturnType")) && (!obj.get("parametricReturnType").isNull())) {
      _1930174634__1195259493_parametricReturnType(entity, java_lang_String.demarshall(obj.get("parametricReturnType"), a1));
    }
    if ((obj.containsKey("genericType")) && (!obj.get("genericType").isNull())) {
      _1930174634__1195259493_genericType(entity, java_lang_String.demarshall(obj.get("genericType"), a1));
    }
    return entity;
  }

  public String marshall(MethodInfo a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.MethodInfo\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"params\":").append(java_util_List.marshall(a0.getParams(), a1)).append(",").append("\"returnClassType\":").append(java_lang_String.marshall(a0.getReturnClassType(), a1)).append(",").append("\"parametricReturnType\":").append(java_lang_String.marshall(a0.getParametricReturnType(), a1)).append(",").append("\"genericType\":").append(java_lang_String.marshall(a0.getGenericType(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}