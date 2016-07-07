package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.uberfire.ext.services.shared.preferences.GridGlobalPreferences;

public class Marshaller_o_u_e_s_s_p_GridGlobalPreferences_1_Impl implements GeneratedMarshaller<GridGlobalPreferences> {
  private GridGlobalPreferences[] EMPTY_ARRAY = new GridGlobalPreferences[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public GridGlobalPreferences[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$1440754209__1195259493_key(GridGlobalPreferences instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::key;
  }-*/;

  private native static void _$1440754209__1195259493_key(GridGlobalPreferences instance, String value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::key = value;
  }-*/;

  private native static List _$1440754209__65821278_initialColumns(GridGlobalPreferences instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::initialColumns;
  }-*/;

  private native static void _$1440754209__65821278_initialColumns(GridGlobalPreferences instance, List<String> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::initialColumns = value;
  }-*/;

  private native static List _$1440754209__65821278_bannedColumns(GridGlobalPreferences instance) /*-{
    return instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::bannedColumns;
  }-*/;

  private native static void _$1440754209__65821278_bannedColumns(GridGlobalPreferences instance, List<String> value) /*-{
    instance.@org.uberfire.ext.services.shared.preferences.GridGlobalPreferences::bannedColumns = value;
  }-*/;

  public GridGlobalPreferences demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GridGlobalPreferences.class, objId);
    }
    GridGlobalPreferences entity = new GridGlobalPreferences();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("key")) && (!obj.get("key").isNull())) {
      _$1440754209__1195259493_key(entity, java_lang_String.demarshall(obj.get("key"), a1));
    }
    if ((obj.containsKey("initialColumns")) && (!obj.get("initialColumns").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1440754209__65821278_initialColumns(entity, java_util_List.demarshall(obj.get("initialColumns"), a1));
    }
    if ((obj.containsKey("bannedColumns")) && (!obj.get("bannedColumns").isNull())) {
      a1.setAssumedElementType("java.lang.String");
      _$1440754209__65821278_bannedColumns(entity, java_util_List.demarshall(obj.get("bannedColumns"), a1));
    }
    if ((obj.containsKey("pageSize")) && (!obj.get("pageSize").isNull())) {
      entity.setPageSize(java_lang_Integer.demarshall(obj.get("pageSize"), a1));
    }
    return entity;
  }

  public String marshall(GridGlobalPreferences a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.services.shared.preferences.GridGlobalPreferences\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"key\":").append(java_lang_String.marshall(a0.getKey(), a1)).append(",").append("\"initialColumns\":").append(java_util_List.marshall(a0.getInitialColumns(), a1)).append(",").append("\"bannedColumns\":").append(java_util_List.marshall(a0.getBannedColumns(), a1)).append(",").append("\"pageSize\":").append(java_lang_Integer.marshall(a0.getPageSize(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}