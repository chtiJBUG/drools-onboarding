package org.jboss.errai.marshalling.client.api;

import java.util.Date;
import org.drools.workbench.models.datamodel.auditlog.AuditLogEntry;
import org.drools.workbench.models.guided.dtable.shared.auditlog.DeleteRowAuditLogEntry;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_a_DeleteRowAuditLogEntry_1_Impl implements GeneratedMarshaller<DeleteRowAuditLogEntry> {
  private DeleteRowAuditLogEntry[] EMPTY_ARRAY = new DeleteRowAuditLogEntry[0];
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Date> java_util_Date = Marshalling.getMarshaller(Date.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public DeleteRowAuditLogEntry[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Date _191684281__65575278_dateOfEntry(AuditLogEntry instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::dateOfEntry;
  }-*/;

  private native static void _191684281__65575278_dateOfEntry(AuditLogEntry instance, Date value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::dateOfEntry = value;
  }-*/;

  private native static String _191684281__1195259493_userName(AuditLogEntry instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::userName;
  }-*/;

  private native static void _191684281__1195259493_userName(AuditLogEntry instance, String value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::userName = value;
  }-*/;

  private native static boolean _191684281__64711720_isDeleted(AuditLogEntry instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::isDeleted;
  }-*/;

  private native static void _191684281__64711720_isDeleted(AuditLogEntry instance, boolean value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.AuditLogEntry::isDeleted = value;
  }-*/;

  public DeleteRowAuditLogEntry demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DeleteRowAuditLogEntry.class, objId);
    }
    DeleteRowAuditLogEntry entity = new DeleteRowAuditLogEntry();
    a1.recordObject(objId, entity);
    entity.rowIndex = java_lang_Integer.demarshall(obj.get("rowIndex"), a1);
    if ((obj.containsKey("dateOfEntry")) && (!obj.get("dateOfEntry").isNull())) {
      _191684281__65575278_dateOfEntry(entity, java_util_Date.demarshall(obj.get("dateOfEntry"), a1));
    }
    if ((obj.containsKey("userName")) && (!obj.get("userName").isNull())) {
      _191684281__1195259493_userName(entity, java_lang_String.demarshall(obj.get("userName"), a1));
    }
    if ((obj.containsKey("userComment")) && (!obj.get("userComment").isNull())) {
      entity.setUserComment(java_lang_String.demarshall(obj.get("userComment"), a1));
    }
    if ((obj.containsKey("isDeleted")) && (!obj.get("isDeleted").isNull())) {
      _191684281__64711720_isDeleted(entity, java_lang_Boolean.demarshall(obj.get("isDeleted"), a1));
    }
    return entity;
  }

  public String marshall(DeleteRowAuditLogEntry a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.auditlog.DeleteRowAuditLogEntry\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"rowIndex\":").append(java_lang_Integer.marshall(a0.rowIndex, a1)).append(",").append("\"dateOfEntry\":").append(java_util_Date.marshall(a0.getDateOfEntry(), a1)).append(",").append("\"userName\":").append(java_lang_String.marshall(a0.getUserName(), a1)).append(",").append("\"userComment\":").append(java_lang_String.marshall(a0.getUserComment(), a1)).append(",").append("\"isDeleted\":").append(java_lang_Boolean.marshall(_191684281__64711720_isDeleted(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}