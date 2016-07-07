package org.jboss.errai.marshalling.client.api;

import java.util.LinkedList;
import org.drools.workbench.models.datamodel.auditlog.AuditLog;
import org.drools.workbench.models.datamodel.auditlog.AuditLogEntry;
import org.drools.workbench.models.datamodel.auditlog.AuditLogFilter;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_a_AuditLog_1_Impl implements GeneratedMarshaller<AuditLog> {
  private AuditLog[] EMPTY_ARRAY = new AuditLog[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<LinkedList> java_util_LinkedList = Marshalling.getMarshaller(LinkedList.class);
  public AuditLog[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static AuditLogFilter _1600951609__1671020049_filter(AuditLog instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.AuditLog::filter;
  }-*/;

  private native static void _1600951609__1671020049_filter(AuditLog instance, AuditLogFilter value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.AuditLog::filter = value;
  }-*/;

  private native static LinkedList _1600951609__$1899270121_entries(AuditLog instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.AuditLog::entries;
  }-*/;

  private native static void _1600951609__$1899270121_entries(AuditLog instance, LinkedList<AuditLogEntry> value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.AuditLog::entries = value;
  }-*/;

  public AuditLog demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(AuditLog.class, objId);
    }
    AuditLog entity = new AuditLog();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("filter")) && (!obj.get("filter").isNull())) {
      _1600951609__1671020049_filter(entity, (AuditLogFilter) ((ObjectMarshaller) java_lang_Object).demarshall(AuditLogFilter.class, obj.get("filter"), a1));
    }
    if ((obj.containsKey("entries")) && (!obj.get("entries").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.auditlog.AuditLogEntry");
      _1600951609__$1899270121_entries(entity, java_util_LinkedList.demarshall(obj.get("entries"), a1));
    }
    return entity;
  }

  public String marshall(AuditLog a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.auditlog.AuditLog\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"filter\":").append(java_lang_Object.marshall(_1600951609__1671020049_filter(a0), a1)).append(",").append("\"entries\":").append(java_util_LinkedList.marshall(_1600951609__$1899270121_entries(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}