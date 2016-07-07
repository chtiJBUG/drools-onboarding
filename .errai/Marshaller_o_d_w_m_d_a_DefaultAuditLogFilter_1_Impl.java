package org.jboss.errai.marshalling.client.api;

import java.util.Map;
import org.drools.workbench.models.datamodel.auditlog.DefaultAuditLogFilter;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_a_DefaultAuditLogFilter_1_Impl implements GeneratedMarshaller<DefaultAuditLogFilter> {
  private DefaultAuditLogFilter[] EMPTY_ARRAY = new DefaultAuditLogFilter[0];
  private Marshaller<Map> java_util_Map = Marshalling.getMarshaller(Map.class);
  public DefaultAuditLogFilter[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Map _$337413870__$1383349348_acceptedTypes(DefaultAuditLogFilter instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.auditlog.DefaultAuditLogFilter::acceptedTypes;
  }-*/;

  private native static void _$337413870__$1383349348_acceptedTypes(DefaultAuditLogFilter instance, Map<String, Boolean> value) /*-{
    instance.@org.drools.workbench.models.datamodel.auditlog.DefaultAuditLogFilter::acceptedTypes = value;
  }-*/;

  public DefaultAuditLogFilter demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(DefaultAuditLogFilter.class, objId);
    }
    DefaultAuditLogFilter entity = new DefaultAuditLogFilter();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("acceptedTypes")) && (!obj.get("acceptedTypes").isNull())) {
      a1.setAssumedMapKeyType("java.lang.String");
      a1.setAssumedMapValueType("java.lang.Boolean");
      _$337413870__$1383349348_acceptedTypes(entity, java_util_Map.demarshall(obj.get("acceptedTypes"), a1));
      a1.resetAssumedTypes();
    }
    return entity;
  }

  public String marshall(DefaultAuditLogFilter a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.auditlog.DefaultAuditLogFilter\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"acceptedTypes\":").append(java_util_Map.marshall(a0.getAcceptedTypes(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}